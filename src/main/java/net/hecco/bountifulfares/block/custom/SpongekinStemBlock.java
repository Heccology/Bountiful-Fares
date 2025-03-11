package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class SpongekinStemBlock extends PlantBlock implements Fertilizable, FluidFillable {
    public static BooleanProperty ATTACHED = BooleanProperty.of("attached");

    public static final VoxelShape[] SHAPES = new VoxelShape[] {Block.createCuboidShape(7, 0, 7, 9, 3, 9), Block.createCuboidShape(6, 0, 6, 10, 6, 10), Block.createCuboidShape(5, 0, 5, 11, 11, 11), Block.createCuboidShape(5, 0, 5, 11, 15, 11), Block.createCuboidShape(4, 0, 4, 12, 16, 12)};
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = IntProperty.of("age", 0, 3);
    public SpongekinStemBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(AGE, 0).with(ATTACHED, false));
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(AGE) == 0) {
            return SHAPES[0];
        } else if (state.get(AGE) == 1) {
            return SHAPES[1];
        } else if (state.get(AGE) == 2) {
            return SHAPES[2];
        } else if (state.get(AGE) == 3 && state.get(ATTACHED).equals(false)) {
            return SHAPES[3];
        } else if (state.get(AGE) == 3 && state.get(ATTACHED).equals(true)) {
            return SHAPES[4];
        }
        return SHAPES[0];
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, ATTACHED);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!isFullyGrown(state) && !state.get(ATTACHED) && random.nextFloat() < 0.1f) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
        if (isFullyGrown(state) && !state.get(ATTACHED) && random.nextFloat() < 0.1f) {
            BlockPos spongekinPos = pos.offset(Direction.UP);
            if ((world.getBlockState(spongekinPos).isAir() || world.getBlockState(spongekinPos).isOf(Blocks.WATER) && isFullyGrown(state))) {
                world.setBlockState(spongekinPos, BFBlocks.SPONGEKIN.getDefaultState(), 2);
                world.setBlockState(pos, this.getStateWithProperties(state).with(ATTACHED, true));
                BlockPos prismarineBlossomPos = pos.offset(Direction.UP, 2);
                if (shouldPropagatePrismarine(world, pos)) {
                    if (world.getBlockState(prismarineBlossomPos).isOf(Blocks.WATER)) {
                        world.setBlockState(prismarineBlossomPos, BFBlocks.PRISMARINE_BLOSSOM.getDefaultState().with(PrismarineBlossomBlock.WATERLOGGED, true), 2);
                    } else if (world.getBlockState(prismarineBlossomPos).isAir()) {
                        world.setBlockState(prismarineBlossomPos, BFBlocks.PRISMARINE_BLOSSOM.getDefaultState(), 2);
                    }

                }
            }
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (!isFullyGrown(state) && !state.get(ATTACHED)) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
    }

    public boolean shouldPropagatePrismarine(ServerWorld world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(BFBlockTags.PRISMARINE_PROPAGATION_SUBSTRATE);
    }

    protected static boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 3;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isSideSolidFullSquare(world, pos, Direction.UP) && !floor.isOf(Blocks.MAGMA_BLOCK);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        if (fluidState.isIn(FluidTags.WATER) && fluidState.getLevel() == 8) {
            return super.getPlacementState(ctx);
        }
        return null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState blockState = super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        if (!blockState.isAir()) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        if (state.get(ATTACHED) && !world.getBlockState(pos.up()).isOf(BFBlocks.SPONGEKIN)) {
            if (state.get(AGE) == 3)
                return state.with(ATTACHED, false);
        }
        return blockState;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStill(false);
    }

    @Override
    public boolean canFillWithFluid(@Nullable PlayerEntity player, BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return false;
    }
}
