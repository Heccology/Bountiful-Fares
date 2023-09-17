package net.hecco.bountifulcuisine.world;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.world.tree.custom.FruitTreeFoliagePlacer;
import net.hecco.bountifulcuisine.world.tree.custom.HoaryTrunkPlacer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEMON_KEY = registerKey("lemon");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLUM_KEY = registerKey("plum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HOARY_KEY = registerKey("hoary");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_WHEAT_KEY = registerKey("wild_wheat");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, APPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.APPLE_LOG),
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

        register(context, PLUM_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PLUM_LOG),
                new StraightTrunkPlacer(5, 1, 0),
                BlockStateProvider.of(ModBlocks.PLUM_LEAVES),
                new FruitTreeFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(5), 1),
                new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().build());

        register(context, HOARY_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.HOARY_LOG),
                new HoaryTrunkPlacer(1, 1, 1),
                BlockStateProvider.of(ModBlocks.HOARY_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(2), 1),
                new TwoLayersFeatureSize(2, 1, 1))
                .ignoreVines().build());

        register(context, WILD_WHEAT_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WILD_WHEAT)))));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(BountifulCuisine.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
