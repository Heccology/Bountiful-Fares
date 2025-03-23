package net.hecco.bountifulfares.recipe;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Function;

@SuppressWarnings("unchecked")
public class BFSpecialRecipes {

    public static final RecipeSerializer<CeramicMassDyeingRecipe> CERAMIC_MASS_DYEING = (RecipeSerializer<CeramicMassDyeingRecipe>)
            registerSpecialRecipe("ceramic_mass_dyeing", CeramicMassDyeingRecipe::new);

    public static void registerSpecialRecipes() {
    }

    private static RecipeSerializer<? extends SpecialCraftingRecipe> registerSpecialRecipe(String name, Function<CraftingRecipeCategory, SpecialCraftingRecipe> toRecipe){
        return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(BountifulFares.MOD_ID, name),
                new SpecialRecipeSerializer<>(toRecipe::apply));
    }
}
