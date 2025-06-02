package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.SlabBlock;

public class CompatSlabBlock extends SlabBlock {
    private final String modId;
    public CompatSlabBlock(String modId,Properties settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
