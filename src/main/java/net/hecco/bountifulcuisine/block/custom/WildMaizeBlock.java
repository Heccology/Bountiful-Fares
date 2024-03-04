package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.predicate.NbtPredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Map;

public class WildMaizeBlock extends TallPlantBlock {
    public WildMaizeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            return Block.createCuboidShape(2, 0, 2, 14, 16, 14);
        } else {
            return Block.createCuboidShape(2, 0, 2, 14, 12, 14);
        }
    }

//    @Override
//    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
//        if (player.getStackInHand(player.getActiveHand()).getEnchantments().stream().anyMatch(Enchantments.SILK_TOUCH)) {
//            dropStack(world, pos, new ItemStack(ModBlocks.APPLE_BLOCK));
//        }
//        super.onBlockBreakStart(state, world, pos, player);
//    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {

    }
}
