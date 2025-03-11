package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BFRecipes {
    public static final RecipeType<MillingRecipe> MILLING = register("milling");
    public static final RecipeType<FermentationRecipe> FERMENTING = register("fermenting");

    public static <T extends Recipe<?>> RecipeType<T> register(final String id) {
        return Registry.register(Registries.RECIPE_TYPE, Identifier.of(BountifulFares.MOD_ID, id), new RecipeType<T>(){
            public String toString() {
                return id;
            }
        });
    }

    public static final RecipeSerializer<MillingRecipe> MILLING_SERIALIZER = registerSerializer("milling",
            new MillingRecipe.Serializer(MillingRecipe::new));

    public static final RecipeSerializer<FermentationRecipe> FERMENTING_SERIALIZER = registerSerializer("fermenting",
            new FermentationRecipe.Serializer(FermentationRecipe::new));

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerSerializer(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(BountifulFares.MOD_ID, id), serializer);
    }

    public static void registerRecipes() {
    }
}
