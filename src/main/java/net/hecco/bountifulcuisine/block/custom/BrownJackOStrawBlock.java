package net.hecco.bountifulcuisine.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class BrownJackOStrawBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;
    private static final VoxelShape NORTH_SOUTH_UPPER = VoxelShapes.combineAndSimplify(Block.createCuboidShape(3, 9, 3, 13, 21, 13), Block.createCuboidShape(4, 0, 6, 12, 9, 10), BooleanBiFunction.OR);
    private static final VoxelShape NORTH_SOUTH_LOWER = VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, -1, 7, 9, 12, 9), Block.createCuboidShape(4, 12, 6, 12, 16, 10), BooleanBiFunction.OR);
    private static final VoxelShape EAST_WEST_UPPER = VoxelShapes.combineAndSimplify(Block.createCuboidShape(3, 9, 3, 13, 21, 13), Block.createCuboidShape(6, 0, 4, 10, 9, 12), BooleanBiFunction.OR);
    private static final VoxelShape EAST_WEST_LOWER = VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, -1, 7, 9, 12, 9), Block.createCuboidShape(6, 12, 4, 10, 16, 12), BooleanBiFunction.OR);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(FACING) == Direction.NORTH || state.get(FACING) == Direction.SOUTH) {
            if (state.get(HALF) == DoubleBlockHalf.UPPER) {
                return NORTH_SOUTH_UPPER;
            } else {
                return NORTH_SOUTH_LOWER;
            }
        } else if (state.get(FACING) == Direction.EAST || state.get(FACING) == Direction.WEST) {
            if (state.get(HALF) == DoubleBlockHalf.UPPER) {
                return EAST_WEST_UPPER;
            } else {
                return EAST_WEST_LOWER;
            }
        }
        return NORTH_SOUTH_UPPER;
    }

    public BrownJackOStrawBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            return blockState.isSideSolidFullSquare(world, blockPos, Direction.UP) || world.getBlockState(pos.down()).isOf(Blocks.FARMLAND);
        }
        return blockState.isOf(this);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getBlockState(pos.up(1)).isOf(Blocks.AIR) && state.get(HALF) == DoubleBlockHalf.LOWER) {
            world.setBlockState(pos.up(1), this.getDefaultState().with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.UPPER), 2);
        }

    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (world.getBlockState(pos.up(1)).isOf(this) && state.get(HALF) == DoubleBlockHalf.LOWER) {
            world.breakBlock(pos, true);
            world.breakBlock(pos.up(1), false);
        } else if (world.getBlockState(pos.down(1)).isOf(this) && state.get(HALF) == DoubleBlockHalf.UPPER) {
            world.breakBlock(pos, true);
            world.breakBlock(pos.down(1), false);
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF);
    }
}
