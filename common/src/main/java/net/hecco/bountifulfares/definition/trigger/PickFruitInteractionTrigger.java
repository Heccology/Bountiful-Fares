package net.hecco.bountifulfares.definition.trigger;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hecco.bountifulfares.registry.misc.BFCriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.behavior.declarative.Trigger;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;

import java.util.Optional;

public class PickFruitInteractionTrigger extends SimpleCriterionTrigger<PickFruitInteractionTrigger.TriggerInstance> {
    public Codec<PickFruitInteractionTrigger.TriggerInstance> codec() {
        return PickFruitInteractionTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player, BlockPos pos) {
        ServerLevel serverLevel = player.serverLevel();
        BlockState blockState = serverLevel.getBlockState(pos);
        LootParams lootParams = (new LootParams.Builder(serverLevel)).withParameter(LootContextParams.ORIGIN, pos.getCenter()).withParameter(LootContextParams.THIS_ENTITY, player).withParameter(LootContextParams.BLOCK_STATE, blockState).create(LootContextParamSets.BLOCK_USE);
        LootContext lootContext = (new LootContext.Builder(lootParams)).create(Optional.empty());
        this.trigger(player, (triggerInstance) -> triggerInstance.matches(lootContext));
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player, Optional<ContextAwarePredicate> location) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<PickFruitInteractionTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create((instance) -> instance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(PickFruitInteractionTrigger.TriggerInstance::player), ContextAwarePredicate.CODEC.optionalFieldOf("location").forGetter(PickFruitInteractionTrigger.TriggerInstance::location)).apply(instance, PickFruitInteractionTrigger.TriggerInstance::new));

        public boolean matches(LootContext context) {
            return this.location.isEmpty() || this.location.get().matches(context);
        }

        public static Criterion<PickFruitInteractionTrigger.TriggerInstance> pickedAnyFruit() {
            return ((PickFruitInteractionTrigger)BFCriteriaTriggers.PICK_FRUIT.get()).createCriterion(new PickFruitInteractionTrigger.TriggerInstance(Optional.empty(), Optional.empty()));
        }

        public static Criterion<PickFruitInteractionTrigger.TriggerInstance> pickedFruit(LocationPredicate.Builder location) {
            ContextAwarePredicate contextAwarePredicate = ContextAwarePredicate.create(LocationCheck.checkLocation(location).build());
            return ((PickFruitInteractionTrigger)BFCriteriaTriggers.PICK_FRUIT.get()).createCriterion(new PickFruitInteractionTrigger.TriggerInstance(Optional.empty(), Optional.of(contextAwarePredicate)));
        }

        public void validate(CriterionValidator validator) {
            SimpleInstance.super.validate(validator);
            this.location.ifPresent((contextAwarePredicate) -> validator.validate(contextAwarePredicate, LootContextParamSets.BLOCK_USE, ".location"));
        }
    }
}
