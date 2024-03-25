package net.hecco.bountifulfares.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AcidicEffect extends StatusEffect {
    private final List<StatusEffectInstance> affectedEffects;
    protected AcidicEffect(StatusEffectCategory category, int color) {
        super(category, color);
        this.affectedEffects = new ArrayList<>();
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!entity.getStatusEffects().isEmpty()) {
            affectedEffects.clear();
            List<StatusEffectInstance> effectsToModify = new ArrayList<>();
            for (StatusEffectInstance effect : entity.getStatusEffects()) {
                if (effect.getEffectType() != this) {
                    if (effect.getEffectType() != StatusEffects.HERO_OF_THE_VILLAGE || effect.getEffectType() != StatusEffects.BAD_OMEN) {
                        // goes through each effect on the entity that should be affected and increases the amplifier
                        int newAmplifier = effect.getAmplifier() + amplifier + 1;
                        if (newAmplifier > 255) {
                            newAmplifier = 255;
                        }
                        StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                        effectsToModify.add(newEffect);
                        affectedEffects.add(newEffect);
                    }
                }
            }
            if (!effectsToModify.isEmpty()) {
                for (StatusEffectInstance effect : effectsToModify) {
                    //applies the new effects
                    entity.removeStatusEffect(effect.getEffectType());
                    entity.addStatusEffect(effect);
                }
            }
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getStatusEffects().isEmpty()) {
            List<StatusEffectInstance> effectsToModify = new ArrayList<>();

            for (StatusEffectInstance effect : entity.getStatusEffects()) {
                //iterates through every effect on the entity and checks if it wasnt already amplified
                boolean alreadyAffected = affectedEffects.stream().anyMatch(prev -> prev.getEffectType() == effect.getEffectType());

                if (!alreadyAffected && effect.getEffectType() != this) {
                    if (effect.getEffectType() != StatusEffects.HERO_OF_THE_VILLAGE || effect.getEffectType() != StatusEffects.BAD_OMEN) {
                        //increases amplifier and creates an instance
                        int newAmplifier = effect.getAmplifier() + amplifier + 1;
                        if (newAmplifier > 255) {
                            newAmplifier = 255;
                        }
                        StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                        effectsToModify.add(newEffect);
                        affectedEffects.add(newEffect);
                    }
                }
            }

            //resets effects on the entity
            if (!effectsToModify.isEmpty()) {
                effectsToModify.forEach(instance -> entity.removeStatusEffect(instance.getEffectType()));
                effectsToModify.forEach(entity::addStatusEffect);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }




    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!entity.getStatusEffects().isEmpty()) {
            List<StatusEffectInstance> effectsToModify = new ArrayList<>();

            Iterator<StatusEffectInstance> iterator = affectedEffects.iterator();
            while (iterator.hasNext()) {
                StatusEffectInstance effect = iterator.next();

                if (effect.getEffectType() != this && entity.hasStatusEffect(effect.getEffectType())) {
                    if (effect.getEffectType() != StatusEffects.HERO_OF_THE_VILLAGE || effect.getEffectType() != StatusEffects.BAD_OMEN) {
                        int newAmplifier = effect.getAmplifier() - amplifier - 1;
                        if (newAmplifier < 0) {
                            newAmplifier = 0;
                        }
                        StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                        effectsToModify.add(newEffect);
                        iterator.remove();
                    }
                }
            }

            if (!effectsToModify.isEmpty()) {
                effectsToModify.forEach(instance -> entity.removeStatusEffect(instance.getEffectType()));
                effectsToModify.forEach(entity::addStatusEffect);
            }
        }
        super.onApplied(entity, attributes, amplifier);
        affectedEffects.clear();
    }



    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }


//    @Override
//    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
//        List<StatusEffectInstance> entityEffects = new ArrayList<>();
//        List<StatusEffectInstance> effectsToModify = new ArrayList<>();
//        for (StatusEffectInstance effect : entity.getStatusEffects()) {
//            if (effect.getEffectType() != this) {
//                entityEffects.add(effect);
//            }
//        }
//
//        for (StatusEffectInstance ignored : entityEffects) {
//            for (int i = 0; i < affectedEffects.size(); i++) {
//                if (!affectedEffects.contains(entityEffects.get(i))) {
//                    effectsToModify.add(entityEffects.get(i));
//                }
//            }
//        }
//        for (StatusEffectInstance effect : effectsToModify) {
//            if (effect.getEffectType() != this) {
//                // goes through each effect on the entity that isn't Acidic and increases the amplifier
//                int newAmplifier = effect.getAmplifier() + amplifier + 1;
//                if (newAmplifier > 255) {
//                    newAmplifier = 255;
//                }
//                StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
//                affectedEffects.add(newEffect);
//            }
//        }
//        for (StatusEffectInstance effect : affectedEffects) {
//            //applies the new effects
//            entity.removeStatusEffect(effect.getEffectType());
//            entity.addStatusEffect(effect);
//        }
//    }
}
