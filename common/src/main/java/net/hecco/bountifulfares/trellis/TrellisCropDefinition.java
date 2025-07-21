package net.hecco.bountifulfares.trellis;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public record TrellisCropDefinition(Item seeds, Item produce, int stages, ResourceLocation model) {
    public static final Codec<TrellisCropDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("seeds")
                    .xmap(BuiltInRegistries.ITEM::get, BuiltInRegistries.ITEM::getKey)
                    .forGetter(TrellisCropDefinition::seeds),
            ResourceLocation.CODEC.fieldOf("produce")
                    .xmap(BuiltInRegistries.ITEM::get, BuiltInRegistries.ITEM::getKey)
                    .forGetter(TrellisCropDefinition::produce),
            Codec.INT.fieldOf("stages").forGetter(TrellisCropDefinition::stages),
            ResourceLocation.CODEC.fieldOf("model").forGetter(TrellisCropDefinition::model)
    ).apply(instance, TrellisCropDefinition::new));

    public TrellisCropDefinition(Item seeds, Item produce, int stages, ResourceLocation model) {
        this.seeds = seeds;
        this.produce = produce;
        this.stages = stages;
        this.model = model;
    }
}
