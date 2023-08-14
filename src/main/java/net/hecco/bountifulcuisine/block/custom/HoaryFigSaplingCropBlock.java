package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class HoaryFigSaplingCropBlock extends CropBlock {
    public HoaryFigSaplingCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.HOARY_SEEDS;
    }
}
