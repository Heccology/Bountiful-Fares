package net.hecco.bountifulfares;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.hecco.bountifulfares.particle.PrismarineBlossomParticle;
import net.hecco.bountifulfares.registry.content.BFParticles;

public class FabricBountifulFaresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BountifulFaresClient.onInitializeClient();
        ParticleFactoryRegistry.getInstance().register(BFParticles.PRISMARINE_BLOSSOM.get(), PrismarineBlossomParticle.Factory::new);
    }
}
