package net.hecco.bountifulfares.datagen.mint;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class MintRecipeProvider extends FabricRecipeProvider {
    public MintRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
//        offerJackOStrawRecipes(exporter, MintBlocks.ACORN_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "acorn_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.MAROON_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "maroon_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.PEACH_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "peach_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.VERMILION_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "vermilion_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.AMBER_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "amber_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.BANANA_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "banana_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.ARTICHOKE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "artichoke_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.MOLD_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "mold_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.SAGE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "sage_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.SAP_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "sap_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.SHAMROCK_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "shamrock_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.MINT_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "mint_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.CERULEAN_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "cerulean_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.NAVY_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "navy_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.PERIWINKLE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "periwinkle_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.GRAPE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "grape_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.INDIGO_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "indigo_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.MAUVE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "mauve_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.VELVET_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "velvet_wool")));
//        offerJackOStrawRecipes(exporter, MintBlocks.FUCHSIA_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "fuchsia_wool")));
//
//        TrellisUtil.registerCompatTrellisRecipe(exporter, MintBlocks.WINTERGREEN);
//        offerPicketsRecipe(exporter, MintBlocks.WINTERGREEN_PICKETS, ResourceLocation.fromNamespaceAndPath(ELS_AND_LS_DYES_MOD_ID, "wintergreen_planks"));
    }

    public static void offerJackOStrawRecipes(RecipeOutput exporter, ItemLike output, ItemLike wool) {
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
//                .requires(BFItems.SUN_HAT)
//                .requires(Items.CARVED_PUMPKIN)
//                .requires(wool)
//                .requires(Items.STICK)
//                .unlockedBy(getHasName(wool), has(wool))
//                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
//                .unlockedBy(getHasName(BFItems.SUN_HAT), has(BFItems.SUN_HAT))
//                .unlockedBy("has_wool", has(wool))
//                .save(exporter, getDefaultRecipeId(output) + "_with_carved_pumpkin");
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
//                .requires(BFItems.SUN_HAT)
//                .requires(Items.PUMPKIN)
//                .requires(wool)
//                .requires(Items.STICK)
//                .unlockedBy(getHasName(wool), has(wool))
//                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
//                .unlockedBy(getHasName(BFItems.SUN_HAT), has(BFItems.SUN_HAT))
//                .unlockedBy("has_wool", has(wool))
//                .save(exporter, getDefaultRecipeId(output) + "_with_pumpkin");
    }
}
