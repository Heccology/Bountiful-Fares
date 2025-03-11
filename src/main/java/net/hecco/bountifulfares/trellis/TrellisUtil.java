package net.hecco.bountifulfares.trellis;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.datagen.bountifulfares.BFTemplateModels;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFaresUtil.toSentenceCase;
import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;

public class TrellisUtil extends FabricTagProvider.BlockTagProvider {


    public TrellisUtil(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static List<TrellisVariant> TrellisVariants = new ArrayList<>();
    public static List<VineCrop> VineCrops = new ArrayList<>(List.of(
            BFTrellises.PASSION_FRUIT,
            BFTrellises.ELDERBERRY,
            BFTrellises.LAPISBERRY,
            BFTrellises.GLOW_BERRY

    ));
    public static List<DecorativeVine> DecorativeVines = new ArrayList<>(List.of(
            BFTrellises.ROSE,
            BFTrellises.LILAC,
            BFTrellises.PEONY,
            BFTrellises.SUNFLOWER,
            BFTrellises.VINE,
            BFTrellises.WEEPING,
            BFTrellises.TWISTING
    ));

    public static void registerTrellisParts() {
        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID) || BountifulFares.isDatagen()) {
            DecorativeVines.add(BFTrellises.NS_LAVENDER);
            DecorativeVines.add(BFTrellises.NS_BLEEDING_HEART);
            DecorativeVines.add(BFTrellises.NS_BLUE_BULB);
            DecorativeVines.add(BFTrellises.NS_CARNATION);
            DecorativeVines.add(BFTrellises.NS_GARDENIA);
            DecorativeVines.add(BFTrellises.NS_MARIGOLD);
            DecorativeVines.add(BFTrellises.NS_FOXGLOVE);
        }
        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID) || BountifulFares.isDatagen()) {
            VineCrops.add(BFTrellises.SPAWN_SUNFLOWER);
        }
    }

    public static Block registerBlockNoItem(String id, String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(id, name), block);
    }

    public static Block registerBlock(String id, String name, Block block) {
        registerBlockItem(id, name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(id, name), block);
    }

    private static Item registerBlockItem(String id, String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(id, name), new BlockItem(block, new Item.Settings()));
    }

    public static Block getTrellisFromVariant(TrellisVariant variant) {
        return BFTrellises.TRELLISES.get(variant.getBlockName());
    }

    public static Block getCropTrellisFromVariant(TrellisVariant variant, VineCrop crop) {
        return BFTrellises.CROP_TRELLISES.get(crop.getName() + variant.getBlockName());
    }

    public static Block getDecorTrellisFromVariant(TrellisVariant variant, DecorativeVine vine) {
        return BFTrellises.DECORATIVE_TRELLISES.get(vine.getName() + variant.getBlockName());
    }

    public static void registerTrellisModels(BlockStateModelGenerator blockStateModelGenerator, TrellisVariant variant) {
        BFTemplateModels.registerTrellis(blockStateModelGenerator, variant);
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.PASSION_FRUIT),
                variant.getBlockName(),
                BFTrellises.PASSION_FRUIT.getName() + "_trellis_vines",
                BFTrellises.PASSION_FRUIT.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.ELDERBERRY),
                variant.getBlockName(),
                BFTrellises.ELDERBERRY.getName() + "_trellis_vines",
                BFTrellises.ELDERBERRY.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.LAPISBERRY),
                variant.getBlockName(),
                BFTrellises.LAPISBERRY.getName() + "_trellis_vines",
                BFTrellises.LAPISBERRY.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.GLOW_BERRY),
                variant.getBlockName(),
                BFTrellises.GLOW_BERRY.getName() + "_trellis_vines",
                BFTrellises.GLOW_BERRY.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.ROSE),
                variant.getBlockName(),
                BFTrellises.ROSE.getName() + "_trellis_vines",
                BFTrellises.ROSE.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.LILAC),
                variant.getBlockName(),
                BFTrellises.LILAC.getName() + "_trellis_vines",
                BFTrellises.LILAC.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.PEONY),
                variant.getBlockName(),
                BFTrellises.PEONY.getName() + "_trellis_vines",
                BFTrellises.PEONY.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.SUNFLOWER),
                variant.getBlockName(),
                BFTrellises.SUNFLOWER.getName() + "_trellis_vines",
                BFTrellises.SUNFLOWER.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.VINE),
                variant.getBlockName(),
                BFTrellises.VINE.getName() + "_trellis_vines",
                BFTrellises.VINE.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.WEEPING),
                variant.getBlockName(),
                BFTrellises.WEEPING.getName() + "_trellis_vines",
                BFTrellises.WEEPING.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerUpsideDownDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.TWISTING),
                variant.getBlockName(),
                BFTrellises.TWISTING.getName() + "_trellis_vines",
                BFTrellises.TWISTING.getName() + "_trellis_foliage",
                variant.getModId());
//        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                new Identifier(variant.getModId(), ModTrellises.NS_LAVENDER.getName() + "_" + variant.getBlockName()),
//                variant.getBlockName(),
//                ModTrellises.NS_LAVENDER.getName() + "_trellis_vines",
//                ModTrellises.NS_LAVENDER.getName() + "_trellis_foliage",
//                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_LAVENDER),
                variant.getBlockName(),
                BFTrellises.NS_LAVENDER.getName() + "_trellis_vines",
                BFTrellises.NS_LAVENDER.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLEEDING_HEART),
                variant.getBlockName(),
                BFTrellises.NS_BLEEDING_HEART.getName() + "_trellis_vines",
                BFTrellises.NS_BLEEDING_HEART.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLUE_BULB),
                variant.getBlockName(),
                BFTrellises.NS_BLUE_BULB.getName() + "_trellis_vines",
                BFTrellises.NS_BLUE_BULB.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_CARNATION),
                variant.getBlockName(),
                BFTrellises.NS_CARNATION.getName() + "_trellis_vines",
                BFTrellises.NS_CARNATION.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_GARDENIA),
                variant.getBlockName(),
                BFTrellises.NS_GARDENIA.getName() + "_trellis_vines",
                BFTrellises.NS_GARDENIA.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_MARIGOLD),
                variant.getBlockName(),
                BFTrellises.NS_MARIGOLD.getName() + "_trellis_vines",
                BFTrellises.NS_MARIGOLD.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_FOXGLOVE),
                variant.getBlockName(),
                BFTrellises.NS_FOXGLOVE.getName() + "_trellis_vines",
                BFTrellises.NS_FOXGLOVE.getName() + "_trellis_foliage",
                variant.getModId());
        BFTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.SPAWN_SUNFLOWER),
                variant.getBlockName(),
                BFTrellises.SPAWN_SUNFLOWER.getName() + "_trellis_vines",
                BFTrellises.SPAWN_SUNFLOWER.getName() + "_trellis_foliage",
                variant.getModId());
    }

    public static void registerTrellisTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder, TrellisVariant trellis) {
        String temp = toSentenceCase(Registries.ITEM.getId(TrellisUtil.getTrellisFromVariant(trellis).asItem()).getPath());
        translationBuilder.add(TrellisUtil.getTrellisFromVariant(trellis), temp);
        for (VineCrop crop : TrellisUtil.VineCrops) {
            translationBuilder.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), temp);
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            translationBuilder.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), temp);
        }
    }

    public static void registerTrellisTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder, TrellisVariant trellis, String display) {
        translationBuilder.add(TrellisUtil.getTrellisFromVariant(trellis), display);
        for (VineCrop crop : TrellisUtil.VineCrops) {
            translationBuilder.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), display);
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            translationBuilder.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), display);
        }
    }

    public static void registerTrellisRecipe(RecipeExporter exporter, TrellisVariant trellis) {
        if (trellis.getCraftingItem() != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, TrellisUtil.getTrellisFromVariant(trellis))
                    .pattern("# #")
                    .pattern(" P ")
                    .pattern("# #")
                    .input('#', Items.STICK)
                    .input('P', trellis.getCraftingItem())
                    .criterion("has_stick", conditionsFromItem(Items.STICK))
                    .criterion("has_planks", conditionsFromItem(trellis.getCraftingItem()))
                    .group("trellis")
                    .offerTo(exporter);
        }
    }

    public static void registerCompatTrellisRecipe(RecipeExporter exporter, TrellisVariant trellis) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, TrellisUtil.getTrellisFromVariant(trellis))
                    .pattern("# #")
                    .pattern(" P ")
                    .pattern("# #")
                    .input('#', Items.STICK)
                    .input('P', Registries.ITEM.get(trellis.getCraftingItemIdentifier()))
                    .criterion("has_stick", conditionsFromItem(Items.STICK))
                    .criterion("has_planks", conditionsFromItem(Registries.ITEM.get(trellis.getCraftingItemIdentifier())))
                    .group("trellis")
                    .offerTo(exporter);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

    }
}
