package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class GoldenAppleLeavesBlock extends LeavesBlock {

    public GoldenAppleLeavesBlock(Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if (random.nextInt(16) == 0) {
            if (!isFaceFullSquare(world.getBlockState(pos.down()).getCollisionShape(world, pos.down()), Direction.UP)) {
                ParticleUtil.spawnParticle(world, pos, random, BFParticles.GOLDEN_PETAL);
            }
        }
    }

}
