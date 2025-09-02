package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.registry.misc.BFModelLayers;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(SignRenderer.class)
public class SignRendererMixin {
    @Shadow
    private final Map<WoodType, SignRenderer.SignModel> signModels = new HashMap<>();

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(BlockEntityRendererProvider.Context ctx, CallbackInfo ci) {
        this.signModels.put(BFWoodTypes.WALNUT,
                new SignRenderer.SignModel(ctx.bakeLayer(BFModelLayers.WALNUT_SIGN)));
        this.signModels.put(BFWoodTypes.HOARY,
                new SignRenderer.SignModel(ctx.bakeLayer(BFModelLayers.HOARY_SIGN)));
    }
}
