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
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.family.BlockFamilies.register;
import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

public class BFRecipeProvider extends FabricRecipeProvider {

    public BFRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BFBlocks.GRISTMILL)
                .pattern("IP")
                .pattern("BB")
                .input('I', Items.IRON_INGOT)
                .input('P', ItemTags.PLANKS)
                .input('B', Items.BRICK)
                .criterion("has_plank", conditionsFromTag(ItemTags.PLANKS))
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, BFItems.SUN_HAT)
                .pattern("###")
                .pattern("# #")
                .input('#', Items.WHEAT)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter);

        offerSingleOutputShapelessRecipe(exporter, BFItems.SWEET_BERRY_PIPS, Items.SWEET_BERRIES, "sweet_berry_seeds");

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




        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BFBlocks.FELDSPAR_LANTERN)
                .pattern("III")
                .pattern("FTF")
                .pattern("III")
                .input('I', Items.IRON_NUGGET)
                .input('F', BFItems.FELDSPAR)
                .input('T', Items.TORCH)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(BFItems.FELDSPAR), conditionsFromItem(BFItems.FELDSPAR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BFBlocks.TINGED_GLASS)
                .pattern(" F ")
                .pattern("FGF")
                .pattern(" F ")
                .input('F', BFItems.FELDSPAR)
                .input('G', Items.GLASS)
                .criterion(hasItem(BFItems.FELDSPAR), conditionsFromItem(BFItems.FELDSPAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BFItems.CERAMIC_CLAY, 4)
                .input(Items.CLAY_BALL, 3)
                .input(BFItems.FELDSPAR)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .criterion(hasItem(BFItems.FELDSPAR), conditionsFromItem(BFItems.FELDSPAR))
                .group("ceramic_clay")
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BFBlocks.CERAMIC_BUTTON)
                .input(BFItems.CERAMIC_TILE, 1)
                .criterion(hasItem(BFItems.CERAMIC_TILE), conditionsFromItem(BFItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BFBlocks.CERAMIC_PRESSURE_PLATE)
                .pattern("##")
                .input('#', BFItems.CERAMIC_TILE)
                .criterion(hasItem(BFItems.CERAMIC_TILE), conditionsFromItem(BFItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BFBlocks.CERAMIC_DISH)
                .pattern("###")
                .input('#', BFItems.CERAMIC_TILE)
                .criterion(hasItem(BFItems.CERAMIC_TILE), conditionsFromItem(BFItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BFBlocks.CERAMIC_LEVER)
                .pattern(" S ")
                .pattern("###")
                .input('S', Items.STICK)
                .input('#', BFItems.CERAMIC_TILE)
                .criterion(hasItem(BFItems.CERAMIC_TILE), conditionsFromItem(BFItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.JAR, 3)
                .pattern("# #")
                .pattern(" # ")
                .input('#', BFItems.CERAMIC_CLAY)
                .criterion(hasItem(BFItems.CERAMIC_CLAY), conditionsFromItem(BFItems.CERAMIC_CLAY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BFBlocks.FERMENTATION_VESSEL)
                .pattern(" # ")
                .pattern("# #")
                .pattern("###")
                .input('#', BFItems.CERAMIC_CLAY)
                .criterion(hasItem(BFItems.CERAMIC_CLAY), conditionsFromItem(BFItems.CERAMIC_CLAY))
                .offerTo(exporter);

        BlockFamily hoaryFamily = register(BFBlocks.HOARY_PLANKS)
                .button(BFBlocks.HOARY_BUTTON)
                .fence(BFBlocks.HOARY_FENCE)
                .fenceGate(BFBlocks.HOARY_FENCE_GATE)
                .pressurePlate(BFBlocks.HOARY_PRESSURE_PLATE)
                .sign(BFBlocks.HOARY_SIGN, BFBlocks.HOARY_WALL_SIGN)
                .slab(BFBlocks.HOARY_SLAB)
                .stairs(BFBlocks.HOARY_STAIRS)
                .door(BFBlocks.HOARY_DOOR)
                .trapdoor(BFBlocks.HOARY_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        generateFamily(exporter, hoaryFamily, FeatureSet.of(FeatureFlags.VANILLA));
        offerPlanksRecipe(exporter, BFBlocks.HOARY_PLANKS, BFItemTags.HOARY_LOGS, 4);


        BlockFamily walnutFamily = register(BFBlocks.WALNUT_PLANKS)
                .button(BFBlocks.WALNUT_BUTTON)
                .fence(BFBlocks.WALNUT_FENCE)
                .fenceGate(BFBlocks.WALNUT_FENCE_GATE)
                .pressurePlate(BFBlocks.WALNUT_PRESSURE_PLATE)
                .sign(BFBlocks.WALNUT_SIGN, BFBlocks.WALNUT_WALL_SIGN)
                .slab(BFBlocks.WALNUT_SLAB)
                .stairs(BFBlocks.WALNUT_STAIRS)
                .door(BFBlocks.WALNUT_DOOR)
                .trapdoor(BFBlocks.WALNUT_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        generateFamily(exporter, walnutFamily, FeatureSet.of(FeatureFlags.VANILLA));
        offerPlanksRecipe(exporter, BFBlocks.WALNUT_PLANKS, BFItemTags.WALNUT_LOGS, 4);

        BlockFamily ceramicFamily = register(BFBlocks.CERAMIC_TILES)
                .slab(BFBlocks.CERAMIC_TILE_SLAB)
                .stairs(BFBlocks.CERAMIC_TILE_STAIRS)
                .group("ceramic_tiles")
                .unlockCriterionName("has_ceramic_tiles")
                .build();
        generateFamily(exporter, ceramicFamily, FeatureSet.of(FeatureFlags.VANILLA));

//        BlockFamily checkeredCeramicFamily = register(ModBlocks.CHECKERED_CERAMIC_TILES)
//                .slab(ModBlocks.CERAMIC_TILE_SLAB)
//                .stairs(ModBlocks.CERAMIC_TILE_STAIRS)
//                .group("checkered_ceramic_tiles")
//                .unlockCriterionName("has_checkered_ceramic_tiles")
//                .build();
//        generateFamily(exporter, checkeredCeramicFamily);

        BlockFamily ceramicMosaicFamily = register(BFBlocks.CERAMIC_MOSAIC)
                .slab(BFBlocks.CERAMIC_MOSAIC_SLAB)
                .stairs(BFBlocks.CERAMIC_MOSAIC_STAIRS)
                .group("ceramic_mosaic")
                .unlockCriterionName("has_ceramic_mosaic")
                .build();
        generateFamily(exporter, ceramicMosaicFamily, FeatureSet.of(FeatureFlags.VANILLA));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BFBlocks.CERAMIC_DOOR)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .input('#', BFItems.CERAMIC_TILE)
                .criterion(hasItem(BFItems.CERAMIC_TILE), conditionsFromItem(BFItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BFBlocks.CERAMIC_TRAPDOOR)
                .pattern("###")
                .pattern("###")
                .input('#', BFItems.CERAMIC_TILE)
                .criterion(hasItem(BFItems.CERAMIC_TILE), conditionsFromItem(BFItems.CERAMIC_TILE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFBlocks.ARTISAN_BREAD)
                .input(BFItemTags.C_FLOUR)
                .input(BFItemTags.C_FLOUR)
                .input(BFItemTags.C_FLOUR)
                .input(Items.EGG)
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(BFItems.FLOUR), conditionsFromTag(BFItemTags.C_FLOUR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.ARTISAN_COOKIE, 4)
                .input(BFItemTags.C_FLOUR)
                .input(BFItems.ELDERBERRIES)
                .input(Items.SUGAR)
                .criterion(hasItem(BFItems.ELDERBERRIES), conditionsFromItem(BFItems.ELDERBERRIES))
                .criterion(hasItem(BFItems.FLOUR), conditionsFromTag(BFItemTags.C_FLOUR))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BFBlocks.COCOA_CAKE)
                .pattern("MMM")
                .pattern("CEC")
                .pattern("FFF")
                .input('M', BFItemTags.C_MILKS)
                .input('E', Items.EGG)
                .input('F', BFItemTags.C_FLOUR)
                .input('C', Items.COCOA_BEANS)
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(BFItems.FLOUR), conditionsFromTag(BFItemTags.C_FLOUR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BFBlocks.COCONUT_CAKE)
                .pattern("CCC")
                .pattern("SES")
                .pattern("FFF")
                .input('C', BFItemTags.C_COCONUT_HALVES)
                .input('E', Items.EGG)
                .input('F', BFItemTags.C_FLOUR)
                .input('S', Items.SUGAR)
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(BFItems.FLOUR), conditionsFromTag(BFItemTags.C_FLOUR))
                .criterion(hasItem(BFItems.COCONUT_HALF), conditionsFromTag(BFItemTags.C_COCONUT_HALVES))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.MAIZE_BREAD)
                .pattern("###")
                .input('#', BFItems.MAIZE)
                .criterion(hasItem(BFItems.MAIZE), conditionsFromItem(BFItems.MAIZE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.WALNUT_COOKIE, 4)
                .pattern("#W#")
                .input('#', BFItemTags.C_FLOUR)
                .input('W', BFItems.WALNUT)
                .criterion(hasItem(BFItems.FLOUR), conditionsFromTag(BFItemTags.C_FLOUR))
                .criterion(hasItem(BFItems.WALNUT), conditionsFromItem(BFItems.WALNUT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.FOREST_MEDLEY)
                .input(Items.COOKED_PORKCHOP)
                .input(Items.CARROT)
                .input(Items.SWEET_BERRIES)
                .input(Items.BREAD)
                .criterion(hasItem(Items.COOKED_PORKCHOP), conditionsFromItem(Items.COOKED_PORKCHOP))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.ARID_MEDLEY)
                .input(Items.CACTUS)
                .input(Items.POTATO)
                .input(BFItems.MAIZE)
                .input(Items.BREAD)
                .criterion(hasItem(Items.CACTUS), conditionsFromItem(Items.CACTUS))
                .criterion(hasItem(Items.POTATO), conditionsFromItem(Items.POTATO))
                .criterion(hasItem(BFItems.MAIZE), conditionsFromItem(BFItems.MAIZE))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.MEADOW_MEDLEY)
                .input(Items.COOKED_MUTTON)
                .input(Items.BEETROOT)
                .input(BFBlocks.VIOLET_BELLFLOWER)
                .input(BFItems.LEEK)
                .criterion(hasItem(Items.COOKED_MUTTON), conditionsFromItem(Items.COOKED_MUTTON))
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .criterion(hasItem(BFBlocks.VIOLET_BELLFLOWER), conditionsFromItem(BFBlocks.VIOLET_BELLFLOWER))
                .criterion(hasItem(BFItems.LEEK), conditionsFromItem(BFItems.LEEK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.MIRE_MEDLEY)
                .input(BFItems.ELDERBERRIES)
                .input(BFItems.MAIZE)
                .input(BFBlocks.CHAMOMILE_FLOWERS)
                .input(Items.CARROT)
                .criterion(hasItem(BFItems.ELDERBERRIES), conditionsFromItem(BFItems.ELDERBERRIES))
                .criterion(hasItem(BFItems.MAIZE), conditionsFromItem(BFItems.MAIZE))
                .criterion(hasItem(BFBlocks.CHAMOMILE_FLOWERS), conditionsFromItem(BFBlocks.CHAMOMILE_FLOWERS))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.COASTAL_MEDLEY)
                .input(BFItems.SPONGEKIN_SLICE)
                .input(Items.DRIED_KELP, 2)
                .input(BFItemTags.COOKED_FISHES)
                .criterion(hasItem(BFItems.SPONGEKIN_SLICE), conditionsFromItem(BFItems.SPONGEKIN_SLICE))
                .criterion(hasItem(Items.DRIED_KELP), conditionsFromItem(Items.DRIED_KELP))
                .criterion("has_fish", conditionsFromTag(BFItemTags.COOKED_FISHES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.TROPICAL_MEDLEY)
                .input(BFItems.ORANGE)
                .input(Items.COCOA_BEANS)
                .input(BFItems.PASSION_FRUIT)
                .input(BFItems.COCONUT_HALF)
                .criterion(hasItem(BFItems.ORANGE), conditionsFromItem(BFItems.ORANGE))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .criterion(hasItem(BFItems.PASSION_FRUIT), conditionsFromItem(BFItems.PASSION_FRUIT))
                .criterion(hasItem(BFItems.COCONUT_HALF), conditionsFromItem(BFItems.COCONUT_HALF))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.STUFFED_HOARY_APPLE)
                .input(BFItems.HOARY_APPLE)
                .input(BFItems.LAPISBERRIES, 2)
                .criterion(hasItem(BFItems.HOARY_APPLE), conditionsFromItem(BFItems.HOARY_APPLE))
                .criterion(hasItem(BFItems.LAPISBERRIES), conditionsFromItem(BFItems.LAPISBERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.SEA_SALAD)
                .input(Items.KELP, 2)
                .input(BFItems.LEEK)
                .input(BFItems.CITRUS_ESSENCE)
                .input(Items.BOWL)
                .criterion(hasItem(Items.KELP), conditionsFromItem(Items.KELP))
                .criterion(hasItem(BFItems.LEEK), conditionsFromItem(BFItems.LEEK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.MUSHROOM_STUFFED_POTATO)
                .input(Items.BAKED_POTATO)
                .input(Items.RED_MUSHROOM)
                .input(Items.BROWN_MUSHROOM)
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .criterion(hasItem(Items.RED_MUSHROOM), conditionsFromItem(Items.RED_MUSHROOM))
                .criterion(hasItem(Items.BROWN_MUSHROOM), conditionsFromItem(Items.BROWN_MUSHROOM))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.BERRY_STUFFED_POTATO)
                .input(Items.BAKED_POTATO)
                .input(Items.SWEET_BERRIES)
                .input(Items.GLOW_BERRIES)
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(hasItem(Items.GLOW_BERRIES), conditionsFromItem(Items.GLOW_BERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.MAIZE_STUFFED_POTATO)
                .input(Items.BAKED_POTATO)
                .input(BFItems.MAIZE)
                .criterion(hasItem(Items.BAKED_POTATO), conditionsFromItem(Items.BAKED_POTATO))
                .criterion(hasItem(BFItems.MAIZE), conditionsFromItem(BFItems.MAIZE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.PASSION_GLAZED_SALMON)
                .input(BFItems.PASSION_FRUIT, 2)
                .input(Items.COOKED_SALMON)
                .input(Items.BOWL)
                .criterion(hasItem(BFItems.PASSION_FRUIT), conditionsFromItem(BFItems.PASSION_FRUIT))
                .criterion(hasItem(Items.COOKED_SALMON), conditionsFromItem(Items.COOKED_SALMON))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.COCONUT_CRUSTED_COD)
                .input(BFItemTags.C_COCONUT_HALVES)
                .input(BFItemTags.C_COCONUT_HALVES)
                .input(Items.COOKED_COD)
                .input(Items.BOWL)
                .criterion(hasItem(BFItems.COCONUT_HALF), conditionsFromTag(BFItemTags.C_COCONUT_HALVES))
                .criterion(hasItem(Items.COOKED_COD), conditionsFromItem(Items.COOKED_COD))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.BOUNTIFUL_STEW)
                .input(Items.COOKED_PORKCHOP)
                .input(Items.CARROT)
                .input(BFItems.MAIZE)
                .input(Items.BOWL)
                .criterion(hasItem(Items.COOKED_PORKCHOP), conditionsFromItem(Items.COOKED_PORKCHOP))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(BFItems.MAIZE), conditionsFromItem(BFItems.MAIZE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.LEEK_STEW)
                .input(BFItems.LEEK, 3)
                .input(Items.BOWL)
                .criterion(hasItem(BFItems.LEEK), conditionsFromItem(BFItems.LEEK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.APPLE_STEW)
                .input(Items.APPLE, 2)
                .input(BFItems.ELDERBERRIES, 2)
                .input(Items.BOWL)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(BFItems.ELDERBERRIES), conditionsFromItem(BFItems.ELDERBERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.COCONUT_STEW)
                .input(BFItemTags.C_COCONUT_HALVES)
                .input(BFItemTags.C_COCONUT_HALVES)
                .input(BFItems.LEEK, 1)
                .input(Items.BOWL)
                .criterion(hasItem(BFItems.COCONUT_HALF), conditionsFromTag(BFItemTags.C_COCONUT_HALVES))
                .criterion(hasItem(BFItems.LEEK), conditionsFromItem(BFItems.LEEK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.STONE_STEW)
                .input(Items.STONE_PICKAXE)
                .input(Items.COBBLESTONE, 2)
                .input(Items.ROTTEN_FLESH, 1)
                .input(Items.BOWL)
                .criterion(hasItem(Items.STONE_PICKAXE), conditionsFromItem(Items.STONE_PICKAXE))
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.FISH_STEW)
                .group("fish_stew")
                .input(Ingredient.fromTag(BFItemTags.COOKED_FISHES), 2)
                .input(Items.DRIED_KELP, 2)
                .input(Items.BOWL)
                .criterion("has_cooked_fish", conditionsFromTag(BFItemTags.COOKED_FISHES))
                .criterion(hasItem(Items.DRIED_KELP), conditionsFromItem(Items.DRIED_KELP))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.CUSTARD)
                .input(BFItemTags.C_MILKS)
                .input(Items.SUGAR)
                .input(Items.BOWL)
                .criterion("has_milk", conditionsFromTag(BFItemTags.C_MILKS))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.PIQUANT_CUSTARD)
                .input(BFItemTags.C_MILKS)
                .input(Items.SUGAR)
                .input(Items.SWEET_BERRIES)
                .input(Items.BOWL)
                .criterion("has_milk", conditionsFromTag(BFItemTags.C_MILKS))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.PASSION_CUSTARD)
                .input(BFItemTags.C_MILKS)
                .input(Items.SUGAR)
                .input(BFItems.PASSION_FRUIT)
                .input(Items.BOWL)
                .criterion("has_milk", conditionsFromTag(BFItemTags.C_MILKS))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(BFItems.PASSION_FRUIT), conditionsFromItem(BFItems.PASSION_FRUIT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.COCOA_CUSTARD)
                .input(BFItemTags.C_MILKS)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .input(BFItems.WALNUT)
                .input(Items.BOWL)
                .criterion("has_milk", conditionsFromTag(BFItemTags.C_MILKS))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .criterion(hasItem(BFItems.WALNUT), conditionsFromItem(BFItems.WALNUT))
                .offerTo(exporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.ANCIENT_CUSTARD)
                .input(BFItemTags.C_MILKS)
                .input(Items.SUGAR)
                .input(BFItems.LAPISBERRIES)
                .input(BFItems.HOARY_APPLE)
                .input(Items.BOWL)
                .criterion("has_milk", conditionsFromTag(BFItemTags.C_MILKS))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(BFItems.HOARY_APPLE), conditionsFromItem(BFItems.HOARY_APPLE))
                .criterion(hasItem(BFItems.LAPISBERRIES), conditionsFromItem(BFItems.LAPISBERRIES))
                .offerTo(exporter);

        offerCandiedFruitRecipe(exporter, Items.APPLE, BFItems.CANDIED_APPLE, 1);
        offerCandiedFruitRecipe(exporter, BFItems.PLUM, BFItems.CANDIED_PLUM, 1);
        offerCandiedFruitRecipe(exporter, BFItems.ORANGE, BFItems.CANDIED_ORANGE, 4);
        offerCandiedFruitRecipe(exporter, BFItems.LEMON, BFItems.CANDIED_LEMON, 4);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.CRUSTED_BEEF)
                .input(Items.COOKED_BEEF)
                .input(BFItems.WALNUT, 2)
                .input(Items.POTATO)
                .input(BFItems.ELDERBERRIES)
                .input(Items.BOWL)
                .criterion(hasItem(Items.COOKED_BEEF), conditionsFromItem(Items.COOKED_BEEF))
                .criterion(hasItem(Items.POTATO), conditionsFromItem(Items.POTATO))
                .criterion(hasItem(BFItems.WALNUT), conditionsFromItem(BFItems.WALNUT))
                .criterion(hasItem(BFItems.ELDERBERRIES), conditionsFromItem(BFItems.ELDERBERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.CRIMSON_CHOW)
                .input(Items.COOKED_PORKCHOP)
                .input(Items.CRIMSON_FUNGUS, 2)
                .input(Items.CRIMSON_ROOTS)
                .input(Items.BOWL)
                .criterion(hasItem(Items.CRIMSON_FUNGUS), conditionsFromItem(Items.CRIMSON_FUNGUS))
                .criterion(hasItem(Items.CRIMSON_ROOTS), conditionsFromItem(Items.CRIMSON_ROOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, BFItems.WARPED_CHOW)
                .input(Items.WARPED_FUNGUS, 2)
                .input(Items.WARPED_ROOTS)
                .input(Items.NETHER_SPROUTS)
                .input(Items.BOWL)
                .criterion(hasItem(Items.WARPED_FUNGUS), conditionsFromItem(Items.WARPED_FUNGUS))
                .criterion(hasItem(Items.WARPED_ROOTS), conditionsFromItem(Items.WARPED_ROOTS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 8)
                        .group("stick")
                        .input(BFItemTags.FRUIT_LOGS)
                        .criterion("has_fruit_log", conditionsFromTag(BFItemTags.FRUIT_LOGS))
                        .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BFBlocks.WALNUT_MULCH, 4)
                .group("walnut_mulch")
                .input(BFBlocks.WALNUT_MULCH_BLOCK)
                .criterion("has_mulch", conditionsFromItem(BFBlocks.WALNUT_MULCH_BLOCK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.RED_DYE)
                .input(BFItems.TEA_BERRIES)
                .criterion(hasItem(BFItems.TEA_BERRIES), conditionsFromItem(BFItems.TEA_BERRIES))
                .offerTo(exporter);

        offerBarkBlockRecipe(exporter, BFBlocks.APPLE_WOOD, BFBlocks.APPLE_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.STRIPPED_APPLE_WOOD, BFBlocks.STRIPPED_APPLE_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.GOLDEN_APPLE_WOOD, BFBlocks.GOLDEN_APPLE_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.ORANGE_WOOD, BFBlocks.ORANGE_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.STRIPPED_ORANGE_WOOD, BFBlocks.STRIPPED_ORANGE_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.LEMON_WOOD, BFBlocks.LEMON_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.STRIPPED_LEMON_WOOD, BFBlocks.STRIPPED_LEMON_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.PLUM_WOOD, BFBlocks.PLUM_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.STRIPPED_PLUM_WOOD, BFBlocks.STRIPPED_PLUM_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.PALM_WOOD, BFBlocks.PALM_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.STRIPPED_PALM_WOOD, BFBlocks.STRIPPED_PALM_LOG);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.BROWN_DYE)
                .input(BFBlocks.WALNUT_MULCH)
                .criterion("has_mulch", conditionsFromItem(BFBlocks.WALNUT_MULCH))
                .offerTo(exporter);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.WALNUT_MULCH_BLOCK, BFBlocks.WALNUT_MULCH);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BFBlocks.PALM_MULCH, 4)
                .group("coconut_mulch")
                .input(BFBlocks.PALM_MULCH_BLOCK)
                .criterion("has_mulch", conditionsFromItem(BFBlocks.PALM_MULCH_BLOCK))
                .offerTo(exporter);
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.PALM_MULCH_BLOCK, BFBlocks.PALM_MULCH);

        offerShapelessRecipe(exporter, BFItems.COCONUT_HALF, BFItems.COCONUT, "coconut_half", 2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PAPER, 2)
                .pattern("##")
                .input('#', BFItems.PALM_FROND)
                .criterion(hasItem(BFItems.PALM_FROND), conditionsFromItem(BFItems.PALM_FROND))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.PACKED_MUD)
                .input(Items.MUD)
                .input(BFItems.COCONUT_COIR)
                .group("packed_mud")
                .criterion(hasItem(Items.MUD), conditionsFromItem(Items.MUD))
                .offerTo(exporter);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.PACKED_COCONUT_COIR, BFItems.COCONUT_COIR);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.COIR_BRICKS, BFBlocks.PACKED_COCONUT_COIR);
        BlockFamily coirBricksFamily = register(BFBlocks.COIR_BRICKS)
                .stairs(BFBlocks.COIR_BRICK_STAIRS)
                .slab(BFBlocks.COIR_BRICK_SLAB)
                .wall(BFBlocks.COIR_BRICK_WALL)
                .unlockCriterionName("has_coir_bricks")
                .build();
        generateFamily(exporter, coirBricksFamily, FeatureSet.of(FeatureFlags.VANILLA));
        offerCarpetRecipe(exporter, BFBlocks.COIR_CARPET, BFBlocks.PACKED_COCONUT_COIR);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BFBlocks.COCONUT_CANDLE, 1)
                .input('S', Items.STRING)
                .input('H', Items.HONEYCOMB)
                .input('#', BFItemTags.C_COCONUT_HALVES)
                .pattern("S")
                .pattern("H")
                .pattern("#")
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion("has_coconut", conditionsFromTag(BFItemTags.C_COCONUT_HALVES))
                .offerTo(exporter);

        offerBarkBlockRecipe(exporter, BFBlocks.HOARY_WOOD, BFBlocks.HOARY_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.STRIPPED_HOARY_WOOD, BFBlocks.STRIPPED_HOARY_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.WALNUT_WOOD, BFBlocks.WALNUT_LOG);
        offerBarkBlockRecipe(exporter, BFBlocks.STRIPPED_WALNUT_WOOD, BFBlocks.STRIPPED_WALNUT_LOG);
        offerBoatRecipe(exporter, BFItems.HOARY_BOAT, BFBlocks.HOARY_PLANKS);
        offerBoatRecipe(exporter, BFItems.WALNUT_BOAT, BFBlocks.WALNUT_PLANKS);
        offerChestBoatRecipe(exporter, BFItems.HOARY_CHEST_BOAT, BFItems.HOARY_BOAT);
        offerChestBoatRecipe(exporter, BFItems.WALNUT_CHEST_BOAT, BFItems.WALNUT_BOAT);

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
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BFBlocks.IRON_RAILING, 8)
                .input('#', Items.IRON_INGOT)
                .input('S', Items.IRON_NUGGET)
                .pattern("#S#")
                .criterion("has_iron", conditionsFromItem(Items.IRON_INGOT)).offerTo(exporter);



        offerShapelessRecipe(exporter, BFItems.MAIZE_SEEDS, BFItems.MAIZE, null, 2);
        offerShapelessRecipe(exporter, BFItems.SPONGEKIN_SEEDS, BFItems.SPONGEKIN_SLICE, null, 1);
        offerShapelessRecipe(exporter, Items.GREEN_DYE, BFItems.TEA_LEAVES, "green_dye", 1);
        offerShapelessRecipe(exporter, Items.BLACK_DYE, BFItems.DRIED_TEA_LEAVES, "black_dye", 1);
        offerShapelessRecipe(exporter, Items.LIGHT_GRAY_DYE, BFBlocks.CHAMOMILE_FLOWERS, "light_gray_dye", 1);
        offerShapelessRecipe(exporter, Items.YELLOW_DYE, BFBlocks.HONEYSUCKLE, "yellow_dye", 1);
        offerShapelessRecipe(exporter, Items.PURPLE_DYE, BFBlocks.VIOLET_BELLFLOWER, "purple_dye", 1);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.GOLDEN_APPLE, RecipeCategory.FOOD, BFBlocks.GOLDEN_APPLE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, Items.APPLE, RecipeCategory.FOOD, BFBlocks.APPLE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, BFItems.ORANGE, RecipeCategory.FOOD, BFBlocks.ORANGE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, BFItems.LEMON, RecipeCategory.FOOD, BFBlocks.LEMON_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, BFItems.PLUM, RecipeCategory.FOOD, BFBlocks.PLUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, BFItems.HOARY_APPLE, RecipeCategory.FOOD, BFBlocks.HOARY_APPLE_BLOCK);
        offerTeaRecipes(exporter, BFItems.GREEN_TEA_BOTTLE, BFBlocks.GREEN_TEA_CANDLE, BFItems.GREEN_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.BLACK_TEA_BOTTLE, BFBlocks.BLACK_TEA_CANDLE, BFItems.BLACK_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.CHAMOMILE_TEA_BOTTLE, BFBlocks.CHAMOMILE_CANDLE, BFItems.CHAMOMILE_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.HONEYSUCKLE_TEA_BOTTLE, BFBlocks.HONEYSUCKLE_CANDLE, BFItems.HONEYSUCKLE_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.BELLFLOWER_TEA_BOTTLE, BFBlocks.BELLFLOWER_CANDLE, BFItems.BELLFLOWER_TEA_BLEND);
        offerTeaRecipes(exporter, BFItems.TORCHFLOWER_TEA_BOTTLE, BFBlocks.TORCHFLOWER_CANDLE, BFItems.TORCHFLOWER_TEA_BLEND);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BFBlocks.WALNUT_CANDLE, 1)
                .input('S', Items.STRING)
                .input('H', Items.HONEYCOMB)
                .input('#', BFItems.WALNUT)
                .pattern("S")
                .pattern("H")
                .pattern("#")
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion(hasItem(BFItems.WALNUT), conditionsFromItem(BFItems.WALNUT))
                .offerTo(exporter);
        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.SPONGEKIN, BFItems.SPONGEKIN_SLICE);
        offerCompoteJarRecipe(exporter, BFItems.APPLE_COMPOTE_JAR, Items.APPLE);
        offerCompoteJarRecipe(exporter, BFItems.ORANGE_COMPOTE_JAR, BFItems.ORANGE);
        offerCompoteJarRecipe(exporter, BFItems.LEMON_COMPOTE_JAR, BFItems.LEMON);
        offerCompoteJarRecipe(exporter, BFItems.PLUM_COMPOTE_JAR, BFItems.PLUM);
        offerCompoteJarRecipe(exporter, BFItems.HOARY_COMPOTE_JAR, BFItems.HOARY_APPLE);
        offerCandyRecipe(exporter, BFItems.CANDY, Items.HONEY_BOTTLE);
        offerCandyRecipe(exporter, BFItems.PIQUANT_CANDY, Items.SWEET_BERRIES);
        offerCandyRecipe(exporter, BFItems.SOUR_CANDY, BFItems.CITRUS_ESSENCE);
        offerCandyRecipe(exporter, BFItems.BITTER_CANDY, BFItems.ELDERBERRIES);
        offerCandyRecipe(exporter, BFItems.STRANGE_CANDY, BFItems.LAPISBERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.PASSION_FRUIT_TART, BFItems.PASSION_FRUIT);
        offerTartAndPieRecipe(exporter, BFBlocks.ELDERBERRY_TART, BFItems.ELDERBERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.GLOW_BERRY_TART, Items.GLOW_BERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.LAPISBERRY_TART, BFItems.LAPISBERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.SWEET_BERRY_TART, Items.SWEET_BERRIES);
        offerTartAndPieRecipe(exporter, BFBlocks.APPLE_PIE, Items.APPLE);
        offerTartAndPieRecipe(exporter, BFBlocks.ORANGE_PIE, BFItems.ORANGE);
        offerTartAndPieRecipe(exporter, BFBlocks.LEMON_PIE, BFItems.LEMON);
        offerTartAndPieRecipe(exporter, BFBlocks.PLUM_PIE, BFItems.PLUM);
        offerTartAndPieRecipe(exporter, BFBlocks.HOARY_PIE, BFItems.HOARY_APPLE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BLOCK)
                .pattern("##")
                .pattern("##")
                .input('#', BFItems.FELDSPAR)
                .criterion(hasItem(BFItems.FELDSPAR), conditionsFromItem(BFItems.FELDSPAR))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BFItems.FELDSPAR, 4)
                .input(BFBlocks.FELDSPAR_BLOCK)
                .criterion(hasItem(BFBlocks.FELDSPAR_BLOCK), conditionsFromItem(BFBlocks.FELDSPAR_BLOCK))
                .offerTo(exporter);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, BFItems.CERAMIC_CLAY, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_CLAY_BLOCK, "ceramic_clay_block", null, "ceramic_clay_from_block", "ceramic_clay");
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILES, BFItems.CERAMIC_TILE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_PILLAR, 2)
                .pattern("#")
                .pattern("#")
                .input('#', BFBlocks.CERAMIC_TILES)
                .criterion(hasItem(BFBlocks.CERAMIC_TILES), conditionsFromItem(BFBlocks.CERAMIC_TILES))
                .offerTo(exporter);
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC, BFBlocks.CERAMIC_TILES);


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

        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CUT_FELDSPAR_BLOCK, BFBlocks.FELDSPAR_BLOCK);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICKS, BFBlocks.CUT_FELDSPAR_BLOCK);
        BlockFamily feldsparBricksFamily = register(BFBlocks.FELDSPAR_BRICKS)
                .stairs(BFBlocks.FELDSPAR_BRICK_STAIRS)
                .slab(BFBlocks.FELDSPAR_BRICK_SLAB)
                .unlockCriterionName("has_feldspar_bricks")
                .build();
        generateFamily(exporter, feldsparBricksFamily, FeatureSet.of(FeatureFlags.VANILLA));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CUT_FELDSPAR_BLOCK, BFBlocks.FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICKS, BFBlocks.FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_STAIRS, BFBlocks.FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_SLAB, BFBlocks.FELDSPAR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICKS, BFBlocks.CUT_FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_STAIRS, BFBlocks.CUT_FELDSPAR_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_SLAB, BFBlocks.CUT_FELDSPAR_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_STAIRS, BFBlocks.FELDSPAR_BRICKS, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.FELDSPAR_BRICK_SLAB, BFBlocks.FELDSPAR_BRICKS, 2);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_STAIRS, BFBlocks.CERAMIC_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILES, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS, BFBlocks.CHECKERED_CERAMIC_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CHECKERED_CERAMIC_TILE_SLAB, BFBlocks.CHECKERED_CERAMIC_TILES, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_TILE_PILLAR, BFBlocks.CERAMIC_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC, BFBlocks.CERAMIC_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_STAIRS, BFBlocks.CERAMIC_TILES, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_TILES, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_STAIRS, BFBlocks.CERAMIC_MOSAIC, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFBlocks.CERAMIC_MOSAIC_SLAB, BFBlocks.CERAMIC_MOSAIC, 2);

        offerSmelting(exporter, ImmutableList.of(BFItems.CERAMIC_CLAY), RecipeCategory.MISC, BFItems.CERAMIC_TILE, 0.3f, 200, "ceramic_tile");
        offerSmelting(exporter, ImmutableList.of(BFItems.TEA_LEAVES), RecipeCategory.FOOD, BFItems.DRIED_TEA_LEAVES, 0.3f, 200, "dried_tea_leaves");
        offerSmelting(exporter, ImmutableList.of(BFBlocks.CERAMIC_TILES), RecipeCategory.FOOD, BFBlocks.CRACKED_CERAMIC_TILES, 0.3f, 200, "cracked_ceramic_tiles");


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, BFItems.ARTISAN_BRUSH)
                .pattern("FFF")
                .pattern(" G ")
                .pattern(" S ")
                .input('F', Items.STRING)
                .input('G', Items.GOLD_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(BFBlocks.CERAMIC_TILES), conditionsFromTag(BFItemTags.DYEABLE_CERAMIC_BLOCKS))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.DIORITE)
                .pattern("CF")
                .pattern("FC")
                .input('C', Items.COBBLESTONE)
                .input('F', BFItems.FELDSPAR)
                .criterion(hasItem(BFItems.FELDSPAR), conditionsFromItem(BFItems.FELDSPAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.GRANITE)
                .input(Items.DIORITE)
                .input(BFItems.FELDSPAR)
                .criterion(hasItem(BFItems.FELDSPAR), conditionsFromItem(BFItems.FELDSPAR))
                .offerTo(exporter);

        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILE_STAIRS);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILE_SLAB);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CRACKED_CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_TILES, BFBlocks.CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS, BFBlocks.CERAMIC_TILE_STAIRS);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CHECKERED_CERAMIC_TILE_SLAB, BFBlocks.CERAMIC_TILE_SLAB);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES, BFBlocks.CRACKED_CERAMIC_TILES);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TILE_PILLAR);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_PRESSURE_PLATE);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_BUTTON);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_DISH);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_DOOR);
        offerCeramicUndyingRecipe(exporter, BFBlocks.CERAMIC_TRAPDOOR);
        offerCeramicUndyingRecipe(exporter, BFItems.ARTISAN_BRUSH);

        offerHangingSignRecipe(exporter, BFItems.HOARY_HANGING_SIGN, BFBlocks.STRIPPED_HOARY_LOG);
        offerHangingSignRecipe(exporter, BFItems.WALNUT_HANGING_SIGN, BFBlocks.STRIPPED_WALNUT_LOG);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BFBlocks.GRASSY_DIRT)
                .input(BFItems.GRASS_SEEDS)
                .input(BFItemTags.GRASS_SEEDS_PLANTABLE_ON)
                .criterion(hasItem(BFItems.GRASS_SEEDS), conditionsFromItem(BFItems.GRASS_SEEDS))
                .offerTo(exporter);

    }







    public static void offerCandiedFruitRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, int count) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output, count)
                .input(input)
                .input(BFItemTags.SUGAR_INGREDIENTS)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerCeramicUndyingRecipe(RecipeExporter exporter, ItemConvertible item) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, item, 1).input(item)
                .criterion("has_item", conditionsFromItem(item)).offerTo(exporter, getItemId(item) + "_undying");
    }

    public static void offerCeramicUndyingRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1).input(input)
                .criterion("has_item", conditionsFromItem(input)).offerTo(exporter, getItemId(input) + "_undying");
    }

    public static void offerPicketsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', input).input('S', Items.STICK)
                .pattern("#S#").criterion("has_planks", conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerPicketsRecipe(RecipeExporter exporter, ItemConvertible output, Identifier input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4).input('#', Registries.ITEM.get(input)).input('S', Items.STICK)
                .pattern("#S#").criterion("has_planks", conditionsFromItem(Registries.ITEM.get(input))).offerTo(exporter);
    }
    public static void offerTeaRecipes(RecipeExporter exporter, ItemConvertible teaBottle, ItemConvertible teaCandle, ItemConvertible teaBlendItem) {
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
    public static void offerCompoteJarRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input, 2)
                .input(BFItems.CITRUS_ESSENCE)
                .input(BFItems.JAR)
                .criterion(hasItem(BFItems.JAR), conditionsFromItem(BFItems.JAR))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerCandyRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input)
                .input(Items.SUGAR)
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerJackOStrawRecipes(RecipeExporter exporter, ItemConvertible output, ItemConvertible wool) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(BFItems.SUN_HAT)
                .input(Items.CARVED_PUMPKIN)
                .input(wool)
                .input(Items.STICK)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .criterion(hasItem(Items.CARVED_PUMPKIN), conditionsFromItem(Items.CARVED_PUMPKIN))
                .criterion(hasItem(BFItems.SUN_HAT), conditionsFromItem(BFItems.SUN_HAT))
                .criterion("has_wool", conditionsFromItem(wool))
                .offerTo(exporter, getItemId(output) + "_with_carved_pumpkin");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(BFItems.SUN_HAT)
                .input(Items.PUMPKIN)
                .input(wool)
                .input(Items.STICK)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .criterion(hasItem(Items.CARVED_PUMPKIN), conditionsFromItem(Items.CARVED_PUMPKIN))
                .criterion(hasItem(BFItems.SUN_HAT), conditionsFromItem(BFItems.SUN_HAT))
                .criterion("has_wool", conditionsFromItem(wool))
                .offerTo(exporter, getItemId(output) + "_with_pumpkin");
    }
    public static void offerJackOStrawRecipes(RecipeExporter exporter, ItemConvertible output, ItemConvertible wool, String specifier) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(BFItems.SUN_HAT)
                .input(Items.CARVED_PUMPKIN)
                .input(wool)
                .input(Items.STICK)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .criterion(hasItem(Items.CARVED_PUMPKIN), conditionsFromItem(Items.CARVED_PUMPKIN))
                .criterion(hasItem(BFItems.SUN_HAT), conditionsFromItem(BFItems.SUN_HAT))
                .criterion("has_wool", conditionsFromItem(wool))
                .offerTo(exporter, getItemId(output) + "_with_carved_pumpkin_" + specifier);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output)
                .input(BFItems.SUN_HAT)
                .input(Items.PUMPKIN)
                .input(wool)
                .input(Items.STICK)
                .criterion(hasItem(wool), conditionsFromItem(wool))
                .criterion(hasItem(Items.CARVED_PUMPKIN), conditionsFromItem(Items.CARVED_PUMPKIN))
                .criterion(hasItem(BFItems.SUN_HAT), conditionsFromItem(BFItems.SUN_HAT))
                .criterion("has_wool", conditionsFromItem(wool))
                .offerTo(exporter, getItemId(output) + "_with_pumpkin_" + specifier);
    }
    public static void offerTartAndPieRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output)
                .input(input)
                .input(BFItemTags.C_FLOUR)
                .input(Items.EGG)
                .input(Items.SUGAR)
                .criterion(hasItem(BFItems.FLOUR), conditionsFromTag(BFItemTags.C_FLOUR))
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerMillingRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, int count) {
        MillingRecipeBuilder.create(input.asItem(), output, count)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offerFermentingRecipe(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, int count, int particleColor) {
        FermentingRecipeBuilder.create(input.asItem(), output, count, particleColor)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
}
