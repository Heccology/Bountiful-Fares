package net.hecco.bountifulcuisine.recipe;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(BountifulCuisine.MOD_ID, QuernStoneRecipe.Serializer.ID), QuernStoneRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(BountifulCuisine.MOD_ID, QuernStoneRecipe.Type.ID), QuernStoneRecipe.Type.INSTANCE);
    }
}
