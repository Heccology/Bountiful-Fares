package net.hecco.bountifulcuisine.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.custom.*;
import net.hecco.bountifulcuisine.block.custom.template.PlantedTrellisBlock;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.world.tree.AppleSaplingGenerator;
import net.hecco.bountifulcuisine.world.tree.LemonSaplingGenerator;
import net.hecco.bountifulcuisine.world.tree.OrangeSaplingGenerator;
import net.hecco.bountifulcuisine.world.tree.PlumSaplingGenerator;
import net.minecraft.block.*;
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
    public static final Block TRELLIS = registerBlock("trellis", new TrellisBlock(FabricBlockSettings.create().strength(0.5F).sounds(BlockSoundGroup.WOOD).nonOpaque().requiresTool()));
    public static final Block PASSION_FRUIT_TRELLIS = registerBlockNoItem("passion_fruit_trellis", new PassionFruitTrellisBlock(ModItems.PASSION_FRUIT, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().requiresTool()));
    public static final Block ELDERBERRY_TRELLIS = registerBlockNoItem("elderberry_trellis", new ElderberryTrellisBlock(ModItems.ELDERBERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().requiresTool()));
    public static final Block GLOW_BERRY_TRELLIS = registerBlockNoItem("glow_berry_trellis", new GlowBerryTrellisBlock(Items.GLOW_BERRIES, FabricBlockSettings.copyOf(ModBlocks.TRELLIS).ticksRandomly().requiresTool()));
    public static final Block WILD_CARROTS = registerBlockNoItem("wild_carrots", new WildCropBlock(ModItems.WILD_CARROT, FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_POTATOES = registerBlockNoItem("wild_potatoes", new WildCropBlock(ModItems.WILD_POTATO, FabricBlockSettings.create().mapColor(MapColor.DULL_PINK).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_WHEAT = registerBlockNoItem("wild_wheat", new WildCropBlock(ModItems.WILD_WHEAT_SEEDS, FabricBlockSettings.create().mapColor(MapColor.OAK_TAN).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WILD_BEETROOTS = registerBlockNoItem("wild_beetroots", new WildCropBlock(ModItems.WILD_BEETROOT_SEEDS, FabricBlockSettings.create().mapColor(MapColor.DULL_PINK).noCollision().breakInstantly().sounds(BlockSoundGroup.CROP).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FERMENTATION_VESSEL = registerBlock("fermentation_vessel", new FermentationVesselBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).requiresTool().nonOpaque().sounds(BlockSoundGroup.DECORATED_POT)));
    public static final Block FULL_FERMENTATION_VESSEL = registerBlockNoItem("full_fermentation_vessel", new FullFermentationVesselBlock(FabricBlockSettings.create().mapColor(MapColor.OFF_WHITE).strength(2, 5).requiresTool().nonOpaque().ticksRandomly().sounds(BlockSoundGroup.DECORATED_POT)));





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

    public static void registerModBlocks() {
        BountifulCuisine.LOGGER.debug("Registering ModBlocks for " + BountifulCuisine.MOD_ID);
    }
}
