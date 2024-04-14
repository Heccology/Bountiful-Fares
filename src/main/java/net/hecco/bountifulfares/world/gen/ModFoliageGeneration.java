package net.hecco.bountifulfares.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.world.ModPlacedFeatures;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModFoliageGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.SAVANNA, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HONEYSUCKLE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.MEADOW, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.VIOLET_BELLFLOWER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHAMOMILE_PLACED_KEY);
        if (BountifulFares.CONFIG.isGenerateVanillaWildCrops()) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST).and(BiomeSelectors.tag(BiomeTags.IS_SAVANNA)),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_WHEAT_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_WHEAT_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_CARROTS_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_CARROTS_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.DARK_FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_POTATOES_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.DARK_FOREST).and(BiomeSelectors.tag(BiomeTags.IS_SAVANNA)),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_POTATOES_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.MEADOW),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_BEETROOTS_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_BEETROOTS_PLACED_KEY);
        }
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_LEEKS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_RIVER),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_LEEKS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MANGROVE_SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_MAIZE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MANGROVE_SWAMP).and(BiomeSelectors.tag(BiomeTags.IS_SAVANNA)),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_MAIZE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TEA_SHRUB_PLACED_KEY);
        if (BountifulFares.CONFIG.isGenerateForestTeaShrubs()) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FOREST_TEA_SHRUB_PLACED_KEY);
        }
    }
}
