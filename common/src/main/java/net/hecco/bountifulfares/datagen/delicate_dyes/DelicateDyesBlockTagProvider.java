package net.hecco.bountifulfares.datagen.delicate_dyes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class DelicateDyesBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DelicateDyesBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(DelicateDyesBlocks.CORAL_JACK_O_STRAW)
                .add(DelicateDyesBlocks.CANARY_JACK_O_STRAW)
                .add(DelicateDyesBlocks.WASABI_JACK_O_STRAW)
                .add(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW)
                .add(DelicateDyesBlocks.SKY_JACK_O_STRAW)
                .add(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW)
                .add(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW)
                .add(DelicateDyesBlocks.ROSE_JACK_O_STRAW)
        ;

        getOrCreateTagBuilder(BFBlockTags.JACK_O_STRAWS)
                .add(DelicateDyesBlocks.CORAL_JACK_O_STRAW)
                .add(DelicateDyesBlocks.CANARY_JACK_O_STRAW)
                .add(DelicateDyesBlocks.WASABI_JACK_O_STRAW)
                .add(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW)
                .add(DelicateDyesBlocks.SKY_JACK_O_STRAW)
                .add(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW)
                .add(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW)
                .add(DelicateDyesBlocks.ROSE_JACK_O_STRAW)
        ;
    }
}
