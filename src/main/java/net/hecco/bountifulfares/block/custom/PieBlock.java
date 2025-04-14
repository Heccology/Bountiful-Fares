package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class PieBlock extends QuarterPastryBlock {

    public static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(1, 0, 1, 15, 6, 15),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(1, 0, 8, 15, 6, 15), Block.createCuboidShape(8, 0, 1, 15, 6, 8), BooleanBiFunction.OR),
            Block.createCuboidShape(1, 0, 8, 15, 6, 15),
            Block.createCuboidShape(1, 0, 8, 8, 6, 15)
    };
    public static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(1, 0, 1, 15, 6, 15),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 8, 15, 6, 15), Block.createCuboidShape(1, 0, 1, 8, 6, 15), BooleanBiFunction.OR),
            Block.createCuboidShape(1, 0, 1, 8, 6, 15),
            Block.createCuboidShape(1, 0, 1, 8, 6, 8)
    };
    public static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(1, 0, 1, 15, 6, 15),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(1, 0, 8, 8, 6, 15), Block.createCuboidShape(1, 0, 1, 15, 6, 8), BooleanBiFunction.OR),
            Block.createCuboidShape(1, 0, 1, 15, 6, 8),
            Block.createCuboidShape(8, 0, 1, 15, 6, 8)
    };
    public static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(1, 0, 1, 15, 6, 15),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(1, 0, 1, 8, 6, 8), Block.createCuboidShape(8, 0, 1, 15, 6, 15), BooleanBiFunction.OR),
            Block.createCuboidShape(8, 0, 1, 15, 6, 15),
            Block.createCuboidShape(8, 0, 8, 15, 6, 15)
    };
    public PieBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(FACING) == Direction.NORTH) {
            return NORTH_SHAPES[state.get(BITES)];
        } else if (state.get(FACING) == Direction.EAST) {
            return EAST_SHAPES[state.get(BITES)];
        } else if (state.get(FACING) == Direction.SOUTH) {
            return SOUTH_SHAPES[state.get(BITES)];
        } else if (state.get(FACING) == Direction.WEST) {
            return WEST_SHAPES[state.get(BITES)];
        }
        return NORTH_SHAPES[state.get(BITES)];
    }
}
