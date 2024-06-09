package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.util.BFItemTags;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WolfEntity.class)
public class WolfEntityMixin {
    @Inject(method = "isBreedingItem", at = @At("HEAD"), cancellable = true)
    protected void feedMulchToWolf(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Item item = stack.getItem();
        cir.setReturnValue((item.isFood() && item.getFoodComponent().isMeat()) || item.getDefaultStack().isIn(BFItemTags.MULCH));
    }
}
