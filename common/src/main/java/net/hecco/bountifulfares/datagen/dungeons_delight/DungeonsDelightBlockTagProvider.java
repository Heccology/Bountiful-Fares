package net.hecco.bountifulfares.datagen.dungeons_delight;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class DungeonsDelightBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DungeonsDelightBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(DungeonsDelightBlocks.WORMWOOD_PICKETS)
        ;
        registerTrellisBlockTags(DungeonsDelightBlocks.WORMWOOD);

        getOrCreateTagBuilder(BFBlockTags.PICKETS)
                .add(DungeonsDelightBlocks.WORMWOOD_PICKETS)
        ;
    }

    public void registerTrellisBlockTags(TrellisVariant trellis) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), trellis.getBlockName()))
        ;
        for (VineCrop crop : TrellisUtil.VineCrops) {
            tag(BlockTags.MINEABLE_WITH_AXE)
                    .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), crop.getName() + "_" + trellis.getBlockName()))
            ;
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            tag(BlockTags.MINEABLE_WITH_AXE)
                    .addOptional(ResourceLocation.fromNamespaceAndPath(trellis.getModId(), vine.getName() + "_" + trellis.getBlockName()))
            ;
        }
    }
}
