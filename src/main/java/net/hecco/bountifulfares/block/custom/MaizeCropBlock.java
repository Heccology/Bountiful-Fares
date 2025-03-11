package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class MaizeCropBlock extends CropBlock implements Fertilizable {
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public static final IntProperty AGE;
    public static final VoxelShape[] LOWER_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(0, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 0, 0, 16, 6, 16),
            Block.createCuboidShape(0, 0, 0, 16, 12, 16),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16)
    };
    public static final VoxelShape[] UPPER_SHAPES = new VoxelShape[] {
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(0, 0, 0, 16, 8, 16),
            Block.createCuboidShape(0, 0, 0, 16, 16, 16),
    };

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            return switch (state.get(AGE)) {
                case 0 -> LOWER_SHAPES[0];
                case 1 -> LOWER_SHAPES[1];
                case 2 -> LOWER_SHAPES[2];
                default -> LOWER_SHAPES[3];
            };
        } else if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            return switch (state.get(AGE)) {
                case 0, 1, 2, 3, 4 -> UPPER_SHAPES[0];
                case 5 -> UPPER_SHAPES[1];
                default -> UPPER_SHAPES[2];
            };
        }
        return LOWER_SHAPES[3];
    }

    public MaizeCropBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(AGE, 0));
    }

    private boolean isFullyGrown(BlockState state) {
        return state.get(AGE) >= 7;
    }

    public boolean hasRandomTicks(BlockState state) {
        return state.get(HALF) == DoubleBlockHalf.LOWER && !this.isFullyGrown(state);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (!isLowerHalf(state)) {
            return super.canPlaceAt(state, world, pos) || world.getBlockState(pos.down()).isOf(this);
        } else {
            return super.canPlantOnTop(world.getBlockState(pos.down()), world, pos.down()) && canPlaceAt(world, pos) && (state.get(AGE) < 4 || isUpperHalf(world.getBlockState(pos.up())));
        }
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(BFItems.MAIZE_SEEDS);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, HALF);
    }
    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.LOWER && state.get(AGE) < 7) {
            dropStack(world, pos, BFItems.MAIZE_SEEDS.getDefaultStack());
        }
        if (!world.isClient) {
            if (player.isCreative()) {
                onBreakInCreative(world, pos, state, player);
            } else {
                dropStacks(state, world, pos, null, player, player.getMainHandStack());
            }
        }
        return super.onBreak(world, pos, state, player);
    }

    protected static void onBreakInCreative(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockState2 = blockState.getFluidState().isOf(Fluids.WATER) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                world.setBlockState(blockPos, blockState2, 35);
                world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
            }
        }

    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            float f = CropBlock.getAvailableMoisture(this, world, pos);
            boolean bl = random.nextInt((int) (25.0F / f) + 1) == 0;
            if (bl) {
                this.tryGrow(world, state, pos);
            }
        }
    }

    private void tryGrow(ServerWorld world, BlockState state, BlockPos pos) {
        int i = Math.min(state.get(AGE) + 1, 7);
        if (this.canGrow(world, pos, state, i)) {
            world.setBlockState(pos, state.with(AGE, i), 2);
            if (i >= 4) {
                BlockPos blockPos = pos.up();
                world.setBlockState(blockPos, withWaterloggedState(world, pos, (this.getDefaultState().with(AGE, i)).with(HALF, DoubleBlockHalf.UPPER)), 3);
            }

        }
    }

    private static boolean canGrowAt(WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isAir() || blockState.isOf(BFBlocks.MAIZE_CROP);
    }

    private static boolean canPlaceAt(WorldView world, BlockPos pos) {
        return world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos);
    }

    private static boolean isLowerHalf(BlockState state) {
        return state.isOf(BFBlocks.MAIZE_CROP) && state.get(HALF) == DoubleBlockHalf.LOWER;
    }

    private static boolean isUpperHalf(BlockState state) {
        return state.isOf(BFBlocks.MAIZE_CROP) && state.get(HALF) == DoubleBlockHalf.UPPER;
    }

    private boolean canGrow(WorldView world, BlockPos pos, BlockState state, int age) {
        return !this.isFullyGrown(state) && canPlaceAt(world, pos) && (age < 3 || canGrowAt(world, pos.up()));
    }

    @Nullable
    private MaizeCropBlock.LowerHalfContext getLowerHalfContext(WorldView world, BlockPos pos, BlockState state) {
        if (isLowerHalf(state)) {
            return new MaizeCropBlock.LowerHalfContext(pos, state);
        } else {
            BlockPos blockPos = pos.down();
            BlockState blockState = world.getBlockState(blockPos);
            return isLowerHalf(blockState) ? new MaizeCropBlock.LowerHalfContext(blockPos, blockState) : null;
        }
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        MaizeCropBlock.LowerHalfContext lowerHalfContext = this.getLowerHalfContext(world, pos, state);
        return lowerHalfContext != null && this.canGrow(world, lowerHalfContext.pos, lowerHalfContext.state, lowerHalfContext.state.get(AGE) + 1);
    }

    public boolean canGrow(World world, net.minecraft.util.math.random.Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        MaizeCropBlock.LowerHalfContext lowerHalfContext = this.getLowerHalfContext(world, pos, state);
        if (lowerHalfContext != null) {
            this.tryGrow(world, lowerHalfContext.state, lowerHalfContext.pos);
        }
    }

    public static BlockState withWaterloggedState(WorldView world, BlockPos pos, BlockState state) {
        return state.contains(Properties.WATERLOGGED) ? state.with(Properties.WATERLOGGED, world.isWater(pos)) : state;
    }

    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, Blocks.AIR.getDefaultState(), blockEntity, tool);
    }

    public long getRenderingSeed(BlockState state, BlockPos pos) {
        return MathHelper.hashCode(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    static {
        AGE = Properties.AGE_7;
        HALF = Properties.DOUBLE_BLOCK_HALF;
    }

    private record LowerHalfContext(BlockPos pos, BlockState state) {

        public BlockPos pos() {
            return this.pos;
        }

        public BlockState state() {
            return this.state;
        }
    }
}
