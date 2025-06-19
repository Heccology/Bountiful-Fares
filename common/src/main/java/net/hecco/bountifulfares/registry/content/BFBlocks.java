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
import net.hecco.heccolib.lib.publicBlocks.PublicButtonBlock;
import net.hecco.heccolib.lib.publicBlocks.PublicDoorBlock;
import net.hecco.heccolib.lib.publicBlocks.PublicPressurePlateBlock;
import net.hecco.heccolib.lib.publicBlocks.PublicSaplingBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.ToIntFunction;

public class BFBlocks {
    public static final Map<Item, CropTrellisBlock> CROPS_TO_CROP_TRELLISES = Maps.newHashMap();
    public static final Map<Item, VineCrop> CROPS_TO_VINE_CROPS = Maps.newHashMap();
    public static final Map<Item, DecorativeVine> PLANTS_TO_DECORATIVE_VINES = Maps.newHashMap();
    public static final Map<Item, DecorativeTrellisBlock> PLANTS_TO_DECORATIVE_TRELLISES = Maps.newHashMap();
    public static final Map<DecorativeTrellisBlock, Item> DECORATIVE_TRELLISES_TO_PLANTS = Maps.newHashMap();
    public static final Map<Block, Block> CERAMIC_TO_CHECKERED_CERAMIC = Maps.newHashMap();
    public static final Map<Block, Block> REVERT_CHECKERED_CERAMIC = Maps.newHashMap();

    public static final Block APPLE_LOG = registerBlock("apple_log", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).noOcclusion().forceSolidOff()));
    public static final Block APPLE_WOOD = registerBlock("apple_wood", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).noOcclusion().forceSolidOff()));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).noOcclusion().forceSolidOff()));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).noOcclusion().forceSolidOff()));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves", new AppleLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final Block FLOWERING_APPLE_LEAVES = registerBlock("flowering_apple_leaves", new AppleLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final Block HANGING_APPLE = registerBlockNoItem("hanging_apple", new HangingAppleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).dynamicShape().sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY).randomTicks().offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling", new PublicSaplingBlock(BFSaplingGenerators.APPLE_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).sound(SoundType.CHERRY_SAPLING)));
    public static final Block POTTED_APPLE_SAPLING = registerBlockNoItem("potted_apple_sapling", new FlowerPotBlock(BFBlocks.APPLE_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block ORANGE_LOG = registerBlock("orange_log", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LOG)));
    public static final Block ORANGE_WOOD = registerBlock("orange_wood", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block ORANGE_LEAVES = registerBlock("orange_leaves", new OrangeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_ORANGE_LEAVES = registerBlock("flowering_orange_leaves", new OrangeLeavesBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_ORANGE = registerBlockNoItem("hanging_orange", new HangingOrangeBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.HANGING_APPLE)));
    public static final Block ORANGE_SAPLING = registerBlock("orange_sapling", new PublicSaplingBlock(BFSaplingGenerators.ORANGE_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_ORANGE_SAPLING = registerBlockNoItem("potted_orange_sapling", new FlowerPotBlock(BFBlocks.ORANGE_SAPLING, BlockBehaviour.Properties.ofFullCopy(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block LEMON_LOG = registerBlock("lemon_log", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LOG)));
    public static final Block LEMON_WOOD = registerBlock("lemon_wood", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_LEMON_LOG = registerBlock("stripped_lemon_log", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = registerBlock("stripped_lemon_wood", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves", new LemonLeavesBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_LEMON_LEAVES = registerBlock("flowering_lemon_leaves", new LemonLeavesBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_LEMON = registerBlockNoItem("hanging_lemon", new HangingLemonBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.HANGING_APPLE)));
    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling", new PublicSaplingBlock(BFSaplingGenerators.LEMON_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_LEMON_SAPLING = registerBlockNoItem("potted_lemon_sapling", new FlowerPotBlock(BFBlocks.LEMON_SAPLING, BlockBehaviour.Properties.ofFullCopy(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block PLUM_LOG = registerBlock("plum_log", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LOG)));
    public static final Block PLUM_WOOD = registerBlock("plum_wood", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block PLUM_LEAVES = registerBlock("plum_leaves", new PlumLeavesBlock(BFBlocks.HANGING_PLUM, BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LEAVES)));
    public static final Block FLOWERING_PLUM_LEAVES = registerBlock("flowering_plum_leaves", new PlumLeavesBlock(BFBlocks.HANGING_PLUM, BlockBehaviour.Properties.ofFullCopy(BFBlocks.FLOWERING_APPLE_LEAVES)));
    public static final Block HANGING_PLUM = registerBlockNoItem("hanging_plum", new HangingPlumBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.HANGING_APPLE)));
    public static final Block PLUM_SAPLING = registerBlock("plum_sapling", new PublicSaplingBlock(BFSaplingGenerators.PLUM_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_SAPLING)));
    public static final Block POTTED_PLUM_SAPLING = registerBlockNoItem("potted_plum_sapling", new FlowerPotBlock(BFBlocks.PLUM_SAPLING, BlockBehaviour.Properties.ofFullCopy(BFBlocks.POTTED_APPLE_SAPLING)));
    public static final Block HOARY_APPLE_SAPLING_CROP = registerBlockNoItem("hoary_apple_sapling_crop", new HoaryAppleSaplingCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).randomTicks().noCollission().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final Block HOARY_APPLE_SAPLING = registerBlock("hoary_apple_sapling", new PublicSaplingBlock(BFSaplingGenerators.HOARY_SAPLING_GENERATOR, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).randomTicks().noCollission().instabreak().sound(SoundType.CHERRY_SAPLING).pushReaction(PushReaction.DESTROY)));
    public static final Block POTTED_HOARY_APPLE_SAPLING = registerBlockNoItem("potted_hoary_apple_sapling", new FlowerPotBlock(BFBlocks.HOARY_APPLE_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
    public static final Block HOARY_LOG = registerBlock("hoary_log", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WOOD = registerBlock("hoary_wood", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_LOG = registerBlock("stripped_hoary_log", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block STRIPPED_HOARY_WOOD = registerBlock("stripped_hoary_wood", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_PLANKS = registerBlock("hoary_planks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_STAIRS = registerBlock("hoary_stairs", new ModStairsBlock(BFBlocks.HOARY_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_SLAB = registerBlock("hoary_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS)));
    public static final Block HOARY_FENCE = registerBlock("hoary_fence", new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_FENCE_GATE = registerBlock("hoary_fence_gate", new ModFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFWoodTypes.HOARY));
    public static final Block HOARY_DOOR = registerBlock("hoary_door", new PublicDoorBlock(BFBlockSetTypes.HOARY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_TRAPDOOR = registerBlock("hoary_trapdoor", new ModTrapdoorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY), BFBlockSetTypes.HOARY));
    public static final Block HOARY_PRESSURE_PLATE = registerBlock("hoary_pressure_plate", new PublicPressurePlateBlock(BFBlockSetTypes.HOARY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5f, 5.0f)));
    public static final Block HOARY_BUTTON = registerBlock("hoary_button", new PublicButtonBlock(BFBlockSetTypes.HOARY, 30, BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS).noCollission().strength(0.5f, 5f)));
    public static final Block HOARY_SIGN = registerBlockNoItem("hoary_sign", new ModStandingSignBlock(BFWoodTypes.HOARY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WALL_SIGN = registerBlockNoItem("hoary_wall_sign", new ModWallSignBlock(BFWoodTypes.HOARY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_HANGING_SIGN = registerBlockNoItem("hoary_hanging_sign", new ModHangingSignBlock(BFWoodTypes.HOARY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_WALL_HANGING_SIGN = registerBlockNoItem("hoary_wall_hanging_sign", new ModWallHangingSignBlock(BFWoodTypes.HOARY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.TERRACOTTA_GRAY)));
    public static final Block HOARY_LEAVES = registerBlock("hoary_leaves", new HoaryLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Block HANGING_HOARY_APPLE = registerBlockNoItem("hanging_hoary_apple", new HangingHoaryAppleBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.HANGING_APPLE)));

    public static final Block WALNUT_SAPLING = registerBlock("walnut_sapling", new PublicSaplingBlock(BFSaplingGenerators.WALNUT_SAPLING_GENERATOR, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final Block POTTED_WALNUT_SAPLING = registerBlockNoItem("potted_walnut_sapling", new FlowerPotBlock(BFBlocks.WALNUT_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));
    public static final Block WALNUT_LOG = registerBlock("walnut_log", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_WOOD = registerBlock("walnut_wood", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_BROWN)));
    public static final Block STRIPPED_WALNUT_LOG = registerBlock("stripped_walnut_log", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.COLOR_BROWN)));
    public static final Block STRIPPED_WALNUT_WOOD = registerBlock("stripped_walnut_wood", new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_PLANKS = registerBlock("walnut_planks", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0f, 5.0f).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_STAIRS = registerBlock("walnut_stairs", new ModStairsBlock(BFBlocks.WALNUT_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_SLAB = registerBlock("walnut_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS)));
    public static final Block WALNUT_FENCE = registerBlock("walnut_fence", new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).strength(2.0f, 5.0f).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_FENCE_GATE = registerBlock("walnut_fence_gate", new ModFenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).strength(2.0f, 5.0f).mapColor(MapColor.COLOR_BROWN), BFWoodTypes.WALNUT));
    public static final Block WALNUT_DOOR = registerBlock("walnut_door", new PublicDoorBlock(BFBlockSetTypes.WALNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).strength(2.0f, 5.0f).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_TRAPDOOR = registerBlock("walnut_trapdoor", new ModTrapdoorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).strength(2.0f, 5.0f).mapColor(MapColor.COLOR_BROWN), BFBlockSetTypes.WALNUT));
    public static final Block WALNUT_PRESSURE_PLATE = registerBlock("walnut_pressure_plate", new PublicPressurePlateBlock(BFBlockSetTypes.WALNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.COLOR_BROWN).strength(0.5f, 5.0f)));
    public static final Block WALNUT_BUTTON = registerBlock("walnut_button", new PublicButtonBlock(BFBlockSetTypes.WALNUT, 30, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS).mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.5f, 5f)));
    public static final Block WALNUT_SIGN = registerBlockNoItem("walnut_sign", new ModStandingSignBlock(BFWoodTypes.WALNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_WALL_SIGN = registerBlockNoItem("walnut_wall_sign", new ModWallSignBlock(BFWoodTypes.WALNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_HANGING_SIGN = registerBlockNoItem("walnut_hanging_sign", new ModHangingSignBlock(BFWoodTypes.WALNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_WALL_HANGING_SIGN = registerBlockNoItem("walnut_wall_hanging_sign", new ModWallHangingSignBlock(BFWoodTypes.WALNUT, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f, 5.0f).mapColor(MapColor.COLOR_BROWN)));
    public static final Block WALNUT_LEAVES = registerBlock("walnut_leaves", new WalnutLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Block WALNUT_MULCH = registerBlock("walnut_mulch", new MulchBlock(BlockBehaviour.Properties.of().forceSolidOff().mapColor(MapColor.COLOR_BROWN).forceSolidOff().strength(0.4f).sound(SoundType.ROOTED_DIRT).ignitedByLava()));
    public static final Block WALNUT_MULCH_BLOCK = registerBlock("walnut_mulch_block", new MulchBlockBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.4f).sound(SoundType.ROOTED_DIRT).ignitedByLava()));

    public static final Block HANGING_WALNUTS = registerBlockNoItem("hanging_walnuts", new HangingWalnutsBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.HANGING_APPLE)));
    public static final Block FALLEN_WALNUTS = registerBlockNoItem("fallen_walnuts", new FallenWalnutsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY).instabreak().noTerrainParticles()));

    public static final Block WALNUT_CANDLE = registerBlock("walnut_candle", new WalnutCandleBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.CANDLE).lightLevel(createLightLevelFromLitBlockState(12)).pushReaction(PushReaction.DESTROY)));

    public static final Block PALM_SAPLING = registerBlockNoItem("palm_sapling", new PalmSaplingBlock(BFSaplingGenerators.PALM_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).sound(SoundType.CROP)));
    public static final Block PALM_LOG = registerBlock("palm_log", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_LOG)));
    public static final Block PALM_WOOD = registerBlock("palm_wood", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_PALM_LOG = registerBlock("stripped_palm_log", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_LOG)));
    public static final Block STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood", new StrippedFruitLogBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block PALM_CROWN = registerBlock("palm_crown", new PalmCrownBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Block PALM_FROND = registerBlockNoItem("palm_frond", new PalmFrondBlock(BlockBehaviour.Properties.of().noCollission().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.2F).sound(SoundType.AZALEA_LEAVES).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOff()));
    public static final Block POTTED_PALM_FROND = registerBlockNoItem("potted_palm_frond", new FlowerPotBlock(PALM_FROND, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));
    public static final Block WALL_PALM_FROND = registerBlockNoItem("wall_palm_frond", new WallPalmFrondBlock(BlockBehaviour.Properties.of().noCollission().mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.2F).sound(SoundType.AZALEA_LEAVES).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOff()));
    public static final Block COCONUT = registerBlockNoItem("coconut", new CoconutBlock(BlockBehaviour.Properties.of().strength(0.2f).mapColor(MapColor.COLOR_BROWN).dynamicShape().sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY).randomTicks().noOcclusion()));
    public static final Block PALM_MULCH = registerBlock("palm_mulch", new MulchBlock(BlockBehaviour.Properties.of().forceSolidOff().mapColor(MapColor.COLOR_BROWN).forceSolidOff().strength(0.4f).sound(SoundType.ROOTED_DIRT).ignitedByLava()));
    public static final Block PALM_MULCH_BLOCK = registerBlock("palm_mulch_block", new MulchBlockBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(0.4f).sound(SoundType.ROOTED_DIRT).ignitedByLava()));
    public static final Block COCONUT_CAKE = registerBlockUnstackableItem("coconut_cake", new NoCandleCakeBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block PACKED_COCONUT_COIR = registerBlock("packed_coconut_coir", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 1.0F).sound(BFSounds.COIR)));
    public static final Block COIR_CARPET = registerBlock("coir_carpet", new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET).mapColor(MapColor.WOOD).sound(BFSounds.COIR)));
    public static final Block COIR_BRICKS = registerBlock("coir_bricks", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.5F, 1.0F).sound(SoundType.PACKED_MUD)));
    public static final Block COIR_BRICK_SLAB = registerBlock("coir_brick_slab", new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.5F, 1.0F).sound(SoundType.PACKED_MUD)));
    public static final Block COIR_BRICK_STAIRS = registerBlock("coir_brick_stairs", new ModStairsBlock(COIR_BRICKS.defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.5F, 1.0F).sound(SoundType.PACKED_MUD)));
    public static final Block COIR_BRICK_WALL = registerBlock("coir_brick_wall", new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.5F, 1.0F).sound(SoundType.PACKED_MUD)));
    public static final Block COCONUT_CANDLE = registerBlock("coconut_candle", new CoconutCandleBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.CANDLE).lightLevel(createLightLevelFromLitBlockState(12)).pushReaction(PushReaction.DESTROY)));

    public static final Block WILD_WHEAT = registerBlock("wild_wheat", new WildCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).replaceable().noCollission().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final Block WILD_CARROTS = registerBlock("wild_carrots", new WildCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).replaceable().noCollission().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final Block WILD_POTATOES = registerBlock("wild_potatoes", new WildCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).replaceable().noCollission().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final Block WILD_BEETROOTS = registerBlock("wild_beetroots", new WildCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).replaceable().noCollission().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final Block WILD_LEEKS = registerBlock("wild_leeks", new WildCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).replaceable().noCollission().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final Block WILD_MAIZE = registerBlock("wild_maize", new WildMaizeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).replaceable().noCollission().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final Block WILD_PASSION_FRUIT_VINE = registerBlock("wild_passion_fruit_vine", new WildVineCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).replaceable().noCollission().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final Block WILD_ELDERBERRY_VINE = registerBlock("wild_elderberry_vine", new WildVineCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).replaceable().noCollission().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final Block FELDSPAR_BLOCK = registerBlock("feldspar_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5f).sound(SoundType.TUFF)));
    public static final Block CUT_FELDSPAR_BLOCK = registerBlock("cut_feldspar_block", new Block(BlockBehaviour.Properties.ofFullCopy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICKS = registerBlock("feldspar_bricks", new Block(BlockBehaviour.Properties.ofFullCopy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_STAIRS = registerBlock("feldspar_brick_stairs", new ModStairsBlock(BFBlocks.FELDSPAR_BRICKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_SLAB = registerBlock("feldspar_brick_slab", new SlabBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_BRICK_WALL = registerBlock("feldspar_brick_wall", new WallBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.FELDSPAR_BLOCK)));
    public static final Block FELDSPAR_LANTERN = registerBlock("feldspar_lantern", new FeldsparLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).forceSolidOn().requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel(state -> 8).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block TINGED_GLASS = registerBlock("tinged_glass", new TingedGlassBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));

    public static final Block CERAMIC_CLAY_BLOCK = registerBlock("ceramic_clay_block", new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CLAY).instrument(NoteBlockInstrument.FLUTE).mapColor(MapColor.SNOW)));
    public static final Block CERAMIC_TILES = registerDyeableCeramicBlock("ceramic_tiles", new CeramicTilesBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(2f, 16f).sound(BFSounds.CERAMIC_TILES).instrument(BFNoteBlockInstruments.OCARINA).mapColor(MapColor.QUARTZ)), null);
    public static final Block CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("ceramic_tile_stairs", new CeramicTileStairsBlock(BFBlocks.CERAMIC_TILES.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_TILES)), null);
    public static final Block CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("ceramic_tile_slab", new CeramicTileSlabBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_TILES)), null);
    //public static final Block CERAMIC_TILE_WALL = registerDyeableCeramicBlock("ceramic_tile_wall", new CeramicTileWallBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_TILES)), null);
    public static final Block CRACKED_CERAMIC_TILES = registerDyeableCeramicBlock("cracked_ceramic_tiles", new CeramicTilesBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_TILES)), null);
    public static final Block CHECKERED_CERAMIC_TILES = registerDyeableCeramicBlock("checkered_ceramic_tiles", new CeramicTilesBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_TILES)), null);
    public static final Block CHECKERED_CERAMIC_TILE_STAIRS = registerDyeableCeramicBlock("checkered_ceramic_tile_stairs", new CeramicTileStairsBlock(BFBlocks.CHECKERED_CERAMIC_TILES.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.CHECKERED_CERAMIC_TILES)), null);
    public static final Block CHECKERED_CERAMIC_TILE_SLAB = registerDyeableCeramicBlock("checkered_ceramic_tile_slab", new CeramicTileSlabBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CHECKERED_CERAMIC_TILES)), null);
    //public static final Block CHECKERED_CERAMIC_TILE_WALL = registerDyeableCeramicBlock("checkered_ceramic_tile_wall", new CeramicTileWallBlock(AbstractBlock.Settings.copy(BFBlocks.CHECKERED_CERAMIC_TILES)), null);
    public static final Block CRACKED_CHECKERED_CERAMIC_TILES = registerDyeableCeramicBlock("cracked_checkered_ceramic_tiles", new CeramicTilesBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_TILES)), null);
    public static final Block CERAMIC_TILE_PILLAR = registerDyeableCeramicBlock("ceramic_tile_pillar", new CeramicTilePillarBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_TILES)), null);
    public static final Block CERAMIC_MOSAIC = registerDyeableCeramicBlock("ceramic_mosaic", new CeramicTilesBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(2f, 16f).sound(BFSounds.CERAMIC_TILES).instrument(BFNoteBlockInstruments.OCARINA).mapColor(MapColor.QUARTZ)), null);
    public static final Block CERAMIC_MOSAIC_STAIRS = registerDyeableCeramicBlock("ceramic_mosaic_stairs", new CeramicTileStairsBlock(BFBlocks.CERAMIC_MOSAIC.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_MOSAIC)), null);
    public static final Block CERAMIC_MOSAIC_SLAB = registerDyeableCeramicBlock("ceramic_mosaic_slab", new CeramicTileSlabBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_MOSAIC)), null);
    //public static final Block CERAMIC_MOSAIC_WALL = registerDyeableCeramicBlock("ceramic_mosaic_wall", new CeramicTileWallBlock(AbstractBlock.Settings.copy(BFBlocks.CERAMIC_MOSAIC)), null);
    public static final Block CHECKERED_CERAMIC_MOSAIC = registerDyeableCeramicBlock("checkered_ceramic_mosaic", new CeramicTilesBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CERAMIC_MOSAIC)), null);
    public static final Block CHECKERED_CERAMIC_MOSAIC_STAIRS = registerDyeableCeramicBlock("checkered_ceramic_mosaic_stairs", new CeramicTileStairsBlock(BFBlocks.CHECKERED_CERAMIC_MOSAIC.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(BFBlocks.CHECKERED_CERAMIC_MOSAIC)), null);
    public static final Block CHECKERED_CERAMIC_MOSAIC_SLAB = registerDyeableCeramicBlock("checkered_ceramic_mosaic_slab", new CeramicTileSlabBlock(BlockBehaviour.Properties.ofFullCopy(BFBlocks.CHECKERED_CERAMIC_MOSAIC)), null);
    //public static final Block CHECKERED_CERAMIC_MOSAIC_WALL = registerDyeableCeramicBlock("checkered_ceramic_mosaic_wall", new CeramicTileWallBlock(AbstractBlock.Settings.copy(BFBlocks.CHECKERED_CERAMIC_MOSAIC)), null);

    public static final Block CERAMIC_PRESSURE_PLATE = registerDyeableCeramicBlock("ceramic_pressure_plate", new CeramicPressurePlateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).forceSolidOn().sound(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BFBlockSetTypes.CERAMIC), null);
    public static final Block CERAMIC_BUTTON = registerDyeableCeramicBlock("ceramic_button", new CeramicButtonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).forceSolidOn().sound(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BFBlockSetTypes.CERAMIC, 10, true), null);
    public static final Block CERAMIC_LEVER = registerDyeableCeramicBlock("ceramic_lever", new CeramicLeverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).forceSolidOn().sound(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY)), null);
    public static final Block CERAMIC_DISH = registerCeramicDishBlock("ceramic_dish", new CeramicDishBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).sound(BFSounds.CERAMIC_DECORATION).strength(0.2F).pushReaction(PushReaction.DESTROY)));
    public static final Block CERAMIC_DOOR = registerDyeableCeramicBlock("ceramic_door", new CeramicDoorBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(2f, 16f).sound(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).mapColor(MapColor.QUARTZ), BFBlockSetTypes.CERAMIC), null);
    public static final Block CERAMIC_TRAPDOOR = registerDyeableCeramicBlock("ceramic_trapdoor", new CeramicTrapdoorBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(2f, 16f).sound(BFSounds.CERAMIC_DECORATION).instrument(BFNoteBlockInstruments.OCARINA).mapColor(MapColor.QUARTZ), BFBlockSetTypes.CERAMIC), null);

    public static final Block SOLID_CERAMIC = registerDyeableCeramicBlock("solid_ceramic", new CeramicTilesBlock(BlockBehaviour.Properties.ofFullCopy(CERAMIC_TILES).destroyTime(100f).sound(BFSounds.CERAMIC_DECORATION)), new Item.Properties().rarity(Rarity.EPIC));

    public static final Block FERMENTATION_VESSEL = registerBlock("fermentation_vessel", new FermentationVesselBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).strength(2, 5).instrument(BFNoteBlockInstruments.OCARINA).requiresCorrectToolForDrops().noOcclusion().sound(BFSounds.CERAMIC_DECORATION)));
    public static final Block APPLE_BLOCK = registerBlock("apple_block", new AppleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(1f).instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final Block GOLDEN_APPLE_BLOCK = registerBlock("golden_apple_block", new GoldenAppleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1f).instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.METAL).pushReaction(PushReaction.DESTROY)), Rarity.RARE);
    public static final Block ORANGE_BLOCK = registerBlock("orange_block", new OrangeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.5f).instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.WOOD)));
    public static final Block LEMON_BLOCK = registerBlock("lemon_block", new LemonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.5f).instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.WOOD)));
    public static final Block PLUM_BLOCK = registerBlock("plum_block", new PlumBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_HYPHAE).strength(0.5f).instrument(NoteBlockInstrument.DIDGERIDOO).sound(SoundType.WOOD)));
    public static final Block HOARY_APPLE_BLOCK = registerBlock("hoary_apple_block", new HoaryAppleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).strength(0.5f).instrument(BFNoteBlockInstruments.OLD_PIANO).sound(SoundType.WOOD)));
    public static final Block LEEKS = registerBlockNoItem("leeks", new LeekCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final Block MAIZE_CROP = registerBlockNoItem("maize_crop", new MaizeCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final Block SPONGEKIN_SPROUT = registerBlock("spongekin_sprout", new SpongekinSproutBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final Block SPONGEKIN_STEM = registerBlockNoItem("spongekin_stem", new SpongekinStemBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().randomTicks().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final Block SPONGEKIN = registerBlock("spongekin", new SpongekinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK).instrument(BFNoteBlockInstruments.STEEL_DRUM).strength(1.0f).sound(BFSounds.SPONGEKIN).pushReaction(PushReaction.DESTROY)));
    public static final Block PRISMARINE_BLOSSOM = registerBlock("prismarine_blossom", new PrismarineBlossomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).randomTicks().strength(0.4f).noOcclusion().noCollission().sound(SoundType.CALCITE).lightLevel(state -> state.getValue(BlockStateProperties.WATERLOGGED) ? 12 : 0).pushReaction(PushReaction.DESTROY)));
    public static final Block SCORCHKIN_STEM = registerBlockNoItem("scorchkin_stem", new ScorchkinStemBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).noCollission().randomTicks().instabreak().sound(SoundType.NETHER_WART).pushReaction(PushReaction.DESTROY)));
    public static final Block SCORCHKIN = registerBlock("scorchkin", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0f).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final Block TEA_SHRUB = registerBlockNoItem("tea_shrub", new TeaShrubBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.5f).randomTicks().noCollission().mapColor(MapColor.COLOR_GREEN).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Block CHAMOMILE_FLOWERS = registerBlock("chamomile_flowers", new ChamomileFlowersBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final Block HONEYSUCKLE = registerBlock("honeysuckle", new TeaFlowerBlock(MobEffects.REGENERATION, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));
    public static final Block POTTED_HONEYSUCKLE = registerBlockNoItem("potted_honeysuckle", new FlowerPotBlock(BFBlocks.HONEYSUCKLE, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));
    public static final Block VIOLET_BELLFLOWER = registerBlock("violet_bellflower", new TeaFlowerBlock(MobEffects.INVISIBILITY, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));
    public static final Block POTTED_VIOLET_BELLFLOWER = registerBlockNoItem("potted_violet_bellflower", new FlowerPotBlock(BFBlocks.VIOLET_BELLFLOWER, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)));
    public static final Block WHITE_JACK_O_STRAW = registerBlock("white_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block LIGHT_GRAY_JACK_O_STRAW = registerBlock("light_gray_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block GRAY_JACK_O_STRAW = registerBlock("gray_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block BLACK_JACK_O_STRAW = registerBlock("black_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block BROWN_JACK_O_STRAW = registerBlock("brown_jack_o_straw", new BrownJackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block RED_JACK_O_STRAW = registerBlock("red_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block ORANGE_JACK_O_STRAW = registerBlock("orange_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block YELLOW_JACK_O_STRAW = registerBlock("yellow_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block LIME_JACK_O_STRAW = registerBlock("lime_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block GREEN_JACK_O_STRAW = registerBlock("green_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block CYAN_JACK_O_STRAW = registerBlock("cyan_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block LIGHT_BLUE_JACK_O_STRAW = registerBlock("light_blue_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block BLUE_JACK_O_STRAW = registerBlock("blue_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block PURPLE_JACK_O_STRAW = registerBlock("purple_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block MAGENTA_JACK_O_STRAW = registerBlock("magenta_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final Block PINK_JACK_O_STRAW = registerBlock("pink_jack_o_straw", new JackOStrawBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_YELLOW).strength(0.5F).lightLevel(createLightLevelFromLitBlockState(12)).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final Block GRISTMILL = registerBlock("gristmill", new GristmillBlock(BlockBehaviour.Properties.of().destroyTime(2.5f).instrument(NoteBlockInstrument.DIDGERIDOO).mapColor(MapColor.WOOD).sound(SoundType.WOOD)));
    public static final Block GREEN_TEA_CANDLE = registerBlock("green_tea_candle", new GreenTeaCandleBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.CANDLE).lightLevel(createLightLevelFromLitBlockState(12)).pushReaction(PushReaction.DESTROY)));
    public static final Block BLACK_TEA_CANDLE = registerBlock("black_tea_candle", new BlackTeaCandleBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.CANDLE).lightLevel(createLightLevelFromLitBlockState(12)).pushReaction(PushReaction.DESTROY)));
    public static final Block CHAMOMILE_CANDLE = registerBlock("chamomile_candle", new ChamomileCandleBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.CANDLE).lightLevel(createLightLevelFromLitBlockState(12)).pushReaction(PushReaction.DESTROY)));
    public static final Block HONEYSUCKLE_CANDLE = registerBlock("honeysuckle_candle", new HoneysuckleCandleBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.CANDLE).lightLevel(createLightLevelFromLitBlockState(12)).pushReaction(PushReaction.DESTROY)));
    public static final Block BELLFLOWER_CANDLE = registerBlock("bellflower_candle", new BellflowerCandleBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.CANDLE).lightLevel(createLightLevelFromLitBlockState(12)).pushReaction(PushReaction.DESTROY)));
    public static final Block TORCHFLOWER_CANDLE = registerBlock("torchflower_candle", new TorchflowerCandleBlock(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.CANDLE).lightLevel(createLightLevelFromLitBlockState(12)).pushReaction(PushReaction.DESTROY)));

    public static final Block PASSION_FRUIT_TART = registerBlock16StackItem("passion_fruit_tart", new TartBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block ELDERBERRY_TART = registerBlock16StackItem("elderberry_tart", new TartBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block GLOW_BERRY_TART = registerBlock16StackItem("glow_berry_tart", new TartBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block LAPISBERRY_TART = registerBlock16StackItem("lapisberry_tart", new TartBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block SWEET_BERRY_TART = registerBlock16StackItem("sweet_berry_tart", new TartBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block APPLE_PIE = registerBlock16StackItem("apple_pie", new PieBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block ORANGE_PIE = registerBlock16StackItem("orange_pie", new PieBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block LEMON_PIE = registerBlock16StackItem("lemon_pie", new PieBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block PLUM_PIE = registerBlock16StackItem("plum_pie", new PieBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block HOARY_PIE = registerBlock16StackItem("hoary_pie", new PieBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block PUMPKIN_PIE = registerBlockNoItem("pumpkin_pie", new PumpkinPieBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block MELON_PIE = registerBlock16StackItem("melon_pie", new PieBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block COCOA_CAKE = registerBlockUnstackableItem("cocoa_cake", new NoCandleCakeBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block SPONGE_CAKE = registerBlockUnstackableItem("sponge_cake", new SpongeCakeBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel((state) -> state.getValue(SpongeCakeBlock.PICKLED) && state.getValue(BlockStateProperties.BITES) == 0 ? 5 : 0)));
    public static final Block ARTISAN_BREAD = registerBlock16StackItem("artisan_bread", new ArtisanBreadBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final Block ARTISAN_COOKIE = registerBlockNoItem("artisan_cookies", new ArtisanCookiesBlock(BlockBehaviour.Properties.of().noOcclusion().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));

    public static Block OAK_PICKETS = registerBlock("oak_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block SPRUCE_PICKETS = registerBlock("spruce_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block BIRCH_PICKETS = registerBlock("birch_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block JUNGLE_PICKETS = registerBlock("jungle_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block ACACIA_PICKETS = registerBlock("acacia_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block DARK_OAK_PICKETS = registerBlock("dark_oak_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block MANGROVE_PICKETS = registerBlock("mangrove_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block CHERRY_PICKETS = registerBlock("cherry_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block BAMBOO_PICKETS = registerBlock("bamboo_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block WALNUT_PICKETS = registerBlock("walnut_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block HOARY_PICKETS = registerBlock("hoary_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block CRIMSON_PICKETS = registerBlock("crimson_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block WARPED_PICKETS = registerBlock("warped_pickets", new PicketsBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE).strength(0.5F).sound(BFSounds.LIGHT_WOOD).instrument(NoteBlockInstrument.BASS).forceSolidOff().noOcclusion()));
    public static Block IRON_RAILING = registerBlock("iron_railing", new PicketsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(1.0F, 2.0f).sound(SoundType.METAL).forceSolidOff().noOcclusion()));

    public static Block GRASSY_DIRT = registerBlock("grassy_dirt", new GrassyDirtBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).randomTicks()));


    public static final Block GOLDEN_APPLE_LOG = registerBlock("golden_apple_log", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).noOcclusion().forceSolidOff()), Rarity.UNCOMMON);
    public static final Block GOLDEN_APPLE_WOOD = registerBlock("golden_apple_wood", new FruitLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).noOcclusion().forceSolidOff()), Rarity.UNCOMMON);
    public static final Block GOLDEN_APPLE_LEAVES = registerBlock("golden_apple_leaves", new GoldenAppleLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.GOLD)), Rarity.UNCOMMON);
    public static final Block FLOWERING_GOLDEN_APPLE_LEAVES = registerBlock("flowering_golden_apple_leaves", new GoldenAppleLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.GOLD)), Rarity.UNCOMMON);
    public static final Block GOLDEN_APPLE_SAPLING = registerBlock("golden_apple_sapling", new PublicSaplingBlock(BFSaplingGenerators.GOLDEN_APPLE_SAPLING_GENERATOR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).lightLevel(state -> 7)), Rarity.RARE);
    public static final Block POTTED_GOLDEN_APPLE_SAPLING = registerBlockNoItem("potted_golden_apple_sapling", new FlowerPotBlock(BFBlocks.GOLDEN_APPLE_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).lightLevel(state -> 7)));
    public static final Block HANGING_GOLDEN_APPLE = registerBlockNoItem("hanging_golden_apple", new HangingGoldenAppleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).dynamicShape().sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY).randomTicks().offsetType(BlockBehaviour.OffsetType.XZ).lightLevel((state) -> 7)));
    public static final Block HANGING_WITHERED_GOLDEN_APPLE = registerBlockNoItem("hanging_withered_golden_apple", new HangingWitheredGoldenAppleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).dynamicShape().sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ)));



    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.getValue(BlockStateProperties.LIT) ? litLevel : 0;
    }

    public static ToIntFunction<BlockState> createLightLevelFromAgeBlockState(int lit1, int lit2, int lit3) {
        return state -> state.getValue(CropTrellisBlock.AGE) == 1 ? lit1 : state.getValue(CropTrellisBlock.AGE) == 2 ? lit2 : state.getValue(CropTrellisBlock.AGE) == 3 ? lit3 : 0;
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }

    public static Block registerBlock(String name, Block block, Item.Properties properties) {
        registerBlockItem(name, block);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), new BlockItem(block, properties));
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }

    private static Block registerDyeableCeramicBlock(String name, Block block, @Nullable Item.Properties itemSettings) {
        if (itemSettings == null) {
            itemSettings = new Item.Properties();
        }
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), new DyeableCeramicBlockItem(block, itemSettings));
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }

    public static Block registerBlock(String name, Block block, Rarity rarity) {
        registerBlockItem(name, block, rarity);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }

    private static Block registerBlockWithInfo(String name, Block block) {
        registerBlockItemWithInfo(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }

    private static void registerBlockItemWithInfo(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), new BlockItemWithInfo(block, new Item.Properties()));
    }

    private static Block registerBlockUnstackableItem(String name, Block block) {
        registerUnstackableBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }

    private static Block registerBlock16StackItem(String name, Block block) {
        register16StackItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }
    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), new BlockItem(block, new Item.Properties()));
    }

    private static void registerBlockItem(String name, Block block, Rarity rarity) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), new BlockItem(block, new Item.Properties().rarity(rarity)));
    }

    private static void register16StackItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), new BlockItem(block, new Item.Properties().stacksTo(16)));
    }

    private static void registerUnstackableBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), new BlockItem(block, new Item.Properties().stacksTo(1)));
    }

    private static Block registerCeramicDishBlock(String name, Block block) {
        registerCeramicDishBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), block);
    }
    private static void registerCeramicDishBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name), new CeramicDishBlockItem(block, new Item.Properties()));
    }

    public static void registerModBlocks() {
    }
}
