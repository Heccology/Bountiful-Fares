package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class LeekCropBlock extends CropBlock {
    public LeekCropBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.LEEK_SEEDS;
    }
}
