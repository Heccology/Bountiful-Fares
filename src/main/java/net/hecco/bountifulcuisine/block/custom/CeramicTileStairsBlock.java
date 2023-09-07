package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.DyeableCeramicBlockInterface;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.custom.entity.CeramicTilesBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CeramicTileStairsBlock extends StairsBlock implements DyeableCeramicBlockInterface, BlockEntityProvider {
    public static final BooleanProperty CHECKERED = BooleanProperty.of("checkered");
    public static final BooleanProperty WAXED = BooleanProperty.of("waxed");
    public CeramicTileStairsBlock(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(HALF, BlockHalf.BOTTOM).with(SHAPE, StairShape.STRAIGHT).with(WATERLOGGED, false).with(CHECKERED, false).with(WAXED, false));

    }
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        if (CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getPickStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(ModBlocks.CERAMIC_TILES);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, SHAPE, WATERLOGGED, CHECKERED, WAXED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        Boolean checkered = state.get(CHECKERED);
        Boolean waxed = state.get(WAXED);
        if ((itemStack.isOf(Items.SPONGE) || itemStack.isOf(Items.WET_SPONGE)) && !checkered && !waxed && CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            world.setBlockState(pos, ModBlocks.CERAMIC_TILE_STAIRS.getStateWithProperties(state).with(CHECKERED, true), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_UP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else if (itemStack.isOf(Items.HONEYCOMB) && !waxed && CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            world.setBlockState(pos, ModBlocks.CERAMIC_TILE_STAIRS.getStateWithProperties(state).with(WAXED, true), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else if ((itemStack.isOf(Items.SPONGE) || itemStack.isOf(Items.WET_SPONGE)) && waxed) {
            world.setBlockState(pos, ModBlocks.CERAMIC_TILE_STAIRS.getStateWithProperties(state).with(WAXED, false), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_UP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else if ((itemStack.isOf(Items.SPONGE) || itemStack.isOf(Items.WET_SPONGE)) && checkered && !waxed && CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            world.removeBlock(pos, false);
            world.setBlockState(pos, ModBlocks.CERAMIC_TILE_STAIRS.getDefaultState().with(FACING, state.get(FACING)).with(HALF, state.get(HALF)).with(SHAPE, state.get(SHAPE)).with(WATERLOGGED, state.get(WATERLOGGED)), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_UP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }
}
