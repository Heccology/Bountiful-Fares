package net.hecco.bountifulfares.definition.item.custom;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.ArrayList;
import java.util.List;

public class BlackTeaBottleItem extends TeaBottleItem{
    public BlackTeaBottleItem(Properties settings) {
        super(List.of(new MobEffectInstance(MobEffects.WEAKNESS), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN), new MobEffectInstance(BFEffects.ACIDIC)), settings);
    }
    public ArrayList<Holder<MobEffect>> getStatusEffectsToRemove() {
        ArrayList<Holder<MobEffect>> list = new ArrayList<>();
        list.add(MobEffects.WEAKNESS);
        list.add(MobEffects.MOVEMENT_SLOWDOWN);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
