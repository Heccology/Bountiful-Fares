package net.hecco.bountifulfares.datagen.farmersdelight;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class FarmersDelightRecipeProvider extends FabricRecipeProvider {
    public FarmersDelightRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
//        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, FarmersDelightBlocks.HOARY_CABINET)
//                .input('_', BFBlocks.HOARY_SLAB)
//                .input('D', BFBlocks.HOARY_TRAPDOOR)
//                .pattern("___")
//                .pattern("D D")
//                .pattern("___")
//                .criterion(hasItem(BFBlocks.HOARY_TRAPDOOR), conditionsFromItem(BFBlocks.HOARY_TRAPDOOR))
//                .offerTo(exporter);
//        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, FarmersDelightBlocks.WALNUT_CABINET)
//                .input('_', BFBlocks.WALNUT_SLAB)
//                .input('D', BFBlocks.WALNUT_TRAPDOOR)
//                .pattern("___")
//                .pattern("D D")
//                .pattern("___")
//                .criterion(hasItem(BFBlocks.WALNUT_TRAPDOOR), conditionsFromItem(BFBlocks.WALNUT_TRAPDOOR))
//                .offerTo(exporter);
    }
}
