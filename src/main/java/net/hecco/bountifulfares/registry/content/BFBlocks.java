package net.hecco.bountifulfares.registry.content;

import com.google.common.collect.Maps;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.*;
import net.hecco.bountifulfares.item.custom.BlockItemWithInfo;
import net.hecco.bountifulfares.item.custom.CeramicDishBlockItem;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulfares.registry.misc.BFSaplingGenerators;
import net.hecco.bountifulfares.registry.util.BFBlockSetTypes;
import net.hecco.bountifulfares.registry.util.BFNoteBlockInstruments;
import net.hecco.bountifulfares.registry.util.BFWoodTypes;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.Map;
import java.util.function.ToIntFunction;

public class BFBlocks {
    public static final Map<Item, CropTrellisBlock> CROPS_TO_CROP_TRELLISES = Maps.newHashMap();
    public static final Map<Item, VineCrop> CROPS_TO_VINE_CROPS = Maps.newHashMap();
    public static final Map<Item, DecorativeVine> PLANTS_TO_DECORATIVE_VINES = Maps.newHashMap();
    public static final Map<Item, DecorativeTrellisBlock> PLANTS_TO_DECORATIVE_TRELLISES = Maps.newHashMap();
    public static final Map<DecorativeTrellisBlock, Item> DECORATIVE_TRELLISES_TO_PLANTS = Maps.newHashMap();
    public static final Map<Block, Block> CERAMIC_TO_CHECKERED_CERAMIC = Maps.newHashMap();

    public static final Block APPLE_LOG = registerBlock("apple_log", new FruitLogBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).nonOpaque().notSolid()));
    public static final Block APPLE_WOOD = registerBlock("apple_wood", new FruitLogBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque().notSolid()));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).nonOpaque().notSolid()));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).nonOpaque().notSolid()));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves", new AppleLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block FLOWERING_APPLE_LEAVES = registerBlock("flowering_apple_leaves", new AppleLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block HANGING_APPLE = registerBlockNoItem("hanging_apple", new HangingAppleBlock(AbstractBlock.Settings.create().mapColor(MapColor.RED).dynamicBounds().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly().offset(AbstractBlock.OffsetType.XZ)));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling", new SaplingBlock(BFSaplingGenerators.APPLE_SAPLING_GENERATOR, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING)));
    public static final Block POTTED_APPLE_SAPLING = registerBlockNoItem("potted_apple_sapling", new FlowerPotBlock(BFBlocks.APPLE_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block ORANGE_LOG = registerBlock("orange_log", new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG)));
    public static final Block ORANGE_WOOD = registerBlock("orange_wood", new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block ORANGE_LEAVES = registerBlock("orange_leaves", new OrangeLeavesBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_ORANGE_LEAVES = registerBlock("flowering_orange_leaves", new OrangeLeavesBlock(AbstractBlock.Settings.copy(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_ORANGE = registerBlockNoItem("hanging_orange", new HangingOrangeBlock(AbstractBlock.Settings.copy(BFBlocks.HANGING_APPLE)));
    public static final Block ORANGE_SAPLING = registerBlock("orange_sapling", new SaplingBlock(BFSaplingGenerators.ORANGE_SAPLING_GENERATOR, AbstractBlock.Settings.copy(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_ORANGE_SAPLING = registerBlockNoItem("potted_orange_sapling", new FlowerPotBlock(BFBlocks.ORANGE_SAPLING, AbstractBlock.Settings.copy(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block LEMON_LOG = registerBlock("lemon_log", new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new LemonLeavesBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_LEMON_LEAVES = registerBlock("flowering_lemon_leaves", new LemonLeavesBlock(AbstractBlock.Settings.copy(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_LEMON = registerBlockNoItem("hanging_lemon", new HangingLemonBlock(AbstractBlock.Settings.copy(BFBlocks.HANGING_APPLE)));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", new SaplingBlock(BFSaplingGenerators.LEMON_SAPLING_GENERATOR, AbstractBlock.Settings.copy(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_LEMON_SAPLING = registerBlockNoItem("potted_lemon_sapling", new FlowerPotBlock(BFBlocks.LEMON_SAPLING, AbstractBlock.Settings.copy(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block PLUM_LOG = registerBlock("plum_log", new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG)));
    public static final Block PLUM_WOOD = registerBlock("plum_wood", new FruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block PLUM_LEAVES = registerBlock("plum_leaves", new PlumLeavesBlock(BFBlocks.HANGING_PLUM, AbstractBlock.Settings.copy(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_PLUM_LEAVES = registerBlock("flowering_plum_leaves", new PlumLeavesBlock(BFBlocks.HANGING_PLUM, AbstractBlock.Settings.copy(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_PLUM = registerBlockNoItem("hanging_plum", new HangingPlumBlock(AbstractBlock.Settings.copy(BFBlocks.HANGING_APPLE)));
    public static final Block PLUM_SAPLING = registerBlock("plum_sapling", new SaplingBlock(BFSaplingGenerators.PLUM_SAPLING_GENERATOR, AbstractBlock.Settings.copy(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_PLUM_SAPLING = registerBlockNoItem("potted_plum_sapling", new FlowerPotBlock(BFBlocks.PLUM_SAPLING, AbstractBlock.Settings.copy(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block HOARY_APPLE_SAPLING_CROP = registerBlockNoItem("hoary_apple_sapling_crop", new HoaryAppleSaplingCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HOARY_APPLE_SAPLING = registerBlock("hoary_apple_sapling", new SaplingBlock(BFSaplingGenerators.HOARY_SAPLING_GENERATOR, AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CHERRY_SAPLING).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_HOARY_APPLE_SAPLING = registerBlockNoItem("potted_hoary_apple_sapling", new FlowerPotBlock(BFBlocks.HOARY_APPLE_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block HOARY_LOG = registerBlock("hoary_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WOOD = registerBlock("hoary_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_LOG = registerBlock("stripped_hoary_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_WOOD = registerBlock("stripped_hoary_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_PLANKS = registerBlock("hoary_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_STAIRS = registerBlock("hoary_stairs", new ModStairsBlock(BFBlocks.HOARY_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_SLAB = registerBlock("hoary_slab", new SlabBlock(AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_FENCE = registerBlock("hoary_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_FENCE_GATE = registerBlock("hoary_fence_gate", new ModFenceGateBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFWoodTypes.HOARY));
    public static final Block HOARY_DOOR = registerBlock("hoary_door", new DoorBlock(BFBlockSetTypes.HOARY, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_TRAPDOOR = registerBlock("hoary_trapdoor", new ModTrapdoorBlock(AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFBlockSetTypes.HOARY));
    public static final Block HOARY_PRESSURE_PLATE = registerBlock("hoary_pressure_plate", new PressurePlateBlock(BFBlockSetTypes.HOARY, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5f, 5.0f)));
    public static final Block HOARY_BUTTON = registerBlock("hoary_button", new ButtonBlock(BFBlockSetTypes.HOARY, 30, AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS).noCollision().strength(0.5f, 5f)));
    public static final Block HOARY_SIGN = registerBlockNoItem("hoary_sign", new ModStandingSignBlock(BFWoodTypes.HOARY, AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WALL_SIGN = registerBlockNoItem("hoary_wall_sign", new ModWallSignBlock(BFWoodTypes.HOARY, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_HANGING_SIGN = registerBlockNoItem("hoary_hanging_sign", new ModHangingSignBlock(BFWoodTypes.HOARY, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WALL_HANGING_SIGN = registerBlockNoItem("hoary_wall_hanging_sign", new ModWallHangingSignBlock(BFWoodTypes.HOARY, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_LEAVES = registerBlock("hoary_leaves", new HoaryLeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block HANGING_HOARY_APPLE = registerBlockNoItem("hanging_hoary_apple", new HangingHoaryAppleBlock(AbstractBlock.Settings.copy(BFBlocks.HANGING_APPLE)));

    public static final Block WALNUT_SAPLING = registerBlock("walnut_sapling", new SaplingBlock(BFSaplingGenerators.WALNUT_SAPLING_GENERATOR, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_WALNUT_SAPLING = registerBlockNoItem("potted_walnut_sapling", new FlowerPotBlock(BFBlocks.WALNUT_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_POPPY)));
    public static final Block WALNUT_LOG = registerBlock("walnut_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_WOOD = registerBlock("walnut_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.BROWN)));
    public static final Block STRIPPED_WALNUT_LOG = registerBlock("stripped_walnut_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.BROWN)));
    public static final Block STRIPPED_WALNUT_WOOD = registerBlock("stripped_walnut_wood", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_PLANKS = registerBlock("walnut_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_STAIRS = registerBlock("walnut_stairs", new ModStairsBlock(BFBlocks.WALNUT_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_SLAB = registerBlock("walnut_slab", new SlabBlock(AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_FENCE = registerBlock("walnut_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_FENCE_GATE = registerBlock("walnut_fence_gate", new ModFenceGateBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.BROWN), BFWoodTypes.WALNUT));
    public static final Block WALNUT_DOOR = registerBlock("walnut_door", new DoorBlock(BFBlockSetTypes.WALNUT, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_TRAPDOOR = registerBlock("walnut_trapdoor", new ModTrapdoorBlock(AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.BROWN), BFBlockSetTypes.WALNUT));
    public static final Block WALNUT_PRESSURE_PLATE = registerBlock("walnut_pressure_plate", new PressurePlateBlock(BFBlockSetTypes.WALNUT, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.BROWN).strength(0.5f, 5.0f)));
    public static final Block WALNUT_BUTTON = registerBlock("walnut_button", new ButtonBlock(BFBlockSetTypes.WALNUT, 30, AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS).mapColor(MapColor.BROWN).noCollision().strength(0.5f, 5f)));
    public static final Block WALNUT_SIGN = registerBlockNoItem("walnut_sign", new ModStandingSignBlock(BFWoodTypes.WALNUT, AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_WALL_SIGN = registerBlockNoItem("walnut_wall_sign", new ModWallSignBlock(BFWoodTypes.WALNUT, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_HANGING_SIGN = registerBlockNoItem("walnut_hanging_sign", new ModHangingSignBlock(BFWoodTypes.WALNUT, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_WALL_HANGING_SIGN = registerBlockNoItem("walnut_wall_hanging_sign", new ModWallHangingSignBlock(BFWoodTypes.WALNUT, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_LEAVES = registerBlock("walnut_leaves", new WalnutLeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block WALNUT_MULCH = registerBlock("walnut_mulch", new MulchBlock(AbstractBlock.Settings.create().notSolid().mapColor(MapColor.BROWN).notSolid().strength(0.4f).sounds(BlockSoundGroup.ROOTED_DIRT).burnable()));
    public static final Block WALNUT_MULCH_BLOCK = registerBlock("walnut_mulch_block", new MulchBlockBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN).strength(0.4f).sounds(BlockSoundGroup.ROOTED_DIRT).burnable()));

    public static final Block HANGING_WALNUTS = registerBlockNoItem("hanging_walnuts", new HangingWalnutsBlock(AbstractBlock.Settings.copy(BFBlocks.HANGING_APPLE)));
    public static final Block FALLEN_WALNUTS = registerBlockNoItem("fallen_walnuts", new FallenWalnutsBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN).noCollision().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().noBlockBreakParticles()));

    public static final Block WALNUT_CANDLE = registerBlock("walnut_candle", new WalnutCandleBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PALM_SAPLING = registerBlockNoItem("palm_sapling", new PalmSaplingBlock(BFSaplingGenerators.PALM_SAPLING_GENERATOR, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CROP)));
    public static final Block PALM_LOG = registerBlock("palm_log", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_LOG)));
    public static final Block PALM_WOOD = registerBlock("palm_wood", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_PALM_LOG = registerBlock("stripped_palm_log", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood", new StrippedFruitLogBlock(AbstractBlock.Settings.copy(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block PALM_CROWN = registerBlock("palm_crown", new PalmCrownBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block PALM_FROND = registerBlockNoItem("palm_frond", new PalmFrondBlock(AbstractBlock.Settings.create().noCollision().mapColor(MapColor.LIME).strength(0.2F).sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY).notSolid()));
    public static final Block POTTED_PALM_FROND = registerBlockNoItem("potted_palm_frond", new FlowerPotBlock(PALM_FROND, AbstractBlock.Settings.copy(Blocks.POTTED_POPPY)));
    public static final Block WALL_PALM_FROND = registerBlockNoItem("wall_palm_frond", new WallPalmFrondBlock(AbstractBlock.Settings.create().noCollision().mapColor(MapColor.LIME).strength(0.2F).sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY).notSolid()));
    public static final Block COCONUT = registerBlockNoItem("coconut", new CoconutBlock(AbstractBlock.Settings.create().strength(0.2f).mapColor(MapColor.BROWN).dynamicBounds().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly().nonOpaque()));
    public static final Block PALM_MULCH = registerBlock("palm_mulch", new MulchBlock(AbstractBlock.Settings.create().notSolid().mapColor(MapColor.BROWN).notSolid().strength(0.4f).sounds(BlockSoundGroup.ROOTED_DIRT).burnable()));
    public static final Block PALM_MULCH_BLOCK = registerBlock("palm_mulch_block", new MulchBlockBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN).strength(0.4f).sounds(BlockSoundGroup.ROOTED_DIRT).burnable()));
    public static final Block COCONUT_CAKE = registerBlockUnstackableItem("coconut_cake", new NoCandleCakeBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PACKED_COCONUT_COIR = registerBlock("packed_coconut_coir", new Block(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 1.0F).sounds(BFSounds.COIR)));
    public static final Block COIR_CARPET = registerBlock("coir_carpet", new CarpetBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).mapColor(MapColor.OAK_TAN).sounds(BFSounds.COIR)));
    public static final Block COIR_BRICKS = registerBlock("coir_bricks", new Block(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.5F, 1.0F).sounds(BlockSoundGroup.PACKED_MUD)));
    public static final Block COIR_BRICK_SLAB = registerBlock("coir_brick_slab", new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.5F, 1.0F).sounds(BlockSoundGroup.PACKED_MUD)));
    public static final Block COIR_BRICK_STAIRS = registerBlock("coir_brick_stairs", new ModStairsBlock(COIR_BRICKS.getDefaultState(), AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.5F, 1.0F).sounds(BlockSoundGroup.PACKED_MUD)));
    public static final Block COIR_BRICK_WALL = registerBlock("coir_brick_wall", new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.5F, 1.0F).sounds(BlockSoundGroup.PACKED_MUD)));
    public static final Block COCONUT_CANDLE = registerBlock("coconut_candle", new CoconutCandleBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block WILD_WHEAT = registerBlock("wild_wheat", new WildCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_CARROTS = registerBlock("wild_carrots", new WildCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_POTATOES = registerBlock("wild_potatoes", new WildCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_BEETROOTS = registerBlock("wild_beetroots", new WildCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_LEEKS = registerBlock("wild_leeks", new WildCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_MAIZE = registerBlock("wild_maize", new WildMaizeBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_PASSION_FRUIT_VINE = registerBlock("wild_passion_fruit_vine", new WildVineCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_ELDERBERRY_VINE = registerBlock("wild_elderberry_vine", new WildVineCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FELDSPAR_BLOCK = registerBlock("feldspar_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f).sounds(BlockSoundGroup.TUFF)));
    public static final Block CUT_FELDSPAR_BLOCK = registerBlock("cut_feldspar_block", new Block(AbstractBlock.Settings.copy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICKS = registerBlock("feldspar_bricks", new Block(AbstractBlock.Settings.copy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_STAIRS = registerBlock("feldspar_brick_stairs", new ModStairsBlock(BFBlocks.FELDSPAR_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_SLAB = registerBlock("feldspar_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_LANTERN = registerBlock("feldspar_lantern", new FeldsparLanternBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance(state -> 8).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TINGED_GLASS = registerBlock("tinged_glass", new TingedGlassBlock(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block CERAMIC_CLAY_BLOCK = registerBlock("ceramic_clay_block", new Block(AbstractBlock.Settings.copy(Blocks.CLAY).instrument(NoteBlockInstrument.FLUTE).mapColor(MapColor.WHITE)));
    public static final Block CERAMIC_TILES = registerDyeableCeramicBlock("ceramic_tiles", new CeramicTilesBlock(AbstractBlock.Settings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(BFSounds.CERAMIC_TILES).instrument(BFNoteBlockInstruments.OCARINA).mapColor(MapColor.OFF_WHITE)));
    public static final Block CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("ceramic_tile_stairs", new CeramicTileStairsBlock(BFBlocks.CERAMIC_TILES.getDefaultState(), AbstractBlock.Settings.copy(BFBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("ceramic_tile_slab", new CeramicTileSlabBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_TILES)));
    public static final Block CRACKED_CERAMIC_TILES = registerDyeableCeramicBlock("cracked_ceramic_tiles", new CeramicTilesBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILES = registerDyeableCeramicBlock("checkered_ceramic_tiles", new CeramicTilesBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("checkered_ceramic_tile_stairs", new CeramicTileStairsBlock(BFBlocks.CHECKERED_CERAMIC_TILES.getDefaultState(), AbstractBlock.Settings.copy(BFBlocks.CHECKERED_CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("checkered_ceramic_tile_slab", new CeramicTileSlabBlock(AbstractBlock.Settings.copy(BFBlocks.CHECKERED_CERAMIC_TILES)));
    public static final Block CRACKED_CHECKERED_CERAMIC_TILES = registerDyeableCeramicBlock("cracked_checkered_ceramic_tiles", new CeramicTilesBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_TILE_PILLAR = registerDyeableCeramicBlock("ceramic_tile_pillar", new CeramicTilePillarBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_MOSAIC = registerDyeableCeramicBlock("ceramic_mosaic", new CeramicTilesBlock(AbstractBlock.Settings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(BFSounds.CERAMIC_TILES).instrument(BFNoteBlockInstruments.OCARINA).mapColor(MapColor.OFF_WHITE)));
    public static final Block CERAMIC_MOSAIC_STAIRS = registerDyeableCeramicBlock("ceramic_mosaic_stairs", new CeramicTileStairsBlock(BFBlocks.CERAMIC_MOSAIC.getDefaultState(), AbstractBlock.Settings.copy(BFBlocks.CERAMIC_MOSAIC)));
    public static final Block CERAMIC_MOSAIC_SLAB = registerDyeableCeramicBlock("ceramic_mosaic_slab", new CeramicTileSlabBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_MOSAIC)));
    public static final Block CHECKERED_CERAMIC_MOSAIC = registerDyeableCeramicBlock("checkered_ceramic_mosaic", new CeramicTilesBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_MOSAIC)));
    public static final Block CHECKERED_CERAMIC_MOSAIC_STAIRS = registerDyeableCeramicBlock("checkered_ceramic_mosaic_stairs", new CeramicTileStairsBlock(BFBlocks.CHECKERED_CERAMIC_MOSAIC.getDefaultState(), AbstractBlock.Settings.copy(BFBlocks.CHECKERED_CERAMIC_MOSAIC)));
    public static final Block CHECKERED_CERAMIC_MOSAIC_SLAB = registerDyeableCeramicBlock("checkered_ceramic_mosaic_slab", new CeramicTileSlabBlock(AbstractBlock.Settings.copy(BFBlocks.CHECKERED_CERAMIC_MOSAIC)));

    public static final Block CERAMIC_PRESSURE_PLATE = registerDyeableCeramicBlock("ceramic_pressure_plate", new CeramicPressurePlateBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), BFBlockSetTypes.CERAMIC));
    public static final Block CERAMIC_BUTTON = registerDyeableCeramicBlock("ceramic_button", new CeramicButtonBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), BFBlockSetTypes.CERAMIC, 10, true));
    public static final Block CERAMIC_LEVER = registerDyeableCeramicBlock("ceramic_lever", new CeramicLeverBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CERAMIC_DISH = registerCeramicDishBlock("ceramic_dish", new CeramicDishBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).sounds(BFSounds.CERAMIC_DECORATION).strength(0.2F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CERAMIC_DOOR = registerDyeableCeramicBlock("ceramic_door", new CeramicDoorBlock(AbstractBlock.Settings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).mapColor(MapColor.OFF_WHITE), BFBlockSetTypes.CERAMIC));
    public static final Block CERAMIC_TRAPDOOR = registerDyeableCeramicBlock("ceramic_trapdoor", new CeramicTrapdoorBlock(AbstractBlock.Settings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).mapColor(MapColor.OFF_WHITE), BFBlockSetTypes.CERAMIC));


    public static final Block FERMENTATION_VESSEL = registerBlock("fermentation_vessel", new FermentationVesselBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).instrument(BFNoteBlockInstruments.OCARINA).requiresTool().nonOpaque().sounds(BFSounds.CERAMIC_DECORATION)));
    public static final Block APPLE_BLOCK = registerBlock("apple_block", new AppleBlock(AbstractBlock.Settings.create().mapColor(MapColor.RED).strength(1f).instrument(NoteBlockInstrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GOLDEN_APPLE_BLOCK = registerBlock("golden_apple_block", new GoldenAppleBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(1f).instrument(NoteBlockInstrument.DIDGERIDOO).sounds(BlockSoundGroup.METAL).pistonBehavior(PistonBehavior.DESTROY)), Rarity.EPIC);
    public static final Block ORANGE_BLOCK = registerBlock("orange_block", new OrangeBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).strength(0.5f).instrument(NoteBlockInstrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD)));
    public static final Block LEMON_BLOCK = registerBlock("lemon_block", new LemonBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW).strength(0.5f).instrument(NoteBlockInstrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD)));
    public static final Block PLUM_BLOCK = registerBlock("plum_block", new PlumBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_DULL_PINK).strength(0.5f).instrument(NoteBlockInstrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD)));
    public static final Block HOARY_APPLE_BLOCK = registerBlock("hoary_apple_block", new HoaryAppleBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5f).instrument(BFNoteBlockInstruments.OLD_PIANO).sounds(BlockSoundGroup.WOOD)));
    public static final Block LEEKS = registerBlockNoItem("leeks", new LeekCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MAIZE_CROP = registerBlockNoItem("maize_crop", new MaizeCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SPONGEKIN_SPROUT = registerBlock("spongekin_sprout", new SpongekinSproutBlock(AbstractBlock.Settings.create().mapColor(MapColor.WATER_BLUE).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SPONGEKIN_STEM = registerBlockNoItem("spongekin_stem", new SpongekinStemBlock(AbstractBlock.Settings.create().mapColor(MapColor.WATER_BLUE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SPONGEKIN = registerBlock("spongekin", new SpongekinBlock(AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).instrument(BFNoteBlockInstruments.STEEL_DRUM).strength(1.0f).sounds(BFSounds.SPONGEKIN).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PRISMARINE_BLOSSOM = registerBlock("prismarine_blossom", new PrismarineBlossomBlock(AbstractBlock.Settings.create().mapColor(MapColor.CYAN).ticksRandomly().strength(0.4f).nonOpaque().noCollision().sounds(BlockSoundGroup.CALCITE).luminance(state -> state.get(Properties.WATERLOGGED) ? 12 : 0).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SCORCHKIN_STEM = registerBlockNoItem("scorchkin_stem", new ScorchkinStemBlock(AbstractBlock.Settings.create().mapColor(MapColor.CLEAR).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.NETHER_WART).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SCORCHKIN = registerBlock("scorchkin", new Block(AbstractBlock.Settings.create().mapColor(MapColor.GRAY).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0f).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TEA_SHRUB = registerBlockNoItem("tea_shrub", new TeaShrubBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.5f).ticksRandomly().noCollision().mapColor(MapColor.GREEN).sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHAMOMILE_FLOWERS = registerBlock("chamomile_flowers", new ChamomileFlowersBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).noCollision().sounds(BlockSoundGroup.PINK_PETALS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HONEYSUCKLE = registerBlock("honeysuckle", new TeaFlowerBlock(StatusEffects.REGENERATION, 5, AbstractBlock.Settings.copy(Blocks.POPPY)));
    public static final Block POTTED_HONEYSUCKLE = registerBlockNoItem("potted_honeysuckle", new FlowerPotBlock(BFBlocks.HONEYSUCKLE, AbstractBlock.Settings.copy(Blocks.POTTED_POPPY)));
    public static final Block VIOLET_BELLFLOWER = registerBlock("violet_bellflower", new TeaFlowerBlock(StatusEffects.INVISIBILITY, 5, AbstractBlock.Settings.copy(Blocks.POPPY)));
    public static final Block POTTED_VIOLET_BELLFLOWER = registerBlockNoItem("potted_violet_bellflower", new FlowerPotBlock(BFBlocks.VIOLET_BELLFLOWER, AbstractBlock.Settings.copy(Blocks.POTTED_POPPY)));
    public static final Block WHITE_JACK_O_STRAW = registerBlock("white_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIGHT_GRAY_JACK_O_STRAW = registerBlock("light_gray_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GRAY_JACK_O_STRAW = registerBlock("gray_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLACK_JACK_O_STRAW = registerBlock("black_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BROWN_JACK_O_STRAW = registerBlock("brown_jack_o_straw", new BrownJackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block RED_JACK_O_STRAW = registerBlock("red_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ORANGE_JACK_O_STRAW = registerBlock("orange_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block YELLOW_JACK_O_STRAW = registerBlock("yellow_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIME_JACK_O_STRAW = registerBlock("lime_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GREEN_JACK_O_STRAW = registerBlock("green_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CYAN_JACK_O_STRAW = registerBlock("cyan_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIGHT_BLUE_JACK_O_STRAW = registerBlock("light_blue_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLUE_JACK_O_STRAW = registerBlock("blue_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PURPLE_JACK_O_STRAW = registerBlock("purple_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MAGENTA_JACK_O_STRAW = registerBlock("magenta_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PINK_JACK_O_STRAW = registerBlock("pink_jack_o_straw", new JackOStrawBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block GRISTMILL = registerBlock("gristmill", new GristmillBlock(AbstractBlock.Settings.create().hardness(2.5f).instrument(NoteBlockInstrument.DIDGERIDOO).mapColor(MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD)));
    public static final Block GREEN_TEA_CANDLE = registerBlock("green_tea_candle", new GreenTeaCandleBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLACK_TEA_CANDLE = registerBlock("black_tea_candle", new BlackTeaCandleBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHAMOMILE_CANDLE = registerBlock("chamomile_candle", new ChamomileCandleBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HONEYSUCKLE_CANDLE = registerBlock("honeysuckle_candle", new HoneysuckleCandleBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BELLFLOWER_CANDLE = registerBlock("bellflower_candle", new BellflowerCandleBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TORCHFLOWER_CANDLE = registerBlock("torchflower_candle", new TorchflowerCandleBlock(AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PASSION_FRUIT_TART = registerBlock16StackItem("passion_fruit_tart", new TartBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ELDERBERRY_TART = registerBlock16StackItem("elderberry_tart", new TartBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GLOW_BERRY_TART = registerBlock16StackItem("glow_berry_tart", new TartBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LAPISBERRY_TART = registerBlock16StackItem("lapisberry_tart", new TartBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SWEET_BERRY_TART = registerBlock16StackItem("sweet_berry_tart", new TartBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block APPLE_PIE = registerBlock16StackItem("apple_pie", new PieBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ORANGE_PIE = registerBlock16StackItem("orange_pie", new PieBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LEMON_PIE = registerBlock16StackItem("lemon_pie", new PieBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PLUM_PIE = registerBlock16StackItem("plum_pie", new PieBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HOARY_PIE = registerBlock16StackItem("hoary_pie", new PieBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PUMPKIN_PIE = registerBlockNoItem("pumpkin_pie", new PieBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MELON_PIE = registerBlock16StackItem("melon_pie", new PieBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block COCOA_CAKE = registerBlockUnstackableItem("cocoa_cake", new NoCandleCakeBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SPONGE_CAKE = registerBlockUnstackableItem("sponge_cake", new SpongeCakeBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY).luminance((state) -> state.get(SpongeCakeBlock.PICKLED) && state.get(Properties.BITES) == 0 ? 5 : 0)));
    public static final Block ARTISAN_BREAD = registerBlock16StackItem("artisan_bread", new ArtisanBreadBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ARTISAN_COOKIES = registerBlockNoItem("artisan_cookies", new ArtisanCookiesBlock(AbstractBlock.Settings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));

    public static Block OAK_PICKETS = registerBlock("oak_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block SPRUCE_PICKETS = registerBlock("spruce_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block BIRCH_PICKETS = registerBlock("birch_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block JUNGLE_PICKETS = registerBlock("jungle_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block ACACIA_PICKETS = registerBlock("acacia_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block DARK_OAK_PICKETS = registerBlock("dark_oak_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block MANGROVE_PICKETS = registerBlock("mangrove_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block CHERRY_PICKETS = registerBlock("cherry_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block BAMBOO_PICKETS = registerBlock("bamboo_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block WALNUT_PICKETS = registerBlock("walnut_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block HOARY_PICKETS = registerBlock("hoary_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block CRIMSON_PICKETS = registerBlock("crimson_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block WARPED_PICKETS = registerBlock("warped_pickets", new PicketsBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).notSolid().nonOpaque()));
    public static Block IRON_RAILING = registerBlock("iron_railing", new PicketsBlock(AbstractBlock.Settings.create().mapColor(MapColor.CLEAR).strength(1.0F, 2.0f).sounds(BlockSoundGroup.METAL).notSolid().nonOpaque()));

    public static Block GRASSY_DIRT = registerBlock("grassy_dirt", new GrassyDirtBlock(AbstractBlock.Settings.copy(Blocks.DIRT).ticksRandomly()));


    public static final Block GOLDEN_APPLE_LOG = registerBlock("golden_apple_log", new FruitLogBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).nonOpaque().notSolid()), Rarity.UNCOMMON);
    public static final Block GOLDEN_APPLE_WOOD = registerBlock("golden_apple_wood", new FruitLogBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque().notSolid()), Rarity.UNCOMMON);
    public static final Block GOLDEN_APPLE_LEAVES = registerBlock("golden_apple_leaves", new GoldenAppleLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.GOLD)), Rarity.UNCOMMON);
    public static final Block FLOWERING_GOLDEN_APPLE_LEAVES = registerBlock("flowering_golden_apple_leaves", new GoldenAppleLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.GOLD)), Rarity.UNCOMMON);
    public static final Block GOLDEN_APPLE_SAPLING = registerBlock("golden_apple_sapling", new SaplingBlock(BFSaplingGenerators.GOLDEN_APPLE_SAPLING_GENERATOR, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).luminance(state -> 7)), Rarity.RARE);
    public static final Block POTTED_GOLDEN_APPLE_SAPLING = registerBlockNoItem("potted_golden_apple_sapling", new FlowerPotBlock(BFBlocks.GOLDEN_APPLE_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING).luminance(state -> 7)));
    public static final Block HANGING_GOLDEN_APPLE = registerBlockNoItem("hanging_golden_apple", new HangingGoldenAppleBlock(AbstractBlock.Settings.create().mapColor(MapColor.GOLD).dynamicBounds().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly().offset(AbstractBlock.OffsetType.XZ).luminance((state) -> 7)));
    public static final Block HANGING_WITHERED_GOLDEN_APPLE = registerBlockNoItem("hanging_withered_golden_apple", new HangingWitheredGoldenAppleBlock(AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLACK).dynamicBounds().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).offset(AbstractBlock.OffsetType.XZ)));



    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }

    public static ToIntFunction<BlockState> createLightLevelFromAgeBlockState(int lit1, int lit2, int lit3) {
        return state -> state.get(CropTrellisBlock.AGE) == 1 ? lit1 : state.get(CropTrellisBlock.AGE) == 2 ? lit2 : state.get(CropTrellisBlock.AGE) == 3 ? lit3 : 0;
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BountifulFares.MOD_ID, name), block);
    }

    public static Block registerBlock(String name, Block block, Rarity rarity) {
        registerBlockItem(name, block, rarity);
        return Registry.register(Registries.BLOCK, Identifier.of(BountifulFares.MOD_ID, name), block);
    }

    private static Block registerBlockWithInfo(String name, Block block) {
        registerBlockItemWithInfo(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BountifulFares.MOD_ID, name), block);
    }

    private static void registerBlockItemWithInfo(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BountifulFares.MOD_ID, name), new BlockItemWithInfo(block, new Item.Settings()));
    }

    private static Block registerBlockUnstackableItem(String name, Block block) {
        registerUnstackableBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BountifulFares.MOD_ID, name), block);
    }

    private static Block registerBlock16StackItem(String name, Block block) {
        register16StackItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BountifulFares.MOD_ID, name), block);
    }
    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(BountifulFares.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BountifulFares.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    private static void registerBlockItem(String name, Block block, Rarity rarity) {
        Registry.register(Registries.ITEM, Identifier.of(BountifulFares.MOD_ID, name), new BlockItem(block, new Item.Settings().rarity(rarity)));
    }

    private static void register16StackItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BountifulFares.MOD_ID, name), new BlockItem(block, new Item.Settings().maxCount(16)));
    }

    private static void registerUnstackableBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BountifulFares.MOD_ID, name), new BlockItem(block, new Item.Settings().maxCount(1)));
    }

    private static Block registerDyeableCeramicBlock(String name, Block block) {
        registerDyeableCeramicBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BountifulFares.MOD_ID, name), block);
    }
    private static void registerDyeableCeramicBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BountifulFares.MOD_ID, name), new DyeableCeramicBlockItem(block, new Item.Settings()));
    }

    private static Block registerCeramicDishBlock(String name, Block block) {
        registerCeramicDishBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BountifulFares.MOD_ID, name), block);
    }
    private static void registerCeramicDishBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BountifulFares.MOD_ID, name), new CeramicDishBlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
    }
}
