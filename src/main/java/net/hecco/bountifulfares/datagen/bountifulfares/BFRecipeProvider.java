package net.hecco.bountifulfares.datagen.bountifulfares;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.datagen.recipe.FermentingRecipeBuilder;
import net.hecco.bountifulfares.datagen.recipe.MillingRecipeBuilder;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.BlockFamilies.familyBuilder;
import static net.minecraft.data.recipes.RecipeBuilder.getDefaultRecipeId;

public class BFRecipeProvider extends FabricRecipeProvider {

    public BFRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BFBlocks.GRISTMILL)
                .pattern("IP")
                .pattern("BB")
                .define('I', Items.IRON_INGOT)
                .define('P', ItemTags.PLANKS)
                .define('B', Items.BRICK)
                .unlockedBy("has_plank", has(ItemTags.PLANKS))
                .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BFItems.SUN_HAT)
                .pattern("###")
                .pattern("# #")
                .define('#', Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(exporter);

        oneToOneConversionRecipe(exporter, BFItems.SWEET_BERRY_PIPS, Items.SWEET_BERRIES, "sweet_berry_seeds");

//        for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//            if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                if (trellis.getPlanks() != Items.STICK) {
//                    ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, TrellisUtil.getTrellisFromVariant(trellis))
//                            .pattern("# #")
//                            .pattern(" P ")
//                            .pattern("# #")
//                            .input('#', Items.STICK)
//                            .input('P', trellis.getPlanks())
//                            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
//                            .criterion(hasItem(trellis.getPlanks()), conditionsFromItem(trellis.getPlanks()))
//                            .group("trellis")
//                            .offerTo(exporter);
//                } else {
//                    ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, TrellisUtil.getTrellisFromVariant(trellis))
//                            .pattern("# #")
//                            .pattern(" # ")
//                            .pattern("# #")
//                            .input('#', Items.STICK)
//                            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
//                            .group("trellis")
//                            .offerTo(exporter);
//                }
//            }
//        }
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.OAK);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.SPRUCE);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.BIRCH);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.JUNGLE);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.ACACIA);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.DARK_OAK);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.MANGROVE);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.CHERRY);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.BAMBOO);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.WALNUT);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.HOARY);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.CRIMSON);
        TrellisUtil.registerTrellisRecipe(exporter, BFTrellises.WARPED);




        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BFBlocks.FELDSPAR_LANTERN)
                .pattern("III")
                .pattern("FTF")
                .pattern("III")
                .define('I', Items.IRON_NUGGET)
                .define('F', BFItems.FELDSPAR)
                .define('T', Items.TORCH)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .unlockedBy(getHasName(BFItems.FELDSPAR), has(BFItems.FELDSPAR))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BFBlocks.TINGED_GLASS)
                .pattern(" F ")
                .pattern("FGF")
                .pattern(" F ")
                .define('F', BFItems.FELDSPAR)
                .define('G', Items.GLASS)
                .unlockedBy(getHasName(BFItems.FELDSPAR), has(BFItems.FELDSPAR))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BFItems.CERAMIC_CLAY, 4)
                .requires(Items.CLAY_BALL, 3)
                .requires(BFItems.FELDSPAR)
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .unlockedBy(getHasName(BFItems.FELDSPAR), has(BFItems.FELDSPAR))
                .group("ceramic_clay")
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, BFBlocks.CERAMIC_BUTTON)
                .requires(BFItems.CERAMIC_TILE, 1)
                .unlockedBy(getHasName(BFItems.CERAMIC_TILE), has(BFItems.CERAMIC_TILE))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BFBlocks.CERAMIC_PRESSURE_PLATE)
                .pattern("##")
                .define('#', BFItems.CERAMIC_TILE)
                .unlockedBy(getHasName(BFItems.CERAMIC_TILE), has(BFItems.CERAMIC_TILE))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BFBlocks.CERAMIC_DISH)
                .pattern("###")
                .define('#', BFItems.CERAMIC_TILE)
                .unlockedBy(getHasName(BFItems.CERAMIC_TILE), has(BFItems.CERAMIC_TILE))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, BFBlocks.CERAMIC_LEVER)
                .pattern(" S ")
                .pattern("###")
                .define('S', Items.STICK)
                .define('#', BFItems.CERAMIC_TILE)
                .unlockedBy(getHasName(BFItems.CERAMIC_TILE), has(BFItems.CERAMIC_TILE))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BFItems.JAR, 3)
                .pattern("# #")
                .pattern(" # ")
                .define('#', BFItems.CERAMIC_CLAY)
                .unlockedBy(getHasName(BFItems.CERAMIC_CLAY), has(BFItems.CERAMIC_CLAY))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BFBlocks.FERMENTATION_VESSEL)
                .pattern(" # ")
                .pattern("# #")
                .pattern("###")
                .define('#', BFItems.CERAMIC_CLAY)
                .unlockedBy(getHasName(BFItems.CERAMIC_CLAY), has(BFItems.CERAMIC_CLAY))
                .save(exporter);

        BlockFamily hoaryFamily = familyBuilder(BFBlocks.HOARY_PLANKS)
                .button(BFBlocks.HOARY_BUTTON)
                .fence(BFBlocks.HOARY_FENCE)
                .fenceGate(BFBlocks.HOARY_FENCE_GATE)
                .pressurePlate(BFBlocks.HOARY_PRESSURE_PLATE)
                .sign(BFBlocks.HOARY_SIGN, BFBlocks.HOARY_WALL_SIGN)
                .slab(BFBlocks.HOARY_SLAB)
                .stairs(BFBlocks.HOARY_STAIRS)
                .door(BFBlocks.HOARY_DOOR)
                .trapdoor(BFBlocks.HOARY_TRAPDOOR)
                .recipeGroupPrefix("wooden")
                .recipeUnlockedBy("has_planks")
                .getFamily();
        generateRecipes(exporter, hoaryFamily, FeatureFlagSet.of(FeatureFlags.VANILLA));
        planksFromLogs(exporter, BFBlocks.HOARY_PLANKS, BFItemTags.HOARY_LOGS, 4);


        BlockFamily walnutFamily = familyBuilder(BFBlocks.WALNUT_PLANKS)
                .button(BFBlocks.WALNUT_BUTTON)
                .fence(BFBlocks.WALNUT_FENCE)
                .fenceGate(BFBlocks.WALNUT_FENCE_GATE)
                .pressurePlate(BFBlocks.WALNUT_PRESSURE_PLATE)
                .sign(BFBlocks.WALNUT_SIGN, BFBlocks.WALNUT_WALL_SIGN)
                .slab(BFBlocks.WALNUT_SLAB)
                .stairs(BFBlocks.WALNUT_STAIRS)
                .door(BFBlocks.WALNUT_DOOR)
                .trapdoor(BFBlocks.WALNUT_TRAPDOOR)
                .recipeGroupPrefix("wooden")
                .recipeUnlockedBy("has_planks")
                .getFamily();
        generateRecipes(exporter, walnutFamily, FeatureFlagSet.of(FeatureFlags.VANILLA));
        planksFromLogs(exporter, BFBlocks.WALNUT_PLANKS, BFItemTags.WALNUT_LOGS, 4);

        BlockFamily ceramicFamily = familyBuilder(BFBlocks.CERAMIC_TILES)
                .slab(BFBlocks.CERAMIC_TILE_SLAB)
                .stairs(BFBlocks.CERAMIC_TILE_STAIRS)
                /*.wall(BFBlocks.CERAMIC_TILE_WALL)*/
                .recipeGroupPrefix("ceramic_tiles")
                .recipeUnlockedBy("has_ceramic_tiles")
                .getFamily();
        generateRecipes(exporter, ceramicFamily, FeatureFlagSet.of(FeatureFlags.VANILLA));

//        BlockFamily checkeredCeramicFamily = register(ModBlocks.CHECKERED_CERAMIC_TILES)
//                .slab(ModBlocks.CERAMIC_TILE_SLAB)
//                .stairs(ModBlocks.CERAMIC_TILE_STAIRS)
//                .group("checkered_ceramic_tiles")
//                .unlockCriterionName("has_checkered_ceramic_tiles")
//                .build();
//        generateFamily(exporter, checkeredCeramicFamily);

        BlockFamily ceramicMosaicFamily = familyBuilder(BFBlocks.CERAMIC_MOSAIC)
                .slab(BFBlocks.CERAMIC_MOSAIC_SLAB)
                .stairs(BFBlocks.CERAMIC_MOSAIC_STAIRS)
                /*.wall(BFBlocks.CERAMIC_MOSAIC_WALL)*/
                .recipeGroupPrefix("ceramic_mosaic")
                .recipeUnlockedBy("has_ceramic_mosaic")
                .getFamily();
        generateRecipes(exporter, ceramicMosaicFamily, FeatureFlagSet.of(FeatureFlags.VANILLA));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BFBlocks.CERAMIC_DOOR)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .define('#', BFItems.CERAMIC_TILE)
                .unlockedBy(getHasName(BFItems.CERAMIC_TILE), has(BFItems.CERAMIC_TILE))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BFBlocks.CERAMIC_TRAPDOOR)
                .pattern("###")
                .pattern("###")
                .define('#', BFItems.CERAMIC_TILE)
                .unlockedBy(getHasName(BFItems.CERAMIC_TILE), has(BFItems.CERAMIC_TILE))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFBlocks.ARTISAN_BREAD)
                .requires(BFItemTags.C_FLOUR)
                .requires(BFItemTags.C_FLOUR)
                .requires(BFItemTags.C_FLOUR)
                .requires(Items.EGG)
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(BFItems.FLOUR), has(BFItemTags.C_FLOUR))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.ARTISAN_COOKIE, 4)
                .requires(BFItemTags.C_FLOUR)
                .requires(BFItemTags.C_ELDERBERRIES)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(BFItems.ELDERBERRIES), has(BFItemTags.C_ELDERBERRIES))
                .unlockedBy(getHasName(BFItems.FLOUR), has(BFItemTags.C_FLOUR))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BFBlocks.COCOA_CAKE)
                .pattern("MMM")
                .pattern("CEC")
                .pattern("FFF")
                .define('M', BFItemTags.C_MILKS)
                .define('E', Items.EGG)
                .define('F', BFItemTags.C_FLOUR)
                .define('C', Items.COCOA_BEANS)
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(BFItems.FLOUR), has(BFItemTags.C_FLOUR))
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BFBlocks.COCONUT_CAKE)
                .pattern("CCC")
                .pattern("SES")
                .pattern("FFF")
                .define('C', BFItemTags.C_COCONUT_HALVES)
                .define('E', Items.EGG)
                .define('F', BFItemTags.C_FLOUR)
                .define('S', Items.SUGAR)
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(BFItems.FLOUR), has(BFItemTags.C_FLOUR))
                .unlockedBy(getHasName(BFItems.COCONUT_HALF), has(BFItemTags.C_COCONUT_HALVES))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BFBlocks.SPONGE_CAKE)
                .pattern("PPP")
                .pattern("SES")
                .pattern("###")
                .define('P', Items.WATER_BUCKET)
                .define('E', Items.EGG)
                .define('#', BFBlocks.SPONGEKIN)
                .define('S', Items.SUGAR)
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(Items.SPONGE), has(Items.SPONGE))
                .unlockedBy(getHasName(BFBlocks.SPONGEKIN), has(BFBlocks.SPONGEKIN))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BFItems.MAIZE_BREAD)
                .pattern("###")
                .define('#', BFItemTags.C_CORN)
                .unlockedBy(getHasName(BFItems.MAIZE), has(BFItemTags.C_CORN))
                .save(exporter);

        oreSmelting(exporter, ImmutableList.of(BFItems.MAIZE_SEEDS), RecipeCategory.FOOD, BFItems.POPPED_MAIZE, 0.1f, 100, "popped_maize");
        oreCooking(exporter, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, ImmutableList.of(BFItems.MAIZE_SEEDS), RecipeCategory.FOOD, BFItems.POPPED_MAIZE, 0.1f, 50, "popped_maize", "_from_smoking");
        oreCooking(exporter, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, ImmutableList.of(BFItems.MAIZE_SEEDS), RecipeCategory.FOOD, BFItems.POPPED_MAIZE, 0.1f, 300, "popped_maize", "_from_campfire_cooking");

        oreSmelting(exporter, ImmutableList.of(Items.EGG), RecipeCategory.FOOD, BFItems.COOKED_EGG, 0.1f, 100, "cooked_egg");
        oreCooking(exporter, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, ImmutableList.of(Items.EGG), RecipeCategory.FOOD, BFItems.COOKED_EGG, 0.1f, 50, "cooked_egg", "_from_smoking");
        oreCooking(exporter, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, ImmutableList.of(Items.EGG), RecipeCategory.FOOD, BFItems.COOKED_EGG, 0.1f, 300, "cooked_egg", "_from_campfire_cooking");


        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, BFItems.WALNUT_COOKIE, 4)
                .pattern("#W#")
                .define('#', BFItemTags.C_FLOUR)
                .define('W', BFItemTags.C_WALNUTS)
                .unlockedBy(getHasName(BFItems.FLOUR), has(BFItemTags.C_FLOUR))
                .unlockedBy(getHasName(BFItems.WALNUT), has(BFItemTags.C_WALNUTS))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.FOREST_MEDLEY)
                .requires(Items.COOKED_PORKCHOP)
                .requires(Items.CARROT)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.BREAD)
                .unlockedBy(getHasName(Items.COOKED_PORKCHOP), has(Items.COOKED_PORKCHOP))
                .unlockedBy(getHasName(Items.CARROT), has(Items.CARROT))
                .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.ARID_MEDLEY)
                .requires(Items.CACTUS)
                .requires(Items.POTATO)
                .requires(BFItemTags.C_CORN)
                .requires(Items.BREAD)
                .unlockedBy(getHasName(Items.CACTUS), has(Items.CACTUS))
                .unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
                .unlockedBy(getHasName(BFItems.MAIZE), has(BFItemTags.C_CORN))
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.MEADOW_MEDLEY)
                .requires(Items.COOKED_MUTTON)
                .requires(Items.BEETROOT)
                .requires(BFBlocks.VIOLET_BELLFLOWER)
                .requires(BFItems.LEEK)
                .unlockedBy(getHasName(Items.COOKED_MUTTON), has(Items.COOKED_MUTTON))
                .unlockedBy(getHasName(Items.BEETROOT), has(Items.BEETROOT))
                .unlockedBy(getHasName(BFBlocks.VIOLET_BELLFLOWER), has(BFBlocks.VIOLET_BELLFLOWER))
                .unlockedBy(getHasName(BFItems.LEEK), has(BFItems.LEEK))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.MIRE_MEDLEY)
                .requires(BFItemTags.C_ELDERBERRIES)
                .requires(BFItemTags.C_CORN)
                .requires(BFBlocks.CHAMOMILE_FLOWERS)
                .requires(Items.CARROT)
                .unlockedBy(getHasName(BFItems.ELDERBERRIES), has(BFItemTags.C_ELDERBERRIES))
                .unlockedBy(getHasName(BFItems.MAIZE), has(BFItemTags.C_CORN))
                .unlockedBy(getHasName(BFBlocks.CHAMOMILE_FLOWERS), has(BFBlocks.CHAMOMILE_FLOWERS))
                .unlockedBy(getHasName(Items.CARROT), has(Items.CARROT))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.COASTAL_MEDLEY)
                .requires(BFItems.SPONGEKIN_SLICE)
                .requires(Items.DRIED_KELP, 2)
                .requires(BFItemTags.COOKED_FISHES)
                .unlockedBy(getHasName(BFItems.SPONGEKIN_SLICE), has(BFItems.SPONGEKIN_SLICE))
                .unlockedBy(getHasName(Items.DRIED_KELP), has(Items.DRIED_KELP))
                .unlockedBy("has_fish", has(BFItemTags.COOKED_FISHES))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.TROPICAL_MEDLEY)
                .requires(BFItemTags.C_ORANGES)
                .requires(Items.COCOA_BEANS)
                .requires(BFItemTags.C_PASSION_FRUIT)
                .requires(BFItems.COCONUT_HALF)
                .unlockedBy(getHasName(BFItems.ORANGE), has(BFItemTags.C_ORANGES))
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .unlockedBy(getHasName(BFItems.PASSION_FRUIT), has(BFItemTags.C_PASSION_FRUIT))
                .unlockedBy(getHasName(BFItems.COCONUT_HALF), has(BFItems.COCONUT_HALF))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.STUFFED_HOARY_APPLE)
                .requires(BFItems.HOARY_APPLE)
                .requires(BFItems.LAPISBERRIES, 2)
                .unlockedBy(getHasName(BFItems.HOARY_APPLE), has(BFItems.HOARY_APPLE))
                .unlockedBy(getHasName(BFItems.LAPISBERRIES), has(BFItems.LAPISBERRIES))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.SEA_SALAD)
                .requires(Items.KELP, 2)
                .requires(BFItems.LEEK)
                .requires(BFItems.CITRUS_ESSENCE)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(Items.KELP), has(Items.KELP))
                .unlockedBy(getHasName(BFItems.LEEK), has(BFItems.LEEK))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.MUSHROOM_STUFFED_POTATO)
                .requires(Items.BAKED_POTATO)
                .requires(Items.RED_MUSHROOM)
                .requires(Items.BROWN_MUSHROOM)
                .unlockedBy(getHasName(Items.BAKED_POTATO), has(Items.BAKED_POTATO))
                .unlockedBy(getHasName(Items.RED_MUSHROOM), has(Items.RED_MUSHROOM))
                .unlockedBy(getHasName(Items.BROWN_MUSHROOM), has(Items.BROWN_MUSHROOM))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.BERRY_STUFFED_POTATO)
                .requires(Items.BAKED_POTATO)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.GLOW_BERRIES)
                .unlockedBy(getHasName(Items.BAKED_POTATO), has(Items.BAKED_POTATO))
                .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                .unlockedBy(getHasName(Items.GLOW_BERRIES), has(Items.GLOW_BERRIES))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.MAIZE_STUFFED_POTATO)
                .requires(Items.BAKED_POTATO)
                .requires(BFItemTags.C_CORN)
                .unlockedBy(getHasName(Items.BAKED_POTATO), has(Items.BAKED_POTATO))
                .unlockedBy(getHasName(BFItems.MAIZE), has(BFItemTags.C_CORN))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.PASSION_GLAZED_SALMON)
                .requires(BFItemTags.C_PASSION_FRUIT)
                .requires(BFItemTags.C_PASSION_FRUIT)
                .requires(Items.COOKED_SALMON)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(BFItems.PASSION_FRUIT), has(BFItemTags.C_PASSION_FRUIT))
                .unlockedBy(getHasName(Items.COOKED_SALMON), has(Items.COOKED_SALMON))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.COCONUT_CRUSTED_COD)
                .requires(BFItemTags.C_COCONUT_HALVES)
                .requires(BFItemTags.C_COCONUT_HALVES)
                .requires(Items.COOKED_COD)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(BFItems.COCONUT_HALF), has(BFItemTags.C_COCONUT_HALVES))
                .unlockedBy(getHasName(Items.COOKED_COD), has(Items.COOKED_COD))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.BOUNTIFUL_STEW)
                .requires(Items.COOKED_PORKCHOP)
                .requires(Items.CARROT)
                .requires(BFItemTags.C_CORN)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(Items.COOKED_PORKCHOP), has(Items.COOKED_PORKCHOP))
                .unlockedBy(getHasName(Items.CARROT), has(Items.CARROT))
                .unlockedBy(getHasName(BFItems.MAIZE), has(BFItemTags.C_CORN))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.LEEK_STEW)
                .requires(BFItems.LEEK, 3)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(BFItems.LEEK), has(BFItems.LEEK))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.APPLE_STEW)
                .requires(Items.APPLE, 2)
                .requires(BFItemTags.C_ELDERBERRIES)
                .requires(BFItemTags.C_ELDERBERRIES)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .unlockedBy(getHasName(BFItems.ELDERBERRIES), has(BFItemTags.C_ELDERBERRIES))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.COCONUT_STEW)
                .requires(BFItemTags.C_COCONUT_HALVES)
                .requires(BFItemTags.C_COCONUT_HALVES)
                .requires(BFItems.LEEK, 1)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(BFItems.COCONUT_HALF), has(BFItemTags.C_COCONUT_HALVES))
                .unlockedBy(getHasName(BFItems.LEEK), has(BFItems.LEEK))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.STONE_STEW)
                .requires(Items.STONE_PICKAXE)
                .requires(Items.COBBLESTONE, 2)
                .requires(Items.ROTTEN_FLESH, 1)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(Items.STONE_PICKAXE), has(Items.STONE_PICKAXE))
                .unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.FISH_STEW)
                .group("fish_stew")
                .requires(Ingredient.of(BFItemTags.COOKED_FISHES), 2)
                .requires(Items.DRIED_KELP, 2)
                .requires(Items.BOWL)
                .unlockedBy("has_cooked_fish", has(BFItemTags.COOKED_FISHES))
                .unlockedBy(getHasName(Items.DRIED_KELP), has(Items.DRIED_KELP))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.CUSTARD)
                .requires(BFItemTags.C_MILKS)
                .requires(Items.SUGAR)
                .requires(Items.BOWL)
                .unlockedBy("has_milk", has(BFItemTags.C_MILKS))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.PIQUANT_CUSTARD)
                .requires(BFItemTags.C_MILKS)
                .requires(Items.SUGAR)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.BOWL)
                .unlockedBy("has_milk", has(BFItemTags.C_MILKS))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.PASSION_CUSTARD)
                .requires(BFItemTags.C_MILKS)
                .requires(Items.SUGAR)
                .requires(BFItemTags.C_PASSION_FRUIT)
                .requires(Items.BOWL)
                .unlockedBy("has_milk", has(BFItemTags.C_MILKS))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BFItems.PASSION_FRUIT), has(BFItemTags.C_PASSION_FRUIT))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.COCOA_CUSTARD)
                .requires(BFItemTags.C_MILKS)
                .requires(Items.SUGAR)
                .requires(Items.COCOA_BEANS)
                .requires(BFItemTags.C_WALNUTS)
                .requires(Items.BOWL)
                .unlockedBy("has_milk", has(BFItemTags.C_MILKS))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .unlockedBy(getHasName(BFItems.WALNUT), has(BFItemTags.C_WALNUTS))
                .save(exporter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.ANCIENT_CUSTARD)
                .requires(BFItemTags.C_MILKS)
                .requires(Items.SUGAR)
                .requires(BFItems.LAPISBERRIES)
                .requires(BFItems.HOARY_APPLE)
                .requires(Items.BOWL)
                .unlockedBy("has_milk", has(BFItemTags.C_MILKS))
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(BFItems.HOARY_APPLE), has(BFItems.HOARY_APPLE))
                .unlockedBy(getHasName(BFItems.LAPISBERRIES), has(BFItems.LAPISBERRIES))
                .save(exporter);

        offerCandiedFruitRecipe(exporter, Items.APPLE, BFItems.CANDIED_APPLE, 1);
        offerCandiedFruitRecipe(exporter, BFItems.PLUM, BFItemTags.C_PLUMS, BFItems.CANDIED_PLUM, 1);
        offerCandiedFruitRecipe(exporter, BFItems.ORANGE, BFItemTags.C_ORANGES, BFItems.CANDIED_ORANGE, 4);
        offerCandiedFruitRecipe(exporter, BFItems.LEMON, BFItemTags.C_LEMONS, BFItems.CANDIED_LEMON, 4);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.CRUSTED_BEEF)
                .requires(Items.COOKED_BEEF)
                .requires(BFItemTags.C_WALNUTS)
                .requires(BFItemTags.C_WALNUTS)
                .requires(Items.POTATO)
                .requires(BFItemTags.C_ELDERBERRIES)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(Items.COOKED_BEEF), has(Items.COOKED_BEEF))
                .unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
                .unlockedBy(getHasName(BFItems.WALNUT), has(BFItemTags.C_WALNUTS))
                .unlockedBy(getHasName(BFItems.ELDERBERRIES), has(BFItemTags.C_ELDERBERRIES))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.CRIMSON_CHOW)
                .requires(Items.COOKED_PORKCHOP)
                .requires(Items.CRIMSON_FUNGUS, 2)
                .requires(Items.CRIMSON_ROOTS)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(Items.CRIMSON_FUNGUS), has(Items.CRIMSON_FUNGUS))
                .unlockedBy(getHasName(Items.CRIMSON_ROOTS), has(Items.CRIMSON_ROOTS))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BFItems.WARPED_CHOW)
                .requires(Items.WARPED_FUNGUS, 2)
                .requires(Items.WARPED_ROOTS)
                .requires(Items.NETHER_SPROUTS)
                .requires(Items.BOWL)
                .unlockedBy(getHasName(Items.WARPED_FUNGUS), has(Items.WARPED_FUNGUS))
                .unlockedBy(getHasName(Items.WARPED_ROOTS), has(Items.WARPED_ROOTS))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STICK, 8)
                        .group("stick")
                        .requires(BFItemTags.FRUIT_LOGS)
                        .unlockedBy("has_fruit_log", has(BFItemTags.FRUIT_LOGS))
                        .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BFBlocks.WALNUT_MULCH, 4)
                .group("walnut_mulch")
                .requires(BFBlocks.WALNUT_MULCH_BLOCK)
                .unlockedBy("has_mulch", has(BFBlocks.WALNUT_MULCH_BLOCK))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE)
                .requires(BFItems.TEA_BERRIES)
                .unlockedBy(getHasName(BFItems.TEA_BERRIES), has(BFItems.TEA_BERRIES))
                .save(exporter);

        woodFromLogs(exporter, BFBlocks.APPLE_WOOD, BFBlocks.APPLE_LOG);
        woodFromLogs(exporter, BFBlocks.STRIPPED_APPLE_WOOD, BFBlocks.STRIPPED_APPLE_LOG);
        woodFromLogs(exporter, BFBlocks.GOLDEN_APPLE_WOOD, BFBlocks.GOLDEN_APPLE_LOG);
        woodFromLogs(exporter, BFBlocks.ORANGE_WOOD, BFBlocks.ORANGE_LOG);
        woodFromLogs(exporter, BFBlocks.STRIPPED_ORANGE_WOOD, BFBlocks.STRIPPED_ORANGE_LOG);
        woodFromLogs(exporter, BFBlocks.LEMON_WOOD, BFBlocks.LEMON_LOG);
        woodFromLogs(exporter, BFBlocks.STRIPPED_LEMON_WOOD, BFBlocks.STRIPPED_LEMON_LOG);
        woodFromLogs(exporter, BFBlocks.PLUM_WOOD, BFBlocks.PLUM_LOG);
        woodFromLogs(exporter, BFBlocks.STRIPPED_PLUM_WOOD, BFBlocks.STRIPPED_PLUM_LOG);
        woodFromLogs(exporter, BFBlocks.PALM_WOOD, BFBlocks.PALM_LOG);
        woodFromLogs(exporter, BFBlocks.STRIPPED_PALM_WOOD, BFBlocks.STRIPPED_PALM_LOG);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.BROWN_DYE)
                .requires(BFBlocks.WALNUT_MULCH)
                .unlockedBy("has_mulch", has(BFBlocks.WALNUT_MULCH))
                .save(exporter);

        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.WALNUT_MULCH_BLOCK, BFBlocks.WALNUT_MULCH);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BFBlocks.PALM_MULCH, 4)
                .group("coconut_mulch")
                .requires(BFBlocks.PALM_MULCH_BLOCK)
                .unlockedBy("has_mulch", has(BFBlocks.PALM_MULCH_BLOCK))
                .save(exporter);
        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.PALM_MULCH_BLOCK, BFBlocks.PALM_MULCH);

        oneToOneConversionRecipe(exporter, BFItems.COCONUT_HALF, BFItems.COCONUT, "coconut_half", 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER, 2)
                .pattern("##")
                .define('#', BFItems.PALM_FROND)
                .unlockedBy(getHasName(BFItems.PALM_FROND), has(BFItems.PALM_FROND))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.PACKED_MUD)
                .requires(Items.MUD)
                .requires(BFItems.COCONUT_COIR)
                .group("packed_mud")
                .unlockedBy(getHasName(Items.MUD), has(Items.MUD))
                .save(exporter);

        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.PACKED_COCONUT_COIR, BFItems.COCONUT_COIR);
        polished(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.COIR_BRICKS, BFBlocks.PACKED_COCONUT_COIR);
        BlockFamily coirBricksFamily = familyBuilder(BFBlocks.COIR_BRICKS)
                .stairs(BFBlocks.COIR_BRICK_STAIRS)
                .slab(BFBlocks.COIR_BRICK_SLAB)
                .wall(BFBlocks.COIR_BRICK_WALL)
                .recipeUnlockedBy("has_coir_bricks")
                .getFamily();
        generateRecipes(exporter, coirBricksFamily, FeatureFlagSet.of(FeatureFlags.VANILLA));
        carpet(exporter, BFBlocks.COIR_CARPET, BFBlocks.PACKED_COCONUT_COIR);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BFBlocks.COCONUT_CANDLE, 1)
                .define('S', Items.STRING)
                .define('H', Items.HONEYCOMB)
                .define('#', BFItemTags.C_COCONUT_HALVES)
                .pattern("S")
                .pattern("H")
                .pattern("#")
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .unlockedBy("has_coconut", has(BFItemTags.C_COCONUT_HALVES))
                .save(exporter);

        woodFromLogs(exporter, BFBlocks.HOARY_WOOD, BFBlocks.HOARY_LOG);
        woodFromLogs(exporter, BFBlocks.STRIPPED_HOARY_WOOD, BFBlocks.STRIPPED_HOARY_LOG);
        woodFromLogs(exporter, BFBlocks.WALNUT_WOOD, BFBlocks.WALNUT_LOG);
        woodFromLogs(exporter, BFBlocks.STRIPPED_WALNUT_WOOD, BFBlocks.STRIPPED_WALNUT_LOG);
        woodenBoat(exporter, BFItems.HOARY_BOAT, BFBlocks.HOARY_PLANKS);
        woodenBoat(exporter, BFItems.WALNUT_BOAT, BFBlocks.WALNUT_PLANKS);
        chestBoat(exporter, BFItems.HOARY_CHEST_BOAT, BFItems.HOARY_BOAT);
        chestBoat(exporter, BFItems.WALNUT_CHEST_BOAT, BFItems.WALNUT_BOAT);

        offerPicketsRecipe(exporter, BFBlocks.OAK_PICKETS, Items.OAK_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.SPRUCE_PICKETS, Items.SPRUCE_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.BIRCH_PICKETS, Items.BIRCH_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.JUNGLE_PICKETS, Items.JUNGLE_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.ACACIA_PICKETS, Items.ACACIA_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.DARK_OAK_PICKETS, Items.DARK_OAK_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.MANGROVE_PICKETS, Items.MANGROVE_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.CHERRY_PICKETS, Items.CHERRY_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.BAMBOO_PICKETS, Items.BAMBOO_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.WALNUT_PICKETS, BFBlocks.WALNUT_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.HOARY_PICKETS, BFBlocks.HOARY_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.CRIMSON_PICKETS, Items.CRIMSON_PLANKS);
        offerPicketsRecipe(exporter, BFBlocks.WARPED_PICKETS, Items.WARPED_PLANKS);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BFBlocks.IRON_RAILING, 8)
                .define('#', Items.IRON_INGOT)
                .define('S', Items.IRON_NUGGET)
                .pattern("#S#")
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(exporter);



        oneToOneConversionRecipe(exporter, BFItems.MAIZE_SEEDS, BFItems.MAIZE, null, 2);
        oneToOneConversionRecipe(exporter, BFItems.SPONGEKIN_SEEDS, BFItems.SPONGEKIN_SLICE, null, 1);
        oneToOneConversionRecipe(exporter, Items.GREEN_DYE, BFItems.TEA_LEAVES, "green_dye", 1);
        oneToOneConversionRecipe(exporter, Items.BLACK_DYE, BFItems.DRIED_TEA_LEAVES, "black_dye", 1);
        oneToOneConversionRecipe(exporter, Items.LIGHT_GRAY_DYE, BFBlocks.CHAMOMILE_FLOWERS, "light_gray_dye", 1);
        oneToOneConversionRecipe(exporter, Items.YELLOW_DYE, BFBlocks.HONEYSUCKLE, "yellow_dye", 1);
        oneToOneConversionRecipe(exporter, Items.PURPLE_DYE, BFBlocks.VIOLET_BELLFLOWER, "purple_dye", 1);

        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.FOOD, BFBlocks.GOLDEN_APPLE_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, Items.APPLE, RecipeCategory.FOOD, BFBlocks.APPLE_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, BFItems.ORANGE, RecipeCategory.FOOD, BFBlocks.ORANGE_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, BFItems.LEMON, RecipeCategory.FOOD, BFBlocks.LEMON_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, BFItems.PLUM, RecipeCategory.FOOD, BFBlocks.PLUM_BLOCK);
        nineBlockStorageRecipes(exporter, RecipeCategory.FOOD, BFItems.HOARY_APPLE, RecipeCategory.FOOD, BFBlocks.HOARY_APPLE_BLOCK);
        offerTeaRecipes(exporter, BFItems.GREEN_TEA_BOTTLE, BFBlocks.GREEN_TEA_CANDLE, BFItems.GREEN_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.BLACK_TEA_BOTTLE, BFBlocks.BLACK_TEA_CANDLE, BFItems.BLACK_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.CHAMOMILE_TEA_BOTTLE, BFBlocks.CHAMOMILE_CANDLE, BFItems.CHAMOMILE_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.HONEYSUCKLE_TEA_BOTTLE, BFBlocks.HONEYSUCKLE_CANDLE, BFItems.HONEYSUCKLE_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.BELLFLOWER_TEA_BOTTLE, BFBlocks.BELLFLOWER_CANDLE, BFItems.BELLFLOWER_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.TORCHFLOWER_TEA_BOTTLE, BFBlocks.TORCHFLOWER_CANDLE, BFItems.TORCHFLOWER_TEA_BLEND);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, BFBlocks.WALNUT_CANDLE, 1)
                .define('S', Items.STRING)
                .define('H', Items.HONEYCOMB)
                .define('#', BFItemTags.C_WALNUTS)
                .pattern("S")
                .pattern("H")
                .pattern("#")
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .unlockedBy(getHasName(BFItems.WALNUT), has(BFItemTags.C_WALNUTS))
                .save(exporter);
        threeByThreePacker(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.SPONGEKIN, BFItems.SPONGEKIN_SLICE);
        offerCompoteJarRecipe(exporter, BFItems.APPLE_COMPOTE_JAR, Items.APPLE);
        offerCompoteJarRecipe(exporter, BFItems.ORANGE_COMPOTE_JAR, BFItemTags.C_ORANGES, BFItems.ORANGE);
        offerCompoteJarRecipe(exporter, BFItems.LEMON_COMPOTE_JAR, BFItemTags.C_LEMONS, BFItems.LEMON);
        offerCompoteJarRecipe(exporter, BFItems.PLUM_COMPOTE_JAR, BFItemTags.C_PLUMS, BFItems.PLUM);
        offerCompoteJarRecipe(exporter, BFItems.HOARY_COMPOTE_JAR, BFItems.HOARY_APPLE);
        offerCandyRecipe(exporter, BFItems.CANDY, Items.HONEY_BOTTLE);
        offerCandyRecipe(exporter, BFItems.PIQUANT_CANDY, Items.SWEET_BERRIES);
        offerCandyRecipe(exporter, BFItems.SOUR_CANDY, BFItems.CITRUS_ESSENCE);
        offerCandyRecipe(exporter, BFItems.BITTER_CANDY, BFItemTags.C_ELDERBERRIES, BFItems.ELDERBERRIES);
        offerCandyRecipe(exporter, BFItems.STRANGE_CANDY, BFItems.LAPISBERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.PASSION_FRUIT_TART, BFItemTags.C_PASSION_FRUIT, BFItems.PASSION_FRUIT);
        offerTartAndPieRecipe(exporter, BFBlocks.ELDERBERRY_TART, BFItemTags.C_ELDERBERRIES, BFItems.ELDERBERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.GLOW_BERRY_TART, Items.GLOW_BERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.LAPISBERRY_TART, BFItems.LAPISBERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.SWEET_BERRY_TART, Items.SWEET_BERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.APPLE_PIE, Items.APPLE);
        offerTartAndPieRecipe(exporter, BFBlocks.ORANGE_PIE, BFItemTags.C_ORANGES, BFItems.ORANGE);
        offerTartAndPieRecipe(exporter, BFBlocks.LEMON_PIE, BFItemTags.C_LEMONS, BFItems.LEMON);
        offerTartAndPieRecipe(exporter, BFBlocks.PLUM_PIE, BFItemTags.C_PLUMS, BFItems.PLUM);
        offerTartAndPieRecipe(exporter, BFBlocks.HOARY_PIE, BFItems.HOARY_APPLE);
        offerTartAndPieRecipe(exporter, BFBlocks.MELON_PIE, Items.MELON_SLICE);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BLOCK)
                .pattern("##")
                .pattern("##")
                .define('#', BFItems.FELDSPAR)
                .unlockedBy(getHasName(BFItems.FELDSPAR), has(BFItems.FELDSPAR))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BFItems.FELDSPAR, 4)
                .requires(BFBlocks.FELDSPAR_BLOCK)
                .unlockedBy(getHasName(BFBlocks.FELDSPAR_BLOCK), has(BFBlocks.FELDSPAR_BLOCK))
                .save(exporter);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, BFItems.CERAMIC_CLAY, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_CLAY_BLOCK, "ceramic_clay_block", null, "ceramic_clay_from_block", "ceramic_clay");
        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILES, BFItems.CERAMIC_TILE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_PILLAR, 2)
                .pattern("#")
                .pattern("#")
                .define('#', BFBlocks.CERAMIC_TILES)
                .unlockedBy(getHasName(BFBlocks.CERAMIC_TILES), has(BFBlocks.CERAMIC_TILES))
                .save(exporter);
        twoByTwoPacker(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC, BFBlocks.CERAMIC_TILES);


        offerJackOStrawRecipes(exporter, BFBlocks.WHITE_JACK_O_STRAW, Items.WHITE_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.LIGHT_GRAY_JACK_O_STRAW, Items.LIGHT_GRAY_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.GRAY_JACK_O_STRAW, Items.GRAY_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.BLACK_JACK_O_STRAW, Items.BLACK_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.BROWN_JACK_O_STRAW, Items.BROWN_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.RED_JACK_O_STRAW, Items.RED_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.ORANGE_JACK_O_STRAW, Items.ORANGE_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.YELLOW_JACK_O_STRAW, Items.YELLOW_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.LIME_JACK_O_STRAW, Items.LIME_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.GREEN_JACK_O_STRAW, Items.GREEN_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.CYAN_JACK_O_STRAW, Items.CYAN_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.LIGHT_BLUE_JACK_O_STRAW, Items.LIGHT_BLUE_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.BLUE_JACK_O_STRAW, Items.BLUE_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.PURPLE_JACK_O_STRAW, Items.PURPLE_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.MAGENTA_JACK_O_STRAW, Items.MAGENTA_WOOL);
        offerJackOStrawRecipes(exporter, BFBlocks.PINK_JACK_O_STRAW, Items.PINK_WOOL);

        offerMillingRecipe(exporter, Items.WHEAT, BFItems.FLOUR, 2);
        offerMillingRecipe(exporter, BFItems.MAIZE, BFItems.FLOUR, 2);
        offerMillingRecipe(exporter, Items.GRANITE, BFItems.FELDSPAR, 2);
        offerMillingRecipe(exporter, Items.ANDESITE, BFItems.FELDSPAR, 2);
        offerMillingRecipe(exporter, Items.DIORITE, BFItems.FELDSPAR, 2);
        offerMillingRecipe(exporter, Items.TUFF, BFItems.FELDSPAR, 2);
        offerMillingRecipe(exporter, BFItems.COCONUT, BFItems.COCONUT_COIR, 2);
        offerMillingRecipe(exporter, BFItems.WALNUT, BFBlocks.WALNUT_MULCH, 1);
        offerMillingRecipe(exporter, BFItems.PALM_FROND, BFBlocks.PALM_MULCH, 1);
        offerMillingRecipe(exporter, Items.BONE, Items.BONE_MEAL, 4);
        offerMillingRecipe(exporter, Items.COAL_ORE, Items.COAL, 2);
        offerMillingRecipe(exporter, Items.SUGAR_CANE, Items.SUGAR, 2);
        offerMillingRecipe(exporter, Items.AMETHYST_BLOCK, Items.AMETHYST_SHARD, 2);
        offerMillingRecipe(exporter, Items.DEEPSLATE_COAL_ORE, Items.COAL, 2);
        offerMillingRecipe(exporter, Items.IRON_ORE, Items.RAW_IRON, 2);
        offerMillingRecipe(exporter, Items.DEEPSLATE_IRON_ORE, Items.RAW_IRON, 2);
        offerMillingRecipe(exporter, Items.COPPER_ORE, Items.RAW_COPPER, 5);
        offerMillingRecipe(exporter, Items.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER, 5);
        offerMillingRecipe(exporter, Items.REDSTONE_ORE, Items.REDSTONE, 6);
        offerMillingRecipe(exporter, Items.DEEPSLATE_REDSTONE_ORE, Items.REDSTONE, 6);
        offerMillingRecipe(exporter, Items.LAPIS_ORE, Items.LAPIS_LAZULI, 6);
        offerMillingRecipe(exporter, Items.DEEPSLATE_LAPIS_ORE, Items.LAPIS_LAZULI, 6);
        offerMillingRecipe(exporter, Items.GOLD_ORE, Items.RAW_GOLD, 2);
        offerMillingRecipe(exporter, Items.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD, 2);
        offerMillingRecipe(exporter, Items.DIAMOND_ORE, Items.DIAMOND, 2);
        offerMillingRecipe(exporter, Items.DEEPSLATE_DIAMOND_ORE, Items.DIAMOND, 2);
        offerMillingRecipe(exporter, Items.EMERALD_ORE, Items.EMERALD, 3);
        offerMillingRecipe(exporter, Items.DEEPSLATE_EMERALD_ORE, Items.EMERALD, 3);
        offerMillingRecipe(exporter, Items.NETHER_QUARTZ_ORE, Items.QUARTZ, 4);
        offerMillingRecipe(exporter, Items.NETHER_GOLD_ORE, Items.GOLD_NUGGET, 8);
        offerMillingRecipe(exporter, BFItems.TEA_LEAVES, BFItems.GREEN_TEA_BLEND, 1);
        offerMillingRecipe(exporter, BFItems.DRIED_TEA_LEAVES, BFItems.BLACK_TEA_BLEND, 1);
        offerMillingRecipe(exporter, BFBlocks.CHAMOMILE_FLOWERS, BFItems.CHAMOMILE_TEA_BLEND, 2);
        offerMillingRecipe(exporter, BFBlocks.HONEYSUCKLE, BFItems.HONEYSUCKLE_TEA_BLEND, 2);
        offerMillingRecipe(exporter, BFBlocks.VIOLET_BELLFLOWER, BFItems.BELLFLOWER_TEA_BLEND, 2);
        offerMillingRecipe(exporter, Items.TORCHFLOWER, BFItems.TORCHFLOWER_TEA_BLEND, 2);

        offerFermentingRecipe(exporter, Items.APPLE, BFItems.APPLE_CIDER_JAR, 1, 16771237);
        offerFermentingRecipe(exporter, BFItems.ORANGE, BFItems.CITRUS_ESSENCE, 2, 15200149);
        offerFermentingRecipe(exporter, BFItems.LEMON, BFItems.CITRUS_ESSENCE, 2, 15200149);
        offerFermentingRecipe(exporter, BFItems.ELDERBERRIES, BFItems.ELDERBERRY_WINE_BOTTLE, 1, 13803457);
        offerFermentingRecipe(exporter, Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE, 1, 10250865);
        offerFermentingRecipe(exporter, BFItems.HOARY_APPLE, BFItems.HOARY_CIDER_JAR, 1, 15714738);
        offerFermentingRecipe(exporter, BFItems.LAPISBERRIES, BFItems.LAPISBERRY_WINE_BOTTLE, 1, 6449890);
        offerFermentingRecipe(exporter, Items.HONEY_BOTTLE, BFItems.MEAD_BOTTLE, 1, 16774088);
        offerFermentingRecipe(exporter, BFItems.SPONGEKIN_SLICE, BFItems.PICKLED_SPONGEKIN, 2, 3916203);
        offerFermentingRecipe(exporter, BFItems.PLUM, BFItems.PLUM_CIDER_JAR, 1, 14532546);
        offerFermentingRecipe(exporter, BFItems.COCONUT_HALF, BFItems.COCONUT_MILK_BOTTLE, 1, 13747902);
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

        polished(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CUT_FELDSPAR_BLOCK, BFBlocks.FELDSPAR_BLOCK);
        polished(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICKS, BFBlocks.CUT_FELDSPAR_BLOCK);
        BlockFamily feldsparBricksFamily = familyBuilder(BFBlocks.FELDSPAR_BRICKS)
                .stairs(BFBlocks.FELDSPAR_BRICK_STAIRS)
                .slab(BFBlocks.FELDSPAR_BRICK_SLAB)
                .wall(BFBlocks.FELDSPAR_BRICK_WALL)
                .recipeUnlockedBy("has_feldspar_bricks")
                .getFamily();
        generateRecipes(exporter, feldsparBricksFamily, FeatureFlagSet.of(FeatureFlags.VANILLA));

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CUT_FELDSPAR_BLOCK, BFBlocks.FELDSPAR_BLOCK, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICKS, BFBlocks.FELDSPAR_BLOCK, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_STAIRS, BFBlocks.FELDSPAR_BLOCK, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_SLAB, BFBlocks.FELDSPAR_BLOCK, 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_WALL, BFBlocks.FELDSPAR_BLOCK, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICKS, BFBlocks.CUT_FELDSPAR_BLOCK, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_STAIRS, BFBlocks.CUT_FELDSPAR_BLOCK, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_SLAB, BFBlocks.CUT_FELDSPAR_BLOCK, 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_WALL, BFBlocks.CUT_FELDSPAR_BLOCK, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_STAIRS, BFBlocks.FELDSPAR_BRICKS, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_SLAB, BFBlocks.FELDSPAR_BRICKS, 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_WALL, BFBlocks.FELDSPAR_BRICKS, 1);

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_STAIRS, BFBlocks.CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILES, 2);
        //offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_WALL, BFBlocks.CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS, BFBlocks.CHECKERED_CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_TILE_SLAB, BFBlocks.CHECKERED_CERAMIC_TILES, 2);
        //offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_TILE_WALL, BFBlocks.CHECKERED_CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_PILLAR, BFBlocks.CERAMIC_TILES, 1);

        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC, BFBlocks.CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_STAIRS, BFBlocks.CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_TILES, 2);
        //offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_WALL, BFBlocks.CERAMIC_TILES, 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_STAIRS, BFBlocks.CERAMIC_MOSAIC, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC, 2);
        //offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_WALL, BFBlocks.CERAMIC_MOSAIC, 2);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_MOSAIC, BFBlocks.CHECKERED_CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS, BFBlocks.CHECKERED_CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB, BFBlocks.CHECKERED_CERAMIC_TILES, 2);
        //offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL, BFBlocks.CHECKERED_CERAMIC_TILES, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS, BFBlocks.CHECKERED_CERAMIC_MOSAIC, 1);
        stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB, BFBlocks.CHECKERED_CERAMIC_MOSAIC, 2);
        //offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL, BFBlocks.CHECKERED_CERAMIC_MOSAIC, 1);

        oreSmelting(exporter, ImmutableList.of(BFItems.CERAMIC_CLAY), RecipeCategory.MISC, BFItems.CERAMIC_TILE, 0.3f, 200, "ceramic_tile");
        oreSmelting(exporter, ImmutableList.of(BFItems.TEA_LEAVES), RecipeCategory.FOOD, BFItems.DRIED_TEA_LEAVES, 0.3f, 200, "dried_tea_leaves");
        oreCooking(exporter, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, ImmutableList.of(BFItems.TEA_LEAVES), RecipeCategory.FOOD, BFItems.DRIED_TEA_LEAVES, 0.2f, 100, "dried_tea_leaves", "_from_smoking");
        oreCooking(exporter, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, ImmutableList.of(BFItems.TEA_LEAVES), RecipeCategory.FOOD, BFItems.DRIED_TEA_LEAVES, 0.2f, 600, "dried_tea_leaves", "_from_campfire_cooking");
        oreSmelting(exporter, ImmutableList.of(BFBlocks.CERAMIC_TILES), RecipeCategory.FOOD, BFBlocks.CRACKED_CERAMIC_TILES, 0.3f, 200, "cracked_ceramic_tiles");


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BFItems.ARTISAN_BRUSH)
                .pattern("FFF")
                .pattern(" G ")
                .pattern(" S ")
                .define('F', Items.STRING)
                .define('G', Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(BFBlocks.CERAMIC_TILES), has(BFItemTags.DYEABLE_CERAMIC_BLOCKS))
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.DIORITE)
                .pattern("CF")
                .pattern("FC")
                .define('C', Items.COBBLESTONE)
                .define('F', BFItems.FELDSPAR)
                .unlockedBy(getHasName(BFItems.FELDSPAR), has(BFItems.FELDSPAR))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.GRANITE)
                .requires(Items.DIORITE)
                .requires(BFItems.FELDSPAR)
                .unlockedBy(getHasName(BFItems.FELDSPAR), has(BFItems.FELDSPAR))
                .save(exporter);

        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILE_STAIRS);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILE_SLAB);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CRACKED_CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_TILES, BFBlocks.CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS, BFBlocks.CERAMIC_TILE_STAIRS);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILE_SLAB);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES, BFBlocks.CRACKED_CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILE_PILLAR);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_MOSAIC);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_MOSAIC_STAIRS);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_MOSAIC_SLAB);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_MOSAIC, BFBlocks.CERAMIC_MOSAIC);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS, BFBlocks.CERAMIC_MOSAIC_STAIRS);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC_SLAB);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_PRESSURE_PLATE);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_BUTTON);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_DISH);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_DOOR);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TRAPDOOR);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_LEVER);
        //offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_MOSAIC_WALL);
        //offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILE_WALL);
        //offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL, BFBlocks.CERAMIC_MOSAIC_WALL);
        //offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_TILE_WALL, BFBlocks.CERAMIC_TILE_WALL);
        offerCeramicUndyingRecipe(exporter, BFItems.ARTISAN_BRUSH);

        hangingSign(exporter, BFItems.HOARY_HANGING_SIGN, BFBlocks.STRIPPED_HOARY_LOG);
        hangingSign(exporter, BFItems.WALNUT_HANGING_SIGN, BFBlocks.STRIPPED_WALNUT_LOG);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BFBlocks.GRASSY_DIRT)
                .requires(BFItems.GRASS_SEEDS)
                .requires(BFItemTags.GRASS_SEEDS_PLANTABLE_ON)
                .unlockedBy(getHasName(BFItems.GRASS_SEEDS), has(BFItems.GRASS_SEEDS))
                .save(exporter);

    }







    public static void offerCandiedFruitRecipe(RecipeOutput exporter, ItemLike input, ItemLike output, int count) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output, count)
                .requires(input)
                .requires(BFItemTags.SUGAR_INGREDIENTS)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter);
    }

    public static void offerCandiedFruitRecipe(RecipeOutput exporter, ItemLike input, TagKey<Item> tag, ItemLike output, int count) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output, count)
                .requires(tag)
                .requires(BFItemTags.SUGAR_INGREDIENTS)
                .unlockedBy(getHasName(input), has(tag))
                .save(exporter);
    }

    public static void offerCeramicUndyingRecipe(RecipeOutput exporter, ItemLike item) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item, 1).requires(item)
                .unlockedBy("has_item", has(item)).save(exporter, getDefaultRecipeId(item) + "_undying");
    }

    public static void offerCeramicUndyingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, 1).requires(input)
                .unlockedBy("has_item", has(input)).save(exporter, getDefaultRecipeId(input) + "_undying");
    }

    public static void offerPicketsRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', input).define('S', Items.STICK)
                .pattern("#S#").unlockedBy("has_planks", has(input)).save(exporter);
    }

    public static void offerPicketsRecipe(RecipeOutput exporter, ItemLike output, ResourceLocation input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 4).define('#', BuiltInRegistries.ITEM.get(input)).define('S', Items.STICK)
                .pattern("#S#").unlockedBy("has_planks", has(BuiltInRegistries.ITEM.get(input))).save(exporter);
    }
    public static void offerTeaRecipes(RecipeOutput exporter, ItemLike teaBottle, ItemLike teaCandle, ItemLike teaBlendItem) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, teaBottle)
                .requires(teaBlendItem, 1)
                .requires(Items.POTION)
                .unlockedBy(getHasName(teaBlendItem), has(teaBlendItem))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, teaCandle, 1)
                .define('S', Items.STRING)
                .define('H', Items.HONEYCOMB)
                .define('#', teaBlendItem)
                .pattern("S")
                .pattern("H")
                .pattern("#")
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .unlockedBy("has_tea_blend", has(teaBlendItem))
                .save(exporter);


    }
    public static void offerCompoteJarRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output)
                .requires(input, 2)
                .requires(BFItems.CITRUS_ESSENCE)
                .requires(BFItems.JAR)
                .unlockedBy(getHasName(BFItems.JAR), has(BFItems.JAR))
                .unlockedBy(getHasName(input), has(input))
                .save(exporter);
    }
    public static void offerCompoteJarRecipe(RecipeOutput exporter, ItemLike output, TagKey<Item> tag, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output)
                .requires(tag)
                .requires(tag)
                .requires(BFItems.CITRUS_ESSENCE)
                .requires(BFItems.JAR)
                .unlockedBy(getHasName(BFItems.JAR), has(BFItems.JAR))
                .unlockedBy(getHasName(input), has(tag))
                .save(exporter);
    }
    public static void offerCandyRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output)
                .requires(input)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(input), has(input))
                .save(exporter);
    }
    public static void offerCandyRecipe(RecipeOutput exporter, ItemLike output, TagKey<Item> tag, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output)
                .requires(tag)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .unlockedBy(getHasName(input), has(tag))
                .save(exporter);
    }
    public static void offerJackOStrawRecipes(RecipeOutput exporter, ItemLike output, ItemLike wool) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
                .requires(BFItems.SUN_HAT)
                .requires(Items.CARVED_PUMPKIN)
                .requires(wool)
                .requires(Items.STICK)
                .unlockedBy(getHasName(wool), has(wool))
                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                .unlockedBy(getHasName(BFItems.SUN_HAT), has(BFItems.SUN_HAT))
                .unlockedBy("has_wool", has(wool))
                .save(exporter, getDefaultRecipeId(output) + "_with_carved_pumpkin");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
                .requires(BFItems.SUN_HAT)
                .requires(Items.PUMPKIN)
                .requires(wool)
                .requires(Items.STICK)
                .unlockedBy(getHasName(wool), has(wool))
                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                .unlockedBy(getHasName(BFItems.SUN_HAT), has(BFItems.SUN_HAT))
                .unlockedBy("has_wool", has(wool))
                .save(exporter, getDefaultRecipeId(output) + "_with_pumpkin");
    }
    public static void offerJackOStrawRecipes(RecipeOutput exporter, ItemLike output, ItemLike wool, String specifier) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
                .requires(BFItems.SUN_HAT)
                .requires(Items.CARVED_PUMPKIN)
                .requires(wool)
                .requires(Items.STICK)
                .unlockedBy(getHasName(wool), has(wool))
                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                .unlockedBy(getHasName(BFItems.SUN_HAT), has(BFItems.SUN_HAT))
                .unlockedBy("has_wool", has(wool))
                .save(exporter, getDefaultRecipeId(output) + "_with_carved_pumpkin_" + specifier);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, output)
                .requires(BFItems.SUN_HAT)
                .requires(Items.PUMPKIN)
                .requires(wool)
                .requires(Items.STICK)
                .unlockedBy(getHasName(wool), has(wool))
                .unlockedBy(getHasName(Items.CARVED_PUMPKIN), has(Items.CARVED_PUMPKIN))
                .unlockedBy(getHasName(BFItems.SUN_HAT), has(BFItems.SUN_HAT))
                .unlockedBy("has_wool", has(wool))
                .save(exporter, getDefaultRecipeId(output) + "_with_pumpkin_" + specifier);
    }
    public static void offerTartAndPieRecipe(RecipeOutput exporter, ItemLike output, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output)
                .requires(input)
                .requires(BFItemTags.C_FLOUR)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(BFItems.FLOUR), has(BFItemTags.C_FLOUR))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(input), has(input))
                .save(exporter);
    }

    public static void offerTartAndPieRecipe(RecipeOutput exporter, ItemLike output, TagKey<Item> tag, ItemLike input) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output)
                .requires(tag)
                .requires(BFItemTags.C_FLOUR)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(BFItems.FLOUR), has(BFItemTags.C_FLOUR))
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .unlockedBy(getHasName(input), has(tag))
                .save(exporter);
    }

    public static void offerMillingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output, int count) {
        MillingRecipeBuilder.create(input.asItem(), output, count)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter);
    }

    public static void offerFermentingRecipe(RecipeOutput exporter, ItemLike input, ItemLike output, int count, int particleColor) {
        FermentingRecipeBuilder.create(input.asItem(), output, count, particleColor)
                .unlockedBy(getHasName(input), has(input))
                .save(exporter);
    }
}
