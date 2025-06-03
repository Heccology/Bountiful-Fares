package net.hecco.bountifulfares.datagen.natures_spirit;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

public class NaturesSpiritItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public NaturesSpiritItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BFItemTags.C_COCONUT_HALVES)
                .addOptional(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_half"))
                ;
    }
}
