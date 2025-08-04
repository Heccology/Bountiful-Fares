package net.hecco.bountifulfares.definition.compat.block;

import net.hecco.bountifulfares.definition.block.custom.PicketsBlock;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.flag.FeatureFlagSet;

public class CompatPicketsBlock extends PicketsBlock {
    private final String modId;
    public CompatPicketsBlock(String modId, Properties settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return HLServices.PLATFORM.isModLoaded(modId) || HLServices.PLATFORM.isDatagen();
    }
}
