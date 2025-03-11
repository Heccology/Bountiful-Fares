package net.hecco.bountifulfares.mixin;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFPotions;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
    @Inject(method = "registerDefaults", at = @At("TAIL"))
    private static void registerDefaults(BrewingRecipeRegistry.Builder builder, CallbackInfo ci) {
        builder.registerPotionRecipe(Potions.AWKWARD, BFItems.CITRUS_ESSENCE, BFPotions.ACIDIC);
        builder.registerPotionRecipe(BFPotions.ACIDIC, Items.REDSTONE, BFPotions.LONG_ACIDIC);
        builder.registerPotionRecipe(BFPotions.ACIDIC, Items.GLOWSTONE_DUST, BFPotions.STRONG_ACIDIC);
        builder.registerPotionRecipe(BFPotions.ACIDIC, Items.FERMENTED_SPIDER_EYE, BFPotions.STUPOR);
        builder.registerPotionRecipe(BFPotions.LONG_ACIDIC, Items.FERMENTED_SPIDER_EYE, BFPotions.LONG_STUPOR);
        builder.registerPotionRecipe(BFPotions.STUPOR, Items.REDSTONE, BFPotions.LONG_STUPOR);
    }
}