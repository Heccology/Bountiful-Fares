package net.hecco.bountifulfares.block.entity.renderer;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.CoirBedBlockEntity;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BedBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.BedPart;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

public class CoirBedBlockEntityRenderer implements BlockEntityRenderer<CoirBedBlockEntity> {
     private final ModelPart headRoot;
        private final ModelPart footRoot;

        public CoirBedBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
            this.headRoot = context.getLayerModelPart(EntityModelLayers.BED_HEAD);
            this.footRoot = context.getLayerModelPart(EntityModelLayers.BED_FOOT);
        }

        private void renderPiece(MatrixStack matrices, VertexConsumerProvider multiBufferSource, ModelPart modelPart, Direction direction, SpriteIdentifier material, int i, int j, boolean bl) {
            matrices.push();
            matrices.translate(0.0F, 0.5625F, bl ? -1.0F : 0.0F);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
            matrices.translate(0.5F, 0.5F, 0.5F);
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F + direction.asRotation()));
            matrices.translate(-0.5F, -0.5F, -0.5F);
            VertexConsumer vertexConsumer = material.getVertexConsumer(multiBufferSource, RenderLayer::getEntitySolid);
            modelPart.render(matrices, vertexConsumer, i, j);
            matrices.pop();
        }

    public void render(CoirBedBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        SpriteIdentifier material = new SpriteIdentifier(TexturedRenderLayers.BEDS_ATLAS_TEXTURE, new Identifier("entity/bed/red"));
        if (entity.getColor() == DyeColor.WHITE) {
            material = new SpriteIdentifier(TexturedRenderLayers.BEDS_ATLAS_TEXTURE, new Identifier("entity/bed/coir"));
        }

        World level = entity.getWorld();
        if (level != null) {
            BlockState blockState = entity.getCachedState();
            DoubleBlockProperties.PropertySource<BedBlockEntity> neighborCombineResult = DoubleBlockProperties.toPropertySource(BlockEntityType.BED, BedBlock::getBedPart, BedBlock::getOppositePartDirection, BedBlock.FACING, blockState, level, entity.getPos(), (levelAccessor, blockPos) -> false);
            int k = neighborCombineResult.apply(new LightmapCoordinatesRetriever<>()).get(light);
            this.renderPiece(matrices, vertexConsumers, blockState.get(BedBlock.PART) == BedPart.HEAD ? this.headRoot : this.footRoot, blockState.get(BedBlock.FACING), material, k, overlay, false);
        } else {
            this.renderPiece(matrices, vertexConsumers, this.headRoot, Direction.SOUTH, material, light, overlay, false);
            this.renderPiece(matrices, vertexConsumers, this.footRoot, Direction.SOUTH, material, light, overlay, true);
        }
    }
}
