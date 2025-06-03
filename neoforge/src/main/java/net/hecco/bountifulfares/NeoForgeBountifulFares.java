package net.hecco.bountifulfares;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(BountifulFares.MOD_ID)
public class NeoForgeBountifulFares {

    public NeoForgeBountifulFares(IEventBus eventBus) {
        BountifulFares.init();
    }
}