package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class BFPlacedFeatures {

    public static final RegistryKey<PlacedFeature> APPLE_PLACED_KEY = registerKey("apple_placed");
    public static final RegistryKey<PlacedFeature> ORANGE_PLACED_KEY = registerKey("orange_placed");
    public static final RegistryKey<PlacedFeature> LEMON_PLACED_KEY = registerKey("lemon_placed");
    public static final RegistryKey<PlacedFeature> PLUM_PLACED_KEY = registerKey("plum_placed");
    public static final RegistryKey<PlacedFeature> PLUM_FLOWER_FOREST_PLACED_KEY = registerKey("plum_flower_forest_placed");
    public static final RegistryKey<PlacedFeature> HONEYSUCKLE_PLACED_KEY = registerKey("honeysuckle_placed");
    public static final RegistryKey<PlacedFeature> VIOLET_BELLFLOWER_PLACED_KEY = registerKey("violet_bellflower_placed");
    public static final RegistryKey<PlacedFeature> CHAMOMILE_PLACED_KEY = registerKey("chamomile_placed");
    public static final RegistryKey<PlacedFeature> WILD_WHEAT_PLACED_KEY = registerKey("wild_wheat_placed");
    public static final RegistryKey<PlacedFeature> LARGE_WILD_WHEAT_PLACED_KEY = registerKey("large_wild_wheat_placed");
    public static final RegistryKey<PlacedFeature> WILD_CARROTS_PLACED_KEY = registerKey("wild_carrots_placed");
    public static final RegistryKey<PlacedFeature> LARGE_WILD_CARROTS_PLACED_KEY = registerKey("large_wild_carrots_placed");
    public static final RegistryKey<PlacedFeature> WILD_POTATOES_PLACED_KEY = registerKey("wild_potatoes_placed");
    public static final RegistryKey<PlacedFeature> LARGE_WILD_POTATOES_PLACED_KEY = registerKey("large_wild_potatoes_placed");
    public static final RegistryKey<PlacedFeature> WILD_BEETROOTS_PLACED_KEY = registerKey("wild_beetroots_placed");
    public static final RegistryKey<PlacedFeature> LARGE_WILD_BEETROOTS_PLACED_KEY = registerKey("large_wild_beetroots_placed");
    public static final RegistryKey<PlacedFeature> WILD_LEEKS_PLACED_KEY = registerKey("wild_leeks_placed");
    public static final RegistryKey<PlacedFeature> LARGE_WILD_LEEKS_PLACED_KEY = registerKey("large_wild_leeks_placed");
    public static final RegistryKey<PlacedFeature> WILD_MAIZE_PLACED_KEY = registerKey("wild_maize_placed");
    public static final RegistryKey<PlacedFeature> LARGE_WILD_MAIZE_PLACED_KEY = registerKey("large_wild_maize_placed");
    public static final RegistryKey<PlacedFeature> TEA_SHRUB_PLACED_KEY = registerKey("tea_shrub_placed");
    public static final RegistryKey<PlacedFeature> FOREST_TEA_SHRUB_PLACED_KEY = registerKey("forest_tea_shrub_placed");
    public static final RegistryKey<PlacedFeature> WALNUT_PLACED_KEY = registerKey("walnut_placed");
    public static final RegistryKey<PlacedFeature> PALM_PLACED_KEY = registerKey("palm_placed");
    public static final RegistryKey<PlacedFeature> WILD_PASSION_FRUIT_PLACED_KEY = registerKey("wild_passion_fruit_placed");
    public static final RegistryKey<PlacedFeature> WILD_ELDERBERRY_PLACED_KEY = registerKey("wild_elderberry_placed");
    public static final RegistryKey<PlacedFeature> PATCH_GRASSY_DIRT_KEY = registerKey("patch_grassy_dirt");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, WALNUT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BFConfiguredFeatures.WALNUT_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.5f, 1), BFBlocks.WALNUT_SAPLING));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(BountifulFares.MOD_ID, name));
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
