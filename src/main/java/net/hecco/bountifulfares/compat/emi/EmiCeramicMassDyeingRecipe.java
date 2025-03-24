package net.hecco.bountifulfares.compat.emi;

import com.google.common.collect.Lists;
import dev.emi.emi.api.recipe.EmiPatternCraftingRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.GeneratedSlotWidget;
import dev.emi.emi.api.widget.SlotWidget;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmiCeramicMassDyeingRecipe extends EmiPatternCraftingRecipe {
    private static final List<DyeItem> DYES = Stream.of(DyeColor.values()).map(DyeItem::byColor).filter(c -> !(Registries.ITEM.getId(c).equals(Identifier.of("unidye", "custom_dye")))).toList();
    private final ItemConvertible ceramicItem;

    public EmiCeramicMassDyeingRecipe(ItemConvertible ceramicItem, Identifier id) {
        super(List.of(
                EmiIngredient.of(DYES.stream().map(i -> (EmiIngredient) EmiStack.of(i)).collect(Collectors.toList())),
                        EmiStack.of(ceramicItem)),
                EmiStack.of(ceramicItem), id);
        this.ceramicItem = ceramicItem;
    }

    @Override
    public SlotWidget getInputWidget(int slot, int x, int y) {
        return new GeneratedSlotWidget(r -> {
            List<DyeItem> dyes = getDyes(r);
            int ceramicAmount = r.nextInt(2, 10 - dyes.size());
            if (slot < dyes.size()) {
                return EmiStack.of(dyes.get(slot));
            }else if(slot < dyes.size() + ceramicAmount){
                return EmiStack.of(getCeramicStack(r));
            }
            return EmiStack.EMPTY;
        }, unique, x, y);
    }

    @Override
    public SlotWidget getOutputWidget(int x, int y) {
        return new GeneratedSlotWidget(r -> {
            List<DyeItem> dyes = getDyes(r);
            int ceramicAmount = r.nextInt(2, 10 - dyes.size());
            EmiStack emiStack = EmiStack.of(DyedColorComponent.setColor(getCeramicStack(r), dyes));
            emiStack.setAmount(ceramicAmount);
            return emiStack;
        }, unique, x, y);
    }

    private List<DyeItem> getDyes(Random random) {
        List<DyeItem> dyes = Lists.newArrayList();
        int amount = random.nextInt(1,8);
        for (int i = 0; i < amount; i++) {
            dyes.add(DYES.get(random.nextInt(DYES.size())));
        }
        return dyes;
    }

    private ItemStack getCeramicStack(Random random) {
        random.nextInt(); //to set the random a bit off

        List<DyeItem> dyes = Lists.newArrayList();
        int amount = random.nextInt(1,4);
        for (int i = 0; i < amount; i++) {
            dyes.add(DYES.get(random.nextInt(DYES.size())));
        }
        return DyedColorComponent.setColor(new ItemStack(ceramicItem), dyes);
    }
}
