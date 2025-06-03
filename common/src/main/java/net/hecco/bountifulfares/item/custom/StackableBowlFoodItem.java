package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;

import java.util.List;

public class StackableBowlFoodItem extends Item {
    public List<MobEffectInstance> effects;

    public StackableBowlFoodItem(Item.Properties settings) {
        super(settings.craftRemainder(Items.BOWL));
    }
    public StackableBowlFoodItem(List<MobEffectInstance> effects, Item.Properties settings) {
        super(settings.craftRemainder(Items.BOWL));
        this.effects = effects;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        super.finishUsingItem(stack, world, user);
        if (user instanceof ServerPlayer serverPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.awardStat(Stats.ITEM_USED.get(this));
        }
            if (user instanceof Player && !((Player)user).getAbilities().instabuild) {
                ItemStack itemStack = new ItemStack(Items.BOWL);
                Player playerEntity = (Player)user;
                if (!playerEntity.getInventory().add(itemStack)) {
                    playerEntity.drop(itemStack, false);
                }
            }

            return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        super.appendHoverText(stack, context, tooltip, type);
        if (effects != null && !effects.isEmpty() && BountifulFares.CONFIG.effectTooltips) {
            PotionContents.addPotionTooltip(effects, tooltip::add, 1.0F, context.tickRate());
        }
    }
}
