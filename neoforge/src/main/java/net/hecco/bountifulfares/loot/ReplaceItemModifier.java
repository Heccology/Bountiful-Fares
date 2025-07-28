package net.hecco.bountifulfares.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ReplaceItemModifier extends LootModifier {
    public static final Supplier<MapCodec<ReplaceItemModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(modifierInstance -> codecStart(modifierInstance).and(modifierInstance.group(BuiltInRegistries.ITEM.byNameCodec().fieldOf("removed_item").forGetter((m) -> m.removedItem), BuiltInRegistries.ITEM.byNameCodec().fieldOf("added_item").forGetter((m) -> m.addedItem), Codec.INT.optionalFieldOf("count", 1).forGetter((m) -> m.addedCount))).apply(modifierInstance, ReplaceItemModifier::new)));

    private final Item removedItem;
    private final Item addedItem;
    private final int addedCount;

    protected ReplaceItemModifier(LootItemCondition[] lootItemConditions, Item removeditem, Item addedItem, int count) {
        super(lootItemConditions);
        this.removedItem = removeditem;
        this.addedItem = addedItem;
        this.addedCount = count;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> stacks, LootContext ctx) {
        ItemStack addedStack = new ItemStack(addedItem, addedCount);
        stacks.forEach((item) -> {
            if (item.is(removedItem)) {
                stacks.remove(item);
            }
        });
        if (addedStack.getCount() < addedStack.getMaxStackSize()) {
            stacks.add(addedStack);
        } else {
            int i = addedStack.getCount();

            while (i > 0) {
                ItemStack subStack = addedStack.copy();
                subStack.setCount(Math.min(addedStack.getMaxStackSize(), i));
                i -= subStack.getCount();
                stacks.add(subStack);
            }
        }
        return stacks;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}