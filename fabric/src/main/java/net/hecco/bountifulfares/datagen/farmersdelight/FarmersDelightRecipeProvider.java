package net.hecco.bountifulfares.datagen.farmersdelight;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class FarmersDelightRecipeProvider extends FabricRecipeProvider {
    public FarmersDelightRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
//        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, FarmersDelightBlocks.HOARY_CABINET)
//                .define('_', BFBlocks.HOARY_SLAB)
//                .define('D', BFBlocks.HOARY_TRAPDOOR)
//                .pattern("___")
//                .pattern("D D")
//                .pattern("___")
//                .unlockedBy(getHasName(BFBlocks.HOARY_TRAPDOOR), has(BFBlocks.HOARY_TRAPDOOR))
//                .save(exporter);
//        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, FarmersDelightBlocks.WALNUT_CABINET)
//                .define('_', BFBlocks.WALNUT_SLAB)
//                .define('D', BFBlocks.WALNUT_TRAPDOOR)
//                .pattern("___")
//                .pattern("D D")
//                .pattern("___")
//                .unlockedBy(getHasName(BFBlocks.WALNUT_TRAPDOOR), has(BFBlocks.WALNUT_TRAPDOOR))
//                .save(exporter);
    }
}
