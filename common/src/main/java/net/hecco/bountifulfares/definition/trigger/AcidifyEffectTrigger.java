package net.hecco.bountifulfares.definition.trigger;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.registry.misc.BFCriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class AcidifyEffectTrigger extends SimpleCriterionTrigger<AcidifyEffectTrigger.TriggerInstance> {
    public Codec<AcidifyEffectTrigger.TriggerInstance> codec() {
        return AcidifyEffectTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player, Integer levelIncrease) {
        this.trigger(player, (triggerInstance) -> triggerInstance.matches(levelIncrease));
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player, Optional<Integer> levelIncrease) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<AcidifyEffectTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(AcidifyEffectTrigger.TriggerInstance::player), Codec.INT.optionalFieldOf("level_increase").forGetter(AcidifyEffectTrigger.TriggerInstance::levelIncrease)).apply(instance, AcidifyEffectTrigger.TriggerInstance::new));

        public boolean matches(int levelIncrease) {
            return this.levelIncrease.isEmpty() || this.levelIncrease.get().equals(levelIncrease);
        }

        public static Criterion<AcidifyEffectTrigger.TriggerInstance> acidifiedAnyAmount() {
            return ((AcidifyEffectTrigger) BFCriteriaTriggers.ACIDIFY_EFFECT.get()).createCriterion(new AcidifyEffectTrigger.TriggerInstance(Optional.empty(), Optional.empty()));
        }

        public static Criterion<AcidifyEffectTrigger.TriggerInstance> acidified(int levelIncrease) {
            return ((AcidifyEffectTrigger)BFCriteriaTriggers.ACIDIFY_EFFECT.get()).createCriterion(new AcidifyEffectTrigger.TriggerInstance(Optional.empty(), Optional.of(levelIncrease)));
        }
    }
}
