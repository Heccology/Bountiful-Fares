package net.hecco.bountifulfares.definition.world.wild_vine_feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class WildVineFeatureConfig implements FeatureConfiguration {
    protected final BlockState block;
    protected final TagKey<Block> canPlaceOn;
    protected final int patchSize;
    public static final Codec<WildVineFeatureConfig> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                    BlockState.CODEC
                            .fieldOf("block")
                            .forGetter((placer) -> placer.block),
                    TagKey.hashedCodec(BuiltInRegistries.BLOCK.key())
                            .fieldOf("can_place_on")
                            .forGetter((placer) -> placer.canPlaceOn),
                    Codec.intRange(1, 16)
                            .fieldOf("patch_size")
                            .forGetter((placer) -> placer.patchSize)
            ).apply(instance, WildVineFeatureConfig::new)

    );

    public WildVineFeatureConfig(BlockState block, TagKey<Block> canPlaceOn, int patchSize) {
        this.block = block;
        this.canPlaceOn = canPlaceOn;
        this.patchSize = patchSize;
    }
}
