package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.enums.Flower;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class FlowerTrellisBlock extends TrellisBlock implements Fertilizable {

    protected static final EnumProperty<Flower> FLOWER = EnumProperty.of("flower", Flower.class);

    Item flowerItem = Items.DIAMOND;
    public FlowerTrellisBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH).with(FLOWER, Flower.ROSE));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, FLOWER);
    }

    public Item getFlowerItem(BlockState state) {
        if (state.get(FLOWER) == (Flower.ROSE)) {
            return Items.ROSE_BUSH;
        } else if (state.get(FLOWER) == (Flower.PEONY)) {
            return Items.PEONY;
        } else if (state.get(FLOWER) == (Flower.LILAC)) {
            return Items.LILAC;
        } else if (state.get(FLOWER) == (Flower.SUNFLOWER)) {
            return Items.SUNFLOWER;
        }
        return Items.ROSE_BUSH;
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Direction facing = state.get(FACING);
        if (player.getStackInHand(hand).isOf(Items.SHEARS)) {
            player.getStackInHand(hand).damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
            world.setBlockState(pos, ModBlocks.TRELLIS.getDefaultState().with(FACING, facing), 2);
            dropStack(world, pos, new ItemStack(getFlowerItem(state)));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModBlocks.TRELLIS);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        TallFlowerBlock.dropStack(world, pos, new ItemStack(getFlowerItem(state)));
    }
}
