package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BFConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_KEY = registerKey("orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_KEY = registerKey("lemon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM_KEY = registerKey("plum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOARY_KEY = registerKey("hoary");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_KEY = registerKey("walnut");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_KEY = registerKey("palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_APPLE_KEY = registerKey("golden_apple");

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name));
    }
}
