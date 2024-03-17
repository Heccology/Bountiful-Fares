package net.hecco.bountifulcuisine.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.custom.*;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.item.custom.CeramicDishBlockItem;
import net.hecco.bountifulcuisine.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulcuisine.sounds.ModSounds;
import net.hecco.bountifulcuisine.util.ModBlockSetTypes;
import net.hecco.bountifulcuisine.util.ModWoodTypes;
import net.hecco.bountifulcuisine.world.tree.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final Block APPLE_LOG = registerBlock("apple_log", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.FLOWERING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block APPLE_WOOD = registerBlock("apple_wood", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.FLOWERING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.FLOWERING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.FLOWERING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves", new AppleLeavesBlock(ModBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block FLOWERING_APPLE_LEAVES = registerBlock("flowering_apple_leaves", new AppleLeavesBlock(ModBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block HANGING_APPLE = registerBlockNoItem("hanging_apple", new HangingAppleBlock(FabricBlockSettings.create().mapColor(MapColor.RED).dynamicBounds().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly().offset(AbstractBlock.OffsetType.XZ)));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling", new SaplingBlock(ModSaplingGenerators.APPLE, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING)));
    public static final Block POTTED_APPLE_SAPLING = registerBlockNoItem("potted_apple_sapling", new FlowerPotBlock(ModBlocks.APPLE_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
    public static final Block ORANGE_LOG = registerBlock("orange_log", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.FLOWERING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block ORANGE_WOOD = registerBlock("orange_wood", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.FLOWERING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.FLOWERING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.FLOWERING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block ORANGE_LEAVES = registerBlock("orange_leaves", new OrangeLeavesBlock(ModBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_ORANGE_LEAVES = registerBlock("flowering_orange_leaves", new OrangeLeavesBlock(ModBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(ModBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_ORANGE = registerBlockNoItem("hanging_orange", new HangingOrangeBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block ORANGE_SAPLING = registerBlock("orange_sapling", new SaplingBlock(ModSaplingGenerators.ORANGE, FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block POTTED_ORANGE_SAPLING = registerBlockNoItem("potted_orange_sapling", new FlowerPotBlock(ModBlocks.ORANGE_SAPLING, FabricBlockSettings.copyOf(ModBlocks.POTTED_APPLE_SAPLING)));
    public static final Block LEMON_LOG = registerBlock("lemon_log", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.FLOWERING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.FLOWERING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.FLOWERING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new LemonLogBlock(ModBlocks.LEMON_LEAVES, ModBlocks.FLOWERING_LEMON_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new LemonLeavesBlock(ModBlocks.HANGING_LEMON, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_LEMON_LEAVES = registerBlock("flowering_lemon_leaves", new LemonLeavesBlock(ModBlocks.HANGING_LEMON, FabricBlockSettings.copyOf(ModBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_LEMON = registerBlockNoItem("hanging_lemon", new HangingLemonBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", new SaplingBlock(ModSaplingGenerators.LEMON, FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block POTTED_LEMON_SAPLING = registerBlockNoItem("potted_lemon_sapling", new FlowerPotBlock(ModBlocks.LEMON_SAPLING, FabricBlockSettings.copyOf(ModBlocks.POTTED_APPLE_SAPLING)));
    public static final Block PLUM_LOG = registerBlock("plum_log", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.FLOWERING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block PLUM_WOOD = registerBlock("plum_wood", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.FLOWERING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.FLOWERING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood", new PlumLogBlock(ModBlocks.PLUM_LEAVES, ModBlocks.FLOWERING_PLUM_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block PLUM_LEAVES = registerBlock("plum_leaves", new PlumLeavesBlock(ModBlocks.HANGING_PLUM, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_PLUM_LEAVES = registerBlock("flowering_plum_leaves", new PlumLeavesBlock(ModBlocks.HANGING_PLUM, FabricBlockSettings.copyOf(ModBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_PLUM = registerBlockNoItem("hanging_plum", new HangingPlumBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block PLUM_SAPLING = registerBlock("plum_sapling", new SaplingBlock(ModSaplingGenerators.PLUM, FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));
    public static final Block POTTED_PLUM_SAPLING = registerBlockNoItem("potted_plum_sapling", new FlowerPotBlock(ModBlocks.PLUM_SAPLING, FabricBlockSettings.copyOf(ModBlocks.POTTED_APPLE_SAPLING)));
    public static final Block HOARY_APPLE_SAPLING_CROP = registerBlockNoItem("hoary_apple_sapling_crop", new HoaryAppleSaplingCropBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HOARY_APPLE_SAPLING = registerBlock("hoary_apple_sapling", new SaplingBlock(ModSaplingGenerators.HOARY, FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CHERRY_SAPLING).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_HOARY_APPLE_SAPLING = registerBlockNoItem("potted_hoary_apple_sapling", new FlowerPotBlock(ModBlocks.HOARY_APPLE_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
    public static final Block HOARY_LOG = registerBlock("hoary_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WOOD = registerBlock("hoary_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_LOG = registerBlock("stripped_hoary_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_WOOD = registerBlock("stripped_hoary_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_PLANKS = registerBlock("hoary_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_STAIRS = registerBlock("hoary_stairs", new ModStairsBlock(ModBlocks.HOARY_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.HOARY_PLANKS)));
    public static final Block HOARY_SLAB = registerBlock("hoary_slab", new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.HOARY_PLANKS)));
    public static final Block HOARY_FENCE = registerBlock("hoary_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_FENCE_GATE = registerBlock("hoary_fence_gate", new ModFenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_DOOR = registerBlock("hoary_door", new DoorBlock(ModBlockSetTypes.HOARY, FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_TRAPDOOR = registerBlock("hoary_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), ModBlockSetTypes.HOARY));
    public static final Block HOARY_PRESSURE_PLATE = registerBlock("hoary_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.HOARY, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5f, 5.0f)));
    public static final Block HOARY_BUTTON = registerBlock("hoary_button", new ButtonBlock(ModBlockSetTypes.HOARY, 30, AbstractBlock.Settings.copy(ModBlocks.HOARY_PLANKS).noCollision().strength(0.5f, 5f)));
    public static final Block HOARY_SIGN = registerBlockNoItem("hoary_sign", new ModStandingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_WALL_SIGN = registerBlockNoItem("hoary_wall_sign", new ModWallSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_HANGING_SIGN = registerBlockNoItem("hoary_hanging_sign", new ModHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_WALL_HANGING_SIGN = registerBlockNoItem("hoary_wall_hanging_sign", new ModWallHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), ModWoodTypes.HOARY));
    public static final Block HOARY_LEAVES = registerBlock("hoary_leaves", new HoaryLeavesBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block HANGING_HOARY_APPLE = registerBlockNoItem("hanging_hoary_apple", new HangingHoaryAppleBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));

    public static final Block WALNUT_SAPLING = registerBlock("walnut_sapling", new SaplingBlock(ModSaplingGenerators.WALNUT, FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_WALNUT_SAPLING = registerBlockNoItem("potted_walnut_sapling", new FlowerPotBlock(ModBlocks.WALNUT_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block WALNUT_LOG = registerBlock("walnut_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_WOOD = registerBlock("walnut_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.BROWN)));
    public static final Block STRIPPED_WALNUT_LOG = registerBlock("stripped_walnut_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.BROWN)));
    public static final Block STRIPPED_WALNUT_WOOD = registerBlock("stripped_walnut_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_PLANKS = registerBlock("walnut_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_STAIRS = registerBlock("walnut_stairs", new ModStairsBlock(ModBlocks.WALNUT_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_SLAB = registerBlock("walnut_slab", new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_FENCE = registerBlock("walnut_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_FENCE_GATE = registerBlock("walnut_fence_gate", new ModFenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.BROWN), ModWoodTypes.WALNUT));
    public static final Block WALNUT_DOOR = registerBlock("walnut_door", new DoorBlock(ModBlockSetTypes.WALNUT, FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_TRAPDOOR = registerBlock("walnut_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.BROWN), ModBlockSetTypes.WALNUT));
    public static final Block WALNUT_PRESSURE_PLATE = registerBlock("walnut_pressure_plate", new PressurePlateBlock(ModBlockSetTypes.WALNUT, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.BROWN).strength(0.5f, 5.0f)));
    public static final Block WALNUT_BUTTON = registerBlock("walnut_button", new ButtonBlock(ModBlockSetTypes.WALNUT, 30, AbstractBlock.Settings.copy(ModBlocks.WALNUT_PLANKS).mapColor(MapColor.BROWN).noCollision().strength(0.5f, 5f)));
    public static final Block WALNUT_SIGN = registerBlockNoItem("walnut_sign", new ModStandingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN), ModWoodTypes.WALNUT));
    public static final Block WALNUT_WALL_SIGN = registerBlockNoItem("walnut_wall_sign", new ModWallSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN), ModWoodTypes.WALNUT));
    public static final Block WALNUT_HANGING_SIGN = registerBlockNoItem("walnut_hanging_sign", new ModHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN), ModWoodTypes.WALNUT));
    public static final Block WALNUT_WALL_HANGING_SIGN = registerBlockNoItem("walnut_wall_hanging_sign", new ModWallHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN), ModWoodTypes.WALNUT));
    public static final Block WALNUT_LEAVES = registerBlock("walnut_leaves", new WalnutLeavesBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block WALNUT_MULCH = registerBlock("walnut_mulch", new WalnutMulchBlock(FabricBlockSettings.create().notSolid().mapColor(MapColor.BROWN).notSolid().strength(0.4f).sounds(BlockSoundGroup.ROOTED_DIRT).burnable()));
    public static final Block WALNUT_MULCH_BLOCK = registerBlock("walnut_mulch_block", new Block(FabricBlockSettings.create().mapColor(MapColor.BROWN).strength(0.4f).sounds(BlockSoundGroup.ROOTED_DIRT).burnable()));

    public static final Block HANGING_WALNUTS = registerBlockNoItem("hanging_walnuts", new HangingWalnutsBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block FALLEN_WALNUTS = registerBlockNoItem("fallen_walnuts", new FallenWalnutsBlock(FabricBlockSettings.create().mapColor(MapColor.BROWN).noCollision().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().noBlockBreakParticles()));

    public static final Block WALNUT_CANDLE = registerBlock("walnut_candle", new WalnutCandleBlock(FabricBlockSettings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block TRELLIS = registerBlock("trellis", new TrellisBlock(FabricBlockSettings.create().nonOpaque().strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).nonOpaque()));
    public static final Block PASSION_FRUIT_TRELLIS = registerBlockNoItem("passion_fruit_trellis", new CropTrellisBlock(ModItems.PASSION_FRUIT, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block ELDERBERRY_TRELLIS = registerBlockNoItem("elderberry_trellis", new CropTrellisBlock(ModItems.ELDERBERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block GLOW_BERRY_TRELLIS = registerBlockNoItem("glow_berry_trellis", new CropTrellisBlock(Items.GLOW_BERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block LAPISBERRY_TRELLIS = registerBlockNoItem("lapisberry_trellis", new CropTrellisBlock(ModItems.LAPISBERRY_SEEDS, ModItems.LAPISBERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block ROSE_TRELLIS = registerBlockNoItem("rose_trellis", new DecorativeTrellisBlock(Items.ROSE_BUSH, true, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block LILAC_TRELLIS = registerBlockNoItem("lilac_trellis", new DecorativeTrellisBlock(Items.LILAC, true, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block PEONY_TRELLIS = registerBlockNoItem("peony_trellis", new DecorativeTrellisBlock(Items.PEONY, true, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block SUNFLOWER_TRELLIS = registerBlockNoItem("sunflower_trellis", new DecorativeTrellisBlock(Items.SUNFLOWER, true, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block VINE_TRELLIS = registerBlockNoItem("vine_trellis", new DecorativeTrellisBlock(Items.VINE, false, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block WILD_WHEAT = registerBlock("wild_wheat", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_CARROTS = registerBlock("wild_carrots", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_POTATOES = registerBlock("wild_potatoes", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_BEETROOTS = registerBlock("wild_beetroots", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_LEEKS = registerBlock("wild_leeks", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_MAIZE = registerBlock("wild_maize", new WildMaizeBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_PASSION_FRUIT_VINE = registerBlock("wild_passion_fruit_vine", new WildVineCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_ELDERBERRY_VINE = registerBlock("wild_elderberry_vine", new WildVineCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FELDSPAR_BLOCK = registerBlock("feldspar_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BASEDRUM).strength(1.5f).sounds(BlockSoundGroup.TUFF)));
    public static final Block CUT_FELDSPAR_BLOCK = registerBlock("cut_feldspar_block", new Block(FabricBlockSettings.copyOf(ModBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICKS = registerBlock("feldspar_bricks", new Block(FabricBlockSettings.copyOf(ModBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_STAIRS = registerBlock("feldspar_brick_stairs", new ModStairsBlock(ModBlocks.FELDSPAR_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_SLAB = registerBlock("feldspar_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_LANTERN = registerBlock("feldspar_lantern", new FeldsparLanternBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance(8).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TINGED_GLASS = registerBlock("tinged_glass", new TingedGlassBlock(FabricBlockSettings.create().instrument(Instrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block CERAMIC_CLAY_BLOCK = registerBlock("ceramic_clay_block", new Block(FabricBlockSettings.copyOf(Blocks.CLAY).instrument(Instrument.FLUTE).mapColor(MapColor.WHITE)));
    public static final Block CERAMIC_TILES = registerDyeableCeramicBlock("ceramic_tiles", new CeramicTilesBlock(FabricBlockSettings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(ModSounds.CERAMIC_TILES).instrument(Instrument.HAT).mapColor(MapColor.OFF_WHITE)));
    public static final Block CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("ceramic_tile_stairs", new CeramicTileStairsBlock(ModBlocks.CERAMIC_TILES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("ceramic_tile_slab", new CeramicTileSlabBlock(FabricBlockSettings.copyOf(ModBlocks.CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILES = registerDyeableCeramicBlock("checkered_ceramic_tiles", new CheckeredCeramicTilesBlock(FabricBlockSettings.copyOf(ModBlocks.CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("checkered_ceramic_tile_stairs", new CheckeredCeramicTileStairsBlock(ModBlocks.CHECKERED_CERAMIC_TILES.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CHECKERED_CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("checkered_ceramic_tile_slab", new CheckeredCeramicTileSlabBlock(FabricBlockSettings.copyOf(ModBlocks.CHECKERED_CERAMIC_TILES)));

    public static final Block CERAMIC_PRESSURE_PLATE = registerDyeableCeramicBlock("ceramic_pressure_plate", new CeramicPressurePlateBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(ModSounds.CERAMIC_DECORATION).instrument(Instrument.HAT).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), ModBlockSetTypes.CERAMIC));
    public static final Block CERAMIC_BUTTON = registerDyeableCeramicBlock("ceramic_button", new CeramicButtonBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(ModSounds.CERAMIC_DECORATION).instrument(Instrument.HAT).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), ModBlockSetTypes.CERAMIC, 10, true));
    public static final Block CERAMIC_LEVER = registerDyeableCeramicBlock("ceramic_lever", new CeramicLeverBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(ModSounds.CERAMIC_DECORATION).instrument(Instrument.HAT).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CERAMIC_DISH = registerCeramicDishBlock("ceramic_dish", new CeramicDishBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).sounds(ModSounds.CERAMIC_DECORATION).strength(0.2F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FERMENTATION_VESSEL = registerBlock("fermentation_vessel", new FermentationVesselBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).instrument(Instrument.BASEDRUM).requiresTool().nonOpaque().sounds(ModSounds.CERAMIC_DECORATION)));
    public static final Block APPLE_BLOCK = registerBlock("apple_block", new AppleBlock(FabricBlockSettings.create().mapColor(MapColor.RED).strength(1f).instrument(Instrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GOLDEN_APPLE_BLOCK = registerBlock("golden_apple_block", new GoldenAppleBlock(FabricBlockSettings.create().mapColor(MapColor.YELLOW).strength(1f).instrument(Instrument.DIDGERIDOO).sounds(BlockSoundGroup.METAL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ORANGE_BLOCK = registerBlock("orange_block", new OrangeBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).strength(0.5f).instrument(Instrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD)));
    public static final Block LEMON_BLOCK = registerBlock("lemon_block", new LemonBlock(FabricBlockSettings.create().mapColor(MapColor.YELLOW).strength(0.5f).instrument(Instrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD)));
    public static final Block PLUM_BLOCK = registerBlock("plum_block", new PlumBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_DULL_PINK).strength(0.5f).instrument(Instrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD)));
    public static final Block HOARY_APPLE_BLOCK = registerBlock("hoary_apple_block", new HoaryAppleBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5f).instrument(Instrument.DIDGERIDOO).sounds(BlockSoundGroup.WOOD)));
    public static final Block LEEKS = registerBlockNoItem("leeks", new LeekCropBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MAIZE_CROP = registerBlockNoItem("maize_crop", new MaizeCropBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SPONGEKIN_SPROUT = registerBlock("spongekin_sprout", new SpongekinSproutBlock(FabricBlockSettings.create().mapColor(MapColor.WATER_BLUE).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SPONGEKIN_STEM = registerBlockNoItem("spongekin_stem", new SpongekinStemBlock(FabricBlockSettings.create().mapColor(MapColor.WATER_BLUE).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SPONGEKIN = registerBlock("spongekin", new SpongekinBlock(FabricBlockSettings.create().mapColor(MapColor.BRIGHT_TEAL).instrument(Instrument.DIDGERIDOO).strength(1.0f).sounds(ModSounds.SPONGEKIN).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PRISMARINE_BLOSSOM = registerBlock("prismarine_blossom", new PrismarineBlossomBlock(FabricBlockSettings.create().mapColor(MapColor.CYAN).ticksRandomly().strength(0.4f).nonOpaque().noCollision().sounds(BlockSoundGroup.CALCITE).luminance(state -> state.get(Properties.WATERLOGGED) ? 12 : 0).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TEA_SHRUB = registerBlockNoItem("tea_shrub", new TeaShrubBlock(FabricBlockSettings.create().nonOpaque().strength(0.5f).ticksRandomly().noCollision().mapColor(MapColor.GREEN).sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHAMOMILE_FLOWERS = registerBlock("chamomile_flowers", new ChamomileFlowersBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).noCollision().sounds(BlockSoundGroup.PINK_PETALS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HONEYSUCKLE = registerBlock("honeysuckle", new TeaFlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block POTTED_HONEYSUCKLE = registerBlockNoItem("potted_honeysuckle", new FlowerPotBlock(ModBlocks.HONEYSUCKLE, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block VIOLET_BELLFLOWER = registerBlock("violet_bellflower", new TeaFlowerBlock(StatusEffects.INVISIBILITY, 5, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block POTTED_VIOLET_BELLFLOWER = registerBlockNoItem("potted_violet_bellflower", new FlowerPotBlock(ModBlocks.VIOLET_BELLFLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block WHITE_JACK_O_STRAW = registerBlockUnstackableItem("white_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIGHT_GRAY_JACK_O_STRAW = registerBlockUnstackableItem("light_gray_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GRAY_JACK_O_STRAW = registerBlockUnstackableItem("gray_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLACK_JACK_O_STRAW = registerBlockUnstackableItem("black_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BROWN_JACK_O_STRAW = registerBlockUnstackableItem("brown_jack_o_straw", new BrownJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block RED_JACK_O_STRAW = registerBlockUnstackableItem("red_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ORANGE_JACK_O_STRAW = registerBlockUnstackableItem("orange_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block YELLOW_JACK_O_STRAW = registerBlockUnstackableItem("yellow_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIME_JACK_O_STRAW = registerBlockUnstackableItem("lime_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GREEN_JACK_O_STRAW = registerBlockUnstackableItem("green_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CYAN_JACK_O_STRAW = registerBlockUnstackableItem("cyan_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIGHT_BLUE_JACK_O_STRAW = registerBlockUnstackableItem("light_blue_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLUE_JACK_O_STRAW = registerBlockUnstackableItem("blue_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PURPLE_JACK_O_STRAW = registerBlockUnstackableItem("purple_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MAGENTA_JACK_O_STRAW = registerBlockUnstackableItem("magenta_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PINK_JACK_O_STRAW = registerBlockUnstackableItem("pink_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GRISTMILL = registerBlock("gristmill", new GristmillBlock(FabricBlockSettings.create().hardness(2.5f).instrument(Instrument.DIDGERIDOO).mapColor(MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD)));
    public static final Block GREEN_TEA_CANDLE = registerBlock("green_tea_candle", new GreenTeaCandleBlock(FabricBlockSettings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLACK_TEA_CANDLE = registerBlock("black_tea_candle", new BlackTeaCandleBlock(FabricBlockSettings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHAMOMILE_CANDLE = registerBlock("chamomile_candle", new ChamomileCandleBlock(FabricBlockSettings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HONEYSUCKLE_CANDLE = registerBlock("honeysuckle_candle", new HoneysuckleCandleBlock(FabricBlockSettings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BELLFLOWER_CANDLE = registerBlock("bellflower_candle", new BellflowerCandleBlock(FabricBlockSettings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TORCHFLOWER_CANDLE = registerBlock("torchflower_candle", new TorchflowerCandleBlock(FabricBlockSettings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PASSION_FRUIT_TART = registerBlock16StackItem("passion_fruit_tart", new TartBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ELDERBERRY_TART = registerBlock16StackItem("elderberry_tart", new TartBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GLOW_BERRY_TART = registerBlock16StackItem("glow_berry_tart", new TartBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LAPISBERRY_TART = registerBlock16StackItem("lapisberry_tart", new TartBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SWEET_BERRY_TART = registerBlock16StackItem("sweet_berry_tart", new TartBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block APPLE_PIE = registerBlock16StackItem("apple_pie", new PieBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ORANGE_PIE = registerBlock16StackItem("orange_pie", new PieBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LEMON_PIE = registerBlock16StackItem("lemon_pie", new PieBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PLUM_PIE = registerBlock16StackItem("plum_pie", new PieBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HOARY_PIE = registerBlock16StackItem("hoary_pie", new PieBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block COCOA_CAKE = registerBlockUnstackableItem("cocoa_cake", new CocoaCakeBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ARTISAN_BREAD = registerBlock16StackItem("artisan_bread", new ArtisanBreadBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ARTISAN_COOKIES = registerBlockNoItem("artisan_cookies", new ArtisanCookiesBlock(FabricBlockSettings.create().nonOpaque().solid().strength(0.5F).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));

//    public static Block ACORN_JACK_O_STRAW = registerBlockUnstackableItem("acorn_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block AMBER_JACK_O_STRAW = registerBlockUnstackableItem("amber_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block ARTICHOKE_JACK_O_STRAW = registerBlockUnstackableItem("artichoke_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block BANANA_JACK_O_STRAW = registerBlockUnstackableItem("banana_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block CERULEAN_JACK_O_STRAW = registerBlockUnstackableItem("cerulean_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block FUCHSIA_JACK_O_STRAW = registerBlockUnstackableItem("fuchsia_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block GRAPE_JACK_O_STRAW = registerBlockUnstackableItem("grape_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block INDIGO_JACK_O_STRAW = registerBlockUnstackableItem("indigo_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block MAROON_JACK_O_STRAW = registerBlockUnstackableItem("maroon_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block MAUVE_JACK_O_STRAW = registerBlockUnstackableItem("mauve_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block MINT_JACK_O_STRAW = registerBlockUnstackableItem("mint_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block MOLD_JACK_O_STRAW = registerBlockUnstackableItem("mold_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block NAVY_JACK_O_STRAW = registerBlockUnstackableItem("navy_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block PEACH_JACK_O_STRAW = registerBlockUnstackableItem("peach_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block PERIWINKLE_JACK_O_STRAW = registerBlockUnstackableItem("periwinkle_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block SAGE_JACK_O_STRAW = registerBlockUnstackableItem("sage_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block SAP_JACK_O_STRAW = registerBlockUnstackableItem("sap_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block SHAMROCK_JACK_O_STRAW = registerBlockUnstackableItem("shamrock_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block VELVET_JACK_O_STRAW = registerBlockUnstackableItem("velvet_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
//    public static Block VERMILION_JACK_O_STRAW = registerBlockUnstackableItem("vermilion_jack_o_straw", new ElsAndLsJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));


    public static Block OAK_PICKETS = registerBlock("oak_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.OAK_TAN).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block SPRUCE_PICKETS = registerBlock("spruce_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.SPRUCE_BROWN).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block BIRCH_PICKETS = registerBlock("birch_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.PALE_YELLOW).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block JUNGLE_PICKETS = registerBlock("jungle_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.DIRT_BROWN).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block ACACIA_PICKETS = registerBlock("acacia_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.ORANGE).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block DARK_OAK_PICKETS = registerBlock("dark_oak_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.BROWN).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block MANGROVE_PICKETS = registerBlock("mangrove_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.RED).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block CHERRY_PICKETS = registerBlock("cherry_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block BAMBOO_PICKETS = registerBlock("bamboo_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block WALNUT_PICKETS = registerBlock("walnut_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.SPRUCE_BROWN).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block HOARY_PICKETS = registerBlock("hoary_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block CRIMSON_PICKETS = registerBlock("crimson_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.DULL_PINK).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block WARPED_PICKETS = registerBlock("warped_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.DARK_AQUA).strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));

    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }

    private static Block registerBlockUnstackableItem(String name, Block block) {
        registerUnstackableBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }

    private static Block registerBlock16StackItem(String name, Block block) {
        register16StackItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }
    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static void register16StackItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new BlockItem(block, new FabricItemSettings().maxCount(16)));
    }

    private static void registerUnstackableBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new BlockItem(block, new FabricItemSettings().maxCount(1)));
    }

    private static Block registerDyeableCeramicBlock(String name, Block block) {
        registerDyeableCeramicBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }
    private static void registerDyeableCeramicBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new DyeableCeramicBlockItem(block, new FabricItemSettings()));
    }

    private static Block registerCeramicDishBlock(String name, Block block) {
        registerCeramicDishBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulCuisine.MOD_ID, name), block);
    }
    private static void registerCeramicDishBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulCuisine.MOD_ID, name), new CeramicDishBlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BountifulCuisine.LOGGER.debug("Registering ModBlocks for " + BountifulCuisine.MOD_ID);
    }
}
