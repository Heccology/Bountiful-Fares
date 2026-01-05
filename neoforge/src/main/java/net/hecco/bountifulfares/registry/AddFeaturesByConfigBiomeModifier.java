package net.hecco.bountifulfares.registry;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.definition.platform.Services;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

public record AddFeaturesByConfigBiomeModifier(HolderSet<Biome> biomes, String config, HolderSet<PlacedFeature> features, GenerationStep.Decoration step) implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> holder, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && this.biomes.contains(holder)) {
            if (!Services.PLATFORM.get().getBoolConfigValue(config)) {
                return;
            }
            this.features.forEach(i -> builder.getGenerationSettings().addFeature(this.step, i));
        }
    }

    @Override
    public MapCodec<? extends BiomeModifier> codec() {
        return BFBiomeModifiers.ADD_FEATURES_BY_CONFIG.get();
    }
}
