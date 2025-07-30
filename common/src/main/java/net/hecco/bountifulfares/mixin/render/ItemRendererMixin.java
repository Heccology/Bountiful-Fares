package net.hecco.bountifulfares.mixin.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.item.component.TiffinContents;
import net.hecco.bountifulfares.item.custom.TiffinItem;
import net.hecco.bountifulfares.mixin.util.ItemRendererAccessor;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    @Shadow
    private void render(ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel model) {}

    @ModifyVariable(method = "render", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel bountifulfares$renderSunHatHeadModel(BakedModel value, ItemStack stack, ItemDisplayContext renderMode, boolean leftHanded, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        if (stack.is(BFItems.SUN_HAT.get()) && renderMode == ItemDisplayContext.HEAD) {
            return ((ItemRendererAccessor) this).getModels().getModelManager().getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "sun_hat_head")));
        }
        return value;
    }

//    @Unique
//    private ItemDisplayContext bountifulfares$displayContext = null;
//
//    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ItemRenderer;renderModelLists(Lnet/minecraft/client/resources/model/BakedModel;Lnet/minecraft/world/item/ItemStack;IILcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;)V"))
//    private void bountifulfares$getDisplayContext(ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel model, CallbackInfo ci) {
//        bountifulfares$displayContext = displayContext;
//    }
//
//    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ItemRenderer;renderModelLists(Lnet/minecraft/client/resources/model/BakedModel;Lnet/minecraft/world/item/ItemStack;IILcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;)V"))
//    private void bountifulfares$renderTiffinGuiModel(ItemRenderer instance, BakedModel model, ItemStack stack, int combinedLight, int combinedOverlay, PoseStack poseStack, VertexConsumer buffer) {
//        if (
//                bountifulfares$displayContext != null && bountifulfares$displayContext == ItemDisplayContext.GUI &&
//                stack.getItem() instanceof TiffinItem && stack.has(BFComponents.TIFFIN_CONTENTS) &&
//                stack.has(BFComponents.TIFFIN_INTERACTABLE) &&
//                stack.get(BFComponents.TIFFIN_CONTENTS).getItem() != Items.AIR &&
//                stack.get(BFComponents.TIFFIN_INTERACTABLE)) {
//            TiffinContents contents = stack.get(BFComponents.TIFFIN_CONTENTS);
////            BakedModel backModel = ((ItemRenderer)(Object)this).getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "shulker_tiffin_back")));
//            renderModelLists(((ItemRendererAccessor) this).getModels().getModelManager().getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "shulker_tiffin_back"))), stack, combinedLight, combinedOverlay, poseStack, buffer);
//        } else {
//            renderModelLists(model, stack, combinedLight, combinedOverlay, poseStack, buffer);
//        }
//    }

//    @Inject(method = "renderStatic(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/level/Level;III)V", at = @At("HEAD"), cancellable = true)
//    private void bountifulfares$renderTiffinGuiModel(LivingEntity entity, ItemStack stack, ItemDisplayContext diplayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, Level level, int combinedLight, int combinedOverlay, int seed, CallbackInfo ci) {
//        if (
//                diplayContext == ItemDisplayContext.GUI &&
//                stack.getItem() instanceof TiffinItem && stack.has(BFComponents.TIFFIN_CONTENTS) &&
//                stack.has(BFComponents.TIFFIN_INTERACTABLE) &&
//                stack.get(BFComponents.TIFFIN_CONTENTS).getItem() != Items.AIR &&
//                stack.get(BFComponents.TIFFIN_INTERACTABLE)) {
//            TiffinContents contents = stack.get(BFComponents.TIFFIN_CONTENTS);
//            BakedModel backModel = ((ItemRendererAccessor) this).getModels().getModelManager().getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "shulker_tiffin_back")));
//            render(stack, diplayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, backModel);
//            ci.cancel();
//        }
//    }
}