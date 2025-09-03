package net.hecco.bountifulfares.definition.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;

public class SweetBerryPipsItem extends ItemNameBlockItem {
    public SweetBerryPipsItem(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return Services.PLATFORM.getBoolConfigValue("enableSweetBerryPips");
    }
}
