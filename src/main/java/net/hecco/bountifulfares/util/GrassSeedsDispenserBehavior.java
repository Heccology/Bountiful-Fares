package net.hecco.bountifulfares.util;

import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public abstract class GrassSeedsDispenserBehavior extends ItemDispenserBehavior {
    public GrassSeedsDispenserBehavior() {
    }

    public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        World world = pointer.world();
        Position position = DispenserBlock.getOutputLocation(pointer);
        Direction direction = pointer.state().get(DispenserBlock.FACING);
        BlockPos pos = new BlockPos((int)position.getX(), (int)position.getY(), (int)position.getZ()).offset(direction);
        if (world.getBlockState(pos).isIn(BFBlockTags.GRASS_SEEDS_PLANTABLE_ON)) {
            world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
            BoneMealItem.createParticles(world, pos, 0);
        }
        stack.decrement(1);
        return stack;
    }
    protected void playSound(BlockPointer pointer) {
        pointer.world().syncWorldEvent(1002, pointer.pos(), 0);
    }
}
