package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.definition.block.custom.DyeableCeramicBlock;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
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
import net.minecraft.util.FastColor;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CeramicChestBlockEntity extends ChestBlockEntity {

    public static final int DEFAULT_COLOR = FastColor.ARGB32.opaque(16777215);
    public int color = DEFAULT_COLOR;

    public CeramicChestBlockEntity(BlockPos pos, BlockState blockState) {
        super(BFBlockEntities.CERAMIC_CHEST_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.bountifulfares.ceramic_chest");
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
