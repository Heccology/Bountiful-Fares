package net.hecco.bountifulfares.compat.block;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.item.Item;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatCropTrellisBlock extends CropTrellisBlock {
    private final String modId;
    public CompatCropTrellisBlock(String modId, Item berryItem, TrellisVariant variant, VineCrop crop, Settings settings) {
        super(berryItem, variant, crop, settings);
        this.modId = modId;
    }

    public CompatCropTrellisBlock(String modId, int harvestResetAge, String berryItemID, TrellisVariant variant, VineCrop crop, Settings settings) {
        super(harvestResetAge, berryItemID, variant, crop, settings);
        this.modId = modId;
    }
    public CompatCropTrellisBlock(String modId, Item seedsItem, Item berryItem, TrellisVariant variant, VineCrop crop, Settings settings) {
        super(seedsItem, berryItem, variant, crop, settings);
        this.modId = modId;
    }
    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.isModLoaded(modId) || BountifulFares.isDatagen();
    }
}
