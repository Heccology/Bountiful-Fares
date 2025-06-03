package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class BFRecipes {
    public static final RecipeType<MillingRecipe> MILLING = register("milling");
    public static final RecipeType<FermentationRecipe> FERMENTING = register("fermenting");

    public static <T extends Recipe<?>> RecipeType<T> register(final String id) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, id), new RecipeType<T>(){
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
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, id), serializer);
    }

    public static void registerRecipes() {
    }
}
