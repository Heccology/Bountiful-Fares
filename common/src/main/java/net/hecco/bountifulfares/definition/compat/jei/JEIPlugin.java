//package net.hecco.bountifulfares.compat.jei;
//
//import com.google.common.collect.ImmutableList;
//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.registration.IRecipeCatalystRegistration;
//import mezz.jei.api.registration.IRecipeCategoryRegistration;
//import mezz.jei.api.registration.IRecipeRegistration;
//import net.hecco.bountifulfares.BountifulFares;
//import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
//import net.hecco.bountifulfares.compat.jei.category.FermentingRecipeCategory;
//import net.hecco.bountifulfares.compat.jei.category.MillingRecipeCategory;
//import net.hecco.bountifulfares.compat.jei.category.PrismarinePropagationCategory;
//import net.hecco.bountifulfares.registry.content.BFBlocks;
//import net.hecco.bountifulfares.registry.content.BFItems;
//import net.minecraft.MethodsReturnNonnullByDefault;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.ItemStack;
//
//@JeiPlugin @MethodsReturnNonnullByDefault @SuppressWarnings("unused")
//public class JEIPlugin implements IModPlugin {
//    private static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "jei_plugin");
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        BFJEIRecipes bfRecipes = new BFJEIRecipes();
//
//        //RECIPES
//        registration.addRecipes(BFRecipeTypes.MILLING, bfRecipes.getMillingRecipes());
//        registration.addRecipes(BFRecipeTypes.FERMENTING, bfRecipes.getFermentationRecipes());
//        registration.addRecipes(BFRecipeTypes.PRISMARINE_PROPAGATION, ImmutableList.of(new PropagationRecipe()));
//
//        //TOOLTIPS
//        registration.addIngredientInfo(new ItemStack(AppledogBlocks.APPLEDOG_BLOCK), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.appledog_block"));
//
//        registration.addIngredientInfo(new ItemStack(BFBlocks.GOLDEN_APPLE_SAPLING), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.golden_apple_sapling"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.CERAMIC_DISH), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.ceramic_dish"));
//        registration.addIngredientInfo(new ItemStack(BFItems.ARTISAN_BRUSH), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.artisian_brush"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.PRISMARINE_BLOSSOM), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.prismarine_blossom"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.FERMENTATION_VESSEL), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.fermentation_vessel"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.ARTISAN_BREAD), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.artisan_food"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.ARTISAN_COOKIE), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.artisan_cookie"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.APPLE_LEAVES), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.fruit_leaves"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.PLUM_LEAVES), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.fruit_leaves"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.ORANGE_LEAVES), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.fruit_leaves"));
//        registration.addIngredientInfo(new ItemStack(BFBlocks.LEMON_LEAVES), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.fruit_leaves"));
//        registration.addIngredientInfo(new ItemStack(BFItems.ELDERBERRIES), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.chance_to_heal"));
//        registration.addIngredientInfo(new ItemStack(BFItems.BITTER_CANDY), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.chance_to_heal"));
//        registration.addIngredientInfo(new ItemStack(BFItems.ELDERBERRY_WINE_BOTTLE), VanillaTypes.ITEM_STACK, Component.translatable("jei.info.chance_to_heal"));
//    }
//
//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registry) {
//        registry.addRecipeCategories(new MillingRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
//        registry.addRecipeCategories(new FermentingRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
//        registry.addRecipeCategories(new PrismarinePropagationCategory(registry.getJeiHelpers().getGuiHelper()));
//    }
//
//    @Override
//    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        registration.addRecipeCatalyst(new ItemStack(BFBlocks.GRISTMILL.asItem()), BFRecipeTypes.MILLING);
//        registration.addRecipeCatalyst(new ItemStack(BFBlocks.FERMENTATION_VESSEL.asItem()), BFRecipeTypes.FERMENTING);
//    }
//
//    @Override
//    public ResourceLocation getPluginUid() {
//        return ID;
//    }
//}
