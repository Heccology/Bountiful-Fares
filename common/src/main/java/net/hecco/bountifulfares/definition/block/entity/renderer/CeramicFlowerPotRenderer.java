package net.hecco.bountifulfares.definition.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hecco.bountifulfares.definition.block.custom.CeramicFlowerPotBlock;
import net.hecco.bountifulfares.definition.block.entity.CeramicFlowerPotBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CeramicFlowerPotRenderer implements BlockEntityRenderer<CeramicFlowerPotBlockEntity> {

    private static final Direction[] SIDES = {null, Direction.UP, Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.DOWN};
    private static final Map<Block, List<BakedQuad>> MODELS = new HashMap<>();

    public CeramicFlowerPotRenderer(BlockEntityRendererProvider.Context context) {
    }

    private static List<BakedQuad> getEditedPlantModel(BlockState state) {
        return MODELS.computeIfAbsent(state.getBlock(), block -> {
            List<BakedQuad> quads = new ArrayList<>();
            BakedModel model = Minecraft.getInstance().getBlockRenderer().getBlockModel(state);
            RandomSource randomSource = RandomSource.create(42);
            for (Direction side : SIDES) {
                for (BakedQuad quad : model.getQuads(state, side, randomSource)) {
                    if (!quad.getSprite().contents().name().equals(ResourceLocation.withDefaultNamespace("block/flower_pot"))) quads.add(quad);
                }
            }
            return quads;
        });
    }

    public static void resetModels() {
        MODELS.clear();
    }

    @Override
    public void render(CeramicFlowerPotBlockEntity entity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        poseStack.pushPose();
        poseStack.translate(0, 2/16f, 0);
        if (entity.getPlant().getItem() instanceof BlockItem item) {
            Block block = item.getBlock();
            if (CeramicFlowerPotBlock.POTTED_PLANTS.isEmpty()) CeramicFlowerPotBlock.getAllPottedPlants();
            if (CeramicFlowerPotBlock.POTTED_PLANTS.containsKey(block)) {
                Block block1 = CeramicFlowerPotBlock.POTTED_PLANTS.get(block);
                if (block1 != null) {
                    VertexConsumer consumer = multiBufferSource.getBuffer(RenderType.cutout());
                    for (BakedQuad quad : getEditedPlantModel(block1.defaultBlockState())) {
                        float shade = entity.getLevel() != null ? entity.getLevel().getShade(quad.getDirection(), quad.isShade()) : 1f;
                        float r = 1f;
                        float g = 1f;
                        float b = 1f;
                        if (quad.isTinted()) {
                            int color = Minecraft.getInstance().getBlockColors().getColor(block1.defaultBlockState(), entity.getLevel(), entity.getBlockPos(), quad.getTintIndex());
                            r = (color >> 16 & 0xFF) / 255f;
                            g = (color >> 8 & 0xFF) / 255f;
                            b = (color & 0xFF) / 255f;
                        }
                        consumer.putBulkData(poseStack.last(), quad, r * shade, g * shade, b * shade, 1f, i, OverlayTexture.NO_OVERLAY);
                    }
                }
            }
        }

        poseStack.popPose();
    }

    @Override
    public int getViewDistance() {
        return 128;
    }
}
