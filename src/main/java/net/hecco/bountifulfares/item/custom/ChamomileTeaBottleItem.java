package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.ArrayList;
import java.util.List;

public class ChamomileTeaBottleItem extends TeaBottleItem{
    public ChamomileTeaBottleItem(Properties settings) {
        super(List.of(new MobEffectInstance(MobEffects.CONFUSION), new MobEffectInstance(MobEffects.POISON), new MobEffectInstance(BFEffects.ACIDIC)), settings);
    }
    public ArrayList<Holder<MobEffect>> getStatusEffectsToRemove() {
        ArrayList<Holder<MobEffect>> list = new ArrayList<>();
        list.add(MobEffects.CONFUSION);
        list.add(MobEffects.POISON);
        list.add(BFEffects.ACIDIC);
        return list;
    }
}
