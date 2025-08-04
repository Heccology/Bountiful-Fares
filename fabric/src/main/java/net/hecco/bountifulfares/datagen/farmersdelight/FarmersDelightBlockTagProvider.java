package net.hecco.bountifulfares.datagen.farmersdelight;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class FarmersDelightBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public FarmersDelightBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
//        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
//                .add(FarmersDelightBlocks.WALNUT_CABINET)
//                .add(FarmersDelightBlocks.HOARY_CABINET)
//                ;
    }
}
