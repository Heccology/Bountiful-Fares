package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.registry.content.BFBoats;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBoat.class)
public abstract class ChestBoatMixin extends Boat {
    public ChestBoatMixin(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At(value = "RETURN"), method = "getDropItem", cancellable = true)
    public void bountifulfares$getDropItem(CallbackInfoReturnable<Item> cir) {
        if (this.getVariant() == BFBoats.HOARY) {
            cir.setReturnValue(BFItems.HOARY_CHEST_BOAT.get());
        }
        if (this.getVariant() == BFBoats.WALNUT) {
            cir.setReturnValue(BFItems.WALNUT_CHEST_BOAT.get());
        }
    }
}
