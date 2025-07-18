package net.hecco.bountifulfares.compat.excessive_building;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.*;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSoundTypes;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.*;
import static net.hecco.bountifulfares.BountifulFares.DYE_DEPOT_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFTrellises.TRELLIS_RENDER_CUTOUT;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class ExcessiveBuildingBlocks {
    public static final Supplier<Block> ANCIENT_PICKETS = registerBlock("ancient_pickets", () -> new CompatPicketsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSoundTypes.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static final Supplier<Block> WALNUT_VERTICAL_STAIRS = registerBlock("walnut_vertical_stairs", () -> new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS.get())));
    public static final Supplier<Block> CHISELED_WALNUT_PLANKS = registerBlock("chiseled_walnut_planks", () -> new CompatBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS.get())));
    public static final Supplier<Block> WALNUT_MOSAIC = registerBlock("walnut_mosaic", () -> new CompatBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS.get())));
    public static final Supplier<Block> WALNUT_MOSAIC_STAIRS = registerBlock("walnut_mosaic_stairs", () -> new CompatStairsBlock(EXCESSIVE_BUILDING_MOD_ID, ExcessiveBuildingBlocks.WALNUT_MOSAIC.get(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS.get())));
    public static final Supplier<Block> WALNUT_MOSAIC_SLAB = registerBlock("walnut_mosaic_slab", () -> new CompatSlabBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS.get())));
    public static final Supplier<Block> WALNUT_MOSAIC_VERTICAL_STAIRS = registerBlock("walnut_mosaic_vertical_stairs", () -> new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS.get())));
    public static final Supplier<Block> WALNUT_LADDER = registerBlock("walnut_ladder", () -> new CompatLadderBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));

    public static final Supplier<Block> HOARY_VERTICAL_STAIRS = registerBlock("hoary_vertical_stairs", () -> new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS.get())));
    public static final Supplier<Block> CHISELED_HOARY_PLANKS = registerBlock("chiseled_hoary_planks", () -> new CompatBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS.get())));
    public static final Supplier<Block> HOARY_MOSAIC = registerBlock("hoary_mosaic", () -> new CompatBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS.get())));
    public static final Supplier<Block> HOARY_MOSAIC_STAIRS = registerBlock("hoary_mosaic_stairs", () -> new CompatStairsBlock(EXCESSIVE_BUILDING_MOD_ID, ExcessiveBuildingBlocks.HOARY_MOSAIC.get(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS.get())));
    public static final Supplier<Block> HOARY_MOSAIC_SLAB = registerBlock("hoary_mosaic_slab", () -> new CompatSlabBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS.get())));
    public static final Supplier<Block> HOARY_MOSAIC_VERTICAL_STAIRS = registerBlock("hoary_mosaic_vertical_stairs", () -> new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS.get())));
    public static final Supplier<Block> HOARY_LADDER = registerBlock("hoary_ladder", () -> new CompatLadderBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));

    public static final Supplier<Block> FELDSPAR_BRICK_VERTICAL_STAIRS = registerBlock("feldspar_brick_vertical_stairs", () -> new CompatVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.FELDSPAR_BRICKS.get())));
    public static final Supplier<Block> CERAMIC_TILE_VERTICAL_STAIRS = registerBlock("ceramic_tile_vertical_stairs", () -> new CeramicTileVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_TILES.get())));
    public static final Supplier<Block> CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS = registerBlock("checkered_ceramic_tile_vertical_stairs", () -> new CeramicTileVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.CHECKERED_CERAMIC_TILES.get())));
    public static final Supplier<Block> CERAMIC_MOSAIC_VERTICAL_STAIRS = registerBlock("ceramic_mosaic_vertical_stairs", () -> new CeramicTileVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_MOSAIC.get())));
    public static final Supplier<Block> CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS = registerBlock("checkered_ceramic_mosaic_vertical_stairs", () -> new CeramicTileVerticalStairsBlock(EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get())));

    public static final Supplier<Block> WALNUT_MULCH_BRICKS = registerBlock("walnut_mulch_bricks", () -> new CompatBlock(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_MULCH_BLOCK.get())));
    public static final Supplier<Block> WALNUT_MULCH_BRICK_STAIRS = registerBlock("walnut_mulch_bricks_stairs", () -> new CompatStairsBlock(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, WALNUT_MULCH_BRICKS.get(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_MULCH_BLOCK.get())));
    public static final Supplier<Block> WALNUT_MULCH_BRICK_SLAB = registerBlock("walnut_mulch_bricks_slab", () -> new CompatSlabBlock(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_MULCH_BLOCK.get())));
    public static final Supplier<Block> WALNUT_MULCH_BRICK_WALL = registerBlock("walnut_mulch_bricks_wall", () -> new CompatWallBlock(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_MULCH_BLOCK.get())));

    public static final Supplier<Block> PALM_MULCH_BRICKS = registerBlock("palm_mulch_bricks", () -> new CompatBlock(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.PALM_MULCH_BLOCK.get())));
    public static final Supplier<Block> PALM_MULCH_BRICK_STAIRS = registerBlock("palm_mulch_bricks_stairs", () -> new CompatStairsBlock(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, PALM_MULCH_BRICKS.get(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.PALM_MULCH_BLOCK.get())));
    public static final Supplier<Block> PALM_MULCH_BRICK_SLAB = registerBlock("palm_mulch_bricks_slab", () -> new CompatSlabBlock(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.PALM_MULCH_BLOCK.get())));
    public static final Supplier<Block> PALM_MULCH_BRICK_WALL = registerBlock("palm_mulch_bricks_wall", () -> new CompatWallBlock(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.PALM_MULCH_BLOCK.get())));

    public static final TrellisVariant ANCIENT = new TrellisVariant(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "ancient", ResourceLocation.fromNamespaceAndPath(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "ancient_planks"), TRELLIS_RENDER_CUTOUT);

    public static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return HLServices.REGISTRY.registerBlockNoItem(EXCESSIVE_BUILDING_MOD_ID, name, block);
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        HLServices.REGISTRY.registerItem(EXCESSIVE_BUILDING_MOD_ID, name, () -> new CompatBlockItem(EXCESSIVE_BUILDING_MOD_ID, block.get(), new Item.Properties()));
    }
    public static void registerExcessiveBuildingBlocks() {

    }
}
