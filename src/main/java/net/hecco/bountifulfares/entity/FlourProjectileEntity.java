package net.hecco.bountifulfares.entity;

import net.hecco.bountifulfares.registry.content.BFEntities;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class FlourProjectileEntity extends ThrownItemEntity {
    public FlourProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public FlourProjectileEntity(LivingEntity livingEntity, World world) {
        super(BFEntities.THROWN_FLOUR_PROJECTILE, livingEntity, world);
    }

    public FlourProjectileEntity(World world, double x, double y, double z) {
        super(BFEntities.THROWN_FLOUR_PROJECTILE, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return BFItems.FLOUR;
    }


    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        World world = this.getWorld();
        if (!world.isClient()) {
            world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
        }
        this.getWorld().playSound(null, this.getBlockPos(), BFSounds.FLOUR_LAND, SoundCategory.BLOCKS, 1.0f, 0.9f + world.random.nextFloat()/4);

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
                this.getWorld().addParticle(BFParticles.FLOUR_CLOUD, this.getX()+this.getWorld().random.nextFloat(), this.getY()+this.getWorld().random.nextFloat(), this.getZ()+this.getWorld().random.nextFloat(), this.getWorld().random.nextGaussian()/16 + this.getVelocity().getX(), this.getWorld().random.nextFloat()/8, this.getWorld().random.nextGaussian()/16 + this.getVelocity().getZ());
            }
            for (int x = 0; x < 16; ++x) {
                this.getWorld().addImportantParticle(BFParticles.FLOUR_CLOUD, this.getX()+this.getWorld().random.nextFloat(), this.getY()+this.getWorld().random.nextFloat(), this.getZ()+this.getWorld().random.nextFloat(), this.getWorld().random.nextGaussian()/16 + this.getVelocity().getX(), this.getWorld().random.nextFloat()/8, this.getWorld().random.nextGaussian()/16 + this.getVelocity().getZ());
            }
        }
    }
}
