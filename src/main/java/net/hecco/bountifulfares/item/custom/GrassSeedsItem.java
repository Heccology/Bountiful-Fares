package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class GrassSeedsItem extends Item {
    public GrassSeedsItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        if (world.getBlockState(pos).isIn(BFBlockTags.GRASS_SEEDS_PLANTABLE_ON) && !world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos.up(), Direction.UP)) {
            world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
            world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            for (int i = 0; i < 16; i++) {
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 0.5) + 0.8, (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
            }
            if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                stack.decrement(1);
            }
            return ActionResult.success(true);
        }  else if (world.getBlockState(pos).isOf(Blocks.GRASS_BLOCK) && context.getSide() == Direction.UP && world.getBlockState(pos.up()).isAir()) {
            pos = pos.up();
            world.setBlockState(pos, Blocks.SHORT_GRASS.getDefaultState());
            world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            for (int i = 0; i < 16; i++) {
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 0.5) + 0.8, (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
            }
            if (context.getPlayer() != null && !context.getPlayer().isCreative()) {
                stack.decrement(1);
            }
            return ActionResult.success(true);
        }
        return super.useOnBlock(context);
    }
}
