package net.hecco.bountifulfares;

import net.hecco.bountifulfares.definition.block.entity.DyeableBlockEntity;
import net.hecco.bountifulfares.definition.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class BountifulFaresClient {

    public static final List<Pair<BlockColor, Block>> blockColors = new ArrayList<>();
    public static final List<Pair<ItemColor, ItemLike>> itemColors = new ArrayList<>();

    static {
        registerCeramicBlockColor(BFBlocks.CERAMIC_TILES.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_TILE_STAIRS.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_TILE_SLAB.get());
        //registerCeramicBlockColor(BFBlocks.CERAMIC_TILE_WALL);
        registerCeramicBlockColor(BFBlocks.CRACKED_CERAMIC_TILES.get());
        registerCeramicBlockColor(BFBlocks.CHECKERED_CERAMIC_TILES.get());
        registerCeramicBlockColor(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get());
        registerCeramicBlockColor(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get());
        //registerCeramicBlockColor(BFBlocks.CHECKERED_CERAMIC_TILE_WALL);
        registerCeramicBlockColor(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_MOSAIC.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_MOSAIC_STAIRS.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_MOSAIC_SLAB.get());
        //registerCeramicBlockColor(BFBlocks.CERAMIC_MOSAIC_WALL);
        registerCeramicBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get());
        registerCeramicBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get());
        registerCeramicBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get());
        //registerCeramicBlockColor(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL);
        registerCeramicBlockColor(BFBlocks.CERAMIC_TILE_PILLAR.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_PRESSURE_PLATE.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_BUTTON.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_LEVER.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_DOOR.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_TRAPDOOR.get());
        registerCeramicBlockColor(BFBlocks.CERAMIC_DISH.get());
        registerCeramicBlockColor(BFBlocks.SOLID_CERAMIC.get());
        itemColors.add(new Pair<>((stack, tintIndex) -> {
            if (stack.getComponents().has(DataComponents.DYED_COLOR) && tintIndex == 0) {
                return FastColor.ARGB32.opaque(Objects.requireNonNull(stack.getComponents().get(DataComponents.DYED_COLOR)).rgb());
            }
            return ArtisanBrushItem.DEFAULT_COLOR;
        }, BFItems.ARTISAN_BRUSH.get()));
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.CHAMOMILE_FLOWERS.get()));

        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.GRASSY_DIRT.get()));

        itemColors.add(new Pair<>((stack, tintIndex) -> GrassColor.getDefaultColor(),
                BFBlocks.GRASSY_DIRT.get()));

        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.APPLE_LEAVES.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.FLOWERING_APPLE_LEAVES.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.APPLE_LOG.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.APPLE_WOOD.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.ORANGE_LEAVES.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.FLOWERING_ORANGE_LEAVES.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.ORANGE_LOG.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.ORANGE_WOOD.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.LEMON_LEAVES.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.FLOWERING_LEMON_LEAVES.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.LEMON_LOG.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.LEMON_WOOD.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.PLUM_LEAVES.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.FLOWERING_PLUM_LEAVES.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.PLUM_LOG.get());
        registerBlockItemColor((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                (stack, tintIndex) -> FastColor.ARGB32.opaque(FoliageColor.getDefaultColor()), BFBlocks.PLUM_WOOD.get());
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                BFBlocks.WALNUT_LEAVES.get()));
        itemColors.add(new Pair<>((stack, tintIndex) -> FastColor.ARGB32.opaque(5809764), BFBlocks.WALNUT_LEAVES.get()));
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                BFBlocks.HANGING_WALNUTS.get()));

        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.WILD_CARROTS.get()));
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.WILD_POTATOES.get()));
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.WILD_BEETROOTS.get()));
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.WILD_LEEKS.get()));
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.WILD_MAIZE.get()));
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.WILD_ELDERBERRY_VINE.get()));
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor(),
                BFBlocks.WILD_PASSION_FRUIT_VINE.get()));
    }

    public static void onInitializeClient() {
//        ElsAndLsDyes compat
//            HLServices.client().setBlockRenderType(MintBlocks.ACORN_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.ARTICHOKE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.AMBER_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.BANANA_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.CERULEAN_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.FUCHSIA_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.GRAPE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.INDIGO_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.MAROON_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.MAUVE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.MOLD_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.MINT_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.NAVY_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.PEACH_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.PERIWINKLE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.SAGE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.SAP_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.SHAMROCK_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.VELVET_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.VERMILION_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(MintBlocks.WINTERGREEN_PICKETS.get(), RenderType.cutout());

//        DyeDepot compat
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.MAROON_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.ROSE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.CORAL_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.GINGER_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.TAN_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.BEIGE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.AMBER_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.OLIVE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.FOREST_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.VERDANT_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.TEAL_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.MINT_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.AQUA_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.SLATE_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.NAVY_JACK_O_STRAW.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(DyeDepotBlocks.INDIGO_JACK_O_STRAW.get(), RenderType.cutout());
//        ExcessiveBuilding compat
//            HLServices.client().setBlockRenderType(ExcessiveBuildingBlocks.ANCIENT_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(ExcessiveBuildingBlocks.WALNUT_LADDER.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(ExcessiveBuildingBlocks.HOARY_LADDER.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS.get(), RenderType.cutout());
//            registerBlockColor(ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS.get());
//            registerBlockColor(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS.get());
//            registerBlockColor(ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS.get());
//            registerBlockColor(ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS.get());
//
////        NaturesSpirit compat
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.ASPEN_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.CEDAR_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.COCONUT_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.CYPRESS_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.FIR_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.JOSHUA_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.GHAF_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.LARCH_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.MAHOGANY_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.MAPLE_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.MAHOGANY_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.OLIVE_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.PALO_VERDE_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.REDWOOD_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.SAXAUL_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.SUGI_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.WILLOW_PICKETS.get(), RenderType.cutout());
//            HLServices.client().setBlockRenderType(NaturesSpiritBlocks.WISTERIA_PICKETS.get(), RenderType.cutout());
//
//        //        Spawn compat
////            HLServices.client().setBlockRenderType(SpawnBlocks.ROTTEN_PICKETS.get(), RenderType.cutout());
//        //        ArtsAndCrafts compat
//            HLServices.client().setBlockRenderType(ArtsAndCraftsBlocks.CORK_PICKETS.get(), RenderType.cutout());
//
//        //        DelicateDyes compat
//        HLServices.client().setBlockRenderType(DelicateDyesBlocks.CORAL_JACK_O_STRAW.get(), RenderType.cutout());
//        HLServices.client().setBlockRenderType(DelicateDyesBlocks.CANARY_JACK_O_STRAW.get(), RenderType.cutout());
//        HLServices.client().setBlockRenderType(DelicateDyesBlocks.WASABI_JACK_O_STRAW.get(), RenderType.cutout());
//        HLServices.client().setBlockRenderType(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW.get(), RenderType.cutout());
//        HLServices.client().setBlockRenderType(DelicateDyesBlocks.SKY_JACK_O_STRAW.get(), RenderType.cutout());
//        HLServices.client().setBlockRenderType(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW.get(), RenderType.cutout());
//        HLServices.client().setBlockRenderType(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW.get(), RenderType.cutout());
//        HLServices.client().setBlockRenderType(DelicateDyesBlocks.ROSE_JACK_O_STRAW.get(), RenderType.cutout());
//
//        //          Appledog compat
//        HLServices.client().setBlockRenderType(AppledogBlocks.APPLEDOG_BLOCK.get(), RenderType.cutout());
//
//        //          DungeonsDelight compat
//        HLServices.client().setBlockRenderType(DungeonsDelightBlocks.WORMWOOD_PICKETS.get(), RenderType.cutout());
//
        HLServices.client().setBlockRenderType(BFBlocks.APPLE_LOG.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.APPLE_WOOD.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HANGING_APPLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.APPLE_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_APPLE_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.ORANGE_LOG.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.ORANGE_WOOD.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HANGING_ORANGE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.ORANGE_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_ORANGE_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.LEMON_LOG.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.LEMON_WOOD.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HANGING_LEMON.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.LEMON_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_LEMON_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PLUM_LOG.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PLUM_WOOD.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HANGING_PLUM.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PLUM_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_PLUM_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.GOLDEN_APPLE_LOG.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.GOLDEN_APPLE_WOOD.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HANGING_GOLDEN_APPLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HANGING_WITHERED_GOLDEN_APPLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.GOLDEN_APPLE_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_GOLDEN_APPLE_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HOARY_APPLE_SAPLING_CROP.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HOARY_APPLE_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_WALNUT_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_HOARY_APPLE_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HANGING_HOARY_APPLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WALNUT_SAPLING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HANGING_WALNUTS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.FALLEN_WALNUTS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WILD_CARROTS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WILD_POTATOES.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WILD_WHEAT.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WILD_BEETROOTS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WILD_LEEKS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WILD_MAIZE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WILD_PASSION_FRUIT_VINE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WILD_ELDERBERRY_VINE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.FERMENTATION_VESSEL.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.FELDSPAR_LANTERN.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.TINGED_GLASS.get(), RenderType.translucent());
        HLServices.client().setBlockRenderType(BFBlocks.CHECKERED_CERAMIC_TILES.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get(), RenderType.cutout());
        //HLServices.client().setBlockRenderType(BFBlocks.CHECKERED_CERAMIC_TILE_WALL, RenderLayer.getCutout());
        HLServices.client().setBlockRenderType(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get(), RenderType.cutout());
        //HLServices.client().setBlockRenderType(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL, RenderLayer.getCutout());
        HLServices.client().setBlockRenderType(BFBlocks.CERAMIC_DOOR.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.APPLE_BLOCK.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.GOLDEN_APPLE_BLOCK.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.ORANGE_BLOCK.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.LEMON_BLOCK.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PLUM_BLOCK.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HOARY_APPLE_BLOCK.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WALNUT_DOOR.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.TEA_SHRUB.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CHAMOMILE_FLOWERS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HONEYSUCKLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_HONEYSUCKLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.VIOLET_BELLFLOWER.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_VIOLET_BELLFLOWER.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.RED_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.ORANGE_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.YELLOW_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.LIME_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.GREEN_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CYAN_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.BLUE_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PURPLE_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.MAGENTA_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PINK_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WHITE_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.GRAY_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.BLACK_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.BROWN_JACK_O_STRAW.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.GREEN_TEA_CANDLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.BLACK_TEA_CANDLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CHAMOMILE_CANDLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HONEYSUCKLE_CANDLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.BELLFLOWER_CANDLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.TORCHFLOWER_CANDLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WALNUT_CANDLE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.LEEKS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.MAIZE_CROP.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.SPONGEKIN_STEM.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.SPONGEKIN_SPROUT.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.SPONGE_CAKE.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PRISMARINE_BLOSSOM.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.SCORCHKIN_STEM.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.OAK_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.SPRUCE_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.BIRCH_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.JUNGLE_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.ACACIA_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.DARK_OAK_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.MANGROVE_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CHERRY_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.BAMBOO_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WALNUT_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.HOARY_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.CRIMSON_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WARPED_PICKETS.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.IRON_RAILING.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.GRASSY_DIRT.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PALM_FROND.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.WALL_PALM_FROND.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.POTTED_PALM_FROND.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.COCONUT.get(), RenderType.cutout());
        HLServices.client().setBlockRenderType(BFBlocks.PALM_SAPLING.get(), RenderType.cutout());
        for (Block block : BFBlocks.TRELLISES.values().stream().map(Supplier::get).toList()) {
            HLServices.client().setBlockRenderType(block, RenderType.cutout());
        }


//        TerraformBoatClientHelper.registerModelLayers(BFBoats.HOARY_BOAT_ID, false);
//        TerraformBoatClientHelper.registerModelLayers(BFBoats.WALNUT_BOAT_ID, false);

        HLServices.client().registerItemModelPredicate(
                BFItems.ARTISAN_BRUSH.get(),
                ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "dyed"),
                (itemStack, clientWorld, livingEntity, seed) ->
                        itemStack.getComponents().get(DataComponents.DYED_COLOR) != null ? 1.0F : 0.0F);

        Sheets.SIGN_MATERIALS.put(BFWoodTypes.HOARY, new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "entity/signs/hoary")));
        Sheets.HANGING_SIGN_MATERIALS.put(BFWoodTypes.HOARY, new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "entity/signs/hanging/hoary")));
        Sheets.SIGN_MATERIALS.put(BFWoodTypes.WALNUT, new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "entity/signs/walnut")));
        Sheets.HANGING_SIGN_MATERIALS.put(BFWoodTypes.WALNUT, new Material(Sheets.SIGN_SHEET, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "entity/signs/hanging/walnut")));
    }

    private static void registerBlockItemColor(BlockColor color, ItemColor itemColor, Block block) {
        itemColors.add(new Pair<>(itemColor, block));
        blockColors.add(new Pair<>(color, block));
    }

    private static void registerCeramicBlockColor(Block block) {
        registerCeramicItemColor(block.asItem());
        blockColors.add(new Pair<>((state, world, pos, tintIndex) -> FastColor.ARGB32.opaque(DyeableBlockEntity.getColor(world, pos)), block));
    }

    private static void registerCeramicItemColor(Item item) {
        itemColors.add(new Pair<>((stack, tintIndex) -> {
            if (stack.getComponents().get(DataComponents.DYED_COLOR) != null && tintIndex == 0) {
                return FastColor.ARGB32.opaque(stack.getComponents().get(DataComponents.DYED_COLOR).rgb());
            }
            return DyeableBlockEntity.DEFAULT_COLOR;
        }, item));
    }
}
