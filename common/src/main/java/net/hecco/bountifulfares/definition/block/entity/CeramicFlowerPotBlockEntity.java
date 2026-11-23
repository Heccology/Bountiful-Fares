package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CeramicFlowerPotBlockEntity extends DyeableBlockEntity {
    private ItemStack plant = ItemStack.EMPTY;

    public CeramicFlowerPotBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.CERAMIC_FLOWER_POT_BLOCK_ENTITY.get(), pos, state);
    }

    public ItemStack getPlant() {
        return plant;
    }

    public void setPlant(ItemStack stack) {
        this.plant = stack;
        this.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (!this.plant.isEmpty()) {
            tag.put("plant", this.plant.save(registries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("plant")) {
            this.plant = ItemStack.parse(registries, tag.getCompound("plant")).orElse(ItemStack.EMPTY);
        }
    }

    public static int getColor(BlockGetter world, BlockPos pos){
        if(world==null){
            return CeramicFlowerPotBlockEntity.DEFAULT_COLOR;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof CeramicFlowerPotBlockEntity ceramicFlowerPotBlockEntity){
            return ceramicFlowerPotBlockEntity.color;
        } else {
            return CeramicFlowerPotBlockEntity.DEFAULT_COLOR;
        }
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        if (!this.plant.isEmpty()) {
            tag.put("plant", this.plant.save(registries));
        }
        return tag;
    }
}
