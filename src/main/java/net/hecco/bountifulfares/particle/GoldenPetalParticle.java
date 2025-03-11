package net.hecco.bountifulfares.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class GoldenPetalParticle extends SpriteBillboardParticle {
    private float rotation;
    private final float randomThing;
    private final float otherRotation;

    protected GoldenPetalParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider) {
        super(world, x, y, z);
        this.setSprite(spriteProvider.getSprite(this.random.nextInt(3), 3));
        this.rotation = (float)Math.toRadians(this.random.nextBoolean() ? (double)-30.0F : (double)30.0F);
        this.randomThing = this.random.nextFloat();
        this.otherRotation = (float)Math.toRadians(this.random.nextBoolean() ? (double)-5.0F : (double)5.0F);
        this.maxAge = 300;
        this.gravityStrength = 7.5E-4F;
        float f = this.random.nextBoolean() ? 0.05F : 0.075F;
        this.scale = f;
        this.setBoundingBoxSpacing(f, f);
        this.velocityMultiplier = 1.0F;
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        }

        if (!this.dead) {
            float f = (float)(300 - this.maxAge);
            float g = Math.min(f / 300.0F, 1.0F);
            double d = Math.cos(Math.toRadians(this.randomThing * 60.0F)) * (double)2.0F * Math.pow(g, 1.25F);
            double e = Math.sin(Math.toRadians(this.randomThing * 60.0F)) * (double)2.0F * Math.pow(g, 1.25F);
            this.velocityX += d * (double)0.0025F;
            this.velocityZ += e * (double)0.0025F;
            this.velocityY -= this.gravityStrength;
            this.rotation += this.otherRotation / 20.0F;
            this.prevAngle = this.angle;
            this.angle += this.rotation / 20.0F;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            if (this.onGround || this.maxAge < 299 && (this.velocityX == (double)0.0F || this.velocityZ == (double)0.0F)) {
                this.markDead();
            }

            if (!this.dead) {
                this.velocityX *= this.velocityMultiplier;
                this.velocityY *= this.velocityMultiplier;
                this.velocityZ *= this.velocityMultiplier;
            }
        }
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprites;
        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientWorld clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new GoldenPetalParticle(clientWorld, x, y, z, sprites);
        }
    }
}