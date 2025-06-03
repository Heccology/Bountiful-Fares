package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.world.WalnutTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class BFConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_KEY = registerKey("lemon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM_KEY = registerKey("plum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOARY_KEY = registerKey("hoary");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_KEY = registerKey("walnut");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_KEY = registerKey("palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_APPLE_KEY = registerKey("golden_apple");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, WALNUT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BFBlocks.WALNUT_LOG),
                new WalnutTrunkPlacer(7, 9, 4),
                BlockStateProvider.simple(BFBlocks.WALNUT_LEAVES),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 4),
//                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), ConstantIntProvider.create(3), 50),
                new TwoLayersFeatureSize(0, 0, 0)).forceDirt().build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
