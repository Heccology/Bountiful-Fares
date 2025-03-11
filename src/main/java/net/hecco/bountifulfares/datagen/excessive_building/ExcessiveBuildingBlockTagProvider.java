package net.hecco.bountifulfares.datagen.excessive_building;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ExcessiveBuildingBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ExcessiveBuildingBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        registerTrellisBlockTags(ExcessiveBuildingBlocks.ANCIENT);

        getOrCreateTagBuilder(BFBlockTags.PICKETS)
                .add(ExcessiveBuildingBlocks.ANCIENT_PICKETS);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ExcessiveBuildingBlocks.WALNUT_VERTICAL_STAIRS)
                .add(ExcessiveBuildingBlocks.CHISELED_WALNUT_PLANKS)
                .add(ExcessiveBuildingBlocks.WALNUT_MOSAIC)
                .add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_STAIRS)
                .add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB)
                .add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS)
                .add(ExcessiveBuildingBlocks.WALNUT_LADDER)
                .add(ExcessiveBuildingBlocks.HOARY_VERTICAL_STAIRS)
                .add(ExcessiveBuildingBlocks.CHISELED_HOARY_PLANKS)
                .add(ExcessiveBuildingBlocks.HOARY_MOSAIC)
                .add(ExcessiveBuildingBlocks.HOARY_MOSAIC_STAIRS)
                .add(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB)
                .add(ExcessiveBuildingBlocks.HOARY_MOSAIC_VERTICAL_STAIRS)
                .add(ExcessiveBuildingBlocks.HOARY_LADDER)
                .add(ExcessiveBuildingBlocks.ANCIENT_PICKETS);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ExcessiveBuildingBlocks.FELDSPAR_BRICK_VERTICAL_STAIRS)
                .add(ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS)
                .add(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS)
                .add(ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS)
                .add(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS)
                ;
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_STAIRS)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_SLAB)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_WALL)
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS)
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_STAIRS)
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_SLAB)
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_WALL)
                ;

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_STAIRS)
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_STAIRS)
                ;

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_SLAB)
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_SLAB)
        ;

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_WALL)
                .add(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_WALL)
        ;

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(ExcessiveBuildingBlocks.HOARY_LADDER)
                .add(ExcessiveBuildingBlocks.WALNUT_LADDER)
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
