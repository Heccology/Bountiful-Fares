package net.hecco.bountifulfares.mixin.gameplay;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorStand.class)
public class ArmorStandMixin {

    @Shadow
    private EquipmentSlot getClickedSlot(Vec3 vector) {return EquipmentSlot.HEAD;}

    @Inject(method = "interactAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/decoration/ArmorStand;getEquipmentSlotForItem(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/entity/EquipmentSlot;", shift = At.Shift.AFTER), cancellable = true)
    private void bountifulfares$artisanBrushInteraction(Player player, Vec3 vec, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.is(BFItems.ARTISAN_BRUSH.get())) {
            EquipmentSlot equipmentslot1 = this.getClickedSlot(vec);
            ItemStack slotStack = ((ArmorStand)(Object)this).getItemBySlot(equipmentslot1);
            if (itemstack.has(DataComponents.DYED_COLOR) && (slotStack.has(DataComponents.DYED_COLOR) || (slotStack.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() == ArmorMaterials.LEATHER))) {
                slotStack.set(DataComponents.DYED_COLOR, itemstack.get(DataComponents.DYED_COLOR));
                player.level().playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                cir.setReturnValue(InteractionResult.SUCCESS);
                cir.cancel();
            }
        }
    }
}
