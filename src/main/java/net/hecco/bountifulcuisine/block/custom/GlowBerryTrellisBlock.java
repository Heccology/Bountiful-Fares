package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.custom.template.PlantedTrellisBlock;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class GlowBerryTrellisBlock extends PlantedTrellisBlock {
    public GlowBerryTrellisBlock(Item berryItem, Settings settings) {
        super(berryItem, settings);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = state.get(AGE);
        if (player.getStackInHand(hand).isOf(Items.SHEARS) && !state.get(SNIPPED)) {
            world.setBlockState(pos, state.with(SNIPPED, true));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else if(i != 3) {
            return ActionResult.PASS;
        } else if(state.get(AGE) == 3 & !state.get(SNIPPED)) {
            int j = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(Items.GLOW_BERRIES, j));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            BlockState blockState = state.with(AGE, 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
