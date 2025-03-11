package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ArtisanBreadBlock extends SixSlicePastry{

    public static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(3, 0, 1, 13, 7, 15),
            Block.createCuboidShape(3, 0, 3, 13, 7, 15),
            Block.createCuboidShape(3, 0, 5, 13, 7, 15),
            Block.createCuboidShape(3, 0, 7, 13, 7, 15),
            Block.createCuboidShape(3, 0, 9, 13, 7, 15),
            Block.createCuboidShape(3, 0, 11, 13, 7, 15),
            Block.createCuboidShape(3, 0, 13, 13, 7, 15)
    };
    public static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(1, 0, 3, 15, 7, 13),
            Block.createCuboidShape(1, 0, 3, 13, 7, 13),
            Block.createCuboidShape(1, 0, 3, 11, 7, 13),
            Block.createCuboidShape(1, 0, 3, 9, 7, 13),
            Block.createCuboidShape(1, 0, 3, 7, 7, 13),
            Block.createCuboidShape(1, 0, 3, 5, 7, 13),
            Block.createCuboidShape(1, 0, 3, 3, 7, 13)
    };
    public static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(3, 0, 1, 13, 7, 15),
            Block.createCuboidShape(3, 0, 1, 13, 7, 13),
            Block.createCuboidShape(3, 0, 1, 13, 7, 11),
            Block.createCuboidShape(3, 0, 1, 13, 7, 9),
            Block.createCuboidShape(3, 0, 1, 13, 7, 7),
            Block.createCuboidShape(3, 0, 1, 13, 7, 5),
            Block.createCuboidShape(3, 0, 1, 13, 7, 3)
    };
    public static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(1, 0, 3, 15, 7, 13),
            Block.createCuboidShape(3, 0, 3, 15, 7, 13),
            Block.createCuboidShape(5, 0, 3, 15, 7, 13),
            Block.createCuboidShape(7, 0, 3, 15, 7, 13),
            Block.createCuboidShape(9, 0, 3, 15, 7, 13),
            Block.createCuboidShape(11, 0, 3, 15, 7, 13),
            Block.createCuboidShape(13, 0, 3, 15, 7, 13)
    };
    public ArtisanBreadBlock(Settings settings) {
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
