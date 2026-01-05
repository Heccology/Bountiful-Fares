package net.hecco.bountifulfares.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class BFBiomeModifiers {
    public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, BountifulFares.MOD_ID);

    public static Supplier<MapCodec<AddFeaturesByConfigBiomeModifier>> ADD_FEATURES_BY_CONFIG = BIOME_MODIFIERS.register("add_features_by_config", () ->
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(AddFeaturesByConfigBiomeModifier::biomes),
                    Codec.STRING.fieldOf("config_value").forGetter(AddFeaturesByConfigBiomeModifier::config),
                    PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(AddFeaturesByConfigBiomeModifier::features),
                    GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(AddFeaturesByConfigBiomeModifier::step)
                ).apply(instance, AddFeaturesByConfigBiomeModifier::new)
            ));

}
