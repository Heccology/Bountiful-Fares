package net.hecco.bountifulfares;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hecco.bountifulfares.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.block.entity.renderer.CeramicDishBlockEntityRenderer;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.networking.BFMessages;
import net.hecco.bountifulfares.particle.FermentedBubbleParticle;
import net.hecco.bountifulfares.particle.FlourCloudParticle;
import net.hecco.bountifulfares.particle.GoldenPetalParticle;
import net.hecco.bountifulfares.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.misc.BFScreenHandlers;
import net.hecco.bountifulfares.registry.util.BFTooltipEvents;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.hecco.bountifulfares.screen.GristmillScreen;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.biome.FoliageColors;
import net.minecraft.world.biome.GrassColors;

import java.util.Objects;

import static net.hecco.bountifulfares.registry.content.BFItems.ARTISAN_BRUSH;

public class BountifulFaresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BFMessages.registerS2CPackets();
        ItemTooltipCallback.EVENT.register(BFTooltipEvents::addTooltipsToVanillaItems);
        BlockEntityRendererFactories.register(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY, CeramicDishBlockEntityRenderer::new);
//        ElsAndLsDyes compat
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.ACORN_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.ARTICHOKE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.AMBER_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.BANANA_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.CERULEAN_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.FUCHSIA_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.GRAPE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.INDIGO_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.MAROON_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.MAUVE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.MOLD_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.MINT_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.NAVY_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.PEACH_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.PERIWINKLE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.SAGE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.SAP_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.SHAMROCK_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.VELVET_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.VERMILION_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(MintBlocks.WINTERGREEN_PICKETS, RenderLayer.getCutout());

//        DyeDepot compat
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.MAROON_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.ROSE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.CORAL_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.GINGER_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.TAN_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.BEIGE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.AMBER_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.OLIVE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.FOREST_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.VERDANT_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.TEAL_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.MINT_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.AQUA_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.SLATE_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.NAVY_JACK_O_STRAW, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(DyeDepotBlocks.INDIGO_JACK_O_STRAW, RenderLayer.getCutout());
//        ExcessiveBuilding compat
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingBlocks.ANCIENT_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingBlocks.WALNUT_LADDER, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingBlocks.HOARY_LADDER, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS, RenderLayer.getCutout());
            registerBlockColor(ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS);
            registerBlockColor(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS);
            registerBlockColor(ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS);
            registerBlockColor(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS);

//        NaturesSpirit compat
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.ASPEN_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.CEDAR_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.COCONUT_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.CYPRESS_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.FIR_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.JOSHUA_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.GHAF_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.LARCH_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.MAHOGANY_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.MAPLE_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.MAHOGANY_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.OLIVE_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.PALO_VERDE_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.REDWOOD_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.SAXAUL_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.SUGI_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.WILLOW_PICKETS, RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(NaturesSpiritBlocks.WISTERIA_PICKETS, RenderLayer.getCutout());

        //        Spawn compat
            BlockRenderLayerMap.INSTANCE.putBlock(SpawnBlocks.ROTTEN_PICKETS, RenderLayer.getCutout());
        //        ArtsAndCrafts compat
            BlockRenderLayerMap.INSTANCE.putBlock(ArtsAndCraftsBlocks.CORK_PICKETS, RenderLayer.getCutout());

        //        DelicateDyes compat
        BlockRenderLayerMap.INSTANCE.putBlock(DelicateDyesBlocks.CORAL_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DelicateDyesBlocks.CANARY_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DelicateDyesBlocks.WASABI_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DelicateDyesBlocks.SKY_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DelicateDyesBlocks.ROSE_JACK_O_STRAW, RenderLayer.getCutout());

        //          Appledog compat
        BlockRenderLayerMap.INSTANCE.putBlock(AppledogBlocks.APPLEDOG_BLOCK, RenderLayer.getCutout());

        //          DungeonsDelight compat
        BlockRenderLayerMap.INSTANCE.putBlock(DungeonsDelightBlocks.WORMWOOD_PICKETS, RenderLayer.getCutout());

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
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GOLDEN_APPLE_LOG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GOLDEN_APPLE_WOOD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_GOLDEN_APPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_WITHERED_GOLDEN_APPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GOLDEN_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_GOLDEN_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HOARY_APPLE_SAPLING_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HOARY_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_WALNUT_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_HOARY_APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_HOARY_APPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WALNUT_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.HANGING_WALNUTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.FALLEN_WALNUTS, RenderLayer.getCutout());
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
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.IRON_RAILING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.GRASSY_DIRT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PALM_FROND, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.WALL_PALM_FROND, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.POTTED_PALM_FROND, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.COCONUT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BFBlocks.PALM_SAPLING, RenderLayer.getCutout());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (stack.getComponents().contains(DataComponentTypes.DYED_COLOR) && tintIndex == 0) {
                return ColorHelper.Argb.fullAlpha(Objects.requireNonNull(stack.getComponents().get(DataComponentTypes.DYED_COLOR)).rgb());
            }
            return ArtisanBrushItem.DEFAULT_COLOR;
        }, ARTISAN_BRUSH);
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
        registerBlockColor(BFBlocks.CERAMIC_DISH);
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
                : FoliageColors.getDefaultColor(),
                BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.APPLE_LOG, BFBlocks.APPLE_WOOD,
                BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.ORANGE_LOG, BFBlocks.ORANGE_WOOD,
                BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.LEMON_LOG, BFBlocks.LEMON_WOOD,
                BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.PLUM_LOG, BFBlocks.PLUM_WOOD,
                BFBlocks.WALNUT_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getDefaultColor(), BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.ORANGE_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 5809764, BFBlocks.WALNUT_LEAVES);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos)
                : FoliageColors.getDefaultColor(), BFBlocks.HANGING_WALNUTS);

        HandledScreens.register(BFScreenHandlers.GRISTMILL_SCREEN_HANDLER, GristmillScreen::new);
        EntityRendererRegistry.register(BFEntities.THROWN_FLOUR_PROJECTILE, FlyingItemEntityRenderer::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.FLOUR_CLOUD, FlourCloudParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.PRISMARINE_BLOSSOM, PrismarineBlossomParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.FERMENTED_BUBBLE, FermentedBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.GOLDEN_PETAL, GoldenPetalParticle.Factory::new);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : FoliageColors.getDefaultColor()), BFBlocks.WILD_POTATOES, BFBlocks.WILD_CARROTS, BFBlocks.WILD_BEETROOTS, BFBlocks.WILD_LEEKS, BFBlocks.WILD_MAIZE, BFBlocks.WILD_PASSION_FRUIT_VINE, BFBlocks.WILD_ELDERBERRY_VINE);

        ModelPredicateProviderRegistry.register(
                ARTISAN_BRUSH, Identifier.of(BountifulFares.MOD_ID, "dyed"),
                (itemStack, clientWorld, livingEntity, seed) ->
                        itemStack.getComponents().get(DataComponentTypes.DYED_COLOR) != null ? 1.0F : 0.0F);

        for (Block block : BFTrellises.TRELLIS_RENDER_CUTOUT) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }
    }



    private void registerBlockColor(Block ModCeramicBlocksItems) {
//        Registers tint for ceramic blocks
        registerItemColor(ModCeramicBlocksItems.asItem());
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> DyeableBlockEntity.getColor(world,pos),ModCeramicBlocksItems);
    }

    private void registerItemColor(Item item) {
//        Registers tint for ceramic items
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            if (stack.getComponents().get(DataComponentTypes.DYED_COLOR) != null && tintIndex == 0) {
                return stack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
            }
            return DyeableBlockEntity.DEFAULT_COLOR;
        },item);
    }
}
