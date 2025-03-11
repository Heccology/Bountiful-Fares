package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.SlabBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatSlabBlock extends SlabBlock {
    private final String modId;
    public CompatSlabBlock(String modId,Settings settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
