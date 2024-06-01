package net.hecco.bountifulfares.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.item.BFItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class BFLootTableModifiers {

    private static final Identifier GRASS_ID = new Identifier("minecraft", "blocks/grass");
    private static final Identifier TALL_GRASS_ID = new Identifier("minecraft", "blocks/tall_grass");
    private static final Identifier FERN_ID = new Identifier("minecraft", "blocks/fern");
    private static final Identifier LARGE_FERN_ID = new Identifier("minecraft", "blocks/large_fern");
    private static final Identifier SNIFFER_DIGGING_ID = new Identifier("minecraft", "gameplay/sniffer_digging");
    private static final Identifier ELDER_GUARDIAN_ID = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier GUARDIAN_ID = new Identifier("minecraft", "entities/guardian");
    public static void modifyLootTables() {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && GRASS_ID.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(BFItems.GRASS_SEEDS).weight(1))
                            .with(EmptyEntry.builder().weight(5));

                    tableBuilder.pool(poolBuilder);
                }
            });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && TALL_GRASS_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(BFItems.GRASS_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5));

                tableBuilder.pool(poolBuilder);
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && FERN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(BFItems.GRASS_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5));

                tableBuilder.pool(poolBuilder);
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LARGE_FERN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(BFItems.GRASS_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5));

                tableBuilder.pool(poolBuilder);
            }
        });
        if (BountifulFares.CONFIG.isEnableLapisberrySeeds()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && SNIFFER_DIGGING_ID.equals(id)) {
                    tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(BFItems.LAPISBERRY_SEEDS)));
                }
            });
        }
        if (BountifulFares.CONFIG.isEnableHoarySeeds()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && SNIFFER_DIGGING_ID.equals(id)) {
                    tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(BFItems.HOARY_SEEDS)));
                }
            });
        }
        if (BountifulFares.CONFIG.isEnableElderGuardianSpongekinSeeds()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && ELDER_GUARDIAN_ID.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(BFItems.SPONGEKIN_SEEDS));

                    tableBuilder.pool(poolBuilder);
                }
            });
        }
        if (BountifulFares.CONFIG.isEnableGuardianSpongekinSeeds()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && GUARDIAN_ID.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(BFItems.SPONGEKIN_SEEDS).weight(1))
                            .with(EmptyEntry.builder().weight(5));

                    tableBuilder.pool(poolBuilder);
                }
            });
        }
    }
}
