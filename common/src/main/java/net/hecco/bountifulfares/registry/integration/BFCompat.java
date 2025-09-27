package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.registry.integration.everycompat.EveryCompatIntegration;

import static net.hecco.bountifulfares.BountifulFares.COMPAT_MANAGER;

public class BFCompat {
    public static void register() {
        COMPAT_MANAGER.addIntegration(new NaturesSpiritIntegration());
        COMPAT_MANAGER.addIntegration(new FrontiersIntegration());
        COMPAT_MANAGER.addIntegration(new FarmersDelightIntegration());
        COMPAT_MANAGER.addIntegration(new AmendmentsIntegration());
        COMPAT_MANAGER.addIntegration(new NoMansLandIntegration());
        COMPAT_MANAGER.addIntegration(new ArtsAndCraftsIntegration());
        COMPAT_MANAGER.addIntegration(new AppledogIntegration());
        COMPAT_MANAGER.addIntegration(new NetherExpIntegration());
        COMPAT_MANAGER.addIntegration(new EveryCompatIntegration());

        COMPAT_MANAGER.registerCompatContent();
    }
}
