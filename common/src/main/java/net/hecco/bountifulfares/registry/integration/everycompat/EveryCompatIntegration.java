package net.hecco.bountifulfares.registry.integration.everycompat;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.nexuslib.lib.compat.CompatManager;
import net.hecco.nexuslib.lib.compat.ModIntegration;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;

import java.util.List;

import static net.hecco.bountifulfares.BountifulFares.EVERY_COMPAT_MOD_ID;

public class EveryCompatIntegration implements ModIntegration {

    @Override
    public CompatManager getCompatManager() { return BountifulFares.COMPAT_MANAGER; }

    @Override
    public List<String> modIds() { return List.of(EVERY_COMPAT_MOD_ID); }

    @Override
    public void registerContent() {
        EveryCompatAPI.registerModule(new BFEveryCompatModule(BountifulFares.MOD_ID));
    }
}
