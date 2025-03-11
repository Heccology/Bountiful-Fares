package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.WallBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatWallBlock extends WallBlock {
    private final String modId;
    public CompatWallBlock(String modId, Settings settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
