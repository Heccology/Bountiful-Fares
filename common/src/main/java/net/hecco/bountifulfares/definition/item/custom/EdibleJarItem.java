package net.hecco.bountifulfares.definition.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;

import java.util.List;

public class EdibleJarItem extends Item {
    public List<MobEffectInstance> effects;
    public SoundEvent eatSound;

    public EdibleJarItem(Properties settings) {
        super(settings);
        this.eatSound = SoundEvents.GENERIC_EAT;
    }

    public EdibleJarItem(List<MobEffectInstance> effects, SoundEvent eatSound, Properties settings) {
        super(settings);
        this.effects = effects;
        this.eatSound = eatSound;
    }

    public EdibleJarItem(List<MobEffectInstance> effects, Properties settings) {
        super(settings);
        this.effects = effects;
        this.eatSound = SoundEvents.GENERIC_EAT;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        super.finishUsingItem(stack, world, user);
        if (user instanceof ServerPlayer serverPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.awardStat(Stats.ITEM_USED.get(this));
        }
        if (stack.isEmpty()) {
            return new ItemStack(BFItems.CUP.get());
        } else {
            if (user instanceof Player && !((Player)user).getAbilities().instabuild) {
                ItemStack itemStack = new ItemStack(BFItems.CUP.get());
                Player playerEntity = (Player)user;
                if (!playerEntity.getInventory().add(itemStack)) {
                    playerEntity.drop(itemStack, false);
                }
            }

            return stack;
        }
    }

    @Override
    public SoundEvent getEatingSound() {
        return eatSound;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type) {
        super.appendHoverText(stack, context, tooltip, type);
        if (!effects.isEmpty() && BountifulFares.CONFIG.effectTooltips) {
            PotionContents.addPotionTooltip(effects, tooltip::add, 1.0F, context.tickRate());
        }
    }
}
