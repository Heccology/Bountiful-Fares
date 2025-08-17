package net.hecco.bountifulfares.mixin.compat.appleskin;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.item.custom.TiffinItem;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import squeek.appleskin.client.TooltipOverlayHandler;

import java.util.List;

@Mixin(TooltipOverlayHandler.class)
public abstract class TooltipOverlayHandlerMixin {

    @Shadow public abstract void onItemTooltip(ItemStack par1, Player par2, Item.TooltipContext par3, TooltipFlag par4, List par5);

    @Inject(method = "onItemTooltip", at = @At(value = "HEAD"), cancellable = true)
    public void bountifulfares$onItemTooltip(ItemStack hoveredStack, Player player, Item.TooltipContext context, TooltipFlag type, List tooltip, CallbackInfo ci) {
        if(hoveredStack.getItem() instanceof TiffinItem
                && hoveredStack.has(BFComponents.TIFFIN_CONTENTS.get())
                && !hoveredStack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().isEmpty()
                && hoveredStack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().has(DataComponents.FOOD)){
            onItemTooltip(hoveredStack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack(), player, context, type, tooltip);
            ci.cancel();
        }
    }

}
