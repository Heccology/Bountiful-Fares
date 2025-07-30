package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.item.custom.TiffinItem;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @ModifyVariable(method = "spawnItemParticles", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private ItemStack bountifulfares$setTiffinFoodParticles(ItemStack value) {
        if (value.getItem() instanceof TiffinItem && value.has(BFComponents.TIFFIN_CONTENTS.get())) {
            return value.get(BFComponents.TIFFIN_CONTENTS.get()).getItem().getDefaultInstance();
        }
        return value;
    }
}
