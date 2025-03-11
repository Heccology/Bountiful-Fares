package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.DecorativeTrellisBlock;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.item.Item;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatDecorativeTrellisBlock extends DecorativeTrellisBlock {
    private final String modId;
    public CompatDecorativeTrellisBlock(String modId, boolean canDuplicate, Item item, TrellisVariant variant, DecorativeVine vine, Settings settings) {
        super(canDuplicate, item, variant, vine, settings);
        this.modId = modId;
    }
    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
