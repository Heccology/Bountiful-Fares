package net.hecco.bountifulfares.compat.excessive_building;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.compat.block.*;
import net.hecco.bountifulfares.sounds.BFSounds;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.BountifulFares.EXCESSIVE_BUILDING_MOD_ID;
import static net.hecco.bountifulfares.compat.BFCompat.compatBlocks;
import static net.hecco.bountifulfares.trellis.BFTrellises.TRELLIS_RENDER_CUTOUT;

public class ExcessiveBuildingBlocks {
    public static final Block ANCIENT_PICKETS = registerBlock("ancient_pickets", new CompatPicketsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static final Block WALNUT_VERTICAL_STAIRS = registerBlock("walnut_vertical_stairs", new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block CHISELED_WALNUT_PLANKS = registerBlock("chiseled_walnut_planks", new CompatBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_MOSAIC = registerBlock("walnut_mosaic", new CompatBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_MOSAIC_STAIRS = registerBlock("walnut_mosaic_stairs", new CompatStairsBlock(EXCESSIVE_BUILDING_MOD_ID, ExcessiveBuildingBlocks.WALNUT_MOSAIC, AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_MOSAIC_SLAB = registerBlock("walnut_mosaic_slab", new CompatSlabBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_MOSAIC_VERTICAL_STAIRS = registerBlock("walnut_mosaic_vertical_stairs", new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_LADDER = registerBlock("walnut_ladder", new CompatLadderBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(Blocks.LADDER)));

    public static final Block HOARY_VERTICAL_STAIRS = registerBlock("hoary_vertical_stairs", new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block CHISELED_HOARY_PLANKS = registerBlock("chiseled_hoary_planks", new CompatBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_MOSAIC = registerBlock("hoary_mosaic", new CompatBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_MOSAIC_STAIRS = registerBlock("hoary_mosaic_stairs", new CompatStairsBlock(EXCESSIVE_BUILDING_MOD_ID, ExcessiveBuildingBlocks.HOARY_MOSAIC, AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_MOSAIC_SLAB = registerBlock("hoary_mosaic_slab", new CompatSlabBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_MOSAIC_VERTICAL_STAIRS = registerBlock("hoary_mosaic_vertical_stairs", new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_LADDER = registerBlock("hoary_ladder", new CompatLadderBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(Blocks.LADDER)));

    public static final Block FELDSPAR_BRICK_VERTICAL_STAIRS = registerBlock("feldspar_brick_vertical_stairs", new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.FELDSPAR_BRICKS)));
    public static final Block CERAMIC_TILE_VERTICAL_STAIRS = registerBlock("ceramic_tile_vertical_stairs", new CeramicTileVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS = registerBlock("checkered_ceramic_tile_vertical_stairs", new CeramicTileVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.CHECKERED_CERAMIC_TILES)));
    public static final Block CERAMIC_MOSAIC_VERTICAL_STAIRS = registerBlock("ceramic_mosaic_vertical_stairs", new CeramicTileVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.CERAMIC_MOSAIC)));
    public static final Block CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS = registerBlock("checkered_ceramic_mosaic_vertical_stairs", new CeramicTileVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.CHECKERED_CERAMIC_MOSAIC)));

    public static final TrellisVariant ANCIENT = new TrellisVariant(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "ancient", null, TRELLIS_RENDER_CUTOUT);

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(EXCESSIVE_BUILDING_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EXCESSIVE_BUILDING_MOD_ID, name), new CompatBlockItem(EXCESSIVE_BUILDING_MOD_ID, block, new Item.Settings()));
    }
    public static void registerExcessiveBuildingBlocks() {

    }
}
