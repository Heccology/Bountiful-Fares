package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;

public class BFModelLayers {
    public static final ModelLayerLocation HOARY_SIGN = ModelLayers.createSignModelName(BFWoodTypes.HOARY);
    public static final ModelLayerLocation HOARY_HANGING_SIGN = ModelLayers.createHangingSignModelName(BFWoodTypes.HOARY);
    public static final ModelLayerLocation WALNUT_SIGN = ModelLayers.createSignModelName(BFWoodTypes.WALNUT);
    public static final ModelLayerLocation WALNUT_HANGING_SIGN = ModelLayers.createHangingSignModelName(BFWoodTypes.WALNUT);
    public static final ModelLayerLocation CERAMIC_CHEST = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "ceramic_chest"), "main");
    public static final ModelLayerLocation CERAMIC_DOUBLE_CHEST_LEFT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "ceramic_double_chest_left"), "main");
    public static final ModelLayerLocation CERAMIC_DOUBLE_CHEST_RIGHT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "ceramic_double_chest_right"), "main");
    public static final ModelLayerLocation TRELLIS_DEFAULT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "trellis_default"), "main");
    public static final ModelLayerLocation TRELLIS_INVERTED = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "trellis_inverted"), "main");
}