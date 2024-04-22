package net.hecco.bountifulfares.painting;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {
    public static PaintingVariant BOUNTIFUL;

    private static void registerBountifulPainting() {
        if (BountifulFares.CONFIG.isEnableBountifulPainting()) {
            BOUNTIFUL = registerPainting("bountiful", new PaintingVariant(16, 16));
        }
    }

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(BountifulFares.MOD_ID, name), paintingVariant);
    }
    public static void registerPaintings() {
        registerBountifulPainting();
    }
}
