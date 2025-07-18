package net.hecco.bountifulfares.mixin.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.mixin.util.ItemRendererAccessor;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "render", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel renderItemTexture(BakedModel value, ItemStack stack, ItemDisplayContext renderMode, boolean leftHanded, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        if (stack.is(BFItems.SUN_HAT.get()) && renderMode == ItemDisplayContext.HEAD) {
            return ((ItemRendererAccessor) this).getModels().getModelManager().getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "sun_hat_head")));
        }
        return value;
    }
}