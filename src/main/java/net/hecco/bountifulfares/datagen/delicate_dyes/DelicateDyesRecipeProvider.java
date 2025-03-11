package net.hecco.bountifulfares.datagen.delicate_dyes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
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

import static net.hecco.bountifulfares.BountifulFares.DELICATE_DYES_MOD_ID;
import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

public class DelicateDyesRecipeProvider extends FabricRecipeProvider {
    public DelicateDyesRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.CORAL_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DELICATE_DYES_MOD_ID, "coral_wool")));
        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.CANARY_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DELICATE_DYES_MOD_ID, "canary_wool")));
        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.WASABI_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DELICATE_DYES_MOD_ID, "wasabi_wool")));
        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DELICATE_DYES_MOD_ID, "sacramento_wool")));
        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.SKY_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DELICATE_DYES_MOD_ID, "sky_wool")));
        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.BLURPLE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DELICATE_DYES_MOD_ID, "blurple_wool")));
        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.SANGRIA_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DELICATE_DYES_MOD_ID, "sangria_wool")));
        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.ROSE_JACK_O_STRAW, Registries.ITEM.get(Identifier.of(DELICATE_DYES_MOD_ID, "rose_wool")));
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
