package net.hecco.bountifulfares.registry;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import static net.minecraft.data.loot.BlockLootSubProvider.HAS_SHEARS;

public class BFFabricLootTableModifiers {

    private static final ResourceKey<LootTable> SHORT_GRASS_ID = Blocks.SHORT_GRASS.getLootTable();
    private static final ResourceKey<LootTable> TALL_GRASS_ID = Blocks.TALL_GRASS.getLootTable();
    private static final ResourceKey<LootTable> FERN_ID = Blocks.FERN.getLootTable();
    private static final ResourceKey<LootTable> LARGE_FERN_ID = Blocks.LARGE_FERN.getLootTable();

    private static final ResourceKey<LootTable> GUARDIAN_ID = ResourceKey.create(
            Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/guardian"));

    private static final ResourceKey<LootTable> SNIFFER_DIGGING_ID = BuiltInLootTables.SNIFFER_DIGGING;

    public static void modifyLootTables() {
        // Prefetch all config settings for easier read
        boolean do_lapisberries =                   Services.PLATFORM.getBoolConfigValue("enableLapisberrySeeds");
        boolean do_hoaryseeds =                     Services.PLATFORM.getBoolConfigValue("enableHoarySeeds");
        boolean do_spongekinseed_guardian =         Services.PLATFORM.getBoolConfigValue("enableGuardianSpongekinSeeds");
        boolean do_grass_override =                 Services.PLATFORM.getBoolConfigValue("grassLootTableOverride");

        // Short Grass
        LootTableEvents.REPLACE.register((key, original, source, wrapperLookup) -> {
            if (SHORT_GRASS_ID.equals(key) && do_grass_override) {
                LootTable.Builder builder = newGrassDropsShort(Blocks.SHORT_GRASS, BFItems.GRASS_SEEDS.get(), wrapperLookup);
                if (HLServices.PLATFORM.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID))
                {
                    builder = addFDStraw(builder);
                }
                return builder.build();
            }
            return null;
        });
        // Tall Grass
        LootTableEvents.REPLACE.register((key, original, source, wrapperLookup) -> {
            if (TALL_GRASS_ID.equals(key) && do_grass_override) {
                LootTable.Builder builder = newGrassDropsTall(Blocks.TALL_GRASS, Blocks.SHORT_GRASS, BFItems.GRASS_SEEDS.get());
                if (HLServices.PLATFORM.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID))
                {
                    builder = addFDStraw(builder);
                }
                return builder.build();
            }
            return null;
        });
        // Short Fern
        LootTableEvents.REPLACE.register((key, original, source, wrapperLookup) -> {
            if (FERN_ID.equals(key) && do_grass_override) {
                LootTable.Builder builder = newGrassDropsShort(Blocks.FERN, BFItems.GRASS_SEEDS.get(), wrapperLookup);
                if (HLServices.PLATFORM.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID))
                {
                    builder = addFDStraw(builder);
                }
                return builder.build();
            }
            return null;
        });
        // Large Fern
        LootTableEvents.REPLACE.register((key, original, source, wrapperLookup) -> {
            if (LARGE_FERN_ID.equals(key) && do_grass_override) {
                LootTable.Builder builder = newGrassDropsTall(Blocks.LARGE_FERN, Blocks.FERN, BFItems.GRASS_SEEDS.get());
                if (HLServices.PLATFORM.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID))
                {
                    builder = addFDStraw(builder);
                }
                return builder.build();
            }
            return null;
        });
        // Sniffer Digging table (registers only what is set in Config)
        LootTableEvents.MODIFY.register((key, tableBuilder, source, wrapperLookup) -> {
            if (SNIFFER_DIGGING_ID.equals(key)) {

                // Lapisberries
                if (do_lapisberries) tableBuilder.modifyPools(itemEntry -> {
                    itemEntry.with((LootItem.lootTableItem(BFItems.LAPISBERRY_SEEDS.get())).build());
                });

                // Hoary Seeds
                if (do_hoaryseeds) tableBuilder.modifyPools(itemEntry -> {
                    itemEntry.with((LootItem.lootTableItem(BFItems.HOARY_SEEDS.get())).build());
                });
            }
        });
//        // Elder Guardian
//        LootTableEvents.MODIFY.register((key, original, source, wrapperLookup) -> {
//            if (ELDER_GUARDIAN_ID.equals(key) && do_spongekinseed_elderguardian) {
//                original.withPool(LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1.0F))
//                        .add(LootItem.lootTableItem(BFItems.SPONGEKIN_SEEDS.get()))
//                );
//            }
//        });
        // Guardian
        LootTableEvents.MODIFY.register((key, original, source, wrapperLookup) -> {
            if (GUARDIAN_ID.equals(key) && do_spongekinseed_guardian) {
                original.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(BFItems.SPONGEKIN_SEEDS.get()).setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(5))
                );
            }
        });
    }

//    @Deprecated
//    private static LootTable mergePools(LootTable lootTable, LootPool lootPool) {
//        lootPool = LootPool.lootPool().with(lootTable.pools.getFirst().entries).with(lootPool.entries).build();
//        return LootTable.lootTable().pools(List.of(lootPool)).build();
//    }

    /** A hacky, yet functional method of rebuilding short grass drops. Contains an input for the seed to drop as well. */
    public static LootTable.Builder newGrassDropsShort(Block grass, Item seed, HolderLookup.Provider wrapper) {

        HolderLookup.RegistryLookup<Enchantment> impl = wrapper.lookupOrThrow(Registries.ENCHANTMENT);

        return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(grass)
                                .when(HAS_SHEARS)
                                .otherwise(LootItem.lootTableItem(seed)
                                        .when(LootItemRandomChanceCondition.randomChance(0.125F))
                                        .apply(ApplyExplosionDecay.explosionDecay())
                                        .apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 2)))
                )
        );
    }

    /** A method of rebuilding tall grass drops. Contains an input for the seed to drop as well. */
    public static LootTable.Builder newGrassDropsTall(Block tallPlant, Block shortPlant, Item seed) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(shortPlant)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))
                .when(HAS_SHEARS)
                .otherwise(
                        (LootItem.lootTableItem(seed)
                                .when(ExplosionCondition.survivesExplosion())
                                .when(LootItemRandomChanceCondition.randomChance(0.125F)))
                );
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .add(builder)
                                .when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(tallPlant).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))
                                )
                                .when(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location()
                                                        .setBlock(BlockPredicate.Builder.block().of(tallPlant).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))),
                                                new BlockPos(0, 1, 0)
                                        )
                                )
                )
                .withPool(
                        LootPool.lootPool()
                                .add(builder)
                                .when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(tallPlant).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))
                                )
                                .when(
                                        LocationCheck.checkLocation(
                                                LocationPredicate.Builder.location()
                                                        .setBlock(BlockPredicate.Builder.block().of(tallPlant).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))),
                                                new BlockPos(0, -1, 0)
                                        )
                                )
                );
    }

    /** Reimplements straw grabbing in FD. Lazy workaround, but the disabling of the feature entirely still works. */
    public static LootTable.Builder addFDStraw(LootTable.Builder builder)
    {
        return builder.withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.FARMERS_DELIGHT_MOD_ID, "straw")))
                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(
                                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BountifulFares.FARMERS_DELIGHT_MOD_ID, "straw_harvesters")))
                                )
                        )
                )
        );
    }
}
