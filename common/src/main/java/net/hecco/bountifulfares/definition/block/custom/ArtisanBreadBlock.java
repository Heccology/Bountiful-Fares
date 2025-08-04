package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ArtisanBreadBlock extends SixSlicePastry{

    public static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Block.box(3, 0, 1, 13, 7, 15),
            Block.box(3, 0, 3, 13, 7, 15),
            Block.box(3, 0, 5, 13, 7, 15),
            Block.box(3, 0, 7, 13, 7, 15),
            Block.box(3, 0, 9, 13, 7, 15),
            Block.box(3, 0, 11, 13, 7, 15),
            Block.box(3, 0, 13, 13, 7, 15)
    };
    public static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Block.box(1, 0, 3, 15, 7, 13),
            Block.box(1, 0, 3, 13, 7, 13),
            Block.box(1, 0, 3, 11, 7, 13),
            Block.box(1, 0, 3, 9, 7, 13),
            Block.box(1, 0, 3, 7, 7, 13),
            Block.box(1, 0, 3, 5, 7, 13),
            Block.box(1, 0, 3, 3, 7, 13)
    };
    public static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Block.box(3, 0, 1, 13, 7, 15),
            Block.box(3, 0, 1, 13, 7, 13),
            Block.box(3, 0, 1, 13, 7, 11),
            Block.box(3, 0, 1, 13, 7, 9),
            Block.box(3, 0, 1, 13, 7, 7),
            Block.box(3, 0, 1, 13, 7, 5),
            Block.box(3, 0, 1, 13, 7, 3)
    };
    public static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Block.box(1, 0, 3, 15, 7, 13),
            Block.box(3, 0, 3, 15, 7, 13),
            Block.box(5, 0, 3, 15, 7, 13),
            Block.box(7, 0, 3, 15, 7, 13),
            Block.box(9, 0, 3, 15, 7, 13),
            Block.box(11, 0, 3, 15, 7, 13),
            Block.box(13, 0, 3, 15, 7, 13)
    };
    public ArtisanBreadBlock(Properties settings) {
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
