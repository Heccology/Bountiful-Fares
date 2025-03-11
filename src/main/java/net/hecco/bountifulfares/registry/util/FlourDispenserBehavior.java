package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public abstract class FlourDispenserBehavior extends ItemDispenserBehavior {
    public FlourDispenserBehavior() {
    }

    public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        World world = pointer.world();
        Position position = DispenserBlock.getOutputLocation(pointer);
        Direction direction = pointer.state().get(DispenserBlock.FACING);
        ProjectileEntity projectileEntity = this.createProjectile(world, position, stack);
        projectileEntity.setVelocity(direction.getOffsetX(), ((float)direction.getOffsetY() + 0.1F), direction.getOffsetZ(), this.getForce(), this.getVariation());
        world.spawnEntity(projectileEntity);
        stack.decrement(1);
        world.playSound(null, position.getX(), position.getY(), position.getZ(), BFSounds.FLOUR_THROW, SoundCategory.BLOCKS, 0.6f, 0.9f + world.random.nextFloat() / 4);
        return stack;
    }

    protected void playSound(BlockPointer pointer) {
        pointer.world().syncWorldEvent(1002, pointer.pos(), 0);
    }

    protected abstract ProjectileEntity createProjectile(World world, Position position, ItemStack stack);

    protected float getVariation() {
        return 10.0F;
    }

    protected float getForce() {
        return 0.5F;
    }
}
