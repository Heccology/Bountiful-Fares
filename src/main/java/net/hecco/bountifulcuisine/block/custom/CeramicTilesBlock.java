package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.DyeableCeramicBlockInterface;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.custom.entity.CeramicTilesBlockEntity;
import net.hecco.bountifulcuisine.block.enums.Flower;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
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

public class CeramicTilesBlock extends Block implements DyeableCeramicBlockInterface {
    public static final BooleanProperty CHECKERED = BooleanProperty.of("checkered");
    public static final BooleanProperty WAXED = BooleanProperty.of("waxed");
    public CeramicTilesBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(CHECKERED, false).with(WAXED, false));
    }
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        ItemStack stack = super.getPickStack(world, pos, state);
        return pickBlock(world,pos,stack);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        Boolean checkered = state.get(CHECKERED);
        Boolean waxed = state.get(WAXED);
        if ((itemStack.isOf(Items.SPONGE) || itemStack.isOf(Items.WET_SPONGE)) && !checkered && !waxed && CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            world.setBlockState(pos, ModBlocks.CERAMIC_TILES.getStateWithProperties(state).with(CHECKERED, true), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_UP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else if (itemStack.isOf(Items.HONEYCOMB) && !waxed && CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            world.setBlockState(pos, ModBlocks.CERAMIC_TILES.getStateWithProperties(state).with(WAXED, true), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else if ((itemStack.isOf(Items.SPONGE) || itemStack.isOf(Items.WET_SPONGE)) && waxed) {
            world.setBlockState(pos, ModBlocks.CERAMIC_TILES.getStateWithProperties(state).with(WAXED, false), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_UP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else if ((itemStack.isOf(Items.SPONGE) || itemStack.isOf(Items.WET_SPONGE)) && checkered && !waxed && CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            world.removeBlock(pos, false);
            world.setBlockState(pos, ModBlocks.CERAMIC_TILES.getDefaultState(), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_UP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHECKERED, WAXED);
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }
}
