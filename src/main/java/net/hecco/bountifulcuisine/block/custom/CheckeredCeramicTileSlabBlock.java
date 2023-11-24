package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.DyeableCeramicBlockInterface;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.custom.entity.CeramicTilesBlockEntity;
import net.hecco.bountifulcuisine.util.ModItemTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CheckeredCeramicTileSlabBlock extends SlabBlock implements DyeableCeramicBlockInterface {
    public CheckeredCeramicTileSlabBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(TYPE, SlabType.BOTTOM).with(WATERLOGGED, false));
    }
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        if (CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getPickStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(ModBlocks.CERAMIC_TILE_SLAB);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        int oldColor = CeramicTilesBlockEntity.getColor(world, pos);
        if ((itemStack.isIn(ModItemTags.DYES) || itemStack.isIn(ModItemTags.ELS_AND_LS_DYES)) && CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            world.setBlockState(pos, ModBlocks.CERAMIC_TILE_SLAB.getStateWithProperties(state), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_GLOW_INK_SAC_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat());
            if (world.getBlockEntity(pos) instanceof CeramicTilesBlockEntity ceramicTilesBlockEntity) {
                ceramicTilesBlockEntity.color = oldColor;
                ceramicTilesBlockEntity.markDirty();
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }


    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }
}
