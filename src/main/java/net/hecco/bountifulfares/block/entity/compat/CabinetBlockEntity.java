package net.hecco.bountifulfares.block.entity.compat;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.farmersdelight.CabinetBlock;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.tick.OrderedTick;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CabinetBlockEntity extends LootableContainerBlockEntity
{
    private static final int MAX_INVENTORY_SIZE = 27;

    private final ViewerCountManager viewerManager;
    private DefaultedList<ItemStack> content;

    public CabinetBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(BFBlockEntities.CABINET_BLOCK_ENTITY, blockPos, blockState);
    }

    private CabinetBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
        this.content = DefaultedList.ofSize(MAX_INVENTORY_SIZE, ItemStack.EMPTY);
        this.viewerManager = new ViewerCountManager() {
            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
                SoundEvent lazy_open = Registries.SOUND_EVENT.get(Identifier.of(BountifulFares.FARMERS_DELIGHT_MOD_ID, "block.cabinet.open"));
                CabinetBlockEntity.this.playSound(state, (lazy_open != null) ? lazy_open : BFSounds.CABINET_OPEN);
                CabinetBlockEntity.this.setOpen(state, true);
            }

            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
                SoundEvent lazy_close = Registries.SOUND_EVENT.get(Identifier.of(BountifulFares.FARMERS_DELIGHT_MOD_ID, "block.cabinet.close"));
                CabinetBlockEntity.this.playSound(state, (lazy_close != null) ? lazy_close : BFSounds.CABINET_CLOSE);
                CabinetBlockEntity.this.setOpen(state, false);
            }

            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
                // Nothing to do when viewer count is updated
            }

            @Override
            protected boolean isPlayerViewing(PlayerEntity player) {
                if (player.currentScreenHandler instanceof GenericContainerScreenHandler genericContainerScreenHandler) {
                    Inventory inventory = genericContainerScreenHandler.getInventory();
                    return inventory == CabinetBlockEntity.this;
                } else {
                    return false;
                }
            }

        };
    }

    @Override
    protected Text getContainerName() {
        return net.minecraft.text.Text.translatable("farmersdelight.container.cabinet");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }

    @Override
    protected DefaultedList<ItemStack> getHeldStacks() {
        return content;
    }

    @Override
    protected void setHeldStacks(DefaultedList<ItemStack> list) {
        content = list;
    }

    @Override
    public int size() {
        return MAX_INVENTORY_SIZE;
    }

    @Override
    public void onOpen(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.viewerManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    @Override
    public void onClose(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.viewerManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    public void recheckOpen() {
        if (world != null && !this.removed) {
            this.viewerManager.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    @Override
    public void writeNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(tag, registryLookup);
        if (!writeLootTable(tag)) {
            Inventories.writeNbt(tag, content, registryLookup);
        }
    }

    @Override
    public void readNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(tag, registryLookup);
        content = DefaultedList.ofSize(size(), ItemStack.EMPTY);
        if (!readLootTable(tag)) {
            Inventories.readNbt(tag, content, registryLookup);
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound nbtCompound = new NbtCompound();
        Inventories.writeNbt(nbtCompound, content, registryLookup);

        return nbtCompound;
    }

    public void tick() {
        if (!this.removed) {
            this.viewerManager.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
        }

        if (this.viewerManager.getViewerCount() > 0) {
            scheduleTick();
        } else {
            BlockState blockstate = getCachedState();
            if (!(blockstate.getBlock() instanceof CabinetBlock)) {
                markRemoved();
                return;
            }

            boolean flag = blockstate.get(CabinetBlock.OPEN);
            if (flag) {
                playSound(blockstate, BFSounds.CABINET_CLOSE);
                setOpen(blockstate, false);
            }
        }
    }

    private void scheduleTick() {
        Objects.requireNonNull(getWorld()).getBlockTickScheduler().scheduleTick(OrderedTick.create(getCachedState().getBlock(), getPos()));
    }

    private void setOpen(BlockState state, boolean open) {
        Objects.requireNonNull(getWorld()).setBlockState(getPos(), state.with(CabinetBlock.OPEN, open));
    }

    private void playSound(BlockState state, SoundEvent sound) {
        Vec3i vec3i = state.get(CabinetBlock.FACING).getVector();
        BlockPos pos = getPos();
        double dX = pos.getX() + .5d + vec3i.getX() / 2.d;
        double dT = pos.getY() + .5d + vec3i.getY() / 2.d;
        double dZ = pos.getZ() + .5d + vec3i.getZ() / 2.d;
        World world = Objects.requireNonNull(getWorld());
        world.playSound(null, dX, dT, dZ, sound, SoundCategory.BLOCKS, .5f, world.getRandom().nextFloat() * .1f + .9f);
    }
}
