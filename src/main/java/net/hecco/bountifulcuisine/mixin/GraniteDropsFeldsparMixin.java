package net.hecco.bountifulcuisine.mixin;

import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(AbstractBlock.class)
public class GraniteDropsFeldsparMixin {
    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    public void feldsparCollection(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (!world.isClient() && state.isOf(Blocks.GRANITE) && player.getStackInHand(hand).isIn(ItemTags.PICKAXES)) {
            ItemStack feldsparStack = new ItemStack(ModItems.FELDSPAR, new Random().nextInt(3) + 1);
            player.getStackInHand(hand).damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
            Block.dropStack(world, pos, feldsparStack);
            world.breakBlock(pos, false, player);
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }
}