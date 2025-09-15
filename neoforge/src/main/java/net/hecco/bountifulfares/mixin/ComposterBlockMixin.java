package net.hecco.bountifulfares.mixin;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ComposterBlock.class)
public class ComposterBlockMixin {
    @Inject(method = "getValue", at = @At("HEAD"), cancellable = true)
    private static void bountifulfares$injectCompostables(ItemStack item, CallbackInfoReturnable<Float> cir) {
        Object2FloatMap<ItemLike> map = BFRegistries.registerModCompostables();
        if (map.containsKey(item.getItem())) {
            cir.setReturnValue(map.getFloat(item.getItem()));
            cir.cancel();
        }
    }
}
