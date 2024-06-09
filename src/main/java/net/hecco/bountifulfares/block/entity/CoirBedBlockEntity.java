package net.hecco.bountifulfares.block.entity;

import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;

public class CoirBedBlockEntity extends BlockEntity {
    private DyeColor color;

    public CoirBedBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.COIR_BED_BLOCK_ENTITY, pos, state);
        this.color = ((BedBlock)state.getBlock()).getColor();
    }

    public CoirBedBlockEntity(BlockPos $$0, BlockState $$1, DyeColor $$2) {
        super(BFBlockEntities.COIR_BED_BLOCK_ENTITY, $$0, $$1);
        this.color = $$2;
    }

    public BlockEntityUpdateS2CPacket getUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public DyeColor getColor() {
        return this.color;
    }

    public void setColor(DyeColor $$0) {
        this.color = $$0;
    }
}
