package net.hecco.bountifulfares.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BFParticles {

    public static final DefaultParticleType FLOUR_CLOUD_PARTICLE = registerParticle("flour_cloud", FabricParticleTypes.simple());
    public static final DefaultParticleType PRISMARINE_BLOSSOM_PARTICLE = registerParticle("prismarine_blossom", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(BountifulFares.MOD_ID, name), particleType);
    }
    public static void registerParticles() {
//        BountifulFares.LOGGER.info("Registering Mod Particles for " + BountifulFares.MOD_ID);
    }
}
