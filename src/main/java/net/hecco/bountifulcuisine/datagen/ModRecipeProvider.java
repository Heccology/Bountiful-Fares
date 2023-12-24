package net.hecco.bountifulcuisine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.util.ModItemTags;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;

import java.util.function.Consumer;

import static net.minecraft.data.family.BlockFamilies.register;
import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GRISTMILL)
                .pattern("PPP")
                .pattern("PIP")
                .pattern("BBB")
                .input('P', ItemTags.PLANKS)
                .input('I', Items.IRON_INGOT)
                .input('B', Items.BRICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SUN_HAT)
                .pattern("###")
                .pattern("# #")
                .input('#', Items.WHEAT)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TRELLIS)
                .pattern("# #")
                .pattern(" # ")
                .pattern("# #")
                .input('#', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.FELDSPAR_LANTERN)
                .pattern("III")
                .pattern("FTF")
                .pattern("III")
                .input('I', Items.IRON_NUGGET)
                .input('F', ModItems.FELDSPAR)
                .input('T', Items.TORCH)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(ModItems.FELDSPAR), conditionsFromItem(ModItems.FELDSPAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINGED_GLASS)
                .pattern(" F ")
                .pattern("FGF")
                .pattern(" F ")
                .input('F', ModItems.FELDSPAR)
                .input('G', Items.GLASS)
                .criterion(hasItem(ModItems.FELDSPAR), conditionsFromItem(ModItems.FELDSPAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CERAMIC_CLAY)
                .input(Items.CLAY_BALL, 8)
                .input(ModItems.FELDSPAR)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .criterion(hasItem(ModItems.FELDSPAR), conditionsFromItem(ModItems.FELDSPAR))
                .group("ceramic_clay")
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CERAMIC_BUTTON)
                .input(ModItems.CERAMIC_TILE, 1)
                .criterion(hasItem(ModItems.CERAMIC_TILE), conditionsFromItem(ModItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CERAMIC_PRESSURE_PLATE)
                .pattern("###")
                .input('#', ModItems.CERAMIC_TILE)
                .criterion(hasItem(ModItems.CERAMIC_TILE), conditionsFromItem(ModItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.JAR, 3)
                .pattern("# #")
                .pattern(" # ")
                .input('#', ModItems.CERAMIC_CLAY)
                .criterion(hasItem(ModItems.CERAMIC_CLAY), conditionsFromItem(ModItems.CERAMIC_CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FERMENTATION_VESSEL)
                .pattern(" # ")
                .pattern("# #")
                .pattern("###")
                .input('#', ModItems.CERAMIC_CLAY)
                .criterion(hasItem(ModItems.CERAMIC_CLAY), conditionsFromItem(ModItems.CERAMIC_CLAY))
                .offerTo(exporter);

        BlockFamily hoaryFamily = register(ModBlocks.HOARY_PLANKS)
                .button(ModBlocks.HOARY_BUTTON)
                .fence(ModBlocks.HOARY_FENCE)
                .fenceGate(ModBlocks.HOARY_FENCE_GATE)
                .pressurePlate(ModBlocks.HOARY_PRESSURE_PLATE)
                .sign(ModBlocks.HOARY_SIGN, ModBlocks.HOARY_WALL_SIGN)
                .slab(ModBlocks.HOARY_SLAB)
                .stairs(ModBlocks.HOARY_STAIRS)
                .door(ModBlocks.HOARY_DOOR)
                .trapdoor(ModBlocks.HOARY_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        generateFamily(exporter, hoaryFamily);

        BlockFamily ceramicFamily = register(ModBlocks.CERAMIC_TILES)
                .slab(ModBlocks.CERAMIC_TILE_SLAB)
                .stairs(ModBlocks.CERAMIC_TILE_STAIRS)
                .group("ceramic_tiles")
                .unlockCriterionName("has_ceramic_tiles")
                .build();
        generateFamily(exporter, ceramicFamily);

        BlockFamily checkeredCeramicFamily = register(ModBlocks.CHECKERED_CERAMIC_TILES)
                .slab(ModBlocks.CHECKERED_CERAMIC_TILE_SLAB)
                .stairs(ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS)
                .group("checkered_ceramic_tiles")
                .unlockCriterionName("has_checkered_ceramic_tiles")
                .build();
        generateFamily(exporter, checkeredCeramicFamily);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.ARTISAN_BREAD)
                .input(ModItems.FLOUR, 3)
                .input(Items.EGG)
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.FLOUR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ARTISAN_COOKIE)
                .input(ModItems.FLOUR)
                .input(ModBlocks.ELDERBERRIES)
                .input(Items.SUGAR)
                .criterion(hasItem(ModBlocks.ELDERBERRIES), conditionsFromItem(ModBlocks.ELDERBERRIES))
                .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.FLOUR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.COCOA_CAKE)
                .pattern("MMM")
                .pattern("CEC")
                .pattern("FFF")
                .input('M', Items.MILK_BUCKET)
                .input('E', Items.EGG)
                .input('F', ModItems.FLOUR)
                .input('C', Items.COCOA_BEANS)
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.FLOUR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MUSHROOM_STUFFED_POTATO)
                .input(Items.BAKED_POTATO)
                .input(Items.RED_MUSHROOM)
                .input(Items.BROWN_MUSHROOM)
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .criterion(hasItem(Items.RED_MUSHROOM), conditionsFromItem(Items.RED_MUSHROOM))
                .criterion(hasItem(Items.BROWN_MUSHROOM), conditionsFromItem(Items.BROWN_MUSHROOM))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PASSION_GLAZED_SALMON)
                .input(ModBlocks.PASSION_FRUIT, 3)
                .input(Items.COOKED_SALMON)
                .input(Items.BOWL)
                .criterion(hasItem(ModBlocks.PASSION_FRUIT), conditionsFromItem(ModBlocks.PASSION_FRUIT))
                .criterion(hasItem(Items.COOKED_SALMON), conditionsFromItem(Items.COOKED_SALMON))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BOUNTIFUL_STEW)
                .input(Items.COOKED_PORKCHOP)
                .input(Items.CARROT)
                .input(ModItems.MAIZE)
                .input(Items.BOWL)
                .criterion(hasItem(Items.COOKED_PORKCHOP), conditionsFromItem(Items.COOKED_PORKCHOP))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(ModItems.MAIZE), conditionsFromItem(ModItems.MAIZE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CRIMSON_CHOW)
                .input(Items.COOKED_PORKCHOP)
                .input(Items.CRIMSON_FUNGUS)
                .input(Items.CRIMSON_ROOTS)
                .input(Items.BOWL)
                .criterion(hasItem(Items.CRIMSON_FUNGUS), conditionsFromItem(Items.CRIMSON_FUNGUS))
                .criterion(hasItem(Items.CRIMSON_ROOTS), conditionsFromItem(Items.CRIMSON_ROOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WARPED_CHOW)
                .input(Items.WARPED_FUNGUS)
                .input(Items.WARPED_ROOTS)
                .input(Items.NETHER_SPROUTS)
                .input(Items.BOWL)
                .criterion(hasItem(Items.WARPED_FUNGUS), conditionsFromItem(Items.WARPED_FUNGUS))
                .criterion(hasItem(Items.WARPED_ROOTS), conditionsFromItem(Items.WARPED_ROOTS))
                .offerTo(exporter);

        offerPlanksRecipe(exporter, Items.STICK, ModItemTags.FRUIT_LOGS, 8);
        offerBarkBlockRecipe(exporter, ModBlocks.APPLE_WOOD, ModBlocks.APPLE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_APPLE_WOOD, ModBlocks.STRIPPED_APPLE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.ORANGE_WOOD, ModBlocks.ORANGE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_ORANGE_WOOD, ModBlocks.STRIPPED_ORANGE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.LEMON_WOOD, ModBlocks.LEMON_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_LEMON_WOOD, ModBlocks.STRIPPED_LEMON_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.PLUM_WOOD, ModBlocks.PLUM_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_PLUM_WOOD, ModBlocks.STRIPPED_PLUM_LOG);

        offerBarkBlockRecipe(exporter, ModBlocks.HOARY_WOOD, ModBlocks.HOARY_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_HOARY_WOOD, ModBlocks.STRIPPED_HOARY_LOG);
        offerBoatRecipe(exporter, ModItems.HOARY_BOAT, ModBlocks.HOARY_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.HOARY_CHEST_BOAT, ModItems.HOARY_BOAT);

        offerPicketsRecipe(exporter, ModBlocks.OAK_PICKETS, Items.OAK_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.SPRUCE_PICKETS, Items.SPRUCE_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.BIRCH_PICKETS, Items.BIRCH_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.JUNGLE_PICKETS, Items.JUNGLE_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.ACACIA_PICKETS, Items.ACACIA_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.DARK_OAK_PICKETS, Items.DARK_OAK_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.MANGROVE_PICKETS, Items.MANGROVE_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.CHERRY_PICKETS, Items.CHERRY_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.BAMBOO_PICKETS, Items.BAMBOO_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.HOARY_PICKETS, ModBlocks.HOARY_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.CRIMSON_PICKETS, Items.CRIMSON_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.WARPED_PICKETS, Items.WARPED_PLANKS);

        offerShapelessRecipe(exporter, ModItems.MAIZE_SEEDS, ModItems.MAIZE, null, 2);
        offerShapelessRecipe(exporter, ModItems.SPONGEKIN_SEEDS, ModItems.SPONGEKIN_SLICE, null, 1);
        offerShapelessRecipe(exporter, Items.GREEN_DYE, ModItems.TEA_LEAVES, "green_dye", 1);
        offerShapelessRecipe(exporter, Items.BLACK_DYE, ModItems.DRIED_TEA_LEAVES, "black_dye", 1);
        offerShapelessRecipe(exporter, Items.LIGHT_GRAY_DYE, ModBlocks.CHAMOMILE_FLOWERS, "light_gray_dye", 1);
        offerShapelessRecipe(exporter, Items.YELLOW_DYE, ModBlocks.HONEYSUCKLE, "yellow_dye", 1);
        offerShapelessRecipe(exporter, Items.PURPLE_DYE, ModBlocks.VIOLET_BELLFLOWER, "purple_dye", 1);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.FOOD, ModBlocks.GOLDEN_APPLE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.APPLE, RecipeCategory.FOOD, ModBlocks.APPLE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.ORANGE, RecipeCategory.FOOD, ModBlocks.ORANGE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.LEMON, RecipeCategory.FOOD, ModBlocks.LEMON_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.PLUM, RecipeCategory.FOOD, ModBlocks.PLUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModItems.HOARY_APPLE, RecipeCategory.FOOD, ModBlocks.HOARY_APPLE_BLOCK);
        offerTeaRecipes(exporter, ModItems.GREEN_TEA_BOTTLE, ModBlocks.GREEN_TEA_CANDLE, ModItems.GREEN_TEA_BLEND);
        offerTeaRecipes(exporter, ModItems.BLACK_TEA_BOTTLE, ModBlocks.BLACK_TEA_CANDLE, ModItems.BLACK_TEA_BLEND);
        offerTeaRecipes(exporter, ModItems.CHAMOMILE_TEA_BOTTLE, ModBlocks.CHAMOMILE_CANDLE, ModItems.CHAMOMILE_TEA_BLEND);
        offerTeaRecipes(exporter, ModItems.HONEYSUCKLE_TEA_BOTTLE, ModBlocks.HONEYSUCKLE_CANDLE, ModItems.HONEYSUCKLE_TEA_BLEND);
        offerTeaRecipes(exporter, ModItems.BELLFLOWER_TEA_BOTTLE, ModBlocks.BELLFLOWER_CANDLE, ModItems.BELLFLOWER_TEA_BLEND);
        offerTeaRecipes(exporter, ModItems.TORCHFLOWER_TEA_BOTTLE, ModBlocks.TORCHFLOWER_CANDLE, ModItems.TORCHFLOWER_TEA_BLEND);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPONGEKIN, ModItems.SPONGEKIN_SLICE);
        offerCompoteJarRecipe(exporter, ModItems.APPLE_COMPOTE_JAR, Items.APPLE);
        offerCompoteJarRecipe(exporter, ModItems.ORANGE_COMPOTE_JAR, ModItems.ORANGE);
        offerCompoteJarRecipe(exporter, ModItems.LEMON_COMPOTE_JAR, ModItems.LEMON);
        offerCompoteJarRecipe(exporter, ModItems.PLUM_COMPOTE_JAR, ModItems.PLUM);
        offerCompoteJarRecipe(exporter, ModItems.HOARY_COMPOTE_JAR, ModItems.HOARY_APPLE);
        offerCandyRecipe(exporter, ModItems.CANDY, Items.HONEY_BOTTLE);
        offerCandyRecipe(exporter, ModItems.PIQUANT_CANDY, Items.SWEET_BERRIES);
        offerCandyRecipe(exporter, ModItems.SOUR_CANDY, ModItems.CITRIC_ACID);
        offerCandyRecipe(exporter, ModItems.BITTER_CANDY, ModBlocks.ELDERBERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.PASSION_FRUIT_TART, ModBlocks.PASSION_FRUIT);
        offerTartAndPieRecipe(exporter, ModBlocks.ELDERBERRY_TART, ModBlocks.ELDERBERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.GLOW_BERRY_TART, Items.GLOW_BERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.LAPISBERRY_TART, ModBlocks.LAPISBERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.SWEET_BERRY_TART, Items.SWEET_BERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.APPLE_PIE, Items.APPLE);
        offerTartAndPieRecipe(exporter, ModBlocks.ORANGE_PIE, ModItems.ORANGE);
        offerTartAndPieRecipe(exporter, ModBlocks.LEMON_PIE, ModItems.LEMON);
        offerTartAndPieRecipe(exporter, ModBlocks.PLUM_PIE, ModItems.PLUM);
        offerTartAndPieRecipe(exporter, ModBlocks.HOARY_PIE, ModItems.HOARY_APPLE);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.FELDSPAR, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.CERAMIC_CLAY, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CERAMIC_CLAY_BLOCK, "ceramic_clay_block", null, "ceramic_clay_from_block", "ceramic_clay");
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CERAMIC_TILES, ModItems.CERAMIC_TILE);
        
        
        offerJackOStrawRecipes(exporter, ModBlocks.WHITE_JACK_O_STRAW, Items.WHITE_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.LIGHT_GRAY_JACK_O_STRAW, Items.LIGHT_GRAY_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.GRAY_JACK_O_STRAW, Items.GRAY_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.BLACK_JACK_O_STRAW, Items.BLACK_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.BROWN_JACK_O_STRAW, Items.BROWN_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.RED_JACK_O_STRAW, Items.RED_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.ORANGE_JACK_O_STRAW, Items.ORANGE_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.YELLOW_JACK_O_STRAW, Items.YELLOW_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.LIME_JACK_O_STRAW, Items.LIME_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.GREEN_JACK_O_STRAW, Items.GREEN_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.CYAN_JACK_O_STRAW, Items.CYAN_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.LIGHT_BLUE_JACK_O_STRAW, Items.LIGHT_BLUE_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.BLUE_JACK_O_STRAW, Items.BLUE_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.PURPLE_JACK_O_STRAW, Items.PURPLE_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.MAGENTA_JACK_O_STRAW, Items.MAGENTA_WOOL);
        offerJackOStrawRecipes(exporter, ModBlocks.PINK_JACK_O_STRAW, Items.PINK_WOOL);

    }

    public static void offerPicketsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', input).input('S', Items.STICK)
                .pattern("#S#").criterion("has_planks", conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerTeaRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible teaBottle, ItemConvertible teaCandle, ItemConvertible teaBlendItem) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, teaBottle)
                .input(teaBlendItem, 1)
                .input(Items.POTION)
                .criterion(hasItem(teaBlendItem), conditionsFromItem(teaBlendItem))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, teaCandle, 4)
                .input('S', Items.STRING)
                .input('H', Items.HONEYCOMB)
                .input('#', teaBlendItem)
                .pattern("S")
                .pattern("H")
                .pattern("#")
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion("has_tea_blend", conditionsFromItem(teaBlendItem))
                .offerTo(exporter);
    }
    public static void offerCompoteJarRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input, 2)
                .input(ModItems.CITRIC_ACID)
                .input(ModItems.JAR)
                .criterion(hasItem(ModItems.JAR), conditionsFromItem(ModItems.JAR))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerCandyRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input)
                .input(Items.SUGAR)
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerJackOStrawRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible wool) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(ModItems.SUN_HAT)
                .input(Items.CARVED_PUMPKIN)
                .input(wool)
                .input(Items.STICK)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .criterion(hasItem(Items.CARVED_PUMPKIN), conditionsFromItem(Items.CARVED_PUMPKIN))
                .criterion(hasItem(ModItems.SUN_HAT), conditionsFromItem(ModItems.SUN_HAT))
                .criterion("has_wool", conditionsFromItem(wool))
                .offerTo(exporter, getItemId(output) + "_with_carved_pumpkin");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(ModItems.SUN_HAT)
                .input(Items.CARVED_PUMPKIN)
                .input(wool)
                .input(Items.STICK)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .criterion(hasItem(Items.CARVED_PUMPKIN), conditionsFromItem(Items.CARVED_PUMPKIN))
                .criterion(hasItem(ModItems.SUN_HAT), conditionsFromItem(ModItems.SUN_HAT))
                .criterion("has_wool", conditionsFromItem(wool))
                .offerTo(exporter, getItemId(output) + "_with_pumpkin");
    }
    public static void offerTartAndPieRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input)
                .input(ModItems.FLOUR)
                .input(Items.EGG)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.FLOUR))
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
}
