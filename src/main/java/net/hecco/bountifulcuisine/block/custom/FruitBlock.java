package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class FruitBlock extends FallingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final int DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(15);
    public FruitBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Direction direction = state.get(FACING);
        if (player.canConsume(false)) {
            world.setBlockState(pos, getEatenBlock().getDefaultState().with(EatenFruitBlock.FACING, direction), Block.NOTIFY_LISTENERS);
            player.getHungerManager().add(4, 0.1f);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient) {
            world.breakBlock(hit.getBlockPos(), false);
            world.spawnEntity(new ItemEntity(world, hit.getBlockPos().getX() + 0.5, hit.getBlockPos().getY() + 0.5, hit.getBlockPos().getZ() + 0.5, new ItemStack(getFruitItem(), 9)));
            world.playSound(null, hit.getBlockPos(), SoundEvents.BLOCK_BAMBOO_WOOD_FALL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    public Item getFruitItem() {
        return null;
    }

    public Block getEatenBlock() {
        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return 15;
    }

    public static int getComparatorOutput(int slices) {
        return 15;
    }
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
