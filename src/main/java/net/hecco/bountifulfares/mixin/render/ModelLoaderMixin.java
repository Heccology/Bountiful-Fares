package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBakery.class)
public abstract class ModelLoaderMixin {

    @Shadow protected abstract void loadSpecialItemModelAndDependencies(ModelResourceLocation modelLocation);

    @Inject(method = "<init>", at = {@At(value = "INVOKE", ordinal = 0, target = "net/minecraft/client/resources/model/ModelBakery.loadSpecialItemModelAndDependencies (Lnet/minecraft/client/resources/model/ModelResourceLocation;)V")})
    private void addModels(CallbackInfo info) {
        this.loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "sun_hat_head")));
    }
}