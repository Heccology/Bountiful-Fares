package net.hecco.bountifulfares.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
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
        if (world.getBlockState(pos).isOf(Blocks.DIRT) && world.getBlockState(pos.up()).isAir()) {
            world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
            world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            BoneMealItem.createParticles(world, pos, 0);
            return ActionResult.success(true);
        }
        return super.useOnBlock(context);
    }
}