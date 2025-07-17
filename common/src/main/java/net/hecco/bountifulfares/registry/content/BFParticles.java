package net.hecco.bountifulfares.registry.content;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class BFParticles {
    //Might need to be loader specific
    public static final SimpleParticleType FLOUR_CLOUD = registerParticle("flour_cloud", FabricParticleTypes.simple());
    public static final SimpleParticleType PRISMARINE_BLOSSOM = registerParticle("prismarine_blossom", FabricParticleTypes.simple());
    public static final SimpleParticleType FERMENTED_BUBBLE = registerParticle("fermented_bubble", FabricParticleTypes.simple());
    public static final SimpleParticleType GOLDEN_PETAL = registerParticle("golden_petal", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
    }
}
