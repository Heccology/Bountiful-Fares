package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class GrassSeedsItem extends Item {
    public GrassSeedsItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        ItemStack stack = context.getItemInHand();
        if (world.getBlockState(pos).is(BFBlockTags.GRASS_SEEDS_PLANTABLE_ON) && !world.getBlockState(pos.above()).isFaceSturdy(world, pos.above(), Direction.UP)) {
            world.setBlockAndUpdate(pos, Blocks.GRASS_BLOCK.defaultBlockState());
            world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            for (int i = 0; i < 16; i++) {
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 0.5) + 0.8, (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
            }
            if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(true);
        }  else if (world.getBlockState(pos).is(Blocks.GRASS_BLOCK) && context.getClickedFace() == Direction.UP && world.getBlockState(pos.above()).isAir()) {
            pos = pos.above();
            world.setBlockAndUpdate(pos, Blocks.SHORT_GRASS.defaultBlockState());
            world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            for (int i = 0; i < 16; i++) {
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 0.5) + 0.8, (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
            }
            if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(true);
        }
        return super.useOn(context);
    }
}
