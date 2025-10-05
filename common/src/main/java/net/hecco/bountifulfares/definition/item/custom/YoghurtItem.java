package net.hecco.bountifulfares.definition.item.custom;

import net.hecco.bountifulfares.definition.platform.Services;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;

import java.util.List;

public class YoghurtItem extends Item {
    public final List<MobEffectInstance> effects;
    public YoghurtItem(List<MobEffectInstance> effects, Properties settings) {
        super(settings);
        this.effects = effects;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        super.appendHoverText(stack, context, tooltip, type);
        if (Services.PLATFORM.get().getBoolConfigValue("effectTooltips")) {
            if (effects != null && !effects.isEmpty()) {
                PotionContents.addPotionTooltip(effects, tooltip::add, 1.0F, context.tickRate());
                tooltip.add(Component.empty());
            }
            tooltip.add(Component.translatable("tooltip.bountifulfares.when_drunk").withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.translatable("tooltip.bountifulfares.dilutes_negative_effects").withStyle(ChatFormatting.BLUE));
        }
    }
}
