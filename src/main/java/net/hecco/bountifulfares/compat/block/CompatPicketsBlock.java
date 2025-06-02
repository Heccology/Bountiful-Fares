package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.minecraft.world.flag.FeatureFlagSet;

public class CompatPicketsBlock extends PicketsBlock {
    private final String modId;
    public CompatPicketsBlock(String modId, Properties settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
