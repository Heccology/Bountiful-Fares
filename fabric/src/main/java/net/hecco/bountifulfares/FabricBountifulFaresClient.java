package net.hecco.bountifulfares;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.hecco.bountifulfares.block.entity.renderer.CeramicDishBlockEntityRenderer;
import net.hecco.bountifulfares.block.entity.renderer.TrellisBlockEntityRenderer;
import net.hecco.bountifulfares.registry.BFMessages;
import net.hecco.bountifulfares.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FabricBountifulFaresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BFMessages.registerS2CPackets();
        BountifulFaresClient.onInitializeClient();
        ParticleFactoryRegistry.getInstance().register(BFParticles.PRISMARINE_BLOSSOM.get(), PrismarineBlossomParticle.Factory::new);
        BlockEntityRenderers.register(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), TrellisBlockEntityRenderer::new);
        BlockEntityRenderers.register(BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY.get(), CeramicDishBlockEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TrellisBlockEntityRenderer.TRELLIS_DEFAULT, TrellisBlockEntityRenderer::createDefaultLayer);
        EntityModelLayerRegistry.registerModelLayer(TrellisBlockEntityRenderer.TRELLIS_INVERTED, TrellisBlockEntityRenderer::createInvertedLayer);
    }
}
