package net.hecco.bountifulfares.definition.effect;

import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.registry.tags.BFEffectTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;

public class StuporEffect extends MobEffect {
    public StuporEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

//    @Override
//    public void onEffectStarted(LivingEntity livingEntity, int amplifier) {
//        ArrayList<MobEffectInstance> removedEffects = new ArrayList<>();
//        for (MobEffectInstance effectInstance : livingEntity.getActiveEffects()) {
//            if (effectInstance.getEffect() != BFEffects.STUPOR && !effectInstance.getEffect().is(BFEffectTags.STUPOR_BLACKLIST)) {
//                removedEffects.add(effectInstance);
//            }
//        }
//        for (MobEffectInstance effectInstance : removedEffects) {
//            livingEntity.removeEffect(effectInstance.getEffect());
//        }
//        super.onEffectStarted(livingEntity, amplifier);
//    }
}
