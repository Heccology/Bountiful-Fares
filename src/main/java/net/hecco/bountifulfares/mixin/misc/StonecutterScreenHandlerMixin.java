package net.hecco.bountifulfares.mixin.misc;

import com.llamalad7.mixinextras.sugar.Local;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(StonecutterMenu.class)
public abstract class StonecutterScreenHandlerMixin {

    @Shadow
    @Final
    Slot inputSlot;

    @Inject(method = "setupResultSlot", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;enabledFeatures()Lnet/minecraft/world/flag/FeatureFlagSet;"))
    public void bountifulfares$populateResult(CallbackInfo ci, @Local ItemStack itemStack) {
        //note to Hecco: you can change this if statement to your liking, maybe have a list of all ceramic block items instead
        //because this currently will apply to ANY dyeable item put into stonecutter that has recipes
        //not that it is a bad thing, just saying...
        //if you DO change it, also check out StonecutterScreenMixin
        if(Objects.equals(BuiltInRegistries.ITEM.getKey(this.inputSlot.getItem().getItem()).getNamespace(), BountifulFares.MOD_ID) && this.inputSlot.getItem().has(DataComponents.DYED_COLOR)){
            itemStack.set(DataComponents.DYED_COLOR, this.inputSlot.getItem().get(DataComponents.DYED_COLOR));
        }
    }
}