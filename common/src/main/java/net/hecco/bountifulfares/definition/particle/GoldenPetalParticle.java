package net.hecco.bountifulfares.definition.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class GoldenPetalParticle extends TextureSheetParticle {
    private float rotation;
    private final float randomThing;
    private final float otherRotation;

    protected GoldenPetalParticle(ClientLevel world, double x, double y, double z, SpriteSet spriteProvider) {
        super(world, x, y, z);
        this.setSprite(spriteProvider.get(this.random.nextInt(3), 3));
        this.rotation = (float)Math.toRadians(this.random.nextBoolean() ? (double)-30.0F : (double)30.0F);
        this.randomThing = this.random.nextFloat();
        this.otherRotation = (float)Math.toRadians(this.random.nextBoolean() ? (double)-5.0F : (double)5.0F);
        this.lifetime = 300;
        this.gravity = 7.5E-4F;
        float f = this.random.nextBoolean() ? 0.05F : 0.075F;
        this.quadSize = f;
        this.setSize(f, f);
        this.friction = 1.0F;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        }

        if (!this.removed) {
            float f = (float)(300 - this.lifetime);
            float g = Math.min(f / 300.0F, 1.0F);
            double d = Math.cos(Math.toRadians(this.randomThing * 60.0F)) * (double)2.0F * Math.pow(g, 1.25F);
            double e = Math.sin(Math.toRadians(this.randomThing * 60.0F)) * (double)2.0F * Math.pow(g, 1.25F);
            this.xd += d * (double)0.0025F;
            this.zd += e * (double)0.0025F;
            this.yd -= this.gravity;
            this.rotation += this.otherRotation / 20.0F;
            this.oRoll = this.roll;
            this.roll += this.rotation / 20.0F;
            this.move(this.xd, this.yd, this.zd);
            if (this.onGround || this.lifetime < 299 && (this.xd == (double)0.0F || this.zd == (double)0.0F)) {
                this.remove();
            }

            if (!this.removed) {
                this.xd *= this.friction;
                this.yd *= this.friction;
                this.zd *= this.friction;
            }
        }
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public Factory(SpriteSet spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new GoldenPetalParticle(clientWorld, x, y, z, sprites);
        }
    }
}