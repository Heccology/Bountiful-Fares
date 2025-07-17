package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.TrellisBlock;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.flag.FeatureFlagSet;

public class CompatTrellisBlock extends TrellisBlock {
    private final String modId;
    public CompatTrellisBlock(String modId, TrellisVariant variant, Properties settings) {
        super(variant, settings);
        this.modId = modId;
    }
    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return HLServices.PLATFORM.isModLoaded(modId) || HLServices.PLATFORM.isDatagen();
    }
}
