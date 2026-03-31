package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Villager.class)
public abstract class VillagerMixin extends AbstractVillager {

    public VillagerMixin(EntityType<? extends AbstractVillager> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "wantsToPickUp", at = @At("HEAD"), cancellable = true)
    private void bountifulfares$pickUpTrellisCrops(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(BFItemTags.VINE_CROPS) && this.getInventory().canAddItem(stack)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
