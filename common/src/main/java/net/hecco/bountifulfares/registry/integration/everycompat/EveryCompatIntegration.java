package net.hecco.bountifulfares.registry.integration.everycompat;

import net.hecco.bountifulfares.BountifulFares;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;

public class EveryCompatIntegration {

    /*
     * This is a dirty "hack" because when every compat is not installed
     * it would try to import the `EveryCompatAPI` class on the mod init making it crash.
     */
    public static void register() {
        EveryCompatAPI.registerModule(new BFEveryCompatModule(BountifulFares.MOD_ID));
    }
}