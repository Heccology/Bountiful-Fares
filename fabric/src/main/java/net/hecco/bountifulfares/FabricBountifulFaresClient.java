package net.hecco.bountifulfares;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hecco.bountifulfares.definition.block.entity.renderer.*;
import net.hecco.bountifulfares.definition.particle.FlourCloudParticle;
import net.hecco.bountifulfares.registry.BFFoliageGeneration;
import net.hecco.bountifulfares.registry.BFMessages;
import net.hecco.bountifulfares.definition.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.registry.BFTreeGeneration;
import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.definition.screen.GristmillScreen;
import net.hecco.bountifulfares.registry.util.BFTooltipEvents;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Pair;

public class FabricBountifulFaresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BFMessages.registerS2CPackets();
        ItemTooltipCallback.EVENT.register(BFTooltipEvents::addTooltipsToVanillaItemsFabric);
        BountifulFaresClient.onInitializeClient();
        BFFoliageGeneration.generateFlowers();
        BFTreeGeneration.generateTrees();
        ParticleFactoryRegistry.getInstance().register(BFParticles.PRISMARINE_BLOSSOM.get(), PrismarineBlossomParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.FLOUR_CLOUD.get(), FlourCloudParticle.Factory::new);
        BlockEntityRenderers.register(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), TrellisBlockEntityRenderer::new);
        BlockEntityRenderers.register(BFBlockEntities.COIR_BED_BLOCK_ENTITY.get(), CoirBedBlockEntityRenderer::new);
        BlockEntityRenderers.register(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY.get(), CeramicDishBlockEntityRenderer::new);
        BlockEntityRenderers.register(BFBlockEntities.MOD_SIGN_BLOCK_ENTITY.get(), ModSignRenderer::new);
        BlockEntityRenderers.register(BFBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY.get(), ModHangingSignRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModelLayers.createSignModelName(BFWoodTypes.HOARY), ModSignRenderer::createSignLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelLayers.createHangingSignModelName(BFWoodTypes.HOARY), ModHangingSignRenderer::createHangingSignLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelLayers.createSignModelName(BFWoodTypes.WALNUT), ModSignRenderer::createSignLayer);
        EntityModelLayerRegistry.registerModelLayer(ModelLayers.createHangingSignModelName(BFWoodTypes.WALNUT), ModHangingSignRenderer::createHangingSignLayer);
        EntityModelLayerRegistry.registerModelLayer(TrellisBlockEntityRenderer.TRELLIS_DEFAULT, TrellisBlockEntityRenderer::createDefaultLayer);
        EntityModelLayerRegistry.registerModelLayer(TrellisBlockEntityRenderer.TRELLIS_INVERTED, TrellisBlockEntityRenderer::createInvertedLayer);

        for (Pair<BlockColor, Block> pair : BountifulFaresClient.blockColors) {
            ColorProviderRegistry.BLOCK.register(pair.getA(), pair.getB());
        }
        for (Pair<ItemColor, ItemLike> pair : BountifulFaresClient.itemColors) {
            ColorProviderRegistry.ITEM.register(pair.getA(), pair.getB());
        }

        EntityRendererRegistry.register(BFEntities.THROWN_FLOUR_PROJECTILE.get(), ThrownItemRenderer::new);
        MenuScreens.register(BFMenus.GRISTMILL_SCREEN_HANDLER.get(), GristmillScreen::new);
    }
}
