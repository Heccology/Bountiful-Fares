package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.world.wild_vine_feature.WildVineFeature;
import net.hecco.bountifulfares.definition.world.wild_vine_feature.WildVineFeatureConfig;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.function.Supplier;

public class BFFeatures {
    public static final Supplier<Feature<WildVineFeatureConfig>> WILD_VINE_FEATURE = register("wild_vine", () -> new WildVineFeature(WildVineFeatureConfig.CODEC));

    private static <C extends FeatureConfiguration, T extends Feature<C>> Supplier<T> register(String name, Supplier<T> feature) {
        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, name, (Registry<T>) BuiltInRegistries.FEATURE, feature);
    }

    public static void register() {
    }
}
