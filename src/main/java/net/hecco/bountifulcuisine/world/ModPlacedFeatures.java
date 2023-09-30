package net.hecco.bountifulcuisine.world;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> APPLE_PLACED_KEY = registerKey("apple_placed");
    public static final RegistryKey<PlacedFeature> ORANGE_PLACED_KEY = registerKey("orange_placed");
    public static final RegistryKey<PlacedFeature> LEMON_PLACED_KEY = registerKey("lemon_placed");
    public static final RegistryKey<PlacedFeature> LEMON_FLOWER_FOREST_PLACED_KEY = registerKey("lemon_flower_forest_placed");
    public static final RegistryKey<PlacedFeature> PLUM_PLACED_KEY = registerKey("plum_placed");
    public static final RegistryKey<PlacedFeature> PLUM_FLOWER_FOREST_PLACED_KEY = registerKey("plum_flower_forest_placed");
    public static final RegistryKey<PlacedFeature> HOARY_PLACED_KEY = registerKey("hoary_placed");
    public static final RegistryKey<PlacedFeature> HONEYSUCKLE_PLACED_KEY = registerKey("honeysuckle_placed");
    public static final RegistryKey<PlacedFeature> VIOLET_BELLFLOWER_PLACED_KEY = registerKey("violet_bellflower_placed");
    public static final RegistryKey<PlacedFeature> CHAMOMILE_PLACED_KEY = registerKey("chamomile_placed");
    public static final RegistryKey<PlacedFeature> WILD_WHEAT_PLACED_KEY = registerKey("wild_wheat_placed");
    public static final RegistryKey<PlacedFeature> WILD_CARROTS_PLACED_KEY = registerKey("wild_carrots_placed");
    public static final RegistryKey<PlacedFeature> WILD_POTATOES_PLACED_KEY = registerKey("wild_potatoes_placed");
    public static final RegistryKey<PlacedFeature> WILD_BEETROOTS_PLACED_KEY = registerKey("wild_beetroots_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, APPLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APPLE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.5f, 1), ModBlocks.APPLE_SAPLING));

        register(context, ORANGE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.5f, 1), ModBlocks.ORANGE_SAPLING));

        register(context, LEMON_FLOWER_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMON_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.5f, 1), ModBlocks.LEMON_SAPLING));

        register(context, LEMON_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMON_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(1, 0.2f, 1), ModBlocks.LEMON_SAPLING));

        register(context, PLUM_FLOWER_FOREST_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLUM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.5f, 1), ModBlocks.PLUM_SAPLING));

        register(context, PLUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLUM_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.2f, 1), ModBlocks.PLUM_SAPLING));
        register(context, HOARY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HOARY_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.05f, 1), ModBlocks.HOARY_APPLE_SAPLING));

        register(context, HONEYSUCKLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HONEYSUCKLE_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, VIOLET_BELLFLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIOLET_BELLFLOWER_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CHAMOMILE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHAMOMILE_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(BountifulCuisine.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
