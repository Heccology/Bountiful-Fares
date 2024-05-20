package net.hecco.bountifulfares.trellis;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.hecco.bountifulfares.datagen.custom.BFTemplateModels;
import net.hecco.bountifulfares.datagen.BFLangProvider;
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

    public static void registerTrellisParts() {}

    public static Block registerBlockNoItem(String id, String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(id, name), block);
    }

    public static Block registerBlock(String id, String name, Block block) {
        registerBlockItem(id, name, block);
        return Registry.register(Registries.BLOCK, new Identifier(id, name), block);
    }

    private static Item registerBlockItem(String id, String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), new BlockItem(block, new FabricItemSettings()));
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
        BFTemplateModels.registerTrellis(blockStateModelGenerator, TrellisUtil.getTrellisFromVariant(variant));
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
    }

    public static void registerTrellisTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder, TrellisVariant trellis) {
        String temp = BFLangProvider.capitalizeString(Registries.ITEM.getId(TrellisUtil.getTrellisFromVariant(trellis).asItem()).getPath().replace("_", " "));
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

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

    }
}
