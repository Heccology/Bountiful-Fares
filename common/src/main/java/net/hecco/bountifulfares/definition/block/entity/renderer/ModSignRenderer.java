package net.hecco.bountifulfares.definition.block.entity.renderer;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.hecco.bountifulfares.definition.block.entity.ModSignBlockEntity;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ModSignRenderer implements BlockEntityRenderer<ModSignBlockEntity> {
    private static final String STICK = "stick";
    private static final int BLACK_TEXT_OUTLINE_COLOR = -988212;
    private static final int OUTLINE_RENDER_DISTANCE = Mth.square(16);
    private static final float RENDER_SCALE = 0.6666667F;
    private static final Vec3 TEXT_OFFSET = new Vec3(0.0F, 0.33333334F, 0.046666667F);
    private final Map<WoodType, SignRenderer.SignModel> signModels;
    private final Font font;

    public ModSignRenderer(BlockEntityRendererProvider.Context context) {
        this.signModels = List.of(BFWoodTypes.WALNUT, BFWoodTypes.HOARY).stream().collect(ImmutableMap.toImmutableMap((woodType) -> woodType, (woodType) -> new SignRenderer.SignModel(context.bakeLayer(ModelLayers.createSignModelName(woodType)))));
        this.font = context.getFont();
    }

    public void render(ModSignBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState blockState = blockEntity.getBlockState();
        SignBlock signBlock = (SignBlock)blockState.getBlock();
        WoodType woodType = SignBlock.getWoodType(signBlock);
        SignRenderer.SignModel signModel = this.signModels.get(woodType);
        signModel.stick.visible = blockState.getBlock() instanceof StandingSignBlock;
        this.renderSignWithText(blockEntity, poseStack, bufferSource, packedLight, packedOverlay, blockState, signBlock, woodType, signModel);
    }

    public float getSignModelRenderScale() {
        return 0.6666667F;
    }

    public float getSignTextRenderScale() {
        return 0.6666667F;
    }

    void renderSignWithText(ModSignBlockEntity signEntity, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, BlockState state, SignBlock signBlock, WoodType woodType, Model model) {
        poseStack.pushPose();
        this.translateSign(poseStack, -signBlock.getYRotationDegrees(state), state);
        this.renderSign(poseStack, buffer, packedLight, packedOverlay, woodType, model);
        this.renderSignText(signEntity.getBlockPos(), signEntity.getFrontText(), poseStack, buffer, packedLight, signEntity.getTextLineHeight(), signEntity.getMaxTextLineWidth(), true);
        this.renderSignText(signEntity.getBlockPos(), signEntity.getBackText(), poseStack, buffer, packedLight, signEntity.getTextLineHeight(), signEntity.getMaxTextLineWidth(), false);
        poseStack.popPose();
    }

    void translateSign(PoseStack poseStack, float yRot, BlockState state) {
        poseStack.translate(0.5F, 0.75F * this.getSignModelRenderScale(), 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        if (!(state.getBlock() instanceof StandingSignBlock)) {
            poseStack.translate(0.0F, -0.3125F, -0.4375F);
        }

    }

    void renderSign(PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, WoodType woodType, Model model) {
        poseStack.pushPose();
        float f = this.getSignModelRenderScale();
        poseStack.scale(f, -f, -f);
        Material material = this.getSignMaterial(woodType);
        Objects.requireNonNull(model);
        VertexConsumer vertexConsumer = material.buffer(buffer, model::renderType);
        this.renderSignModel(poseStack, packedLight, packedOverlay, model, vertexConsumer);
        poseStack.popPose();
    }

    void renderSignModel(PoseStack poseStack, int packedLight, int packedOverlay, Model model, VertexConsumer vertexConsumer) {
        SignRenderer.SignModel signModel = (SignRenderer.SignModel)model;
        signModel.root.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

    Material getSignMaterial(WoodType woodType) {
        return Sheets.getSignMaterial(woodType);
    }

    void renderSignText(BlockPos pos, SignText text, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int lineHeight, int maxWidth, boolean isFrontText) {
        poseStack.pushPose();
        this.translateSignText(poseStack, isFrontText, this.getTextOffset());
        int i = getDarkColor(text);
        int j = 4 * lineHeight / 2;
        FormattedCharSequence[] formattedCharSequences = text.getRenderMessages(Minecraft.getInstance().isTextFilteringEnabled(), (component) -> {
            List<FormattedCharSequence> list = this.font.split(component, maxWidth);
            return list.isEmpty() ? FormattedCharSequence.EMPTY : list.get(0);
        });
        int k;
        boolean bl;
        int l;
        if (text.hasGlowingText()) {
            k = text.getColor().getTextColor();
            bl = isOutlineVisible(pos, k);
            l = 15728880;
        } else {
            k = i;
            bl = false;
            l = packedLight;
        }

        for(int m = 0; m < 4; ++m) {
            FormattedCharSequence formattedCharSequence = formattedCharSequences[m];
            float f = (float)(-this.font.width(formattedCharSequence) / 2);
            if (bl) {
                this.font.drawInBatch8xOutline(formattedCharSequence, f, (float)(m * lineHeight - j), k, i, poseStack.last().pose(), buffer, l);
            } else {
                this.font.drawInBatch(formattedCharSequence, f, (float)(m * lineHeight - j), k, false, poseStack.last().pose(), buffer, Font.DisplayMode.POLYGON_OFFSET, 0, l);
            }
        }

        poseStack.popPose();
    }

    private void translateSignText(PoseStack poseStack, boolean isFrontText, Vec3 offset) {
        if (!isFrontText) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        }

        float f = 0.015625F * this.getSignTextRenderScale();
        poseStack.translate(offset.x, offset.y, offset.z);
        poseStack.scale(f, -f, f);
    }

    Vec3 getTextOffset() {
        return TEXT_OFFSET;
    }

    static boolean isOutlineVisible(BlockPos pos, int textColor) {
        if (textColor == DyeColor.BLACK.getTextColor()) {
            return true;
        } else {
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localPlayer = minecraft.player;
            if (localPlayer != null && minecraft.options.getCameraType().isFirstPerson() && localPlayer.isScoping()) {
                return true;
            } else {
                Entity entity = minecraft.getCameraEntity();
                return entity != null && entity.distanceToSqr(Vec3.atCenterOf(pos)) < (double)OUTLINE_RENDER_DISTANCE;
            }
        }
    }

    public static int getDarkColor(SignText signText) {
        int i = signText.getColor().getTextColor();
        if (i == DyeColor.BLACK.getTextColor() && signText.hasGlowingText()) {
            return -988212;
        } else {
            double d = 0.4;
            int j = (int)((double) FastColor.ARGB32.red(i) * 0.4);
            int k = (int)((double) FastColor.ARGB32.green(i) * 0.4);
            int l = (int)((double) FastColor.ARGB32.blue(i) * 0.4);
            return FastColor.ARGB32.color(0, j, k, l);
        }
    }

    public static SignRenderer.SignModel createSignModel(EntityModelSet entityModelSet, WoodType woodType) {
        return new SignRenderer.SignModel(entityModelSet.bakeLayer(ModelLayers.createSignModelName(woodType)));
    }

    public static LayerDefinition createSignLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("sign", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -14.0F, -1.0F, 24.0F, 12.0F, 2.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("stick", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    public static final class SignModel extends Model {
        public final ModelPart root;
        public final ModelPart stick;

        public SignModel(ModelPart root) {
            super(RenderType::entityCutoutNoCull);
            this.root = root;
            this.stick = root.getChild("stick");
        }

        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
            this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
        }
    }
}
