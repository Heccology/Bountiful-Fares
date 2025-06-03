package net.hecco.bountifulfares.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;

public class GrassyDirtBlock extends Block implements BonemealableBlock {
    public GrassyDirtBlock(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        world.setBlockAndUpdate(pos, Blocks.GRASS_BLOCK.defaultBlockState());
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.above();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.is(Blocks.SNOW) && blockState.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockState.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(world, state, pos, blockState, blockPos, Direction.UP, blockState.getLightBlock(world, blockPos));
            return i < world.getMaxLightLevel();
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!canSurvive(state, world, pos)) {
                world.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
        }
    }
}
