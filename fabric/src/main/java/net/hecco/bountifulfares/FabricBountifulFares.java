package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.hecco.bountifulfares.registry.BFFabricLootTableModifiers;
import net.hecco.bountifulfares.registry.BFMessages;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.trellis.FabricTrellisCropResourceLoader;
import net.hecco.bountifulfares.trellis.FabricTrellisPlantResourceLoader;
import net.minecraft.server.packs.PackType;

public class FabricBountifulFares implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrellisPlantResourceLoader());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrellisCropResourceLoader());
        BountifulFares.init();
        BFFabricLootTableModifiers.modifyLootTables();
        BFItemGroupAdditions.registerItemGroupAdditions();
        BFMessages.registerPayloads();
    }
}
