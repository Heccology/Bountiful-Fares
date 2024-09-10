package net.hecco.bountifulfares.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;

public class FlourCloudParticle extends SpriteBillboardParticle {
    public FlourCloudParticle(ClientWorld world, double xCoord, double yCoord, double zCoord, SpriteProvider spriteSet, double xd, double yd, double zd, int angle) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);
        this.velocityMultiplier = 0.95f;
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;
        this.scale = 0.5f + world.random.nextFloat();
        this.maxAge = 200 + world.random.nextBetween(0, 10);
        this.collidesWithWorld = true;
        this.prevAngle = angle;

//        this.alpha = 0f;
        this.setSprite(spriteSet);
    }

    @Override
    public void tick() {
        this.angle = prevAngle;
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge || this.age >= maxAge) {
            this.markDead();
            return;
        }
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        this.velocityX *= (double)this.velocityMultiplier;
        this.velocityY *= (double)this.velocityMultiplier;
        this.velocityZ *= (double)this.velocityMultiplier;
        if (this.age != this.maxAge) {
            this.scale *= 1.001f;
        }
        if (this.age >= this.maxAge - 100 && this.alpha > 0f) {
            this.alpha -= 0.01f;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprites;
        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientWorld clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new FlourCloudParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd, Random.create().nextBetween(0, 180));
        }
    }
}
