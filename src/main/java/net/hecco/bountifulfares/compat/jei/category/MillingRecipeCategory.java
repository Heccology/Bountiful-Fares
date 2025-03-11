package net.hecco.bountifulfares.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.jei.BFRecipeTypes;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("removal")
public class MillingRecipeCategory implements IRecipeCategory<MillingRecipe> {
    private final IDrawable icon;
    private final IDrawable background;

    public MillingRecipeCategory(IGuiHelper helper) {
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BFBlocks.GRISTMILL.asItem()));
        Identifier backgroundImage = Identifier.of(BountifulFares.MOD_ID, "textures/gui/jei/milling.png");
        background = helper.createDrawable(backgroundImage, 0, 0, 105, 36);
    }

    @Override
    public RecipeType<MillingRecipe> getRecipeType() {
        return BFRecipeTypes.MILLING;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MillingRecipe recipe, IFocusGroup focusGroup) {
        Ingredient recipeIngredients = recipe.getIngredient();
        ItemStack resultStack = recipe.getOutput();

        builder.addSlot(RecipeIngredientRole.INPUT, 7, 10).addItemStack(recipeIngredients.getMatchingStacks()[0]);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 79, 10).addItemStack(resultStack);
    }

//    @Override
//    public List<Text> getTooltipStrings(FermentationRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
//        List<Text> tooltipStrings = new ArrayList<>();
//        if (recipe.getOutput().getRecipeRemainder().getItem() != Items.AIR && mouseX >= 67 && mouseX <= 75 && mouseY >= 33 && mouseY <= 44) {
//            tooltipStrings.add(Text.translatable("jei.bountifulfares.collect_using").append(recipe.getOutput().getRecipeRemainder().getName()));
//        }
//        if (mouseX >= 35 && mouseX <= 47 && mouseY >= 39 && mouseY <= 54) {
//            int minutes = (int) Math.floor((double) BountifulFares.CONFIG.getFermentationTime() / 60);
//            int seconds = (int) Math.floor((double) BountifulFares.CONFIG.getFermentationTime() - (minutes * 60));
//            MutableText text = Text.literal("");
//            if (minutes != 0) {
//                text = text.append(minutes + " ").append(Text.translatable("jei.bountifulfares.minutes"));
//            }
//            if (minutes != 0 && seconds != 0) {
//                text = text.append(", ");
//            }
//            if (seconds != 0) {
//                text = text.append(seconds + " ").append(Text.translatable("jei.bountifulfares.seconds"));
//            }
//            tooltipStrings.add(text);
//        }
//        return tooltipStrings; //hovering over specific icons to display text (id suggest using it for the clock to show how long itll take and the water)
//    }

    @Override
    public Text getTitle() {
        return Text.translatable("bountifulfares.milling");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }
}
