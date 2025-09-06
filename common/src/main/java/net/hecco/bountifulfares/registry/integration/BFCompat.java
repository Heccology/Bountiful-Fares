package net.hecco.bountifulfares.registry.integration;

import static net.hecco.bountifulfares.BountifulFares.COMPAT_MANAGER;

public class BFCompat {
    public static void register() {
        COMPAT_MANAGER.addIntegration(new NaturesSpiritIntegration());
        COMPAT_MANAGER.addIntegration(new FrontiersIntegration());
        COMPAT_MANAGER.addIntegration(new FarmersDelightIntegration());
        COMPAT_MANAGER.addIntegration(new AmendmentsIntegration());
        COMPAT_MANAGER.addIntegration(new NoMansLandIntegration());
        COMPAT_MANAGER.addIntegration(new ArtsAndCraftsIntegration());

        COMPAT_MANAGER.registerCompatContent();
    }
}
