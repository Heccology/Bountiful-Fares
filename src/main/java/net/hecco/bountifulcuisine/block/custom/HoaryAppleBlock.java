package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class HoaryAppleBlock extends FruitBlock{
    public HoaryAppleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.combineAndSimplify(Block.createCuboidShape(4, 16, 4, 12, 20, 12), Block.createCuboidShape(0, 0, 0, 16, 16, 16), BooleanBiFunction.OR);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Direction direction = state.get(FACING);
        if (player.canConsume(false)) {
            world.setBlockState(pos, ModBlocks.EATEN_HOARY_APPLE_BLOCK.getDefaultState().with(EatenFruitBlock.FACING, direction), Block.NOTIFY_LISTENERS);
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
            world.spawnEntity(new ItemEntity(world, hit.getBlockPos().getX() + 0.5, hit.getBlockPos().getY() + 0.5, hit.getBlockPos().getZ() + 0.5, new ItemStack(ModItems.HOARY_APPLE, 9)));
            world.playSound(null, hit.getBlockPos(), SoundEvents.BLOCK_BAMBOO_WOOD_FALL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }
}
