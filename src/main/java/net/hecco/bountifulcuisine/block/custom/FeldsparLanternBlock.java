package net.hecco.bountifulcuisine.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class FeldsparLanternBlock extends LanternBlock {
    public FeldsparLanternBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(Block.createCuboidShape(5, 1, 5, 11, 9, 11), Block.createCuboidShape(4, 0, 4, 12, 1, 12), Block.createCuboidShape(4, 9, 4, 12, 10, 12), Block.createCuboidShape(6, 10, 6, 10, 13, 10));
    }
}
