package net.hecco.bountifulcuisine.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.custom.*;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulcuisine.util.ModBlockSetTypes;
import net.hecco.bountifulcuisine.util.ModWoodTypes;
import net.hecco.bountifulcuisine.world.tree.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block APPLE_LOG = registerBlock("apple_log", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_LOG).requiresTool().ticksRandomly()));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).requiresTool()));
    public static final Block APPLE_WOOD = registerBlock("apple_wood", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).requiresTool()));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).requiresTool()));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves", new AppleLeavesBlock(ModBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block BLOSSOMING_APPLE_LEAVES = registerBlock("blossoming_apple_leaves", new AppleLeavesBlock(ModBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block HANGING_APPLE = registerBlockNoItem("hanging_apple", new HangingAppleBlock(FabricBlockSettings.copyOf(Blocks.GRASS).ticksRandomly().offset(AbstractBlock.OffsetType.XZ)));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling", new SaplingBlock(new AppleSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING)));
    public static final Block ORANGE_LOG = registerBlock("orange_log", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block ORANGE_WOOD = registerBlock("orange_wood", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block ORANGE_LEAVES = registerBlock("orange_leaves", new OrangeLeavesBlock(ModBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block BLOSSOMING_ORANGE_LEAVES = registerBlock("blossoming_orange_leaves", new OrangeLeavesBlock(ModBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(ModBlocks.BLOSSOMING_APPLE_LEAVES)));
    public static final Block HANGING_ORANGE = registerBlockNoItem("hanging_orange", new HangingOrangeBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block ORANGE_SAPLING = registerBlock("orange_sapling", new SaplingBlock(new OrangeSaplingGenerator(), FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block LEMON_LOG = registerBlock("lemon_log", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.BLOSSOMING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.BLOSSOMING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.BLOSSOMING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.BLOSSOMING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new LemonLeavesBlock(ModBlocks.HANGING_LEMON, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block BLOSSOMING_LEMON_LEAVES = registerBlock("blossoming_lemon_leaves", new LemonLeavesBlock(ModBlocks.HANGING_LEMON, FabricBlockSettings.copyOf(ModBlocks.BLOSSOMING_APPLE_LEAVES)));
    public static final Block HANGING_LEMON = registerBlockNoItem("hanging_lemon", new HangingLemonBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", new SaplingBlock(new LemonSaplingGenerator(), FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block PLUM_LOG = registerBlock("plum_log", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.BLOSSOMING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.BLOSSOMING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block PLUM_WOOD = registerBlock("plum_wood", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.BLOSSOMING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.BLOSSOMING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block PLUM_LEAVES = registerBlock("plum_leaves", new PlumLeavesBlock(ModBlocks.HANGING_PLUM, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block BLOSSOMING_PLUM_LEAVES = registerBlock("blossoming_plum_leaves", new PlumLeavesBlock(ModBlocks.HANGING_PLUM, FabricBlockSettings.copyOf(ModBlocks.BLOSSOMING_APPLE_LEAVES)));
    public static final Block HANGING_PLUM = registerBlockNoItem("hanging_plum", new HangingPlumBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block PLUM_SAPLING = registerBlock("plum_sapling", new SaplingBlock(new PlumSaplingGenerator(), FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block HOARY_FIG_SAPLING_CROP = registerBlockNoItem("hoary_fig_sapling_crop", new HoaryFigSaplingCropBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HOARY_FIG_SAPLING = registerBlock("hoary_fig_sapling", new SaplingBlock(new HoarySaplingGenerator(), FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CHERRY_SAPLING).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HOARY_LOG = registerBlock("hoary_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WOOD = registerBlock("hoary_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_LOG = registerBlock("stripped_hoary_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GRAY)));
    public static final Block STRIPPED_HOARY_WOOD = registerBlock("stripped_hoary_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GRAY)));
    public static final Block HOARY_PLANKS = registerBlock("hoary_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.GRAY)));
    public static final Block HOARY_STAIRS = registerBlock("hoary_stairs", new ModStairsBlock(ModBlocks.HOARY_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.HOARY_PLANKS)));
    public static final Block HOARY_SLAB = registerBlock("hoary_slab", new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.HOARY_PLANKS)));
    public static final Block HOARY_FENCE = registerBlock("hoary_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.GRAY)));
    public static final Block HOARY_FENCE_GATE = registerBlock("hoary_fence_gate", new ModFenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_DOOR = registerBlock("hoary_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.GRAY), ModBlockSetTypes.HOARY));
    public static final Block HOARY_TRAPDOOR = registerBlock("hoary_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.GRAY), ModBlockSetTypes.HOARY));
    public static final Block HOARY_PRESSURE_PLATE = registerBlock("hoary_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).strength(0.5f, 5.0f), ModBlockSetTypes.HOARY));
    public static final Block HOARY_BUTTON = registerBlock("hoary_button", new ButtonBlock(AbstractBlock.Settings.copy(ModBlocks.HOARY_PLANKS).noCollision().strength(0.5f, 5f), ModBlockSetTypes.HOARY, 30, true));
    public static final Block HOARY_SIGN = registerBlockNoItem("hoary_sign", new ModStandingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_WALL_SIGN = registerBlockNoItem("hoary_wall_sign", new ModWallSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_HANGING_SIGN = registerBlockNoItem("hoary_hanging_sign", new ModHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_WALL_HANGING_SIGN = registerBlockNoItem("hoary_wall_hanging_sign", new ModWallHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_LEAVES = registerBlock("hoary_leaves", new LeavesBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block TRELLIS = registerBlock("trellis", new TrellisBlock(FabricBlockSettings.create().strength(0.5F).sounds(BlockSoundGroup.WOOD).instrument(Instrument.BASS).nonOpaque().requiresTool()));
    public static final Block PASSION_FRUIT_TRELLIS = registerBlockNoItem("passion_fruit_trellis", new PassionFruitTrellisBlock(ModItems.PASSION_FRUIT, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).instrument(Instrument.BASS).ticksRandomly().requiresTool()));
    public static final Block ELDERBERRY_TRELLIS = registerBlockNoItem("elderberry_trellis", new ElderberryTrellisBlock(ModItems.ELDERBERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).instrument(Instrument.BASS).ticksRandomly().requiresTool()));
    public static final Block GLOW_BERRY_TRELLIS = registerBlockNoItem("glow_berry_trellis", new GlowBerryTrellisBlock(Items.GLOW_BERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).instrument(Instrument.BASS).ticksRandomly().requiresTool()));
    public static final Block LAPISBERRY_TRELLIS = registerBlockNoItem("lapisberry_trellis", new LapisberryTrellisBlock(ModItems.LAPISBERRY_SEEDS, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).instrument(Instrument.BASS).ticksRandomly().requiresTool()));
    public static final Block FLOWER_TRELLIS = registerBlockNoItem("flower_trellis", new FlowerTrellisBlock(FabricBlockSettings.copyOf(ModBlocks.TRELLIS).instrument(Instrument.BASS).ticksRandomly().requiresTool()));
    public static final Block WILD_CARROTS = registerBlockNoItem("wild_carrots", new WildCropBlock(ModItems.WILD_CARROT, FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_POTATOES = registerBlockNoItem("wild_potatoes", new WildCropBlock(ModItems.WILD_POTATO, FabricBlockSettings.create().mapColor(MapColor.DULL_PINK).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_WHEAT = registerBlockNoItem("wild_wheat", new WildCropBlock(ModItems.WILD_WHEAT_SEEDS, FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_BEETROOTS = registerBlockNoItem("wild_beetroots", new WildCropBlock(ModItems.WILD_BEETROOT_SEEDS, FabricBlockSettings.create().mapColor(MapColor.DULL_PINK).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FELDSPAR_BLOCK = registerBlock("feldspar_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BASEDRUM).strength(1.5f).sounds(BlockSoundGroup.CALCITE)));
    public static final Block CERAMIC_CLAY_BLOCK = registerBlock("ceramic_clay_block", new Block(FabricBlockSettings.copyOf(Blocks.CLAY).instrument(Instrument.FLUTE).mapColor(MapColor.WHITE)));
    public static final Block CERAMIC_TILES = registerDyeableCeramicBlock("ceramic_tiles", new CeramicTilesBlock(FabricBlockSettings.copyOf(Blocks.BRICKS).strength(2f, 16f).sounds(BlockSoundGroup.DEEPSLATE_TILES).instrument(Instrument.BASEDRUM).mapColor(MapColor.OFF_WHITE)));
    public static final Block CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("ceramic_tile_stairs", new CeramicTileStairsBlock(ModBlocks.CERAMIC_TILES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("ceramic_tile_slab", new CeramicTileSlabBlock(FabricBlockSettings.copyOf(ModBlocks.CERAMIC_TILES)));
    public static final Block FERMENTATION_VESSEL = registerBlock("fermentation_vessel", new FermentationVesselBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).instrument(Instrument.BASEDRUM).requiresTool().nonOpaque().sounds(BlockSoundGroup.DECORATED_POT)));
    public static final Block FULL_FERMENTATION_VESSEL = registerBlockNoItem("full_fermentation_vessel", new FullFermentationVesselBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).instrument(Instrument.BASEDRUM).requiresTool().nonOpaque().ticksRandomly().sounds(BlockSoundGroup.DECORATED_POT)));
    public static final Block APPLE_BLOCK = registerBlock("apple_block", new FruitBlock(FabricBlockSettings.create().mapColor(MapColor.RED).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block EATEN_APPLE_BLOCK = registerBlockNoItem("eaten_apple_block", new EatenFruitBlock(FabricBlockSettings.create().mapColor(MapColor.RED).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block GIANT_ORANGE_BLOCK = registerBlock("giant_orange_block", new FruitBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block GIANT_LEMON_BLOCK = registerBlock("giant_lemon_block", new PillarBlock(FabricBlockSettings.create().mapColor(MapColor.YELLOW).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block GIANT_PLUM_BLOCK = registerBlock("giant_plum_block", new FruitBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_DULL_PINK).strength(0.5f).instrument(Instrument.DIDGERIDOO).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block TEA_SHRUB = registerBlockNoItem("tea_shrub", new TeaShrubBlock(FabricBlockSettings.create().nonOpaque().strength(0.5f).ticksRandomly().noCollision().mapColor(MapColor.GREEN).sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHAMOMILE_FLOWERS = registerBlock("chamomile_flowers", new ChamomileFlowersBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).noCollision().sounds(BlockSoundGroup.PINK_PETALS).pistonBehavior(PistonBehavior.DESTROY)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }
    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerDyeableCeramicBlock(String name, Block block) {
        registerDyeableCeramicBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }
    private static Item registerDyeableCeramicBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new DyeableCeramicBlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BountifulCuisine.LOGGER.debug("Registering ModBlocks for " + BountifulCuisine.MOD_ID);
    }
}
