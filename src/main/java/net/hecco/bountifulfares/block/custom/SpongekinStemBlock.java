package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SpongekinStemBlock extends BushBlock implements BonemealableBlock, LiquidBlockContainer {
    public static BooleanProperty ATTACHED = BooleanProperty.create("attached");

    public static final VoxelShape[] SHAPES = new VoxelShape[] {Block.box(7, 0, 7, 9, 3, 9), Block.box(6, 0, 6, 10, 6, 10), Block.box(5, 0, 5, 11, 11, 11), Block.box(5, 0, 5, 11, 15, 11), Block.box(4, 0, 4, 12, 16, 12)};
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);
    public SpongekinStemBlock(Properties settings) {
        super(settings);
        this.registerDefaultState((this.stateDefinition.any()).setValue(AGE, 0).setValue(ATTACHED, false));
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return null;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) == 0) {
            return SHAPES[0];
        } else if (state.getValue(AGE) == 1) {
            return SHAPES[1];
        } else if (state.getValue(AGE) == 2) {
            return SHAPES[2];
        } else if (state.getValue(AGE) == 3 && state.getValue(ATTACHED).equals(false)) {
            return SHAPES[3];
        } else if (state.getValue(AGE) == 3 && state.getValue(ATTACHED).equals(true)) {
            return SHAPES[4];
        }
        return SHAPES[0];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, ATTACHED);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!isFullyGrown(state) && !state.getValue(ATTACHED) && random.nextFloat() < 0.1f) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
        if (isFullyGrown(state) && !state.getValue(ATTACHED) && random.nextFloat() < 0.1f) {
            BlockPos spongekinPos = pos.relative(Direction.UP);
            if ((world.getBlockState(spongekinPos).isAir() || world.getBlockState(spongekinPos).is(Blocks.WATER) && isFullyGrown(state))) {
                world.setBlock(spongekinPos, BFBlocks.SPONGEKIN.defaultBlockState(), 2);
                world.setBlockAndUpdate(pos, this.withPropertiesOf(state).setValue(ATTACHED, true));
                BlockPos prismarineBlossomPos = pos.relative(Direction.UP, 2);
                if (shouldPropagatePrismarine(world, pos)) {
                    if (world.getBlockState(prismarineBlossomPos).is(Blocks.WATER)) {
                        world.setBlock(prismarineBlossomPos, BFBlocks.PRISMARINE_BLOSSOM.defaultBlockState().setValue(PrismarineBlossomBlock.WATERLOGGED, true), 2);
                    } else if (world.getBlockState(prismarineBlossomPos).isAir()) {
                        world.setBlock(prismarineBlossomPos, BFBlocks.PRISMARINE_BLOSSOM.defaultBlockState(), 2);
                    }

                }
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        if (!isFullyGrown(state) && !state.getValue(ATTACHED)) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }

    public boolean shouldPropagatePrismarine(ServerLevel world, BlockPos pos) {
        return world.getBlockState(pos.below()).is(BFBlockTags.PRISMARINE_PROPAGATION_SUBSTRATE);
    }

    protected static boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) == 3;
    }

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.isFaceSturdy(world, pos, Direction.UP) && !floor.is(Blocks.MAGMA_BLOCK);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        if (fluidState.is(FluidTags.WATER) && fluidState.getAmount() == 8) {
            return super.getStateForPlacement(ctx);
        }
        return null;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        BlockState blockState = super.updateShape(state, direction, neighborState, world, pos, neighborPos);
        if (!blockState.isAir()) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        if (state.getValue(ATTACHED) && !world.getBlockState(pos.above()).is(BFBlocks.SPONGEKIN)) {
            if (state.getValue(AGE) == 3)
                return state.setValue(ATTACHED, false);
        }
        return blockState;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getSource(false);
    }

    @Override
    public boolean canPlaceLiquid(@Nullable Player player, BlockGetter world, BlockPos pos, BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    public boolean placeLiquid(LevelAccessor world, BlockPos pos, BlockState state, FluidState fluidState) {
        return false;
    }
}
