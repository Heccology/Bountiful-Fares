package net.hecco.bountifulfares.definition.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;

public class CompatStairsBlock extends StairBlock {
    private final String modId;
    public CompatStairsBlock(String modId, Block base, Properties settings) {
        super(base.defaultBlockState(), settings);
        this.modId = modId;
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return HLServices.PLATFORM.isModLoaded(modId) || HLServices.PLATFORM.isDatagen();
    }
}
