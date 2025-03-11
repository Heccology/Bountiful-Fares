package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.JackOStrawBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatJackOStrawBlock extends JackOStrawBlock {
    private final String modId;
    public CompatJackOStrawBlock(String modId, AbstractBlock.Settings settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
