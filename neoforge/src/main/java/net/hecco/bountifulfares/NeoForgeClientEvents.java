package net.hecco.bountifulfares;

import net.hecco.bountifulfares.definition.block.entity.renderer.CoirBedBlockEntityRenderer;
import net.hecco.bountifulfares.definition.block.entity.renderer.TrellisBlockEntityRenderer;
import net.hecco.bountifulfares.definition.particle.FlourCloudParticle;
import net.hecco.bountifulfares.definition.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFEntities;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.registry.content.BFMenus;
import net.hecco.bountifulfares.definition.screen.GristmillScreen;
import net.hecco.bountifulfares.registry.util.BFTooltipEvents;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import oshi.util.tuples.Pair;

@EventBusSubscriber(modid = BountifulFares.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NeoForgeClientEvents {
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
        event.registerBlockEntityRenderer(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), TrellisBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(BFBlockEntities.COIR_BED_BLOCK_ENTITY.get(), CoirBedBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TrellisBlockEntityRenderer.TRELLIS_DEFAULT, TrellisBlockEntityRenderer::createDefaultLayer);
        event.registerLayerDefinition(TrellisBlockEntityRenderer.TRELLIS_INVERTED, TrellisBlockEntityRenderer::createInvertedLayer);
    }

    @SubscribeEvent
    public static void onRegisterParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(BFParticles.FLOUR_CLOUD.get(), FlourCloudParticle.Factory::new);
        event.registerSpriteSet(BFParticles.PRISMARINE_BLOSSOM.get(), PrismarineBlossomParticle.Factory::new);
    }

    @SubscribeEvent
    public static void onRegisterScreens(RegisterMenuScreensEvent event) {
        event.register(BFMenus.GRISTMILL_SCREEN_HANDLER.get(), GristmillScreen::new);
    }
}
