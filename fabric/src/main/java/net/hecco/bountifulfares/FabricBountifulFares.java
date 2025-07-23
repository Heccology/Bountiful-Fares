package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.hecco.bountifulfares.registry.BFMessages;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.trellis.FabricTrelisPlantResourceLoader;
import net.minecraft.server.packs.PackType;

public class FabricBountifulFares implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrelisPlantResourceLoader());
        BountifulFares.init();
//        BFLootTableModifiers.modifyLootTables();
        BFItemGroupAdditions.registerItemGroupAdditions();
        BFMessages.registerPayloads();
    }
}
