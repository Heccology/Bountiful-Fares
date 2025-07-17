package net.hecco.bountifulfares.datagen.dye_depot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.DYE_DEPOT_MOD_ID;
import static net.minecraft.data.recipes.RecipeBuilder.getDefaultRecipeId;

public class DyeDepotRecipeProvider extends FabricRecipeProvider {
    public DyeDepotRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.MAROON_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "maroon_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.ROSE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "rose_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.CORAL_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "coral_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.GINGER_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "ginger_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.TAN_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "tan_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.BEIGE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "beige_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.AMBER_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "amber_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.OLIVE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "olive_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.FOREST_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "forest_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.VERDANT_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "verdant_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.TEAL_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "teal_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.MINT_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "mint_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.AQUA_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "aqua_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.SLATE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "slate_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.NAVY_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "navy_wool")));
        offerJackOStrawRecipes(exporter, DyeDepotBlocks.INDIGO_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DYE_DEPOT_MOD_ID, "indigo_wool")));
    }

    public static void offerJackOStrawRecipes(RecipeOutput exporter, ItemLike output, ItemLike wool) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
                .requires(BFItems.SUN_HAT)
                .requires(Items.CARVED_PUMPKIN)
                .requires(wool)
                .requires(Items.STICK)
                .unlockedBy(getHasName(wool), has(wool))
                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                .unlockedBy(getHasName(BFItems.SUN_HAT), has(BFItems.SUN_HAT))
                .unlockedBy("has_wool", has(wool))
                .save(exporter, getDefaultRecipeId(output) + "_with_carved_pumpkin");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
                .requires(BFItems.SUN_HAT)
                .requires(Items.PUMPKIN)
                .requires(wool)
                .requires(Items.STICK)
                .unlockedBy(getHasName(wool), has(wool))
                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                .unlockedBy(getHasName(BFItems.SUN_HAT), has(BFItems.SUN_HAT))
                .unlockedBy("has_wool", has(wool))
                .save(exporter, getDefaultRecipeId(output) + "_with_pumpkin");
    }
}
