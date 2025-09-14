package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MaizeCropBlock extends CropBlock implements BonemealableBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public static final IntegerProperty AGE;
    public static final VoxelShape[] LOWER_SHAPES = new VoxelShape[] {
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(0, 0, 0, 16, 6, 16),
            Block.box(0, 0, 0, 16, 12, 16),
            Block.box(0, 0, 0, 16, 16, 16)
    };
    public static final VoxelShape[] UPPER_SHAPES = new VoxelShape[] {
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 0, 0, 16, 8, 16),
            Block.box(0, 0, 0, 16, 16, 16),
    };

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return switch (state.getValue(AGE)) {
                case 0 -> LOWER_SHAPES[0];
                case 1 -> LOWER_SHAPES[1];
                case 2 -> LOWER_SHAPES[2];
                default -> LOWER_SHAPES[3];
            };
        } else if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            return switch (state.getValue(AGE)) {
                case 0, 1, 2, 3, 4 -> UPPER_SHAPES[0];
                case 5 -> UPPER_SHAPES[1];
                default -> UPPER_SHAPES[2];
            };
        }
        return LOWER_SHAPES[3];
    }

    public MaizeCropBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(AGE, 0));
    }

    private boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) >= 7;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER && !this.isFullyGrown(state);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState();
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        return !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : state;
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        if (!isLowerHalf(state)) {
            return super.canSurvive(state, world, pos) || world.getBlockState(pos.below()).is(this);
        } else {
            // original 1st arg: super.canPlantOnTop(world.getBlockState(pos.down()), world, pos.down()
            // changed because it was incompatible with things like FD rich soil. - Artyrian
            return (world.getBlockState(pos.below()).getBlock() instanceof FarmBlock) && canPlaceAt(world, pos) && (state.getValue(AGE) < 4 || isUpperHalf(world.getBlockState(pos.above())));
        }
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(BFItems.MAIZE_SEEDS.get());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, HALF);
    }
    @Override
    public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        DoubleBlockHalf doubleBlockHalf = state.getValue(HALF);
        if (!player.isCreative() && doubleBlockHalf == DoubleBlockHalf.LOWER && state.getValue(AGE) < 7) {
            popResource(world, pos, BFItems.MAIZE_SEEDS.get().getDefaultInstance());
        }
        if (!world.isClientSide) {
            if (player.isCreative()) {
                onBreakInCreative(world, pos, state, player);
            } else {
                dropResources(state, world, pos, null, player, player.getMainHandItem());
            }
        }
        return super.playerWillDestroy(world, pos, state, player);
    }

    protected static void onBreakInCreative(Level world, BlockPos pos, BlockState state, Player player) {
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

    protected static float getGrowthSpeed(Block block, BlockGetter world, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockPos = pos.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float g = 0.0F;
                BlockState blockState = world.getBlockState(blockPos.offset(i, 0, j));
                if (blockState.is(Blocks.FARMLAND)) {
                    g = 1.0F;
                    if (blockState.getValue(FarmBlock.MOISTURE) > 0) {
                        g = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    g /= 4.0F;
                }

                f += g;
            }
        }

        BlockPos blockPos2 = pos.north();
        BlockPos blockPos3 = pos.south();
        BlockPos blockPos4 = pos.west();
        BlockPos blockPos5 = pos.east();
        boolean bl = world.getBlockState(blockPos4).is(block) || world.getBlockState(blockPos5).is(block);
        boolean bl2 = world.getBlockState(blockPos2).is(block) || world.getBlockState(blockPos3).is(block);
        if (bl && bl2) {
            f /= 2.0F;
        } else {
            boolean bl3 = world.getBlockState(blockPos4.north()).is(block) || world.getBlockState(blockPos5.north()).is(block) || world.getBlockState(blockPos5.south()).is(block) || world.getBlockState(blockPos4.south()).is(block);
            if (bl3) {
                f /= 2.0F;
            }
        }

        return f;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, net.minecraft.util.RandomSource random) {
        if (world.getRawBrightness(pos, 0) >= 9) {
            float f = getGrowthSpeed(this, world, pos);
            boolean bl = random.nextInt((int) (25.0F / f) + 1) == 0;
            if (bl) {
                this.tryGrow(world, state, pos);
            }
        }
    }

    private void tryGrow(ServerLevel world, BlockState state, BlockPos pos) {
        int i = Math.min(state.getValue(AGE) + 1, 7);
        if (this.canGrow(world, pos, state, i)) {
            world.setBlock(pos, state.setValue(AGE, i), 2);
            if (i >= 4) {
                BlockPos blockPos = pos.above();
                world.setBlock(blockPos, withWaterloggedState(world, pos, (this.defaultBlockState().setValue(AGE, i)).setValue(HALF, DoubleBlockHalf.UPPER)), 3);
            }

        }
    }

    private static boolean canGrowAt(LevelReader world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isAir() || blockState.is(BFBlocks.MAIZE_CROP.get());
    }

    private static boolean canPlaceAt(LevelReader world, BlockPos pos) {
        return world.getRawBrightness(pos, 0) >= 8 || world.canSeeSky(pos);
    }

    private static boolean isLowerHalf(BlockState state) {
        return state.is(BFBlocks.MAIZE_CROP.get()) && state.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    private static boolean isUpperHalf(BlockState state) {
        return state.is(BFBlocks.MAIZE_CROP.get()) && state.getValue(HALF) == DoubleBlockHalf.UPPER;
    }

    private boolean canGrow(LevelReader world, BlockPos pos, BlockState state, int age) {
        return !this.isFullyGrown(state) && canPlaceAt(world, pos) && (age < 3 || canGrowAt(world, pos.above()));
    }

    @Nullable
    private MaizeCropBlock.LowerHalfContext getLowerHalfContext(LevelReader world, BlockPos pos, BlockState state) {
        if (isLowerHalf(state)) {
            return new MaizeCropBlock.LowerHalfContext(pos, state);
        } else {
            BlockPos blockPos = pos.below();
            BlockState blockState = world.getBlockState(blockPos);
            return isLowerHalf(blockState) ? new MaizeCropBlock.LowerHalfContext(blockPos, blockState) : null;
        }
    }

    public boolean isFertilizable(LevelReader world, BlockPos pos, BlockState state, boolean isClient) {
        MaizeCropBlock.LowerHalfContext lowerHalfContext = this.getLowerHalfContext(world, pos, state);
        return lowerHalfContext != null && this.canGrow(world, lowerHalfContext.pos, lowerHalfContext.state, lowerHalfContext.state.getValue(AGE) + 1);
    }

    public boolean isBonemealSuccess(Level world, net.minecraft.util.RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        MaizeCropBlock.LowerHalfContext lowerHalfContext = this.getLowerHalfContext(world, pos, state);
        if (lowerHalfContext != null) {
            this.tryGrow(world, lowerHalfContext.state, lowerHalfContext.pos);
        }
    }

    public static BlockState withWaterloggedState(LevelReader world, BlockPos pos, BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) ? state.setValue(BlockStateProperties.WATERLOGGED, world.isWaterAt(pos)) : state;
    }

    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(world, player, pos, Blocks.AIR.defaultBlockState(), blockEntity, tool);
    }

    public long getSeed(BlockState state, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

    static {
        AGE = BlockStateProperties.AGE_7;
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
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
