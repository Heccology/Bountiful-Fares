package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ChamomileFlowersBlock extends PinkPetalsBlock implements BonemealableBlock {
    public ChamomileFlowersBlock(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.below()).getBlock() instanceof FarmBlock;
    }

    // Unnecessary - `isFertilizable` will make sure the super method can only run on Farmland anyway. - Artyrian
    //@Override
    //public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
    //    int i = state.get(FLOWER_AMOUNT);
    //    if (i < 4 || world.getBlockState(pos.down()).isOf(Blocks.FARMLAND))
    //    {
    //        world.setBlockState(pos, state.cycle(FLOWER_AMOUNT), Block.NOTIFY_LISTENERS);
    //    }
    //}
}
