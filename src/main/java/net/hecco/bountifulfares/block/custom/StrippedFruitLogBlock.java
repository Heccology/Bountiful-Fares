package net.hecco.bountifulfares.block.custom;

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
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrippedFruitLogBlock extends PillarBlock implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape BASE_SHAPE = Block.createCuboidShape(4, 4, 4, 12, 12, 12);
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4, 4, 0, 12, 12, 4);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(12, 4, 4, 16, 12, 12);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(4, 4, 12, 12, 12, 16);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0, 4, 4, 4, 12, 12);
    protected static final VoxelShape UP_SHAPE = Block.createCuboidShape(4, 12, 4, 12, 16, 12);
    protected static final VoxelShape DOWN_SHAPE = Block.createCuboidShape(4, 0, 4, 12, 4, 12);

    public static final BooleanProperty NORTH = Properties.NORTH;
    public static final BooleanProperty EAST = Properties.EAST;
    public static final BooleanProperty SOUTH = Properties.SOUTH;
    public static final BooleanProperty WEST = Properties.WEST;
    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty DOWN = Properties.DOWN;
    public static Map<Direction, BooleanProperty> DIRECTION_TO_PROPERTY = new HashMap<>();
    public static Map<Direction, VoxelShape> DIRECTION_TO_SHAPE = new HashMap<>();

    public StrippedFruitLogBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(AXIS, Direction.Axis.Y).with(NORTH, false).with(EAST, false).with(SOUTH, false).with(WEST, false).with(UP, false).with(DOWN, false));
        DIRECTION_TO_PROPERTY.put(Direction.NORTH, NORTH);
        DIRECTION_TO_PROPERTY.put(Direction.EAST, EAST);
        DIRECTION_TO_PROPERTY.put(Direction.SOUTH, SOUTH);
        DIRECTION_TO_PROPERTY.put(Direction.WEST, WEST);
        DIRECTION_TO_PROPERTY.put(Direction.UP, UP);
        DIRECTION_TO_PROPERTY.put(Direction.DOWN, DOWN);

        DIRECTION_TO_SHAPE.put(Direction.NORTH, NORTH_SHAPE);
        DIRECTION_TO_SHAPE.put(Direction.EAST, EAST_SHAPE);
        DIRECTION_TO_SHAPE.put(Direction.SOUTH, SOUTH_SHAPE);
        DIRECTION_TO_SHAPE.put(Direction.WEST, WEST_SHAPE);
        DIRECTION_TO_SHAPE.put(Direction.UP, UP_SHAPE);
        DIRECTION_TO_SHAPE.put(Direction.DOWN, DOWN_SHAPE);
    }



    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape axisShape = BASE_SHAPE;
        List<VoxelShape> additionalShapes = new ArrayList<>(List.of());
        for (Direction direction : DIRECTIONS) {
            if (state.get(AXIS) == Direction.Axis.Y) {
                boolean xor = state.get(UP) ^ state.get(DOWN);
                if ((!state.get(UP) && !state.get(DOWN)) || (xor && !state.get(NORTH) && !state.get(EAST) && !state.get(SOUTH) && !state.get(WEST))) {
                    additionalShapes.add(UP_SHAPE);
                    additionalShapes.add(DOWN_SHAPE);
                }
            } else if (state.get(AXIS) == Direction.Axis.X) {
                boolean xor = state.get(EAST) ^ state.get(WEST);
                if ((!state.get(EAST) && !state.get(WEST)) || (xor && !state.get(NORTH) && !state.get(UP) && !state.get(SOUTH) && !state.get(DOWN))) {
                    additionalShapes.add(EAST_SHAPE);
                    additionalShapes.add(WEST_SHAPE);
                }
            } else if (state.get(AXIS) == Direction.Axis.Z) {
                boolean xor = state.get(NORTH) ^ state.get(SOUTH);
                if ((!state.get(NORTH) && !state.get(SOUTH)) || (xor && !state.get(EAST) && !state.get(UP) && !state.get(WEST) && !state.get(DOWN))) {
                    additionalShapes.add(NORTH_SHAPE);
                    additionalShapes.add(SOUTH_SHAPE);
                }
            }
            if (state.get(DIRECTION_TO_PROPERTY.get(direction))) {
                additionalShapes.add(DIRECTION_TO_SHAPE.get(direction));
            }
        }
        for (int i = 0; i < additionalShapes.size(); i++) {
            axisShape = VoxelShapes.union(axisShape, additionalShapes.get(i));
        }
        return axisShape;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Map<Direction, Boolean> directionMap = new HashMap<>();
        for (Direction direction : DIRECTIONS) {
            BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction));
            if (blockState.isOf(this) && !blockState.get(DIRECTION_TO_PROPERTY.get(direction.getOpposite()))) {
                directionMap.put(direction, true);
            } else {
                directionMap.put(direction, false);
            }
        }
        return super.getPlacementState(ctx)
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
                .with(NORTH, directionMap.get(Direction.NORTH))
                .with(EAST, directionMap.get(Direction.EAST))
                .with(SOUTH, directionMap.get(Direction.SOUTH))
                .with(WEST, directionMap.get(Direction.WEST))
                .with(UP, directionMap.get(Direction.UP))
                .with(DOWN, directionMap.get(Direction.DOWN));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction unusedDir, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        world.setBlockState(pos, updateState(world, pos, state), 2);
        return super.getStateForNeighborUpdate(state, unusedDir, neighborState, world, pos, neighborPos);
    }

    private BlockState updateState(WorldAccess world, BlockPos pos, BlockState state) {
        Map<Direction, Boolean> directionMap = new HashMap<>();
        for (Direction direction : DIRECTIONS) {
            BlockState blockState = world.getBlockState(pos.offset(direction));
            if (blockState.isOf(this)) {
                directionMap.put(direction, true);
            } else {
                directionMap.put(direction, false);
            }
        }
        return state
                        .with(NORTH, directionMap.get(Direction.NORTH))
                        .with(EAST, directionMap.get(Direction.EAST))
                        .with(SOUTH, directionMap.get(Direction.SOUTH))
                        .with(WEST, directionMap.get(Direction.WEST))
                        .with(UP, directionMap.get(Direction.UP))
                        .with(DOWN, directionMap.get(Direction.DOWN));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS, NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }
}
