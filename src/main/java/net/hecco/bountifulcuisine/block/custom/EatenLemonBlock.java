package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.item.ModItems;
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

import java.util.stream.Stream;

public class EatenLemonBlock extends FallingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty SLICES = IntProperty.of("slices", 0, 2);

    private static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.createCuboidShape(8, 0, 0, 16, 16, 16),
                    Block.createCuboidShape(0, 0, 8, 8, 16, 16),
                    Block.createCuboidShape(8, -3, 4, 12, 19, 12),
                    Block.createCuboidShape(4, -3, 8, 8, 19, 12)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 8, 16, 16, 16), Block.createCuboidShape(4, -3, 8, 12, 19, 12), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 8, 8, 16, 16), Block.createCuboidShape(4, -3, 8, 8, 19, 12), BooleanBiFunction.OR)
    };
    private static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.createCuboidShape(0, 0, 8, 16, 16, 16),
                    Block.createCuboidShape(0, 0, 0, 8, 16, 8),
                    Block.createCuboidShape(4, -3, 8, 12, 19, 12),
                    Block.createCuboidShape(4, -3, 4, 8, 19, 8)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 8, 16, 16), Block.createCuboidShape(4, -3, 4, 8, 19, 12), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 8, 16, 8), Block.createCuboidShape(4, -3, 4, 8, 19, 8), BooleanBiFunction.OR)
    };
    private static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.createCuboidShape(0, 0, 0, 8, 16, 16),
                    Block.createCuboidShape(8, 0, 0, 16, 16, 8),
                    Block.createCuboidShape(4, -3, 4, 8, 19, 12),
                    Block.createCuboidShape(8, -3, 4, 12, 19, 8)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 16, 16, 8), Block.createCuboidShape(4, -3, 4, 12, 19, 8), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 0, 16, 16, 8), Block.createCuboidShape(8, -3, 4, 12, 19, 8), BooleanBiFunction.OR)
    };
    private static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Stream.of(
                    Block.createCuboidShape(0, 0, 0, 16, 16, 8),
                    Block.createCuboidShape(8, 0, 8, 16, 16, 16),
                    Block.createCuboidShape(4, -3, 4, 12, 19, 8),
                    Block.createCuboidShape(8, -3, 8, 12, 19, 12)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 0, 16, 16, 16), Block.createCuboidShape(8, -3, 4, 12, 19, 12), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 8, 16, 16, 16), Block.createCuboidShape(8, -3, 8, 12, 19, 12), BooleanBiFunction.OR)
    };
    public EatenLemonBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(SLICES, 0).with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(FACING) == Direction.NORTH) {
            return NORTH_SHAPES[state.get(SLICES)];
        } else if (state.get(FACING) == Direction.EAST) {
            return EAST_SHAPES[state.get(SLICES)];
        } else if (state.get(FACING) == Direction.SOUTH) {
            return SOUTH_SHAPES[state.get(SLICES)];
        } else if (state.get(FACING) == Direction.WEST) {
            return WEST_SHAPES[state.get(SLICES)];
        }
        return NORTH_SHAPES[state.get(SLICES)];
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

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.LEMON);
    }
}
