package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public abstract class FlourDispenserBehavior extends DefaultDispenseItemBehavior {
    public FlourDispenserBehavior() {
    }

    public ItemStack execute(BlockSource pointer, ItemStack stack) {
        Level world = pointer.level();
        Position position = DispenserBlock.getDispensePosition(pointer);
        Direction direction = pointer.state().getValue(DispenserBlock.FACING);
        Projectile projectileEntity = this.createProjectile(world, position, stack);
        projectileEntity.shoot(direction.getStepX(), ((float)direction.getStepY() + 0.1F), direction.getStepZ(), this.getForce(), this.getVariation());
        world.addFreshEntity(projectileEntity);
        stack.shrink(1);
        world.playSound(null, position.x(), position.y(), position.z(), BFSounds.FLOUR_THROW, SoundSource.BLOCKS, 0.6f, 0.9f + world.random.nextFloat() / 4);
        return stack;
    }

    protected void playSound(BlockSource pointer) {
        pointer.level().levelEvent(1002, pointer.pos(), 0);
    }

    protected abstract Projectile createProjectile(Level world, Position position, ItemStack stack);

    protected float getVariation() {
        return 10.0F;
    }

    protected float getForce() {
        return 0.5F;
    }
}
