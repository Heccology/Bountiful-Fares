package net.hecco.bountifulfares.mixin.misc;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.StonecutterScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.StonecutterScreenHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(StonecutterScreen.class)
public abstract class StonecutterScreenMixin extends HandledScreen<StonecutterScreenHandler> {

    public StonecutterScreenMixin(StonecutterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @ModifyArg(method = "renderRecipeIcons", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawItem(Lnet/minecraft/item/ItemStack;II)V"))
    public ItemStack bountifulfares$renderRecipeIcons(ItemStack itemStack) {
        //note to Hecco: you can change this if statement to your liking, maybe have a list of all ceramic block items instead
        //because this currently will apply to ANY dyeable item put into stonecutter that has recipes
        //not that it is a bad thing, just saying...
        //if you DO change it, also check out StonecutterScreenHandlerMixin
        if(this.handler.getSlot(0).getStack().contains(DataComponentTypes.DYED_COLOR)){
            itemStack.set(DataComponentTypes.DYED_COLOR, this.handler.getSlot(0).getStack().get(DataComponentTypes.DYED_COLOR));
        }
        return itemStack;
    }
}