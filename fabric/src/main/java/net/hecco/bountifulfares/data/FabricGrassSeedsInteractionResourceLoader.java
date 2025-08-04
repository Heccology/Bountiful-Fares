package net.hecco.bountifulfares.data;

import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.data.grass_seeds.GrassSeedsInteractionResourceLoader;
import net.minecraft.resources.ResourceLocation;

public class FabricGrassSeedsInteractionResourceLoader extends GrassSeedsInteractionResourceLoader implements IdentifiableResourceReloadListener {
    @Override
    public ResourceLocation getFabricId() {
        return ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "bountifulfares/grass_seeds_interaction");
    }
}
