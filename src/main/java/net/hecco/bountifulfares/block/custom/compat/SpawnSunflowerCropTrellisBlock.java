package net.hecco.bountifulfares.block.custom.compat;

import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.item.Item;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class SpawnSunflowerCropTrellisBlock extends CropTrellisBlock {
    public static final IntProperty AGE = Properties.AGE_3;
    public SpawnSunflowerCropTrellisBlock(Item seedsItem, Item berryItem, TrellisVariant variant, VineCrop crop, Settings settings) {
        super(seedsItem, berryItem, variant, crop, settings);
    }
}
