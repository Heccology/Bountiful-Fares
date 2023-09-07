package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
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
    public FruitBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Direction direction = state.get(FACING);
        if (player.canConsume(false)) {
            world.setBlockState(pos, ModBlocks.EATEN_APPLE_BLOCK.getDefaultState().with(EatenFruitBlock.FACING, direction), Block.NOTIFY_LISTENERS);
            player.getHungerManager().add(4, 0.1f);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient) {
            world.setBlockState(hit.getBlockPos(), Blocks.AIR.getDefaultState());
            world.spawnEntity(new ItemEntity(world, hit.getBlockPos().getX() + 0.5, hit.getBlockPos().getY() + 0.5, hit.getBlockPos().getZ() + 0.5, new ItemStack(Items.APPLE, 9)));
            world.playSound(null, hit.getBlockPos(), SoundEvents.BLOCK_BAMBOO_WOOD_FALL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }
}
