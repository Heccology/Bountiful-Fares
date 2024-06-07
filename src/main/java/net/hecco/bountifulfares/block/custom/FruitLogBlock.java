package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.BFBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public abstract class FruitLogBlock extends PillarBlock implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape Y_SHAPE = Block.createCuboidShape(4, 0, 4, 12, 16, 12);
    protected static final VoxelShape Z_SHAPE = Block.createCuboidShape(4, 4, 0, 12, 12, 16);
    protected static final VoxelShape X_SHAPE = Block.createCuboidShape(0, 4, 4, 16, 12, 12);
    public static final BooleanProperty LEAFY = BooleanProperty.of("leafy");
    public FruitLogBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(AXIS, Direction.Axis.Y).with(LEAFY, false));
    }



    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(LEAFY)) {
            return VoxelShapes.fullCube();
        }
        switch (state.get(AXIS)) {
            default: {
                return X_SHAPE;
            }
            case Z: {
                return Z_SHAPE;
            }
            case Y:
        }
        return Y_SHAPE;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {

        return super.getPlacementState(ctx)
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
                .with(LEAFY, shouldBeLeafy(ctx.getWorld(), ctx.getBlockPos(), super.getDefaultState()));
    }

//    @Override
//    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
//        super.onBlockAdded(state, world, pos, oldState, notify);
//
//        if (!world.isClient) {
//            boolean shouldBeLeafy = shouldBeLeafy(world, pos, state);
//            if (shouldBeLeafy != state.get(LEAFY)) {
//                world.setBlockState(pos, state.with(LEAFY, shouldBeLeafy), 2);
//            }
//        }
//    }




    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        if (shouldBeLeafy(world, pos, state)) {
            if (!state.get(LEAFY)) {
                world.setBlockState(pos, state.with(LEAFY, true), 2);
            }
        } else if (state.get(LEAFY)) {
            world.setBlockState(pos, state.with(LEAFY, false), 2);
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }


    protected boolean shouldBeLeafy(WorldView world, BlockPos pos, BlockState blockState) {
        Direction.Axis axis = blockState.get(AppleLogBlock.AXIS);
        Direction[] directions;
        if (axis == Direction.Axis.X) {
            directions = new Direction[]{Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH};
        } else if (axis == Direction.Axis.Z) {
            directions = new Direction[]{Direction.UP, Direction.DOWN, Direction.WEST, Direction.EAST};
        } else {
            directions = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
        }

        for (Direction direction : directions) {
            BlockState neighborState = world.getBlockState(pos.offset(direction));
            if (neighborState.getBlock() != getLeavesBlock() && neighborState.getBlock() != getFloweringLeavesBlock()) {
                return false;
            }
        }

        return true;
    }

    public Block getLeavesBlock() {
        return Blocks.OAK_LEAVES;
    }

    public Block getFloweringLeavesBlock() {
        return Blocks.OAK_LEAVES;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS, LEAFY);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
