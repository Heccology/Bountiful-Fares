package net.hecco.bountifulfares.registry.util;

//import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class BlockUseEvents
{
    public static void register()
    {
//        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
//            if (player.canEat(false) && BountifulFares.CONFIG.isCakeEatSounds() && !player.isSpectator())
//            {
//                BlockPos pos = hitResult.getBlockPos();
//                BlockState state = world.getBlockState(pos);
//                Block target = state.getBlock();
//                ResourceLocation identifier = BuiltInRegistries.BLOCK.getKey(target);
//                if (
//                        target instanceof CakeBlock &&
//                        (identifier.getPath().contains("_cake") || identifier.equals(BuiltInRegistries.BLOCK.getKey(Blocks.CAKE))) &&
//                        target.defaultBlockState().hasProperty(BlockStateProperties.BITES)
//                )
//                {
//                    world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 0.5f, 1.0f);
//                    if (state.getValue(BlockStateProperties.BITES) == 6) {
//                        world.playSound(null, pos, SoundEvents.PLAYER_BURP, SoundSource.BLOCKS, 0.5f, 1.0f);
//                    }
//                }
//            }
//            return InteractionResult.PASS;
//        }); TODO: FIX
    }
}
