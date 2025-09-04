package net.hecco.bountifulfares.definition.trigger;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.definition.item.component.TiffinContents;
import net.hecco.bountifulfares.registry.misc.BFCriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;

import java.util.Optional;

public class FillTiffinTrigger extends SimpleCriterionTrigger<FillTiffinTrigger.TriggerInstance> {
    public Codec<FillTiffinTrigger.TriggerInstance> codec() {
        return FillTiffinTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player, double fullness) {
        this.trigger(player, (p_43166_) -> p_43166_.matches(fullness));
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player, MinMaxBounds.Doubles fullness) implements SimpleInstance {
        public static final Codec<FillTiffinTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(FillTiffinTrigger.TriggerInstance::player), MinMaxBounds.Doubles.CODEC.optionalFieldOf("fullness", MinMaxBounds.Doubles.ANY).forGetter(FillTiffinTrigger.TriggerInstance::fullness)).apply(instance, FillTiffinTrigger.TriggerInstance::new));

        public boolean matches(double fullness) {
            return this.fullness.matches(fullness);
        }

        public static Criterion<FillTiffinTrigger.TriggerInstance> filledTo(MinMaxBounds.Doubles fullness) {
            return ((FillTiffinTrigger)BFCriteriaTriggers.FILL_TIFFIN.get()).createCriterion(new FillTiffinTrigger.TriggerInstance(Optional.empty(), fullness));
        }
    }
}
