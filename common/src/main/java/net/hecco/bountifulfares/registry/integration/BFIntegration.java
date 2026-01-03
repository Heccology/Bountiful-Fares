package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.nexuslib.lib.compat.CompatManager;
import net.hecco.nexuslib.lib.compat.ModIntegration;

public interface BFIntegration extends ModIntegration {
    @Override
    default CompatManager getCompatManager() {
        return BountifulFares.COMPAT_MANAGER;
    }
}
