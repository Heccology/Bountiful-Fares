package net.hecco.bountifulfares.compat.emi;

import dev.emi.emi.EmiPort;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class EmiPropagationRecipe implements EmiRecipe {
    private final ResourceLocation id =  EmiPort.id("bountifulfares", "/" + "prismarine_propagation"); //synthetic id because emi would complain otherwise
    private final List<EmiIngredient> inputs = List.of(EmiStack.of(BFItems.SPONGEKIN_SEEDS), EmiStack.of(Blocks.SEA_LANTERN));
    private final List<EmiStack> outputs = List.of(EmiStack.of(BFBlocks.SPONGEKIN), EmiStack.of(BFBlocks.PRISMARINE_BLOSSOM));

    public EmiPropagationRecipe() {
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return BFEmiRecipeCategories.PRISMARINE_PROPAGATION;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return inputs.subList(0,0);
        //i dont think i need to tell emi that lantern is an input as this would look like you actually spend the lantern on the craft, so instead this just gives seeds
    }

    @Override
    public List<EmiStack> getOutputs() {
        return outputs;
    }

    @Override
    public int getDisplayWidth() {
        return 92;
    }

    @Override
    public int getDisplayHeight() {
        return 49;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/jei/propagation.png"), 0, 0, 92, 49, 0, 0);
        //if you want you can add a tooltip to a certain part of a bg(which means you draw a part of bg on top of bg) (look at the next line) saying smth like "Plant seeds on a sea lantern"
//        widgets.addTexture(Identifier.of(BountifulFares.MOD_ID, "textures/gui/jei/propagation.png"), 26, 11, 14, 14, 26, 11)
//                .tooltip((mx, my) -> List.of(TooltipComponent.of(EmiPort.ordered(Text.literal("Hi i am a test tooltip appledog")))));
        widgets.addSlot(inputs.get(0), 5, 5);
        widgets.addSlot(inputs.get(1), 26, 26);
        widgets.addSlot(outputs.get(1), 69, 5).recipeContext(this);
        widgets.addSlot(outputs.get(0), 69, 26).recipeContext(this);
    }
}
