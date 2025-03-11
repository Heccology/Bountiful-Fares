package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.LadderBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatLadderBlock extends LadderBlock {
    private final String modId;
    public CompatLadderBlock(String modId, Settings settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
