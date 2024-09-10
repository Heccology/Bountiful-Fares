package net.hecco.bountifulfares.recipe;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.recipe.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BFRecipes {
    public static final RecipeType<Recipe<?>> MILLING = register("milling");
    public static <T extends Recipe<?>> RecipeType<T> register(final String id) {
        return Registry.register(Registries.RECIPE_TYPE, Identifier.of(BountifulFares.MOD_ID, id), new RecipeType<T>(){
            public String toString() {
                return id;
            }
        });
    }

    public static final RecipeSerializer<MillingRecipe> MILLING_SERIALIZER = registerSerializer("milling", new MillingRecipe.Serializer());
    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerSerializer(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, id, serializer);
    }
    public static void registerRecipes() {
    }
}
