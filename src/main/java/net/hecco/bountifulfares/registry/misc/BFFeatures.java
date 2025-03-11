package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.world.wild_vine_feature.WildVineFeature;
import net.hecco.bountifulfares.world.wild_vine_feature.WildVineFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class BFFeatures {
    public static final Feature<WildVineFeatureConfig> WILD_VINE_FEATURE = register("wild_vine", new WildVineFeature(WildVineFeatureConfig.CODEC));
    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registries.FEATURE, Identifier.of(BountifulFares.MOD_ID, name), feature);
    }
    public static void register() {
    }
}
