package net.hecco.bountifulfares.datagen.farmersdelight;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class FarmersDelightBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public FarmersDelightBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
//                .add(FarmersDelightBlocks.WALNUT_CABINET)
//                .add(FarmersDelightBlocks.HOARY_CABINET)
//                ;
    }
}
