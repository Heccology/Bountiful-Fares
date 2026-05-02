package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.definition.block.custom.PalmFrondBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.integration.DelicateDyesIntegration;
import net.hecco.bountifulfares.registry.integration.DungeonsDelightIntegration;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;


public class BFBlockLootTableProvider extends FabricBlockLootTableProvider {
    public static final ArrayList<Block> usedBlocks = new ArrayList<>();

//    public static final LootCondition.Builder WITH_FORTUNE = MatchToolLootCondition.builder(net.minecraft.predicate.item.ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(1))));
    public static final float[] PRISMARINE_DROP_CHANCE = new float[]{0.0F, 0.12F, 0.15F, 0.2F};
    public static final float[] FRUIT_SAPLING_DROP_CHANCE = new float[]{0.01F, 0.05F, 0.08F, 0.1F};
    public static final float[] FLOWERING_FRUIT_SAPLING_DROP_CHANCE = new float[]{0.1F, 0.12F, 0.15F, 0.2F};
    private static final float[] HOARY_LEAVES_SAPLING_CHANCE = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};

    public BFBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }


    @Override
    public void add(Block block, LootTable.Builder lootTable) {
        if(usedBlocks.contains(block)) {
            return;
        }
        super.add(block, lootTable);
        usedBlocks.add(block);
    }
    public static final float[] LEAVES_STICK_DROP_CHANCE = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};


    @Override
    public void generate() {
        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        add(BFBlocks.APPLE_LEAVES.get(), createLeavesDrops(BFBlocks.APPLE_LEAVES.get(), BFBlocks.APPLE_SAPLING.get(), FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.FLOWERING_APPLE_LEAVES.get(), createLeavesDrops(BFBlocks.FLOWERING_APPLE_LEAVES.get(), BFBlocks.APPLE_SAPLING.get(), FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.ORANGE_LEAVES.get(), createLeavesDrops(BFBlocks.ORANGE_LEAVES.get(), BFBlocks.ORANGE_SAPLING.get(), FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.FLOWERING_ORANGE_LEAVES.get(), createLeavesDrops(BFBlocks.FLOWERING_ORANGE_LEAVES.get(), BFBlocks.ORANGE_SAPLING.get(), FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.LEMON_LEAVES.get(), createLeavesDrops(BFBlocks.LEMON_LEAVES.get(), BFBlocks.LEMON_SAPLING.get(), FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.FLOWERING_LEMON_LEAVES.get(), createLeavesDrops(BFBlocks.FLOWERING_LEMON_LEAVES.get(), BFBlocks.LEMON_SAPLING.get(), FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.PLUM_LEAVES.get(), createLeavesDrops(BFBlocks.PLUM_LEAVES.get(), BFBlocks.PLUM_SAPLING.get(), FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.FLOWERING_PLUM_LEAVES.get(), createLeavesDrops(BFBlocks.FLOWERING_PLUM_LEAVES.get(), BFBlocks.PLUM_SAPLING.get(), FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.GOLDEN_APPLE_LEAVES.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .when(this.hasCShearsOrSilkTouch())
                .add(LootItem.lootTableItem(BFBlocks.GOLDEN_APPLE_LEAVES.get()))));
        add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .when(this.hasCShearsOrSilkTouch())
                .add(LootItem.lootTableItem(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get()))));

        dropOther(BFBlocks.HOARY_APPLE_SAPLING_CROP.get(), BFItems.HOARY_SEEDS.get());
        add(BFBlocks.HOARY_SLAB.get(), createSlabItemTable(BFBlocks.HOARY_SLAB.get()));
        add(BFBlocks.HOARY_DOOR.get(), createDoorTable(BFBlocks.HOARY_DOOR.get()));
        add(BFBlocks.HOARY_LEAVES.get(), createLeavesDrops(BFBlocks.HOARY_LEAVES.get(), BFBlocks.HOARY_APPLE_SAPLING.get(), HOARY_LEAVES_SAPLING_CHANCE));
        add(BFBlocks.WALNUT_SLAB.get(), createSlabItemTable(BFBlocks.WALNUT_SLAB.get()));
        add(BFBlocks.WALNUT_DOOR.get(), createDoorTable(BFBlocks.WALNUT_DOOR.get()));
        add(BFBlocks.WALNUT_LEAVES.get(), createLeavesDrops(BFBlocks.WALNUT_LEAVES.get(), BFBlocks.WALNUT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(BFBlocks.WILD_WHEAT.get(), WildCropDrops(Items.WHEAT_SEEDS, BFBlocks.WILD_WHEAT.get()));
        add(BFBlocks.WILD_CARROTS.get(), WildCropDrops(Items.CARROT, BFBlocks.WILD_CARROTS.get()));
        add(BFBlocks.WILD_POTATOES.get(), WildCropDrops(Items.POTATO, BFBlocks.WILD_POTATOES.get()));
        add(BFBlocks.WILD_BEETROOTS.get(), WildCropDrops(Items.BEETROOT_SEEDS, BFBlocks.WILD_BEETROOTS.get()));
        add(BFBlocks.WILD_LEEKS.get(), WildCropDrops(BFItems.LEEK_SEEDS.get(), BFBlocks.WILD_LEEKS.get()));
        add(BFBlocks.WILD_PASSION_FRUIT_VINE.get(), WildCropDrops(BFItems.PASSION_FRUIT.get(), BFBlocks.WILD_PASSION_FRUIT_VINE.get()));
        add(BFBlocks.WILD_ELDERBERRY_VINE.get(), WildCropDrops(BFItems.ELDERBERRIES.get(), BFBlocks.WILD_ELDERBERRY_VINE.get()));
        add(BFBlocks.WILD_MAIZE.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WILD_MAIZE)
//                                        .properties(StatePredicate.Builder.create().exactMatch(WildMaizeBlock.HALF, DoubleBlockHalf.LOWER)))
                        .when(this.doesNotHaveCShearsOrSilkTouch())
                        .add(this.applyExplosionDecay(BFBlocks.WILD_MAIZE.get(), LootItem.lootTableItem(BFItems.MAIZE_SEEDS.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WILD_MAIZE)
//                                        .properties(StatePredicate.Builder.create().exactMatch(WildMaizeBlock.HALF, DoubleBlockHalf.LOWER)))
                        .when(this.hasCShearsOrSilkTouch())
                        .add(this.applyExplosionDecay(BFBlocks.WILD_MAIZE.get(), LootItem.lootTableItem(BFBlocks.WILD_MAIZE.get())))));
        add(BFBlocks.MAIZE_CROP.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.MAIZE_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MaizeCropBlock.AGE, 7)))
                        .add(this.applyExplosionDecay(BFBlocks.MAIZE_CROP.get(), LootItem.lootTableItem(BFItems.MAIZE.get())))));
        add(BFBlocks.FELDSPAR_BRICK_SLAB.get(), createSlabItemTable(BFBlocks.FELDSPAR_BRICK_SLAB.get()));
        add(BFBlocks.TINGED_GLASS.get(), createSilkTouchOnlyTable(BFBlocks.TINGED_GLASS.get()));
        add(BFBlocks.SPONGEKIN_SPROUT.get(), block -> this.createSilkTouchOrCShearsDispatchTable(
                    block,
                    this.applyExplosionDecay(
                            block,
                            LootItem.lootTableItem(BFItems.SPONGEKIN_SEEDS.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))
                            )
                    )
            )
        );
        dropOther(BFBlocks.SPONGEKIN_SPROUT.get(), BFItems.SPONGEKIN_SEEDS.get());
        add(BFBlocks.PRISMARINE_BLOSSOM.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(this.doesNotHaveSilkTouch())
                        .add(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM.get(), LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS)).setWeight(4))
                        .add(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM.get(), LootItem.lootTableItem(Items.PRISMARINE_SHARD)).setWeight(2))
                        .add(EmptyLootItem.emptyItem().setWeight(2)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
//                        .conditionally(WITH_FORTUNE)
//                        .with(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_CRYSTALS)).weight(4))
//                            .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, PRISMARINE_DROP_CHANCE))
//                        .with(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_SHARD)).weight(2))
//                            .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, PRISMARINE_DROP_CHANCE)))
                )
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.hasSilkTouch())
                        .add(LootItem.lootTableItem(BFBlocks.PRISMARINE_BLOSSOM.get()))));
        add(BFBlocks.FALLEN_WALNUTS.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.FALLEN_WALNUTS.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.FallenWalnutsBlock.COUNT, 0)))
                        .add(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS.get(), LootItem.lootTableItem(BFItems.WALNUT.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.FALLEN_WALNUTS.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.FallenWalnutsBlock.COUNT, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS.get(), LootItem.lootTableItem(BFItems.WALNUT.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(5.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.FALLEN_WALNUTS.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.FallenWalnutsBlock.COUNT, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS.get(), LootItem.lootTableItem(BFItems.WALNUT.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(6.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.FALLEN_WALNUTS.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.FallenWalnutsBlock.COUNT, 3)))
                        .add(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS.get(), LootItem.lootTableItem(BFItems.WALNUT.get())))));

        add(BFBlocks.LEEKS.get(), createCropDrops(BFBlocks.LEEKS.get(), BFItems.LEEK.get(), BFItems.LEEK_SEEDS.get(), LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.LEEKS.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 7))));

        for (Supplier<Block> block : BFBlocks.JACK_O_STRAWS.values()) {
            jackOStrawDrops(block.get());
        }

        for (Supplier<Block> block : DelicateDyesIntegration.JACK_O_STRAWS.values()) {
            jackOStrawDrops(block.get());
        }

        for (Supplier<Block> block : BFBlocks.PICKETS.values()) {
            picketsDrops(block.get());
        }
        picketsDrops(BFBlocks.IRON_RAILING.get());

        picketsDrops(DungeonsDelightIntegration.STAINED_SCRAP_RAILING.get());
        //picketsDrops(BFBlocks.PICKETS.get("wormwood").get());

        add(BFBlocks.WALNUT_MULCH.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH.get(), LootItem.lootTableItem(BFBlocks.WALNUT_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH.get(), LootItem.lootTableItem(BFBlocks.WALNUT_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 3)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH.get(), LootItem.lootTableItem(BFBlocks.WALNUT_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 4)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH.get(), LootItem.lootTableItem(BFBlocks.WALNUT_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(5.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 5)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH.get(), LootItem.lootTableItem(BFBlocks.WALNUT_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(6.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 6)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH.get(), LootItem.lootTableItem(BFBlocks.WALNUT_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(7.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 7)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH.get(), LootItem.lootTableItem(BFBlocks.WALNUT_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(8.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 8)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH.get(), LootItem.lootTableItem(BFBlocks.WALNUT_MULCH.get())))));


        fruitBlockDrops(BFBlocks.APPLE_BLOCK.get(), Items.APPLE);
        fruitBlockDrops(BFBlocks.GOLDEN_APPLE_BLOCK.get(), Items.GOLDEN_APPLE);
        fruitBlockDrops(BFBlocks.ORANGE_BLOCK.get(), BFItems.ORANGE.get());
        fruitBlockDrops(BFBlocks.LEMON_BLOCK.get(), BFItems.LEMON.get());
        fruitBlockDrops(BFBlocks.PLUM_BLOCK.get(), BFItems.PLUM.get());
        fruitBlockDrops(BFBlocks.HOARY_APPLE_BLOCK.get(), BFItems.HOARY_APPLE.get());

        hangingFruitDrops(BFBlocks.HANGING_APPLE.get(), Items.APPLE);
        hangingFruitDrops(BFBlocks.HANGING_ORANGE.get(), BFItems.ORANGE.get());
        hangingFruitDrops(BFBlocks.HANGING_LEMON.get(), BFItems.LEMON.get());
        hangingFruitDrops(BFBlocks.HANGING_PLUM.get(), BFItems.PLUM.get());
        hangingFruitDrops(BFBlocks.HANGING_HOARY_APPLE.get(), BFItems.HOARY_APPLE.get());
        hangingFruitDrops(BFBlocks.HANGING_GOLDEN_APPLE.get(), Items.GOLDEN_APPLE);
        usedBlocks.add(BFBlocks.HANGING_WITHERED_GOLDEN_APPLE.get());
        add(BFBlocks.GRASSY_DIRT.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveSilkTouch())
                        .add(this.applyExplosionDecay(BFBlocks.GRASSY_DIRT.get(), LootItem.lootTableItem(Blocks.DIRT))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.hasSilkTouch())
                        .add(this.applyExplosionDecay(BFBlocks.GRASSY_DIRT.get(), LootItem.lootTableItem(BFBlocks.GRASSY_DIRT.get())))));
        add(BFBlocks.TEA_SHRUB.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.TEA_SHRUB.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.TeaShrubBlock.BERRIES, true)))
                        .add(this.applyExplosionDecay(BFBlocks.TEA_SHRUB.get(), LootItem.lootTableItem(BFItems.TEA_BERRIES.get())))
                ));

        add(BFBlocks.PALM_MULCH.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH.get(), LootItem.lootTableItem(BFBlocks.PALM_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH.get(), LootItem.lootTableItem(BFBlocks.PALM_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 3)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH.get(), LootItem.lootTableItem(BFBlocks.PALM_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 4)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH.get(), LootItem.lootTableItem(BFBlocks.PALM_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(5.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 5)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH.get(), LootItem.lootTableItem(BFBlocks.PALM_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(6.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 6)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH.get(), LootItem.lootTableItem(BFBlocks.PALM_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(7.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 7)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH.get(), LootItem.lootTableItem(BFBlocks.PALM_MULCH.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(8.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.MulchBlock.LAYERS, 8)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH.get(), LootItem.lootTableItem(BFBlocks.PALM_MULCH.get())))));
        add(BFBlocks.COIR_BRICK_SLAB.get(), createSlabItemTable(BFBlocks.COIR_BRICK_SLAB.get()));
        add(BFBlocks.COIR_BED.get(), (block) -> this.createSinglePropConditionTable(block, BedBlock.PART, BedPart.HEAD));
        add(BFBlocks.PALM_FROND.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_FROND.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.PalmFrondBlock.SIZE, 0)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_FROND.get(), LootItem.lootTableItem(BFItems.PALM_FROND.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_FROND.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.PalmFrondBlock.SIZE, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_FROND.get(), LootItem.lootTableItem(BFItems.PALM_FROND.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_FROND.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PalmFrondBlock.SIZE, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_FROND.get(), LootItem.lootTableItem(BFItems.PALM_FROND.get()))))
        );
        add(BFBlocks.WALL_PALM_FROND.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALL_PALM_FROND.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.WallPalmFrondBlock.SIZE, 0)))
                        .add(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND.get(), LootItem.lootTableItem(BFItems.PALM_FROND.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALL_PALM_FROND.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.WallPalmFrondBlock.SIZE, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND.get(), LootItem.lootTableItem(BFItems.PALM_FROND.get()))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALL_PALM_FROND.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.WallPalmFrondBlock.SIZE, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND.get(), LootItem.lootTableItem(BFItems.PALM_FROND.get()))))
        );
        add(BFBlocks.COCONUT_CANDLE.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(this.applyExplosionDecay(BFBlocks.COCONUT_CANDLE.get(), LootItem.lootTableItem(BFBlocks.COCONUT_CANDLE.get())
                                .apply(List.of(2, 3), (candles) -> SetItemCountFunction.setCount(ConstantValue.exactly((float) candles))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.COCONUT_CANDLE.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.CoconutCandleBlock.CANDLES, candles))))))));
        add(BFBlocks.SPONGEKIN.get(), (block) -> {
            return createSilkTouchDispatchTable(
                    block,
                    applyExplosionDecay(
                            block,
                            LootItem.lootTableItem(BFItems.SPONGEKIN_SLICE.get())
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                                    .apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                    .apply(LimitCount.limitCount(IntRange.upperBound(9)))));
        });
        dropPottedContents(BFBlocks.POTTED_HONEYSUCKLE.get());
        dropPottedContents(BFBlocks.POTTED_APPLE_SAPLING.get());
        dropPottedContents(BFBlocks.POTTED_ORANGE_SAPLING.get());
        dropPottedContents(BFBlocks.POTTED_LEMON_SAPLING.get());
        dropPottedContents(BFBlocks.POTTED_PLUM_SAPLING.get());
        dropPottedContents(BFBlocks.POTTED_HOARY_APPLE_SAPLING.get());
        dropPottedContents(BFBlocks.POTTED_WALNUT_SAPLING.get());
        dropPottedContents(BFBlocks.POTTED_VIOLET_BELLFLOWER.get());
        dropPottedContents(BFBlocks.POTTED_PALM_FROND.get());
        dropPottedContents(BFBlocks.POTTED_GOLDEN_APPLE_SAPLING.get());
        dropOther(BFBlocks.PALM_SAPLING.get(), BFItems.COCONUT.get());
        dropSelf(BFBlocks.FELDSPAR_BRICK_WALL.get());


        usedBlocks.add(BFBlocks.APPLE_PIE.get());
        usedBlocks.add(BFBlocks.ARTISAN_BREAD.get());
        usedBlocks.add(BFBlocks.ARTISAN_COOKIE.get());
        usedBlocks.add(BFBlocks.CERAMIC_BUTTON.get());
        usedBlocks.add(BFBlocks.CERAMIC_DISH.get());
        usedBlocks.add(BFBlocks.CERAMIC_CHEST.get());
        usedBlocks.add(BFBlocks.CERAMIC_DOOR.get());
        usedBlocks.add(BFBlocks.CERAMIC_LEVER.get());
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC.get());
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC_SLAB.get());
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC_STAIRS.get());
        //usedBlocks.add(BFBlocks.CERAMIC_MOSAIC_WALL);
        usedBlocks.add(BFBlocks.CERAMIC_PRESSURE_PLATE.get());
        usedBlocks.add(BFBlocks.CERAMIC_TILE_PILLAR.get());
        usedBlocks.add(BFBlocks.CERAMIC_TILE_SLAB.get());
        usedBlocks.add(BFBlocks.CERAMIC_TILE_STAIRS.get());
        //usedBlocks.add(BFBlocks.CERAMIC_TILE_WALL);
        usedBlocks.add(BFBlocks.CERAMIC_TILES.get());
        usedBlocks.add(BFBlocks.CERAMIC_TRAPDOOR.get());
        usedBlocks.add(BFBlocks.CHAMOMILE_FLOWERS.get());
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC.get());
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get());
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get());
        //usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get());
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get());
        //usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILE_WALL);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILES.get());
        usedBlocks.add(BFBlocks.COCONUT_CAKE.get());
        usedBlocks.add(BFBlocks.COCONUT.get());
        usedBlocks.add(BFBlocks.COCOA_CAKE.get());
        usedBlocks.add(BFBlocks.SPONGE_CAKE.get());
        usedBlocks.add(BFBlocks.CRACKED_CERAMIC_TILES.get());
        usedBlocks.add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get());
        usedBlocks.add(BFBlocks.ELDERBERRY_TART.get());
        usedBlocks.add(BFBlocks.GLOW_BERRY_TART.get());
        usedBlocks.add(BFBlocks.HANGING_WALNUTS.get());
        usedBlocks.add(BFBlocks.HOARY_PIE.get());
        usedBlocks.add(BFBlocks.LAPISBERRY_TART.get());
        usedBlocks.add(BFBlocks.LEMON_PIE.get());
        usedBlocks.add(BFBlocks.ORANGE_PIE.get());
        usedBlocks.add(BFBlocks.PASSION_FRUIT_TART.get());
        usedBlocks.add(BFBlocks.PLUM_PIE.get());
        usedBlocks.add(BFBlocks.PUMPKIN_PIE.get());
        usedBlocks.add(BFBlocks.MELON_PIE.get());
        usedBlocks.add(BFBlocks.SWEET_BERRY_TART.get());
        usedBlocks.add(BFBlocks.TEA_SHRUB.get());

        usedBlocks.add(BFBlocks.HOARY_SIGN.get());
        usedBlocks.add(BFBlocks.HOARY_WALL_SIGN.get());
        usedBlocks.add(BFBlocks.HOARY_HANGING_SIGN.get());
        usedBlocks.add(BFBlocks.HOARY_WALL_HANGING_SIGN.get());
        usedBlocks.add(BFBlocks.WALNUT_SIGN.get());
        usedBlocks.add(BFBlocks.WALNUT_WALL_SIGN.get());
        usedBlocks.add(BFBlocks.WALNUT_HANGING_SIGN.get());
        usedBlocks.add(BFBlocks.WALNUT_WALL_HANGING_SIGN.get());
        usedBlocks.add(BFBlocks.SOLID_CERAMIC.get());

        for(ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.MOD_ID)) {
            Block block = BuiltInRegistries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.dropSelf(block);
        }

        for(ResourceLocation id : BountifulFaresUtil.allCompatBlockIds()) {
            Block block = BuiltInRegistries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.dropSelf(block);
        }
    }

//    public void registerTrellisLootTables(TrellisVariant trellis) {
//        this.dropSelf(TrellisUtil.getTrellisFromVariant(trellis));
//        for (VineCrop crop : TrellisUtil.VineCrops) {
//            this.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), LootTable.lootTable()
//                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//                            .add(this.applyExplosionDecay(TrellisUtil.getCropTrellisFromVariant(trellis, crop), LootItem.lootTableItem(TrellisUtil.getTrellisFromVariant(trellis))))));
//        }
//        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
//            this.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), LootTable.lootTable()
//                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//                            .add(this.applyExplosionDecay(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), LootItem.lootTableItem(TrellisUtil.getTrellisFromVariant(trellis))))));
//        }
//    }

    public LootTable.Builder WildCropDrops(Item seed, Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveCShearsOrSilkTouch())
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(seed))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.hasCShearsOrSilkTouch())
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))));
    }

    public void hangingFruitDrops(Block block, Item drop) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.HangingFruitBlock.AGE, 4)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))))
        );
    }


    public void fruitBlockDrops(Block block, Item fruitItem) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.FruitBlock.SLICES, 0)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.FruitBlock.SLICES, 1)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(fruitItem))))

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.FruitBlock.SLICES, 2)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(fruitItem))))

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.FruitBlock.SLICES, 3)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(fruitItem)))));
        usedBlocks.add(block);
    }

    public void picketsDrops(Block block) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.PicketsBlock.NORTH, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.PicketsBlock.EAST, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.PicketsBlock.SOUTH, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(net.hecco.bountifulfares.definition.block.custom.PicketsBlock.WEST, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)))));
    }

    public void jackOStrawDrops(Block block) {
        this.add(block, this.createSinglePropConditionTable(block, net.hecco.bountifulfares.definition.block.custom.JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }

    public static LootItemCondition.Builder hasCShears() {
        return MatchTool.toolMatches(ItemPredicate.Builder.item().of(BFItemTags.C_SHEARS));
    }

    public final LootItemCondition.Builder hasCShearsOrSilkTouch() {
        return hasCShears().or(this.hasSilkTouch());
    }

    public final LootItemCondition.Builder doesNotHaveCShearsOrSilkTouch() {
        return this.hasShearsOrSilkTouch().invert();
    }

    public LootTable.Builder createSilkTouchOrCShearsDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
        return createSelfDropDispatchTable(block, this.hasCShearsOrSilkTouch(), builder);
    }

    @Override
    public LootTable.Builder createLeavesDrops(Block leavesBlock, Block saplingBlock, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrCShearsDispatchTable(leavesBlock, ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(saplingBlock))).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), chances))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.doesNotHaveCShearsOrSilkTouch()).add(((LootPoolSingletonContainer.Builder)this.applyExplosionDecay(leavesBlock, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_SAPLING_CHANCES))));
    }
}
