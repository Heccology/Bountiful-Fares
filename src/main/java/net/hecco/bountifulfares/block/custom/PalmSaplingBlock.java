package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.util.BFBlockTags;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class PalmSaplingBlock extends SaplingBlock {
    public PalmSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(4, 0, 4, 12, 4, 12);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (this.canPlantOnTop(world.getBlockState(pos.down()), world, pos)) {
            BlockPos blockPos = pos.down();
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < 17; i++) {
                    for (int j = 0; j < 17; j++) {
                        if (world.getBlockState(blockPos.add(i - 8, -k, j - 8)).isOf(Blocks.WATER)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BFBlockTags.PALM_SAPLINGS_PLANTABLE_ON) || floor.isOf(Blocks.FARMLAND);
    }
}
