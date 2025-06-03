package net.hecco.bountifulfares.recipe;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

import java.util.function.Function;

@SuppressWarnings("unchecked")
public class BFSpecialRecipes {

    public static final RecipeSerializer<CeramicMassDyeingRecipe> CERAMIC_MASS_DYEING = (RecipeSerializer<CeramicMassDyeingRecipe>)
            registerSpecialRecipe("ceramic_mass_dyeing", CeramicMassDyeingRecipe::new);

    public static void registerSpecialRecipes() {
    }

    private static RecipeSerializer<? extends CustomRecipe> registerSpecialRecipe(String name, Function<CraftingBookCategory, CustomRecipe> toRecipe){
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name),
                new SimpleCraftingRecipeSerializer<>(toRecipe::apply));
    }
}
