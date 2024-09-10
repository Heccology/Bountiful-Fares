package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.block.interfaces.DyeableCeramicBlockInterface;
import net.hecco.bountifulfares.compat.CompatUtil;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CeramicTilePillarBlock extends PillarBlock implements DyeableCeramicBlockInterface {
    public CeramicTilePillarBlock(AbstractBlock.Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        if (DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getPickStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(this);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        if (itemStack.isOf(BFItems.ARTISAN_BRUSH) && !player.isSneaking() && itemStack.getComponents().contains(DataComponentTypes.DYED_COLOR)) {
            int brushColor = itemStack.getComponents().get(DataComponentTypes.DYED_COLOR).rgb();
            world.removeBlock(pos, false);
            world.setBlockState(pos, this.getStateWithProperties(state));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                dyeableCeramicBlockEntity.color = brushColor;
                dyeableCeramicBlockEntity.markDirty();
                return ActionResult.SUCCESS;

            }
        }
        if (BountifulFares.isModLoaded(BountifulFares.ARTS_AND_CRAFTS_MOD_ID)) {
            Item item = player.getStackInHand(player.getActiveHand()).getItem();
            if (CompatUtil.isItemPaintbrush(item)) {
                int brushColor = CompatUtil.getIntColorFromPaintbrush(item);
                if (brushColor != 1) {
                    world.removeBlock(pos, false);
                    world.setBlockState(pos, this.getStateWithProperties(state));
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
                    if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                        dyeableCeramicBlockEntity.color = brushColor;
                        dyeableCeramicBlockEntity.markDirty();
                        return ActionResult.SUCCESS;

                    }
                }
            }
        }
        return ActionResult.PASS;
    }
}
