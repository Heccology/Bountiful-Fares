package net.hecco.bountifulfares.definition.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.compat.jei.BFRecipeTypes;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.definition.recipe.FermentationRecipe;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("removal")
public class FermentingRecipeCategory implements IRecipeCategory<FermentationRecipe> {
    private final IDrawable fermentationVessel;
    private final IDrawable background;
    private final IDrawable containerIcon;

    public FermentingRecipeCategory(IGuiHelper helper) {
        fermentationVessel = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BFBlocks.FERMENTATION_VESSEL.get().asItem()));
        ResourceLocation backgroundImage = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/jei/fermenting.png");
        background = helper.createDrawable(backgroundImage, 0, 0, 89, 76);
        containerIcon = helper.createDrawable(backgroundImage, 89, 0, 8, 11);
    }

    @Override
    public RecipeType<FermentationRecipe> getRecipeType() {
        return BFRecipeTypes.FERMENTING;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FermentationRecipe recipe, IFocusGroup focusGroup) {
        List<Ingredient> recipeIngredients = recipe.getIngredients();
        ItemStack resultStack = recipe.getOutput();
        Item containerStack = recipe.getOutput().getItem().getCraftingRemainingItem();

        //Code for placing slot locations (input/any misc slot locations)

        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 7, 6).addItemStacks(List.of(PotionContents.createItemStack(Items.POTION, Potions.WATER), Items.WATER_BUCKET.getDefaultInstance())); //output slot location
        builder.addSlot(RecipeIngredientRole.INPUT, 7, 50).addItemStacks(List.of(recipe.getIngredient().getItems())); //output slot location
        builder.addSlot(RecipeIngredientRole.OUTPUT, 63, 50).addItemStack(resultStack); //output slot location
    }

    //this method draws icons (arrow progress etc), i havent converted some mappings here since you use yarn
    @Override
    public void draw(FermentationRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        if (recipe.getOutput().getItem().getCraftingRemainingItem() != null) {
            containerIcon.draw(guiGraphics, 67, 33);
        }
    }

    @Override //you can ignore the errors on this method and getBackground (if they cause errors you can comment them out)
    public List<Component> getTooltipStrings(FermentationRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        List<Component> tooltipStrings = new ArrayList<>();
        if (recipe.getOutput().getItem().getCraftingRemainingItem() != null && mouseX >= 67 && mouseX <= 75 && mouseY >= 33 && mouseY <= 44) {
            tooltipStrings.add(Component.translatable("jei.bountifulfares.collect_using").append(recipe.getOutput().getItem().getCraftingRemainingItem().getDescription()));
        }
        if (mouseX >= 35 && mouseX <= 47 && mouseY >= 39 && mouseY <= 54) {
            int minutes = (int) Math.floor((double) Services.PLATFORM.getIntConfigValue("fermentationTime") / 60);
            int seconds = (int) Math.floor((double) Services.PLATFORM.getIntConfigValue("fermentationTime") - (minutes * 60));
            MutableComponent text = Component.literal("");
            if (minutes != 0) {
                text = text.append(minutes + " ").append(Component.translatable("jei.bountifulfares.minutes"));
            }
            if (minutes != 0 && seconds != 0) {
                text = text.append(", ");
            }
            if (seconds != 0) {
                text = text.append(seconds + " ").append(Component.translatable("jei.bountifulfares.seconds"));
            }
            tooltipStrings.add(text);
        }
        return tooltipStrings; //hovering over specific icons to display text (id suggest using it for the clock to show how long itll take and the water)
    }

    @Override
    public Component getTitle() {
        return Component.translatable("bountifulfares.fermenting");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return fermentationVessel;
    }
}
