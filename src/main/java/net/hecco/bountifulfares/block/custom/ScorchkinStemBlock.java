package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.block.*;
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
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class ScorchkinStemBlock extends PlantBlock {
    public static BooleanProperty ATTACHED = BooleanProperty.of("attached");

    public static final VoxelShape[] SHAPES = new VoxelShape[] {Block.createCuboidShape(7, 13, 7, 9, 16, 9), Block.createCuboidShape(6, 10, 6, 10, 16, 10), Block.createCuboidShape(5, 5, 5, 11, 16, 11), Block.createCuboidShape(5, 1, 5, 11, 16, 11), Block.createCuboidShape(4, 0, 4, 12, 16, 12)};
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = IntProperty.of("age", 0, 3);
    public ScorchkinStemBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(AGE, 0).with(ATTACHED, false));
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(AGE) == 3 && state.get(ATTACHED).equals(true)) {
            return SHAPES[4];
        }
        return SHAPES[state.get(AGE)];
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, ATTACHED);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextFloat() < 0.1f && checkForLava(world, pos)) {
            if (!isFullyGrown(state) && !state.get(ATTACHED)) {
                world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
            }
            if (isFullyGrown(state) && !state.get(ATTACHED)) {
                BlockPos SCORCHKINPos = pos.offset(Direction.DOWN);
                if ((world.getBlockState(SCORCHKINPos).isAir() || world.getBlockState(SCORCHKINPos).isOf(Blocks.LAVA) && isFullyGrown(state))) {
                    world.setBlockState(SCORCHKINPos, BFBlocks.SCORCHKIN.getDefaultState(), 2);
                    world.setBlockState(pos, this.getStateWithProperties(state).with(ATTACHED, true));
//                BlockPos prismarineBlossomPos = pos.offset(Direction.DOWN, 2);
//                if (shouldPropagatePrismarine(world, pos)) {
//                    if (world.getBlockState(prismarineBlossomPos).isOf(Blocks.WATER)) {
//                        world.setBlockState(prismarineBlossomPos, ModBlocks.PRISMARINE_BLOSSOM.getDefaultState().with(PrismarineBlossomBlock.WATERLOGGED, true), 2);
//                    } else if (world.getBlockState(prismarineBlossomPos).isAir()) {
//                        world.setBlockState(prismarineBlossomPos, ModBlocks.PRISMARINE_BLOSSOM.getDefaultState(), 2);
//                    }
//
//                }
                }
            }
        }
    }

    public boolean checkForLava(ServerWorld world, BlockPos pos) {
        BlockPos iPos = pos.down();
        while (!world.getBlockState(iPos).getFluidState().isIn(FluidTags.LAVA)) {
            if (world.getBlockState(iPos).isSolidBlock(world, pos)) {
                return false;
            }
            iPos = iPos.down();
        }
        return true;
    }
    public boolean shouldPropagatePrismarine(ServerWorld world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOf(Blocks.SEA_LANTERN);
    }

    protected static boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 3;
    }

    protected boolean canPlantOnTop(BlockView world, BlockPos pos) {
        return world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos, Direction.DOWN);
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return this.canPlantOnTop(world, pos);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(ATTACHED) && !world.getBlockState(pos.down()).isOf(BFBlocks.SCORCHKIN)) {
            if (state.get(AGE) == 3)
                return state.with(ATTACHED, false);
        }
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }
}
