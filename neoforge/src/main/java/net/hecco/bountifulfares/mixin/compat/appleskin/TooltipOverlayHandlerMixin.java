package net.hecco.bountifulfares.mixin.compat.appleskin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.item.custom.TiffinItem;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import squeek.appleskin.client.TooltipOverlayHandler;

@Mixin(TooltipOverlayHandler.class)
public abstract class TooltipOverlayHandlerMixin {

    @WrapOperation(method = "gatherTooltips", at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/client/event/RenderTooltipEvent$GatherComponents;getItemStack()Lnet/minecraft/world/item/ItemStack;"))
    public ItemStack bountifulfares$gatherTooltips(RenderTooltipEvent.GatherComponents instance, Operation<ItemStack> original) {
        ItemStack itemStack = original.call(instance);
        if(itemStack.getItem() instanceof TiffinItem
                && itemStack.has(BFComponents.TIFFIN_CONTENTS.get())){
            ItemStack tiffinFoodStack = itemStack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack();
            if(!tiffinFoodStack.isEmpty()
                    && tiffinFoodStack.has(DataComponents.FOOD)
                    && !(tiffinFoodStack.is(Items.PUMPKIN_PIE) && BountifulFares.CONFIG.enablePlaceablePumpkinPie)){
                return tiffinFoodStack;
            }
        }
        return itemStack;
    }

    @Inject(method = "gatherTooltips", at = @At("HEAD"), cancellable = true)
    public void bountifulfares$gatherTooltips(RenderTooltipEvent.GatherComponents event, CallbackInfo ci) {
        if (event.getItemStack().is(Items.PUMPKIN_PIE) && BountifulFares.CONFIG.enablePlaceablePumpkinPie) {
            ci.cancel();
        }
    }

}
