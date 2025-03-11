package net.hecco.bountifulfares.registry.content;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BFParticles {

    public static final SimpleParticleType FLOUR_CLOUD = registerParticle("flour_cloud", FabricParticleTypes.simple());
    public static final SimpleParticleType PRISMARINE_BLOSSOM = registerParticle("prismarine_blossom", FabricParticleTypes.simple());
    public static final SimpleParticleType FERMENTED_BUBBLE = registerParticle("fermented_bubble", FabricParticleTypes.simple());
    public static final SimpleParticleType GOLDEN_PETAL = registerParticle("golden_petal", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(BountifulFares.MOD_ID, name), particleType);
    }
    public static void registerParticles() {
//        BountifulFares.LOGGER.info("Registering Mod Particles for " + BountifulFares.MOD_ID);
    }
}
