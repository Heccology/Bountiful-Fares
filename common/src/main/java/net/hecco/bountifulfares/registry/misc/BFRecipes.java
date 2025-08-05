package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.recipe.*;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;

import java.util.function.Function;
import java.util.function.Supplier;

public class BFRecipes {
    public static final Supplier<RecipeType<MillingRecipe>> MILLING = register("milling_recipe");
    public static final Supplier<RecipeType<FermentationRecipe>> FERMENTING = register("fermenting_recipe");

    public static <T extends Recipe<?>> Supplier<RecipeType<T>> register(String id) {
        return HLServices.REGISTRY.registerRecipeType(BountifulFares.MOD_ID, id);
    }

    public static final Supplier<RecipeSerializer<MillingRecipe>> MILLING_SERIALIZER = registerSerializer("milling",
            new MillingRecipe.Serializer(MillingRecipe::new));

    public static final Supplier<RecipeSerializer<FermentationRecipe>> FERMENTING_SERIALIZER = registerSerializer("fermenting",
            new FermentationRecipe.Serializer(FermentationRecipe::new));

    @SuppressWarnings("unchecked")
    public static <T extends Recipe<?>> Supplier<RecipeSerializer<T>> registerSerializer(String id, RecipeSerializer<?> serializer) {
        return HLServices.REGISTRY.registerRecipeSerializer(BountifulFares.MOD_ID, id, (RecipeSerializer<T>) serializer);
    }

    public static final Supplier<RecipeSerializer<?>> CERAMIC_MASS_DYEING = registerSpecialRecipe("ceramic_mass_dyeing", CeramicMassDyeingRecipe::new);
    public static final Supplier<RecipeSerializer<?>> TIFFIN_COLORING = registerSpecialRecipe("tiffin_coloring", TiffinColoringRecipe::new);
    public static final Supplier<RecipeSerializer<?>> TIFFIN_FOOD_CRAFTING = registerSpecialRecipe("tiffin_food_crafting", TiffinFoodCraftingRecipe::new);

    private static Supplier<RecipeSerializer<?>> registerSpecialRecipe(String name, Function<CraftingBookCategory, CustomRecipe> toRecipe){
        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, name, BuiltInRegistries.RECIPE_SERIALIZER, () -> new SimpleCraftingRecipeSerializer<>(toRecipe::apply));
    }

    public static void registerRecipes() {
    }
}
