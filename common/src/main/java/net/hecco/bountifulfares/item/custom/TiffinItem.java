package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.item.component.TiffinContents;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.math.Fraction;

public class TiffinItem extends Item {
    public TiffinItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        FoodProperties foodproperties = null;
        if (itemstack.getComponents().has(BFComponents.TIFFIN_CONTENTS)) {
            Item item = itemstack.get(BFComponents.TIFFIN_CONTENTS).getItem();
            if (item != null && item != Items.AIR && item.getDefaultInstance().has(DataComponents.FOOD)) {
                foodproperties = itemstack.get(BFComponents.TIFFIN_CONTENTS).getItem().getDefaultInstance().get(DataComponents.FOOD);
            }
        }
        if (foodproperties != null) {
            if (player.canEat(foodproperties.canAlwaysEat())) {
                player.startUsingItem(usedHand);
                return InteractionResultHolder.consume(itemstack);
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        } else {
            return InteractionResultHolder.pass(player.getItemInHand(usedHand));
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        FoodProperties foodproperties = null;
        if (stack.getComponents().has(BFComponents.TIFFIN_CONTENTS)) {
            Item item = stack.get(BFComponents.TIFFIN_CONTENTS).getItem();
            if (item != null && item != Items.AIR && item.getDefaultInstance().has(DataComponents.FOOD)) {
                foodproperties = stack.get(BFComponents.TIFFIN_CONTENTS).getItem().getDefaultInstance().get(DataComponents.FOOD);
            }
        }
        if (livingEntity instanceof Player player && player.isCreative()) {
        } else {
            if (stack.has(BFComponents.TIFFIN_CONTENTS)) {
                TiffinContents.Mutable contents = new TiffinContents.Mutable(stack.get(BFComponents.TIFFIN_CONTENTS));
                contents.decrement();
                stack.set(BFComponents.TIFFIN_CONTENTS, contents.toImmutable());
            }
        }
        return foodproperties != null ? livingEntity.eat(level, stack, foodproperties) : stack;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_EAT;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_EAT;
    }


    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        FoodProperties foodproperties = null;
        if (stack.getComponents().has(BFComponents.TIFFIN_CONTENTS)) {
            Item item = stack.get(BFComponents.TIFFIN_CONTENTS).getItem();
            if (item != null && item != Items.AIR && item.getDefaultInstance().has(DataComponents.FOOD)) {
                foodproperties = stack.get(BFComponents.TIFFIN_CONTENTS).getItem().getDefaultInstance().get(DataComponents.FOOD);
                return foodproperties.eatDurationTicks();
            }
        }
        return super.getUseDuration(stack, entity);
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack other, Slot slot, ClickAction action, Player player, SlotAccess access) {
        if (action == ClickAction.SECONDARY && slot.allowModification(player)) {
            TiffinContents contents = stack.getComponents().get(BFComponents.TIFFIN_CONTENTS);
            if (contents == null) {
                return false;
            } else {
                TiffinContents.Mutable mutable = new TiffinContents.Mutable(contents);
                if (other.is(mutable.getItem().getCraftingRemainingItem())) {
                    boolean i = mutable.tryRemove(other, access, player);
                    if (i) {
                        player.playSound(SoundEvents.SHULKER_BOX_CLOSE, 0.8F, 0.8F + player.level().getRandom().nextFloat() * 0.4F);
                    }
                } else {
                    int i = mutable.tryFill(other, access, player);
                    if (i > 0) {
                        player.playSound(SoundEvents.SHULKER_BOX_OPEN, 0.8F, 0.8F + player.level().getRandom().nextFloat() * 0.4F);
                    }
                }
                stack.set(BFComponents.TIFFIN_CONTENTS, mutable.toImmutable());
                return true;
            }
        }
        return false;
    }


    public boolean isBarVisible(ItemStack stack) {
        TiffinContents contents = stack.getOrDefault(BFComponents.TIFFIN_CONTENTS, new TiffinContents(Items.AIR, 0));
        return contents.getCount() > 0;
    }

    public int getBarWidth(ItemStack stack) {
        TiffinContents contents = stack.getOrDefault(BFComponents.TIFFIN_CONTENTS, new TiffinContents(Items.AIR, 0));
        return Math.min(1 + Mth.mulAndTruncate(Fraction.getFraction(contents.getCount(), TiffinContents.CAPACITY), 12), 13);
    }

    public int getBarColor(ItemStack stack) {
        return Mth.color(0.9F, 0.6F, 0.2F);
    }
}
