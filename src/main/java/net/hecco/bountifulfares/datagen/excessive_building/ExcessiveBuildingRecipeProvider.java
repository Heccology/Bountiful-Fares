package net.hecco.bountifulfares.datagen.excessive_building;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.EXCESSIVE_BUILDING_MOD_ID;
import static net.hecco.bountifulfares.datagen.bountifulfares.BFRecipeProvider.offerPicketsRecipe;
import static net.minecraft.data.family.BlockFamilies.register;

public class ExcessiveBuildingRecipeProvider extends FabricRecipeProvider {
    public ExcessiveBuildingRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        TrellisUtil.registerCompatTrellisRecipe(exporter, ExcessiveBuildingBlocks.ANCIENT);
        offerPicketsRecipe(exporter, ExcessiveBuildingBlocks.ANCIENT_PICKETS, Identifier.of(EXCESSIVE_BUILDING_MOD_ID, "ancient_planks"));
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.HOARY_VERTICAL_STAIRS, BFBlocks.HOARY_PLANKS);
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.HOARY_MOSAIC_VERTICAL_STAIRS, ExcessiveBuildingBlocks.HOARY_MOSAIC);
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.WALNUT_VERTICAL_STAIRS, BFBlocks.WALNUT_PLANKS);
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS, ExcessiveBuildingBlocks.WALNUT_MOSAIC);
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.FELDSPAR_BRICK_VERTICAL_STAIRS, BFBlocks.FELDSPAR_BRICKS);
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS, BFBlocks.CERAMIC_TILES);
        offerVerticalStairsRecipe(exporter, ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS, BFBlocks.CERAMIC_MOSAIC);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.CHISELED_HOARY_PLANKS, 2)
                .input('#', BFBlocks.HOARY_SLAB)
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(BFBlocks.HOARY_SLAB), conditionsFromItem(BFBlocks.HOARY_SLAB)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.CHISELED_WALNUT_PLANKS, 2)
                .input('#', BFBlocks.WALNUT_SLAB)
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(BFBlocks.WALNUT_SLAB), conditionsFromItem(BFBlocks.WALNUT_SLAB)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.HOARY_LADDER, 8)
                .input('S', Items.STICK)
                .input('#', BFBlocks.HOARY_PLANKS)
                .pattern("S S")
                .pattern("S#S")
                .pattern("S S")
                .criterion(hasItem(BFBlocks.HOARY_PLANKS), conditionsFromItem(BFBlocks.HOARY_PLANKS)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.WALNUT_LADDER, 8)
                .input('S', Items.STICK)
                .input('#', BFBlocks.WALNUT_PLANKS)
                .pattern("S S")
                .pattern("S#S")
                .pattern("S S")
                .criterion(hasItem(BFBlocks.WALNUT_PLANKS), conditionsFromItem(BFBlocks.WALNUT_PLANKS)).offerTo(exporter);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.HOARY_MOSAIC, BFBlocks.HOARY_SLAB);
        BlockFamily hoaryMosaicFamily = register(ExcessiveBuildingBlocks.HOARY_MOSAIC)
                .stairs(ExcessiveBuildingBlocks.HOARY_MOSAIC_STAIRS)
                .slab(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB)
                .unlockCriterionName(hasItem(ExcessiveBuildingBlocks.HOARY_MOSAIC))
                .build();
        generateFamily(exporter, hoaryMosaicFamily, FeatureSet.of(FeatureFlags.VANILLA));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ExcessiveBuildingBlocks.WALNUT_MOSAIC, BFBlocks.WALNUT_SLAB);
        BlockFamily walnutMosaicFamily = register(ExcessiveBuildingBlocks.WALNUT_MOSAIC)
                .stairs(ExcessiveBuildingBlocks.WALNUT_MOSAIC_STAIRS)
                .slab(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB)
                .unlockCriterionName(hasItem(ExcessiveBuildingBlocks.WALNUT_MOSAIC))
                .build();
        generateFamily(exporter, walnutMosaicFamily, FeatureSet.of(FeatureFlags.VANILLA));
    }

    private static void offerVerticalStairsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .input('#', input)
                .pattern("###")
                .pattern("## ")
                .pattern("#  ")
                .criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
}
