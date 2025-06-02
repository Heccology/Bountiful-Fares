package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.JackOStrawBlock;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CompatJackOStrawBlock extends JackOStrawBlock {
    private final String modId;
    public CompatJackOStrawBlock(String modId, BlockBehaviour.Properties settings) {
        super(settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
