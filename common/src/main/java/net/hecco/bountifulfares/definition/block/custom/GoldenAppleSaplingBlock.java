package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class GoldenAppleSaplingBlock extends SaplingBlock {
    public GoldenAppleSaplingBlock(TreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        playAmbiance(level, pos, random);
        super.animateTick(state, level, pos, random);
    }

    public static void playAmbiance(Level level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.25) {
            level.playLocalSound(pos.getX() + (double)0.5F, pos.getY() + (double)0.5F, pos.getZ() + (double)0.5F, BFSounds.GOLDEN_APPLE_SAPLING_AMBIENT.get(), SoundSource.BLOCKS, 5.0f, random.nextFloat(), false);
        }
    }
}
