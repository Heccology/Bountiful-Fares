package net.hecco.bountifulfares;

import net.hecco.bountifulfares.definition.data.grass_seeds.GrassSeedsInteractionResourceLoader;
import net.hecco.bountifulfares.definition.data.trellis.TrellisCropResourceLoader;
import net.hecco.bountifulfares.definition.data.trellis.TrellisPlantResourceLoader;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

@EventBusSubscriber(modid = BountifulFares.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class NeoForgeEvents {
    @SubscribeEvent
    public static void reloadResourcesSetup(AddReloadListenerEvent event) {
        event.addListener(new TrellisPlantResourceLoader());
        event.addListener(new TrellisCropResourceLoader());
        event.addListener(new GrassSeedsInteractionResourceLoader());
    }
}
