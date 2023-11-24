package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
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

public class EatenFruitBlock extends FallingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty SLICES = IntProperty.of("slices", 0, 2);

    public static final int DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(10);

    private static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 0, 16, 16, 16), Block.createCuboidShape(0, 0, 8, 8, 16, 16), BooleanBiFunction.OR),
            Block.createCuboidShape(0, 0, 8, 16, 16, 16),
            Block.createCuboidShape(0, 0, 8, 8, 16, 16)
    };
    private static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 8, 16, 16, 16), Block.createCuboidShape(0, 0, 0, 8, 16, 8), BooleanBiFunction.OR),
            Block.createCuboidShape(0, 0, 0, 8, 16, 16),
            Block.createCuboidShape(0, 0, 0, 8, 16, 8)
    };
    private static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 8, 16, 16), Block.createCuboidShape(8, 0, 0, 16, 16, 8), BooleanBiFunction.OR),
            Block.createCuboidShape(0, 0, 0, 16, 16, 8),
            Block.createCuboidShape(8, 0, 0, 16, 16, 8)
    };
    private static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 16, 16, 8), Block.createCuboidShape(8, 0, 8, 16, 16, 16), BooleanBiFunction.OR),
            Block.createCuboidShape(8, 0, 0, 16, 16, 16),
            Block.createCuboidShape(8, 0, 8, 16, 16, 16)
    };
    public EatenFruitBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(SLICES, 0).with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SLICES, FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(SLICES) != 2 && player.canConsume(false)) {
            world.setBlockState(pos, state.cycle(SLICES), Block.NOTIFY_LISTENERS);
            player.getHungerManager().add(4, 0.1f);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        } else if (state.get(SLICES) == 2 && player.canConsume(false)) {
            world.removeBlock(pos, false);
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
            world.playSound(null, hit.getBlockPos(), SoundEvents.BLOCK_BAMBOO_WOOD_FALL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return getComparatorOutput(state.get(SLICES));
    }
    public static int getComparatorOutput(int slices) {
        return (7 - ((slices + 1) * 2)) * 2;
    }
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }
}
