package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EatenGoldenAppleBlock extends EatenFruitBlock {
    public EatenGoldenAppleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(SLICES) != 2 && player.canConsume(true)) {
            world.setBlockState(pos, state.cycle(SLICES), Block.NOTIFY_LISTENERS);
            if (player.canConsume(false)) {
                player.getHungerManager().add(4, 0.1f);
            }
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0));
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        } else if (state.get(SLICES) == 2 && player.canConsume(true)) {
            world.removeBlock(pos, false);
            if (player.canConsume(false)) {
                player.getHungerManager().add(4, 0.1f);
            }
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0));
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModBlocks.GOLDEN_APPLE_BLOCK);
    }
}
