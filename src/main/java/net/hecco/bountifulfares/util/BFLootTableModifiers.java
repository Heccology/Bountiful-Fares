package net.hecco.bountifulfares.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.item.BFItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

import java.util.List;

public class BFLootTableModifiers {

    private static final Identifier GRASS_ID = Identifier.of("minecraft", "blocks/grass");
    private static final Identifier TALL_GRASS_ID = Identifier.of("minecraft", "blocks/tall_grass");
    private static final Identifier FERN_ID = Identifier.of("minecraft", "blocks/fern");
    private static final Identifier LARGE_FERN_ID = Identifier.of("minecraft", "blocks/large_fern");
    private static final Identifier SNIFFER_DIGGING_ID = Identifier.of("minecraft", "gameplay/sniffer_digging");
    private static final Identifier ELDER_GUARDIAN_ID = Identifier.of("minecraft", "entities/elder_guardian");
    private static final Identifier GUARDIAN_ID = Identifier.of("minecraft", "entities/guardian");
    public static void modifyLootTables() {
        LootTableEvents.REPLACE.register((key, original, source) -> {
            if (GRASS_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(BFItems.GRASS_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5));

                return mergePools(original, poolBuilder.build());
            }
            return original;
        });
        LootTableEvents.REPLACE.register((key, original, source) -> {
            if (TALL_GRASS_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(BFItems.GRASS_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5));

                return mergePools(original, poolBuilder.build());
            }
            return original;
        });
        LootTableEvents.REPLACE.register((key, original, source) -> {
            if (FERN_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(BFItems.GRASS_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5));

                return mergePools(original, poolBuilder.build());
            }
            return original;
        });
        LootTableEvents.REPLACE.register((key, original, source) -> {
            if (LARGE_FERN_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(BFItems.GRASS_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5));

                return mergePools(original, poolBuilder.build());
            }
            return original;
        });
        if (BountifulFares.CONFIG.isEnableLapisberrySeeds()) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
                if (SNIFFER_DIGGING_ID.equals(key.getValue())) {
                    tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(BFItems.LAPISBERRY_SEEDS)));
                }
            });
        }
        if (BountifulFares.CONFIG.isEnableHoarySeeds()) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
                if (SNIFFER_DIGGING_ID.equals(key.getValue())) {
                    tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(BFItems.HOARY_SEEDS)));
                }
            });
        }
        if (BountifulFares.CONFIG.isEnableElderGuardianSpongekinSeeds()) {
            LootTableEvents.REPLACE.register((key, original, source) -> {
                if (ELDER_GUARDIAN_ID.equals(key.getValue())) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(BFItems.SPONGEKIN_SEEDS));

                    return mergePools(original, poolBuilder.build());
                }
                return original;
            });
        }
        if (BountifulFares.CONFIG.isEnableGuardianSpongekinSeeds()) {
            LootTableEvents.REPLACE.register((key, original, source) -> {
                if (GUARDIAN_ID.equals(key.getValue())) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(BFItems.SPONGEKIN_SEEDS).weight(1))
                            .with(EmptyEntry.builder().weight(5));

                    return mergePools(original, poolBuilder.build());
                }
                return original;
            });
        }
    }
    private static LootTable mergePools(LootTable lootTable, LootPool lootPool) {
        lootPool = LootPool.builder().with(lootTable.pools.getFirst().entries).with(lootPool.entries).build();
        return LootTable.builder().pools(List.of(lootPool)).build();
    }
}
