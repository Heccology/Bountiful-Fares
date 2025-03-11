package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class AirTimeIncreasingItem extends EffectFoodItem {
    public int airTickIncrease;
    public AirTimeIncreasingItem(int airTickIncrease, Settings settings) {
        super(List.of(), settings);
        this.airTickIncrease = airTickIncrease;
    }
    public AirTimeIncreasingItem(List<StatusEffectInstance> effects, int airTickIncrease, Settings settings) {
        super(effects, settings);
        this.airTickIncrease = airTickIncrease;
    }



    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        int air = user.getAir();
        int maxAir = user.getMaxAir();
        if (air < maxAir - airTickIncrease){
            user.setAir(air + airTickIncrease);
        } else {
            user.setAir(maxAir);
        }
        return super.finishUsing(stack, world, user);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (BountifulFares.CONFIG.effectTooltips) {
            tooltip.add(ScreenTexts.EMPTY);
            tooltip.add(Text.translatable("tooltip.bountifulfares.when_eaten").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("+" + airTickIncrease / 20 + " ").append(Text.translatable("tooltip.bountifulfares.air_time")).formatted(Formatting.BLUE));
        }
    }
}
