package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;

public class CoirBedBlock extends BedBlock {
    public CoirBedBlock(DyeColor color, Settings settings) {
        super(color, settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return super.createBlockEntity(pos, state);
    }
}
