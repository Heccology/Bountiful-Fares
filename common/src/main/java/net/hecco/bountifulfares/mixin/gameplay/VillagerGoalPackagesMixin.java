package net.hecco.bountifulfares.mixin.gameplay;

import com.google.common.collect.ImmutableList;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.datafixers.util.Pair;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.entity.villager.HarvestTrellis;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.behavior.RunOne;
import net.minecraft.world.entity.ai.behavior.VillagerGoalPackages;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Mixin(VillagerGoalPackages.class)
public class VillagerGoalPackagesMixin {

    @ModifyReturnValue(method = "getWorkPackage", at = @At("RETURN"))
    private static ImmutableList<Pair<Integer, ? extends BehaviorControl<? super Villager>>> bountifulfares$TrellisHarvestGoal(ImmutableList<Pair<Integer, ? extends BehaviorControl<? super Villager>>> original) {
        List<Pair<Integer, ? extends BehaviorControl<? super Villager>>> mutable = new ArrayList<>(original);
        for (int i = 1; i < original.size(); i++) {
            Pair<Integer, ? extends BehaviorControl<? super Villager>> pair = original.get(i);
            if (pair.getFirst() == 5 && pair.getSecond() instanceof RunOne<?> runOne) {
                List<Pair<? extends BehaviorControl<? super Villager>, Integer>> behaviors = new ArrayList<>(((ShufflingListAccessor) ((RunOneAccessor) runOne).getBehaviors()).getEntries().stream().map(entry -> new Pair<>(entry.getData(), entry.getWeight())).toList());
                behaviors.add(Pair.of(new HarvestTrellis(), 2));
                mutable.set(i, Pair.of(5, new RunOne<>(behaviors)));
                break;
            }
        }
        return ImmutableList.copyOf(mutable);
    }
}
