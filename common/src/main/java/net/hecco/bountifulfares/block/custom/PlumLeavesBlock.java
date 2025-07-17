package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PlumLeavesBlock extends LeavesBlock implements BonemealableBlock {

    public PlumLeavesBlock(Block fruit, Properties settings) {
        super(settings);
    }
    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.below()).isAir();
    }
    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }
    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        world.setBlock(pos.below(), BFBlocks.HANGING_PLUM.get().defaultBlockState(), 2);
    }
}
