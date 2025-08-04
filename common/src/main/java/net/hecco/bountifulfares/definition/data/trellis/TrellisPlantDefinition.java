package net.hecco.bountifulfares.definition.data.trellis;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public record TrellisPlantDefinition(Item plant, ResourceLocation texture, String model, boolean canDuplicate) {
    public static final Codec<TrellisPlantDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("plant")
                    .xmap(BuiltInRegistries.ITEM::get, BuiltInRegistries.ITEM::getKey)
                    .forGetter(TrellisPlantDefinition::plant),
            ResourceLocation.CODEC.fieldOf("texture")
                    .forGetter(TrellisPlantDefinition::texture),
            Codec.STRING.fieldOf("model")
                    .forGetter(TrellisPlantDefinition::model),
            Codec.BOOL.fieldOf("can_duplicate")
                    .forGetter(TrellisPlantDefinition::canDuplicate)
    ).apply(instance, TrellisPlantDefinition::new));

    public TrellisPlantDefinition(Item plant, ResourceLocation texture, String model, boolean canDuplicate) {
        this.plant = plant;
        this.texture = texture;
        this.model = model;
        this.canDuplicate = canDuplicate;
    }
}
