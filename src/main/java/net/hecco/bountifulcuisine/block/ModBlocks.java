package net.hecco.bountifulcuisine.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.custom.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block APPLE_LOG = registerBlock("apple_log", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_LOG).ticksRandomly()));
    public static final Block STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block APPLE_WOOD = registerBlock("apple_wood", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood", new AppleLogBlock(ModBlocks.APPLE_LEAVES, ModBlocks.BLOSSOMING_APPLE_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves", new AppleLeavesBlock(ModBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block BLOSSOMING_APPLE_LEAVES = registerBlock("blossoming_apple_leaves", new AppleLeavesBlock(ModBlocks.HANGING_APPLE, FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block HANGING_APPLE = registerBlockNoItem("hanging_apple", new HangingAppleBlock(FabricBlockSettings.copyOf(Blocks.GRASS).ticksRandomly().offset(AbstractBlock.OffsetType.XZ)));
    public static final Block APPLE_SAPLING = registerBlock("apple_sapling", new SaplingBlock(new OakSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).sounds(BlockSoundGroup.CHERRY_SAPLING)));
    public static final Block ORANGE_LOG = registerBlock("orange_log", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_LOG)));
    public static final Block STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_LOG)));
    public static final Block ORANGE_WOOD = registerBlock("orange_wood", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.APPLE_WOOD)));
    public static final Block STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood", new OrangeLogBlock(ModBlocks.ORANGE_LEAVES, ModBlocks.BLOSSOMING_ORANGE_LEAVES, FabricBlockSettings.copyOf(ModBlocks.STRIPPED_APPLE_WOOD)));
    public static final Block ORANGE_LEAVES = registerBlock("orange_leaves", new OrangeLeavesBlock(ModBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(ModBlocks.APPLE_LEAVES)));
    public static final Block BLOSSOMING_ORANGE_LEAVES = registerBlock("blossoming_orange_leaves", new OrangeLeavesBlock(ModBlocks.HANGING_ORANGE, FabricBlockSettings.copyOf(ModBlocks.BLOSSOMING_APPLE_LEAVES)));
    public static final Block HANGING_ORANGE = registerBlockNoItem("hanging_orange", new HangingOrangeBlock(FabricBlockSettings.copyOf(ModBlocks.HANGING_APPLE)));
    public static final Block ORANGE_SAPLING = registerBlock("orange_sapling", new SaplingBlock(new OakSaplingGenerator(), FabricBlockSettings.copyOf(ModBlocks.APPLE_SAPLING)));





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
