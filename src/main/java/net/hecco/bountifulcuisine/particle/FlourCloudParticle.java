package net.hecco.bountifulcuisine.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class FlourCloudParticle extends SpriteBillboardParticle {
    public FlourCloudParticle(ClientWorld world, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);
        this.velocityMultiplier = 0.95f;
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;
        this.scale = 0.5f + world.random.nextFloat();
        this.maxAge = 100 + world.random.nextInt(50);
        this.collidesWithWorld = true;

//        this.alpha = 0f;
        this.setSpriteForAge(spriteSet);
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge || this.alpha <= 0.0f && this.age >= maxAge - 20) {
            this.markDead();
            return;
        }
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        this.velocityX *= (double)this.velocityMultiplier;
        this.velocityY *= (double)this.velocityMultiplier;
        this.velocityZ *= (double)this.velocityMultiplier;
//        this.move(this.velocityX, this.velocityY, this.velocityZ);
        if (this.age != this.maxAge) {
            this.scale *= 1.005f;
        }
        if (this.age >= this.maxAge - 50 && this.alpha > 0f) {
            this.alpha *= 0.8f;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;
        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new FlourCloudParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
