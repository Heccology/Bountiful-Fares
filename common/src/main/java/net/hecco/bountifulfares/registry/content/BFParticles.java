package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public class BFParticles {
    //Might need to be loader specific
    public static final Supplier<SimpleParticleType> FLOUR_CLOUD = registerParticle("flour_cloud");
    public static final Supplier<SimpleParticleType> PRISMARINE_BLOSSOM = registerParticle("prismarine_blossom");
    public static final Supplier<SimpleParticleType> FERMENTED_BUBBLE = registerParticle("fermented_bubble");
    public static final Supplier<SimpleParticleType> GOLDEN_PETAL = registerParticle("golden_petal");

    private static Supplier<SimpleParticleType> registerParticle(String name) {
        return HLServices.REGISTRY.registerParticleType(BountifulFares.MOD_ID, name);
    }

    public static void registerParticles() {
    }
}
