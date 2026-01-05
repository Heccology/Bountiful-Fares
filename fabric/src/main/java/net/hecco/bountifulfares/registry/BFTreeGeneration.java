package net.hecco.bountifulfares.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.FabricBountifulFares;
import net.hecco.bountifulfares.registry.misc.BFPlacedFeatures;
import net.hecco.bountifulfares.registry.tags.BFBiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class BFTreeGeneration {
    public static void generateTrees() {
        if (FabricBountifulFares.CONFIG.getBoolValue("generateAppleTrees")) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_APPLE_TREES),
                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.APPLE_PLACED_KEY);
        }
        if (FabricBountifulFares.CONFIG.getBoolValue("generateOrangeTrees")) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_ORANGE_TREES),
                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.ORANGE_PLACED_KEY);

        }
        if (FabricBountifulFares.CONFIG.getBoolValue("generateLemonTrees")) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_LEMON_TREES),
                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.LEMON_PLACED_KEY);
        }
        if (FabricBountifulFares.CONFIG.getBoolValue("generatePlumTrees")) {
//            BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST),
//                        GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.PLUM_FLOWER_FOREST_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_PLUM_TREES),
                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.PLUM_PLACED_KEY);
        }

//            BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST),
//                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.APPLE_PLACED_KEY);
//            BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST),
//                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.ORANGE_PLACED_KEY);
//            BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST),
//                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.LEMON_PLACED_KEY);
//            BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST),
//                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.PLUM_PLACED_KEY);
        if (FabricBountifulFares.CONFIG.getBoolValue("generateWalnutTrees")) {
            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_WALNUT_TREES),
                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.WALNUT_PLACED_KEY);
        }
//            BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FOREST),
//                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.WALNUT_PLACED_KEY);
        if (FabricBountifulFares.CONFIG.getBoolValue("generatePalmTrees")) {

            BiomeModifications.addFeature(BiomeSelectors.tag(BFBiomeTags.HAS_PALM_TREES),
                    GenerationStep.Decoration.VEGETAL_DECORATION, BFPlacedFeatures.PALM_PLACED_KEY);
        }
    }
}
