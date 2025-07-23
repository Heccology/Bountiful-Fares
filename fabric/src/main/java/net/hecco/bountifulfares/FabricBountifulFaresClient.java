package net.hecco.bountifulfares;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.impl.client.model.loading.ModelLoadingPluginManager;
import net.hecco.bountifulfares.block.entity.renderer.CeramicDishBlockEntityRenderer;
import net.hecco.bountifulfares.block.entity.renderer.TrellisBlockEntityRenderer;
import net.hecco.bountifulfares.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.trellis.TrellisModelLoadingPlugin;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FabricBountifulFaresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BountifulFaresClient.onInitializeClient();
        ParticleFactoryRegistry.getInstance().register(BFParticles.PRISMARINE_BLOSSOM.get(), PrismarineBlossomParticle.Factory::new);
        BlockEntityRenderers.register(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), TrellisBlockEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TrellisBlockEntityRenderer.TRELLIS_LAYER, TrellisBlockEntityRenderer::createBodyLayer);
    }
}
