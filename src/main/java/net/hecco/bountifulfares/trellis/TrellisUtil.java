package net.hecco.bountifulfares.trellis;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.hecco.bountifulfares.datagen.custom.ModTemplateModels;
import net.hecco.bountifulfares.datagen.lang.ModEnUsProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
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
import java.util.function.Consumer;

import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;

public class TrellisUtil extends FabricTagProvider.BlockTagProvider {


    public TrellisUtil(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static List<TrellisVariant> TrellisVariants = new ArrayList<>();
    public static List<VineCrop> VineCrops = new ArrayList<>(List.of(
            ModTrellises.PASSION_FRUIT,
            ModTrellises.ELDERBERRY,
            ModTrellises.LAPISBERRY,
            ModTrellises.GLOW_BERRY

    ));
    public static List<DecorativeVine> DecorativeVines = new ArrayList<>(List.of(
            ModTrellises.ROSE,
            ModTrellises.LILAC,
            ModTrellises.PEONY,
            ModTrellises.SUNFLOWER,
            ModTrellises.VINE,
            ModTrellises.WEEPING,
            ModTrellises.TWISTING
    ));

    public static void registerTrellisParts() {
        if (FabricLoader.getInstance().isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID) || System.getProperty("fabric-api.datagen") != null) {
            DecorativeVines.add(ModTrellises.NS_LAVENDER);
            DecorativeVines.add(ModTrellises.NS_BLEEDING_HEART);
            DecorativeVines.add(ModTrellises.NS_BLUE_BULB);
            DecorativeVines.add(ModTrellises.NS_CARNATION);
            DecorativeVines.add(ModTrellises.NS_GARDENIA);
            DecorativeVines.add(ModTrellises.NS_MARIGOLD);
            DecorativeVines.add(ModTrellises.NS_FOXGLOVE);
        }
    }

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
        return ModTrellises.TRELLISES.get(variant.getBlockName());
    }

    public static Block getCropTrellisFromVariant(TrellisVariant variant, VineCrop crop) {
        return ModTrellises.CROP_TRELLISES.get(crop.getName() + variant.getBlockName());
    }

    public static Block getDecorTrellisFromVariant(TrellisVariant variant, DecorativeVine vine) {
        return ModTrellises.DECORATIVE_TRELLISES.get(vine.getName() + variant.getBlockName());
    }

    public static void registerTrellisModels(BlockStateModelGenerator blockStateModelGenerator, TrellisVariant variant) {
        ModTemplateModels.registerTrellis(blockStateModelGenerator, variant);
        ModTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, ModTrellises.PASSION_FRUIT),
                variant.getBlockName(),
                ModTrellises.PASSION_FRUIT.getName() + "_trellis_vines",
                ModTrellises.PASSION_FRUIT.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, ModTrellises.ELDERBERRY),
                variant.getBlockName(),
                ModTrellises.ELDERBERRY.getName() + "_trellis_vines",
                ModTrellises.ELDERBERRY.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, ModTrellises.LAPISBERRY),
                variant.getBlockName(),
                ModTrellises.LAPISBERRY.getName() + "_trellis_vines",
                ModTrellises.LAPISBERRY.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerCropTrellis(blockStateModelGenerator,
                TrellisUtil.getCropTrellisFromVariant(variant, ModTrellises.GLOW_BERRY),
                variant.getBlockName(),
                ModTrellises.GLOW_BERRY.getName() + "_trellis_vines",
                ModTrellises.GLOW_BERRY.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.ROSE),
                variant.getBlockName(),
                ModTrellises.ROSE.getName() + "_trellis_vines",
                ModTrellises.ROSE.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.LILAC),
                variant.getBlockName(),
                ModTrellises.LILAC.getName() + "_trellis_vines",
                ModTrellises.LILAC.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.PEONY),
                variant.getBlockName(),
                ModTrellises.PEONY.getName() + "_trellis_vines",
                ModTrellises.PEONY.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.SUNFLOWER),
                variant.getBlockName(),
                ModTrellises.SUNFLOWER.getName() + "_trellis_vines",
                ModTrellises.SUNFLOWER.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.VINE),
                variant.getBlockName(),
                ModTrellises.VINE.getName() + "_trellis_vines",
                ModTrellises.VINE.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.WEEPING),
                variant.getBlockName(),
                ModTrellises.WEEPING.getName() + "_trellis_vines",
                ModTrellises.WEEPING.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerUpsideDownDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.TWISTING),
                variant.getBlockName(),
                ModTrellises.TWISTING.getName() + "_trellis_vines",
                ModTrellises.TWISTING.getName() + "_trellis_foliage",
                variant.getModId());
//        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                new Identifier(variant.getModId(), ModTrellises.NS_LAVENDER.getName() + "_" + variant.getBlockName()),
//                variant.getBlockName(),
//                ModTrellises.NS_LAVENDER.getName() + "_trellis_vines",
//                ModTrellises.NS_LAVENDER.getName() + "_trellis_foliage",
//                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.NS_LAVENDER),
                variant.getBlockName(),
                ModTrellises.NS_LAVENDER.getName() + "_trellis_vines",
                ModTrellises.NS_LAVENDER.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.NS_BLEEDING_HEART),
                variant.getBlockName(),
                ModTrellises.NS_BLEEDING_HEART.getName() + "_trellis_vines",
                ModTrellises.NS_BLEEDING_HEART.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.NS_BLUE_BULB),
                variant.getBlockName(),
                ModTrellises.NS_BLUE_BULB.getName() + "_trellis_vines",
                ModTrellises.NS_BLUE_BULB.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.NS_CARNATION),
                variant.getBlockName(),
                ModTrellises.NS_CARNATION.getName() + "_trellis_vines",
                ModTrellises.NS_CARNATION.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.NS_GARDENIA),
                variant.getBlockName(),
                ModTrellises.NS_GARDENIA.getName() + "_trellis_vines",
                ModTrellises.NS_GARDENIA.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.NS_MARIGOLD),
                variant.getBlockName(),
                ModTrellises.NS_MARIGOLD.getName() + "_trellis_vines",
                ModTrellises.NS_MARIGOLD.getName() + "_trellis_foliage",
                variant.getModId());
        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
                TrellisUtil.getDecorTrellisFromVariant(variant, ModTrellises.NS_FOXGLOVE),
                variant.getBlockName(),
                ModTrellises.NS_FOXGLOVE.getName() + "_trellis_vines",
                ModTrellises.NS_FOXGLOVE.getName() + "_trellis_foliage",
                variant.getModId());
    }

    public static void registerTrellisTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder, TrellisVariant trellis) {
        String temp = ModEnUsProvider.capitalizeString(Registries.ITEM.getId(TrellisUtil.getTrellisFromVariant(trellis).asItem()).getPath().replace("_", " "));
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

    public static void registerTrellisRecipe(Consumer<RecipeJsonProvider> exporter, TrellisVariant trellis) {
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
