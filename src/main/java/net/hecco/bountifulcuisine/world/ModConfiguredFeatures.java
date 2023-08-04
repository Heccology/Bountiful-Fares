package net.hecco.bountifulcuisine.world;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.world.tree.custom.FruitTreeFoliagePlacer;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEMON_KEY = registerKey("lemon");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLUM_KEY = registerKey("plum");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, APPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.APPLE_LOG),
                new StraightTrunkPlacer(5, 1, 0),
                BlockStateProvider.of(ModBlocks.APPLE_LEAVES),
                new FruitTreeFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(5), 1),
                new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build());

        register(context, ORANGE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ORANGE_LOG),
                new StraightTrunkPlacer(5, 1, 0),
                BlockStateProvider.of(ModBlocks.ORANGE_LEAVES),
                new FruitTreeFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(5), 1),
                new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build());

        register(context, LEMON_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.LEMON_LOG),
                new StraightTrunkPlacer(5, 1, 0),
                BlockStateProvider.of(ModBlocks.LEMON_LEAVES),
                new FruitTreeFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(5), 1),
                new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build());

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(BountifulCuisine.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
