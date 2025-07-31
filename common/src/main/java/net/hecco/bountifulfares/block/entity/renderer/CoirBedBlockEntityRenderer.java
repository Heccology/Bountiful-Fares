package net.hecco.bountifulfares.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.CoirBedBlockEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;

public class CoirBedBlockEntityRenderer implements BlockEntityRenderer<CoirBedBlockEntity> {
    private final ModelPart bedHead;
    private final ModelPart bedFoot;

    public CoirBedBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.bedHead = ctx.bakeLayer(ModelLayers.BED_HEAD);
        this.bedFoot = ctx.bakeLayer(ModelLayers.BED_FOOT);
    }

    public void render(CoirBedBlockEntity bedBlockEntity, float f, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, int j) {
        Material spriteIdentifier = new Material(Sheets.BED_SHEET, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "entity/bed/coir_bed"));

        Level world = bedBlockEntity.getLevel();

        if (world != null) {
            BlockState blockState = bedBlockEntity.getBlockState();
            DoubleBlockCombiner.NeighborCombineResult<? extends BedBlockEntity> propertySource = DoubleBlockCombiner.combineWithNeigbour(
                    BlockEntityType.BED,
                    BedBlock::getBlockType,
                    BedBlock::getConnectedDirection,
                    ChestBlock.FACING,
                    blockState,
                    world,
                    bedBlockEntity.getBlockPos(),
                    (worldx, pos) -> false
            );
            int k = propertySource.apply(new BrightnessCombiner<>()).get(i);
            this.renderPart(
                    matrixStack,
                    vertexConsumerProvider,
                    blockState.getValue(BedBlock.PART) == BedPart.HEAD ? this.bedHead : this.bedFoot,
                    blockState.getValue(BedBlock.FACING),
                    spriteIdentifier,
                    k,
                    j,
                    false
            );
        }
        else {
            this.renderPart(matrixStack, vertexConsumerProvider, this.bedHead, Direction.SOUTH, spriteIdentifier, i, j, false);
            this.renderPart(matrixStack, vertexConsumerProvider, this.bedFoot, Direction.SOUTH, spriteIdentifier, i, j, true);
        }
    }

    private void renderPart(PoseStack matrices, MultiBufferSource vertexConsumers, ModelPart part, Direction direction, Material sprite, int light, int overlay, boolean isFoot) {
        matrices.pushPose();
        matrices.translate(0.0F, 0.5625F, isFoot ? -1.0F : 0.0F);
        matrices.mulPose(Axis.XP.rotationDegrees(90.0F));
        matrices.translate(0.5F, 0.5F, 0.5F);
        matrices.mulPose(Axis.ZP.rotationDegrees(180.0F + direction.toYRot()));
        matrices.translate(-0.5F, -0.5F, -0.5F);
        VertexConsumer vertexConsumer = sprite.buffer(vertexConsumers, RenderType::entitySolid);
        part.render(matrices, vertexConsumer, light, overlay);
        matrices.popPose();
    }
}