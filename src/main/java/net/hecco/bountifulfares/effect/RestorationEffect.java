package net.hecco.bountifulfares.effect;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

public class RestorationEffect extends StatusEffect {
    private float regenMax;
    protected RestorationEffect(StatusEffectCategory category, int color) {
        super(category, color);
        this.regenMax = 0;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        regenMax = health;
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        float health = entity.getHealth();
        float maxHealth = entity.getMaxHealth();
        if (health < regenMax && health < maxHealth) {
            entity.heal(0.1f * (amplifier + 1));
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        regenMax = 0;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
