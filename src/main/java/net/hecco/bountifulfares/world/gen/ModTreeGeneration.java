package net.hecco.bountifulfares.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.util.ModBiomeTags;
import net.hecco.bountifulfares.world.ModPlacedFeatures;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        if (BountifulFares.CONFIG.isGenerateAppleTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_APPLE_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLE_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateOrangeTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_ORANGE_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateLemonTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_LEMON_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LEMON_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGeneratePlumTrees()) {
            if (!BountifulFares.CONFIG.isGenerateAllFruitTreesInFlowerForest()) {
                BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                        GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PLUM_FLOWER_FOREST_PLACED_KEY);
            }
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_PLUM_TREES),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PLUM_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateAllFruitTreesInFlowerForest()) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLE_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LEMON_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PLUM_PLACED_KEY);
        }
        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WALNUT_TREES),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WALNUT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_BEACH),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BEACH_WALNUT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WILD_PASSION_FRUIT),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PASSION_FRUIT_JUNGLE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WILD_ELDERBERRIES),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ELDERBERRY_SWAMP_OAK);
        if (BountifulFares.CONFIG.isGenerateForestWalnutTrees()) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WALNUT_PLACED_KEY);
        }
    }
}
