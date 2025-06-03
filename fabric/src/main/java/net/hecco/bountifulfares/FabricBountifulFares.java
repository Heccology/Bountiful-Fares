package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;

public class FabricBountifulFares implements ModInitializer {
    
    @Override
    public void onInitialize() {
        BountifulFares.init();
    }

    public static boolean isDatagen() {
        try {
            Class.forName("net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint");
            return System.getProperty("fabric-api.datagen") != null;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
