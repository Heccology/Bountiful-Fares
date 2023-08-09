package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class WildCropBlock extends PlantBlock {
    private Item cropItem;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(cropItem);
    }

    public WildCropBlock(Item item, Settings settings) {
        super(settings);
        this.cropItem = item;
    }
}
