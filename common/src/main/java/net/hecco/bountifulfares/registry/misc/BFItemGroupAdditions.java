package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.definition.item.component.TiffinContents;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import oshi.util.tuples.Pair;

import java.util.ArrayList;

public class BFItemGroupAdditions {
    public static ArrayList<Pair<ItemLike, ItemStack>> BUILDING_BLOCKS = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> NATURAL_BLOCKS = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> FUNCTIONAL_BLOCKS = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> REDSTONE_BLOCKS = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> TOOLS_AND_UTILITIES = new ArrayList<>();
    public static ArrayList<Pair<ItemStack, ItemStack>> TOOLS_AND_UTILITIES_FORGE = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> COMBAT = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> FOOD_AND_DRINKS = new ArrayList<>();
    public static ArrayList<Pair<ItemStack, ItemStack>> FOOD_AND_DRINKS_FORGE = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> INGREDIENTS = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> COLORED_BLOCKS = new ArrayList<>();
    public static ArrayList<Pair<ItemLike, ItemStack>> OP_BLOCKS = new ArrayList<>();
    public static void registerItemGroupAdditions() {
        BUILDING_BLOCKS = new ArrayList<>();
        NATURAL_BLOCKS = new ArrayList<>();
        FUNCTIONAL_BLOCKS = new ArrayList<>();
        REDSTONE_BLOCKS = new ArrayList<>();
        TOOLS_AND_UTILITIES = new ArrayList<>();
        COMBAT = new ArrayList<>();
        FOOD_AND_DRINKS = new ArrayList<>();
        INGREDIENTS = new ArrayList<>();
        COLORED_BLOCKS = new ArrayList<>();
        OP_BLOCKS = new ArrayList<>();

        BUILDING_BLOCKS.add(new Pair<>(Items.OAK_FENCE_GATE, BFBlocks.PICKETS.get("oak").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.SPRUCE_FENCE_GATE, BFBlocks.PICKETS.get("spruce").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.BIRCH_FENCE_GATE, BFBlocks.PICKETS.get("birch").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.JUNGLE_FENCE_GATE, BFBlocks.PICKETS.get("jungle").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.ACACIA_FENCE_GATE, BFBlocks.PICKETS.get("acacia").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.DARK_OAK_FENCE_GATE, BFBlocks.PICKETS.get("dark_oak").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.MANGROVE_FENCE_GATE, BFBlocks.PICKETS.get("mangrove").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.CHERRY_FENCE_GATE, BFBlocks.PICKETS.get("cherry").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.BAMBOO_FENCE_GATE, BFBlocks.PICKETS.get("bamboo").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.BAMBOO_BUTTON, BFBlocks.WALNUT_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_LOG.get(), BFBlocks.WALNUT_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_WOOD.get(), BFBlocks.STRIPPED_WALNUT_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_WALNUT_LOG.get(), BFBlocks.STRIPPED_WALNUT_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_WALNUT_WOOD.get(), BFBlocks.WALNUT_PLANKS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_PLANKS.get(), BFBlocks.WALNUT_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_STAIRS.get(), BFBlocks.WALNUT_SLAB.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_SLAB.get(), BFBlocks.WALNUT_FENCE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_FENCE.get(), BFBlocks.WALNUT_FENCE_GATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_FENCE_GATE.get(), BFBlocks.PICKETS.get("walnut").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PICKETS.get("walnut").get(), BFBlocks.WALNUT_DOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_DOOR.get(), BFBlocks.WALNUT_TRAPDOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_TRAPDOOR.get(), BFBlocks.WALNUT_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_PRESSURE_PLATE.get(), BFBlocks.WALNUT_BUTTON.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_BUTTON.get(), BFBlocks.HOARY_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_LOG.get(), BFBlocks.HOARY_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_WOOD.get(), BFBlocks.STRIPPED_HOARY_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_HOARY_LOG.get(), BFBlocks.STRIPPED_HOARY_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_HOARY_WOOD.get(), BFBlocks.HOARY_PLANKS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_PLANKS.get(), BFBlocks.HOARY_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_STAIRS.get(), BFBlocks.HOARY_SLAB.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_SLAB.get(), BFBlocks.HOARY_FENCE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_FENCE.get(), BFBlocks.HOARY_FENCE_GATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_FENCE_GATE.get(), BFBlocks.PICKETS.get("hoary").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PICKETS.get("hoary").get(), BFBlocks.HOARY_DOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_DOOR.get(), BFBlocks.HOARY_TRAPDOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_TRAPDOOR.get(), BFBlocks.HOARY_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.HOARY_PRESSURE_PLATE.get(), BFBlocks.HOARY_BUTTON.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.CRIMSON_FENCE_GATE, BFBlocks.PICKETS.get("crimson").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.WARPED_FENCE_GATE, BFBlocks.PICKETS.get("warped").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.WARPED_BUTTON, BFBlocks.APPLE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.APPLE_LOG.get(), BFBlocks.APPLE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.APPLE_WOOD.get(), BFBlocks.STRIPPED_APPLE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_APPLE_LOG.get(), BFBlocks.STRIPPED_APPLE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_APPLE_WOOD.get(), BFBlocks.ORANGE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.ORANGE_LOG.get(), BFBlocks.ORANGE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.ORANGE_WOOD.get(), BFBlocks.STRIPPED_ORANGE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_ORANGE_LOG.get(), BFBlocks.STRIPPED_ORANGE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_ORANGE_WOOD.get(), BFBlocks.LEMON_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.LEMON_LOG.get(), BFBlocks.LEMON_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.LEMON_WOOD.get(), BFBlocks.STRIPPED_LEMON_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_LEMON_LOG.get(), BFBlocks.STRIPPED_LEMON_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_LEMON_WOOD.get(), BFBlocks.PLUM_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PLUM_LOG.get(), BFBlocks.PLUM_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PLUM_WOOD.get(), BFBlocks.STRIPPED_PLUM_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_PLUM_LOG.get(), BFBlocks.STRIPPED_PLUM_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_PLUM_WOOD.get(), BFBlocks.PALM_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PALM_LOG.get(), BFBlocks.PALM_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PALM_WOOD.get(), BFBlocks.STRIPPED_PALM_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_PALM_LOG.get(), BFBlocks.STRIPPED_PALM_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_PALM_WOOD.get(), BFBlocks.GOLDEN_APPLE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.GOLDEN_APPLE_LOG.get(), BFBlocks.GOLDEN_APPLE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.STRIPPED_PLUM_WOOD.get(), BFBlocks.WALNUT_MULCH.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_MULCH.get(), BFBlocks.WALNUT_MULCH_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_MULCH_BLOCK.get(), BFBlocks.PALM_MULCH.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PALM_MULCH.get(), BFBlocks.PALM_MULCH_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Blocks.MUD_BRICK_WALL, BFBlocks.PACKED_COCONUT_COIR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PACKED_COCONUT_COIR.get(), BFBlocks.COIR_CARPET.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.COIR_CARPET.get(), BFBlocks.COIR_BRICKS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.COIR_BRICKS.get(), BFBlocks.COIR_BRICK_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.COIR_BRICK_STAIRS.get(), BFBlocks.COIR_BRICK_SLAB.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.COIR_BRICK_SLAB.get(), BFBlocks.COIR_BRICK_WALL.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Items.DARK_PRISMARINE_SLAB, BFBlocks.PRISMARINE_BLOSSOM.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.PRISMARINE_BLOSSOM.get(), BFBlocks.FELDSPAR_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.FELDSPAR_BLOCK.get(), BFBlocks.CUT_FELDSPAR_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CUT_FELDSPAR_BLOCK.get(), BFBlocks.FELDSPAR_BRICKS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.FELDSPAR_BRICKS.get(), BFBlocks.FELDSPAR_BRICK_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.FELDSPAR_BRICK_STAIRS.get(), BFBlocks.FELDSPAR_BRICK_SLAB.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.FELDSPAR_BRICK_SLAB.get(), BFBlocks.FELDSPAR_BRICK_WALL.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.FELDSPAR_BRICK_WALL.get(), BFBlocks.CERAMIC_CLAY_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_CLAY_BLOCK.get(), BFBlocks.CERAMIC_TILES.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CERAMIC_TILE_SLAB.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILE_WALL.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_TILE_WALL, BFBlocks.CRACKED_CERAMIC_TILES.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CRACKED_CERAMIC_TILES.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_PILLAR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TILE_PILLAR.get(), BFBlocks.CERAMIC_MOSAIC.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CERAMIC_MOSAIC_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC_SLAB.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC_WALL.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_WALL, BFBlocks.CERAMIC_DOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_MOSAIC_SLAB.get(), BFBlocks.CERAMIC_DOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_DOOR.get(), BFBlocks.CERAMIC_TRAPDOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TRAPDOOR.get(), BFBlocks.CERAMIC_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_PRESSURE_PLATE.get(), BFBlocks.CERAMIC_BUTTON.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(new Pair<>(Blocks.IRON_BARS, BFBlocks.IRON_RAILING.get().asItem().getDefaultInstance()));

        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("building_blocks")),
                    BUILDING_BLOCKS
            );
        }

        NATURAL_BLOCKS.add(new Pair<>(Items.GRASS_BLOCK, BFBlocks.GRASSY_DIRT.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Items.CHERRY_LOG, BFBlocks.APPLE_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.APPLE_LOG.get(), BFBlocks.ORANGE_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.ORANGE_LOG.get(), BFBlocks.LEMON_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.LEMON_LOG.get(), BFBlocks.PLUM_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.PLUM_LOG.get(), BFBlocks.PALM_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.PALM_LOG.get(), BFBlocks.PALM_CROWN.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.PALM_CROWN.get(), BFBlocks.WALNUT_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_LOG.get(), BFBlocks.HOARY_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Items.FLOWERING_AZALEA_LEAVES, BFBlocks.APPLE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.APPLE_LEAVES.get(), BFBlocks.FLOWERING_APPLE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.FLOWERING_APPLE_LEAVES.get(), BFBlocks.ORANGE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.ORANGE_LEAVES.get(), BFBlocks.FLOWERING_ORANGE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>( BFBlocks.FLOWERING_ORANGE_LEAVES.get(), BFBlocks.LEMON_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.LEMON_LEAVES.get(), BFBlocks.FLOWERING_LEMON_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.FLOWERING_LEMON_LEAVES.get(), BFBlocks.PLUM_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.PLUM_LEAVES.get(), BFBlocks.FLOWERING_PLUM_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.FLOWERING_PLUM_LEAVES.get(), BFBlocks.GOLDEN_APPLE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.GOLDEN_APPLE_LEAVES.get(), BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get(), BFBlocks.WALNUT_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_LEAVES.get(), BFBlocks.HOARY_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.HOARY_LEAVES.get(), BFItems.PALM_FROND.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Items.CHERRY_SAPLING, BFBlocks.APPLE_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.APPLE_SAPLING.get(), BFBlocks.ORANGE_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.ORANGE_SAPLING.get(), BFBlocks.LEMON_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.LEMON_SAPLING.get(), BFBlocks.PLUM_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.PLUM_SAPLING.get(), BFBlocks.HOARY_APPLE_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.HOARY_APPLE_SAPLING.get(), BFBlocks.WALNUT_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Blocks.FLOWERING_AZALEA, BFItems.COCONUT.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Items.SNIFFER_EGG, BFBlocks.WILD_WHEAT.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WILD_WHEAT.get(), BFBlocks.WILD_CARROTS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WILD_CARROTS.get(), BFBlocks.WILD_POTATOES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WILD_POTATOES.get(), BFBlocks.WILD_BEETROOTS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WILD_BEETROOTS.get(), BFBlocks.WILD_LEEKS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WILD_LEEKS.get(), BFBlocks.WILD_MAIZE.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WILD_MAIZE.get(), BFBlocks.WILD_PASSION_FRUIT_VINE.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WILD_PASSION_FRUIT_VINE.get(), BFBlocks.WILD_ELDERBERRY_VINE.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.WILD_ELDERBERRY_VINE.get(), BFBlocks.SPONGEKIN_SPROUT.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.SPONGEKIN_SPROUT.get(), BFItems.GRASS_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFItems.GRASS_SEEDS.get(), BFItems.SWEET_BERRY_PIPS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Items.KELP, BFBlocks.SPONGEKIN.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.SPONGEKIN.get(), BFBlocks.PRISMARINE_BLOSSOM.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Items.LILY_OF_THE_VALLEY, BFBlocks.CHAMOMILE_FLOWERS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.CHAMOMILE_FLOWERS.get(), BFBlocks.HONEYSUCKLE.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFBlocks.HONEYSUCKLE.get(), BFBlocks.VIOLET_BELLFLOWER.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Items.BEETROOT_SEEDS, BFItems.MAIZE_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFItems.MAIZE_SEEDS.get(), BFItems.LEEK_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFItems.LEEK_SEEDS.get(), BFItems.TEA_BERRIES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFItems.TEA_BERRIES.get(), BFItems.SPONGEKIN_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(Items.PITCHER_POD, BFItems.LAPISBERRY_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(new Pair<>(BFItems.LAPISBERRY_SEEDS.get(), BFItems.HOARY_SEEDS.get().asItem().getDefaultInstance()));

        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("natural_blocks")),
                    NATURAL_BLOCKS
            );
        }


        FUNCTIONAL_BLOCKS.add(new Pair<>(Items.LANTERN, BFBlocks.FELDSPAR_LANTERN.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(Items.GRINDSTONE, BFBlocks.GRISTMILL.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(Items.SOUL_CAMPFIRE, BFBlocks.GREEN_TEA_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.GREEN_TEA_CANDLE.get(), BFBlocks.BLACK_TEA_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.BLACK_TEA_CANDLE.get(), BFBlocks.CHAMOMILE_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.CHAMOMILE_CANDLE.get(), BFBlocks.HONEYSUCKLE_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.HONEYSUCKLE_CANDLE.get(), BFBlocks.BELLFLOWER_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.BELLFLOWER_CANDLE.get(), BFBlocks.TORCHFLOWER_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.TORCHFLOWER_CANDLE.get(), BFBlocks.WALNUT_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.WALNUT_CANDLE.get(), BFBlocks.FERMENTATION_VESSEL.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.FERMENTATION_VESSEL.get(), BFBlocks.COCONUT_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFBlocks.COCONUT_CANDLE.get(), BFBlocks.GOLDEN_APPLE_SAPLING.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(Items.SCAFFOLDING, BFBlocks.FLOUR_BLOCK.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(Items.PINK_BED, BFBlocks.COIR_BED.get().asItem().getDefaultInstance()));
        Block prev = Blocks.COMPOSTER;
        for (String wood : BountifulFaresUtil.WOOD_TYPES) {
            FUNCTIONAL_BLOCKS.add(new Pair<>(prev, BFBlocks.TRELLISES.get(wood).get().asItem().getDefaultInstance()));
            prev = BFBlocks.TRELLISES.get(wood).get();
        }
////            if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(BFTrellises.WINTERGREEN));
////                prevTrellis = BFTrellises.WINTERGREEN;
////            }
//
//
////            if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.REDWOOD), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SUGI), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WISTERIA), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.FIR), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.WILLOW), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.ASPEN), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAPLE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CYPRESS), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.OLIVE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.JOSHUA), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.GHAF), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.PALO_VERDE), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.COCONUT), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.CEDAR), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.LARCH), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY));
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.MAHOGANY), TrellisUtil.getTrellisFromVariant(NaturesSpiritBlocks.SAXAUL));
////                prevTrellis = NaturesSpiritBlocks.SAXAUL;
////            }
////            if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(ExcessiveBuildingBlocks.ANCIENT));
////                prevTrellis = ExcessiveBuildingBlocks.ANCIENT;
////            }
////            if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
////                entries.addAfter(TrellisUtil.getTrellisFromVariant(prevTrellis), TrellisUtil.getTrellisFromVariant(SpawnBlocks.ROTTEN));
////                prevTrellis = SpawnBlocks.ROTTEN;
////            }
        FUNCTIONAL_BLOCKS.add(new Pair<>(Items.TINTED_GLASS, BFBlocks.TINGED_GLASS.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(Items.BAMBOO_HANGING_SIGN, BFItems.WALNUT_SIGN.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFItems.WALNUT_SIGN.get(), BFItems.WALNUT_HANGING_SIGN.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFItems.WALNUT_HANGING_SIGN.get(), BFItems.HOARY_SIGN.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(new Pair<>(BFItems.HOARY_SIGN.get(), BFItems.HOARY_HANGING_SIGN.get().asItem().getDefaultInstance()));
//
        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("functional_blocks")),
                    FUNCTIONAL_BLOCKS
            );
        }
//
        REDSTONE_BLOCKS.add(new Pair<>(Items.LEVER, BFBlocks.CERAMIC_LEVER.get().asItem().getDefaultInstance()));
        REDSTONE_BLOCKS.add(new Pair<>(Items.STONE_BUTTON, BFBlocks.CERAMIC_BUTTON.get().asItem().getDefaultInstance()));
        REDSTONE_BLOCKS.add(new Pair<>(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, BFBlocks.CERAMIC_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        REDSTONE_BLOCKS.add(new Pair<>(Items.WHITE_WOOL, BFBlocks.CERAMIC_TILES.get().asItem().getDefaultInstance()));
        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("redstone_blocks")),
                    REDSTONE_BLOCKS
            );
        }
        TOOLS_AND_UTILITIES.add(new Pair<>(Items.LEAD, BFItems.SUN_HAT.get().asItem().getDefaultInstance()));
        TOOLS_AND_UTILITIES.add(new Pair<>(Items.BRUSH, BFItems.ARTISAN_BRUSH.get().asItem().getDefaultInstance()));
//        TOOLS_AND_UTILITIES.add(new Pair<>(Items.BAMBOO_CHEST_RAFT, BFItems.WALNUT_BOAT);
//        TOOLS_AND_UTILITIES.add(new Pair<>(BFItems.WALNUT_BOAT, BFItems.WALNUT_CHEST_BOAT);
//        TOOLS_AND_UTILITIES.add(new Pair<>(BFItems.WALNUT_CHEST_BOAT, BFItems.HOARY_BOAT);
//        TOOLS_AND_UTILITIES.add(new Pair<>(BFItems.HOARY_BOAT, BFItems.HOARY_CHEST_BOAT);

        addTiffinForge(TOOLS_AND_UTILITIES_FORGE, BFItems.SUN_HAT.get(), null);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, null, DyeColor.WHITE);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.WHITE, DyeColor.LIGHT_GRAY);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.LIGHT_GRAY, DyeColor.GRAY);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.GRAY, DyeColor.BLACK);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.BLACK, DyeColor.BROWN);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.BROWN, DyeColor.RED);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.RED, DyeColor.ORANGE);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.ORANGE, DyeColor.YELLOW);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.YELLOW, DyeColor.LIME);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.LIME, DyeColor.GREEN);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.GREEN, DyeColor.CYAN);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.CYAN, DyeColor.LIGHT_BLUE);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.LIGHT_BLUE, DyeColor.BLUE);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.BLUE, DyeColor.PURPLE);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.PURPLE, DyeColor.MAGENTA);
        addTiffin(TOOLS_AND_UTILITIES_FORGE, DyeColor.MAGENTA, DyeColor.PINK);

        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("tools_and_utilities")),
                    TOOLS_AND_UTILITIES
            );
        }

        COMBAT.add(new Pair<>(Items.EGG, BFItems.FLOUR.get().asItem().getDefaultInstance()));

        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("combat")),
                    COMBAT
            );
        }

        FOOD_AND_DRINKS.add(new Pair<>(Items.APPLE, BFItems.APPLE_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.APPLE_COMPOTE_JAR.get(), BFItems.APPLE_CIDER_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.APPLE_CIDER_JAR.get(), BFBlocks.APPLE_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.APPLE_BLOCK.get(), BFItems.ORANGE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.ORANGE.get(), BFItems.ORANGE_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.ORANGE_COMPOTE_JAR.get(), BFBlocks.ORANGE_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.ORANGE_BLOCK.get(), BFItems.LEMON.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.LEMON.get(), BFItems.LEMON_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.LEMON_COMPOTE_JAR.get(), BFBlocks.LEMON_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.LEMON_BLOCK.get(), BFItems.PLUM.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PLUM.get(), BFItems.PLUM_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PLUM_COMPOTE_JAR.get(), BFItems.PLUM_CIDER_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PLUM_CIDER_JAR.get(), BFBlocks.PLUM_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.PLUM_BLOCK.get(), BFItems.HOARY_APPLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.HOARY_APPLE.get(), BFItems.STUFFED_HOARY_APPLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.STUFFED_HOARY_APPLE.get(), BFItems.HOARY_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.HOARY_COMPOTE_JAR.get(), BFItems.HOARY_CIDER_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.HOARY_CIDER_JAR.get(), BFBlocks.HOARY_APPLE_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.HOARY_APPLE_BLOCK.get(), BFItems.COCONUT_HALF.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.ENCHANTED_GOLDEN_APPLE, BFBlocks.GOLDEN_APPLE_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.MELON_SLICE, BFItems.SPONGEKIN_SLICE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.SPONGEKIN_SLICE.get(), BFItems.PICKLED_SPONGEKIN.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.SWEET_BERRIES, BFItems.PASSION_FRUIT.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PASSION_FRUIT.get(), BFItems.ELDERBERRIES.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.ELDERBERRIES.get(), BFItems.ELDERBERRY_WINE_BOTTLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.GLOW_BERRIES, BFItems.LAPISBERRIES.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.LAPISBERRIES.get(), BFItems.LAPISBERRY_WINE_BOTTLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.MILK_BUCKET, BFItems.COCONUT_MILK_BOTTLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.COCONUT_MILK_BOTTLE.get(), BFItems.WATER_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.WATER_CUP.get(), BFItems.GREEN_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.GREEN_TEA_CUP.get(), BFItems.BLACK_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.BLACK_TEA_CUP.get(), BFItems.CHAMOMILE_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CHAMOMILE_TEA_CUP.get(), BFItems.HONEYSUCKLE_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.HONEYSUCKLE_TEA_CUP.get(), BFItems.BELLFLOWER_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.BELLFLOWER_TEA_CUP.get(), BFItems.TORCHFLOWER_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.HONEY_BOTTLE, BFItems.MEAD_BOTTLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.BAKED_POTATO, BFItems.MUSHROOM_STUFFED_POTATO.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.MUSHROOM_STUFFED_POTATO.get(), BFItems.BERRY_STUFFED_POTATO.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.BERRY_STUFFED_POTATO.get(), BFItems.MAIZE_STUFFED_POTATO.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.BEETROOT, BFItems.PICKLED_BEETROOT.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PICKLED_BEETROOT.get(), BFItems.MAIZE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.MAIZE.get(), BFItems.LEEK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.LEEK.get(), BFItems.WALNUT.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.WALNUT.get(), BFItems.POPPED_MAIZE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.PUFFERFISH, BFItems.COOKED_EGG.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.BREAD, BFItems.MAIZE_BREAD.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.MAIZE_BREAD.get(), BFBlocks.ARTISAN_BREAD.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.COOKIE, BFItems.WALNUT_COOKIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.WALNUT_COOKIE.get(), BFItems.ARTISAN_COOKIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.ARTISAN_COOKIE.get(), BFBlocks.PASSION_FRUIT_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.PASSION_FRUIT_TART.get(), BFBlocks.ELDERBERRY_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.ELDERBERRY_TART.get(), BFBlocks.GLOW_BERRY_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.GLOW_BERRY_TART.get(), BFBlocks.SWEET_BERRY_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.SWEET_BERRY_TART.get(), BFBlocks.LAPISBERRY_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.CAKE, BFBlocks.COCOA_CAKE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.COCOA_CAKE.get(), BFBlocks.COCONUT_CAKE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.COCONUT_CAKE.get(), BFBlocks.SPONGE_CAKE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.PUMPKIN_PIE, BFBlocks.MELON_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.MELON_PIE.get(), BFBlocks.APPLE_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.APPLE_PIE.get(), BFBlocks.ORANGE_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.ORANGE_PIE.get(), BFBlocks.LEMON_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.LEMON_PIE.get(), BFBlocks.PLUM_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFBlocks.PLUM_PIE.get(), BFBlocks.HOARY_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.ROTTEN_FLESH, BFItems.FOUL_FLESH.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.SPIDER_EYE, BFItems.CITRUS_ESSENCE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CITRUS_ESSENCE.get(), BFItems.CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CANDY.get(), BFItems.PIQUANT_CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PIQUANT_CANDY.get(), BFItems.SOUR_CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.SOUR_CANDY.get(), BFItems.BITTER_CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.BITTER_CANDY.get(), BFItems.STRANGE_CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.STRANGE_CANDY.get(), BFItems.CANDIED_APPLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CANDIED_APPLE.get(), BFItems.CANDIED_PLUM.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CANDIED_PLUM.get(), BFItems.CANDIED_ORANGE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CANDIED_ORANGE.get(), BFItems.CANDIED_LEMON.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CANDIED_LEMON.get(), BFItems.FOREST_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.FOREST_MEDLEY.get(), BFItems.ARID_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.ARID_MEDLEY.get(), BFItems.MEADOW_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.MEADOW_MEDLEY.get(), BFItems.MIRE_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.MIRE_MEDLEY.get(), BFItems.COASTAL_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.COASTAL_MEDLEY.get(), BFItems.TROPICAL_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.TROPICAL_MEDLEY.get(), BFItems.SEA_SALAD.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(Items.RABBIT_STEW, BFItems.LEEK_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.LEEK_STEW.get(), BFItems.FISH_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.FISH_STEW.get(), BFItems.APPLE_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.APPLE_STEW.get(), BFItems.COCONUT_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.COCONUT_STEW.get(), BFItems.STONE_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.STONE_STEW.get(), BFItems.BOUNTIFUL_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.BOUNTIFUL_STEW.get(), BFItems.COCONUT_CRUSTED_COD.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.COCONUT_CRUSTED_COD.get(), BFItems.PASSION_GLAZED_SALMON.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PASSION_GLAZED_SALMON.get(), BFItems.CRUSTED_BEEF.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CRUSTED_BEEF.get(), BFItems.CRIMSON_CHOW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CRIMSON_CHOW.get(), BFItems.WARPED_CHOW.get().asItem().getDefaultInstance()));
//        FOOD_AND_DRINKS.add(new Pair<>(BFItems.WARPED_CHOW.get(), BFItems.CUSTARD.get().asItem().getDefaultInstance()));
//        FOOD_AND_DRINKS.add(new Pair<>(BFItems.CUSTARD.get(), BFItems.PIQUANT_CUSTARD.get().asItem().getDefaultInstance()));
//        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PIQUANT_CUSTARD.get(), BFItems.PASSION_CUSTARD.get().asItem().getDefaultInstance()));
//        FOOD_AND_DRINKS.add(new Pair<>(BFItems.PASSION_CUSTARD.get(), BFItems.COCOA_CUSTARD.get().asItem().getDefaultInstance()));
//        FOOD_AND_DRINKS.add(new Pair<>(BFItems.COCOA_CUSTARD.get(), BFItems.ANCIENT_CUSTARD.get().asItem().getDefaultInstance()));

        addTiffinForge(FOOD_AND_DRINKS_FORGE, BFItems.TORCHFLOWER_TEA_CUP.get(), null);
        addTiffin(FOOD_AND_DRINKS_FORGE, null, DyeColor.WHITE);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.WHITE, DyeColor.LIGHT_GRAY);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.LIGHT_GRAY, DyeColor.GRAY);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.GRAY, DyeColor.BLACK);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.BLACK, DyeColor.BROWN);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.BROWN, DyeColor.RED);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.RED, DyeColor.ORANGE);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.ORANGE, DyeColor.YELLOW);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.YELLOW, DyeColor.LIME);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.LIME, DyeColor.GREEN);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.GREEN, DyeColor.CYAN);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.CYAN, DyeColor.LIGHT_BLUE);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.LIGHT_BLUE, DyeColor.BLUE);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.BLUE, DyeColor.PURPLE);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.PURPLE, DyeColor.MAGENTA);
        addTiffin(FOOD_AND_DRINKS_FORGE, DyeColor.MAGENTA, DyeColor.PINK);




        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("food_and_drinks")),
                    FOOD_AND_DRINKS
            );
        }

        INGREDIENTS.add(new Pair<>(Items.WHEAT, BFItems.MAIZE.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(BFItems.MAIZE.get(), BFItems.FLOUR.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(Items.SLIME_BALL, BFItems.FELDSPAR.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(BFItems.FELDSPAR.get(), BFItems.CERAMIC_CLAY.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(BFItems.CERAMIC_CLAY.get(), BFItems.CERAMIC_TILE.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(Items.BOWL, BFBlocks.CERAMIC_DISH.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(BFBlocks.CERAMIC_DISH.get(), BFItems.CUP.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(Items.FIREWORK_STAR, BFItems.COCONUT.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(BFItems.COCONUT.get(), BFItems.COCONUT_HALF.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(BFItems.COCONUT_HALF.get(), BFItems.COCONUT_COIR.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(BFItems.COCONUT_COIR.get(), BFItems.TEA_LEAVES.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(new Pair<>(BFItems.TEA_LEAVES.get(), BFItems.DRIED_TEA_LEAVES.get().asItem().getDefaultInstance()));

        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("ingredients")),
                    INGREDIENTS
            );
        }

        COLORED_BLOCKS.add(new Pair<>(Items.PINK_GLAZED_TERRACOTTA, BFBlocks.CERAMIC_TILES.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_STAIRS.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CERAMIC_TILE_SLAB.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILE_WALL.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_TILE_WALL, BFBlocks.CRACKED_CERAMIC_TILES.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CRACKED_CERAMIC_TILES.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_PILLAR.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_TILE_PILLAR.get(), BFBlocks.CERAMIC_MOSAIC.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CERAMIC_MOSAIC_STAIRS.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC_SLAB.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC_WALL.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(Items.PINK_BANNER, BFBlocks.WHITE_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.WHITE_JACK_O_STRAW.get(), BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), BFBlocks.GRAY_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.GRAY_JACK_O_STRAW.get(), BFBlocks.BLACK_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.BLACK_JACK_O_STRAW.get(), BFBlocks.BROWN_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.BROWN_JACK_O_STRAW.get(), BFBlocks.RED_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.RED_JACK_O_STRAW.get(), BFBlocks.ORANGE_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.ORANGE_JACK_O_STRAW.get(), BFBlocks.YELLOW_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.YELLOW_JACK_O_STRAW.get(), BFBlocks.LIME_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.LIME_JACK_O_STRAW.get(), BFBlocks.GREEN_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.GREEN_JACK_O_STRAW.get(), BFBlocks.CYAN_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.CYAN_JACK_O_STRAW.get(), BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), BFBlocks.BLUE_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.BLUE_JACK_O_STRAW.get(), BFBlocks.PURPLE_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.PURPLE_JACK_O_STRAW.get(), BFBlocks.MAGENTA_JACK_O_STRAW.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(new Pair<>(BFBlocks.MAGENTA_JACK_O_STRAW.get(), BFBlocks.PINK_JACK_O_STRAW.get().asItem().getDefaultInstance()));

        if (HLServices.PLATFORM.getPlatformName() == "Fabric") {
            HLServices.REGISTRY.addItemsToItemGroup(
                    ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("colored_blocks")),
                    COLORED_BLOCKS
            );
        }
    }

    public static void addTiffin(ArrayList<Pair<ItemLike, ItemStack>> tab, ItemLike prev, DyeColor color) {
        ItemStack stack = BFItems.TIFFINS.get(color).get().getDefaultInstance();
        stack.set(BFComponents.TIFFIN_CONTENTS.get(), new TiffinContents());
        tab.add(new Pair<>(prev, stack));
    }

    private static void addTiffinForge(ArrayList<Pair<ItemStack, ItemStack>> tab, ItemLike prev, DyeColor color) {
        ItemStack stack = BFItems.TIFFINS.get(color).get().getDefaultInstance();
        stack.set(BFComponents.TIFFIN_CONTENTS.get(), new TiffinContents());
        tab.add(new Pair<>(prev.asItem().getDefaultInstance(), stack));
    }
    private static void addTiffin(ArrayList<Pair<ItemStack, ItemStack>> tab, DyeColor prev, DyeColor color) {
        ItemStack stack = BFItems.TIFFINS.get(color).get().getDefaultInstance();
        stack.set(BFComponents.TIFFIN_CONTENTS.get(), new TiffinContents());
        ItemStack prevStack = BFItems.TIFFINS.get(prev).get().getDefaultInstance();
        prevStack.set(BFComponents.TIFFIN_CONTENTS.get(), new TiffinContents());
        tab.add(new Pair<>(prevStack, stack));
    }
}
