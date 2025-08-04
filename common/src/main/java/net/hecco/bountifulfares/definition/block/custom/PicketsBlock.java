package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class PicketsBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final VoxelShape NORTH_SHAPE = Block.box(0, 0, 14, 16, 8, 16);
    public static final VoxelShape EAST_SHAPE = Block.box(0, 0, 0, 2, 8, 16);
    public static final VoxelShape SOUTH_SHAPE = Block.box(0, 0, 0, 16, 8, 2);
    public static final VoxelShape WEST_SHAPE = Block.box(14, 0, 0, 16, 8, 16);
    public static final VoxelShape NORTH_COLL = Block.box(0, 0, 14, 16, 10, 16);
    public static final VoxelShape EAST_COLL = Block.box(0, 0, 0, 2, 10, 16);
    public static final VoxelShape SOUTH_COLL = Block.box(0, 0, 0, 16, 10, 2);
    public static final VoxelShape WEST_COLL = Block.box(14, 0, 0, 16, 10, 16);
    public PicketsBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        List<VoxelShape> SHAPES = new ArrayList<>();

        if (state.getValue(NORTH)) SHAPES.add(NORTH_SHAPE);
        if (state.getValue(EAST)) SHAPES.add(EAST_SHAPE);
        if (state.getValue(SOUTH)) SHAPES.add(SOUTH_SHAPE);
        if (state.getValue(WEST)) SHAPES.add(WEST_SHAPE);

        if (!SHAPES.isEmpty()) {
            VoxelShape result = SHAPES.get(0);
            for (int i = 1; i < SHAPES.size(); i++) {
                result = Shapes.or(result, SHAPES.get(i));
            }
            return result;
        }

        return super.getShape(state, world, pos, context);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        List<VoxelShape> COLLISION = new ArrayList<>();

        if (state.getValue(NORTH)) COLLISION.add(NORTH_COLL);
        if (state.getValue(EAST)) COLLISION.add(EAST_COLL);
        if (state.getValue(SOUTH)) COLLISION.add(SOUTH_COLL);
        if (state.getValue(WEST)) COLLISION.add(WEST_COLL);

        if (!COLLISION.isEmpty()) {
            VoxelShape result = COLLISION.get(0);
            for (int i = 1; i < COLLISION.size(); i++) {
                result = Shapes.or(result, COLLISION.get(i));
            }
            return result;
        }

        return super.getCollisionShape(state, world, pos, context);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED);
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction playerDir = ctx.getHorizontalDirection().getOpposite();
        BlockState blockState = ctx.getLevel().getBlockState(ctx.getClickedPos());

        if (blockState.is(this)) {
            Direction facingDirection = getFacingDirection(blockState);

            if (facingDirection != playerDir) {
                return super.withPropertiesOf(blockState).setValue(getFacingProperty(playerDir), true);
            }
        } else {
            return super.defaultBlockState().setValue(getFacingProperty(playerDir), true).setValue(WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER);
        }

        return super.getStateForPlacement(ctx).setValue(WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER);
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (context.getPlayer() != null) {
            Direction playerDir = context.getHorizontalDirection().getOpposite();
            Direction facingDirection = getFacingDirection(state);
            return !context.isSecondaryUseActive() && context.getItemInHand().getItem() == this.asItem() && facingDirection != playerDir || super.canBeReplaced(state, context);
        } else {
            return true;
        }
    }

    private Direction getFacingDirection(BlockState blockState) {
        if (blockState.getValue(NORTH)) return Direction.NORTH;
        if (blockState.getValue(EAST)) return Direction.EAST;
        if (blockState.getValue(SOUTH)) return Direction.SOUTH;
        if (blockState.getValue(WEST)) return Direction.WEST;
        return Direction.NORTH;
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
    public BlockState rotate(BlockState state, Rotation rotation) {
        return switch (rotation) {
            case CLOCKWISE_180 -> (((state.setValue(NORTH, state.getValue(SOUTH))).setValue(EAST, state.getValue(WEST))).setValue(SOUTH, state.getValue(NORTH))).setValue(WEST, state.getValue(EAST));
            case COUNTERCLOCKWISE_90 -> (((state.setValue(NORTH, state.getValue(EAST))).setValue(EAST, state.getValue(SOUTH))).setValue(SOUTH, state.getValue(WEST))).setValue(WEST, state.getValue(NORTH));
            case CLOCKWISE_90 -> (((state.setValue(NORTH, state.getValue(WEST))).setValue(EAST, state.getValue(NORTH))).setValue(SOUTH, state.getValue(EAST))).setValue(WEST, state.getValue(SOUTH));
            default -> state;
        };
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return switch (mirror) {
            case LEFT_RIGHT -> (state.setValue(NORTH, state.getValue(SOUTH))).setValue(SOUTH, state.getValue(NORTH));
            case FRONT_BACK -> (state.setValue(EAST, state.getValue(WEST))).setValue(WEST, state.getValue(EAST));
            default -> super.mirror(state, mirror);
        };
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
