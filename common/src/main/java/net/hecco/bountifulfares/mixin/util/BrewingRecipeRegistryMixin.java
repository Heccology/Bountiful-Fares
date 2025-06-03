package net.hecco.bountifulfares.mixin.util;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFPotions;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PotionBrewing.class)
public class BrewingRecipeRegistryMixin {
    @Inject(method = "addVanillaMixes", at = @At("TAIL"))
    private static void registerDefaults(PotionBrewing.Builder builder, CallbackInfo ci) {
        builder.addMix(Potions.AWKWARD, BFItems.CITRUS_ESSENCE, BFPotions.ACIDIC);
        builder.addMix(BFPotions.ACIDIC, Items.REDSTONE, BFPotions.LONG_ACIDIC);
        builder.addMix(BFPotions.ACIDIC, Items.GLOWSTONE_DUST, BFPotions.STRONG_ACIDIC);
        builder.addMix(BFPotions.ACIDIC, Items.FERMENTED_SPIDER_EYE, BFPotions.STUPOR);
        builder.addMix(BFPotions.LONG_ACIDIC, Items.FERMENTED_SPIDER_EYE, BFPotions.LONG_STUPOR);
        builder.addMix(BFPotions.STUPOR, Items.REDSTONE, BFPotions.LONG_STUPOR);
    }
}