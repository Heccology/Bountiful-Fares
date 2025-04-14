package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class BFTooltipEvents {
    public static void addTooltipsToVanillaItems(ItemStack itemStack, Item.TooltipContext tooltipContext, TooltipType tooltipType, List<Text> tooltip) {
        if (BountifulFares.CONFIG.effectTooltips) {
            if (itemStack.getItem() == Items.MILK_BUCKET) {
                tooltip.add(ScreenTexts.EMPTY);
                tooltip.add(Text.translatable("tooltip.bountifulfares.when_drunk").formatted(Formatting.GRAY));
                tooltip.add(Text.translatable("tooltip.bountifulfares.removes_all_effects").formatted(Formatting.BLUE));
            } else if (itemStack.getItem() == Items.HONEY_BOTTLE) {
                tooltip.add(ScreenTexts.EMPTY);
                tooltip.add(Text.translatable("tooltip.bountifulfares.removes").formatted(Formatting.GRAY));
                tooltip.add(Text.translatable(new StatusEffectInstance(StatusEffects.POISON).getTranslationKey().formatted(StatusEffects.POISON.value().getCategory().getFormatting())).formatted(Formatting.RED));
            }
        }
    }
}
