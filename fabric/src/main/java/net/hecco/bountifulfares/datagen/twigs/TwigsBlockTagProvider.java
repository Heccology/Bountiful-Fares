package net.hecco.bountifulfares.datagen.twigs;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class TwigsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public TwigsBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
//        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
//                .add(TwigsBlocks.WALNUT_TABLE)
//                .add(TwigsBlocks.HOARY_TABLE);
//        getOrCreateTagBuilder(TwigsBlockTags.TABLES)
//                .add(TwigsBlocks.WALNUT_TABLE)
//                .add(TwigsBlocks.HOARY_TABLE);
//        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(TwigsBlocks.FELDSPAR_LAMP);
    }
}
