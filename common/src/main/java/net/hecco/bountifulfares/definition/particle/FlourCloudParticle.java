package net.hecco.bountifulfares.definition.particle;

import net.hecco.nexuslib.lib.util.NLParticleRenderTypes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class FlourCloudParticle extends TextureSheetParticle {
    public FlourCloudParticle(ClientLevel world, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd, int angle) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);
        this.friction = 0.95f;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize = 0.5f + world.random.nextFloat();
        this.lifetime = 200 + world.random.nextIntBetweenInclusive(0, 10);
        this.hasPhysics = true;
        this.oRoll = angle;

//        this.alpha = 0f;
        this.pickSprite(spriteSet);
    }

    @Override
    public void tick() {
        this.roll = oRoll;
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime || this.age >= lifetime) {
            this.remove();
            return;
        }
        this.move(this.xd, this.yd, this.zd);
        this.xd *= this.friction;
        this.yd *= this.friction;
        this.zd *= this.friction;
        if (this.age != this.lifetime) {
            this.quadSize *= 1.001f;
        }
        if (this.age >= this.lifetime - 100 && this.alpha > 0f) {
            this.alpha -= 0.01f;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return NLParticleRenderTypes.PARTICLE_SHEET_CLOUD;
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public Factory(SpriteSet spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel clientWorld, double x, double y, double z, double xd, double yd, double zd) {
            return new FlourCloudParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd, RandomSource.create().nextIntBetweenInclusive(0, 180));
        }
    }
}
