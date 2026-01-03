package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.registry.content.BFBoats;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Boat.class)
public abstract class BoatMixin {
    @Shadow
    public abstract Boat.Type getVariant();

    @Inject(at = @At(value = "RETURN"), method = "getDropItem", cancellable = true)
    public void bountifulfares$getDropItem(CallbackInfoReturnable<Item> cir) {
        if (this.getVariant() == BFBoats.HOARY) {
            cir.setReturnValue(BFItems.HOARY_BOAT.get());
        } else if (this.getVariant() == BFBoats.WALNUT) {
            cir.setReturnValue(BFItems.WALNUT_BOAT.get());
        }
    }
}