package net.hecco.bountifulcuisine.datagen;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.datagen.recipe.MillingRecipeBuilder;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.util.ModItemTags;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CERAMIC_CLAY, 4)
                .input(Items.CLAY_BALL, 3)
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
                .pattern("##")
                .input('#', ModItems.CERAMIC_TILE)
                .criterion(hasItem(ModItems.CERAMIC_TILE), conditionsFromItem(ModItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.CERAMIC_DISH)
                .pattern("###")
                .input('#', ModItems.CERAMIC_TILE)
                .criterion(hasItem(ModItems.CERAMIC_TILE), conditionsFromItem(ModItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CERAMIC_LEVER)
                .pattern(" S ")
                .pattern("###")
                .input('S', Items.STICK)
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
        offerPlanksRecipe(exporter, ModBlocks.HOARY_PLANKS, ModItemTags.HOARY_LOGS, 4);


        BlockFamily walnutFamily = register(ModBlocks.WALNUT_PLANKS)
                .button(ModBlocks.WALNUT_BUTTON)
                .fence(ModBlocks.WALNUT_FENCE)
                .fenceGate(ModBlocks.WALNUT_FENCE_GATE)
                .pressurePlate(ModBlocks.WALNUT_PRESSURE_PLATE)
                .sign(ModBlocks.WALNUT_SIGN, ModBlocks.WALNUT_WALL_SIGN)
                .slab(ModBlocks.WALNUT_SLAB)
                .stairs(ModBlocks.WALNUT_STAIRS)
                .door(ModBlocks.WALNUT_DOOR)
                .trapdoor(ModBlocks.WALNUT_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        generateFamily(exporter, walnutFamily);
        offerPlanksRecipe(exporter, ModBlocks.WALNUT_PLANKS, ModItemTags.WALNUT_LOGS, 4);

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ARTISAN_COOKIE, 4)
                .input(ModItems.FLOUR)
                .input(ModItems.ELDERBERRIES)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.ELDERBERRIES), conditionsFromItem(ModItems.ELDERBERRIES))
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
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MAIZE_BREAD)
                .pattern("###")
                .input('#', ModItems.MAIZE)
                .criterion(hasItem(ModItems.MAIZE), conditionsFromItem(ModItems.MAIZE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WALNUT_COOKIE, 8)
                .pattern("#W#")
                .input('#', ModItems.FLOUR)
                .input('W', ModItems.WALNUT)
                .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.FLOUR))
                .criterion(hasItem(ModItems.WALNUT), conditionsFromItem(ModItems.WALNUT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FOREST_MEDLEY)
                .input(Items.PORKCHOP)
                .input(Items.CARROT)
                .input(Items.SWEET_BERRIES)
                .input(Items.BREAD)
                .criterion(hasItem(Items.PORKCHOP), conditionsFromItem(Items.PORKCHOP))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ARID_MEDLEY)
                .input(Items.CACTUS)
                .input(Items.POTATO)
                .input(ModItems.MAIZE)
                .input(Items.BREAD)
                .criterion(hasItem(Items.CACTUS), conditionsFromItem(Items.CACTUS))
                .criterion(hasItem(Items.POTATO), conditionsFromItem(Items.POTATO))
                .criterion(hasItem(ModItems.MAIZE), conditionsFromItem(ModItems.MAIZE))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MEADOW_MEDLEY)
                .input(Items.COOKED_MUTTON)
                .input(Items.BEETROOT)
                .input(ModBlocks.VIOLET_BELLFLOWER)
                .input(ModItems.LEEK)
                .criterion(hasItem(Items.COOKED_MUTTON), conditionsFromItem(Items.COOKED_MUTTON))
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .criterion(hasItem(ModBlocks.VIOLET_BELLFLOWER), conditionsFromItem(ModBlocks.VIOLET_BELLFLOWER))
                .criterion(hasItem(ModItems.LEEK), conditionsFromItem(ModItems.LEEK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.COASTAL_MEDLEY)
                .input(ModItems.SPONGEKIN_SLICE)
                .input(Items.DRIED_KELP, 2)
                .input(ModItemTags.COOKED_FISHES)
                .criterion(hasItem(ModItems.SPONGEKIN_SLICE), conditionsFromItem(ModItems.SPONGEKIN_SLICE))
                .criterion(hasItem(Items.DRIED_KELP), conditionsFromItem(Items.DRIED_KELP))
                .criterion("has_fish", conditionsFromTag(ModItemTags.COOKED_FISHES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MUSHROOM_STUFFED_POTATO)
                .input(Items.BAKED_POTATO)
                .input(Items.RED_MUSHROOM)
                .input(Items.BROWN_MUSHROOM)
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .criterion(hasItem(Items.RED_MUSHROOM), conditionsFromItem(Items.RED_MUSHROOM))
                .criterion(hasItem(Items.BROWN_MUSHROOM), conditionsFromItem(Items.BROWN_MUSHROOM))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BERRY_STUFFED_POTATO)
                .input(Items.BAKED_POTATO)
                .input(Items.SWEET_BERRIES)
                .input(Items.GLOW_BERRIES)
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(hasItem(Items.GLOW_BERRIES), conditionsFromItem(Items.GLOW_BERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MAIZE_STUFFED_POTATO)
                .input(Items.BAKED_POTATO)
                .input(ModItems.MAIZE)
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .criterion(hasItem(ModItems.MAIZE), conditionsFromItem(ModItems.MAIZE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PASSION_GLAZED_SALMON)
                .input(ModItems.PASSION_FRUIT, 3)
                .input(Items.COOKED_SALMON)
                .input(Items.BOWL)
                .criterion(hasItem(ModItems.PASSION_FRUIT), conditionsFromItem(ModItems.PASSION_FRUIT))
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.LEEK_STEW)
                .input(ModItems.LEEK, 3)
                .input(Items.BOWL)
                .criterion(hasItem(ModItems.LEEK), conditionsFromItem(ModItems.LEEK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.APPLE_STEW)
                .input(Items.APPLE, 2)
                .input(ModItems.ELDERBERRIES, 2)
                .input(Items.BOWL)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(ModItems.ELDERBERRIES), conditionsFromItem(ModItems.ELDERBERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.STONE_STEW)
                .input(Items.STONE_PICKAXE)
                .input(Items.COBBLESTONE, 2)
                .input(Items.ROTTEN_FLESH, 1)
                .input(Items.BOWL)
                .criterion(hasItem(Items.STONE_PICKAXE), conditionsFromItem(Items.STONE_PICKAXE))
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FISH_STEW)
                .group("fish_stew")
                .input(Ingredient.fromTag(ModItemTags.COOKED_FISHES), 2)
                .input(Items.DRIED_KELP, 2)
                .input(Items.BOWL)
                .criterion("has_cooked_fish", conditionsFromTag(ModItemTags.COOKED_FISHES))
                .criterion(hasItem(Items.DRIED_KELP), conditionsFromItem(Items.DRIED_KELP))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CUSTARD)
                .input(Items.MILK_BUCKET, 1)
                .input(Items.SUGAR, 2)
                .input(Items.BOWL)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PIQUANT_CUSTARD)
                .input(Items.MILK_BUCKET, 1)
                .input(Items.SUGAR, 2)
                .input(Items.SWEET_BERRIES, 2)
                .input(Items.BOWL)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PASSION_CUSTARD)
                .input(Items.MILK_BUCKET, 1)
                .input(Items.SUGAR, 2)
                .input(ModItems.PASSION_FRUIT, 2)
                .input(Items.BOWL)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(ModItems.PASSION_FRUIT), conditionsFromItem(ModItems.PASSION_FRUIT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.COCOA_CUSTARD)
                .input(Items.MILK_BUCKET, 1)
                .input(Items.SUGAR, 2)
                .input(Items.COCOA_BEANS, 1)
                .input(ModItems.WALNUT, 1)
                .input(Items.BOWL)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .criterion(hasItem(ModItems.WALNUT), conditionsFromItem(ModItems.WALNUT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GLOWING_CUSTARD)
                .input(Items.MILK_BUCKET, 1)
                .input(Items.SUGAR, 2)
                .input(Items.GLOW_BERRIES, 2)
                .input(Items.BOWL)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.GLOW_BERRIES), conditionsFromItem(Items.GLOW_BERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ANCIENT_CUSTARD)
                .input(Items.MILK_BUCKET, 1)
                .input(Items.SUGAR, 2)
                .input(ModItems.LAPISBERRIES, 1)
                .input(ModItems.HOARY_APPLE, 1)
                .input(Items.BOWL)
                .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(ModItems.HOARY_APPLE), conditionsFromItem(ModItems.HOARY_APPLE))
                .criterion(hasItem(ModItems.LAPISBERRIES), conditionsFromItem(ModItems.LAPISBERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CANDIED_APPLE)
                .input(Items.APPLE, 1)
                .input(Items.SUGAR, 1)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CANDIED_PLUM)
                .input(ModItems.PLUM, 1)
                .input(Items.SUGAR, 1)
                .criterion(hasItem(ModItems.PLUM), conditionsFromItem(ModItems.PLUM))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CANDIED_ORANGE, 4)
                .input(ModItems.ORANGE, 1)
                .input(Items.SUGAR, 1)
                .criterion(hasItem(ModItems.ORANGE), conditionsFromItem(ModItems.ORANGE))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CANDIED_LEMON, 4)
                .input(ModItems.LEMON, 1)
                .input(Items.SUGAR, 1)
                .criterion(hasItem(ModItems.LEMON), conditionsFromItem(ModItems.LEMON))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CRUSTED_BEEF)
                .input(Items.COOKED_BEEF)
                .input(ModItems.WALNUT, 2)
                .input(Items.POTATO)
                .input(ModItems.ELDERBERRIES)
                .input(Items.BOWL)
                .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
                .criterion(hasItem(Items.POTATO), conditionsFromItem(Items.POTATO))
                .criterion(hasItem(ModItems.WALNUT), conditionsFromItem(ModItems.WALNUT))
                .criterion(hasItem(ModItems.ELDERBERRIES), conditionsFromItem(ModItems.ELDERBERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CRIMSON_CHOW)
                .input(Items.COOKED_PORKCHOP)
                .input(Items.CRIMSON_FUNGUS, 2)
                .input(Items.CRIMSON_ROOTS)
                .input(Items.BOWL)
                .criterion(hasItem(Items.CRIMSON_FUNGUS), conditionsFromItem(Items.CRIMSON_FUNGUS))
                .criterion(hasItem(Items.CRIMSON_ROOTS), conditionsFromItem(Items.CRIMSON_ROOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WARPED_CHOW)
                .input(Items.WARPED_FUNGUS, 2)
                .input(Items.WARPED_ROOTS)
                .input(Items.NETHER_SPROUTS)
                .input(Items.BOWL)
                .criterion(hasItem(Items.WARPED_FUNGUS), conditionsFromItem(Items.WARPED_FUNGUS))
                .criterion(hasItem(Items.WARPED_ROOTS), conditionsFromItem(Items.WARPED_ROOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 8)
                        .group("stick")
                        .input(ModItemTags.FRUIT_LOGS)
                        .criterion("has_fruit_log", conditionsFromTag(ModItemTags.FRUIT_LOGS))
                        .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.WALNUT_MULCH, 4)
                .group("walnut_mulch")
                .input(ModBlocks.WALNUT_MULCH_BLOCK)
                .criterion("has_mulch", conditionsFromItem(ModBlocks.WALNUT_MULCH_BLOCK))
                .offerTo(exporter);

        offerBarkBlockRecipe(exporter, ModBlocks.APPLE_WOOD, ModBlocks.APPLE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_APPLE_WOOD, ModBlocks.STRIPPED_APPLE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.ORANGE_WOOD, ModBlocks.ORANGE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_ORANGE_WOOD, ModBlocks.STRIPPED_ORANGE_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.LEMON_WOOD, ModBlocks.LEMON_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_LEMON_WOOD, ModBlocks.STRIPPED_LEMON_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.PLUM_WOOD, ModBlocks.PLUM_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_PLUM_WOOD, ModBlocks.STRIPPED_PLUM_LOG);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.BROWN_DYE)
                .input(ModBlocks.WALNUT_MULCH)
                .criterion("has_mulch", conditionsFromItem(ModBlocks.WALNUT_MULCH))
                .offerTo(exporter);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WALNUT_MULCH_BLOCK, ModBlocks.WALNUT_MULCH);

        offerBarkBlockRecipe(exporter, ModBlocks.HOARY_WOOD, ModBlocks.HOARY_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_HOARY_WOOD, ModBlocks.STRIPPED_HOARY_LOG);
        offerBoatRecipe(exporter, ModItems.HOARY_BOAT, ModBlocks.HOARY_PLANKS);
        offerBoatRecipe(exporter, ModItems.WALNUT_BOAT, ModBlocks.WALNUT_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.HOARY_CHEST_BOAT, ModItems.HOARY_BOAT);
        offerChestBoatRecipe(exporter, ModItems.WALNUT_CHEST_BOAT, ModItems.WALNUT_BOAT);

        offerPicketsRecipe(exporter, ModBlocks.OAK_PICKETS, Items.OAK_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.SPRUCE_PICKETS, Items.SPRUCE_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.BIRCH_PICKETS, Items.BIRCH_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.JUNGLE_PICKETS, Items.JUNGLE_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.ACACIA_PICKETS, Items.ACACIA_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.DARK_OAK_PICKETS, Items.DARK_OAK_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.MANGROVE_PICKETS, Items.MANGROVE_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.CHERRY_PICKETS, Items.CHERRY_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.BAMBOO_PICKETS, Items.BAMBOO_PLANKS);
        offerPicketsRecipe(exporter, ModBlocks.WALNUT_PICKETS, ModBlocks.WALNUT_PLANKS);
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.WALNUT_CANDLE, 1)
                .input('S', Items.STRING)
                .input('H', Items.HONEYCOMB)
                .input('#', ModItems.WALNUT)
                .pattern("S")
                .pattern("H")
                .pattern("#")
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion(hasItem(ModItems.WALNUT), conditionsFromItem(ModItems.WALNUT))
                .offerTo(exporter);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPONGEKIN, ModItems.SPONGEKIN_SLICE);
        offerCompoteJarRecipe(exporter, ModItems.APPLE_COMPOTE_JAR, Items.APPLE);
        offerCompoteJarRecipe(exporter, ModItems.ORANGE_COMPOTE_JAR, ModItems.ORANGE);
        offerCompoteJarRecipe(exporter, ModItems.LEMON_COMPOTE_JAR, ModItems.LEMON);
        offerCompoteJarRecipe(exporter, ModItems.PLUM_COMPOTE_JAR, ModItems.PLUM);
        offerCompoteJarRecipe(exporter, ModItems.HOARY_COMPOTE_JAR, ModItems.HOARY_APPLE);
        offerCandyRecipe(exporter, ModItems.CANDY, Items.HONEY_BOTTLE);
        offerCandyRecipe(exporter, ModItems.PIQUANT_CANDY, Items.SWEET_BERRIES);
        offerCandyRecipe(exporter, ModItems.SOUR_CANDY, ModItems.CITRIC_ACID);
        offerCandyRecipe(exporter, ModItems.BITTER_CANDY, ModItems.ELDERBERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.PASSION_FRUIT_TART, ModItems.PASSION_FRUIT);
        offerTartAndPieRecipe(exporter, ModBlocks.ELDERBERRY_TART, ModItems.ELDERBERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.GLOW_BERRY_TART, Items.GLOW_BERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.LAPISBERRY_TART, ModItems.LAPISBERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.SWEET_BERRY_TART, Items.SWEET_BERRIES);
        offerTartAndPieRecipe(exporter, ModBlocks.APPLE_PIE, Items.APPLE);
        offerTartAndPieRecipe(exporter, ModBlocks.ORANGE_PIE, ModItems.ORANGE);
        offerTartAndPieRecipe(exporter, ModBlocks.LEMON_PIE, ModItems.LEMON);
        offerTartAndPieRecipe(exporter, ModBlocks.PLUM_PIE, ModItems.PLUM);
        offerTartAndPieRecipe(exporter, ModBlocks.HOARY_PIE, ModItems.HOARY_APPLE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BLOCK)
                .pattern("##")
                .pattern("##")
                .input('#', ModItems.FELDSPAR)
                .criterion(hasItem(ModItems.FELDSPAR), conditionsFromItem(ModItems.FELDSPAR))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FELDSPAR)
                .input(ModBlocks.FELDSPAR_BLOCK)
                .criterion(hasItem(ModBlocks.FELDSPAR_BLOCK), conditionsFromItem(ModBlocks.FELDSPAR_BLOCK))
                .offerTo(exporter);
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

//        offerTeaBlendMillingRecipe(exporter, ModItems.GREEN_TEA_BLEND, ModItems.TEA_LEAVES);
//        offerTeaBlendMillingRecipe(exporter, ModItems.BLACK_TEA_BLEND, ModItems.DRIED_TEA_LEAVES);
//        offerTeaBlendMillingRecipe(exporter, ModItems.CHAMOMILE_TEA_BLEND, ModBlocks.CHAMOMILE_FLOWERS);
//        offerTeaBlendMillingRecipe(exporter, ModItems.HONEYSUCKLE_TEA_BLEND, ModBlocks.HONEYSUCKLE);
//        offerTeaBlendMillingRecipe(exporter, ModItems.BELLFLOWER_TEA_BLEND, ModBlocks.VIOLET_BELLFLOWER);
//        offerTeaBlendMillingRecipe(exporter, ModItems.TORCHFLOWER_TEA_BLEND, Items.TORCHFLOWER);
//        new MillingRecipeBuilder(Items.GRANITE, ModItems.FELDSPAR, 2, "granite")
//                .group("feldspar")
//                .criterion("has_felsic_stone", conditionsFromTag(ModItemTags.FELSIC_STONES))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DIORITE, ModItems.FELDSPAR, 2, "diorite")
//                .group("feldspar")
//                .criterion("has_felsic_stone", conditionsFromTag(ModItemTags.FELSIC_STONES))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.ANDESITE, ModItems.FELDSPAR, 2, "andesite")
//                .group("feldspar")
//                .criterion("has_felsic_stone", conditionsFromTag(ModItemTags.FELSIC_STONES))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.TUFF, ModItems.FELDSPAR, 2, "tuff")
//                .group("feldspar")
//                .criterion("has_felsic_stone", conditionsFromTag(ModItemTags.FELSIC_STONES))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.BONE, Items.BONE_MEAL, 4, null)
//                .group("bone_meal")
//                .criterion(hasItem(Items.BONE), conditionsFromItem(Items.BONE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.WHEAT, ModItems.FLOUR, 2, "wheat")
//                .group("flour")
//                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(ModItems.MAIZE, ModItems.FLOUR, 2, "maize")
//                .group("flour")
//                .criterion(hasItem(ModItems.MAIZE), conditionsFromItem(ModItems.MAIZE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.COAL_ORE, Items.COAL, 2, null)
//                .group("coal")
//                .criterion(hasItem(Items.COAL_ORE), conditionsFromItem(Items.COAL_ORE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DEEPSLATE_COAL_ORE, Items.COAL, 2, "deepslate")
//                .group("coal")
//                .criterion(hasItem(Items.DEEPSLATE_COAL_ORE), conditionsFromItem(Items.DEEPSLATE_COAL_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.IRON_ORE, Items.RAW_IRON, 2, null)
//                .group("iron")
//                .criterion(hasItem(Items.IRON_ORE), conditionsFromItem(Items.IRON_ORE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DEEPSLATE_IRON_ORE, Items.RAW_IRON, 2, "deepslate")
//                .group("iron")
//                .criterion(hasItem(Items.DEEPSLATE_IRON_ORE), conditionsFromItem(Items.DEEPSLATE_IRON_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.GOLD_ORE, Items.RAW_GOLD, 2, null)
//                .group("gold")
//                .criterion(hasItem(Items.GOLD_ORE), conditionsFromItem(Items.GOLD_ORE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD, 2, "deepslate")
//                .group("gold")
//                .criterion(hasItem(Items.DEEPSLATE_GOLD_ORE), conditionsFromItem(Items.DEEPSLATE_GOLD_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.COPPER_ORE, Items.RAW_COPPER, 5, null)
//                .group("copper")
//                .criterion(hasItem(Items.COPPER_ORE), conditionsFromItem(Items.COPPER_ORE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER, 5, "deepslate")
//                .group("copper")
//                .criterion(hasItem(Items.DEEPSLATE_COPPER_ORE), conditionsFromItem(Items.DEEPSLATE_COPPER_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.LAPIS_ORE, Items.LAPIS_LAZULI, 8, null)
//                .group("lapis")
//                .criterion(hasItem(Items.LAPIS_ORE), conditionsFromItem(Items.LAPIS_ORE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DEEPSLATE_LAPIS_ORE, Items.LAPIS_LAZULI, 8, "deepslate")
//                .group("lapis")
//                .criterion(hasItem(Items.DEEPSLATE_LAPIS_ORE), conditionsFromItem(Items.DEEPSLATE_LAPIS_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.REDSTONE_ORE, Items.REDSTONE, 6, null)
//                .group("redstone")
//                .criterion(hasItem(Items.REDSTONE_ORE), conditionsFromItem(Items.REDSTONE_ORE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DEEPSLATE_REDSTONE_ORE, Items.REDSTONE, 6, "deepslate")
//                .group("redstone")
//                .criterion(hasItem(Items.DEEPSLATE_REDSTONE_ORE), conditionsFromItem(Items.DEEPSLATE_REDSTONE_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.NETHER_GOLD_ORE, Items.GOLD_NUGGET, 8, null)
//                .group("gold_nugget")
//                .criterion(hasItem(Items.NETHER_GOLD_ORE), conditionsFromItem(Items.NETHER_GOLD_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.NETHER_QUARTZ_ORE, Items.QUARTZ, 2, null)
//                .group("quartz")
//                .criterion(hasItem(Items.NETHER_QUARTZ_ORE), conditionsFromItem(Items.NETHER_QUARTZ_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.EMERALD_ORE, Items.EMERALD, 2, null)
//                .group("emerald")
//                .criterion(hasItem(Items.EMERALD_ORE), conditionsFromItem(Items.EMERALD_ORE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DEEPSLATE_EMERALD_ORE, Items.EMERALD, 2, "deepslate")
//                .group("emerald")
//                .criterion(hasItem(Items.DEEPSLATE_EMERALD_ORE), conditionsFromItem(Items.DEEPSLATE_EMERALD_ORE))
//                .offerTo(exporter);
//
//        new MillingRecipeBuilder(Items.DIAMOND_ORE, Items.DIAMOND, 2, null)
//                .group("diamond")
//                .criterion(hasItem(Items.DIAMOND_ORE), conditionsFromItem(Items.DIAMOND_ORE))
//                .offerTo(exporter);
//        new MillingRecipeBuilder(Items.DEEPSLATE_DIAMOND_ORE, Items.DIAMOND, 2, "deepslate")
//                .group("diamond")
//                .criterion(hasItem(Items.DEEPSLATE_DIAMOND_ORE), conditionsFromItem(Items.DEEPSLATE_DIAMOND_ORE))
//                .offerTo(exporter);

        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_FELDSPAR_BLOCK, ModBlocks.FELDSPAR_BLOCK);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICKS, ModBlocks.CUT_FELDSPAR_BLOCK);
        BlockFamily feldsparBricksFamily = register(ModBlocks.FELDSPAR_BRICKS)
                .stairs(ModBlocks.FELDSPAR_BRICK_STAIRS)
                .slab(ModBlocks.FELDSPAR_BRICK_SLAB)
                .unlockCriterionName("has_feldspar_bricks")
                .build();
        generateFamily(exporter, feldsparBricksFamily);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_FELDSPAR_BLOCK, ModBlocks.FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICKS, ModBlocks.FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICK_STAIRS, ModBlocks.FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICK_SLAB, ModBlocks.FELDSPAR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICKS, ModBlocks.CUT_FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICK_STAIRS, ModBlocks.CUT_FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICK_SLAB, ModBlocks.CUT_FELDSPAR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICK_STAIRS, ModBlocks.FELDSPAR_BRICKS, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FELDSPAR_BRICK_SLAB, ModBlocks.FELDSPAR_BRICKS, 2);

        offerSmelting(exporter, ImmutableList.of(ModItems.CERAMIC_CLAY), RecipeCategory.MISC, ModItems.CERAMIC_TILE, 0.3f, 200, "ceramic_tile");
        offerSmelting(exporter, ImmutableList.of(ModItems.TEA_LEAVES), RecipeCategory.FOOD, ModItems.DRIED_TEA_LEAVES, 0.3f, 200, "dried_tea_leaves");

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ARTISAN_BRUSH)
                .pattern("FFF")
                .pattern(" G ")
                .pattern(" S ")
                .input('F', Items.STRING)
                .input('G', Items.GOLD_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.CERAMIC_TILES), conditionsFromItem(ModBlocks.CERAMIC_TILES))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);

        offerCeramicUndyingRecipe(exporter, ModBlocks.CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, ModBlocks.CERAMIC_TILE_STAIRS);
        offerCeramicUndyingRecipe(exporter, ModBlocks.CERAMIC_TILE_SLAB);
        offerCeramicUndyingRecipe(exporter, ModBlocks.CHECKERED_CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, ModBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        offerCeramicUndyingRecipe(exporter, ModBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        offerCeramicUndyingRecipe(exporter, ModBlocks.CERAMIC_PRESSURE_PLATE);
        offerCeramicUndyingRecipe(exporter, ModBlocks.CERAMIC_BUTTON);
        offerCeramicUndyingRecipe(exporter, ModBlocks.CERAMIC_DISH);
        offerCeramicUndyingRecipe(exporter, ModItems.ARTISAN_BRUSH);

        offerHangingSignRecipe(exporter, ModItems.HOARY_HANGING_SIGN, ModBlocks.STRIPPED_HOARY_LOG);
        offerHangingSignRecipe(exporter, ModItems.WALNUT_HANGING_SIGN, ModBlocks.STRIPPED_WALNUT_LOG);
    }









    public static void offerCeramicUndyingRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible item) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, item, 1).input(item)
                .criterion("has_item", conditionsFromItem(item)).offerTo(exporter, getItemId(item) + "_undying");
    }


    public static void offerTeaBlendMillingRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        new MillingRecipeBuilder(input, output, 1, null)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, teaCandle, 1)
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
