package net.hecco.bountifulcuisine;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.custom.entity.CeramicTilesBlockEntity;
import net.hecco.bountifulcuisine.block.custom.entity.ModBlockEntities;
import net.hecco.bountifulcuisine.entity.ModBoats;
import net.hecco.bountifulcuisine.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulcuisine.util.ModWoodTypes;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public class BountifulCuisineClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_APPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_LEMON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_PLUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_FIG_SAPLING_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_FIG_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRELLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PASSION_FRUIT_TRELLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ELDERBERRY_TRELLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOW_BERRY_TRELLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAPISBERRY_TRELLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOWER_TRELLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_CARROTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_POTATOES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_WHEAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_BEETROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FERMENTATION_VESSEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FULL_FERMENTATION_VESSEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_TILES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_TILE_SLAB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_TILE_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAMOMILE_FLOWERS, RenderLayer.getCutout());
        registerBlockColor(ModBlocks.CERAMIC_TILES);
        registerBlockColor(ModBlocks.CERAMIC_TILE_STAIRS);
        registerBlockColor(ModBlocks.CERAMIC_TILE_SLAB);
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.HOARY, TexturedRenderLayers.getSignTextureId(ModWoodTypes.HOARY));
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.HOARY_BOAT_ID, false);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos)
                : FoliageColors.getDefaultColor(), ModBlocks.CHAMOMILE_FLOWERS);
    }
    private void registerBlockColor(Block ModCeramicBlocksItems) {
        registerItemColor(ModCeramicBlocksItems);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> CeramicTilesBlockEntity.getColor(world,pos),ModCeramicBlocksItems);
    }

    private void registerItemColor(Block ModCeramicBlocksItems) {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            NbtCompound nbtCompound = stack.getSubNbt(DyeableCeramicBlockItem.DISPLAY_KEY);
            if (nbtCompound != null && nbtCompound.contains(DyeableCeramicBlockItem.COLOR_KEY, NbtElement.NUMBER_TYPE)) {
                return nbtCompound.getInt(DyeableCeramicBlockItem.COLOR_KEY);
            }
            return CeramicTilesBlockEntity.DEFAULT_COLOR;
        },ModCeramicBlocksItems);
    }
}
