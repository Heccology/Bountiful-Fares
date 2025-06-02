package net.hecco.bountifulfares.block.entity.compat;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.farmersdelight.CabinetBlock;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.ticks.ScheduledTick;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CabinetBlockEntity extends RandomizableContainerBlockEntity
{
    private static final int MAX_INVENTORY_SIZE = 27;

    private final ContainerOpenersCounter viewerManager;
    private NonNullList<ItemStack> content;

    public CabinetBlockEntity(BlockPos blockPos, BlockState blockState) {
        this(BFBlockEntities.CABINET_BLOCK_ENTITY, blockPos, blockState);
    }

    private CabinetBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
        this.content = NonNullList.withSize(MAX_INVENTORY_SIZE, ItemStack.EMPTY);
        this.viewerManager = new ContainerOpenersCounter() {
            protected void onOpen(Level world, BlockPos pos, BlockState state) {
                SoundEvent lazy_open = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.FARMERS_DELIGHT_MOD_ID, "block.cabinet.open"));
                CabinetBlockEntity.this.playSound(state, (lazy_open != null) ? lazy_open : BFSounds.CABINET_OPEN);
                CabinetBlockEntity.this.setOpen(state, true);
            }

            protected void onClose(Level world, BlockPos pos, BlockState state) {
                SoundEvent lazy_close = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.FARMERS_DELIGHT_MOD_ID, "block.cabinet.close"));
                CabinetBlockEntity.this.playSound(state, (lazy_close != null) ? lazy_close : BFSounds.CABINET_CLOSE);
                CabinetBlockEntity.this.setOpen(state, false);
            }

            protected void openerCountChanged(Level world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
                // Nothing to do when viewer count is updated
            }

            @Override
            protected boolean isOwnContainer(Player player) {
                if (player.containerMenu instanceof ChestMenu genericContainerScreenHandler) {
                    Container inventory = genericContainerScreenHandler.getContainer();
                    return inventory == CabinetBlockEntity.this;
                } else {
                    return false;
                }
            }

        };
    }

    @Override
    protected Component getDefaultName() {
        return net.minecraft.network.chat.Component.translatable("farmersdelight.container.cabinet");
    }

    @Override
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return ChestMenu.threeRows(syncId, playerInventory, this);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return content;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> list) {
        content = list;
    }

    @Override
    public int getContainerSize() {
        return MAX_INVENTORY_SIZE;
    }

    @Override
    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.viewerManager.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.viewerManager.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    public void recheckOpen() {
        if (level != null && !this.remove) {
            this.viewerManager.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registryLookup) {
        super.saveAdditional(tag, registryLookup);
        if (!trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, content, registryLookup);
        }
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registryLookup) {
        super.loadAdditional(tag, registryLookup);
        content = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if (!tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, content, registryLookup);
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registryLookup) {
        CompoundTag nbtCompound = new CompoundTag();
        ContainerHelper.saveAllItems(nbtCompound, content, registryLookup);

        return nbtCompound;
    }

    public void tick() {
        if (!this.remove) {
            this.viewerManager.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

        if (this.viewerManager.getOpenerCount() > 0) {
            scheduleTick();
        } else {
            BlockState blockstate = getBlockState();
            if (!(blockstate.getBlock() instanceof CabinetBlock)) {
                setRemoved();
                return;
            }

            boolean flag = blockstate.getValue(CabinetBlock.OPEN);
            if (flag) {
                playSound(blockstate, BFSounds.CABINET_CLOSE);
                setOpen(blockstate, false);
            }
        }
    }

    private void scheduleTick() {
        Objects.requireNonNull(getLevel()).getBlockTicks().schedule(ScheduledTick.probe(getBlockState().getBlock(), getBlockPos()));
    }

    private void setOpen(BlockState state, boolean open) {
        Objects.requireNonNull(getLevel()).setBlockAndUpdate(getBlockPos(), state.setValue(CabinetBlock.OPEN, open));
    }

    private void playSound(BlockState state, SoundEvent sound) {
        Vec3i vec3i = state.getValue(CabinetBlock.FACING).getNormal();
        BlockPos pos = getBlockPos();
        double dX = pos.getX() + .5d + vec3i.getX() / 2.d;
        double dT = pos.getY() + .5d + vec3i.getY() / 2.d;
        double dZ = pos.getZ() + .5d + vec3i.getZ() / 2.d;
        Level world = Objects.requireNonNull(getLevel());
        world.playSound(null, dX, dT, dZ, sound, SoundSource.BLOCKS, .5f, world.getRandom().nextFloat() * .1f + .9f);
    }
}
