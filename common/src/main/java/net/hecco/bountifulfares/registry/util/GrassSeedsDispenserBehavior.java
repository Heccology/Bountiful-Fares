package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;

public abstract class GrassSeedsDispenserBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior itemDispenser;

    public GrassSeedsDispenserBehavior() {
        this.itemDispenser = new DefaultDispenseItemBehavior();
    }

    public ItemStack execute(BlockSource pointer, ItemStack stack) {
        Level world = pointer.level();
        Direction direction = pointer.state().getValue(DispenserBlock.FACING);
        BlockPos pos = pointer.pos().relative(direction);
        if (world.getBlockState(pos).is(BFBlockTags.GRASS_SEEDS_PLANTABLE_ON)) {
            world.setBlockAndUpdate(pos, Blocks.GRASS_BLOCK.defaultBlockState());
            ParticleUtils.spawnParticleInBlock(world, pos, 10, ParticleTypes.HAPPY_VILLAGER);
            stack.shrink(1);
            world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            return stack;
        }
        return itemDispenser.dispense(pointer, stack);
    }
    protected void playSound(BlockSource pointer) {
        pointer.level().levelEvent(1002, pointer.pos(), 0);
    }
}
