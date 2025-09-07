package net.hecco.bountifulfares.definition.trigger;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.registry.misc.BFCriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class UseArtisanBrushInInventoryTrigger extends SimpleCriterionTrigger<UseArtisanBrushInInventoryTrigger.TriggerInstance> {
    public Codec<UseArtisanBrushInInventoryTrigger.TriggerInstance> codec() {
        return UseArtisanBrushInInventoryTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, (p_43166_) -> true);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleInstance {
        public static final Codec<UseArtisanBrushInInventoryTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(UseArtisanBrushInInventoryTrigger.TriggerInstance::player)).apply(instance, UseArtisanBrushInInventoryTrigger.TriggerInstance::new));

        public static Criterion<UseArtisanBrushInInventoryTrigger.TriggerInstance> use() {
            return ((UseArtisanBrushInInventoryTrigger)BFCriteriaTriggers.USE_ARTISAN_BRUSH_IN_INVENTORY.get()).createCriterion(new UseArtisanBrushInInventoryTrigger.TriggerInstance(Optional.empty()));
        }
    }
}
