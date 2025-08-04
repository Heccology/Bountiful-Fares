package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TartBlock extends QuarterPastryBlock{

    public static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Block.box(1, 0, 1, 15, 4, 15),
            Shapes.join(Block.box(1, 0, 8, 15, 4, 15), Block.box(8, 0, 1, 15, 4, 8), BooleanOp.OR),
            Block.box(1, 0, 8, 15, 4, 15),
            Block.box(1, 0, 8, 8, 4, 15)
    };
    public static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Block.box(1, 0, 1, 15, 4, 15),
            Shapes.join(Block.box(8, 0, 8, 15, 4, 15), Block.box(1, 0, 1, 8, 4, 15), BooleanOp.OR),
            Block.box(1, 0, 1, 8, 4, 15),
            Block.box(1, 0, 1, 8, 4, 8)
    };
    public static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Block.box(1, 0, 1, 15, 4, 15),
            Shapes.join(Block.box(1, 0, 8, 8, 4, 15), Block.box(1, 0, 1, 15, 4, 8), BooleanOp.OR),
            Block.box(1, 0, 1, 15, 4, 8),
            Block.box(8, 0, 1, 15, 4, 8)
    };
    public static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Block.box(1, 0, 1, 15, 4, 15),
            Shapes.join(Block.box(1, 0, 1, 8, 4, 8), Block.box(8, 0, 1, 15, 4, 15), BooleanOp.OR),
            Block.box(8, 0, 1, 15, 4, 15),
            Block.box(8, 0, 8, 15, 4, 15)
    };
    public TartBlock(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(FACING) == Direction.NORTH) {
            return NORTH_SHAPES[state.getValue(BITES)];
        } else if (state.getValue(FACING) == Direction.EAST) {
            return EAST_SHAPES[state.getValue(BITES)];
        } else if (state.getValue(FACING) == Direction.SOUTH) {
            return SOUTH_SHAPES[state.getValue(BITES)];
        } else if (state.getValue(FACING) == Direction.WEST) {
            return WEST_SHAPES[state.getValue(BITES)];
        }
        return NORTH_SHAPES[state.getValue(BITES)];
    }
}
