package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TeaShrubBlock extends PlantBlock implements Fertilizable {

    public static final IntProperty AGE = Properties.AGE_4;
    public static BooleanProperty BERRIES = BooleanProperty.of("berries");

    private static final VoxelShape AGE0_SHAPE = Block.createCuboidShape(4, 0, 4, 12, 6, 12);
    private static final VoxelShape AGE1_SHAPE = Block.createCuboidShape(3, 0, 3, 13, 9, 13);
    private static final VoxelShape AGE4_SHAPE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, 0, 7, 9, 9, 9), Block.createCuboidShape(0, 9, 0, 16, 16, 16), BooleanBiFunction.OR);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(AGE)) {
            case 0:
                return AGE0_SHAPE;
            case 1:
                return AGE1_SHAPE;
            default:
                return AGE4_SHAPE;
        }
    }

    public TeaShrubBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(this.AGE, 0).with(BERRIES, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(this.AGE, this.BERRIES);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(AGE) == 1) {
            world.setBlockState(pos, state.with(AGE, 4), Block.NOTIFY_LISTENERS);
        } else if (!isFullyGrown(state)) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS)) {
            itemStack.damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
            dropStack(world, pos, new ItemStack(ModItems.TEA_LEAVES, 2 + world.random.nextInt(3)));
            world.setBlockState(pos, state.with(AGE, 2), Block.NOTIFY_LISTENERS);
            return ActionResult.SUCCESS;
        } else if (itemStack.isOf(Items.BONE_MEAL) && state.get(AGE) == 4 && !state.get(BERRIES)) {
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, state.with(BERRIES, true), Block.NOTIFY_LISTENERS);
            return ActionResult.SUCCESS;
        } else if (state.get(BERRIES)) {
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, state.with(BERRIES, false), Block.NOTIFY_LISTENERS);
            dropStack(world, pos, new ItemStack(ModItems.TEA_BERRIES, 1 + world.random.nextInt(1)));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.TEA_BERRIES);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (state.get(AGE) == 1) {
            world.setBlockState(pos, state.with(AGE, 4), Block.NOTIFY_LISTENERS);
        } else if (!isFullyGrown(state)) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
    }

    protected static boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 4;
    }
}
