package net.hecco.bountifulfares.datagen.delicate_dyes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.RecipeBuilder.getDefaultRecipeId;

public class DelicateDyesRecipeProvider extends FabricRecipeProvider {
    public DelicateDyesRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
//        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.CORAL_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, "coral_wool")));
//        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.CANARY_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, "canary_wool")));
//        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.WASABI_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, "wasabi_wool")));
//        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, "sacramento_wool")));
//        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.SKY_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, "sky_wool")));
//        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.BLURPLE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, "blurple_wool")));
//        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.SANGRIA_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, "sangria_wool")));
//        offerJackOStrawRecipes(exporter, DelicateDyesBlocks.ROSE_JACK_O_STRAW, BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, "rose_wool")));
    }

    public static void offerJackOStrawRecipes(RecipeOutput exporter, ItemLike output, ItemLike wool) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
                .requires(BFItems.SUN_HAT.get())
                .requires(Items.CARVED_PUMPKIN)
                .requires(wool)
                .requires(Items.STICK)
                .unlockedBy(getHasName(wool), has(wool))
                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                .unlockedBy(getHasName(BFItems.SUN_HAT.get()), has(BFItems.SUN_HAT.get()))
                .unlockedBy("has_wool", has(wool))
                .save(exporter, getDefaultRecipeId(output) + "_with_carved_pumpkin");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
                .requires(BFItems.SUN_HAT.get())
                .requires(Items.PUMPKIN)
                .requires(wool)
                .requires(Items.STICK)
                .unlockedBy(getHasName(wool), has(wool))
                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                .unlockedBy(getHasName(BFItems.SUN_HAT.get()), has(BFItems.SUN_HAT.get()))
                .unlockedBy("has_wool", has(wool))
                .save(exporter, getDefaultRecipeId(output) + "_with_pumpkin");
    }
}
