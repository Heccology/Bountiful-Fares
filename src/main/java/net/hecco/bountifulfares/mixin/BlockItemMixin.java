package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class BlockItemMixin {

    @Inject(method = "canPlace", at = @At("HEAD"), cancellable = true)
    private void bountifulfares_replace_pickstack(ItemPlacementContext context, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (BountifulFares.CONFIG.enableSweetBerryPips) {
            if (context.getPlayer() != null && context.getPlayer().getStackInHand(context.getPlayer().getActiveHand()).isOf(Items.SWEET_BERRIES)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }
}
