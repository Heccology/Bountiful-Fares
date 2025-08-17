package net.hecco.bountifulfares.mixin.compat.appleskin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hecco.bountifulfares.definition.item.custom.TiffinItem;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import squeek.appleskin.client.TooltipOverlayHandler;

@Mixin(TooltipOverlayHandler.class)
public abstract class TooltipOverlayHandlerMixin {

    @WrapOperation(method = "gatherTooltips", at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/client/event/RenderTooltipEvent$GatherComponents;getItemStack()Lnet/minecraft/world/item/ItemStack;"))
    public ItemStack bountifulfares$gatherTooltips(RenderTooltipEvent.GatherComponents instance, Operation<ItemStack> original) {
        ItemStack itemStack = original.call(instance);
        if(itemStack.getItem() instanceof TiffinItem
                && itemStack.has(BFComponents.TIFFIN_CONTENTS.get())
                && !itemStack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().isEmpty()
                && itemStack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().has(DataComponents.FOOD)){
            return itemStack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack();
        }
        return itemStack;
    }

}
