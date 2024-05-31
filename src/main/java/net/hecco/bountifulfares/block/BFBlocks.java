package net.hecco.bountifulfares.block;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.*;
import net.hecco.bountifulfares.block.custom.compat.*;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.hecco.bountifulfares.item.custom.BlockItemWithInfo;
import net.hecco.bountifulfares.item.custom.CeramicDishBlockItem;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.hecco.bountifulfares.sounds.BFSounds;
import net.hecco.bountifulfares.util.BFBlockSetTypes;
import net.hecco.bountifulfares.util.BFWoodTypes;
import net.hecco.bountifulfares.world.tree.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.function.ToIntFunction;

public class BFBlocks {
    public static final Map<Item, CropTrellisBlock> CROPS_TO_CROP_TRELLISES = Maps.newHashMap();
    public static final Map<Item, VineCrop> CROPS_TO_VINE_CROPS = Maps.newHashMap();
    public static final Map<Item, DecorativeVine> PLANTS_TO_DECORATIVE_VINES = Maps.newHashMap();
    public static final Map<Item, DecorativeTrellisBlock> PLANTS_TO_DECORATIVE_TRELLISES = Maps.newHashMap();
    public static final Map<DecorativeTrellisBlock, Item> DECORATIVE_TRELLISES_TO_PLANTS = Maps.newHashMap();
    public static final Map<Block, Block> CERAMIC_TO_CHECKERED_CERAMIC = Maps.newHashMap();

    public static final Block APPLE_LOG = registerBlock("apple_log", new AppleLogBlock(BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block APPLE_WOOD = registerBlock("apple_wood", new AppleLogBlock(BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", new AppleLogBlock(BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood", new AppleLogBlock(BFBlocks.APPLE_LEAVES, BFBlocks.FLOWERING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves", new AppleLeavesBlock(BFBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block FLOWERING_APPLE_LEAVES = registerBlock("flowering_apple_leaves", new AppleLeavesBlock(BFBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block HANGING_APPLE = registerBlockNoItem("hanging_apple", new HangingAppleBlock(FabricBlockSettings.create().mapColor(MapColor.RED).dynamicBounds().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).ticksRandomly().offset(AbstractBlock.OffsetType.XZ)));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling", new SaplingBlock(new AppleSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING)));
    public static final Block POTTED_APPLE_SAPLING = registerBlockNoItem("potted_apple_sapling", new FlowerPotBlock(BFBlocks.APPLE_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
    public static final Block ORANGE_LOG = registerBlock("orange_log", new OrangeLogBlock(BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES, FabricBlockSettings.copyOf(BFBlocks.APPLE_LOG)));
    public static final Block ORANGE_WOOD = registerBlock("orange_wood", new OrangeLogBlock(BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES, FabricBlockSettings.copyOf(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log", new OrangeLogBlock(BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES, FabricBlockSettings.copyOf(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood", new OrangeLogBlock(BFBlocks.ORANGE_LEAVES, BFBlocks.FLOWERING_ORANGE_LEAVES, FabricBlockSettings.copyOf(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block ORANGE_LEAVES = registerBlock("orange_leaves", new OrangeLeavesBlock(BFBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_ORANGE_LEAVES = registerBlock("flowering_orange_leaves", new OrangeLeavesBlock(BFBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_ORANGE = registerBlockNoItem("hanging_orange", new HangingOrangeBlock(FabricBlockSettings.copyOf(BFBlocks.HANGING_APPLE)));
    public static final Block ORANGE_SAPLING = registerBlock("orange_sapling", new SaplingBlock(new OrangeSaplingGenerator(), FabricBlockSettings.copyOf(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_ORANGE_SAPLING = registerBlockNoItem("potted_orange_sapling", new FlowerPotBlock(BFBlocks.ORANGE_SAPLING, FabricBlockSettings.copyOf(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block LEMON_LOG = registerBlock("lemon_log", new LemonLogBlock(BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES, FabricBlockSettings.copyOf(BFBlocks.APPLE_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new LemonLogBlock(BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES, FabricBlockSettings.copyOf(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new LemonLogBlock(BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES, FabricBlockSettings.copyOf(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new LemonLogBlock(BFBlocks.LEMON_LEAVES, BFBlocks.FLOWERING_LEMON_LEAVES, FabricBlockSettings.copyOf(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new LemonLeavesBlock(BFBlocks.HANGING_LEMON, FabricBlockSettings.copyOf(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_LEMON_LEAVES = registerBlock("flowering_lemon_leaves", new LemonLeavesBlock(BFBlocks.HANGING_LEMON, FabricBlockSettings.copyOf(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_LEMON = registerBlockNoItem("hanging_lemon", new HangingLemonBlock(FabricBlockSettings.copyOf(BFBlocks.HANGING_APPLE)));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", new SaplingBlock(new LemonSaplingGenerator(), FabricBlockSettings.copyOf(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_LEMON_SAPLING = registerBlockNoItem("potted_lemon_sapling", new FlowerPotBlock(BFBlocks.LEMON_SAPLING, FabricBlockSettings.copyOf(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block PLUM_LOG = registerBlock("plum_log", new PlumLogBlock(BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES, FabricBlockSettings.copyOf(BFBlocks.APPLE_LOG)));
    public static final Block PLUM_WOOD = registerBlock("plum_wood", new PlumLogBlock(BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES, FabricBlockSettings.copyOf(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log", new PlumLogBlock(BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES, FabricBlockSettings.copyOf(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood", new PlumLogBlock(BFBlocks.PLUM_LEAVES, BFBlocks.FLOWERING_PLUM_LEAVES, FabricBlockSettings.copyOf(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block PLUM_LEAVES = registerBlock("plum_leaves", new PlumLeavesBlock(BFBlocks.HANGING_PLUM, FabricBlockSettings.copyOf(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_PLUM_LEAVES = registerBlock("flowering_plum_leaves", new PlumLeavesBlock(BFBlocks.HANGING_PLUM, FabricBlockSettings.copyOf(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_PLUM = registerBlockNoItem("hanging_plum", new HangingPlumBlock(FabricBlockSettings.copyOf(BFBlocks.HANGING_APPLE)));
    public static final Block PLUM_SAPLING = registerBlock("plum_sapling", new SaplingBlock(new PlumSaplingGenerator(), FabricBlockSettings.copyOf(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_PLUM_SAPLING = registerBlockNoItem("potted_plum_sapling", new FlowerPotBlock(BFBlocks.PLUM_SAPLING, FabricBlockSettings.copyOf(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block HOARY_APPLE_SAPLING_CROP = registerBlockNoItem("hoary_apple_sapling_crop", new HoaryAppleSaplingCropBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HOARY_APPLE_SAPLING = registerBlock("hoary_apple_sapling", new SaplingBlock(new HoarySaplingGenerator(), FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CHERRY_SAPLING).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_HOARY_APPLE_SAPLING = registerBlockNoItem("potted_hoary_apple_sapling", new FlowerPotBlock(BFBlocks.HOARY_APPLE_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
    public static final Block HOARY_LOG = registerBlock("hoary_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WOOD = registerBlock("hoary_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_LOG = registerBlock("stripped_hoary_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_WOOD = registerBlock("stripped_hoary_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_PLANKS = registerBlock("hoary_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_STAIRS = registerBlock("hoary_stairs", new ModStairsBlock(BFBlocks.HOARY_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_SLAB = registerBlock("hoary_slab", new SlabBlock(FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_FENCE = registerBlock("hoary_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_FENCE_GATE = registerBlock("hoary_fence_gate", new ModFenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFWoodTypes.HOARY));
    public static final Block HOARY_DOOR = registerBlock("hoary_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFBlockSetTypes.HOARY));
    public static final Block HOARY_TRAPDOOR = registerBlock("hoary_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFBlockSetTypes.HOARY));
    public static final Block HOARY_PRESSURE_PLATE = registerBlock("hoary_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5f, 5.0f), BFBlockSetTypes.HOARY));
    public static final Block HOARY_BUTTON = registerBlock("hoary_button", new ButtonBlock(AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS).noCollision().strength(0.5f, 5f), BFBlockSetTypes.HOARY, 30, true));
    public static final Block HOARY_SIGN = registerBlockNoItem("hoary_sign", new ModStandingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFWoodTypes.HOARY));
    public static final Block HOARY_WALL_SIGN = registerBlockNoItem("hoary_wall_sign", new ModWallSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFWoodTypes.HOARY));
    public static final Block HOARY_HANGING_SIGN = registerBlockNoItem("hoary_hanging_sign", new ModHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFWoodTypes.HOARY));
    public static final Block HOARY_WALL_HANGING_SIGN = registerBlockNoItem("hoary_wall_hanging_sign", new ModWallHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFWoodTypes.HOARY));
    public static final Block HOARY_LEAVES = registerBlock("hoary_leaves", new HoaryLeavesBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block HANGING_HOARY_APPLE = registerBlockNoItem("hanging_hoary_apple", new HangingHoaryAppleBlock(FabricBlockSettings.copyOf(BFBlocks.HANGING_APPLE)));

    public static final Block WALNUT_SAPLING = registerBlock("walnut_sapling", new SaplingBlock(new WalnutSaplingGenerator(), FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block POTTED_WALNUT_SAPLING = registerBlockNoItem("potted_walnut_sapling", new FlowerPotBlock(BFBlocks.WALNUT_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block WALNUT_LOG = registerBlock("walnut_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_WOOD = registerBlock("walnut_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).mapColor(MapColor.BROWN)));
    public static final Block STRIPPED_WALNUT_LOG = registerBlock("stripped_walnut_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.BROWN)));
    public static final Block STRIPPED_WALNUT_WOOD = registerBlock("stripped_walnut_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_PLANKS = registerBlock("walnut_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_STAIRS = registerBlock("walnut_stairs", new ModStairsBlock(BFBlocks.WALNUT_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_SLAB = registerBlock("walnut_slab", new SlabBlock(FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_FENCE = registerBlock("walnut_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.BROWN)));
    public static final Block WALNUT_FENCE_GATE = registerBlock("walnut_fence_gate", new ModFenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.BROWN), BFWoodTypes.WALNUT));
    public static final Block WALNUT_DOOR = registerBlock("walnut_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.BROWN), BFBlockSetTypes.WALNUT));
    public static final Block WALNUT_TRAPDOOR = registerBlock("walnut_trapdoor", new ModTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.BROWN), BFBlockSetTypes.WALNUT));
    public static final Block WALNUT_PRESSURE_PLATE = registerBlock("walnut_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.BROWN).strength(0.5f, 5.0f), BFBlockSetTypes.WALNUT));
    public static final Block WALNUT_BUTTON = registerBlock("walnut_button", new ButtonBlock(AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS).mapColor(MapColor.BROWN).noCollision().strength(0.5f, 5f), BFBlockSetTypes.WALNUT, 30, true));
    public static final Block WALNUT_SIGN = registerBlockNoItem("walnut_sign", new ModStandingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN), BFWoodTypes.WALNUT));
    public static final Block WALNUT_WALL_SIGN = registerBlockNoItem("walnut_wall_sign", new ModWallSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN), BFWoodTypes.WALNUT));
    public static final Block WALNUT_HANGING_SIGN = registerBlockNoItem("walnut_hanging_sign", new ModHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN), BFWoodTypes.WALNUT));
    public static final Block WALNUT_WALL_HANGING_SIGN = registerBlockNoItem("walnut_wall_hanging_sign", new ModWallHangingSignBlock(AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.BROWN), BFWoodTypes.WALNUT));
    public static final Block WALNUT_LEAVES = registerBlock("walnut_leaves", new WalnutLeavesBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)));
    public static final Block WALNUT_MULCH = registerBlock("walnut_mulch", new WalnutMulchBlock(FabricBlockSettings.create().notSolid().mapColor(MapColor.BROWN).notSolid().strength(0.4f).sounds(BlockSoundGroup.ROOTED_DIRT).burnable()));
    public static final Block WALNUT_MULCH_BLOCK = registerBlock("walnut_mulch_block", new Block(FabricBlockSettings.create().mapColor(MapColor.BROWN).strength(0.4f).sounds(BlockSoundGroup.ROOTED_DIRT).burnable()));

    public static final Block HANGING_WALNUTS = registerBlockNoItem("hanging_walnuts", new HangingWalnutsBlock(FabricBlockSettings.copyOf(BFBlocks.HANGING_APPLE)));
    public static final Block FALLEN_WALNUTS = registerBlockNoItem("fallen_walnuts", new FallenWalnutsBlock(FabricBlockSettings.create().mapColor(MapColor.BROWN).noCollision().sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY).breakInstantly().noBlockBreakParticles()));

    public static final Block WALNUT_CANDLE = registerBlock("walnut_candle", new WalnutCandleBlock(FabricBlockSettings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.CANDLE).luminance(createLightLevelFromLitBlockState(12)).pistonBehavior(PistonBehavior.DESTROY)));

//    public static final Block TRELLIS = registerBlock("trellis", new OldTrellisBlock(FabricBlockSettings.create().nonOpaque().strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).nonOpaque()));
//    public static final Block PASSION_FRUIT_TRELLIS = registerBlockNoItem("passion_fruit_trellis", new OldCropTrellisBlock(ModItems.PASSION_FRUIT, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block ELDERBERRY_TRELLIS = registerBlockNoItem("elderberry_trellis", new OldCropTrellisBlock(ModItems.ELDERBERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block GLOW_BERRY_TRELLIS = registerBlockNoItem("glow_berry_trellis", new OldCropTrellisBlock(Items.GLOW_BERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS).luminance(createLightLevelFromAgeBlockState(0, 6, 12))));
//    public static final Block LAPISBERRY_TRELLIS = registerBlockNoItem("lapisberry_trellis", new OldCropTrellisBlock(ModItems.LAPISBERRY_SEEDS, ModItems.LAPISBERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block ROSE_TRELLIS = registerBlockNoItem("rose_trellis", new DecorativeTrellisBlock(Items.ROSE_BUSH, true, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block LILAC_TRELLIS = registerBlockNoItem("lilac_trellis", new DecorativeTrellisBlock(Items.LILAC, true, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block PEONY_TRELLIS = registerBlockNoItem("peony_trellis", new DecorativeTrellisBlock(Items.PEONY, true, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block SUNFLOWER_TRELLIS = registerBlockNoItem("sunflower_trellis", new DecorativeTrellisBlock(Items.SUNFLOWER, true, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block VINE_TRELLIS = registerBlockNoItem("vine_trellis", new DecorativeTrellisBlock(Items.VINE, false, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block WEEPING_TRELLIS = registerBlockNoItem("weeping_trellis", new DecorativeTrellisBlock(Items.WEEPING_VINES, false, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
//    public static final Block TWISTING_TRELLIS = registerBlockNoItem("twisting_trellis", new DecorativeTrellisBlock(Items.TWISTING_VINES, false, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).sounds(ModSounds.PLANTED_TRELLIS)));
    public static final Block WILD_WHEAT = registerBlock("wild_wheat", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_CARROTS = registerBlock("wild_carrots", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_POTATOES = registerBlock("wild_potatoes", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_BEETROOTS = registerBlock("wild_beetroots", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_LEEKS = registerBlock("wild_leeks", new WildCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_MAIZE = registerBlock("wild_maize", new WildMaizeBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XYZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_PASSION_FRUIT_VINE = registerBlock("wild_passion_fruit_vine", new WildVineCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_ELDERBERRY_VINE = registerBlock("wild_elderberry_vine", new WildVineCropBlock(FabricBlockSettings.create().mapColor(MapColor.GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FELDSPAR_BLOCK = registerBlock("feldspar_block", new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE).instrument(Instrument.BASEDRUM).strength(1.5f).sounds(BlockSoundGroup.TUFF)));
    public static final Block CUT_FELDSPAR_BLOCK = registerBlock("cut_feldspar_block", new Block(FabricBlockSettings.copyOf(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICKS = registerBlock("feldspar_bricks", new Block(FabricBlockSettings.copyOf(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_STAIRS = registerBlock("feldspar_brick_stairs", new ModStairsBlock(BFBlocks.FELDSPAR_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_SLAB = registerBlock("feldspar_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_LANTERN = registerBlock("feldspar_lantern", new FeldsparLanternBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance(8).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TINGED_GLASS = registerBlock("tinged_glass", new TingedGlassBlock(FabricBlockSettings.create().instrument(Instrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block CERAMIC_CLAY_BLOCK = registerBlock("ceramic_clay_block", new Block(FabricBlockSettings.copyOf(Blocks.CLAY).instrument(Instrument.FLUTE).mapColor(MapColor.WHITE)));
    public static final Block CERAMIC_TILES = registerDyeableCeramicBlock("ceramic_tiles", new CeramicTilesBlock(FabricBlockSettings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(BFSounds.CERAMIC_TILES).instrument(Instrument.HAT).mapColor(MapColor.OFF_WHITE)));
    public static final Block CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("ceramic_tile_stairs", new CeramicTileStairsBlock(BFBlocks.CERAMIC_TILES.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("ceramic_tile_slab", new CeramicTileSlabBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_TILES)));
    public static final Block CRACKED_CERAMIC_TILES = registerDyeableCeramicBlock("cracked_ceramic_tiles", new CeramicTilesBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILES = registerDyeableCeramicBlock("checkered_ceramic_tiles", new CeramicTilesBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("checkered_ceramic_tile_stairs", new CeramicTileStairsBlock(BFBlocks.CHECKERED_CERAMIC_TILES.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.CHECKERED_CERAMIC_TILES)));
    public static final Block CHECKERED_CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("checkered_ceramic_tile_slab", new CeramicTileSlabBlock(FabricBlockSettings.copyOf(BFBlocks.CHECKERED_CERAMIC_TILES)));
    public static final Block CRACKED_CHECKERED_CERAMIC_TILES = registerDyeableCeramicBlock("cracked_checkered_ceramic_tiles", new CeramicTilesBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_TILE_PILLAR = registerDyeableCeramicBlock("ceramic_tile_pillar", new CeramicTilePillarBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_TILES)));
    public static final Block CERAMIC_MOSAIC = registerDyeableCeramicBlock("ceramic_mosaic", new CeramicTilesBlock(FabricBlockSettings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(BFSounds.CERAMIC_TILES).instrument(Instrument.HAT).mapColor(MapColor.OFF_WHITE)));
    public static final Block CERAMIC_MOSAIC_STAIRS = registerDyeableCeramicBlock("ceramic_mosaic_stairs", new CeramicTileStairsBlock(BFBlocks.CERAMIC_MOSAIC.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.CERAMIC_MOSAIC)));
    public static final Block CERAMIC_MOSAIC_SLAB = registerDyeableCeramicBlock("ceramic_mosaic_slab", new CeramicTileSlabBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_MOSAIC)));
    public static final Block CHECKERED_CERAMIC_MOSAIC = registerDyeableCeramicBlock("checkered_ceramic_mosaic", new CeramicTilesBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_MOSAIC)));
    public static final Block CHECKERED_CERAMIC_MOSAIC_STAIRS = registerDyeableCeramicBlock("checkered_ceramic_mosaic_stairs", new CeramicTileStairsBlock(BFBlocks.CHECKERED_CERAMIC_MOSAIC.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.CHECKERED_CERAMIC_MOSAIC)));
    public static final Block CHECKERED_CERAMIC_MOSAIC_SLAB = registerDyeableCeramicBlock("checkered_ceramic_mosaic_slab", new CeramicTileSlabBlock(FabricBlockSettings.copyOf(BFBlocks.CHECKERED_CERAMIC_MOSAIC)));

    public static final Block CERAMIC_PRESSURE_PLATE = registerDyeableCeramicBlock("ceramic_pressure_plate", new CeramicPressurePlateBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(BFSounds.CERAMIC_DECORATION).instrument(Instrument.HAT).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), BFBlockSetTypes.CERAMIC));
    public static final Block CERAMIC_BUTTON = registerDyeableCeramicBlock("ceramic_button", new CeramicButtonBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(BFSounds.CERAMIC_DECORATION).instrument(Instrument.HAT).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), BFBlockSetTypes.CERAMIC, 10, true));
    public static final Block CERAMIC_LEVER = registerDyeableCeramicBlock("ceramic_lever", new CeramicLeverBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).solid().sounds(BFSounds.CERAMIC_DECORATION).instrument(Instrument.HAT).noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CERAMIC_DISH = registerCeramicDishBlock("ceramic_dish", new CeramicDishBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).sounds(BFSounds.CERAMIC_DECORATION).strength(0.2F).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CERAMIC_DOOR = registerDyeableCeramicBlock("ceramic_door", new CeramicDoorBlock(FabricBlockSettings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(BFSounds.CERAMIC_DECORATION).instrument(Instrument.HAT).mapColor(MapColor.OFF_WHITE), BFBlockSetTypes.CERAMIC));
    public static final Block CERAMIC_TRAPDOOR = registerDyeableCeramicBlock("ceramic_trapdoor", new CeramicTrapdoorBlock(FabricBlockSettings.create().solidBlock(Blocks::never).requiresTool().strength(2f, 16f).sounds(BFSounds.CERAMIC_DECORATION).instrument(Instrument.HAT).mapColor(MapColor.OFF_WHITE), BFBlockSetTypes.CERAMIC));


    public static final Block FERMENTATION_VESSEL = registerBlock("fermentation_vessel", new FermentationVesselBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).instrument(Instrument.BASEDRUM).requiresTool().nonOpaque().sounds(BFSounds.CERAMIC_DECORATION)));
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
    public static final Block SPONGEKIN = registerBlock("spongekin", new SpongekinBlock(FabricBlockSettings.create().mapColor(MapColor.BRIGHT_TEAL).instrument(Instrument.DIDGERIDOO).strength(1.0f).sounds(BFSounds.SPONGEKIN).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PRISMARINE_BLOSSOM = registerBlock("prismarine_blossom", new PrismarineBlossomBlock(FabricBlockSettings.create().mapColor(MapColor.CYAN).ticksRandomly().strength(0.4f).nonOpaque().noCollision().sounds(BlockSoundGroup.CALCITE).luminance(state -> state.get(Properties.WATERLOGGED) ? 12 : 0).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SCORCHKIN_STEM = registerBlockNoItem("scorchkin_stem", new ScorchkinStemBlock(FabricBlockSettings.create().mapColor(MapColor.CLEAR).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.NETHER_WART).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SCORCHKIN = registerBlock("scorchkin", new Block(FabricBlockSettings.create().mapColor(MapColor.GRAY).instrument(Instrument.DIDGERIDOO).strength(1.0f).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block TEA_SHRUB = registerBlockNoItem("tea_shrub", new TeaShrubBlock(FabricBlockSettings.create().nonOpaque().strength(0.5f).ticksRandomly().noCollision().mapColor(MapColor.GREEN).sounds(BlockSoundGroup.AZALEA).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CHAMOMILE_FLOWERS = registerBlock("chamomile_flowers", new ChamomileFlowersBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).noCollision().sounds(BlockSoundGroup.PINK_PETALS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block HONEYSUCKLE = registerBlock("honeysuckle", new TeaFlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block POTTED_HONEYSUCKLE = registerBlockNoItem("potted_honeysuckle", new FlowerPotBlock(BFBlocks.HONEYSUCKLE, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block VIOLET_BELLFLOWER = registerBlock("violet_bellflower", new TeaFlowerBlock(StatusEffects.INVISIBILITY, 5, FabricBlockSettings.copyOf(Blocks.POPPY)));
    public static final Block POTTED_VIOLET_BELLFLOWER = registerBlockNoItem("potted_violet_bellflower", new FlowerPotBlock(BFBlocks.VIOLET_BELLFLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_POPPY)));
    public static final Block WHITE_JACK_O_STRAW = registerBlock("white_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIGHT_GRAY_JACK_O_STRAW = registerBlock("light_gray_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GRAY_JACK_O_STRAW = registerBlock("gray_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLACK_JACK_O_STRAW = registerBlock("black_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BROWN_JACK_O_STRAW = registerBlock("brown_jack_o_straw", new BrownJackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block RED_JACK_O_STRAW = registerBlock("red_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ORANGE_JACK_O_STRAW = registerBlock("orange_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block YELLOW_JACK_O_STRAW = registerBlock("yellow_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIME_JACK_O_STRAW = registerBlock("lime_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GREEN_JACK_O_STRAW = registerBlock("green_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block CYAN_JACK_O_STRAW = registerBlock("cyan_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LIGHT_BLUE_JACK_O_STRAW = registerBlock("light_blue_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block BLUE_JACK_O_STRAW = registerBlock("blue_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PURPLE_JACK_O_STRAW = registerBlock("purple_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MAGENTA_JACK_O_STRAW = registerBlock("magenta_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block PINK_JACK_O_STRAW = registerBlock("pink_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));

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

    public static Block OAK_PICKETS = registerBlock("oak_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block SPRUCE_PICKETS = registerBlock("spruce_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block BIRCH_PICKETS = registerBlock("birch_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block JUNGLE_PICKETS = registerBlock("jungle_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block ACACIA_PICKETS = registerBlock("acacia_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block DARK_OAK_PICKETS = registerBlock("dark_oak_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block MANGROVE_PICKETS = registerBlock("mangrove_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block CHERRY_PICKETS = registerBlock("cherry_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block BAMBOO_PICKETS = registerBlock("bamboo_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block WALNUT_PICKETS = registerBlock("walnut_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block HOARY_PICKETS = registerBlock("hoary_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block CRIMSON_PICKETS = registerBlock("crimson_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
    public static Block WARPED_PICKETS = registerBlock("warped_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));

    public static Block GRASSY_DIRT = registerBlock("grassy_dirt", new GrassyDirtBlock(FabricBlockSettings.copyOf(Blocks.DIRT).ticksRandomly()));


    public static Block ACORN_JACK_O_STRAW;
    public static Block AMBER_JACK_O_STRAW;
    public static Block ARTICHOKE_JACK_O_STRAW;
    public static Block BANANA_JACK_O_STRAW;
    public static Block CERULEAN_JACK_O_STRAW;
    public static Block FUCHSIA_JACK_O_STRAW;
    public static Block GRAPE_JACK_O_STRAW;
    public static Block INDIGO_JACK_O_STRAW;
    public static Block MAROON_JACK_O_STRAW;
    public static Block MAUVE_JACK_O_STRAW;
    public static Block MINT_JACK_O_STRAW;
    public static Block MOLD_JACK_O_STRAW;
    public static Block NAVY_JACK_O_STRAW;
    public static Block PEACH_JACK_O_STRAW;
    public static Block PERIWINKLE_JACK_O_STRAW;
    public static Block SAGE_JACK_O_STRAW;
    public static Block SAP_JACK_O_STRAW;
    public static Block SHAMROCK_JACK_O_STRAW;
    public static Block VELVET_JACK_O_STRAW;
    public static Block VERMILION_JACK_O_STRAW;
    public static Block WINTERGREEN_PICKETS;
    public static void registerElsAndLsDyesBlocks() {
        if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
            ACORN_JACK_O_STRAW = registerBlock("acorn_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            ARTICHOKE_JACK_O_STRAW = registerBlock("artichoke_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            BANANA_JACK_O_STRAW = registerBlock("banana_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            CERULEAN_JACK_O_STRAW = registerBlock("cerulean_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            FUCHSIA_JACK_O_STRAW = registerBlock("fuchsia_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            GRAPE_JACK_O_STRAW = registerBlock("grape_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            MAUVE_JACK_O_STRAW = registerBlock("mauve_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            MOLD_JACK_O_STRAW = registerBlock("mold_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            PEACH_JACK_O_STRAW = registerBlock("peach_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            PERIWINKLE_JACK_O_STRAW = registerBlock("periwinkle_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            SAGE_JACK_O_STRAW = registerBlock("sage_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            SAP_JACK_O_STRAW = registerBlock("sap_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            SHAMROCK_JACK_O_STRAW = registerBlock("shamrock_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            VELVET_JACK_O_STRAW = registerBlock("velvet_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            VERMILION_JACK_O_STRAW = registerBlock("vermilion_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            WINTERGREEN_PICKETS = registerBlock("wintergreen_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
        }
    }
    public static Block ROSE_JACK_O_STRAW;
    public static Block CORAL_JACK_O_STRAW;
    public static Block GINGER_JACK_O_STRAW;
    public static Block TAN_JACK_O_STRAW;
    public static Block BEIGE_JACK_O_STRAW;
    public static Block OLIVE_JACK_O_STRAW;
    public static Block FOREST_JACK_O_STRAW;
    public static Block VERDANT_JACK_O_STRAW;
    public static Block TEAL_JACK_O_STRAW;
    public static Block AQUA_JACK_O_STRAW;
    public static Block SLATE_JACK_O_STRAW;

    public static void registerDyeDepotBlocks() {
        if (BountifulFares.isModLoaded(BountifulFares.DYE_DEPOT_MOD_ID)) {
            MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            GINGER_JACK_O_STRAW = registerBlock("ginger_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            TAN_JACK_O_STRAW = registerBlock("tan_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            BEIGE_JACK_O_STRAW = registerBlock("beige_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            OLIVE_JACK_O_STRAW = registerBlock("olive_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            FOREST_JACK_O_STRAW = registerBlock("forest_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            VERDANT_JACK_O_STRAW = registerBlock("verdant_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            TEAL_JACK_O_STRAW = registerBlock("teal_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            AQUA_JACK_O_STRAW = registerBlock("aqua_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            SLATE_JACK_O_STRAW = registerBlock("slate_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
            INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", new JackOStrawBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.YELLOW).strength(0.5F).luminance(createLightLevelFromLitBlockState(12)).instrument(Instrument.BASS).notSolid().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        }
    }


    public static Block ANCIENT_PICKETS;
    public static Block WALNUT_VERTICAL_STAIRS;
    public static Block CHISELED_WALNUT_PLANKS;
    public static Block WALNUT_MOSAIC;
    public static Block WALNUT_MOSAIC_STAIRS;
    public static Block WALNUT_MOSAIC_VERTICAL_STAIRS;
    public static Block WALNUT_MOSAIC_SLAB;
    public static Block WALNUT_LADDER;
    public static Block HOARY_VERTICAL_STAIRS;
    public static Block CHISELED_HOARY_PLANKS;
    public static Block HOARY_MOSAIC;
    public static Block HOARY_MOSAIC_STAIRS;
    public static Block HOARY_MOSAIC_VERTICAL_STAIRS;
    public static Block HOARY_MOSAIC_SLAB;
    public static Block HOARY_LADDER;
    public static Block FELDSPAR_BRICK_VERTICAL_STAIRS;
    public static Block CERAMIC_TILE_VERTICAL_STAIRS;
    public static Block CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS;
    public static Block CERAMIC_MOSAIC_VERTICAL_STAIRS;
    public static Block CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS;
    public static void registerExcessiveBuildingBlocks() {
        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
            ANCIENT_PICKETS = registerBlock("ancient_pickets", new PicketsBlock(FabricBlockSettings.create().burnable().mapColor(MapColor.CLEAR).strength(0.5F).sounds(BFSounds.LIGHT_WOOD).instrument(Instrument.BASS).notSolid().nonOpaque()));
            WALNUT_VERTICAL_STAIRS = registerBlock("walnut_vertical_stairs", new VerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
            CHISELED_WALNUT_PLANKS = registerBlock("chiseled_walnut_planks", new Block(FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
            WALNUT_MOSAIC = registerBlock("walnut_mosaic", new Block(FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
            WALNUT_MOSAIC_STAIRS = registerBlock("walnut_mosaic_stairs", new ModStairsBlock(BFBlocks.WALNUT_MOSAIC.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
            WALNUT_MOSAIC_SLAB = registerBlock("walnut_mosaic_slab", new SlabBlock(FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
            WALNUT_MOSAIC_VERTICAL_STAIRS = registerBlock("walnut_mosaic_vertical_stairs", new VerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
            WALNUT_LADDER = registerBlock("walnut_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER)));

            HOARY_VERTICAL_STAIRS = registerBlock("hoary_vertical_stairs", new VerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
            CHISELED_HOARY_PLANKS = registerBlock("chiseled_hoary_planks", new Block(FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
            HOARY_MOSAIC = registerBlock("hoary_mosaic", new Block(FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
            HOARY_MOSAIC_STAIRS = registerBlock("hoary_mosaic_stairs", new ModStairsBlock(BFBlocks.HOARY_MOSAIC.getDefaultState(), FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
            HOARY_MOSAIC_SLAB = registerBlock("hoary_mosaic_slab", new SlabBlock(FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
            HOARY_MOSAIC_VERTICAL_STAIRS = registerBlock("hoary_mosaic_vertical_stairs", new VerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
            HOARY_LADDER = registerBlock("hoary_ladder", new LadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER)));

            FELDSPAR_BRICK_VERTICAL_STAIRS = registerBlock("feldspar_brick_vertical_stairs", new VerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.FELDSPAR_BRICKS)));
            CERAMIC_TILE_VERTICAL_STAIRS = registerBlock("ceramic_tile_vertical_stairs", new CeramicTileVerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_TILES)));
            CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS = registerBlock("checkered_ceramic_tile_vertical_stairs", new CeramicTileVerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.CHECKERED_CERAMIC_TILES)));
            CERAMIC_MOSAIC_VERTICAL_STAIRS = registerBlock("ceramic_mosaic_vertical_stairs", new CeramicTileVerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.CERAMIC_MOSAIC)));
            CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS = registerBlock("checkered_ceramic_mosaic_vertical_stairs", new CeramicTileVerticalStairsBlock(FabricBlockSettings.copyOf(BFBlocks.CHECKERED_CERAMIC_MOSAIC)));
        }
    }


    public static Block ASPEN_PICKETS;
    public static Block CEDAR_PICKETS;
    public static Block COCONUT_PICKETS;
    public static Block CYPRESS_PICKETS;
    public static Block FIR_PICKETS;
    public static Block GHAF_PICKETS;
    public static Block JOSHUA_PICKETS;
    public static Block LARCH_PICKETS;
    public static Block MAHOGANY_PICKETS;
    public static Block MAPLE_PICKETS;
    public static Block OLIVE_PICKETS;
    public static Block PALO_VERDE_PICKETS;
    public static Block REDWOOD_PICKETS;
    public static Block SAXAUL_PICKETS;
    public static Block SUGI_PICKETS;
    public static Block WILLOW_PICKETS;
    public static Block WISTERIA_PICKETS;

    public static void registerNaturesSpiritBlocks() {
        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
            ASPEN_PICKETS = registerBlock("aspen_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            CEDAR_PICKETS = registerBlock("cedar_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            COCONUT_PICKETS = registerBlock("coconut_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            CYPRESS_PICKETS = registerBlock("cypress_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            FIR_PICKETS = registerBlock("fir_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            GHAF_PICKETS = registerBlock("ghaf_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            JOSHUA_PICKETS = registerBlock("joshua_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            LARCH_PICKETS = registerBlock("larch_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            MAHOGANY_PICKETS = registerBlock("mahogany_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            MAPLE_PICKETS = registerBlock("maple_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            OLIVE_PICKETS = registerBlock("olive_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            PALO_VERDE_PICKETS = registerBlock("palo_verde_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            REDWOOD_PICKETS = registerBlock("redwood_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            SAXAUL_PICKETS = registerBlock("saxaul_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            SUGI_PICKETS = registerBlock("sugi_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            WILLOW_PICKETS = registerBlock("willow_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
            WISTERIA_PICKETS = registerBlock("wisteria_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
        }
    }

    public static Block ROTTEN_PICKETS;

    public static void registerSpawnBlocks() {
        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
            ROTTEN_PICKETS = registerBlock("rotten_pickets", new PicketsBlock(FabricBlockSettings.copyOf(OAK_PICKETS)));
        }
    }


    public static Block WALNUT_CABINET;
    public static Block HOARY_CABINET;

    public static void registerFarmersDelightBlocks() {
        if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID)) {
            WALNUT_CABINET = registerBlock("walnut_cabinet", new CabinetBlock(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.BROWN)));
            HOARY_CABINET = registerBlock("hoary_cabinet", new CabinetBlock(FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.TERRACOTTA_GRAY)));
        }
    }


    public static Block TALL_WALNUT_DOOR;
    public static Block SHORT_WALNUT_DOOR;
    public static Block TALL_HOARY_DOOR;
    public static Block SHORT_HOARY_DOOR;
    public static Block TALL_CERAMIC_DOOR;
    public static Block SHORT_CERAMIC_DOOR;

    public static void registerDramaticDoorsBlocks() {
        if (BountifulFares.isModLoaded(BountifulFares.DRAMATIC_DOORS_MOD_ID)) {
            TALL_WALNUT_DOOR = registerBlock("tall_walnut_door", new TallDoorBlock(FabricBlockSettings.copyOf(WALNUT_DOOR), BFBlockSetTypes.WALNUT));
            SHORT_WALNUT_DOOR = registerBlock("short_walnut_door", new ShortDoorBlock(FabricBlockSettings.copyOf(WALNUT_DOOR), BFBlockSetTypes.WALNUT));
            TALL_HOARY_DOOR = registerBlock("tall_hoary_door", new TallDoorBlock(FabricBlockSettings.copyOf(HOARY_DOOR), BFBlockSetTypes.HOARY));
            SHORT_HOARY_DOOR = registerBlock("short_hoary_door", new ShortDoorBlock(FabricBlockSettings.copyOf(HOARY_DOOR), BFBlockSetTypes.HOARY));
            TALL_CERAMIC_DOOR = registerDyeableCeramicBlock("tall_ceramic_door", new TallCeramicDoorBlock(FabricBlockSettings.copyOf(CERAMIC_DOOR), BFBlockSetTypes.CERAMIC));
            SHORT_CERAMIC_DOOR = registerDyeableCeramicBlock("short_ceramic_door", new ShortCeramicDoorBlock(FabricBlockSettings.copyOf(CERAMIC_DOOR), BFBlockSetTypes.CERAMIC));
        }
    }


    public static Block WALNUT_TABLE;
    public static Block HOARY_TABLE;
    public static Block FELDSPAR_LAMP;

    public static void registerTwigsBlocks() {
        if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
            WALNUT_TABLE = registerBlock("walnut_table", new TwigsTableBlock(FabricBlockSettings.copyOf(WALNUT_PLANKS)));
            HOARY_TABLE = registerBlock("hoary_table", new TwigsTableBlock(FabricBlockSettings.copyOf(HOARY_PLANKS)));
            FELDSPAR_LAMP = registerBlock("feldspar_lamp", new TwigsLampBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(4.5F).sounds(BFSounds.LAMP).luminance(createLightLevelFromLitBlockState(8))));
        }
    }



    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }

    public static ToIntFunction<BlockState> createLightLevelFromAgeBlockState(int lit1, int lit2, int lit3) {
        return state -> state.get(CropTrellisBlock.AGE) == 1 ? lit1 : state.get(CropTrellisBlock.AGE) == 2 ? lit2 : state.get(CropTrellisBlock.AGE) == 3 ? lit3 : 0;
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulFares.MOD_ID, name), block);
    }

    private static Block registerBlockWithInfo(String name, Block block) {
        registerBlockItemWithInfo(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulFares.MOD_ID, name), block);
    }

    private static void registerBlockItemWithInfo(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulFares.MOD_ID, name), new BlockItemWithInfo(block, new FabricItemSettings()));
    }

    private static Block registerBlockUnstackableItem(String name, Block block) {
        registerUnstackableBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulFares.MOD_ID, name), block);
    }

    private static Block registerBlock16StackItem(String name, Block block) {
        register16StackItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulFares.MOD_ID, name), block);
    }
    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(BountifulFares.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulFares.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static void register16StackItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulFares.MOD_ID, name), new BlockItem(block, new FabricItemSettings().maxCount(16)));
    }

    private static void registerUnstackableBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulFares.MOD_ID, name), new BlockItem(block, new FabricItemSettings().maxCount(1)));
    }

    private static Block registerDyeableCeramicBlock(String name, Block block) {
        registerDyeableCeramicBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulFares.MOD_ID, name), block);
    }
    private static void registerDyeableCeramicBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulFares.MOD_ID, name), new DyeableCeramicBlockItem(block, new FabricItemSettings()));
    }

    private static Block registerCeramicDishBlock(String name, Block block) {
        registerCeramicDishBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BountifulFares.MOD_ID, name), block);
    }
    private static void registerCeramicDishBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(BountifulFares.MOD_ID, name), new CeramicDishBlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        registerElsAndLsDyesBlocks();
        registerDyeDepotBlocks();
        registerExcessiveBuildingBlocks();
        registerNaturesSpiritBlocks();
        registerSpawnBlocks();
        registerFarmersDelightBlocks();
        registerTwigsBlocks();
    }
}
