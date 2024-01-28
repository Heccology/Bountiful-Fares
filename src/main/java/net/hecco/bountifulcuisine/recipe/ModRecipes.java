package net.hecco.bountifulcuisine.recipe;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(BountifulCuisine.MOD_ID, MillingRecipe.Serializer.ID), MillingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(BountifulCuisine.MOD_ID, MillingRecipe.Type.ID), MillingRecipe.Type.INSTANCE);
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(BountifulCuisine.MOD_ID, FermentationRecipe.Serializer.ID), FermentationRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(BountifulCuisine.MOD_ID, FermentationRecipe.Type.ID), FermentationRecipe.Type.INSTANCE);
    }
}
