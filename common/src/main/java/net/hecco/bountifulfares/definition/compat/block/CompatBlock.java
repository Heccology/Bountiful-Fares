package net.hecco.bountifulfares.definition.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class CompatBlock extends Block {
    private final String modId;
    public CompatBlock(String modId, Properties settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return HLServices.PLATFORM.isModLoaded(modId) || HLServices.PLATFORM.isDatagen();
    }
}
