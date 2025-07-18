package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.world.wild_vine_feature.WildVineFeature;
import net.hecco.bountifulfares.world.wild_vine_feature.WildVineFeatureConfig;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class BFFeatures {
    public static final Feature<WildVineFeatureConfig> WILD_VINE_FEATURE = register("wild_vine", new WildVineFeature(WildVineFeatureConfig.CODEC));
    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String name, F feature) {
//        return Registry.register(BuiltInRegistries.FEATURE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), feature);
        return null;
        //TODO: FIX
    }
    public static void register() {
    }
}
