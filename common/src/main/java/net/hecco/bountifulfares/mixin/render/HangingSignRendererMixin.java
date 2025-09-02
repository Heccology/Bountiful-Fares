package net.hecco.bountifulfares.mixin.render;

import net.hecco.bountifulfares.registry.misc.BFModelLayers;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(HangingSignRenderer.class)
public class HangingSignRendererMixin {
    @Shadow
    private final Map<WoodType, HangingSignRenderer.HangingSignModel> hangingSignModels = new HashMap<>();

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(BlockEntityRendererProvider.Context ctx, CallbackInfo ci) {
        this.hangingSignModels.put(BFWoodTypes.WALNUT,
                new HangingSignRenderer.HangingSignModel(ctx.bakeLayer(BFModelLayers.WALNUT_HANGING_SIGN)));
        this.hangingSignModels.put(BFWoodTypes.HOARY,
                new HangingSignRenderer.HangingSignModel(ctx.bakeLayer(BFModelLayers.HOARY_HANGING_SIGN)));
    }
}
