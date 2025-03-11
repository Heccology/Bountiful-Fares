package net.hecco.bountifulfares.registry.misc;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.tags.BFBiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class BFFoliageGeneration {
    public static void generateFlowers() {
        if (BountifulFares.CONFIG.generateGrassyDirtPatches) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                    GenerationStep.Feature.TOP_LAYER_MODIFICATION, BFPlacedFeatures.PATCH_GRASSY_DIRT_KEY);
        }
        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_HONEYSUCKLE),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.HONEYSUCKLE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_VIOLET_BELLFLOWER),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.VIOLET_BELLFLOWER_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_CHAMOMILE),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.CHAMOMILE_PLACED_KEY);

        if (BountifulFares.CONFIG.isGenerateWildWheat()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_WHEAT),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WILD_WHEAT_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_LARGE_WILD_WHEAT),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.LARGE_WILD_WHEAT_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateWildCarrots()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_CARROTS),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WILD_CARROTS_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_LARGE_WILD_CARROTS),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.LARGE_WILD_CARROTS_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateWildPotatoes()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_POTATOES),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WILD_POTATOES_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_LARGE_WILD_POTATOES),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.LARGE_WILD_POTATOES_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateWildBeetroot()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_BEETROOT),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WILD_BEETROOTS_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_LARGE_WILD_BEETROOT),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.LARGE_WILD_BEETROOTS_PLACED_KEY);
        }
        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_LEEKS),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WILD_LEEKS_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_LARGE_WILD_LEEKS),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.LARGE_WILD_LEEKS_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_MAIZE),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WILD_MAIZE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_LARGE_WILD_MAIZE),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.LARGE_WILD_MAIZE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_TEA_SHRUB),
                GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.TEA_SHRUB_PLACED_KEY);

        if (BountifulFares.CONFIG.generateWildPassionFruit) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_PASSION_FRUIT),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WILD_PASSION_FRUIT_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.generateWildElderberries) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WILD_ELDERBERRIES),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.WILD_ELDERBERRY_PLACED_KEY);
        }

        if (BountifulFares.CONFIG.isGenerateForestTeaShrubs()) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, BFPlacedFeatures.FOREST_TEA_SHRUB_PLACED_KEY);
        }
    }
}
