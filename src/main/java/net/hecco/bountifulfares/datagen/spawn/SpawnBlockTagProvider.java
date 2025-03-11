package net.hecco.bountifulfares.datagen.spawn;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class SpawnBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public SpawnBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(SpawnBlocks.ROTTEN_PICKETS)
        ;
        registerTrellisBlockTags(SpawnBlocks.ROTTEN);

        getOrCreateTagBuilder(BFBlockTags.PICKETS)
                .add(SpawnBlocks.ROTTEN_PICKETS)
        ;
    }

    public void registerTrellisBlockTags(TrellisVariant trellis) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .addOptional(Identifier.of(trellis.getModId(), trellis.getBlockName()))
        ;
        for (VineCrop crop : TrellisUtil.VineCrops) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                    .addOptional(Identifier.of(trellis.getModId(), crop.getName() + "_" + trellis.getBlockName()))
            ;
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                    .addOptional(Identifier.of(trellis.getModId(), vine.getName() + "_" + trellis.getBlockName()))
            ;
        }
    }
}
