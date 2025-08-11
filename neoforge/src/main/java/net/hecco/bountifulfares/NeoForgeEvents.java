package net.hecco.bountifulfares;

import net.hecco.bountifulfares.definition.data.grass_seeds.GrassSeedsInteractionResourceLoader;
import net.hecco.bountifulfares.definition.data.trellis.TrellisCropResourceLoader;
import net.hecco.bountifulfares.definition.data.trellis.TrellisPlantResourceLoader;
import net.hecco.bountifulfares.registry.util.BFTooltipEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = BountifulFares.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class NeoForgeEvents {
    @SubscribeEvent
    public static void reloadResourcesSetup(AddReloadListenerEvent event) {
        event.addListener(new TrellisPlantResourceLoader());
        event.addListener(new TrellisCropResourceLoader());
        event.addListener(new GrassSeedsInteractionResourceLoader());
    }

    @SubscribeEvent
    public static void onRegisterTooltips(ItemTooltipEvent event) {
        BFTooltipEvents.addTooltipsToVanillaItems(event.getItemStack(), event.getToolTip());
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        BlockHitResult hitResult = event.getHitVec();
        Level world = event.getLevel();
        if (player.canEat(false) && BountifulFares.CONFIG.isCakeEatSounds() && !player.isSpectator()) {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            Block target = state.getBlock();
            ResourceLocation identifier = BuiltInRegistries.BLOCK.getKey(target);
            if (
                    target instanceof CakeBlock &&
                            (identifier.getPath().contains("_cake") || identifier.equals(BuiltInRegistries.BLOCK.getKey(Blocks.CAKE))) &&
                            target.defaultBlockState().hasProperty(BlockStateProperties.BITES)
            ) {
                world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 0.5f, 1.0f);
                if (state.getValue(BlockStateProperties.BITES) == 6) {
                    world.playSound(null, pos, SoundEvents.PLAYER_BURP, SoundSource.BLOCKS, 0.5f, 1.0f);
                }
            }
        } else {
            event.setCancellationResult(InteractionResult.PASS);
        }
    }
}
