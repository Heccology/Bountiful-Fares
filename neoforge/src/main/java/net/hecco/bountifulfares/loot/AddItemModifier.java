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

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    public static final Supplier<MapCodec<AddItemModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(modifierInstance -> codecStart(modifierInstance).and(modifierInstance.group(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter((m) -> m.addedItem), Codec.INT.optionalFieldOf("count", 1).forGetter((m) -> m.count))).apply(modifierInstance, AddItemModifier::new)));

    private final Item addedItem;
    private final int count;

    protected AddItemModifier(LootItemCondition[] lootItemConditions, Item item, int count) {
        super(lootItemConditions);
        this.addedItem = item;
        this.count = count;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> stacks, LootContext ctx) {
        ItemStack addedStack = new ItemStack(addedItem, count);
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