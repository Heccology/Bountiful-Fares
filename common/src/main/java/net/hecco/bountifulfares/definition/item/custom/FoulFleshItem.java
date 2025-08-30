package net.hecco.bountifulfares.definition.item.custom;

import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FoulFleshItem extends Item {
    public FoulFleshItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (player.getFoodData().getFoodLevel() <= 0) {
            return InteractionResultHolder.pass(player.getItemInHand(usedHand));
        }
        return super.use(level, player, usedHand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (level.getDifficulty() != Difficulty.PEACEFUL) {
            if (livingEntity instanceof Player player) {
                player.getFoodData().setFoodLevel(Math.max(player.getFoodData().getFoodLevel() - 2, 0));
                player.getFoodData().setSaturation(Math.max(player.getFoodData().getSaturationLevel() - 4, 0));
            }
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
