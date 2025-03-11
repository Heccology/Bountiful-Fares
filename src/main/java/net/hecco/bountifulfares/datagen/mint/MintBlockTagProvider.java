package net.hecco.bountifulfares.datagen.mint;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class MintBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public MintBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(MintBlocks.ACORN_JACK_O_STRAW)
                .add(MintBlocks.AMBER_JACK_O_STRAW)
                .add(MintBlocks.ARTICHOKE_JACK_O_STRAW)
                .add(MintBlocks.BANANA_JACK_O_STRAW)
                .add(MintBlocks.CERULEAN_JACK_O_STRAW)
                .add(MintBlocks.FUCHSIA_JACK_O_STRAW)
                .add(MintBlocks.GRAPE_JACK_O_STRAW)
                .add(MintBlocks.INDIGO_JACK_O_STRAW)
                .add(MintBlocks.MAROON_JACK_O_STRAW)
                .add(MintBlocks.MAUVE_JACK_O_STRAW)
                .add(MintBlocks.MINT_JACK_O_STRAW)
                .add(MintBlocks.MOLD_JACK_O_STRAW)
                .add(MintBlocks.NAVY_JACK_O_STRAW)
                .add(MintBlocks.PEACH_JACK_O_STRAW)
                .add(MintBlocks.PERIWINKLE_JACK_O_STRAW)
                .add(MintBlocks.SAGE_JACK_O_STRAW)
                .add(MintBlocks.SAP_JACK_O_STRAW)
                .add(MintBlocks.SHAMROCK_JACK_O_STRAW)
                .add(MintBlocks.VELVET_JACK_O_STRAW)
                .add(MintBlocks.VERMILION_JACK_O_STRAW)
                .add(MintBlocks.WINTERGREEN_PICKETS)
                ;
        registerTrellisBlockTags(MintBlocks.WINTERGREEN);

        getOrCreateTagBuilder(BFBlockTags.PICKETS)
                .add(MintBlocks.WINTERGREEN_PICKETS)
                ;

        getOrCreateTagBuilder(BFBlockTags.JACK_O_STRAWS)
                .add(MintBlocks.ACORN_JACK_O_STRAW)
                .add(MintBlocks.MAROON_JACK_O_STRAW)
                .add(MintBlocks.PEACH_JACK_O_STRAW)
                .add(MintBlocks.VERMILION_JACK_O_STRAW)
                .add(MintBlocks.AMBER_JACK_O_STRAW)
                .add(MintBlocks.BANANA_JACK_O_STRAW)
                .add(MintBlocks.ARTICHOKE_JACK_O_STRAW)
                .add(MintBlocks.MINT_JACK_O_STRAW)
                .add(MintBlocks.SHAMROCK_JACK_O_STRAW)
                .add(MintBlocks.SAGE_JACK_O_STRAW)
                .add(MintBlocks.MOLD_JACK_O_STRAW)
                .add(MintBlocks.SAP_JACK_O_STRAW)
                .add(MintBlocks.NAVY_JACK_O_STRAW)
                .add(MintBlocks.CERULEAN_JACK_O_STRAW)
                .add(MintBlocks.INDIGO_JACK_O_STRAW)
                .add(MintBlocks.PERIWINKLE_JACK_O_STRAW)
                .add(MintBlocks.GRAPE_JACK_O_STRAW)
                .add(MintBlocks.MAUVE_JACK_O_STRAW)
                .add(MintBlocks.VELVET_JACK_O_STRAW)
                .add(MintBlocks.FUCHSIA_JACK_O_STRAW)
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
