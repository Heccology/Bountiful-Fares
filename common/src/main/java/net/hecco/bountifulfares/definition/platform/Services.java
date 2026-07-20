package net.hecco.bountifulfares.definition.platform;

import com.google.common.base.Suppliers;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.platform.services.IPlatformHelper;

import java.lang.ClassLoader;
import java.util.ServiceLoader;
import java.util.function.Supplier;

public class Services {

    public static final Supplier<IPlatformHelper> PLATFORM = Suppliers.memoize(() -> load(IPlatformHelper.class));
    private static ClassLoader classLoader;

    public static void setClassLoader(final ClassLoader classLoader) {
        Services.classLoader = classLoader;
    }

    public static <T> T load(Class<T> clazz) {
        ServiceLoader<T> loader = ServiceLoader.load(clazz, classLoader);
        for (T service : loader) {
            System.out.println("Loaded service: " + service.getClass().getName());
            return service;
        }
        throw new NullPointerException("Failed to load service for " + clazz.getName());
    }
}
