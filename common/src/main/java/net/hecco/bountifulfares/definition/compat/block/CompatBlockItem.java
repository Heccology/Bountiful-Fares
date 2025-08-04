package net.hecco.bountifulfares.definition.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class CompatBlockItem extends BlockItem {
    private final String modId;
    public CompatBlockItem(String modId, Block block, Properties settings) {
        super(block, settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return HLServices.PLATFORM.isModLoaded(modId) || HLServices.PLATFORM.isDatagen();
    }
}
