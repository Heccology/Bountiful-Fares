package net.hecco.bountifulfares.definition.recipe;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.*;

import java.util.function.Function;
import java.util.function.Supplier;

public class BFSpecialRecipes {

    public static final Supplier<RecipeSerializer<?>> CERAMIC_MASS_DYEING = registerSpecialRecipe("ceramic_mass_dyeing", CeramicMassDyeingRecipe::new);

    public static void registerSpecialRecipes() {
    }

    private static Supplier<RecipeSerializer<?>> registerSpecialRecipe(String name, Function<CraftingBookCategory, CustomRecipe> toRecipe){
        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, name, BuiltInRegistries.RECIPE_SERIALIZER, () -> new SimpleCraftingRecipeSerializer<>(toRecipe::apply));
    }
} //TODO: FIX
