package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class BFPlacedFeatures {

    public static final ResourceKey<PlacedFeature> APPLE_PLACED_KEY = registerKey("apple_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_PLACED_KEY = registerKey("orange_placed");
    public static final ResourceKey<PlacedFeature> LEMON_PLACED_KEY = registerKey("lemon_placed");
    public static final ResourceKey<PlacedFeature> PLUM_PLACED_KEY = registerKey("plum_placed");
    public static final ResourceKey<PlacedFeature> PLUM_FLOWER_FOREST_PLACED_KEY = registerKey("plum_flower_forest_placed");
    public static final ResourceKey<PlacedFeature> HONEYSUCKLE_PLACED_KEY = registerKey("honeysuckle_placed");
    public static final ResourceKey<PlacedFeature> VIOLET_BELLFLOWER_PLACED_KEY = registerKey("violet_bellflower_placed");
    public static final ResourceKey<PlacedFeature> CHAMOMILE_PLACED_KEY = registerKey("chamomile_placed");
    public static final ResourceKey<PlacedFeature> WILD_WHEAT_PLACED_KEY = registerKey("wild_wheat_placed");
    public static final ResourceKey<PlacedFeature> LARGE_WILD_WHEAT_PLACED_KEY = registerKey("large_wild_wheat_placed");
    public static final ResourceKey<PlacedFeature> WILD_CARROTS_PLACED_KEY = registerKey("wild_carrots_placed");
    public static final ResourceKey<PlacedFeature> LARGE_WILD_CARROTS_PLACED_KEY = registerKey("large_wild_carrots_placed");
    public static final ResourceKey<PlacedFeature> WILD_POTATOES_PLACED_KEY = registerKey("wild_potatoes_placed");
    public static final ResourceKey<PlacedFeature> LARGE_WILD_POTATOES_PLACED_KEY = registerKey("large_wild_potatoes_placed");
    public static final ResourceKey<PlacedFeature> WILD_BEETROOTS_PLACED_KEY = registerKey("wild_beetroots_placed");
    public static final ResourceKey<PlacedFeature> LARGE_WILD_BEETROOTS_PLACED_KEY = registerKey("large_wild_beetroots_placed");
    public static final ResourceKey<PlacedFeature> WILD_LEEKS_PLACED_KEY = registerKey("wild_leeks_placed");
    public static final ResourceKey<PlacedFeature> LARGE_WILD_LEEKS_PLACED_KEY = registerKey("large_wild_leeks_placed");
    public static final ResourceKey<PlacedFeature> WILD_MAIZE_PLACED_KEY = registerKey("wild_maize_placed");
    public static final ResourceKey<PlacedFeature> LARGE_WILD_MAIZE_PLACED_KEY = registerKey("large_wild_maize_placed");
    public static final ResourceKey<PlacedFeature> TEA_SHRUB_PLACED_KEY = registerKey("tea_shrub_placed");
    public static final ResourceKey<PlacedFeature> FOREST_TEA_SHRUB_PLACED_KEY = registerKey("forest_tea_shrub_placed");
    public static final ResourceKey<PlacedFeature> WALNUT_PLACED_KEY = registerKey("walnut_placed");
    public static final ResourceKey<PlacedFeature> PALM_PLACED_KEY = registerKey("palm_placed");
    public static final ResourceKey<PlacedFeature> WILD_PASSION_FRUIT_PLACED_KEY = registerKey("wild_passion_fruit_placed");
    public static final ResourceKey<PlacedFeature> WILD_ELDERBERRY_PLACED_KEY = registerKey("wild_elderberry_placed");
    public static final ResourceKey<PlacedFeature> PATCH_GRASSY_DIRT_KEY = registerKey("patch_grassy_dirt");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, WALNUT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(BFConfiguredFeatures.WALNUT_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.5f, 1), BFBlocks.WALNUT_SAPLING.get()));

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                   Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
