package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SweetBerryBushBlock.class)
public class SweetBerryBushMixin {

    @Inject(method = "getCloneItemStack", at = @At("HEAD"), cancellable = true)
    private void bountifulfares_replace_pickstack(LevelReader world, BlockPos pos, BlockState state, CallbackInfoReturnable<ItemStack> cir) {
        if (BountifulFares.CONFIG.enableSweetBerryPips) {
            cir.setReturnValue(BFItems.SWEET_BERRY_PIPS.getDefaultInstance());
            cir.cancel();
        }
    }
}
