package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class BFRecipes {
    public static final RecipeType<MillingRecipe> MILLING = register("milling");
    public static final RecipeType<FermentationRecipe> FERMENTING = register("fermenting");

    public static <T extends Recipe<?>> RecipeType<T> register(final String id) {
//        return Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, id), new RecipeType<T>(){
//            public String toString() {
//                return id;
//            }
//        });
        return null; //TODO: FIX
    }

    public static final Supplier<RecipeSerializer<MillingRecipe>> MILLING_SERIALIZER = registerSerializer("milling",
            () -> new MillingRecipe.Serializer(MillingRecipe::new));

    public static final Supplier<RecipeSerializer<FermentationRecipe>> FERMENTING_SERIALIZER = registerSerializer("fermenting",
            () -> new FermentationRecipe.Serializer(FermentationRecipe::new));

    @SuppressWarnings("unchecked")
    public static <S extends RecipeSerializer<?>> Supplier<S> registerSerializer(String id, Supplier<S> serializer) {
//        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, id, (net.minecraft.resources.ResourceKey<? extends Registry<S>>) BuiltInRegistries.RECIPE_SERIALIZER.key(), serializer);
        return null; //TODO: FIX
    }

    public static void registerRecipes() {
    }
}
