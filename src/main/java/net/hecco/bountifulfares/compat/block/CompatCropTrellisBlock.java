package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;

public class CompatCropTrellisBlock extends CropTrellisBlock {
    private final String modId;
    public CompatCropTrellisBlock(String modId, Item berryItem, TrellisVariant variant, VineCrop crop, Properties settings) {
        super(berryItem, variant, crop, settings);
        this.modId = modId;
    }

    public CompatCropTrellisBlock(String modId, int harvestResetAge, String berryItemID, TrellisVariant variant, VineCrop crop, Properties settings) {
        super(harvestResetAge, berryItemID, variant, crop, settings);
        this.modId = modId;
    }
    public CompatCropTrellisBlock(String modId, Item seedsItem, Item berryItem, TrellisVariant variant, VineCrop crop, Properties settings) {
        super(seedsItem, berryItem, variant, crop, settings);
        this.modId = modId;
    }
    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
