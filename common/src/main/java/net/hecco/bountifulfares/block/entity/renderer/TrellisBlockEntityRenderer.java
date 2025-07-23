package net.hecco.bountifulfares.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.NewTrellisBlock;
import net.hecco.bountifulfares.block.entity.TrellisBlockEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class TrellisBlockEntityRenderer implements BlockEntityRenderer<TrellisBlockEntity> {

    private final ModelPart bellBody;
    public static final ModelLayerLocation TRELLIS_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "trellis"), "main");

    public TrellisBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart modelpart = context.bakeLayer(TRELLIS_LAYER);
        this.bellBody = modelpart.getChild("vines");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("vines", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, 6.975F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition twisting_bottom_r1 = bb_main.addOrReplaceChild("twisting_bottom_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 6.975F, 0.3927F, 0.0F, 0.0F));

        PartDefinition twisting_top_r1 = bb_main.addOrReplaceChild("twisting_top_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 6.975F, 0.3927F, 0.0F, 0.0F));

        PartDefinition foliage_top_r1 = bb_main.addOrReplaceChild("foliage_top_r1", CubeListBuilder.create().texOffs(32, 16).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 6.975F, -0.3927F, 0.0F, 0.0F));

        PartDefinition foliage_bottom_r1 = bb_main.addOrReplaceChild("foliage_bottom_r1", CubeListBuilder.create().texOffs(32, 24).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 6.975F, -0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void render(TrellisBlockEntity entity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        BlockState state = entity.getBlockState();

        Direction direction = state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)
                ? state.getValue(BlockStateProperties.HORIZONTAL_FACING)
                : Direction.NORTH;

        poseStack.pushPose();

        poseStack.translate(0.5, -0.5, 0.5);

        switch (direction) {
            case NORTH -> this.bellBody.yRot = 0;
            case SOUTH -> this.bellBody.yRot = (float) Math.PI;
            case WEST -> this.bellBody.yRot = (float) (Math.PI * 0.5);
            case EAST -> this.bellBody.yRot = (float) (Math.PI * 1.5);
        }

        if (entity.getPlant() != null && NewTrellisBlock.PLANTS.get(entity.getPlant()) != null) {
            VertexConsumer vertexconsumer = new Material(TextureAtlas.LOCATION_BLOCKS, NewTrellisBlock.PLANTS.get(entity.getPlant()).texture()).buffer(multiBufferSource, RenderType::entityCutoutNoCull);
            this.bellBody.render(poseStack, vertexconsumer, i, i1);
        }
        poseStack.popPose();
    }
}
