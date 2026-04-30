package net.hecco.bountifulfares.mixin.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.hecco.bountifulfares.definition.block.custom.CeramicChestBlock;
import net.hecco.bountifulfares.definition.block.entity.CeramicChestBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.CoirBedBlockEntity;
import net.hecco.bountifulfares.definition.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityWithoutLevelRenderer.class)
public abstract class BuiltinItemModelMixin {

    @Shadow @Final private BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    @Mutable @Unique @Final private CoirBedBlockEntity bountifare$renderCoirBed;
    @Mutable @Unique @Final private CeramicChestBlockEntity bountifare$renderChestCeramic;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void bountifulfares$setFinals(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet, CallbackInfo ci) {
        bountifare$renderCoirBed = new CoirBedBlockEntity(BlockPos.ZERO, BFBlocks.COIR_BED.get().defaultBlockState());
        bountifare$renderChestCeramic = new CeramicChestBlockEntity(BlockPos.ZERO, BFBlocks.CERAMIC_CHEST.get().defaultBlockState());
    }

    @Inject(method = "renderByItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getItem()Lnet/minecraft/world/item/Item;"), cancellable = true)
    private void bountifulfares$renderCoirBed(ItemStack stack, ItemDisplayContext mode, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay, CallbackInfo ci) {
        Item item = stack.getItem();
        if (item instanceof BlockItem blockItem && blockItem.getBlock() == BFBlocks.COIR_BED.get()) {
            this.blockEntityRenderDispatcher.renderItem(bountifare$renderCoirBed, matrices, vertexConsumers, light, overlay);
            ci.cancel();
        }
        if (item instanceof BlockItem blockItem && blockItem.getBlock() instanceof CeramicChestBlock && blockItem instanceof DyeableCeramicBlockItem dyeableItem) {
            bountifare$renderChestCeramic.color = DyedItemColor.getOrDefault(stack ,dyeableItem.DEFAULT_COLOR);
            this.blockEntityRenderDispatcher.renderItem(bountifare$renderChestCeramic, matrices, vertexConsumers, light, overlay);
            ci.cancel();
        }
    }
}