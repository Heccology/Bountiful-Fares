package net.hecco.bountifulfares.datagen.twigs;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.twigs.TwigsBlockTags;
import net.hecco.bountifulfares.compat.twigs.TwigsBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class TwigsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public TwigsBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(TwigsBlocks.WALNUT_TABLE)
                .add(TwigsBlocks.HOARY_TABLE);
        getOrCreateTagBuilder(TwigsBlockTags.TABLES)
                .add(TwigsBlocks.WALNUT_TABLE)
                .add(TwigsBlocks.HOARY_TABLE);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(TwigsBlocks.FELDSPAR_LAMP);
    }
}
