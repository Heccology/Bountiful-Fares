package net.hecco.bountifulfares.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.util.ModBiomeTags;
import net.hecco.bountifulfares.world.ModPlacedFeatures;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModFoliageGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_HONEYSUCKLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HONEYSUCKLE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_VIOLET_BELLFLOWER),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.VIOLET_BELLFLOWER_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_CHAMOMILE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHAMOMILE_PLACED_KEY);

        if (BountifulFares.CONFIG.isGenerateWildWheat()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WILD_WHEAT),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_WHEAT_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_LARGE_WILD_WHEAT),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_WHEAT_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateWildCarrots()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WILD_CARROTS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_CARROTS_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_LARGE_WILD_CARROTS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_CARROTS_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateWildPotatoes()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WILD_POTATOES),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_POTATOES_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_LARGE_WILD_POTATOES),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_POTATOES_PLACED_KEY);
        }
        if (BountifulFares.CONFIG.isGenerateWildBeetroot()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WILD_BEETROOT),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_BEETROOTS_PLACED_KEY);

            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_LARGE_WILD_BEETROOT),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_BEETROOTS_PLACED_KEY);
        }
        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WILD_LEEKS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_LEEKS_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_LARGE_WILD_LEEKS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_LEEKS_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_WILD_MAIZE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_MAIZE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_LARGE_WILD_MAIZE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_WILD_MAIZE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.HAS_TEA_SHRUB),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TEA_SHRUB_PLACED_KEY);

        if (BountifulFares.CONFIG.isGenerateForestTeaShrubs()) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FOREST_TEA_SHRUB_PLACED_KEY);
        }
    }
}
