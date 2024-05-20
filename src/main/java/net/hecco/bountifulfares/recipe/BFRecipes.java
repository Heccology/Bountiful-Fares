package net.hecco.bountifulfares.recipe;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BFRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(BountifulFares.MOD_ID, MillingRecipe.Serializer.ID), MillingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(BountifulFares.MOD_ID, MillingRecipe.Type.ID), MillingRecipe.Type.INSTANCE);
    }
}
