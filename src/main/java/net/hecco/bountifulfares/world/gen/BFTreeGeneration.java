package net.hecco.bountifulfares.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.util.BFBiomeTags;
import net.hecco.bountifulfares.world.BFPlacedFeatures;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class BFTreeGeneration {
    public static void generateTrees() {
        if (BountifulFares.CONFIG.isGenerateAppleTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_APPLE_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.APPLE_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateOrangeTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_ORANGE_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.ORANGE_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateLemonTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_LEMON_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.LEMON_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGeneratePlumTrees()) {
            if (!BountifulFares.CONFIG.isGenerateAllFruitTreesInFlowerForest()) {
                BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                        GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.PLUM_FLOWER_FOREST_PLACED_KEY);
            }
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_PLUM_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.PLUM_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateAllFruitTreesInFlowerForest()) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.APPLE_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.ORANGE_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.LEMON_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.PLUM_PLACED_KEY);
        }
        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WALNUT_TREES),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WALNUT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_BEACH),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.BEACH_WALNUT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_PASSION_FRUIT),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.PASSION_FRUIT_JUNGLE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_ELDERBERRIES),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.ELDERBERRY_SWAMP_OAK);
        if (BountifulFares.CONFIG.isGenerateForestWalnutTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WALNUT_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGeneratePalmTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_PALM_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.PALM_PLACED_KEY);
        }
    }
}
