package net.hecco.bountifulfares.block;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.datagen.custom.ModTemplateModels;
import net.hecco.bountifulfares.datagen.lang.ModEnUsProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;

public class TrellisUtil extends FabricTagProvider.BlockTagProvider {


    public TrellisUtil(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
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
        for (VineCrop crop : TrellisVariants.VineCrops) {
            translationBuilder.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), temp);
        }
        for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
            translationBuilder.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), temp);
        }
//        for (DecorativeVine vine : TrellisVariants.CompatDecorativeVines) {
//            translationBuilder.add("block." + trellis.getModId() + "." + vine.getName() + "_" + trellis.getBlockName(), temp);
//        }
    }

    public static void registerTrellisTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder, TrellisVariant trellis, String display) {
        translationBuilder.add(TrellisUtil.getTrellisFromVariant(trellis), display);
        for (VineCrop crop : TrellisVariants.VineCrops) {
            translationBuilder.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), display);
        }
        for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
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
