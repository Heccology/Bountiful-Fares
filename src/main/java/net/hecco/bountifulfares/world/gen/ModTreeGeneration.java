package net.hecco.bountifulfares.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hecco.bountifulfares.world.ModPlacedFeatures;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_RIVER),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LEMON_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PLUM_FLOWER_FOREST_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PLUM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WALNUT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_BEACH),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BEACH_WALNUT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PASSION_FRUIT_JUNGLE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.SWAMP_HUT_HAS_STRUCTURE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ELDERBERRY_SWAMP_OAK);
    }
}
