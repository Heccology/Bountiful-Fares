package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.util.ModBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GrassSeedsItem extends Item {
    public GrassSeedsItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        if (world.getBlockState(pos).isIn(ModBlockTags.GRASS_SEEDS_PLANTABLE_ON) && world.getBlockState(pos.up()).isAir()) {
            world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
            world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            for (int i = 0; i < 16; i++) {
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (pos.getX() - 0.2) + (world.random.nextFloat() * 1.4), pos.getY() + (world.random.nextFloat() * 0.5) + 0.8, (pos.getZ() - 0.2) + (world.random.nextFloat() * 1.4), (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8, (world.random.nextFloat() - 0.5) / 8);
            }
            return ActionResult.success(true);
        }
        return super.useOnBlock(context);
    }
}
