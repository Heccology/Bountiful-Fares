package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class ArtisanCookiesBlock extends Block {
    public static final int MAX_COUNT = 3;
    public static final IntProperty COUNT = IntProperty.of("count", 0, 3);
    public static final int DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(0);

    public static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.createCuboidShape(4, 0, 4, 12, 2, 12),
            Block.createCuboidShape(4, 0, 4, 12, 4, 12),
            Block.createCuboidShape(4, 0, 4, 12, 6, 12),
            Block.createCuboidShape(4, 0, 4, 12, 8, 12)
    };

    public ArtisanCookiesBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(COUNT, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES[state.get(COUNT)];
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        if (itemStack.isOf(BFItems.ARTISAN_COOKIE) && state.get(COUNT) < MAX_COUNT) {
            return ActionResult.PASS;
        } else if (world.isClient) {
            if (tryEat(world, pos, state, player, player.getActiveHand()).isAccepted()) {
                return ActionResult.SUCCESS;
            }
        }
        return tryEat(world, pos, state, player, player.getActiveHand());
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        if (blockState.isOf(this)) {
            if (blockState.get(COUNT) < 3) {
                return super.getStateWithProperties(blockState).with(COUNT, blockState.get(COUNT) + 1);
            } else {
                return null;
            }
        }
        return super.getPlacementState(ctx);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.shouldCancelInteraction() && context.getStack().getItem() == this.asItem() || super.canReplace(state, context);
    }

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.getHungerManager().add(3, 0.3F);
            int count = state.get(COUNT);
            world.emitGameEvent(player, GameEvent.EAT, pos);
            if (!player.getStackInHand(hand).isOf(BFItems.ARTISAN_COOKIE)) {
                if (count > 0) {
                    world.setBlockState(pos, state.with(COUNT, count - 1), 3);
                    world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 0.5f, 1.0f);
                } else {
                    world.removeBlock(pos, false);
                    world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
                    world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 0.5f, 1.0f);
                }

                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COUNT);
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return getComparatorOutput(state.get(COUNT));
    }

    public static int getComparatorOutput(int COUNT) {
        return (7 - (COUNT * 2)) * 2;
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
