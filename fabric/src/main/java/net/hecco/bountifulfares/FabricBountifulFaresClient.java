package net.hecco.bountifulfares;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hecco.bountifulfares.definition.block.entity.renderer.*;
import net.hecco.bountifulfares.definition.block.entity.renderer.model.TrellisBlockEntityModel;
import net.hecco.bountifulfares.definition.particle.FermentedBubbleParticle;
import net.hecco.bountifulfares.definition.particle.FlourCloudParticle;
import net.hecco.bountifulfares.definition.particle.GoldenPetalParticle;
import net.hecco.bountifulfares.definition.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.definition.screen.GristmillScreen;
import net.hecco.bountifulfares.registry.BFFoliageGeneration;
import net.hecco.bountifulfares.registry.BFMessages;
import net.hecco.bountifulfares.registry.BFTreeGeneration;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFEntities;
import net.hecco.bountifulfares.registry.content.BFMenus;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.registry.misc.BFModelLayers;
import net.hecco.bountifulfares.registry.util.BFTooltipEvents;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
        ParticleFactoryRegistry.getInstance().register(BFParticles.FERMENTED_BUBBLE.get(), FermentedBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.FLOUR_CLOUD.get(), FlourCloudParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(BFParticles.GOLDEN_PETAL.get(), GoldenPetalParticle.Factory::new);
        BlockEntityRenderers.register(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), TrellisBlockEntityRenderer::new);
        BlockEntityRenderers.register(BFBlockEntities.COIR_BED_BLOCK_ENTITY.get(), CoirBedBlockEntityRenderer::new);
        BlockEntityRenderers.register(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY.get(), CeramicDishBlockEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(BFModelLayers.TRELLIS_DEFAULT, TrellisBlockEntityModel::createDefaultLayer);
        EntityModelLayerRegistry.registerModelLayer(BFModelLayers.TRELLIS_INVERTED, TrellisBlockEntityModel::createInvertedLayer);

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
