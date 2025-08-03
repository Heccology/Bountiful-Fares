package net.hecco.bountifulfares.datagen.arts_and_crafts;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ArtsAndCraftsBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ArtsAndCraftsBlocks.CORK_PICKETS.get())
        ;
//        registerTrellisBlockTags(ArtsAndCraftsBlocks.CORK);

        getOrCreateTagBuilder(BFBlockTags.PICKETS)
                .add(ArtsAndCraftsBlocks.CORK_PICKETS.get())
        ;
    }

//    public void registerTrellisBlockTags(TrellisVariant trellis) {
//        tag(BlockTags.MINEABLE_WITH_AXE)
//                .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), trellis.getBlockName()))
        ;
//        for (VineCrop crop : TrellisUtil.VineCrops) {
//            tag(BlockTags.MINEABLE_WITH_AXE)
//                    .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), crop.getName() + "_" + trellis.getBlockName()))
//            ;
//        }
//        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
//            tag(BlockTags.MINEABLE_WITH_AXE)
//                    .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), vine.getName() + "_" + trellis.getBlockName()))
//            ;
//        }
//    }
}
