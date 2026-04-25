package net.hecco.bountifulfares.mixin.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.hecco.bountifulfares.definition.block.entity.CeramicChestBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.CoirBedBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityWithoutLevelRenderer.class)
public abstract class BuiltinItemModelMixin {

    @Shadow
    @Final
    private BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    @Inject(method = "renderByItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getItem()Lnet/minecraft/world/item/Item;"), cancellable = true)
    private void bountifulfares$renderCoirBed(ItemStack stack, ItemDisplayContext mode, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay, CallbackInfo ci) {
        Item item = stack.getItem();
        if (item instanceof BlockItem blockItem && blockItem.getBlock() == BFBlocks.COIR_BED.get()) {
            this.blockEntityRenderDispatcher.renderItem(new CoirBedBlockEntity(BlockPos.ZERO, BFBlocks.COIR_BED.get().defaultBlockState()), matrices, vertexConsumers, light, overlay);
            ci.cancel();
        }
        if (item instanceof BlockItem blockItem && blockItem.getBlock() == BFBlocks.CERAMIC_CHEST.get()) {
            this.blockEntityRenderDispatcher.renderItem(new CeramicChestBlockEntity(BlockPos.ZERO, BFBlocks.CERAMIC_CHEST.get().defaultBlockState()), matrices, vertexConsumers, light, overlay);
            ci.cancel();
        }
    }
}