package net.hecco.bountifulfares.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class FermentedBubbleParticle extends TextureSheetParticle {
    private final SpriteSet spriteProvider;
    protected FermentedBubbleParticle(ClientLevel clientWorld, double d, double e, double f, double red, double green, double blue, SpriteSet spriteProvider) {
        super(clientWorld, d, e, f);
        this.spriteProvider = spriteProvider;
        this.lifetime = level.random.nextIntBetweenInclusive(50, 100);
        this.quadSize = 0;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.rCol = (float) red;
        this.gCol = (float) green;
        this.bCol = (float) blue;
        this.hasPhysics = false;
        this.setSprite(spriteProvider.get(1, 2));
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.oRoll = this.roll;
        if (this.age + 2 >= this.lifetime) {
            this.setSprite(this.spriteProvider.get(2, 2));
        }
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
        int max = this.lifetime * 2;
        this.quadSize = (float) -((this.age * this.age) - max * this.age) / (max * 600);
        this.move(this.xd, this.yd, this.zd);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public Factory(SpriteSet spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new FermentedBubbleParticle(clientWorld, x, y, z, xd, yd, zd, sprites);
        }
    }
}
