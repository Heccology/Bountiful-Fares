package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.TrellisBlock;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatTrellisBlock extends TrellisBlock {
    private final String modId;
    public CompatTrellisBlock(String modId, TrellisVariant variant, Settings settings) {
        super(variant, settings);
        this.modId = modId;
    }
    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
