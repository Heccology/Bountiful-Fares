package net.hecco.bountifulfares.registry.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.List;

import static net.minecraft.data.server.loottable.BlockLootTableGenerator.WITH_SHEARS;

public class BFLootTableModifiers {

    private static final RegistryKey<LootTable> SHORT_GRASS_ID = Blocks.SHORT_GRASS.getLootTableKey();
    private static final RegistryKey<LootTable> TALL_GRASS_ID = Blocks.TALL_GRASS.getLootTableKey();
    private static final RegistryKey<LootTable> FERN_ID = Blocks.FERN.getLootTableKey();
    private static final RegistryKey<LootTable> LARGE_FERN_ID = Blocks.LARGE_FERN.getLootTableKey();

    private static final RegistryKey<LootTable> GUARDIAN_ID = RegistryKey.of(
            RegistryKeys.LOOT_TABLE, Identifier.ofVanilla("entities/guardian"));
    private static final RegistryKey<LootTable> ELDER_GUARDIAN_ID = RegistryKey.of(
            RegistryKeys.LOOT_TABLE, Identifier.ofVanilla("entities/elder_guardian"));

    private static final RegistryKey<LootTable> SNIFFER_DIGGING_ID = LootTables.SNIFFER_DIGGING_GAMEPLAY;

    public static void modifyLootTables() {
        // Prefetch all config settings for easier read
        boolean do_lapisberries =                   BountifulFares.CONFIG.isEnableLapisberrySeeds();
        boolean do_hoaryseeds =                     BountifulFares.CONFIG.isEnableHoarySeeds();
        boolean do_spongekinseed_guardian =         BountifulFares.CONFIG.isEnableElderGuardianSpongekinSeeds();
        boolean do_spongekinseed_elderguardian =    BountifulFares.CONFIG.isEnableElderGuardianSpongekinSeeds();
        boolean do_grass_override =                 BountifulFares.CONFIG.isGrassLootTableOverride();

        // Short Grass
        LootTableEvents.REPLACE.register((key, original, source, wrapperLookup) -> {
            if (SHORT_GRASS_ID.equals(key) && do_grass_override) {
                return newGrassDropsShort(Blocks.SHORT_GRASS, BFItems.GRASS_SEEDS, wrapperLookup).build();
            }
            return null;
        });
        // Tall Grass
        LootTableEvents.REPLACE.register((key, original, source, wrapperLookup) -> {
            if (TALL_GRASS_ID.equals(key) && do_grass_override) {
                return newGrassDropsTall(Blocks.TALL_GRASS, Blocks.SHORT_GRASS, BFItems.GRASS_SEEDS).build();
            }
            return null;
        });
        // Short Fern
        LootTableEvents.REPLACE.register((key, original, source, wrapperLookup) -> {
            if (FERN_ID.equals(key) && do_grass_override) {
                return newGrassDropsShort(Blocks.FERN, BFItems.GRASS_SEEDS, wrapperLookup).build();
            }
            return null;
        });
        // Large Fern
        LootTableEvents.REPLACE.register((key, original, source, wrapperLookup) -> {
            if (LARGE_FERN_ID.equals(key) && do_grass_override) {
                return newGrassDropsTall(Blocks.LARGE_FERN, Blocks.FERN, BFItems.GRASS_SEEDS).build();
            }
            return null;
        });
        // Sniffer Digging table (registers only what is set in Config)
        LootTableEvents.MODIFY.register((key, tableBuilder, source, wrapperLookup) -> {
            if (SNIFFER_DIGGING_ID.equals(key)) {

                // Lapisberries
                if (do_lapisberries) tableBuilder.modifyPools(itemEntry -> {
                    itemEntry.with((ItemEntry.builder(BFItems.LAPISBERRY_SEEDS)).build());
                });

                // Hoary Seeds
                if (do_hoaryseeds) tableBuilder.modifyPools(itemEntry -> {
                    itemEntry.with((ItemEntry.builder(BFItems.HOARY_SEEDS)).build());
                });
            }
        });
        // Elder Guardian
        LootTableEvents.MODIFY.register((key, original, source, wrapperLookup) -> {
            if (ELDER_GUARDIAN_ID.equals(key) && do_spongekinseed_elderguardian) {
                original.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(BFItems.SPONGEKIN_SEEDS))
                );
            }
        });
        // Guardian
        LootTableEvents.MODIFY.register((key, original, source, wrapperLookup) -> {
            if (GUARDIAN_ID.equals(key) && do_spongekinseed_guardian) {
                original.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(BFItems.SPONGEKIN_SEEDS).weight(1))
                        .with(EmptyEntry.builder().weight(5))
                );
            }
        });
    }

    @Deprecated
    private static LootTable mergePools(LootTable lootTable, LootPool lootPool) {
        lootPool = LootPool.builder().with(lootTable.pools.getFirst().entries).with(lootPool.entries).build();
        return LootTable.builder().pools(List.of(lootPool)).build();
    }

    /** A hacky, yet functional method of rebuilding short grass drops. Contains an input for the seed to drop as well. */
    public static LootTable.Builder newGrassDropsShort(Block grass, Item seed, RegistryWrapper.WrapperLookup wrapper) {

        RegistryWrapper.Impl<Enchantment> impl = wrapper.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        return LootTable.builder().pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .with(ItemEntry.builder(grass)
                                .conditionally(WITH_SHEARS)
                                .alternatively(ItemEntry.builder(seed)
                                        .conditionally(RandomChanceLootCondition.builder(0.125F))
                                        .apply(ExplosionDecayLootFunction.builder())
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 2)))
                )
        );
    }

    /** A method of rebuilding tall grass drops. Contains an input for the seed to drop as well. */
    public static LootTable.Builder newGrassDropsTall(Block tallPlant, Block shortPlant, Item seed) {
        LootPoolEntry.Builder<?> builder = ItemEntry.builder(shortPlant)
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0F)))
                .conditionally(WITH_SHEARS)
                .alternatively(
                        (ItemEntry.builder(seed)
                                .conditionally(SurvivesExplosionLootCondition.builder())
                                .conditionally(RandomChanceLootCondition.builder(0.125F)))
                );
        return LootTable.builder()
                .pool(
                        LootPool.builder()
                                .with(builder)
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(tallPlant).properties(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.LOWER))
                                )
                                .conditionally(
                                        LocationCheckLootCondition.builder(
                                                LocationPredicate.Builder.create()
                                                        .block(BlockPredicate.Builder.create().blocks(tallPlant).state(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.UPPER))),
                                                new BlockPos(0, 1, 0)
                                        )
                                )
                )
                .pool(
                        LootPool.builder()
                                .with(builder)
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(tallPlant).properties(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.UPPER))
                                )
                                .conditionally(
                                        LocationCheckLootCondition.builder(
                                                LocationPredicate.Builder.create()
                                                        .block(BlockPredicate.Builder.create().blocks(tallPlant).state(StatePredicate.Builder.create().exactMatch(TallPlantBlock.HALF, DoubleBlockHalf.LOWER))),
                                                new BlockPos(0, -1, 0)
                                        )
                                )
                );
    }
}
