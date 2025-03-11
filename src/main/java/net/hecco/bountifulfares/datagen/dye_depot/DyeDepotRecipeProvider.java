package net.hecco.bountifulfares.datagen.dye_depot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.DYE_DEPOT_MOD_ID;
import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

public class DyeDepotRecipeProvider extends FabricRecipeProvider {
    public DyeDepotRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.MAROON_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "maroon_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.ROSE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "rose_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.CORAL_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "coral_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.GINGER_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "ginger_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.TAN_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "tan_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.BEIGE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "beige_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.AMBER_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "amber_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.OLIVE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "olive_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.FOREST_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "forest_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.VERDANT_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "verdant_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.TEAL_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "teal_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.MINT_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "mint_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.AQUA_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "aqua_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.SLATE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "slate_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.NAVY_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "navy_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.INDIGO_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DYE_DEPOT_MOD_ID, "indigo_wool")));
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
