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
import net.hecco.bountifulfares.compat.jei.PropagationRecipe;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("removal")
public class PrismarinePropagationCategory implements IRecipeCategory<PropagationRecipe> {
    private final IDrawable icon;
    private final IDrawable background;

    public PrismarinePropagationCategory(IGuiHelper helper) {
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BFBlocks.PRISMARINE_BLOSSOM));
        Identifier backgroundImage = Identifier.of(BountifulFares.MOD_ID, "textures/gui/jei/propagation.png");
        background = helper.createDrawable(backgroundImage, 0, 0, 92, 49);
    }

    @Override
    public RecipeType<PropagationRecipe> getRecipeType() {
        return BFRecipeTypes.PRISMARINE_PROPAGATION;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PropagationRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 6).addItemStack(BFItems.SPONGEKIN_SEEDS.getDefaultStack());
        builder.addSlot(RecipeIngredientRole.CATALYST, 27, 27).addItemStacks(Registries.BLOCK.getEntryList(
                BFBlockTags.PRISMARINE_PROPAGATION_SUBSTRATE)
                .map(tag -> tag.stream()
                        .map(RegistryEntry::value)
                        .map(block -> block.asItem().getDefaultStack())
                        .collect(Collectors.toList()))
                .orElse(List.of()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 70, 6).addItemStack(BFBlocks.PRISMARINE_BLOSSOM.asItem().getDefaultStack());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 70, 27).addItemStack(BFBlocks.SPONGEKIN.asItem().getDefaultStack());
    }

    @Override
    public Text getTitle() {
        return Text.translatable("bountifulfares.prismarine_propagation");
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
