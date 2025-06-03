package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TeaShrubBlock extends BushBlock implements BonemealableBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    public static BooleanProperty BERRIES = BooleanProperty.create("berries");

    private static final VoxelShape AGE0_SHAPE = Block.box(4, 0, 4, 12, 6, 12);
    private static final VoxelShape AGE1_SHAPE = Block.box(3, 0, 3, 13, 9, 13);
    private static final VoxelShape AGE2_SHAPE = Shapes.join(Block.box(7, 0, 7, 9, 9, 9), Block.box(0, 9, 0, 16, 16, 16), BooleanOp.OR);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        switch (state.getValue(AGE)) {
            case 0:
                return AGE0_SHAPE;
            case 1:
                return AGE1_SHAPE;
            default:
                return AGE2_SHAPE;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(AGE) >= 2 && context.isAbove(AGE2_SHAPE, pos, false)) {
            return AGE2_SHAPE;
        } else {
            return Shapes.empty();
        }
    }

    public TeaShrubBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(BERRIES, false));
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, BERRIES);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!isFullyGrown(state) && random.nextFloat() < 0.5f) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }


    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        ItemStack itemStack = player.getItemInHand(player.getUsedItemHand());
        if (stack.is(Items.SHEARS) && canHarvestLeaves(state)) {
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (state.getValue(AGE) == 4) {
                popResource(world, pos, new ItemStack(BFItems.TEA_LEAVES, 3 + world.random.nextInt(2)));
            } else {
                popResource(world, pos, new ItemStack(BFItems.TEA_LEAVES, 1 + world.random.nextInt(2)));
            }
            world.setBlock(pos, state.setValue(AGE, 2), Block.UPDATE_CLIENTS);
            return ItemInteractionResult.SUCCESS;
        } else if (stack.is(Items.BONE_MEAL) && state.getValue(AGE) == 4 && !state.getValue(BERRIES)) {
            if (!player.isCreative()) {
                stack.shrink(1);
            }
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlock(pos, state.setValue(BERRIES, true), Block.UPDATE_CLIENTS);
            return ItemInteractionResult.SUCCESS;
        } else if (state.getValue(BERRIES)) {
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);
            world.setBlock(pos, state.setValue(BERRIES, false), Block.UPDATE_CLIENTS);
            popResource(world, pos, new ItemStack(BFItems.TEA_BERRIES, 1 + world.random.nextInt(1)));
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(BFItems.TEA_BERRIES);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        if (!isFullyGrown(state)) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }

    protected static boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) == 4;
    }
    protected static boolean canHarvestLeaves(BlockState state) {
        return state.getValue(AGE) >= 3 && !state.getValue(BERRIES);
    }
}
