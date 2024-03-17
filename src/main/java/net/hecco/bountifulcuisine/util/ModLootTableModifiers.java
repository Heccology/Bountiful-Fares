package net.hecco.bountifulcuisine.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {

    private static final Identifier SNIFFER_DIGGING_ID = new Identifier("minecraft", "gameplay/sniffer_digging");
    private static final Identifier ELDER_GUARDIAN_ID = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier GUARDIAN_ID = new Identifier("minecraft", "entities/guardian");
    public static void modifyLootTables() {
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
//            if(SNIFFER_DIGGING_ID.equals(id)) {
//                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
//                entries.add(ItemEntry.builder(ModItems.LAPISBERRY_SEEDS).build());
//                entries.add(ItemEntry.builder(ModItems.HOARY_SEEDS).build());
//                LootPool.Builder pool = LootPool.builder().with(entries);
//                return LootTable.builder().pool(pool).build();
//            }

            return null;
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && ELDER_GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.SPONGEKIN_SEEDS));

                tableBuilder.pool(poolBuilder);
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.SPONGEKIN_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5));

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
