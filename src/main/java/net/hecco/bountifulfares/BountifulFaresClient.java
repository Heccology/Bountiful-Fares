package net.hecco.bountifulfares;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.trellis.BFTrellises;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.block.entity.BFBlockEntities;
import net.hecco.bountifulfares.block.entity.renderer.CeramicDishBlockEntityRenderer;
import net.hecco.bountifulfares.entity.BFBoats;
import net.hecco.bountifulfares.entity.BFEntities;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulfares.networking.BFMessages;
import net.hecco.bountifulfares.particle.FlourCloudParticle;
import net.hecco.bountifulfares.particle.BFParticles;
import net.hecco.bountifulfares.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.screen.GristmillScreen;
import net.hecco.bountifulfares.screen.BFScreenHandlers;
import net.hecco.bountifulfares.util.BFWoodTypes;
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

import static net.hecco.bountifulfares.item.BFItems.ARTISAN_BRUSH;
import static net.hecco.bountifulfares.item.BFItems.SUN_HAT;

public class BountifulFaresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BFMessages.registerS2CPackets();
        BlockEntityRendererFactories.register(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY, CeramicDishBlockEntityRenderer::new);
//        ElsAndLsDyes compat
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACORN_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ARTICHOKE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBER_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BANANA_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERULEAN_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FUCHSIA_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INDIGO_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAROON_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAUVE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOLD_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MINT_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NAVY_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEACH_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PERIWINKLE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAGE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAP_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHAMROCK_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VELVET_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERMILION_JACK_O_STRAW, RenderLayer.getCutout());
//        DyeDepot compat
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROSE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORAL_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINGER_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TAN_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OLIVE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FOREST_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERDANT_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TEAL_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AQUA_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SLATE_JACK_O_STRAW, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INDIGO2_JACK_O_STRAW, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.APPLE_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.APPLE_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_APPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.ORANGE_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.ORANGE_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.ORANGE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_ORANGE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.LEMON_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.LEMON_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_LEMON, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.LEMON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_LEMON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PLUM_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PLUM_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_PLUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PLUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_PLUM_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HOARY_APPLE_SAPLING_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HOARY_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_WALNUT_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_HOARY_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_HOARY_APPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WALNUT_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_WALNUTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.FALLEN_WALNUTS, RenderLayer.getCutout());
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
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WILD_CARROTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WILD_POTATOES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WILD_WHEAT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WILD_BEETROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WILD_LEEKS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WILD_MAIZE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WILD_PASSION_FRUIT_VINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WILD_ELDERBERRY_VINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.FERMENTATION_VESSEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.FELDSPAR_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.TINGED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHECKERED_CERAMIC_TILES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHECKERED_CERAMIC_MOSAIC, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CERAMIC_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GOLDEN_APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.ORANGE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.LEMON_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PLUM_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HOARY_APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WALNUT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.TEA_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHAMOMILE_FLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HONEYSUCKLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_HONEYSUCKLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.VIOLET_BELLFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_VIOLET_BELLFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.RED_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.ORANGE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.YELLOW_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.LIME_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GREEN_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CYAN_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.LIGHT_BLUE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.BLUE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PURPLE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.MAGENTA_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PINK_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WHITE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.LIGHT_GRAY_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GRAY_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.BLACK_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.BROWN_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GREEN_TEA_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.BLACK_TEA_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHAMOMILE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HONEYSUCKLE_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.BELLFLOWER_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.TORCHFLOWER_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WALNUT_CANDLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.LEEKS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.MAIZE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.SPONGEKIN_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.SPONGEKIN_SPROUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PRISMARINE_BLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.SCORCHKIN_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.OAK_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.SPRUCE_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.BIRCH_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.JUNGLE_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.ACACIA_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.DARK_OAK_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.MANGROVE_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CHERRY_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.BAMBOO_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WALNUT_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HOARY_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.CRIMSON_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WARPED_PICKETS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GRASSY_DIRT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PALM_FROND, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WALL_PALM_FROND, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.COCONUT, RenderLayer.getCutout());
        registerItemColor(BFItems.ARTISAN_BRUSH);
        registerBlockColor(BFBlocks.CERAMIC_TILES);
        registerBlockColor(BFBlocks.CERAMIC_TILE_STAIRS);
        registerBlockColor(BFBlocks.CERAMIC_TILE_SLAB);
        registerBlockColor(BFBlocks.CRACKED_CERAMIC_TILES);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_TILES);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        registerBlockColor(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        registerBlockColor(BFBlocks.CERAMIC_MOSAIC);
        registerBlockColor(BFBlocks.CERAMIC_MOSAIC_STAIRS);
        registerBlockColor(BFBlocks.CERAMIC_MOSAIC_SLAB);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        registerBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        registerBlockColor(BFBlocks.CERAMIC_TILE_PILLAR);
        registerBlockColor(BFBlocks.CERAMIC_PRESSURE_PLATE);
        registerBlockColor(BFBlocks.CERAMIC_BUTTON);
        registerBlockColor(BFBlocks.CERAMIC_LEVER);
        registerBlockColor(BFBlocks.CERAMIC_DOOR);
        registerBlockColor(BFBlocks.CERAMIC_TRAPDOOR);
        registerDishColor();
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(BFWoodTypes.HOARY, TexturedRenderLayers.getSignTextureId(BFWoodTypes.HOARY));
        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(BFWoodTypes.WALNUT, TexturedRenderLayers.getSignTextureId(BFWoodTypes.WALNUT));
        BlockEntityRendererFactories.register(BFBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BFBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);
        TerraformBoatClientHelper.registerModelLayers(BFBoats.HOARY_BOAT_ID, false);
        TerraformBoatClientHelper.registerModelLayers(BFBoats.WALNUT_BOAT_ID, false);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos)
                : GrassColors.getDefaultColor(), BFBlocks.CHAMOMILE_FLOWERS, BFBlocks.GRASSY_DIRT);
        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getDefaultColor()), BFBlocks.GRASSY_DIRT);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos)
                : FoliageColors.getDefaultColor(), BFBlocks.WALNUT_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 5809764, BFBlocks.WALNUT_LEAVES);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos)
                : FoliageColors.getDefaultColor(), BFBlocks.HANGING_WALNUTS);

        HandledScreens.register(BFScreenHandlers.GRISTMILL_SCREEN_HANDLER, GristmillScreen::new);
        EntityRendererRegistry.register(BFEntities.THROWN_FLOUR_PROJECTILE, FlyingItemEntityRenderer::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.FLOUR_CLOUD_PARTICLE, FlourCloudParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.PRISMARINE_BLOSSOM_PARTICLE, PrismarineBlossomParticle.Factory::new);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : FoliageColors.getDefaultColor()), BFBlocks.WILD_POTATOES, BFBlocks.WILD_CARROTS, BFBlocks.WILD_BEETROOTS, BFBlocks.WILD_LEEKS, BFBlocks.WILD_MAIZE, BFBlocks.WILD_PASSION_FRUIT_VINE, BFBlocks.WILD_ELDERBERRY_VINE);

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
//        for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//                BlockRenderLayerMap.INSTANCE.putBlock(TrellisUtil.getTrellisFromVariant(trellis), RenderLayer.getCutout());
//                for (VineCrop crop : TrellisVariants.VineCrops) {
//                    BlockRenderLayerMap.INSTANCE.putBlock(TrellisUtil.getCropTrellisFromVariant(trellis, crop), RenderLayer.getCutout());
//                }
//                for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
//                    BlockRenderLayerMap.INSTANCE.putBlock(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), RenderLayer.getCutout());
//                }
//        }
        for (Block block : BFTrellises.TRELLIS_RENDER_CUTOUT) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }
    }
//        for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//            if (!Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                BlockRenderLayerMap.INSTANCE.putBlock(TrellisUtil.getTrellisFromVariant(trellis), RenderLayer.getCutout());
//                for (VineCrop crop : TrellisVariants.VineCrops) {
//                    BlockRenderLayerMap.INSTANCE.putBlock(TrellisUtil.getCropTrellisFromVariant(trellis, crop), RenderLayer.getCutout());
//                }
//                for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
//                    BlockRenderLayerMap.INSTANCE.putBlock(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), RenderLayer.getCutout());
//                }
//            }
//        }



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
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> CeramicDishBlockEntity.getColor(world,pos), BFBlocks.CERAMIC_DISH);
    }

    private void registerDishItemColor() {
//        Registers tint for ceramic items
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            NbtCompound nbtCompound = stack.getSubNbt(DyeableCeramicBlockItem.DISPLAY_KEY);
            if (nbtCompound != null && nbtCompound.contains(DyeableCeramicBlockItem.COLOR_KEY, NbtElement.NUMBER_TYPE)) {
                return nbtCompound.getInt(DyeableCeramicBlockItem.COLOR_KEY);
            }
            return CeramicDishBlockEntity.DEFAULT_COLOR;
        }, BFBlocks.CERAMIC_DISH);
    }
}
