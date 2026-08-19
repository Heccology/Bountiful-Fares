package net.hecco.bountifulfares.definition.item.custom;

import net.hecco.bountifulfares.definition.item.component.TiffinContents;
import net.hecco.bountifulfares.definition.item.component.TiffinTooltip;
import net.hecco.bountifulfares.definition.networking.payload.TiffinFillPayload;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.definition.trigger.CraftFoodInTiffinTrigger;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.misc.BFCriteriaTriggers;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.math.Fraction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TiffinItem extends Item {
    private static final Map<DyeColor, TiffinItem> DYE_TO_TIFFIN = new HashMap<>();
    public TiffinItem(DyeColor color, Properties properties) {
        super(properties);
        DYE_TO_TIFFIN.put(color, this);
    }

    public static TiffinItem getItemFromDye(DyeColor color) {
        return DYE_TO_TIFFIN.get(color);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        FoodProperties foodproperties = null;
        if (itemstack.getComponents().has(BFComponents.TIFFIN_CONTENTS.get())) {
            ItemStack stack = itemstack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack();
            if (stack.is(Items.PUMPKIN_PIE) && Services.PLATFORM.get().getBoolConfigValue("enablePlaceablePumpkinPie")){
                return InteractionResultHolder.fail(itemstack);
            }
            if (!stack.isEmpty() && !(stack.getItem() instanceof TiffinItem) && stack.has(DataComponents.FOOD)) {
                foodproperties = stack.get(DataComponents.FOOD);
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
            return InteractionResultHolder.fail(itemstack);
        }
    }

    public static Item getRemainderItem(Item item) {
        if (item.hasCraftingRemainingItem()) {
            return item.getCraftingRemainingItem();
        }
        if (item.getDefaultInstance().has(DataComponents.FOOD)) {
            if (item.getDefaultInstance().get(DataComponents.FOOD).usingConvertsTo().isPresent()) {
                return item.getDefaultInstance().get(DataComponents.FOOD).usingConvertsTo().get().getItem();
            }
        }
        return null;
    }

    public static boolean canInsertStack(ItemStack stack, TiffinContents contents) {
        if (stack.is(Items.PUMPKIN_PIE) && Services.PLATFORM.get().getBoolConfigValue("enablePlaceablePumpkinPie")) return false;
        return !(stack.getItem() instanceof TiffinItem) && stack.has(DataComponents.FOOD) && (getRemainderItem(stack.getItem()) == null || getRemainderItem(stack.getItem()).getDefaultInstance().is(BFItemTags.FOOD_CONTAINERS_TIFFINS_CAN_HOLD)) && (ItemStack.isSameItemSameComponents(contents.getItemStack(), stack) || contents.getItemStack().isEmpty());
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack itemStack;
        if (stack.getComponents().has(BFComponents.TIFFIN_CONTENTS.get())) {
            ItemStack item = stack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack();
            if (!item.isEmpty() && !(item.getItem() instanceof TiffinItem) && item.has(DataComponents.FOOD)) {
                itemStack = item.copy();
                FoodProperties existingProperties = itemStack.get(DataComponents.FOOD);
                itemStack.set(DataComponents.FOOD, new FoodProperties(existingProperties.nutrition(),existingProperties.saturation(), existingProperties.canAlwaysEat(), existingProperties.eatSeconds(), Optional.empty(), existingProperties.effects()));
                itemStack.finishUsingItem(level, livingEntity);
                if (livingEntity == null || !livingEntity.hasInfiniteMaterials()) {
                    if (item.getCount() == 1) {
                        stack.set(BFComponents.TIFFIN_CONTENTS.get(), new TiffinContents());
                    } else {
                        item.shrink(1);
                    }
                }
            }
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
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
        FoodProperties foodproperties;
        if (stack.getComponents().has(BFComponents.TIFFIN_CONTENTS.get())) {
            ItemStack item = stack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack();
            if (!item.isEmpty() && !(item.getItem() instanceof TiffinItem) && item.has(DataComponents.FOOD)) {
                foodproperties = stack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().get(DataComponents.FOOD);
                return foodproperties.eatDurationTicks();
            }
        }
        return 0;
    }

    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        return !stack.has(DataComponents.HIDE_TOOLTIP) && !stack.has(DataComponents.HIDE_ADDITIONAL_TOOLTIP) ? Optional.ofNullable(stack.get(BFComponents.TIFFIN_CONTENTS.get())).map(TiffinTooltip::new) : Optional.empty();
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction action, Player player) {
        ItemStack other = slot.getItem();
        if (action == ClickAction.SECONDARY && slot.allowModification(player)) {
            TiffinContents contents = stack.getComponents().get(BFComponents.TIFFIN_CONTENTS.get());
            if (contents == null) {
                return false;
            } else {
                TiffinContents.Mutable mutable = new TiffinContents.Mutable(contents);
                if (!contents.getItemStack().isEmpty() && ((getRemainderItem(contents.getItemStack().getItem()) == null && other.isEmpty()) || other.is(getRemainderItem(contents.getItemStack().getItem())))) {
                    boolean i = mutable.tryRemove(other, slot, player);
                    if (i) {
                        player.playSound(BFSounds.TIFFIN_REMOVE.get(), 0.9F, (Fraction.getFraction(contents.getCount(), contents.CAPACITY).floatValue() / 2) + 0.8f);
                    }
                    stack.set(BFComponents.TIFFIN_CONTENTS.get(), mutable.toImmutable());
                    return true;
                } else if (canInsertStack(other, contents)) {
                    int i = mutable.tryFill(other, slot, player);
                    if (i > 0) {
                        player.playSound(BFSounds.TIFFIN_INSERT.get(), 0.9F, (Fraction.getFraction(contents.getCount(), contents.CAPACITY).floatValue() / 2) + 0.8f);
                        if (player.level().isClientSide()) {
                            NLServices.NETWORK.sendToServer(new TiffinFillPayload((double) mutable.getCount() / mutable.getCapacity()));
                        }
                    }
                    stack.set(BFComponents.TIFFIN_CONTENTS.get(), mutable.toImmutable());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack other, Slot slot, ClickAction action, Player player, SlotAccess access) {
        if (action == ClickAction.SECONDARY && slot.allowModification(player)) {
            TiffinContents contents = stack.getComponents().get(BFComponents.TIFFIN_CONTENTS.get());
            if (contents == null) {
                return false;
            } else {
                TiffinContents.Mutable mutable = new TiffinContents.Mutable(contents);
                if (!contents.getItemStack().isEmpty() && ((getRemainderItem(contents.getItemStack().getItem()) == null && other.isEmpty()) || other.is(getRemainderItem(contents.getItemStack().getItem())))) {
                    boolean i = mutable.tryRemove(other, access, player);
                    if (i) {
                        player.playSound(BFSounds.TIFFIN_REMOVE.get(), 0.9F, (Fraction.getFraction(contents.getCount(), contents.CAPACITY).floatValue() / 2) + 0.8f);
                    }
                    stack.set(BFComponents.TIFFIN_CONTENTS.get(), mutable.toImmutable());
                    return true;
                } else if (canInsertStack(other, contents)) {
                    int i = mutable.tryFill(other, access, player);
                    if (i > 0) {
                        player.playSound(BFSounds.TIFFIN_INSERT.get(), 0.9F, (Fraction.getFraction(contents.getCount(), contents.CAPACITY).floatValue() / 2) + 0.8f);
                        if (player.level().isClientSide()) {
                            NLServices.NETWORK.sendToServer(new TiffinFillPayload((double) mutable.getCount() / mutable.getCapacity()));
                        }
                    }
                    stack.set(BFComponents.TIFFIN_CONTENTS.get(), mutable.toImmutable());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (player instanceof ServerPlayer serverPlayer && stack.get(BFComponents.TIFFIN_CONTENTS.get()) != null) {
            ((CraftFoodInTiffinTrigger) BFCriteriaTriggers.CRAFT_FOOD_IN_TIFFIN.get()).trigger(serverPlayer, stack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack());
        }
        super.onCraftedBy(stack, level, player);
    }

    public boolean isBarVisible(ItemStack stack) {
        TiffinContents contents = stack.getOrDefault(BFComponents.TIFFIN_CONTENTS.get(), new TiffinContents());
        return contents.getCount() > 0;
    }

    public int getBarWidth(ItemStack stack) {
        TiffinContents contents = stack.getOrDefault(BFComponents.TIFFIN_CONTENTS.get(), new TiffinContents());
        return Math.min(1 + Mth.mulAndTruncate(Fraction.getFraction(contents.getCount(), contents.CAPACITY), 12), 13);
    }

    public int getBarColor(ItemStack stack) {
        return Mth.color(0.9F, 0.6F, 0.2F);
    }
}
