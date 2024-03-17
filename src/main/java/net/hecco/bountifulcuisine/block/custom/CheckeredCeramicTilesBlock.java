package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.interfaces.DyeableCeramicBlockInterface;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.entity.CeramicTilesBlockEntity;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.item.custom.ArtisanBrushItem;
import net.hecco.bountifulcuisine.util.ModItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CheckeredCeramicTilesBlock extends Block implements DyeableCeramicBlockInterface {
    public CheckeredCeramicTilesBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        if (CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getPickStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(ModBlocks.CHECKERED_CERAMIC_TILES);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        int oldColor = CeramicTilesBlockEntity.getColor(world, pos);
        if ((itemStack.isIn(ModItemTags.DYES) //|| itemStack.isIn(ModItemTags.ELS_AND_LS_DYES)
             ) && CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            world.setBlockState(pos, ModBlocks.CERAMIC_TILES.getDefaultState(), 2);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat());
            if (world.getBlockEntity(pos) instanceof CeramicTilesBlockEntity ceramicTilesBlockEntity) {
                ceramicTilesBlockEntity.color = oldColor;
                ceramicTilesBlockEntity.markDirty();
                return ActionResult.SUCCESS;
            }
        }
        if (itemStack.isOf(ModItems.ARTISAN_BRUSH) && itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY) != null) {
            int brushColor = itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY);
            world.removeBlock(pos, false);
            world.setBlockState(pos, this.getStateWithProperties(state));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof CeramicTilesBlockEntity ceramicTilesBlockEntity && ceramicTilesBlockEntity.color != brushColor) {
                ceramicTilesBlockEntity.color = brushColor;
                ceramicTilesBlockEntity.markDirty();
                return ActionResult.SUCCESS;

            }
        }
        return ActionResult.PASS;
    }
}
