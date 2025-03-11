package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatStairsBlock extends StairsBlock {
    private final String modId;
    public CompatStairsBlock(String modId, Block base, Settings settings) {
        super(base.getDefaultState(), settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
