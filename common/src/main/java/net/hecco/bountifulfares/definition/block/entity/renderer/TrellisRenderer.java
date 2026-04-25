package net.hecco.bountifulfares.definition.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.definition.block.entity.TrellisBlockEntity;
import net.hecco.bountifulfares.registry.misc.BFModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class TrellisRenderer implements BlockEntityRenderer<TrellisBlockEntity> {

    private final ModelPart defaultModel;
    private final ModelPart invertedModel;

    public TrellisRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart defaultLayer = context.bakeLayer(BFModelLayers.TRELLIS_DEFAULT);
        ModelPart invertedLayer = context.bakeLayer(BFModelLayers.TRELLIS_INVERTED);
        this.defaultModel = defaultLayer.getChild("vines");
        this.invertedModel = invertedLayer.getChild("vines");
    }

    @Override
    public void render(TrellisBlockEntity entity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {

        BlockState state = entity.getBlockState();

        Direction direction = state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)
                ? state.getValue(BlockStateProperties.HORIZONTAL_FACING)
                : Direction.NORTH;

        poseStack.pushPose();
        if (entity.getPlant() != null && (TrellisBlock.PLANTS.containsKey(entity.getPlant()) || TrellisBlock.CROPS.containsKey(entity.getPlant()))) {
            poseStack.translate(0.5, 1.5, 0.5);
            poseStack.scale(-1, -1, -1);

            ModelPart modelPart = defaultModel;
            ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/trellis");
            if (TrellisBlock.PLANTS.containsKey(entity.getPlant())) {
                if (TrellisBlock.PLANTS.get(entity.getPlant()).model().equalsIgnoreCase("inverted")) {
                    modelPart = invertedModel;
                }
                texture = TrellisBlock.PLANTS.get(entity.getPlant()).texture();
            }
            if (TrellisBlock.CROPS.containsKey(entity.getPlant())) {
                if (TrellisBlock.CROPS.get(entity.getPlant()).model().equalsIgnoreCase("inverted")) {
                    modelPart = invertedModel;
                }
                texture = TrellisBlock.CROPS.get(entity.getPlant()).texture().withSuffix("_" + entity.getStage());
            }

            switch (direction) {
                case SOUTH -> modelPart.yRot = 0;
                case NORTH -> modelPart.yRot = (float) Math.PI;
                case EAST -> modelPart.yRot = (float) (Math.PI * 0.5);
                case WEST -> modelPart.yRot = (float) (Math.PI * 1.5);
            }
            VertexConsumer vertexconsumer = new Material(TextureAtlas.LOCATION_BLOCKS, texture).buffer(multiBufferSource, RenderType::entityCutoutNoCull);
            modelPart.render(poseStack, vertexconsumer, i, i1);

        }
        poseStack.popPose();
    }
}
