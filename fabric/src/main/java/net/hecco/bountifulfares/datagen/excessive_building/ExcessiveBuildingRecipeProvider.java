package net.hecco.bountifulfares.datagen.excessive_building;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.EXCESSIVE_BUILDING_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;
import static net.minecraft.data.BlockFamilies.familyBuilder;

public class ExcessiveBuildingRecipeProvider extends FabricRecipeProvider {
    public ExcessiveBuildingRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
//        TrellisUtil.registerCompatTrellisRecipe(exporter, ExcessiveBuildingBlocks.ANCIENT);
//        offerPicketsRecipe(exporter, ExcessiveBuildingBlocks.ANCIENT_PICKETS, ResourceLocation.fromNamespaceAndPath(EXCESSIVE_BUILDING_MOD_ID, "ancient_planks"));
//        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.HOARY_VERTICAL_STAIRS, BFBlocks.HOARY_PLANKS);
//        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.HOARY_MOSAIC_VERTICAL_STAIRS, ExcessiveBuildingBlocks.HOARY_MOSAIC);
//        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.WALNUT_VERTICAL_STAIRS, BFBlocks.WALNUT_PLANKS);
//        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS, ExcessiveBuildingBlocks.WALNUT_MOSAIC);
//        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.FELDSPAR_BRICK_VERTICAL_STAIRS, BFBlocks.FELDSPAR_BRICKS);
//        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS, BFBlocks.CERAMIC_TILES);
//        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS, BFBlocks.CERAMIC_MOSAIC);
//        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.CHISELED_HOARY_PLANKS, 2)
//                .define('#', BFBlocks.HOARY_SLAB)
//                .pattern("##")
//                .pattern("##")
//                .unlockedBy(getHasName(BFBlocks.HOARY_SLAB), has(BFBlocks.HOARY_SLAB)).save(exporter);
//        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.CHISELED_WALNUT_PLANKS, 2)
//                .define('#', BFBlocks.WALNUT_SLAB)
//                .pattern("##")
//                .pattern("##")
//                .unlockedBy(getHasName(BFBlocks.WALNUT_SLAB), has(BFBlocks.WALNUT_SLAB)).save(exporter);
//        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.HOARY_LADDER, 8)
//                .define('S', Items.STICK)
//                .define('#', BFBlocks.HOARY_PLANKS)
//                .pattern("S S")
//                .pattern("S#S")
//                .pattern("S S")
//                .unlockedBy(getHasName(BFBlocks.HOARY_PLANKS), has(BFBlocks.HOARY_PLANKS)).save(exporter);
//        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.WALNUT_LADDER, 8)
//                .define('S', Items.STICK)
//                .define('#', BFBlocks.WALNUT_PLANKS)
//                .pattern("S S")
//                .pattern("S#S")
//                .pattern("S S")
//                .unlockedBy(getHasName(BFBlocks.WALNUT_PLANKS), has(BFBlocks.WALNUT_PLANKS)).save(exporter);
//        chiseled(exporter, RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.HOARY_MOSAIC, BFBlocks.HOARY_SLAB);
//        BlockFamily hoaryMosaicFamily = familyBuilder(ExcessiveBuildingBlocks.HOARY_MOSAIC)
//                .stairs(ExcessiveBuildingBlocks.HOARY_MOSAIC_STAIRS)
//                .slab(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB)
//                .recipeUnlockedBy(getHasName(ExcessiveBuildingBlocks.HOARY_MOSAIC))
//                .getFamily();
//        generateRecipes(exporter, hoaryMosaicFamily, FeatureFlagSet.of(FeatureFlags.VANILLA));
//        chiseled(exporter, RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.WALNUT_MOSAIC, BFBlocks.WALNUT_SLAB);
//        BlockFamily walnutMosaicFamily = familyBuilder(ExcessiveBuildingBlocks.WALNUT_MOSAIC)
//                .stairs(ExcessiveBuildingBlocks.WALNUT_MOSAIC_STAIRS)
//                .slab(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB)
//                .recipeUnlockedBy(getHasName(ExcessiveBuildingBlocks.WALNUT_MOSAIC))
//                .getFamily();
//        generateRecipes(exporter, walnutMosaicFamily, FeatureFlagSet.of(FeatureFlags.VANILLA));
    }

    private static void offerVerticalStairsRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .define('#', input)
                .pattern("###")
                .pattern("## ")
                .pattern("#  ")
                .unlockedBy(getHasName(input), has(input)).save(exporter);
    }
}
