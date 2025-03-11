package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WolfEntity.class)
public class WolfEntityMixin {
    @Inject(method = "isBreedingItem", at = @At("HEAD"), cancellable = true)
    protected void feedMulchToWolf(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Item item = stack.getItem();
        cir.setReturnValue((stack.isIn(ItemTags.WOLF_FOOD) || item.getDefaultStack().isIn(BFItemTags.MULCH)));
    }
}
