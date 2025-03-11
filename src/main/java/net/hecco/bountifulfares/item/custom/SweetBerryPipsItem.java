package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class SweetBerryPipsItem extends AliasedBlockItem {
    public SweetBerryPipsItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.CONFIG.enableSweetBerryPips;
    }
}
