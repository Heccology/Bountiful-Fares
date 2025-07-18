package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GoldenAppleLeavesBlock extends LeavesBlock {

    public GoldenAppleLeavesBlock(Properties settings) {
        super(settings);
    }

    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        super.animateTick(state, world, pos, random);
        if (random.nextInt(16) == 0) {
            if (!isFaceFull(world.getBlockState(pos.below()).getCollisionShape(world, pos.below()), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(world, pos, random, (ParticleOptions) BFParticles.GOLDEN_PETAL.get());
            }
        }
    }

}
