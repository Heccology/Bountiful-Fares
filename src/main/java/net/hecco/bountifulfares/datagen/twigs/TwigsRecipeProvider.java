package net.hecco.bountifulfares.datagen.twigs;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.twigs.TwigsBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TwigsRecipeProvider extends FabricRecipeProvider {
    public TwigsRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.WALNUT_TABLE)
                .pattern("___")
                .pattern("0 0")
                .pattern("0 0")
                .input('_', BFBlocks.WALNUT_SLAB)
                .input('0', BFBlocks.WALNUT_FENCE)
                .criterion(hasItem(BFBlocks.WALNUT_PLANKS), conditionsFromItem(BFBlocks.WALNUT_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.HOARY_TABLE)
                .pattern("___")
                .pattern("0 0")
                .pattern("0 0")
                .input('_', BFBlocks.HOARY_SLAB)
                .input('0', BFBlocks.HOARY_FENCE)
                .criterion(hasItem(BFBlocks.HOARY_PLANKS), conditionsFromItem(BFBlocks.HOARY_PLANKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, TwigsBlocks.FELDSPAR_LAMP)
                .pattern("III")
                .pattern("FSF")
                .pattern("ICI")
                .input('I', Items.IRON_INGOT)
                .input('F', BFItems.FELDSPAR)
                .input('S', Items.TORCH)
                .input('C', Items.COAL)
                .criterion(hasItem(BFItems.FELDSPAR), conditionsFromItem(BFItems.FELDSPAR))
                .offerTo(exporter);
    }
}
