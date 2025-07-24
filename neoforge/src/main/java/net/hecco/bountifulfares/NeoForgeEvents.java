package net.hecco.bountifulfares;

import net.hecco.bountifulfares.trellis.TrellisCropResourceLoader;
import net.hecco.bountifulfares.trellis.TrellisPlantResourceLoader;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import oshi.util.tuples.Pair;

@EventBusSubscriber(modid = BountifulFares.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class NeoForgeEvents {
    @SubscribeEvent
    public static void reloadResourcesSetup(AddReloadListenerEvent event) {
        event.addListener(new TrellisPlantResourceLoader());
        event.addListener(new TrellisCropResourceLoader());
    }
}
