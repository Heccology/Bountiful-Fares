package net.hecco.bountifulfares.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class FermentedBubbleParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;
    protected FermentedBubbleParticle(ClientWorld clientWorld, double d, double e, double f, double red, double green, double blue, SpriteProvider spriteProvider) {
        super(clientWorld, d, e, f);
        this.spriteProvider = spriteProvider;
        this.maxAge = world.random.nextBetween(50, 100);
        this.scale = 0;
        this.velocityX = 0;
        this.velocityY = 0;
        this.velocityZ = 0;
        this.red = (float) red;
        this.green = (float) green;
        this.blue = (float) blue;
        this.collidesWithWorld = false;
        this.setSprite(spriteProvider.getSprite(1, 2));
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        this.prevAngle = this.angle;
        if (this.age + 2 >= this.maxAge) {
            this.setSprite(this.spriteProvider.getSprite(2, 2));
        }
        if (this.age++ >= this.maxAge) {
            this.markDead();
        }
        int max = this.maxAge * 2;
        this.scale = (float) -((this.age * this.age) - max * this.age) / (max * 600);
        this.move(this.velocityX, this.velocityY, this.velocityZ);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprites;
        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientWorld clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new FermentedBubbleParticle(clientWorld, x, y, z, xd, yd, zd, sprites);
        }
    }
}
