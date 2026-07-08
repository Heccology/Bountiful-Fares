package net.hecco.bountifulfares;

import net.hecco.bountifulfares.definition.block.entity.renderer.*;
import net.hecco.bountifulfares.definition.block.entity.renderer.model.TrellisBlockEntityModel;
import net.hecco.bountifulfares.definition.particle.FermentedBubbleParticle;
import net.hecco.bountifulfares.definition.particle.FlourCloudParticle;
import net.hecco.bountifulfares.definition.particle.GoldenPetalParticle;
import net.hecco.bountifulfares.definition.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.definition.screen.GristmillScreen;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFEntities;
import net.hecco.bountifulfares.registry.content.BFMenus;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.registry.misc.BFModelLayers;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import oshi.util.tuples.Pair;

@EventBusSubscriber(modid = BountifulFares.MOD_ID, value = Dist.CLIENT)
public class NeoForgeClientEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ModContainer container = NeoForgeBountifulFares.modContainer;
        if (container != null) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }
    }

    @SubscribeEvent
    public static void blockColorSetup(RegisterColorHandlersEvent.Block event) {
        for (Pair<BlockColor, Block> pair : BountifulFaresClient.blockColors) {
            event.register(pair.getA(), pair.getB());
        }
    }

    @SubscribeEvent
    public static void itemColorSetup(RegisterColorHandlersEvent.Item event) {
        for (Pair<ItemColor, ItemLike> pair : BountifulFaresClient.itemColors) {
            event.register(pair.getA(), pair.getB());
        }
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BFEntities.THROWN_FLOUR_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerBlockEntityRenderer(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), TrellisRenderer::new);
        event.registerBlockEntityRenderer(BFBlockEntities.COIR_BED_BLOCK_ENTITY.get(), CoirBedRenderer::new);
        event.registerBlockEntityRenderer(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY.get(), CeramicDishRenderer::new);
        event.registerBlockEntityRenderer(BFBlockEntities.CERAMIC_CHEST_BLOCK_ENTITY.get(), CeramicChestRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BFModelLayers.TRELLIS_DEFAULT, TrellisBlockEntityModel::createDefaultLayer);
        event.registerLayerDefinition(BFModelLayers.TRELLIS_INVERTED, TrellisBlockEntityModel::createInvertedLayer);
        event.registerLayerDefinition(BFModelLayers.CERAMIC_CHEST, CeramicChestRenderer::createSingleBodyLayer);
        event.registerLayerDefinition(BFModelLayers.CERAMIC_DOUBLE_CHEST_LEFT, CeramicChestRenderer::createDoubleBodyLeftLayer);
        event.registerLayerDefinition(BFModelLayers.CERAMIC_DOUBLE_CHEST_RIGHT, CeramicChestRenderer::createDoubleBodyRightLayer);
    }

    @SubscribeEvent
    public static void onRegisterParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(BFParticles.FLOUR_CLOUD.get(), FlourCloudParticle.Factory::new);
        event.registerSpriteSet(BFParticles.PRISMARINE_BLOSSOM.get(), PrismarineBlossomParticle.Factory::new);
        event.registerSpriteSet(BFParticles.FERMENTED_BUBBLE.get(), FermentedBubbleParticle.Factory::new);
        event.registerSpriteSet(BFParticles.GOLDEN_PETAL.get(), GoldenPetalParticle.Factory::new);
    }

    @SubscribeEvent
    public static void onRegisterScreens(RegisterMenuScreensEvent event) {
        event.register(BFMenus.GRISTMILL_SCREEN_HANDLER.get(), GristmillScreen::new);
    }
}
