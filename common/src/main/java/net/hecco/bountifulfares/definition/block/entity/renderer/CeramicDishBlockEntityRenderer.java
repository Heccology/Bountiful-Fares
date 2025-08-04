package net.hecco.bountifulfares.definition.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.hecco.bountifulfares.definition.block.custom.CeramicDishBlock;
import net.hecco.bountifulfares.definition.block.entity.CeramicDishBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

import java.util.Objects;

public class CeramicDishBlockEntityRenderer implements BlockEntityRenderer<CeramicDishBlockEntity> {
    public CeramicDishBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }
    @Override
    public void render(CeramicDishBlockEntity entity, float tickDelta, PoseStack matrices,
                       MultiBufferSource vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = entity.getRenderStack();
        matrices.pushPose();
        matrices.translate(0.5f, 0.08f, 0.5f);
        matrices.scale(0.5f, 0.5f, 0.5f);
        matrices.mulPose(Axis.YN.rotationDegrees(entity.getBlockState().getValue(CeramicDishBlock.FACING).toYRot() + 180));
        matrices.mulPose(Axis.XP.rotationDegrees(90));

        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(Objects.requireNonNull(entity.getLevel()),
                entity.getBlockPos()), OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, entity.getLevel(), 1);
        matrices.popPose();
    }
    private int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
