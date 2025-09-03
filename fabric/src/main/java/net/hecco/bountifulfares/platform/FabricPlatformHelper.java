package net.hecco.bountifulfares.platform;

import net.hecco.bountifulfares.FabricBountifulFares;
import net.hecco.bountifulfares.definition.platform.services.IPlatformHelper;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public boolean getBoolConfigValue(String id) {
        return FabricBountifulFares.CONFIG.getBoolValue(id);
    }
    @Override
    public int getIntConfigValue(String id) {
        return FabricBountifulFares.CONFIG.getIntValue(id);
    }
}
