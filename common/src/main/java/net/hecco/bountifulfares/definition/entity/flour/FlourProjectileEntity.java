package net.hecco.bountifulfares.definition.entity.flour;

import net.hecco.bountifulfares.registry.content.BFEntities;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class FlourProjectileEntity extends ThrowableItemProjectile implements ItemSupplier {
    public FlourProjectileEntity(EntityType<? extends FlourProjectileEntity> entityType, Level world) {
        super(entityType, world);
    }

    public FlourProjectileEntity(LivingEntity livingEntity, Level world) {
        super(BFEntities.THROWN_FLOUR_PROJECTILE.get(), livingEntity, world);
    }

    public FlourProjectileEntity(Level world, double x, double y, double z) {
        super(BFEntities.THROWN_FLOUR_PROJECTILE.get(), x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return BFItems.FLOUR.get();
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        Level world = this.level();
        if (!world.isClientSide()) {
            world.broadcastEntityEvent(this, EntityEvent.DEATH);
        }
        this.level().playSound(null, this.blockPosition(), BFSounds.FLOUR_LAND.get(), SoundSource.BLOCKS, 1.0f, 0.9f + world.random.nextFloat()/4);

        if (world.isClientSide()) {
            return;
        }
        if (!this.level().isClientSide && !this.isRemoved()) {
            this.discard();
        }
    }

    @Override
    public void handleEntityEvent(byte status) {
        if (status == EntityEvent.DEATH) {
            for (int x = 0; x < 16; ++x) {
                this.level().addParticle(BFParticles.FLOUR_CLOUD.get(), this.getX()+this.level().random.nextFloat(), this.getY()+this.level().random.nextFloat(), this.getZ()+this.level().random.nextFloat(), this.level().random.nextGaussian()/16 + this.getDeltaMovement().x(), this.level().random.nextFloat()/8, this.level().random.nextGaussian()/16 + this.getDeltaMovement().z());
            }
            for (int x = 0; x < 16; ++x) {
                this.level().addAlwaysVisibleParticle(BFParticles.FLOUR_CLOUD.get(), this.getX()+this.level().random.nextFloat(), this.getY()+this.level().random.nextFloat(), this.getZ()+this.level().random.nextFloat(), this.level().random.nextGaussian()/16 + this.getDeltaMovement().x(), this.level().random.nextFloat()/8, this.level().random.nextGaussian()/16 + this.getDeltaMovement().z());
            }
        }
    }
}
