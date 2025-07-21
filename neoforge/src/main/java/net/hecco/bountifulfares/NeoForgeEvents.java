package net.hecco.bountifulfares;

import net.hecco.bountifulfares.trellis.TrellisPlantResourceLoader;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

@EventBusSubscriber(modid = BountifulFares.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class NeoForgeEvents {
    @SubscribeEvent
    public static void reloadResourcesSetup(AddReloadListenerEvent event) {
        BountifulFares.LOGGER.info("called");
        event.addListener(new TrellisPlantResourceLoader());
    }
}
