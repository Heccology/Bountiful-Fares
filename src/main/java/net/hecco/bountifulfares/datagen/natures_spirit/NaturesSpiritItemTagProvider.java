package net.hecco.bountifulfares.datagen.natures_spirit;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class NaturesSpiritItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public NaturesSpiritItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BFItemTags.C_COCONUT_HALVES)
                .addOptional(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "coconut_half"))
                ;
    }
}
