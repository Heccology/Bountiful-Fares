package net.hecco.bountifulfares.definition.compat.emi;

import com.google.common.collect.Lists;
import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.VanillaEmiRecipeCategories;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.SlotWidget;
import dev.emi.emi.api.widget.WidgetHolder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.compat.emi.BFEmiRecipeCategories;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.definition.recipe.FermentationRecipe;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/*
Taken from EmiWorldInteractionRecipe since extending it causes a harder implementation
NOTE: this can (and probably should) be simplified, but for now this allows for any amount
of inputs and outputs for a fermentation recipe, may be useful in the future so i don't want to remove it
 */
public class EmiFermentationRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final List<EmiFermentationRecipe.WorldIngredient> left;
    private final List<EmiFermentationRecipe.WorldIngredient> right;
    private final List<EmiFermentationRecipe.WorldIngredient> outputIngredients;
    private final List<EmiIngredient> inputs;
    private final List<EmiIngredient> catalysts;
    private final List<EmiStack> outputs;
    private final boolean supportsRecipeTree;
    private final int slotHeight;
    private int width = 125;
    private int height;
    private int totalSize;
    private int leftSize;
    private int rightSize;
    private int outputSize;
    private int leftHeight;
    private int rightHeight;
    private int outputHeight;

    protected EmiFermentationRecipe(EmiFermentationRecipe.Builder builder) {
        this.id = builder.id;
        this.left = builder.left;
        this.right = builder.right;
        this.inputs = Stream.concat(this.left.stream(), this.right.stream()).filter((i) -> !i.catalyst).map((i) -> i.stack).toList();
        this.catalysts = Stream.concat(this.left.stream(), this.right.stream()).filter((i) -> i.catalyst).map((i) -> i.stack).toList();
        this.outputIngredients = builder.output;
        this.outputs = builder.output.stream().map((i) -> (EmiStack)i.stack).toList();
        this.supportsRecipeTree = builder.supportsRecipeTree;

        for(EmiIngredient catalyst : this.catalysts) {
            for(EmiStack stack : catalyst.getEmiStacks()) {
                if (stack.getRemainder().isEmpty()) {
                    stack.setRemainder(stack.copy());
                }
            }
        }

        this.totalSize = this.left.size() + this.right.size() + this.outputs.size();
        if (this.totalSize > 5) {
            int[] portions = new int[]{this.left.size(), this.right.size(), this.outputs.size()};
            int[] sizes = new int[]{1, 1, 1};

            for(int i = 0; i < 2; ++i) {
                int largest = portions[0];
                int li = 0;

                for(int j = 1; j < 3; ++j) {
                    if (portions[j] >= largest) {
                        largest = portions[j];
                        li = j;
                    }
                }

                int var10002 = sizes[li]++;
                portions[li] = portions[li] * 2 / 3;
            }

            this.leftSize = sizes[0];
            this.rightSize = sizes[1];
            this.outputSize = sizes[2];
        } else {
            this.leftSize = this.left.size();
            this.rightSize = this.right.size();
            this.outputSize = this.outputs.size();
        }

        this.leftHeight = (this.left.size() - 1) / this.leftSize + 1;
        this.rightHeight = (this.right.size() - 1) / this.rightSize + 1;
        this.outputHeight = (this.outputs.size() - 1) / this.outputSize + 1;
        this.slotHeight = Math.max(this.leftHeight, Math.max(this.rightHeight, this.outputHeight));
        this.height = this.slotHeight * 18;
        if (this.totalSize > 4) {
            this.width = 134;
        }

    }

    public static EmiFermentationRecipe.Builder builder() {
        return new EmiFermentationRecipe.Builder();
    }

    /*
    quick way to build a usual fermentation recipe, if you don't want to do crazy stuff
    with a regular builder (since it was meant for world interaction recipes
    thus it is more flexible)
     */
    public static EmiFermentationRecipe quickBuild(FermentationRecipe recipe) {
        return builder()
                .id(EmiPort.getId(recipe))
                .output(EmiStack.of(recipe.getOutput()))
                .leftInput(EmiStack.of(BFBlocks.FERMENTATION_VESSEL.get()))
                .rightInput(EmiIngredient.of(BFItemTags.FERMENTATION_WATER_SOURCES), false)
                .rightInput(EmiIngredient.of(recipe.getIngredient()), false).build();
    }

    public EmiRecipeCategory getCategory() {
        return BFEmiRecipeCategories.FERMENTING;
    }

    public @Nullable ResourceLocation getId() {
        return this.id;
    }

    public List<EmiIngredient> getInputs() {
        return this.inputs;
    }

    public List<EmiIngredient> getCatalysts() {
        return this.catalysts;
    }

    public List<EmiStack> getOutputs() {
        return this.outputs;
    }

    public boolean supportsRecipeTree() {
        return this.supportsRecipeTree;
    }

    public int getDisplayWidth() {
        return this.width;
    }

    public int getDisplayHeight() {
        return this.height;
    }

    public void addWidgets(WidgetHolder widgets) {
        int lr = this.leftSize * 18;
        int ol = this.width - this.outputSize * 18;
        int rl = (lr + ol) / 2 - this.rightSize * 9 - 4;
        int rr = rl + this.rightSize * 18;
        widgets.addTexture(EmiTexture.PLUS, (lr + rl) / 2 - EmiTexture.PLUS.width / 2, -6 + this.slotHeight * 9);
        widgets.addTexture(EmiTexture.EMPTY_ARROW, (rr + ol) / 2 - EmiTexture.EMPTY_ARROW.width / 2, -8 + this.slotHeight * 9)
                .tooltip((mx, my) -> List.of(ClientTooltipComponent.create(EmiPort.ordered(EmiPort.translatable("emi.cooking.time", Services.PLATFORM.get().getIntConfigValue("fermentationTime"))))));
        int yo = (this.slotHeight - this.leftHeight) * 9;

        for(int i = 0; i < this.left.size(); ++i) {
            EmiFermentationRecipe.WorldIngredient wi = (EmiFermentationRecipe.WorldIngredient)this.left.get(i);
            widgets.add((SlotWidget)wi.mutator.apply(new SlotWidget(wi.stack, i % this.leftSize * 18, yo + i / this.leftSize * 18)));
        }

        yo = (this.slotHeight - this.rightHeight) * 9;

        for(int i = 0; i < this.right.size(); ++i) {
            EmiFermentationRecipe.WorldIngredient wi = (EmiFermentationRecipe.WorldIngredient)this.right.get(i);
            widgets.add((SlotWidget)wi.mutator.apply((new SlotWidget(wi.stack, rl + i % this.rightSize * 18, yo + i / this.rightSize * 18)).catalyst(wi.catalyst)));
        }

        yo = (this.slotHeight - this.outputHeight) * 9;

        for(int i = 0; i < this.outputIngredients.size(); ++i) {
            EmiFermentationRecipe.WorldIngredient wi = (EmiFermentationRecipe.WorldIngredient)this.outputIngredients.get(i);
            widgets.add(((SlotWidget)wi.mutator.apply(new SlotWidget(wi.stack, ol + i % this.outputSize * 18, yo + i / this.outputSize * 18))).recipeContext(this));
        }
    }

    public static class Builder {
        private final List<EmiFermentationRecipe.WorldIngredient> left = Lists.newArrayList();
        private final List<EmiFermentationRecipe.WorldIngredient> right = Lists.newArrayList();
        private final List<EmiFermentationRecipe.WorldIngredient> output = Lists.newArrayList();
        private boolean supportsRecipeTree = true;
        private ResourceLocation id = null;

        private Builder() {
        }

        public EmiFermentationRecipe build() {
            if (this.left.isEmpty()) {
                throw new IllegalStateException("Cannot create a world interaction recipe without a left input");
            } else if (this.right.isEmpty()) {
                throw new IllegalStateException("Cannot create a world interaction recipe without a right input");
            } else if (this.output.isEmpty()) {
                throw new IllegalStateException("Cannot create a world interaction recipe without an output");
            } else {
                return new EmiFermentationRecipe(this);
            }
        }

        public EmiFermentationRecipe.Builder id(ResourceLocation id) {
            this.id = id;
            return this;
        }

        public EmiFermentationRecipe.Builder leftInput(EmiIngredient stack) {
            this.left.add(new EmiFermentationRecipe.WorldIngredient(stack, false, (s) -> s));
            return this;
        }

        public EmiFermentationRecipe.Builder leftInput(EmiIngredient stack, Function<SlotWidget, SlotWidget> mutator) {
            this.left.add(new EmiFermentationRecipe.WorldIngredient(stack, false, mutator));
            return this;
        }

        public EmiFermentationRecipe.Builder rightInput(EmiIngredient stack, boolean catalyst) {
            this.right.add(new EmiFermentationRecipe.WorldIngredient(stack, catalyst, (s) -> s));
            return this;
        }

        public EmiFermentationRecipe.Builder rightInput(EmiIngredient stack, boolean catalyst, Function<SlotWidget, SlotWidget> mutator) {
            this.right.add(new EmiFermentationRecipe.WorldIngredient(stack, catalyst, mutator));
            return this;
        }

        public EmiFermentationRecipe.Builder output(EmiStack stack) {
            this.output.add(new EmiFermentationRecipe.WorldIngredient(stack, false, (s) -> s));
            return this;
        }

        public EmiFermentationRecipe.Builder output(EmiStack stack, Function<SlotWidget, SlotWidget> mutator) {
            this.output.add(new EmiFermentationRecipe.WorldIngredient(stack, false, mutator));
            return this;
        }

        public EmiFermentationRecipe.Builder supportsRecipeTree(boolean supportsRecipeTree) {
            this.supportsRecipeTree = supportsRecipeTree;
            return this;
        }
    }

    private record WorldIngredient(EmiIngredient stack, boolean catalyst, Function<SlotWidget, SlotWidget> mutator) { }
}