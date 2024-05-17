package net.hecco.bountifulfares;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.ModTrellises;
import net.hecco.bountifulfares.block.TrellisUtil;
import net.hecco.bountifulfares.block.TrellisVariants;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.block.entity.ModBlockEntities;
import net.hecco.bountifulfares.block.entity.renderer.CeramicDishBlockEntityRenderer;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.entity.ModBoats;
import net.hecco.bountifulfares.entity.ModEntities;
import net.hecco.bountifulfares.item.ModItems;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulfares.networking.ModMessages;
import net.hecco.bountifulfares.particle.FlourCloudParticle;
import net.hecco.bountifulfares.particle.ModParticles;
import net.hecco.bountifulfares.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.screen.GristmillScreen;
import net.hecco.bountifulfares.screen.ModScreenHandlers;
import net.hecco.bountifulfares.util.ModWoodTypes;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.Identifier;

import java.util.Objects;

import static net.hecco.bountifulfares.item.ModItems.ARTISAN_BRUSH;
import static net.hecco.bountifulfares.item.ModItems.SUN_HAT;

public class BountifulFaresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModMessages.registerS2CPackets();
        BlockEntityRendererFactories.register(ModBlockEntities.CERAMIC_DISH_BLOCK_ENTITY, CeramicDishBlockEntityRenderer::new);
//        ElsAndLsDyes compat
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACORN_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ARTICHOKE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBER_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BANANA_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERULEAN_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FUCHSIA_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INDIGO_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAROON_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAUVE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOLD_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MINT_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NAVY_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEACH_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PERIWINKLE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAGE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAP_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHAMROCK_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VELVET_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERMILION_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WINTERGREEN_PICKETS, RenderLayer.getCutout());
        }
//        DyeDepot compat
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.DYE_DEPOT_MOD_ID)) {
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAROON_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROSE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORAL_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINGER_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TAN_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBER_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OLIVE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FOREST_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANT_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TEAL_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MINT_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AQUA_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SLATE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NAVY_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INDIGO_JACK_O_STRAW, RenderLayer.getCutout());
        }
//        ExcessiveBuilding compat
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ANCIENT_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALNUT_LADDER, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_LADDER, RenderLayer.getCutout());
        }
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_APPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ORANGE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_LEMON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LEMON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_PLUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_PLUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_APPLE_SAPLING_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_WALNUT_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_HOARY_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_HOARY_APPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALNUT_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_WALNUTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FALLEN_WALNUTS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PASSION_FRUIT_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ELDERBERRY_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOW_BERRY_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAPISBERRY_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROSE_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LILAC_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEONY_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUNFLOWER_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VINE_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WEEPING_TRELLIS, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TWISTING_TRELLIS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_CARROTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_POTATOES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_WHEAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_BEETROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_LEEKS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_MAIZE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_PASSION_FRUIT_VINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_ELDERBERRY_VINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FERMENTATION_VESSEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FELDSPAR_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TINGED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHECKERED_CERAMIC_TILES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHECKERED_CERAMIC_TILE_SLAB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRACKED_CHECKERED_CERAMIC_TILES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHECKERED_CERAMIC_MOSAIC, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLUM_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALNUT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TEA_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAMOMILE_FLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HONEYSUCKLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_HONEYSUCKLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VIOLET_BELLFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_VIOLET_BELLFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIME_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYAN_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_BLUE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURPLE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAGENTA_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_GRAY_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAY_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_TEA_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_TEA_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAMOMILE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HONEYSUCKLE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BELLFLOWER_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TORCHFLOWER_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALNUT_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEEKS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAIZE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPONGEKIN_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPONGEKIN_SPROUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PRISMARINE_BLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SCORCHKIN_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OAK_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPRUCE_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BIRCH_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNGLE_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACACIA_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_OAK_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGROVE_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHERRY_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAMBOO_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALNUT_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HOARY_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRIMSON_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WARPED_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRASSY_DIRT, RenderLayer.getCutout());
        registerItemColor(ModItems.ARTISAN_BRUSH);
        registerBlockColor(ModBlocks.CERAMIC_TILES);
        registerBlockColor(ModBlocks.CERAMIC_TILE_STAIRS);
        registerBlockColor(ModBlocks.CERAMIC_TILE_SLAB);
        registerBlockColor(ModBlocks.CRACKED_CERAMIC_TILES);
        registerBlockColor(ModBlocks.CHECKERED_CERAMIC_TILES);
        registerBlockColor(ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        registerBlockColor(ModBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        registerBlockColor(ModBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        registerBlockColor(ModBlocks.CERAMIC_MOSAIC);
        registerBlockColor(ModBlocks.CERAMIC_MOSAIC_STAIRS);
        registerBlockColor(ModBlocks.CERAMIC_MOSAIC_SLAB);
        registerBlockColor(ModBlocks.CHECKERED_CERAMIC_MOSAIC);
        registerBlockColor(ModBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        registerBlockColor(ModBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        registerBlockColor(ModBlocks.CERAMIC_TILE_PILLAR);
        registerBlockColor(ModBlocks.CERAMIC_PRESSURE_PLATE);
        registerBlockColor(ModBlocks.CERAMIC_BUTTON);
        registerBlockColor(ModBlocks.CERAMIC_LEVER);
        registerBlockColor(ModBlocks.CERAMIC_DOOR);
        registerBlockColor(ModBlocks.CERAMIC_TRAPDOOR);
        registerDishColor();
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.HOARY, TexturedRenderLayers.getSignTextureId(ModWoodTypes.HOARY));
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.WALNUT, TexturedRenderLayers.getSignTextureId(ModWoodTypes.WALNUT));
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.HOARY_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.WALNUT_BOAT_ID, false);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos)
                : GrassColors.getDefaultColor(), ModBlocks.CHAMOMILE_FLOWERS, ModBlocks.GRASSY_DIRT);
        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getDefaultColor()), ModBlocks.GRASSY_DIRT);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos)
                : FoliageColors.getDefaultColor(), ModBlocks.WALNUT_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 5809764, ModBlocks.WALNUT_LEAVES);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos)
                : FoliageColors.getDefaultColor(), ModBlocks.HANGING_WALNUTS);

        HandledScreens.register(ModScreenHandlers.GRISTMILL_SCREEN_HANDLER, GristmillScreen::new);
        EntityRendererRegistry.register(ModEntities.THROWN_FLOUR_PROJECTILE, FlyingItemEntityRenderer::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FLOUR_CLOUD_PARTICLE, FlourCloudParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.PRISMARINE_BLOSSOM_PARTICLE, PrismarineBlossomParticle.Factory::new);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : FoliageColors.getDefaultColor()), ModBlocks.WILD_POTATOES, ModBlocks.WILD_CARROTS, ModBlocks.WILD_BEETROOTS, ModBlocks.WILD_LEEKS, ModBlocks.WILD_MAIZE, ModBlocks.WILD_PASSION_FRUIT_VINE, ModBlocks.WILD_ELDERBERRY_VINE);

        ModelPredicateProviderRegistry.register(SUN_HAT, new Identifier("head"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getEquippedStack(EquipmentSlot.HEAD) == itemStack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(ARTISAN_BRUSH, new Identifier("dyed"), (itemStack, clientWorld, livingEntity, seed) -> {
            NbtCompound nbtCompound = itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY);
            if (nbtCompound == null) {
                return 0.0F;
            }
            return 1.0F;
        });
        for (Block block : ModTrellises.TRELLIS_RENDER_CUTOUT) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }
    }



    private void registerBlockColor(Block ModCeramicBlocksItems) {
//        Registers tint for ceramic blocks
        registerItemColor(ModCeramicBlocksItems.asItem());
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> DyeableCeramicBlockEntity.getColor(world,pos),ModCeramicBlocksItems);
    }

    private void registerItemColor(Item item) {
//        Registers tint for ceramic items
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            NbtCompound nbtCompound = stack.getSubNbt(DyeableCeramicBlockItem.DISPLAY_KEY);
            if (nbtCompound != null && nbtCompound.contains(DyeableCeramicBlockItem.COLOR_KEY, NbtElement.NUMBER_TYPE) && tintIndex == 0) {
                return nbtCompound.getInt(DyeableCeramicBlockItem.COLOR_KEY);
            }
            return DyeableCeramicBlockEntity.DEFAULT_COLOR;
        },item);
    }

    private void registerDishColor() {
//        Registers tint for ceramic blocks
        registerDishItemColor();
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> CeramicDishBlockEntity.getColor(world,pos), ModBlocks.CERAMIC_DISH);
    }

    private void registerDishItemColor() {
//        Registers tint for ceramic items
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            NbtCompound nbtCompound = stack.getSubNbt(DyeableCeramicBlockItem.DISPLAY_KEY);
            if (nbtCompound != null && nbtCompound.contains(DyeableCeramicBlockItem.COLOR_KEY, NbtElement.NUMBER_TYPE)) {
                return nbtCompound.getInt(DyeableCeramicBlockItem.COLOR_KEY);
            }
            return CeramicDishBlockEntity.DEFAULT_COLOR;
        }, ModBlocks.CERAMIC_DISH);
    }
}
