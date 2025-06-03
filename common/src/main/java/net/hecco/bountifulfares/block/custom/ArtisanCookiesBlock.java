package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ArtisanCookiesBlock extends Block {
    public static final int MAX_COUNT = 3;
    public static final IntegerProperty COUNT = IntegerProperty.create("count", 0, 3);
    public static final int DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(0);

    public static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.box(4, 0, 4, 12, 2, 12),
            Block.box(4, 0, 4, 12, 4, 12),
            Block.box(4, 0, 4, 12, 6, 12),
            Block.box(4, 0, 4, 12, 8, 12)
    };

    public ArtisanCookiesBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(COUNT, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(COUNT)];
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (stack.is(BFItems.ARTISAN_COOKIE) && state.getValue(COUNT) < MAX_COUNT) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else if (world.isClientSide) {
            if (tryEat(world, pos, state, player, hand).consumesAction()) {
                return ItemInteractionResult.SUCCESS;
            }
        }

        return tryEat(world, pos, state, player, hand);
    }

    //public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
    //    ItemStack itemStack = player.getStackInHand(player.getActiveHand());
    //    if (itemStack.isOf(BFItems.ARTISAN_COOKIE) && state.get(COUNT) < MAX_COUNT) {
    //        return ActionResult.PASS;
    //    } else if (world.isClient) {
    //        if (tryEat(world, pos, state, player, player.getActiveHand()).isAccepted()) {
    //            return ActionResult.SUCCESS;
    //        }
    //    }
    //    return tryEat(world, pos, state, player, player.getActiveHand());
    //}

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (blockState.is(this)) {
            if (blockState.getValue(COUNT) < 3) {
                return super.withPropertiesOf(blockState).setValue(COUNT, blockState.getValue(COUNT) + 1);
            } else {
                return null;
            }
        }
        return super.getStateForPlacement(ctx);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().getItem() == this.asItem() || super.canBeReplaced(state, context);
    }

    protected static ItemInteractionResult tryEat(LevelAccessor world, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        if (!player.canEat(false)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        } else {
            player.getFoodData().eat(3, 0.3F);
            int count = state.getValue(COUNT);
            world.gameEvent(player, GameEvent.EAT, pos);

            if (count > 0) {
                world.setBlock(pos, state.setValue(COUNT, count - 1), 3);
                world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 0.5f, 1.0f);
            } else {
                world.removeBlock(pos, false);
                world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
                world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 0.5f, 1.0f);
            }
            return ItemInteractionResult.SUCCESS;
        }
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isSolid();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COUNT);
    }

    public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
        return getComparatorOutput(state.getValue(COUNT));
    }

    public static int getComparatorOutput(int COUNT) {
        return (7 - (COUNT * 2)) * 2;
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public boolean canPathfindThrough(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        return false;
    }
}
