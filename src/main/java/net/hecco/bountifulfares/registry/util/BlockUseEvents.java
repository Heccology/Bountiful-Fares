package net.hecco.bountifulfares.registry.util;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class BlockUseEvents
{
    public static void register()
    {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (player.canConsume(false) && BountifulFares.CONFIG.isCakeEatSounds() && !player.isSpectator())
            {
                BlockPos pos = hitResult.getBlockPos();
                BlockState state = world.getBlockState(pos);
                Block target = state.getBlock();
                Identifier identifier = Registries.BLOCK.getId(target);
                if (
                        target instanceof CakeBlock &&
                        (identifier.getPath().contains("_cake") || identifier.equals(Registries.BLOCK.getId(Blocks.CAKE))) &&
                        target.getDefaultState().contains(Properties.BITES)
                )
                {
                    world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 0.5f, 1.0f);
                    if (state.get(Properties.BITES) == 6) {
                        world.playSound(null, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.BLOCKS, 0.5f, 1.0f);
                    }
                }
            }
            return ActionResult.PASS;
        });
    }
}
