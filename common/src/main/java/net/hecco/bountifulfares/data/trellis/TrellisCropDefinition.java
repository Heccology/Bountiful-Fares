package net.hecco.bountifulfares.data.trellis;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public record TrellisCropDefinition(Item seeds, Item produce, ResourceLocation texture, String model, int stages, float growChance, int minDrops, int maxDrops) {
    public static final Codec<TrellisCropDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("seeds")
                    .xmap(BuiltInRegistries.ITEM::get, BuiltInRegistries.ITEM::getKey)
                    .forGetter(TrellisCropDefinition::seeds),
            ResourceLocation.CODEC.fieldOf("produce")
                    .xmap(BuiltInRegistries.ITEM::get, BuiltInRegistries.ITEM::getKey)
                    .forGetter(TrellisCropDefinition::produce),
            ResourceLocation.CODEC.fieldOf("texture")
                    .forGetter(TrellisCropDefinition::texture),
            Codec.STRING.fieldOf("model")
                    .forGetter(TrellisCropDefinition::model),
            Codec.intRange(1, 8).fieldOf("stages")
                    .forGetter(TrellisCropDefinition::stages),
            Codec.floatRange(0.0F, 1.0F).fieldOf("grow_chance")
                    .forGetter(TrellisCropDefinition::growChance),
            Codec.intRange(1, 64).fieldOf("min_drops")
                    .forGetter(TrellisCropDefinition::minDrops),
            Codec.intRange(1, 64).fieldOf("max_drops")
                    .forGetter(TrellisCropDefinition::maxDrops)
    ).apply(instance, TrellisCropDefinition::new));

    public TrellisCropDefinition(Item seeds, Item produce, ResourceLocation texture, String model, int stages, float growChance, int minDrops, int maxDrops) {
        this.seeds = seeds;
        this.produce = produce;
        this.texture = texture;
        this.model = model;
        this.stages = stages;
        this.growChance = growChance;
        this.minDrops = minDrops;
        this.maxDrops = maxDrops;
    }
}
