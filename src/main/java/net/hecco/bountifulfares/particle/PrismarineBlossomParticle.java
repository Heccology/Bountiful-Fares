package net.hecco.bountifulfares.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class PrismarineBlossomParticle extends SpriteBillboardParticle {
    public PrismarineBlossomParticle(ClientWorld world, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);
        this.velocityMultiplier = 0.95f;
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;
        this.scale = 0.05f + world.random.nextFloat()/20;
        this.maxAge = 20 + world.random.nextInt(10);
        this.collidesWithWorld = false;

//        this.alpha = 0f;
        this.setSpriteForAge(spriteSet);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_LIT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;
        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new PrismarineBlossomParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
