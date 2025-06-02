package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class LeekCropBlock extends CropBlock {
    public LeekCropBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return BFItems.LEEK_SEEDS;
    }
}
