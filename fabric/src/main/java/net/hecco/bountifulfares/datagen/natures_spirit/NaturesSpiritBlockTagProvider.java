package net.hecco.bountifulfares.datagen.natures_spirit;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class NaturesSpiritBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public NaturesSpiritBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
//        registerTrellisBlockTags(NaturesSpiritBlocks.ASPEN);
//        registerTrellisBlockTags(NaturesSpiritBlocks.CEDAR);
//        registerTrellisBlockTags(NaturesSpiritBlocks.COCONUT);
//        registerTrellisBlockTags(NaturesSpiritBlocks.CYPRESS);
//        registerTrellisBlockTags(NaturesSpiritBlocks.FIR);
//        registerTrellisBlockTags(NaturesSpiritBlocks.GHAF);
//        registerTrellisBlockTags(NaturesSpiritBlocks.JOSHUA);
//        registerTrellisBlockTags(NaturesSpiritBlocks.LARCH);
//        registerTrellisBlockTags(NaturesSpiritBlocks.MAHOGANY);
//        registerTrellisBlockTags(NaturesSpiritBlocks.MAPLE);
//        registerTrellisBlockTags(NaturesSpiritBlocks.OLIVE);
//        registerTrellisBlockTags(NaturesSpiritBlocks.PALO_VERDE);
//        registerTrellisBlockTags(NaturesSpiritBlocks.SAXAUL);
//        registerTrellisBlockTags(NaturesSpiritBlocks.SUGI);
//        registerTrellisBlockTags(NaturesSpiritBlocks.WILLOW);
//        registerTrellisBlockTags(NaturesSpiritBlocks.WISTERIA);
//
//        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
//                .add(NaturesSpiritBlocks.ASPEN_PICKETS)
//                .add(NaturesSpiritBlocks.CEDAR_PICKETS)
//                .add(NaturesSpiritBlocks.COCONUT_PICKETS)
//                .add(NaturesSpiritBlocks.CYPRESS_PICKETS)
//                .add(NaturesSpiritBlocks.FIR_PICKETS)
//                .add(NaturesSpiritBlocks.GHAF_PICKETS)
//                .add(NaturesSpiritBlocks.JOSHUA_PICKETS)
//                .add(NaturesSpiritBlocks.LARCH_PICKETS)
//                .add(NaturesSpiritBlocks.MAHOGANY_PICKETS)
//                .add(NaturesSpiritBlocks.MAPLE_PICKETS)
//                .add(NaturesSpiritBlocks.OLIVE_PICKETS)
//                .add(NaturesSpiritBlocks.PALO_VERDE_PICKETS)
//                .add(NaturesSpiritBlocks.SAXAUL_PICKETS)
//                .add(NaturesSpiritBlocks.SUGI_PICKETS)
//                .add(NaturesSpiritBlocks.WILLOW_PICKETS)
//                .add(NaturesSpiritBlocks.WISTERIA_PICKETS);
//
//        getOrCreateTagBuilder(BFBlockTags.PICKETS)
//                .add(NaturesSpiritBlocks.ASPEN_PICKETS)
//                .add(NaturesSpiritBlocks.CEDAR_PICKETS)
//                .add(NaturesSpiritBlocks.COCONUT_PICKETS)
//                .add(NaturesSpiritBlocks.CYPRESS_PICKETS)
//                .add(NaturesSpiritBlocks.FIR_PICKETS)
//                .add(NaturesSpiritBlocks.GHAF_PICKETS)
//                .add(NaturesSpiritBlocks.JOSHUA_PICKETS)
//                .add(NaturesSpiritBlocks.LARCH_PICKETS)
//                .add(NaturesSpiritBlocks.MAHOGANY_PICKETS)
//                .add(NaturesSpiritBlocks.MAPLE_PICKETS)
//                .add(NaturesSpiritBlocks.OLIVE_PICKETS)
//                .add(NaturesSpiritBlocks.PALO_VERDE_PICKETS)
//                .add(NaturesSpiritBlocks.SAXAUL_PICKETS)
//                .add(NaturesSpiritBlocks.SUGI_PICKETS)
//                .add(NaturesSpiritBlocks.WILLOW_PICKETS)
//                .add(NaturesSpiritBlocks.WISTERIA_PICKETS)
//                ;
    }

//    public void registerTrellisBlockTags(TrellisVariant trellis) {
//        tag(BlockTags.MINEABLE_WITH_AXE)
//                .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), trellis.getBlockName()))
//        ;
////        for (VineCrop crop : TrellisUtil.VineCrops) {
////            tag(BlockTags.MINEABLE_WITH_AXE)
////                    .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), crop.getName() + "_" + trellis.getBlockName()))
////            ;
////        }
////        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
////            tag(BlockTags.MINEABLE_WITH_AXE)
////                    .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), vine.getName() + "_" + trellis.getBlockName()))
////            ;
////        }
//    }
}
