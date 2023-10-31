package net.hecco.bountifulcuisine.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final DefaultParticleType FLOUR_CLOUD_PARTICLE = registerParticle("flour_cloud", FabricParticleTypes.simple());
    public static final DefaultParticleType PRISMARINE_BLOSSOM_PARTICLE = registerParticle("prismarine_blossom", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(BountifulCuisine.MOD_ID, name), particleType);
    }
    public static void registerParticles() {
        BountifulCuisine.LOGGER.info("Registering Mod Particles for " + BountifulCuisine.MOD_ID);
    }
}
