package net.hecco.bountifulfares.datagen.dye_depot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class DyeDepotBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DyeDepotBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
//        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
//                .add(DyeDepotBlocks.MAROON_JACK_O_STRAW)
//                .add(DyeDepotBlocks.ROSE_JACK_O_STRAW)
//                .add(DyeDepotBlocks.CORAL_JACK_O_STRAW)
//                .add(DyeDepotBlocks.GINGER_JACK_O_STRAW)
//                .add(DyeDepotBlocks.TAN_JACK_O_STRAW)
//                .add(DyeDepotBlocks.BEIGE_JACK_O_STRAW)
//                .add(DyeDepotBlocks.AMBER_JACK_O_STRAW)
//                .add(DyeDepotBlocks.OLIVE_JACK_O_STRAW)
//                .add(DyeDepotBlocks.FOREST_JACK_O_STRAW)
//                .add(DyeDepotBlocks.VERDANT_JACK_O_STRAW)
//                .add(DyeDepotBlocks.TEAL_JACK_O_STRAW)
//                .add(DyeDepotBlocks.MINT_JACK_O_STRAW)
//                .add(DyeDepotBlocks.AQUA_JACK_O_STRAW)
//                .add(DyeDepotBlocks.SLATE_JACK_O_STRAW)
//                .add(DyeDepotBlocks.NAVY_JACK_O_STRAW)
//                .add(DyeDepotBlocks.INDIGO_JACK_O_STRAW)
//        ;
//
//        getOrCreateTagBuilder(BFBlockTags.JACK_O_STRAWS)
//                .add(DyeDepotBlocks.MAROON_JACK_O_STRAW)
//                .add(DyeDepotBlocks.ROSE_JACK_O_STRAW)
//                .add(DyeDepotBlocks.CORAL_JACK_O_STRAW)
//                .add(DyeDepotBlocks.GINGER_JACK_O_STRAW)
//                .add(DyeDepotBlocks.TAN_JACK_O_STRAW)
//                .add(DyeDepotBlocks.BEIGE_JACK_O_STRAW)
//                .add(DyeDepotBlocks.AMBER_JACK_O_STRAW)
//                .add(DyeDepotBlocks.OLIVE_JACK_O_STRAW)
//                .add(DyeDepotBlocks.FOREST_JACK_O_STRAW)
//                .add(DyeDepotBlocks.VERDANT_JACK_O_STRAW)
//                .add(DyeDepotBlocks.TEAL_JACK_O_STRAW)
//                .add(DyeDepotBlocks.MINT_JACK_O_STRAW)
//                .add(DyeDepotBlocks.AQUA_JACK_O_STRAW)
//                .add(DyeDepotBlocks.SLATE_JACK_O_STRAW)
//                .add(DyeDepotBlocks.NAVY_JACK_O_STRAW)
//                .add(DyeDepotBlocks.INDIGO_JACK_O_STRAW)
//        ;
    }

    public void registerTrellisBlockTags(TrellisVariant trellis) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), trellis.getBlockName()))
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
    }
}
