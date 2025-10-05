package net.hecco.bountifulfares.definition.platform;

import com.google.common.base.Suppliers;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.platform.services.IPlatformHelper;

import java.util.ServiceLoader;
import java.util.function.Supplier;

public class Services {

    public static final Supplier<IPlatformHelper> PLATFORM = Suppliers.memoize(() -> load(IPlatformHelper.class));

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        BountifulFares.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}