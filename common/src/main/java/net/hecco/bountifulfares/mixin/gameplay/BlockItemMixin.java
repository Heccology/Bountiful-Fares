package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.definition.platform.Services;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin {
    @Inject(method = "canPlace", at = @At("HEAD"), cancellable = true)
    private void bountifulfares$replacePickstack(BlockPlaceContext context, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (Services.PLATFORM.get().getBoolConfigValue("enableSweetBerryPips")) {
            if (context.getPlayer() != null && context.getItemInHand().is(Items.SWEET_BERRIES)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }
}
