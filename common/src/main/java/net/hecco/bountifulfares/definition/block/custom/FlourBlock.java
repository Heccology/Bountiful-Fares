package net.hecco.bountifulfares.definition.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class FlourBlock extends FallingBlock {
    public FlourBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void spawnDestroyParticles(Level level, Player player, BlockPos pos, BlockState state) {
        for (int i = 0; i < level.random.nextIntBetweenInclusive(10, 20); i++) {
            float x = pos.getX() + (level.random.nextFloat() - 0.5f);
            float y = pos.getY() + (level.random.nextFloat() - 0.5f);
            float z = pos.getZ() + (level.random.nextFloat() - 0.5f);
            level.addParticle(BFParticles.FLOUR_CLOUD.get(), x, y, z, (x - pos.getX()) / 4, Math.abs(y - pos.getY()) / 4, (z - pos.getZ()) / 4);
        }
        super.spawnDestroyParticles(level, player, pos, state);
    }

    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        for (int i = 0; i < player.level().random.nextIntBetweenInclusive(1, 3); i++) {
            float x = pos.getX() + (player.level().random.nextFloat() - 0.5f);
            float y = pos.getY() + (player.level().random.nextFloat() - 0.5f);
            float z = pos.getZ() + (player.level().random.nextFloat() - 0.5f);
            player.level().addParticle(BFParticles.FLOUR_CLOUD.get(), x, y, z, (x - pos.getX()) / 4, Math.abs(y - pos.getY()) / 4, (z - pos.getZ()) / 4);
        }
        return super.getDestroyProgress(state, player, level, pos);
    }

    @Override
    protected void onExplosionHit(BlockState state, Level level, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> dropConsumer) {
        for (int i = 0; i < level.random.nextIntBetweenInclusive(50, 100); i++) {
            float x = pos.getX() + (level.random.nextFloat() - 0.5f);
            float y = pos.getY() + (level.random.nextFloat() - 0.5f);
            float z = pos.getZ() + (level.random.nextFloat() - 0.5f);
            level.addParticle(BFParticles.FLOUR_CLOUD.get(), x, y, z, (x - pos.getX()) / 2, Math.abs(y - pos.getY()) / 2, (z - pos.getZ()) / 2);
        }
        super.onExplosionHit(state, level, pos, explosion, dropConsumer);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return null;
    }
}
