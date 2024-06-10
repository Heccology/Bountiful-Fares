package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.util.BFBlockTags;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PalmSaplingBlock extends SaplingBlock {
    public PalmSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(4, 0, 4, 12, 4, 12);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BFBlockTags.PALM_SAPLINGS_PLANTABLE_ON) || floor.isOf(Blocks.FARMLAND);
    }
}
