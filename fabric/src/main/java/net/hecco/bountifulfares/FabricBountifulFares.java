package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;
import net.hecco.bountifulfares.registry.misc.BFLootTableModifiers;

public class FabricBountifulFares implements ModInitializer {
    
    @Override
    public void onInitialize() {
        BountifulFares.init();
        BFLootTableModifiers.modifyLootTables();
    }
}
