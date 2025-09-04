package net.hecco.bountifulfares.registry.integration;

import static net.hecco.bountifulfares.BountifulFares.COMPAT_MANAGER;

public class BFCompat {
    public static void register() {
        COMPAT_MANAGER.addIntegration(new NaturesSpiritIntegration());

        COMPAT_MANAGER.registerCompatContent();
    }
}
