package net.hecco.bountifulfares.trellis;

import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.resources.ResourceLocation;

public class FabricTrelisPlantResourceLoader extends TrellisPlantResourceLoader implements IdentifiableResourceReloadListener {
    @Override
    public ResourceLocation getFabricId() {
        return ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "bountifulfares/trellis_plant");
    }
}
