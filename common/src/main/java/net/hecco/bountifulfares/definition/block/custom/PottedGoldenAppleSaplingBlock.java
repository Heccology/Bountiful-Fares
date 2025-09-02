package net.hecco.bountifulfares.definition.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PottedGoldenAppleSaplingBlock extends FlowerPotBlock {
    public PottedGoldenAppleSaplingBlock(Block potted, Properties properties) {
        super(potted, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        GoldenAppleSaplingBlock.playAmbiance(level, pos, random);
        super.animateTick(state, level, pos, random);
    }
}
