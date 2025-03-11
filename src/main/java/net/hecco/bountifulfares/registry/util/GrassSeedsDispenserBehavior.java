package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public abstract class GrassSeedsDispenserBehavior extends ItemDispenserBehavior {
    private final ItemDispenserBehavior itemDispenser;

    public GrassSeedsDispenserBehavior() {
        this.itemDispenser = new ItemDispenserBehavior();
    }

    public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        World world = pointer.world();
        Direction direction = pointer.state().get(DispenserBlock.FACING);
        BlockPos pos = pointer.pos().offset(direction);
        if (world.getBlockState(pos).isIn(BFBlockTags.GRASS_SEEDS_PLANTABLE_ON)) {
            world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
            ParticleUtil.spawnParticlesAround(world, pos, 10, ParticleTypes.HAPPY_VILLAGER);
            stack.decrement(1);
            world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            return stack;
        }
        return itemDispenser.dispense(pointer, stack);
    }
    protected void playSound(BlockPointer pointer) {
        pointer.world().syncWorldEvent(1002, pointer.pos(), 0);
    }
}
