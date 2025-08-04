//package net.hecco.bountifulfares.recipe;
//
//import net.hecco.bountifulfares.BountifulFares;
//import net.hecco.heccolib.platform.HLServices;
//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.crafting.CraftingBookCategory;
//import net.minecraft.world.item.crafting.CustomRecipe;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
//
//import java.util.function.Function;
//import java.util.function.Supplier;
//
//@SuppressWarnings("unchecked")
//public class BFSpecialRecipes {
//
//    public static final RecipeSerializer<CeramicMassDyeingRecipe> CERAMIC_MASS_DYEING = (RecipeSerializer<CeramicMassDyeingRecipe>)
//            registerSpecialRecipe("ceramic_mass_dyeing", CeramicMassDyeingRecipe::new);
//
//    public static void registerSpecialRecipes() {
//    }
//
//    private static Supplier<RecipeSerializer<? extends CustomRecipe>> registerSpecialRecipe(String name, Function<CraftingBookCategory, CustomRecipe> toRecipe){
//        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, name, (net.minecraft.resources.ResourceKey<? extends Registry<RecipeSerializer<? extends CustomRecipe>>>) BuiltInRegistries.RECIPE_SERIALIZER.key(), () -> new SimpleCraftingRecipeSerializer<>(toRecipe::apply));
//    }
//} TODO: FIX
