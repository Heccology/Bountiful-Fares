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
import net.hecco.bountifulfares.definition.compat.jei.BFRecipeTypes;
import net.hecco.bountifulfares.definition.compat.jei.PropagationRecipe;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("removal")
public class PrismarinePropagationCategory implements IRecipeCategory<net.hecco.bountifulfares.definition.compat.jei.PropagationRecipe> {
    private final IDrawable icon;
    private final IDrawable background;

    public PrismarinePropagationCategory(IGuiHelper helper) {
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BFBlocks.PRISMARINE_BLOSSOM.get()));
        ResourceLocation backgroundImage = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/jei/propagation.png");
        background = helper.createDrawable(backgroundImage, 0, 0, 92, 49);
    }

    @Override
    public RecipeType<PropagationRecipe> getRecipeType() {
        return BFRecipeTypes.PRISMARINE_PROPAGATION;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PropagationRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 6).addItemStack(BFItems.SPONGEKIN_SEEDS.get().getDefaultInstance());
        builder.addSlot(RecipeIngredientRole.CATALYST, 27, 27).addItemStacks(BuiltInRegistries.BLOCK.getTag(
                BFBlockTags.PRISMARINE_PROPAGATION_SUBSTRATE)
                .map(tag -> tag.stream()
                        .map(Holder::value)
                        .map(block -> block.asItem().getDefaultInstance())
                        .collect(Collectors.toList()))
                .orElse(List.of()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 70, 6).addItemStack(BFBlocks.PRISMARINE_BLOSSOM.get().asItem().getDefaultInstance());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 70, 27).addItemStack(BFBlocks.SPONGEKIN.get().asItem().getDefaultInstance());
    }

    @Override
    public Component getTitle() {
        return Component.translatable("bountifulfares.prismarine_propagation");
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
