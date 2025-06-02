package net.hecco.bountifulfares.block.custom.compat;

import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class SpawnSunflowerCropTrellisBlock extends CropTrellisBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public SpawnSunflowerCropTrellisBlock(Item seedsItem, Item berryItem, TrellisVariant variant, VineCrop crop, Properties settings) {
        super(seedsItem, berryItem, variant, crop, settings);
    }
}
