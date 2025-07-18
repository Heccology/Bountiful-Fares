package net.hecco.bountifulfares;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(BountifulFares.MOD_ID)
public class NeoForgeBountifulFares {


    public NeoForgeBountifulFares(IEventBus eventBus) {
        BountifulFares.init();
        eventBus.addListener(this::clientSetup);
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {
        BountifulFaresClient.onInitializeClient();
    }
}