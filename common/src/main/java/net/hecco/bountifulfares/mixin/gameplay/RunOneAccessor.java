package net.hecco.bountifulfares.mixin.gameplay;

import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.behavior.GateBehavior;
import net.minecraft.world.entity.ai.behavior.ShufflingList;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GateBehavior.class)
public interface RunOneAccessor {
    @Accessor("behaviors")
    ShufflingList<BehaviorControl<? super Villager>> getBehaviors();
}