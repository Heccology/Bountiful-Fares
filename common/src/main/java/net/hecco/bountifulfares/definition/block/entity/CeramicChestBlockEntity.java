package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.definition.block.custom.DyeableCeramicBlock;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.FastColor;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.jetbrains.annotations.Nullable;

public class CeramicChestBlockEntity extends ChestBlockEntity {

    public static final int DEFAULT_COLOR = FastColor.ARGB32.opaque(16777215);
    public int color = DEFAULT_COLOR;

    public final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level p_155357_, BlockPos p_155358_, BlockState p_155359_) {
            CeramicChestBlockEntity.playSound(p_155357_, p_155358_, p_155359_, BFSounds.CERAMIC_CHEST_OPEN.get());
        }

        @Override
        protected void onClose(Level p_155367_, BlockPos p_155368_, BlockState p_155369_) {
            CeramicChestBlockEntity.playSound(p_155367_, p_155368_, p_155369_, BFSounds.CERAMIC_CHEST_CLOSE.get());
        }

        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int i, int i1) {
            Block block = state.getBlock();
            level.blockEvent(pos, block, 1, i1);
        }

        @Override
        protected boolean isOwnContainer(Player p_155355_) {
            if (!(p_155355_.containerMenu instanceof ChestMenu)) {
                return false;
            } else {
                Container container = ((ChestMenu)p_155355_.containerMenu).getContainer();
                return container == CeramicChestBlockEntity.this
                        || container instanceof CompoundContainer && ((CompoundContainer)container).contains(CeramicChestBlockEntity.this);
            }
        }
    };

    public CeramicChestBlockEntity(BlockPos pos, BlockState blockState) {
        super(BFBlockEntities.CERAMIC_CHEST_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.bountifulfares.ceramic_chest");
    }

    static void playSound(Level level, BlockPos pos, BlockState state, SoundEvent sound) {
        ChestType chesttype = state.getValue(ChestBlock.TYPE);
        if (chesttype != ChestType.LEFT) {
            double d0 = (double)pos.getX() + 0.5;
            double d1 = (double)pos.getY() + 0.5;
            double d2 = (double)pos.getZ() + 0.5;
            if (chesttype == ChestType.RIGHT) {
                Direction direction = ChestBlock.getConnectedDirection(state);
                d0 += (double)direction.getStepX() * 0.5;
                d2 += (double)direction.getStepZ() * 0.5;
            }

            level.playSound(null, d0, d1, d2, sound, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
        }
    }


    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        super.saveAdditional(nbt, registryLookup);
        if (color != DEFAULT_COLOR) {
            nbt.putInt("color", color);
        }
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder componentMapBuilder) {
        if (color != DEFAULT_COLOR) {
            componentMapBuilder.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
        }
        super.collectImplicitComponents(componentMapBuilder);
    }

    @Override
    protected void applyImplicitComponents(DataComponentInput components) {
        if (components.get(DataComponents.DYED_COLOR) == null) {
            color = DEFAULT_COLOR;
        } else {
            color = components.get(DataComponents.DYED_COLOR).rgb();
        }
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        super.loadAdditional(nbt, registryLookup);
        if (!nbt.contains("color", Tag.TAG_INT) || nbt.getInt("color") == 0) {
            color = DEFAULT_COLOR;
        } else {
            color = nbt.getInt("color");
        }
    }

    @Override
    public void setChanged()
    {
        if (
                this.getLevel() != null &&
                        !this.getLevel().isClientSide &&
                        this.getBlockPos() != null
        )
        {
            Level thisworld = this.getLevel();
            DyeableCeramicBlock.sendColorPayload(
                    (ServerLevel) thisworld, thisworld.getBlockEntity(this.getBlockPos()), this.color);
        }
        super.setChanged();
    }

    @Override
    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registryLookup) {
        return saveWithoutMetadata(registryLookup);
    }
}
