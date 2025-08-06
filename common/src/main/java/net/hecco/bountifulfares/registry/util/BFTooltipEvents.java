package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class BFTooltipEvents {
    public static void addTooltipsToVanillaItemsFabric(ItemStack itemStack, Item.TooltipContext tooltipContext, TooltipFlag tooltipType, List<Component> tooltip) {
        addTooltipsToVanillaItems(itemStack, tooltip);
    }

    public static void addTooltipsToVanillaItems(ItemStack itemStack, List<Component> tooltip) {
        if (BountifulFares.CONFIG.effectTooltips) {
            if (itemStack.getItem() == Items.MILK_BUCKET) {
                tooltip.add(1, CommonComponents.EMPTY);
                tooltip.add(2, Component.translatable("tooltip.bountifulfares.when_drunk").withStyle(ChatFormatting.GRAY));
                tooltip.add(3, Component.translatable("tooltip.bountifulfares.removes_all_effects").withStyle(ChatFormatting.BLUE));
            }
            if (itemStack.getItem() == Items.HONEY_BOTTLE) {
                tooltip.add(1, CommonComponents.EMPTY);
                tooltip.add(2, Component.translatable("tooltip.bountifulfares.removes").withStyle(ChatFormatting.GRAY));
                tooltip.add(3, Component.translatable(new MobEffectInstance(MobEffects.POISON).getDescriptionId().formatted(MobEffects.POISON.value().getCategory().getTooltipFormatting())).withStyle(ChatFormatting.RED));
            }
        }
    }
}
