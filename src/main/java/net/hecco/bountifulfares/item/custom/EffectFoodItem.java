package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class EffectFoodItem extends Item {
    public final List<StatusEffectInstance> effects;
    public EffectFoodItem(List<StatusEffectInstance> effects, Settings settings) {
        super(settings);
        this.effects = effects;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (effects != null && !effects.isEmpty() && BountifulFares.CONFIG.effectTooltips) {
            PotionContentsComponent.buildTooltip(effects, tooltip::add, 1.0F, context.getUpdateTickRate());
        }
    }
}
