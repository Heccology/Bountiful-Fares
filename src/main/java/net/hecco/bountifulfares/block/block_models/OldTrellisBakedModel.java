package net.hecco.bountifulfares.block.block_models;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.custom.TestTrellisBlock;
import net.hecco.bountifulfares.block.entity.TestTrellisEntity;
import net.mehvahdjukaar.moonlight.api.client.model.CustomBakedModel;
import net.mehvahdjukaar.moonlight.api.client.model.ExtraModelData;
import net.mehvahdjukaar.moonlight.api.client.model.ModelDataKey;
import net.mehvahdjukaar.moonlight.api.client.util.VertexUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OldTrellisBakedModel implements CustomBakedModel {
    private final BakedModel box;
    private final BakedModel vine;

    private final BlockModels blockModelShaper;
    private final ModelBakeSettings rotation;

    public OldTrellisBakedModel(BakedModel box, BakedModel vine, ModelBakeSettings rotation) {
        this.box = box;
        this.vine = vine;
        this.blockModelShaper = MinecraftClient.getInstance().getBlockRenderManager().getModels();
        this.rotation = rotation;
    }

    private void addBlockToModel(final List<BakedQuad> quads, BlockState state, MatrixStack poseStack, @Nullable Direction side, @NotNull Random rand) {
        BakedModel model;
        model = blockModelShaper.getModel(state);

        List<BakedQuad> mimicQuads = model.getQuads(state, side, rand);
        for (BakedQuad q : mimicQuads) {
            poseStack.push();
            int[] v = Arrays.copyOf(q.getVertexData(), q.getVertexData().length);

            poseStack.translate(-0.5f, -0.5f + 3 / 16f, -0.5f);
            Matrix4f matrix = poseStack.peek().getPositionMatrix();
//            transformVertices(v, matrix);

            poseStack.pop();

            quads.add(new BakedQuad(v, q.getColorIndex(),
                    Direction.transform(matrix, q.getFace()), q.getSprite(), q.hasShade()));
        }
    }

    public static void transformVertices(int[] v, Matrix4f transform) {
        int stride = VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL.getVertexSizeInteger();

        float normalX;
        for(int i = 0; i < 4; ++i) {
            i = i * stride + 0;
            float originalX = Float.intBitsToFloat(v[i]) - 0.5F;
            float originalY = Float.intBitsToFloat(v[i + 1]) - 0.5F;
            normalX = Float.intBitsToFloat(v[i + 2]) - 0.5F;
            Vector4f vec = new Vector4f(originalX, originalY, normalX, 1.0F);
            vec.mul(transform);
            vec.div(vec.w);
            v[i] = Float.floatToRawIntBits(vec.x() + 0.5F);
            v[i + 1] = Float.floatToRawIntBits(vec.y() + 0.5F);
            v[i + 2] = Float.floatToRawIntBits(vec.z() + 0.5F);
        }

        Matrix3f normalTransform = (new Matrix3f(transform)).invert().transpose();
        int i;
        for(i = 0; i < 4; ++i) {
            int offset = i * stride + 7;
            int normalIn = v[offset];
            if ((normalIn & 16777215) != 0) {
                normalX = (float)((byte)(normalIn & 255)) / 127.0F;
                float normalY = (float)((byte)(normalIn >> 8 & 255)) / 127.0F;
                float normalZ = (float)((byte)(normalIn >> 16 & 255)) / 127.0F;
                Vector3f vec = new Vector3f(normalX, normalY, normalZ);
                vec.mul(normalTransform);
                vec.normalize();
                v[offset] = (byte)((int)(vec.x() * 127.0F)) & 255 | ((byte)((int)(vec.y() * 127.0F)) & 255) << 8 | ((byte)((int)(vec.z() * 127.0F)) & 255) << 16 | normalIn & -16777216;
            }
        }

    }

    @Override
    public List<BakedQuad> getBlockQuads(BlockState state, Direction direction, Random random, @Nullable RenderLayer renderLayer, ExtraModelData extraModelData) {
        List<BakedQuad> quads = new ArrayList<>();

        //box
        try {
            quads.addAll(box.getQuads(state, direction, random));
//            quads.addAll(vine.getQuads(state, direction, random));
        } catch (Exception ignored) {
        }

//        //mimic
//        try {
//
//            if (state != null) {
//
                MatrixStack poseStack = new MatrixStack();
//
                org.joml.Matrix4f rot = rotation.getRotation().getMatrix();
                poseStack.multiplyPositionMatrix(rot);
//                BlockState vine = extraModelData.get(TestTrellisEntity.VINE_CROP);
//                if (vine != null && !vine.isAir()) {
                    poseStack.push();
                    this.addBlockToModel(quads, ModBlocks.PASSION_FRUIT_VINE.getDefaultState(), poseStack, direction, random);
                    poseStack.pop();
//                }
//            }
//
//        } catch (Exception ignored) {
//        }
        return quads;
    }

    @Override
    public Sprite getBlockParticle(ExtraModelData extraModelData) {
        return box.getParticleSprite();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean hasDepth() {
        return false;
    }

    @Override
    public boolean isSideLit() {
        return false;
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public ModelTransformation getTransformation() {
        return null;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return null;
    }
}
