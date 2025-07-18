package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFSoundTypes;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BrownJackOStrawBlock extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private static final VoxelShape NORTH_SOUTH_UPPER = Shapes.join(Block.box(3, 9, 3, 13, 21, 13), Block.box(4, 0, 6, 12, 9, 10), BooleanOp.OR);
    private static final VoxelShape NORTH_SOUTH_LOWER = Shapes.join(Block.box(7, -1, 7, 9, 12, 9), Block.box(4, 12, 6, 12, 16, 10), BooleanOp.OR);
    private static final VoxelShape EAST_WEST_UPPER = Shapes.join(Block.box(3, 9, 3, 13, 21, 13), Block.box(6, 0, 4, 10, 9, 12), BooleanOp.OR);
    private static final VoxelShape EAST_WEST_LOWER = Shapes.join(Block.box(7, -1, 7, 9, 12, 9), Block.box(6, 12, 4, 10, 16, 12), BooleanOp.OR);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(FACING) == Direction.NORTH || state.getValue(FACING) == Direction.SOUTH) {
            if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
                return NORTH_SOUTH_UPPER;
            } else {
                return NORTH_SOUTH_LOWER;
            }
        } else if (state.getValue(FACING) == Direction.EAST || state.getValue(FACING) == Direction.WEST) {
            if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
                return EAST_WEST_UPPER;
            } else {
                return EAST_WEST_LOWER;
            }
        }
        return NORTH_SOUTH_UPPER;
    }



    public BrownJackOStrawBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        BlockState blockState = world.getBlockState(blockPos);
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return (blockState.isFaceSturdy(world, blockPos, Direction.UP) || world.getBlockState(pos.below()).is(Blocks.FARMLAND)) && world.getBlockState(pos.above()).is(Blocks.AIR) || world.getBlockState(pos.above()).is(Blocks.WATER);
        }
        return blockState.is(this);
    }
    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getBlockState(pos.above(1)).is(Blocks.AIR) && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            world.setBlock(pos.above(1), this.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(HALF, DoubleBlockHalf.UPPER), 2);

        }
        if (world.getBlockState(pos.above(1)).is(Blocks.WATER) && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            world.setBlock(pos.above(1), this.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(HALF, DoubleBlockHalf.UPPER).setValue(WATERLOGGED, true), 2);

        }
    }

    private static void onBreakInCreative(Level world, BlockPos pos, BlockState state, Player player) {
        DoubleBlockHalf doubleBlockHalf = state.getValue(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos blockPos = pos.below();
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.is(state.getBlock()) && blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockState2 = blockState.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                world.setBlock(blockPos, blockState2, 35);
                world.levelEvent(player, 2001, blockPos, Block.getId(blockState));
            }
        }

    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = state.getValue(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP) && (!neighborState.is(this) || neighborState.getValue(HALF) == doubleBlockHalf)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP) && (!neighborState.is(this) || neighborState.getValue(HALF) == doubleBlockHalf)) {
                return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
            }
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide && player.isCreative()) {
            onBreakInCreative(world, pos, state, player);
        } else if (world.getBlockState(pos.above()).is(this) && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            world.destroyBlock(pos, true);
            world.destroyBlock(pos.above(), false);
        } else if (world.getBlockState(pos.below()).is(this) && state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            world.destroyBlock(pos, true);
            world.destroyBlock(pos.below(), false);
        }
        return super.playerWillDestroy(world, pos, state, player);
    }

    @Override
    public SoundType getSoundType(BlockState state) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return BFSoundTypes.JACK_O_STRAW;
        } else {
            return BFSoundTypes.SILENT;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }
}
