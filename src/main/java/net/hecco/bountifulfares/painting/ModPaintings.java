package net.hecco.bountifulfares.painting;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {

    public static PaintingVariant BOUNTIFUL;
//    public static final PaintingVariant SPONGE_HOUSE = register("sponge_house", new PaintingVariant(32, 32));
    public static PaintingVariant CITRUS_DISH;
//    public static final PaintingVariant MULCHER = register("mulcher", new PaintingVariant(16, 16));
    public static PaintingVariant RUMINER;
    public static PaintingVariant VIOLET_FLORET;
    public static PaintingVariant PHYLOGENESIS;
    public static PaintingVariant AQUACULTURE;
    public static PaintingVariant UNPLEASANT_TILES;
    private static PaintingVariant register(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(BountifulFares.MOD_ID, name), paintingVariant);
    }
    public static void registerPaintings() {
        if (BountifulFares.CONFIG.isEnableBountifulPainting()) {
            BOUNTIFUL = register("bountiful", new PaintingVariant(16, 16));
        }
        if (BountifulFares.CONFIG.isEnableCitrusDishPainting()) {
            CITRUS_DISH = register("citrus_dish", new PaintingVariant(16, 16));
        }
        if (BountifulFares.CONFIG.isEnableRuminerPainting()) {
            RUMINER = register("ruminer", new PaintingVariant(16, 32));
        }
        if (BountifulFares.CONFIG.isEnableVioletFloretPainting()) {
            VIOLET_FLORET = register("violet_floret", new PaintingVariant(16, 16));
        }
        if (BountifulFares.CONFIG.isEnablePhylogenesisPainting()) {
            PHYLOGENESIS = register("phylogenesis", new PaintingVariant(48, 16));
        }
        if (BountifulFares.CONFIG.isEnableAquaculturePainting()) {
            AQUACULTURE = register("aquaculture", new PaintingVariant(32, 32));
        }
        if (BountifulFares.CONFIG.isEnableUnpleasantTilesPainting()) {
            UNPLEASANT_TILES = register("unpleasant_tiles", new PaintingVariant(32, 48));
        }
    }
}
