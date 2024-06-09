package net.hecco.bountifulfares.block.entity.renderer;

import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.block.custom.CoirBedBlock;
import net.hecco.bountifulfares.block.entity.CoirBedBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;

public class ItemModelRenderer extends BuiltinModelItemRenderer implements SynchronousResourceReloader {
    private final CoirBedBlockEntity bed;
    public ItemModelRenderer() {
        super(null, null);

        this.bed = new CoirBedBlockEntity(BlockPos.ORIGIN, BFBlocks.COIR_BED.getDefaultState());
    }

    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockEntityRenderDispatcher blockEntityRenderDispatcher = MinecraftClient.getInstance().getBlockEntityRenderDispatcher();
        Item item = stack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem)item).getBlock();
            BlockState blockState = block.getDefaultState();
            BlockEntity blockEntity = null;
            DyeColor[] var12 = DyeColor.values();
            int var13 = var12.length;

            if (blockState.isOf(BFBlocks.COIR_BED)) {
                this.bed.setColor(((CoirBedBlock)blockState.getBlock()).getColor());
                this.bed.setColor(DyeColor.WHITE);
                blockEntity = this.bed;
            }

            blockEntityRenderDispatcher.renderEntity(blockEntity, matrices, vertexConsumers, light, overlay);
        }
        super.render(stack, mode, matrices, vertexConsumers, light, overlay);
    }
}