package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class EatenHoaryAppleBlock extends EatenFruitBlock {
    public EatenHoaryAppleBlock(Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.HOARY_APPLE);
    }
}
