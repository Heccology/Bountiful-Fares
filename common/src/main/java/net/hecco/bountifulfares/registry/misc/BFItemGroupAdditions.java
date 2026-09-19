package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.definition.item.component.TiffinContents;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFComponents;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.nexuslib.lib.util.ItemGroupAddition;
import net.hecco.nexuslib.lib.util.ItemGroupAdditionType;
import net.hecco.nexuslib.platform.NLServices;
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
import java.util.Objects;
import java.util.Optional;

import static net.hecco.bountifulfares.registry.misc.BFItemGroups.addTiffin;

//TODO make this more laconic -diemant, to self
public class BFItemGroupAdditions {
    public static ArrayList<ItemGroupAddition> BUILDING_BLOCKS = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> NATURAL_BLOCKS = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> FUNCTIONAL_BLOCKS = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> REDSTONE_BLOCKS = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> TOOLS_AND_UTILITIES = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> COMBAT = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> FOOD_AND_DRINKS = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> INGREDIENTS = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> COLORED_BLOCKS = new ArrayList<>();
    public static ArrayList<ItemGroupAddition> OP_BLOCKS = new ArrayList<>();
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

        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.OAK_FENCE_GATE, BFBlocks.PICKETS.get("oak").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.SPRUCE_FENCE_GATE, BFBlocks.PICKETS.get("spruce").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.BIRCH_FENCE_GATE, BFBlocks.PICKETS.get("birch").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.JUNGLE_FENCE_GATE, BFBlocks.PICKETS.get("jungle").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.ACACIA_FENCE_GATE, BFBlocks.PICKETS.get("acacia").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.DARK_OAK_FENCE_GATE, BFBlocks.PICKETS.get("dark_oak").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.MANGROVE_FENCE_GATE, BFBlocks.PICKETS.get("mangrove").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.CHERRY_FENCE_GATE, BFBlocks.PICKETS.get("cherry").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.BAMBOO_FENCE_GATE, BFBlocks.PICKETS.get("bamboo").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.BAMBOO_BUTTON, BFBlocks.WALNUT_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_LOG.get(), BFBlocks.WALNUT_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_WOOD.get(), BFBlocks.STRIPPED_WALNUT_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_WALNUT_LOG.get(), BFBlocks.STRIPPED_WALNUT_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_WALNUT_WOOD.get(), BFBlocks.WALNUT_PLANKS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_PLANKS.get(), BFBlocks.WALNUT_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_STAIRS.get(), BFBlocks.WALNUT_SLAB.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_SLAB.get(), BFBlocks.WALNUT_FENCE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_FENCE.get(), BFBlocks.WALNUT_FENCE_GATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_FENCE_GATE.get(), BFBlocks.PICKETS.get("walnut").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PICKETS.get("walnut").get(), BFBlocks.WALNUT_DOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_DOOR.get(), BFBlocks.WALNUT_TRAPDOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_TRAPDOOR.get(), BFBlocks.WALNUT_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_PRESSURE_PLATE.get(), BFBlocks.WALNUT_BUTTON.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_BUTTON.get(), BFBlocks.HOARY_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_LOG.get(), BFBlocks.HOARY_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_WOOD.get(), BFBlocks.STRIPPED_HOARY_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_HOARY_LOG.get(), BFBlocks.STRIPPED_HOARY_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_HOARY_WOOD.get(), BFBlocks.HOARY_PLANKS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_PLANKS.get(), BFBlocks.HOARY_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_STAIRS.get(), BFBlocks.HOARY_SLAB.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_SLAB.get(), BFBlocks.HOARY_FENCE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_FENCE.get(), BFBlocks.HOARY_FENCE_GATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_FENCE_GATE.get(), BFBlocks.PICKETS.get("hoary").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PICKETS.get("hoary").get(), BFBlocks.HOARY_DOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_DOOR.get(), BFBlocks.HOARY_TRAPDOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_TRAPDOOR.get(), BFBlocks.HOARY_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_PRESSURE_PLATE.get(), BFBlocks.HOARY_BUTTON.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.CRIMSON_FENCE_GATE, BFBlocks.PICKETS.get("crimson").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.WARPED_FENCE_GATE, BFBlocks.PICKETS.get("warped").get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.WARPED_BUTTON, BFBlocks.APPLE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.APPLE_LOG.get(), BFBlocks.APPLE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.APPLE_WOOD.get(), BFBlocks.STRIPPED_APPLE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_APPLE_LOG.get(), BFBlocks.STRIPPED_APPLE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_APPLE_WOOD.get(), BFBlocks.ORANGE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.ORANGE_LOG.get(), BFBlocks.ORANGE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.ORANGE_WOOD.get(), BFBlocks.STRIPPED_ORANGE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_ORANGE_LOG.get(), BFBlocks.STRIPPED_ORANGE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_ORANGE_WOOD.get(), BFBlocks.LEMON_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.LEMON_LOG.get(), BFBlocks.LEMON_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.LEMON_WOOD.get(), BFBlocks.STRIPPED_LEMON_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_LEMON_LOG.get(), BFBlocks.STRIPPED_LEMON_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_LEMON_WOOD.get(), BFBlocks.PLUM_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PLUM_LOG.get(), BFBlocks.PLUM_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PLUM_WOOD.get(), BFBlocks.STRIPPED_PLUM_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_PLUM_LOG.get(), BFBlocks.STRIPPED_PLUM_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_PLUM_WOOD.get(), BFBlocks.PALM_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PALM_LOG.get(), BFBlocks.PALM_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PALM_WOOD.get(), BFBlocks.STRIPPED_PALM_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_PALM_LOG.get(), BFBlocks.STRIPPED_PALM_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_PALM_WOOD.get(), BFBlocks.GOLDEN_APPLE_LOG.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.GOLDEN_APPLE_LOG.get(), BFBlocks.GOLDEN_APPLE_WOOD.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.STRIPPED_PLUM_WOOD.get(), BFBlocks.WALNUT_MULCH.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_MULCH.get(), BFBlocks.WALNUT_MULCH_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_MULCH_BLOCK.get(), BFBlocks.PALM_MULCH.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PALM_MULCH.get(), BFBlocks.PALM_MULCH_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Blocks.MUD_BRICK_WALL, BFBlocks.PACKED_COCONUT_COIR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PACKED_COCONUT_COIR.get(), BFBlocks.COIR_CARPET.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.COIR_CARPET.get(), BFBlocks.COIR_BRICKS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.COIR_BRICKS.get(), BFBlocks.COIR_BRICK_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.COIR_BRICK_STAIRS.get(), BFBlocks.COIR_BRICK_SLAB.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.COIR_BRICK_SLAB.get(), BFBlocks.COIR_BRICK_WALL.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Items.DARK_PRISMARINE_SLAB, BFBlocks.PRISMARINE_BLOSSOM.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PRISMARINE_BLOSSOM.get(), BFBlocks.FELDSPAR_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FELDSPAR_BLOCK.get(), BFBlocks.CUT_FELDSPAR_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CUT_FELDSPAR_BLOCK.get(), BFBlocks.FELDSPAR_BRICKS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FELDSPAR_BRICKS.get(), BFBlocks.FELDSPAR_BRICK_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FELDSPAR_BRICK_STAIRS.get(), BFBlocks.FELDSPAR_BRICK_SLAB.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FELDSPAR_BRICK_SLAB.get(), BFBlocks.FELDSPAR_BRICK_WALL.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FELDSPAR_BRICK_WALL.get(), BFBlocks.CERAMIC_CLAY_BLOCK.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_CLAY_BLOCK.get(), BFBlocks.CERAMIC_TILES.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CERAMIC_TILE_SLAB.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILE_WALL.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_TILE_WALL, BFBlocks.CRACKED_CERAMIC_TILES.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CRACKED_CERAMIC_TILES.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_PILLAR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TILE_PILLAR.get(), BFBlocks.CERAMIC_MOSAIC.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CERAMIC_MOSAIC_STAIRS.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC_SLAB.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC_WALL.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_WALL, BFBlocks.CERAMIC_DOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_MOSAIC_SLAB.get(), BFBlocks.CERAMIC_DOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_DOOR.get(), BFBlocks.CERAMIC_TRAPDOOR.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TRAPDOOR.get(), BFBlocks.CERAMIC_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_PRESSURE_PLATE.get(), BFBlocks.CERAMIC_BUTTON.get().asItem().getDefaultInstance()));
        BUILDING_BLOCKS.add(ItemGroupAddition.create(Blocks.IRON_BARS, BFBlocks.IRON_RAILING.get().asItem().getDefaultInstance()));

        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("building_blocks")),
                BUILDING_BLOCKS
        );

        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.GRASS_BLOCK, BFBlocks.GRASSY_DIRT.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.CHERRY_LOG, BFBlocks.APPLE_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.APPLE_LOG.get(), BFBlocks.ORANGE_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.ORANGE_LOG.get(), BFBlocks.LEMON_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.LEMON_LOG.get(), BFBlocks.PLUM_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PLUM_LOG.get(), BFBlocks.PALM_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PALM_LOG.get(), BFBlocks.PALM_CROWN.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PALM_CROWN.get(), BFBlocks.WALNUT_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_LOG.get(), BFBlocks.HOARY_LOG.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.FLOWERING_AZALEA_LEAVES, BFBlocks.APPLE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.APPLE_LEAVES.get(), BFBlocks.FLOWERING_APPLE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FLOWERING_APPLE_LEAVES.get(), BFBlocks.ORANGE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.ORANGE_LEAVES.get(), BFBlocks.FLOWERING_ORANGE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create( BFBlocks.FLOWERING_ORANGE_LEAVES.get(), BFBlocks.LEMON_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.LEMON_LEAVES.get(), BFBlocks.FLOWERING_LEMON_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FLOWERING_LEMON_LEAVES.get(), BFBlocks.PLUM_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PLUM_LEAVES.get(), BFBlocks.FLOWERING_PLUM_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FLOWERING_PLUM_LEAVES.get(), BFBlocks.GOLDEN_APPLE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.GOLDEN_APPLE_LEAVES.get(), BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get(), BFBlocks.WALNUT_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_LEAVES.get(), BFBlocks.HOARY_LEAVES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_LEAVES.get(), BFItems.PALM_FROND.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.CHERRY_SAPLING, BFBlocks.APPLE_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.APPLE_SAPLING.get(), BFBlocks.ORANGE_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.ORANGE_SAPLING.get(), BFBlocks.LEMON_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.LEMON_SAPLING.get(), BFBlocks.PLUM_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.PLUM_SAPLING.get(), BFBlocks.HOARY_APPLE_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HOARY_APPLE_SAPLING.get(), BFBlocks.WALNUT_SAPLING.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Blocks.FLOWERING_AZALEA, BFItems.COCONUT.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.SNIFFER_EGG, BFBlocks.WILD_WHEAT.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WILD_WHEAT.get(), BFBlocks.WILD_CARROTS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WILD_CARROTS.get(), BFBlocks.WILD_POTATOES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WILD_POTATOES.get(), BFBlocks.WILD_BEETROOTS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WILD_BEETROOTS.get(), BFBlocks.WILD_LEEKS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WILD_LEEKS.get(), BFBlocks.WILD_MAIZE.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WILD_MAIZE.get(), BFBlocks.WILD_PASSION_FRUIT_VINE.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WILD_PASSION_FRUIT_VINE.get(), BFBlocks.WILD_ELDERBERRY_VINE.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WILD_ELDERBERRY_VINE.get(), BFBlocks.SPONGEKIN_SPROUT.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.SPONGEKIN_SPROUT.get(), BFItems.GRASS_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFItems.GRASS_SEEDS.get(), BFItems.SWEET_BERRY_PIPS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.KELP, BFBlocks.SPONGEKIN.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.SPONGEKIN.get(), BFBlocks.PRISMARINE_BLOSSOM.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.LILY_OF_THE_VALLEY, BFBlocks.CHAMOMILE_FLOWERS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CHAMOMILE_FLOWERS.get(), BFBlocks.HONEYSUCKLE.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HONEYSUCKLE.get(), BFBlocks.VIOLET_BELLFLOWER.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.BEETROOT_SEEDS, BFItems.MAIZE_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFItems.MAIZE_SEEDS.get(), BFItems.LEEK_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFItems.LEEK_SEEDS.get(), BFItems.TEA_BERRIES.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFItems.TEA_BERRIES.get(), BFItems.SPONGEKIN_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(Items.PITCHER_POD, BFItems.LAPISBERRY_SEEDS.get().asItem().getDefaultInstance()));
        NATURAL_BLOCKS.add(ItemGroupAddition.create(BFItems.LAPISBERRY_SEEDS.get(), BFItems.HOARY_SEEDS.get().asItem().getDefaultInstance()));

        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("natural_blocks")),
                NATURAL_BLOCKS
        );


        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(Items.LANTERN, BFBlocks.FELDSPAR_LANTERN.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(Items.GRINDSTONE, BFBlocks.GRISTMILL.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(Items.SOUL_CAMPFIRE, BFBlocks.GREEN_TEA_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.GREEN_TEA_CANDLE.get(), BFBlocks.BLACK_TEA_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.BLACK_TEA_CANDLE.get(), BFBlocks.CHAMOMILE_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CHAMOMILE_CANDLE.get(), BFBlocks.HONEYSUCKLE_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.HONEYSUCKLE_CANDLE.get(), BFBlocks.BELLFLOWER_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.BELLFLOWER_CANDLE.get(), BFBlocks.TORCHFLOWER_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.TORCHFLOWER_CANDLE.get(), BFBlocks.WALNUT_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.WALNUT_CANDLE.get(), BFBlocks.FERMENTATION_VESSEL.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.FERMENTATION_VESSEL.get(), BFBlocks.COCONUT_CANDLE.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFBlocks.COCONUT_CANDLE.get(), BFBlocks.GOLDEN_APPLE_SAPLING.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(Items.SCAFFOLDING, BFBlocks.FLOUR_BLOCK.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(Items.PINK_BED, BFBlocks.COIR_BED.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(Items.CHEST, BFBlocks.CERAMIC_CHEST.get().asItem().getDefaultInstance()));
        Block prev = Blocks.COMPOSTER;
        for (String wood : BountifulFaresUtil.WOOD_TYPES) {
            FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(prev, BFBlocks.TRELLISES.get(wood).get().asItem().getDefaultInstance()));
            prev = BFBlocks.TRELLISES.get(wood).get();
        }

        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(Items.TINTED_GLASS, BFBlocks.TINGED_GLASS.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(Items.BAMBOO_HANGING_SIGN, BFItems.WALNUT_SIGN.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFItems.WALNUT_SIGN.get(), BFItems.WALNUT_HANGING_SIGN.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFItems.WALNUT_HANGING_SIGN.get(), BFItems.HOARY_SIGN.get().asItem().getDefaultInstance()));
        FUNCTIONAL_BLOCKS.add(ItemGroupAddition.create(BFItems.HOARY_SIGN.get(), BFItems.HOARY_HANGING_SIGN.get().asItem().getDefaultInstance()));
        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("functional_blocks")),
                FUNCTIONAL_BLOCKS
        );
        REDSTONE_BLOCKS.add(ItemGroupAddition.create(Items.LEVER, BFBlocks.CERAMIC_LEVER.get().asItem().getDefaultInstance()));
        REDSTONE_BLOCKS.add(ItemGroupAddition.create(Items.STONE_BUTTON, BFBlocks.CERAMIC_BUTTON.get().asItem().getDefaultInstance()));
        REDSTONE_BLOCKS.add(ItemGroupAddition.create(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, BFBlocks.CERAMIC_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        REDSTONE_BLOCKS.add(ItemGroupAddition.create(Items.WHITE_WOOL, BFBlocks.CERAMIC_TILES.get().asItem().getDefaultInstance()));
        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("redstone_blocks")),
                REDSTONE_BLOCKS
        );
        TOOLS_AND_UTILITIES.add(ItemGroupAddition.create(Items.LEAD, BFItems.SUN_HAT.get().asItem().getDefaultInstance()));
        TOOLS_AND_UTILITIES.add(ItemGroupAddition.create(Items.BRUSH, BFItems.ARTISAN_BRUSH.get().asItem().getDefaultInstance()));
        TOOLS_AND_UTILITIES.add(ItemGroupAddition.create(Items.BAMBOO_CHEST_RAFT, BFItems.WALNUT_BOAT.get().asItem().getDefaultInstance()));
        TOOLS_AND_UTILITIES.add(ItemGroupAddition.create(BFItems.WALNUT_BOAT.get(), BFItems.WALNUT_CHEST_BOAT.get().asItem().getDefaultInstance()));
        TOOLS_AND_UTILITIES.add(ItemGroupAddition.create(BFItems.WALNUT_CHEST_BOAT.get(), BFItems.HOARY_BOAT.get().asItem().getDefaultInstance()));
        TOOLS_AND_UTILITIES.add(ItemGroupAddition.create(BFItems.HOARY_BOAT.get(), BFItems.HOARY_CHEST_BOAT.get().asItem().getDefaultInstance()));

        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("tools_and_utilities")),
                TOOLS_AND_UTILITIES
        );

        COMBAT.add(ItemGroupAddition.create(Items.EGG, BFItems.FLOUR.get().asItem().getDefaultInstance()));

        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("combat")),
                COMBAT
        );

        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.APPLE, BFItems.APPLE_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.APPLE_COMPOTE_JAR.get(), BFItems.APPLE_CIDER_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.APPLE_CIDER_JAR.get(), BFBlocks.APPLE_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.APPLE_BLOCK.get(), BFItems.ORANGE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.ORANGE.get(), BFItems.ORANGE_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.ORANGE_COMPOTE_JAR.get(), BFBlocks.ORANGE_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.ORANGE_BLOCK.get(), BFItems.LEMON.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.LEMON.get(), BFItems.LEMON_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.LEMON_COMPOTE_JAR.get(), BFBlocks.LEMON_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.LEMON_BLOCK.get(), BFItems.PLUM.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.PLUM.get(), BFItems.PLUM_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.PLUM_COMPOTE_JAR.get(), BFItems.PLUM_CIDER_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.PLUM_CIDER_JAR.get(), BFBlocks.PLUM_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.PLUM_BLOCK.get(), BFItems.HOARY_APPLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.HOARY_APPLE.get(), BFItems.STUFFED_HOARY_APPLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.STUFFED_HOARY_APPLE.get(), BFItems.HOARY_COMPOTE_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.HOARY_COMPOTE_JAR.get(), BFItems.HOARY_CIDER_JAR.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.HOARY_CIDER_JAR.get(), BFBlocks.HOARY_APPLE_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.HOARY_APPLE_BLOCK.get(), BFItems.COCONUT_HALF.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.ENCHANTED_GOLDEN_APPLE, BFBlocks.GOLDEN_APPLE_BLOCK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.MELON_SLICE, BFItems.SPONGEKIN_SLICE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.SPONGEKIN_SLICE.get(), BFItems.PICKLED_SPONGEKIN.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.SWEET_BERRIES, BFItems.PASSION_FRUIT.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.PASSION_FRUIT.get(), BFItems.ELDERBERRIES.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.ELDERBERRIES.get(), BFItems.ELDERBERRY_WINE_BOTTLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.GLOW_BERRIES, BFItems.LAPISBERRIES.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.LAPISBERRIES.get(), BFItems.LAPISBERRY_WINE_BOTTLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.MILK_BUCKET, BFItems.COCONUT_MILK_BOTTLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.COCONUT_MILK_BOTTLE.get(), BFItems.WATER_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.WATER_CUP.get(), BFItems.GREEN_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.GREEN_TEA_CUP.get(), BFItems.BLACK_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.BLACK_TEA_CUP.get(), BFItems.CHAMOMILE_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CHAMOMILE_TEA_CUP.get(), BFItems.HONEYSUCKLE_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.HONEYSUCKLE_TEA_CUP.get(), BFItems.BELLFLOWER_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.BELLFLOWER_TEA_CUP.get(), BFItems.TORCHFLOWER_TEA_CUP.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.HONEY_BOTTLE, BFItems.MEAD_BOTTLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.BAKED_POTATO, BFItems.MUSHROOM_STUFFED_POTATO.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.MUSHROOM_STUFFED_POTATO.get(), BFItems.BERRY_STUFFED_POTATO.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.BERRY_STUFFED_POTATO.get(), BFItems.MAIZE_STUFFED_POTATO.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.BEETROOT, BFItems.PICKLED_BEETROOT.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.PICKLED_BEETROOT.get(), BFItems.MAIZE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.MAIZE.get(), BFItems.LEEK.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.LEEK.get(), BFItems.WALNUT.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.WALNUT.get(), BFItems.POPPED_MAIZE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.PUFFERFISH, BFItems.COOKED_EGG.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.BREAD, BFItems.MAIZE_BREAD.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.MAIZE_BREAD.get(), BFBlocks.ARTISAN_BREAD.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.COOKIE, BFItems.WALNUT_COOKIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.WALNUT_COOKIE.get(), BFItems.ARTISAN_COOKIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.ARTISAN_COOKIE.get(), BFBlocks.PASSION_FRUIT_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.PASSION_FRUIT_TART.get(), BFBlocks.ELDERBERRY_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.ELDERBERRY_TART.get(), BFBlocks.GLOW_BERRY_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.GLOW_BERRY_TART.get(), BFBlocks.SWEET_BERRY_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.SWEET_BERRY_TART.get(), BFBlocks.LAPISBERRY_TART.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.CAKE, BFBlocks.COCOA_CAKE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.COCOA_CAKE.get(), BFBlocks.COCONUT_CAKE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.COCONUT_CAKE.get(), BFBlocks.SPONGE_CAKE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.PUMPKIN_PIE, BFBlocks.MELON_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.MELON_PIE.get(), BFBlocks.APPLE_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.APPLE_PIE.get(), BFBlocks.ORANGE_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.ORANGE_PIE.get(), BFBlocks.LEMON_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.LEMON_PIE.get(), BFBlocks.PLUM_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFBlocks.PLUM_PIE.get(), BFBlocks.HOARY_PIE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.ROTTEN_FLESH, BFItems.FOUL_FLESH.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.SPIDER_EYE, BFItems.CITRUS_ESSENCE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CITRUS_ESSENCE.get(), BFItems.CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CANDY.get(), BFItems.PIQUANT_CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.PIQUANT_CANDY.get(), BFItems.SOUR_CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.SOUR_CANDY.get(), BFItems.BITTER_CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.BITTER_CANDY.get(), BFItems.STRANGE_CANDY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.STRANGE_CANDY.get(), BFItems.CANDIED_APPLE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CANDIED_APPLE.get(), BFItems.CANDIED_PLUM.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CANDIED_PLUM.get(), BFItems.CANDIED_ORANGE.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CANDIED_ORANGE.get(), BFItems.CANDIED_LEMON.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CANDIED_LEMON.get(), BFItems.FOREST_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.FOREST_MEDLEY.get(), BFItems.ARID_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.ARID_MEDLEY.get(), BFItems.MEADOW_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.MEADOW_MEDLEY.get(), BFItems.MIRE_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.MIRE_MEDLEY.get(), BFItems.COASTAL_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.COASTAL_MEDLEY.get(), BFItems.TROPICAL_MEDLEY.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TROPICAL_MEDLEY.get(), BFItems.SEA_SALAD.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(Items.RABBIT_STEW, BFItems.LEEK_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.LEEK_STEW.get(), BFItems.FISH_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.FISH_STEW.get(), BFItems.APPLE_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.APPLE_STEW.get(), BFItems.COCONUT_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.COCONUT_STEW.get(), BFItems.STONE_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.STONE_STEW.get(), BFItems.BOUNTIFUL_STEW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.BOUNTIFUL_STEW.get(), BFItems.COCONUT_CRUSTED_COD.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.COCONUT_CRUSTED_COD.get(), BFItems.PASSION_GLAZED_SALMON.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.PASSION_GLAZED_SALMON.get(), BFItems.CRUSTED_BEEF.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CRUSTED_BEEF.get(), BFItems.CRIMSON_CHOW.get().asItem().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.CRIMSON_CHOW.get(), BFItems.WARPED_CHOW.get().asItem().getDefaultInstance()));

        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(null).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.WHITE).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.LIGHT_GRAY).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.GRAY).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.BLACK).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.BROWN).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.RED).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.ORANGE).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.YELLOW).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.LIME).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.GREEN).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.CYAN).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.LIGHT_BLUE).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.BLUE).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.PURPLE).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.MAGENTA).get().getDefaultInstance()));
        FOOD_AND_DRINKS.add(ItemGroupAddition.create(BFItems.TIFFINS.get(DyeColor.PINK).get().getDefaultInstance()));




        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("food_and_drinks")),
                FOOD_AND_DRINKS
        );

        INGREDIENTS.add(ItemGroupAddition.create(Items.WHEAT, BFItems.MAIZE.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(BFItems.MAIZE.get(), BFItems.FLOUR.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(Items.SLIME_BALL, BFItems.FELDSPAR.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(BFItems.FELDSPAR.get(), BFItems.CERAMIC_CLAY.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(BFItems.CERAMIC_CLAY.get(), BFItems.CERAMIC_TILE.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(Items.BOWL, BFBlocks.CERAMIC_DISH.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_DISH.get(), BFItems.CUP.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(Items.FIREWORK_STAR, BFItems.COCONUT.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(BFItems.COCONUT.get(), BFItems.COCONUT_HALF.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(BFItems.COCONUT_HALF.get(), BFItems.COCONUT_COIR.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(BFItems.COCONUT_COIR.get(), BFItems.TEA_LEAVES.get().asItem().getDefaultInstance()));
        INGREDIENTS.add(ItemGroupAddition.create(BFItems.TEA_LEAVES.get(), BFItems.DRIED_TEA_LEAVES.get().asItem().getDefaultInstance()));

        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("ingredients")),
                INGREDIENTS
        );

        COLORED_BLOCKS.add(ItemGroupAddition.create(Items.PINK_GLAZED_TERRACOTTA, BFBlocks.CERAMIC_TILES.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_STAIRS.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CERAMIC_TILE_SLAB.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILE_WALL.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_TILE_WALL, BFBlocks.CRACKED_CERAMIC_TILES.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CRACKED_CERAMIC_TILES.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CERAMIC_TILE_PILLAR.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_TILE_PILLAR.get(), BFBlocks.CERAMIC_MOSAIC.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CERAMIC_MOSAIC_STAIRS.get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CERAMIC_MOSAIC_SLAB.get().asItem().getDefaultInstance()));
            //entries.addAfter(BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC_WALL.get().asItem().getDefaultInstance()));

        COLORED_BLOCKS.add(ItemGroupAddition.create(Items.PINK_BANNER, BFBlocks.JACK_O_STRAWS.get(DyeColor.WHITE).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.WHITE).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.LIGHT_GRAY).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.LIGHT_GRAY).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.GRAY).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.GRAY).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.BLACK).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.BLACK).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.BROWN).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.BROWN).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.RED).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.RED).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.ORANGE).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.ORANGE).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.YELLOW).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.YELLOW).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.LIME).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.LIME).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.GREEN).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.GREEN).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.CYAN).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.CYAN).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.LIGHT_BLUE).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.LIGHT_BLUE).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.BLUE).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.BLUE).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.PURPLE).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.PURPLE).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.MAGENTA).get().asItem().getDefaultInstance()));
        COLORED_BLOCKS.add(ItemGroupAddition.create(BFBlocks.JACK_O_STRAWS.get(DyeColor.MAGENTA).get(), BFBlocks.JACK_O_STRAWS.get(DyeColor.PINK).get().asItem().getDefaultInstance()));

        NLServices.REGISTRY.addItemsToItemGroup(
                ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("colored_blocks")),
                COLORED_BLOCKS
        );
    }
}
