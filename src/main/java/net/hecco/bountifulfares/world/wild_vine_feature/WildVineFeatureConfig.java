package net.hecco.bountifulfares.world.wild_vine_feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.gen.feature.FeatureConfig;

public class WildVineFeatureConfig implements FeatureConfig {
    protected final BlockState block;
    protected final TagKey<Block> canPlaceOn;
    protected final int patchSize;
    public static final Codec<WildVineFeatureConfig> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                    BlockState.CODEC
                            .fieldOf("block")
                            .forGetter((placer) -> placer.block),
                    TagKey.codec(Registries.BLOCK.getKey())
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
