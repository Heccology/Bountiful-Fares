package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.ArrayList;
import java.util.List;

public class BellflowerTeaBottleItem extends TeaBottleItem{
    public BellflowerTeaBottleItem(Properties settings) {
        super(List.of(new MobEffectInstance(MobEffects.LEVITATION), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN), new MobEffectInstance(BFEffects.ACIDIC)), settings);
    }
    public ArrayList<Holder<MobEffect>> getStatusEffectsToRemove() {
        ArrayList<Holder<MobEffect>> list = new ArrayList<>();
        list.add(MobEffects.LEVITATION);
        list.add(MobEffects.MOVEMENT_SLOWDOWN);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
