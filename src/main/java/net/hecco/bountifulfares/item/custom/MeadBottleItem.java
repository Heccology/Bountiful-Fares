package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class MeadBottleItem extends LiquidBottleItem {
    public MeadBottleItem(Settings settings) {
        super(settings);
    }
    public MeadBottleItem(List<StatusEffectInstance> effects, Settings settings) {
        super(settings);
        this.effects = effects;
    }
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user.getStatusEffect(StatusEffects.POISON) != null) {
            user.removeStatusEffect(StatusEffects.POISON);
        }
        return stack;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (BountifulFares.CONFIG.effectTooltips) {
            tooltip.add(ScreenTexts.EMPTY);
            tooltip.add(Text.translatable("tooltip.bountifulfares.removes").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable(new StatusEffectInstance(StatusEffects.POISON).getTranslationKey().formatted(StatusEffects.POISON.value().getCategory().getFormatting())).formatted(Formatting.RED));
        }
    }
}
