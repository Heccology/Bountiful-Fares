package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.registry.integration.everycompat.EveryCompatIntegration;
import net.hecco.nexuslib.platform.NLServices;

import static net.hecco.bountifulfares.BountifulFares.COMPAT_MANAGER;
import static net.hecco.bountifulfares.BountifulFares.EVERY_COMPAT_MOD_ID;

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
        COMPAT_MANAGER.addIntegration(new DelicateDyesIntegration());

        COMPAT_MANAGER.registerCompatContent();

        if (NLServices.PLATFORM.isModLoaded(EVERY_COMPAT_MOD_ID)) {
            // integration calls EC API to register module, so check is needed
            EveryCompatIntegration.register();
        }
    }
}
