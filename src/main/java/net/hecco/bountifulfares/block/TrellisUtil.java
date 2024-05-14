package net.hecco.bountifulfares.block;

import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.minecraft.block.Block;

public class TrellisUtil {
    public static Block getTrellisFromVariant(TrellisVariant variant) {
        return TrellisVariants.TRELLISES.get(variant.getTrellisName());
    }

    public static Block getCropTrellisFromVariant(TrellisVariant variant, VineCrop crop) {
        return TrellisVariants.CROP_TRELLISES.get(crop.getName() + variant.getTrellisName());
    }

    public static Block getDecorTrellisFromVariant(TrellisVariant variant, DecorativeVine vine) {
        return TrellisVariants.DECORATIVE_TRELLISES.get(vine.getName() + variant.getTrellisName());
    }
}
