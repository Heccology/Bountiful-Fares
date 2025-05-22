package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EffectClearingItem extends Item {
    protected List<StatusEffectInstance> removedEffects;

    public EffectClearingItem(List<StatusEffectInstance> removedEffects, Settings settings) {
        super(settings);
        this.removedEffects = removedEffects;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            for (RegistryEntry<StatusEffect> effect : getStatusEffectsToRemove()) {
                user.removeStatusEffect(effect);
            }
        }
        return stack;
    }

    public ArrayList<RegistryEntry<StatusEffect>> getStatusEffectsToRemove() {
        return new ArrayList<>();
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (BountifulFares.CONFIG.effectTooltips) {
            tooltip.add(ScreenTexts.EMPTY);
            tooltip.add(Text.translatable("tooltip.bountifulfares.removes").formatted(Formatting.GRAY));
            for (StatusEffectInstance effect : removedEffects) {
                tooltip.add(Text.translatable(effect.getTranslationKey().formatted(effect.getEffectType().value().getCategory().getFormatting())).formatted(Formatting.RED));
            }
        }
    }
}
