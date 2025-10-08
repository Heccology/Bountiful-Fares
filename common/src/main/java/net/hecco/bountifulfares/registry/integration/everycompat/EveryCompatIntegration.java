package net.hecco.bountifulfares.registry.integration.everycompat;

import net.hecco.bountifulfares.BountifulFares;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;

public class EveryCompatIntegration {
    public static void register() {
        EveryCompatAPI.registerModule(new BFEveryCompatModule(BountifulFares.MOD_ID));
    }
}