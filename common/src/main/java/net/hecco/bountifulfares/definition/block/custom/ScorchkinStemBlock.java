package net.hecco.bountifulfares.definition.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ScorchkinStemBlock extends BushBlock { //lmfao - yirfmiri 5/1/26
    public static BooleanProperty ATTACHED = BooleanProperty.create("attached");

    public static final VoxelShape[] SHAPES = new VoxelShape[] {Block.box(7, 13, 7, 9, 16, 9), Block.box(6, 10, 6, 10, 16, 10), Block.box(5, 5, 5, 11, 16, 11), Block.box(5, 1, 5, 11, 16, 11), Block.box(4, 0, 4, 12, 16, 12)};
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);
    public ScorchkinStemBlock(Properties settings) {
        super(settings);
        this.registerDefaultState((this.stateDefinition.any()).setValue(AGE, 0).setValue(ATTACHED, false));
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return null;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) == 3 && state.getValue(ATTACHED).equals(true)) {
            return SHAPES[4];
        }
        return SHAPES[state.getValue(AGE)];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, ATTACHED);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.1f && checkForLava(world, pos)) {
            if (!isFullyGrown(state) && !state.getValue(ATTACHED)) {
                world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
            }
            if (isFullyGrown(state) && !state.getValue(ATTACHED)) {
                BlockPos SCORCHKINPos = pos.relative(Direction.DOWN);
                if ((world.getBlockState(SCORCHKINPos).isAir() || world.getBlockState(SCORCHKINPos).is(Blocks.LAVA) && isFullyGrown(state))) {
                    world.setBlock(SCORCHKINPos, BFBlocks.SCORCHKIN.get().defaultBlockState(), 2);
                    world.setBlockAndUpdate(pos, this.withPropertiesOf(state).setValue(ATTACHED, true));
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

    public boolean checkForLava(ServerLevel world, BlockPos pos) {
        BlockPos iPos = pos.below();
        while (!world.getBlockState(iPos).getFluidState().is(FluidTags.LAVA)) {
            if (world.getBlockState(iPos).isRedstoneConductor(world, pos)) {
                return false;
            }
            iPos = iPos.below();
        }
        return true;
    }
    public boolean shouldPropagatePrismarine(ServerLevel world, BlockPos pos) {
        return world.getBlockState(pos.below()).is(Blocks.SEA_LANTERN);
    }

    protected static boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) == 3;
    }

    protected boolean canPlantOnTop(BlockGetter world, BlockPos pos) {
        return world.getBlockState(pos.above()).isFaceSturdy(world, pos, Direction.DOWN);
    }
    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return this.canPlantOnTop(world, pos);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(ATTACHED) && !world.getBlockState(pos.below()).is(BFBlocks.SCORCHKIN.get())) {
            if (state.getValue(AGE) == 3)
                return state.setValue(ATTACHED, false);
        }
        return !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : state;
    }
}
