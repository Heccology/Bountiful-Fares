//package net.hecco.bountifulfares.trellis;
//
//import net.hecco.bountifulfares.BountifulFares;
//import net.hecco.bountifulfares.datagen.bountifulfares.BFTemplateModels;
//import net.hecco.bountifulfares.registry.content.BFTrellises;
//import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
//import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
//import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
//import net.minecraft.core.HolderLookup;
//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.data.models.BlockModelGenerators;
//import net.minecraft.data.recipes.RecipeCategory;
//import net.minecraft.data.recipes.RecipeOutput;
//import net.minecraft.data.recipes.ShapedRecipeBuilder;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.BlockItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.block.Block;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//import static net.hecco.bountifulfares.BountifulFaresUtil.toSentenceCase;
//import static net.minecraft.data.recipes.RecipeProvider.has;
//
//public class TrellisUtil extends FabricTagProvider.BlockTagProvider {
//
//
//    public TrellisUtil(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
//        super(output, registriesFuture);
//    }
//
//    public static List<TrellisVariant> TrellisVariants = new ArrayList<>();
//    public static List<VineCrop> VineCrops = new ArrayList<>(List.of(
//            BFTrellises.PASSION_FRUIT,
//            BFTrellises.ELDERBERRY,
//            BFTrellises.LAPISBERRY,
//            BFTrellises.GLOW_BERRY
//
//    ));
//    public static List<DecorativeVine> DecorativeVines = new ArrayList<>(List.of(
//            BFTrellises.ROSE,
//            BFTrellises.LILAC,
//            BFTrellises.PEONY,
//            BFTrellises.SUNFLOWER,
//            BFTrellises.VINE,
//            BFTrellises.WEEPING,
//            BFTrellises.TWISTING
//    ));
//
//    public static void registerTrellisParts() {
//        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID) || BountifulFares.isDatagen()) {
//            DecorativeVines.add(BFTrellises.NS_LAVENDER);
//            DecorativeVines.add(BFTrellises.NS_BLEEDING_HEART);
//            DecorativeVines.add(BFTrellises.NS_BLUE_BULB);
//            DecorativeVines.add(BFTrellises.NS_CARNATION);
//            DecorativeVines.add(BFTrellises.NS_GARDENIA);
//            DecorativeVines.add(BFTrellises.NS_MARIGOLD);
//            DecorativeVines.add(BFTrellises.NS_FOXGLOVE);
//        }
//        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID) || BountifulFares.isDatagen()) {
//            VineCrops.add(BFTrellises.SPAWN_SUNFLOWER);
//        }
//    }
//
//    public static Block registerBlockNoItem(String id, String name, Block block) {
//        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(id, name), block);
//    }
//
//    public static Block registerBlock(String id, String name, Block block) {
//        registerBlockItem(id, name, block);
//        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(id, name), block);
//    }
//
//    private static Item registerBlockItem(String id, String name, Block block) {
//        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(id, name), new BlockItem(block, new Item.Properties()));
//    }
//
//    public static Block getTrellisFromVariant(TrellisVariant variant) {
//        return BFTrellises.TRELLISES.get(variant.getBlockName());
//    }
//
//    public static Block getCropTrellisFromVariant(TrellisVariant variant, VineCrop crop) {
//        return BFTrellises.CROP_TRELLISES.get(crop.getName() + variant.getBlockName());
//    }
//
//    public static Block getDecorTrellisFromVariant(TrellisVariant variant, DecorativeVine vine) {
//        return BFTrellises.DECORATIVE_TRELLISES.get(vine.getName() + variant.getBlockName());
//    }
//
//    public static void registerTrellisModels(BlockModelGenerators blockStateModelGenerator, TrellisVariant variant) {
//        BFTemplateModels.registerTrellis(blockStateModelGenerator, variant);
//        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
//                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.PASSION_FRUIT),
//                variant.getBlockName(),
//                BFTrellises.PASSION_FRUIT.getName() + "_trellis_vines",
//                BFTrellises.PASSION_FRUIT.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
//                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.ELDERBERRY),
//                variant.getBlockName(),
//                BFTrellises.ELDERBERRY.getName() + "_trellis_vines",
//                BFTrellises.ELDERBERRY.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
//                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.LAPISBERRY),
//                variant.getBlockName(),
//                BFTrellises.LAPISBERRY.getName() + "_trellis_vines",
//                BFTrellises.LAPISBERRY.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
//                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.GLOW_BERRY),
//                variant.getBlockName(),
//                BFTrellises.GLOW_BERRY.getName() + "_trellis_vines",
//                BFTrellises.GLOW_BERRY.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.ROSE),
//                variant.getBlockName(),
//                BFTrellises.ROSE.getName() + "_trellis_vines",
//                BFTrellises.ROSE.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.LILAC),
//                variant.getBlockName(),
//                BFTrellises.LILAC.getName() + "_trellis_vines",
//                BFTrellises.LILAC.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.PEONY),
//                variant.getBlockName(),
//                BFTrellises.PEONY.getName() + "_trellis_vines",
//                BFTrellises.PEONY.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.SUNFLOWER),
//                variant.getBlockName(),
//                BFTrellises.SUNFLOWER.getName() + "_trellis_vines",
//                BFTrellises.SUNFLOWER.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.VINE),
//                variant.getBlockName(),
//                BFTrellises.VINE.getName() + "_trellis_vines",
//                BFTrellises.VINE.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.WEEPING),
//                variant.getBlockName(),
//                BFTrellises.WEEPING.getName() + "_trellis_vines",
//                BFTrellises.WEEPING.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerUpsideDownDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.TWISTING),
//                variant.getBlockName(),
//                BFTrellises.TWISTING.getName() + "_trellis_vines",
//                BFTrellises.TWISTING.getName() + "_trellis_foliage",
//                variant.getModId());
////        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
////                new Identifier(variant.getModId(), ModTrellises.NS_LAVENDER.getName() + "_" + variant.getBlockName()),
////                variant.getBlockName(),
////                ModTrellises.NS_LAVENDER.getName() + "_trellis_vines",
////                ModTrellises.NS_LAVENDER.getName() + "_trellis_foliage",
////                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_LAVENDER),
//                variant.getBlockName(),
//                BFTrellises.NS_LAVENDER.getName() + "_trellis_vines",
//                BFTrellises.NS_LAVENDER.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLEEDING_HEART),
//                variant.getBlockName(),
//                BFTrellises.NS_BLEEDING_HEART.getName() + "_trellis_vines",
//                BFTrellises.NS_BLEEDING_HEART.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLUE_BULB),
//                variant.getBlockName(),
//                BFTrellises.NS_BLUE_BULB.getName() + "_trellis_vines",
//                BFTrellises.NS_BLUE_BULB.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_CARNATION),
//                variant.getBlockName(),
//                BFTrellises.NS_CARNATION.getName() + "_trellis_vines",
//                BFTrellises.NS_CARNATION.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_GARDENIA),
//                variant.getBlockName(),
//                BFTrellises.NS_GARDENIA.getName() + "_trellis_vines",
//                BFTrellises.NS_GARDENIA.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_MARIGOLD),
//                variant.getBlockName(),
//                BFTrellises.NS_MARIGOLD.getName() + "_trellis_vines",
//                BFTrellises.NS_MARIGOLD.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_FOXGLOVE),
//                variant.getBlockName(),
//                BFTrellises.NS_FOXGLOVE.getName() + "_trellis_vines",
//                BFTrellises.NS_FOXGLOVE.getName() + "_trellis_foliage",
//                variant.getModId());
//        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
//                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.SPAWN_SUNFLOWER),
//                variant.getBlockName(),
//                BFTrellises.SPAWN_SUNFLOWER.getName() + "_trellis_vines",
//                BFTrellises.SPAWN_SUNFLOWER.getName() + "_trellis_foliage",
//                variant.getModId());
//    }
//
//    public static void registerTrellisTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder, TrellisVariant trellis) {
//        String temp = toSentenceCase(BuiltInRegistries.ITEM.getKey(TrellisUtil.getTrellisFromVariant(trellis).asItem()).getPath());
//        translationBuilder.add(TrellisUtil.getTrellisFromVariant(trellis), temp);
//        for (VineCrop crop : TrellisUtil.VineCrops) {
//            translationBuilder.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), temp);
//        }
//        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
//            translationBuilder.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), temp);
//        }
//    }
//
//    public static void registerTrellisRecipe(RecipeOutput exporter, TrellisVariant trellis) {
//        if (trellis.getCraftingItem() != null) {
//            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TrellisUtil.getTrellisFromVariant(trellis))
//                    .pattern("# #")
//                    .pattern(" P ")
//                    .pattern("# #")
//                    .define('#', Items.STICK)
//                    .define('P', trellis.getCraftingItem())
//                    .unlockedBy("has_stick", has(Items.STICK))
//                    .unlockedBy("has_planks", has(trellis.getCraftingItem()))
//                    .group("trellis")
//                    .save(exporter);
//        }
//    }
//
//    public static void registerCompatTrellisRecipe(RecipeOutput exporter, TrellisVariant trellis) {
//        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, TrellisUtil.getTrellisFromVariant(trellis))
//                    .pattern("# #")
//                    .pattern(" P ")
//                    .pattern("# #")
//                    .define('#', Items.STICK)
//                    .define('P', BuiltInRegistries.ITEM.get(trellis.getCraftingItemIdentifier()))
//                    .unlockedBy("has_stick", has(Items.STICK))
//                    .unlockedBy("has_planks", has(BuiltInRegistries.ITEM.get(trellis.getCraftingItemIdentifier())))
//                    .group("trellis")
//                    .save(exporter);
//    }
//
//    @Override
//    protected void addTags(HolderLookup.Provider arg) {
//
//    }
//}
