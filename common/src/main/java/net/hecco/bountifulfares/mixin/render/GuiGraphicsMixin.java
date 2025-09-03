package net.hecco.bountifulfares.mixin.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.MatrixUtil;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.item.component.TiffinContents;
import net.hecco.bountifulfares.definition.item.custom.TiffinItem;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(GuiGraphics.class)
public class GuiGraphicsMixin {

    @Unique private Level bountifulfares$getLevel = null;
    @Unique private LivingEntity bountifulfares$getEntity = null;
    @Unique private int bountifulfares$getSeed = 0;

    @Inject(method = "renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;IIII)V", at = @At("HEAD"))
    private void bountifulFares$getValues(LivingEntity entity, Level level, ItemStack stack, int x, int y, int seed, int guiOffset, CallbackInfo ci) {
        this.bountifulfares$getEntity = entity;
        this.bountifulfares$getLevel = level;
        this.bountifulfares$getSeed = seed;
    }

    @Redirect(method = "renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;IIII)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/ItemRenderer;render(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/client/resources/model/BakedModel;)V"))
    private void bountifulfares$renderTiffinGuiItem(ItemRenderer instance, ItemStack stack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel model) {
        if (
                stack.getItem() instanceof TiffinItem && stack.has(BFComponents.TIFFIN_CONTENTS.get()) &&
                !stack.get(BFComponents.TIFFIN_CONTENTS.get()).getItemStack().isEmpty() &&
                bountifulfares$getSeed != 0) {
            TiffinContents contents = stack.get(BFComponents.TIFFIN_CONTENTS.get());
            if (!Services.PLATFORM.getBoolConfigValue("tiffinCornerFoodIcon")) {
                if (bountifulfares$getEntity != null && bountifulfares$getEntity instanceof Player player && (player.getItemInHand(InteractionHand.MAIN_HAND) == stack || player.getItemInHand(InteractionHand.OFF_HAND) == stack)) {
                    instance.render(stack, displayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, instance.getItemModelShaper().getModelManager().getModel(ModelResourceLocation.inventory(BuiltInRegistries.ITEM.getKey(stack.getItem()).withSuffix("_back"))));
                    if (bountifulfares$getLevel != null && bountifulfares$getEntity != null) {
                        instance.render(stack, displayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, instance.getModel(contents.getItemStack(), bountifulfares$getLevel, bountifulfares$getEntity, bountifulfares$getSeed));
                    }
                    instance.render(stack, displayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, instance.getItemModelShaper().getModelManager().getModel(ModelResourceLocation.inventory(BuiltInRegistries.ITEM.getKey(stack.getItem()).withSuffix("_front"))));
                } else {
                    instance.render(stack, displayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, model);
                }
            } else {
                instance.render(stack, displayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, model);
                if (bountifulfares$getLevel != null && bountifulfares$getEntity != null) {
                    poseStack.pushPose();
                    poseStack.scale(0.5f, 0.5f, 1f);
                    poseStack.translate(0.5f, -0.3f, 0);
                    instance.render(stack, displayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, instance.getModel(contents.getItemStack(), bountifulfares$getLevel, bountifulfares$getEntity, bountifulfares$getSeed));
                    poseStack.popPose();
                }
            }
        } else {
            instance.render(stack, displayContext, leftHand, poseStack, bufferSource, combinedLight, combinedOverlay, model);
        }
    }
}
