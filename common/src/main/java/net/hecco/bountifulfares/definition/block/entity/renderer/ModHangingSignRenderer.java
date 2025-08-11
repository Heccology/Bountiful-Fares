package net.hecco.bountifulfares.definition.block.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.hecco.bountifulfares.definition.block.entity.ModSignBlockEntity;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ModHangingSignRenderer extends ModSignRenderer {
    private static final String PLANK = "plank";
    private static final String V_CHAINS = "vChains";
    private static final String NORMAL_CHAINS = "normalChains";
    private static final String CHAIN_L_1 = "chainL1";
    private static final String CHAIN_L_2 = "chainL2";
    private static final String CHAIN_R_1 = "chainR1";
    private static final String CHAIN_R_2 = "chainR2";
    private static final String BOARD = "board";
    private static final float MODEL_RENDER_SCALE = 1.0F;
    private static final float TEXT_RENDER_SCALE = 0.9F;
    private static final Vec3 TEXT_OFFSET = new Vec3((double)0.0F, (double)-0.32F, (double)0.073F);
    private final Map<WoodType, HangingSignModel> hangingSignModels;

    public ModHangingSignRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
        this.hangingSignModels = Stream.of(BFWoodTypes.WALNUT, BFWoodTypes.HOARY).collect(ImmutableMap.toImmutableMap((woodType) -> woodType, (woodType) -> new HangingSignModel(context.bakeLayer(ModelLayers.createHangingSignModelName(woodType)))));
    }

    public float getSignModelRenderScale() {
        return 1.0F;
    }

    public float getSignTextRenderScale() {
        return 0.9F;
    }

    public void render(ModSignBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState blockState = blockEntity.getBlockState();
        SignBlock signBlock = (SignBlock)blockState.getBlock();
        WoodType woodType = SignBlock.getWoodType(signBlock);
        HangingSignModel hangingSignModel = this.hangingSignModels.get(woodType);
        hangingSignModel.evaluateVisibleParts(blockState);
        this.renderSignWithText(blockEntity, poseStack, bufferSource, packedLight, packedOverlay, blockState, signBlock, woodType, hangingSignModel);
    }

    void translateSign(PoseStack poseStack, float yRot, BlockState state) {
        poseStack.translate(0.5F, 0.9375F, (double)0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        poseStack.translate(0.0F, -0.3125F, 0.0F);
    }

    void renderSignModel(PoseStack poseStack, int packedLight, int packedOverlay, Model model, VertexConsumer vertexConsumer) {
        HangingSignRenderer.HangingSignModel hangingSignModel = (HangingSignRenderer.HangingSignModel)model;
        hangingSignModel.root.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

    Material getSignMaterial(WoodType woodType) {
        return Sheets.getHangingSignMaterial(woodType);
    }

    Vec3 getTextOffset() {
        return TEXT_OFFSET;
    }

    public static LayerDefinition createHangingSignLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("board", CubeListBuilder.create().texOffs(0, 12).addBox(-7.0F, 0.0F, -1.0F, 14.0F, 10.0F, 2.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("plank", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -6.0F, -2.0F, 16.0F, 2.0F, 4.0F), PartPose.ZERO);
        PartDefinition partDefinition2 = partDefinition.addOrReplaceChild("normalChains", CubeListBuilder.create(), PartPose.ZERO);
        partDefinition2.addOrReplaceChild("chainL1", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-5.0F, -6.0F, 0.0F, 0.0F, (-(float)Math.PI / 4F), 0.0F));
        partDefinition2.addOrReplaceChild("chainL2", CubeListBuilder.create().texOffs(6, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-5.0F, -6.0F, 0.0F, 0.0F, ((float)Math.PI / 4F), 0.0F));
        partDefinition2.addOrReplaceChild("chainR1", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(5.0F, -6.0F, 0.0F, 0.0F, (-(float)Math.PI / 4F), 0.0F));
        partDefinition2.addOrReplaceChild("chainR2", CubeListBuilder.create().texOffs(6, 6).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(5.0F, -6.0F, 0.0F, 0.0F, ((float)Math.PI / 4F), 0.0F));
        partDefinition.addOrReplaceChild("vChains", CubeListBuilder.create().texOffs(14, 6).addBox(-6.0F, -6.0F, 0.0F, 12.0F, 6.0F, 0.0F), PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    public static final class HangingSignModel extends Model {
        public final ModelPart root;
        public final ModelPart plank;
        public final ModelPart vChains;
        public final ModelPart normalChains;

        public HangingSignModel(ModelPart root) {
            super(RenderType::entityCutoutNoCull);
            this.root = root;
            this.plank = root.getChild("plank");
            this.normalChains = root.getChild("normalChains");
            this.vChains = root.getChild("vChains");
        }

        public void evaluateVisibleParts(BlockState state) {
            boolean bl = !(state.getBlock() instanceof CeilingHangingSignBlock);
            this.plank.visible = bl;
            this.vChains.visible = false;
            this.normalChains.visible = true;
            if (!bl) {
                boolean bl2 = (Boolean)state.getValue(BlockStateProperties.ATTACHED);
                this.normalChains.visible = !bl2;
                this.vChains.visible = bl2;
            }

        }

        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
            this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
        }
    }
}
