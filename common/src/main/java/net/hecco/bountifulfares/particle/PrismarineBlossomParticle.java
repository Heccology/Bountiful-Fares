package net.hecco.bountifulfares.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class PrismarineBlossomParticle extends TextureSheetParticle {
    public PrismarineBlossomParticle(ClientLevel world, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);
        this.friction = 0.95f;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize = 0.05f + world.random.nextFloat()/20;
        this.lifetime = 20 + world.random.nextInt(10);
        this.hasPhysics = false;

//        this.alpha = 0f;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public Factory(SpriteSet spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new PrismarineBlossomParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
