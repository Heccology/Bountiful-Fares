package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class StrippedFruitLogBlock extends RotatedPillarBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape BASE_SHAPE = Block.box(4, 4, 4, 12, 12, 12);
    protected static final VoxelShape NORTH_SHAPE = Block.box(4, 4, 0, 12, 12, 4);
    protected static final VoxelShape EAST_SHAPE = Block.box(12, 4, 4, 16, 12, 12);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(4, 4, 12, 12, 12, 16);
    protected static final VoxelShape WEST_SHAPE = Block.box(0, 4, 4, 4, 12, 12);
    protected static final VoxelShape UP_SHAPE = Block.box(4, 12, 4, 12, 16, 12);
    protected static final VoxelShape DOWN_SHAPE = Block.box(4, 0, 4, 12, 4, 12);

    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static Map<Direction, BooleanProperty> DIRECTION_TO_PROPERTY = new HashMap<>();
    public static Map<Direction, VoxelShape> DIRECTION_TO_SHAPE = new HashMap<>();

    public StrippedFruitLogBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(AXIS, Direction.Axis.Y).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(UP, false).setValue(DOWN, false));
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
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide && stack.getItem() instanceof AxeItem) {
            final Supplier<Block> stripped;
                    //this code is the equivalent of betting on papyrus knight theory
            if (state.getBlock() == BFBlocks.PALM_LOG.get()) {
                stripped = BFBlocks.STRIPPED_PALM_LOG;

                BlockState strippedState = stripped.get().defaultBlockState();

                for (Property<?> prop : state.getProperties()) {
                    if (strippedState.hasProperty(prop)) {
                        strippedState = copyProperty(strippedState, state, prop);
                    }
                }

                level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                level.setBlock(pos, strippedState, 11);
                return ItemInteractionResult.SUCCESS;
            }

            if (state.getBlock() == BFBlocks.PALM_WOOD.get()) {
                stripped = BFBlocks.STRIPPED_PALM_WOOD;

                BlockState strippedState = stripped.get().defaultBlockState();

                for (Property<?> prop : state.getProperties()) {
                    if (strippedState.hasProperty(prop)) {
                        strippedState = copyProperty(strippedState, state, prop);
                    }
                }

                level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                level.setBlock(pos, strippedState, 11);
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    private <T extends Comparable<T>> BlockState copyProperty(BlockState target, BlockState source, Property<T> prop) {
        return target.setValue(prop, source.getValue(prop));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape axisShape = BASE_SHAPE;
        List<VoxelShape> additionalShapes = new ArrayList<>(List.of());
        for (Direction direction : UPDATE_SHAPE_ORDER) {
            if (state.getValue(AXIS) == Direction.Axis.Y) {
                boolean xor = state.getValue(UP) ^ state.getValue(DOWN);
                if ((!state.getValue(UP) && !state.getValue(DOWN)) || (xor && !state.getValue(NORTH) && !state.getValue(EAST) && !state.getValue(SOUTH) && !state.getValue(WEST))) {
                    additionalShapes.add(UP_SHAPE);
                    additionalShapes.add(DOWN_SHAPE);
                }
            } else if (state.getValue(AXIS) == Direction.Axis.X) {
                boolean xor = state.getValue(EAST) ^ state.getValue(WEST);
                if ((!state.getValue(EAST) && !state.getValue(WEST)) || (xor && !state.getValue(NORTH) && !state.getValue(UP) && !state.getValue(SOUTH) && !state.getValue(DOWN))) {
                    additionalShapes.add(EAST_SHAPE);
                    additionalShapes.add(WEST_SHAPE);
                }
            } else if (state.getValue(AXIS) == Direction.Axis.Z) {
                boolean xor = state.getValue(NORTH) ^ state.getValue(SOUTH);
                if ((!state.getValue(NORTH) && !state.getValue(SOUTH)) || (xor && !state.getValue(EAST) && !state.getValue(UP) && !state.getValue(WEST) && !state.getValue(DOWN))) {
                    additionalShapes.add(NORTH_SHAPE);
                    additionalShapes.add(SOUTH_SHAPE);
                }
            }
            if (state.getValue(DIRECTION_TO_PROPERTY.get(direction))) {
                additionalShapes.add(DIRECTION_TO_SHAPE.get(direction));
            }
        }
        for (int i = 0; i < additionalShapes.size(); i++) {
            axisShape = Shapes.or(axisShape, additionalShapes.get(i));
        }
        return axisShape;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Map<Direction, Boolean> directionMap = new HashMap<>();
        for (Direction direction : UPDATE_SHAPE_ORDER) {
            BlockState blockState = ctx.getLevel().getBlockState(ctx.getClickedPos().relative(direction));
            if (blockState.is(this) && !blockState.getValue(DIRECTION_TO_PROPERTY.get(direction.getOpposite()))) {
                directionMap.put(direction, true);
            } else {
                directionMap.put(direction, false);
            }
        }
        return super.getStateForPlacement(ctx)
                .setValue(WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER)
                .setValue(NORTH, directionMap.get(Direction.NORTH))
                .setValue(EAST, directionMap.get(Direction.EAST))
                .setValue(SOUTH, directionMap.get(Direction.SOUTH))
                .setValue(WEST, directionMap.get(Direction.WEST))
                .setValue(UP, directionMap.get(Direction.UP))
                .setValue(DOWN, directionMap.get(Direction.DOWN));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction unusedDir, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        world.setBlock(pos, updateState(world, pos, state), 2);
        return super.updateShape(state, unusedDir, neighborState, world, pos, neighborPos);
    }

    private BlockState updateState(LevelAccessor world, BlockPos pos, BlockState state) {
        Map<Direction, Boolean> directionMap = new HashMap<>();
        for (Direction direction : UPDATE_SHAPE_ORDER) {
            BlockState blockState = world.getBlockState(pos.relative(direction));
            if (blockState.is(this)) {
                directionMap.put(direction, true);
            } else {
                directionMap.put(direction, false);
            }
        }
        return state
                        .setValue(NORTH, directionMap.get(Direction.NORTH))
                        .setValue(EAST, directionMap.get(Direction.EAST))
                        .setValue(SOUTH, directionMap.get(Direction.SOUTH))
                        .setValue(WEST, directionMap.get(Direction.WEST))
                        .setValue(UP, directionMap.get(Direction.UP))
                        .setValue(DOWN, directionMap.get(Direction.DOWN));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS, NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
