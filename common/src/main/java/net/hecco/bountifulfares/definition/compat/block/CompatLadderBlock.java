package net.hecco.bountifulfares.definition.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.LadderBlock;

public class CompatLadderBlock extends LadderBlock {
    private final String modId;
    public CompatLadderBlock(String modId, Properties settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return HLServices.PLATFORM.isModLoaded(modId) || HLServices.PLATFORM.isDatagen();
    }
}
