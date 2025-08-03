package net.hecco.bountifulfares.data.grass_seeds;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public record GrassSeedsInteractionDefinition(Block soil, Block result, boolean onTop) {
    public static final Codec<GrassSeedsInteractionDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("soil")
                    .xmap(BuiltInRegistries.BLOCK::get, BuiltInRegistries.BLOCK::getKey)
                    .forGetter(GrassSeedsInteractionDefinition::soil),
            ResourceLocation.CODEC.fieldOf("result")
                    .xmap(BuiltInRegistries.BLOCK::get, BuiltInRegistries.BLOCK::getKey)
                    .forGetter(GrassSeedsInteractionDefinition::result),
            Codec.BOOL.fieldOf("on_top")
                    .forGetter(GrassSeedsInteractionDefinition::onTop)
    ).apply(instance, GrassSeedsInteractionDefinition::new));

    public GrassSeedsInteractionDefinition(Block soil, Block result, boolean onTop) {
        this.soil = soil;
        this.result = result;
        this.onTop = onTop;
    }
}
