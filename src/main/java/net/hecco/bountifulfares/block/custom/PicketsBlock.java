package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.ArrayList;
import java.util.List;

public class PicketsBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty NORTH = BooleanProperty.of("north");
    public static final BooleanProperty EAST = BooleanProperty.of("east");
    public static final BooleanProperty SOUTH = BooleanProperty.of("south");
    public static final BooleanProperty WEST = BooleanProperty.of("west");
    public static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0, 0, 14, 16, 8, 16);
    public static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0, 0, 0, 2, 8, 16);
    public static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 8, 2);
    public static final VoxelShape WEST_SHAPE = Block.createCuboidShape(14, 0, 0, 16, 8, 16);
    public static final VoxelShape NORTH_COLL = Block.createCuboidShape(0, 0, 14, 16, 10, 16);
    public static final VoxelShape EAST_COLL = Block.createCuboidShape(0, 0, 0, 2, 10, 16);
    public static final VoxelShape SOUTH_COLL = Block.createCuboidShape(0, 0, 0, 16, 10, 2);
    public static final VoxelShape WEST_COLL = Block.createCuboidShape(14, 0, 0, 16, 10, 16);
    public PicketsBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, false).with(EAST, false).with(SOUTH, false).with(WEST, false).with(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        List<VoxelShape> SHAPES = new ArrayList<>();

        if (state.get(NORTH)) SHAPES.add(NORTH_SHAPE);
        if (state.get(EAST)) SHAPES.add(EAST_SHAPE);
        if (state.get(SOUTH)) SHAPES.add(SOUTH_SHAPE);
        if (state.get(WEST)) SHAPES.add(WEST_SHAPE);

        if (!SHAPES.isEmpty()) {
            VoxelShape result = SHAPES.get(0);
            for (int i = 1; i < SHAPES.size(); i++) {
                result = VoxelShapes.union(result, SHAPES.get(i));
            }
            return result;
        }

        return super.getOutlineShape(state, world, pos, context);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        List<VoxelShape> COLLISION = new ArrayList<>();

        if (state.get(NORTH)) COLLISION.add(NORTH_COLL);
        if (state.get(EAST)) COLLISION.add(EAST_COLL);
        if (state.get(SOUTH)) COLLISION.add(SOUTH_COLL);
        if (state.get(WEST)) COLLISION.add(WEST_COLL);

        if (!COLLISION.isEmpty()) {
            VoxelShape result = COLLISION.get(0);
            for (int i = 1; i < COLLISION.size(); i++) {
                result = VoxelShapes.union(result, COLLISION.get(i));
            }
            return result;
        }

        return super.getCollisionShape(state, world, pos, context);
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction playerDir = ctx.getHorizontalPlayerFacing().getOpposite();
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());

        if (blockState.isOf(this)) {
            Direction facingDirection = getFacingDirection(blockState);

            if (facingDirection != playerDir) {
                return super.getStateWithProperties(blockState).with(getFacingProperty(playerDir), true);
            }
        } else {
            return super.getDefaultState().with(getFacingProperty(playerDir), true).with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
        }

        return super.getPlacementState(ctx).with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        if (context.getPlayer() != null) {
            Direction playerDir = context.getHorizontalPlayerFacing().getOpposite();
            Direction facingDirection = getFacingDirection(state);
            return !context.shouldCancelInteraction() && context.getStack().getItem() == this.asItem() && facingDirection != playerDir || super.canReplace(state, context);
        } else {
            return true;
        }
    }

    private Direction getFacingDirection(BlockState blockState) {
        if (blockState.get(NORTH)) return Direction.NORTH;
        if (blockState.get(EAST)) return Direction.EAST;
        if (blockState.get(SOUTH)) return Direction.SOUTH;
        if (blockState.get(WEST)) return Direction.WEST;
        return Direction.NORTH; // Default direction if none is set
    }

    private Property<Boolean> getFacingProperty(Direction direction) {
        switch (direction) {
            case NORTH:
                return NORTH;
            case EAST:
                return EAST;
            case SOUTH:
                return SOUTH;
            case WEST:
                return WEST;
            default:
                return NORTH;
        }
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return switch (rotation) {
            case CLOCKWISE_180 -> (((state.with(NORTH, state.get(SOUTH))).with(EAST, state.get(WEST))).with(SOUTH, state.get(NORTH))).with(WEST, state.get(EAST));
            case COUNTERCLOCKWISE_90 -> (((state.with(NORTH, state.get(EAST))).with(EAST, state.get(SOUTH))).with(SOUTH, state.get(WEST))).with(WEST, state.get(NORTH));
            case CLOCKWISE_90 -> (((state.with(NORTH, state.get(WEST))).with(EAST, state.get(NORTH))).with(SOUTH, state.get(EAST))).with(WEST, state.get(SOUTH));
            default -> state;
        };
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return switch (mirror) {
            case LEFT_RIGHT -> (state.with(NORTH, state.get(SOUTH))).with(SOUTH, state.get(NORTH));
            case FRONT_BACK -> (state.with(EAST, state.get(WEST))).with(WEST, state.get(EAST));
            default -> super.mirror(state, mirror);
        };
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
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
