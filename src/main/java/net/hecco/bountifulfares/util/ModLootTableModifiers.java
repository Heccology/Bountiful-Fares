package net.hecco.bountifulfares.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    private static final Identifier SNIFFER_DIGGING_ID = new Identifier("minecraft", "gameplay/sniffer_digging");
    private static final Identifier ELDER_GUARDIAN_ID = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier GUARDIAN_ID = new Identifier("minecraft", "entities/guardian");
    public static void modifyLootTables() {
        if (BountifulFares.CONFIG.isEnableLapisberrySeeds()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && SNIFFER_DIGGING_ID.equals(id)) {
                    tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(ModItems.LAPISBERRY_SEEDS)));
                }
            });
        }
        if (BountifulFares.CONFIG.isEnableHoarySeeds()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && SNIFFER_DIGGING_ID.equals(id)) {
                    tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(ModItems.HOARY_SEEDS)));
                }
            });
        }
        if (BountifulFares.CONFIG.isEnableElderGuardianSpongekinSeeds()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (source.isBuiltin() && ELDER_GUARDIAN_ID.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .with(ItemEntry.builder(ModItems.SPONGEKIN_SEEDS));

                    tableBuilder.pool(poolBuilder);
                }
            });
        }
        if (BountifulFares.CONFIG.isEnableGuardianSpongekinSeeds()) {
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
}
