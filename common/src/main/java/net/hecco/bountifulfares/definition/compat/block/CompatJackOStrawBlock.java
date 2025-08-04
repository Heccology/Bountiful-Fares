package net.hecco.bountifulfares.definition.compat.block;

import net.hecco.bountifulfares.definition.block.custom.JackOStrawBlock;
import net.hecco.heccolib.platform.HLServices;
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
        return HLServices.PLATFORM.isModLoaded(modId) || HLServices.PLATFORM.isDatagen();
    }
}
