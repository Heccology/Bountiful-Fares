package net.hecco.bountifulfares.datagen.mint;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.ELS_AND_LS_DYES_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;
import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

public class MintRecipeProvider extends FabricRecipeProvider {
    public MintRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerJackOStrawRecipes(exporter, MintBlocks.ACORN_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "acorn_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.MAROON_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "maroon_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.PEACH_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "peach_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.VERMILION_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "vermilion_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.AMBER_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "amber_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.BANANA_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "banana_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.ARTICHOKE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "artichoke_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.MOLD_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "mold_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.SAGE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "sage_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.SAP_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "sap_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.SHAMROCK_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "shamrock_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.MINT_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "mint_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.CERULEAN_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "cerulean_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.NAVY_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "navy_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.PERIWINKLE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "periwinkle_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.GRAPE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "grape_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.INDIGO_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "indigo_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.MAUVE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "mauve_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.VELVET_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "velvet_wool")));
        offerJackOStrawRecipes(exporter, MintBlocks.FUCHSIA_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(ELS_AND_LS_DYES_MOD_ID, "fuchsia_wool")));

        TrellisUtil.registerCompatTrellisRecipe(exporter, MintBlocks.WINTERGREEN);
        offerPicketsRecipe(exporter, MintBlocks.WINTERGREEN_PICKETS, Identifier.of(ELS_AND_LS_DYES_MOD_ID, "wintergreen_planks"));
    }

    public static void offerJackOStrawRecipes(RecipeExporter exporter, ItemConvertible output, ItemConvertible wool) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(BFItems.SUN_HAT)
                .input(Items.CARVED_PUMPKIN)
                .input(wool)
                .input(Items.STICK)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .criterion(hasItem(Items.CARVED_PUMPKIN), conditionsFromItem(Items.CARVED_PUMPKIN))
                .criterion(hasItem(BFItems.SUN_HAT), conditionsFromItem(BFItems.SUN_HAT))
                .criterion("has_wool", conditionsFromItem(wool))
                .offerTo(exporter, getItemId(output) + "_with_carved_pumpkin");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(BFItems.SUN_HAT)
                .input(Items.PUMPKIN)
                .input(wool)
                .input(Items.STICK)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .criterion(hasItem(Items.CARVED_PUMPKIN), conditionsFromItem(Items.CARVED_PUMPKIN))
                .criterion(hasItem(BFItems.SUN_HAT), conditionsFromItem(BFItems.SUN_HAT))
                .criterion("has_wool", conditionsFromItem(wool))
                .offerTo(exporter, getItemId(output) + "_with_pumpkin");
    }
}
