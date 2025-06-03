package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
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
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
