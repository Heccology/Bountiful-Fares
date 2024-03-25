package net.hecco.bountifulfares.entity;

import net.hecco.bountifulfares.item.ModItems;
import net.hecco.bountifulfares.particle.ModParticles;
import net.hecco.bountifulfares.sounds.ModSounds;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class FlourProjectileEntity extends ThrownItemEntity {
    public FlourProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public FlourProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.THROWN_FLOUR_PROJECTILE, livingEntity, world);
    }

    public FlourProjectileEntity(World world, double x, double y, double z) {
        super(ModEntities.THROWN_FLOUR_PROJECTILE, x, y, z, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FLOUR;
    }


    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        World world = this.getWorld();
        if (!world.isClient()) {
            world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
        }
        this.getWorld().playSound(null, this.getBlockPos(), ModSounds.FLOUR_LAND, SoundCategory.BLOCKS, 1.0f, 0.9f + world.random.nextFloat()/4);

        if (world.isClient()) {
            return;
        }
        if (!this.getWorld().isClient && !this.isRemoved()) {
            this.discard();
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            for (int x = 0; x < 16; ++x) {
                this.getWorld().addParticle(ModParticles.FLOUR_CLOUD_PARTICLE, this.getX()+this.getWorld().random.nextFloat(), this.getY()+this.getWorld().random.nextFloat(), this.getZ()+this.getWorld().random.nextFloat(), this.getWorld().random.nextGaussian()/16 + this.getVelocity().getX(), this.getWorld().random.nextFloat()/8, this.getWorld().random.nextGaussian()/16 + this.getVelocity().getZ());
            }
            for (int x = 0; x < 16; ++x) {
                this.getWorld().addImportantParticle(ModParticles.FLOUR_CLOUD_PARTICLE, this.getX()+this.getWorld().random.nextFloat(), this.getY()+this.getWorld().random.nextFloat(), this.getZ()+this.getWorld().random.nextFloat(), this.getWorld().random.nextGaussian()/16 + this.getVelocity().getX(), this.getWorld().random.nextFloat()/8, this.getWorld().random.nextGaussian()/16 + this.getVelocity().getZ());
            }
        }
    }
}
