package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.integration.DelicateDyesIntegration;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@Mixin(ModelBakery.class)
public abstract class ModelLoaderMixin {

    @Shadow protected abstract void loadSpecialItemModelAndDependencies(ModelResourceLocation modelLocation);

    @Inject(method = "<init>", at = {@At(value = "INVOKE", ordinal = 0, target = "net/minecraft/client/resources/model/ModelBakery.loadSpecialItemModelAndDependencies (Lnet/minecraft/client/resources/model/ModelResourceLocation;)V")})
    private void addModels(CallbackInfo info) {
        this.loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "sun_hat_head")));
        this.loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "shulker_tiffin_back")));
        this.loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "shulker_tiffin_front")));
        for (DyeColor color : Arrays.stream(DyeColor.values()).limit(16).toList()) {
            this.loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, color.getName() + "_shulker_tiffin_back")));
            this.loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, color.getName() + "_shulker_tiffin_front")));
        }
        for (String string : DelicateDyesIntegration.DYES) {
            this.loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.DELICATE_DYES_MOD_ID, string + "_shulker_tiffin_back")));
            this.loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.DELICATE_DYES_MOD_ID, string + "_shulker_tiffin_front")));
        }
    }
}