package net.hecco.bountifulfares.datagen.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.block.custom.*;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class BFBlockLootTableProvider extends FabricBlockLootTableProvider {
    public static final ArrayList<Block> usedBlocks = new ArrayList<>();

//    public static final LootCondition.Builder WITH_FORTUNE = MatchToolLootCondition.builder(net.minecraft.predicate.item.ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(1))));
    public static final float[] PRISMARINE_DROP_CHANCE = new float[]{0.0F, 0.12F, 0.15F, 0.2F};
    public static final float[] FRUIT_SAPLING_DROP_CHANCE = new float[]{0.01F, 0.05F, 0.08F, 0.1F};
    public static final float[] FLOWERING_FRUIT_SAPLING_DROP_CHANCE = new float[]{0.1F, 0.12F, 0.15F, 0.2F};

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

        add(BFBlocks.APPLE_LEAVES, createLeavesDrops(BFBlocks.APPLE_LEAVES, BFBlocks.APPLE_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.FLOWERING_APPLE_LEAVES, createLeavesDrops(BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.APPLE_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.ORANGE_LEAVES, createLeavesDrops(BFBlocks.ORANGE_LEAVES, BFBlocks.ORANGE_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.FLOWERING_ORANGE_LEAVES, createLeavesDrops(BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.ORANGE_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.LEMON_LEAVES, createLeavesDrops(BFBlocks.LEMON_LEAVES, BFBlocks.LEMON_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.FLOWERING_LEMON_LEAVES, createLeavesDrops(BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.LEMON_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.PLUM_LEAVES, createLeavesDrops(BFBlocks.PLUM_LEAVES, BFBlocks.PLUM_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.FLOWERING_PLUM_LEAVES, createLeavesDrops(BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.PLUM_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        add(BFBlocks.GOLDEN_APPLE_LEAVES, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .when(this.hasShearsOrSilkTouch())
                .add(LootItem.lootTableItem(BFBlocks.GOLDEN_APPLE_LEAVES))));
        add(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .when(this.hasShearsOrSilkTouch())
                .add(LootItem.lootTableItem(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES))));

        dropOther(BFBlocks.HOARY_APPLE_SAPLING_CROP, BFItems.HOARY_SEEDS);
        add(BFBlocks.HOARY_SLAB, createSlabItemTable(BFBlocks.HOARY_SLAB));
        add(BFBlocks.HOARY_DOOR, createDoorTable(BFBlocks.HOARY_DOOR));
        add(BFBlocks.HOARY_LEAVES, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add((this.applyExplosionDecay(BFBlocks.HOARY_LEAVES, LootItem.lootTableItem(Items.STICK)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.hasShearsOrSilkTouch())
                        .add(LootItem.lootTableItem(BFBlocks.HOARY_LEAVES))));
        add(BFBlocks.WALNUT_SLAB, createSlabItemTable(BFBlocks.WALNUT_SLAB));
        add(BFBlocks.WALNUT_DOOR, createDoorTable(BFBlocks.WALNUT_DOOR));
        add(BFBlocks.WALNUT_LEAVES, createLeavesDrops(BFBlocks.WALNUT_LEAVES, BFBlocks.WALNUT_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));

        registerTrellisLootTables(BFTrellises.OAK);
        registerTrellisLootTables(BFTrellises.SPRUCE);
        registerTrellisLootTables(BFTrellises.BIRCH);
        registerTrellisLootTables(BFTrellises.JUNGLE);
        registerTrellisLootTables(BFTrellises.ACACIA);
        registerTrellisLootTables(BFTrellises.DARK_OAK);
        registerTrellisLootTables(BFTrellises.MANGROVE);
        registerTrellisLootTables(BFTrellises.CHERRY);
        registerTrellisLootTables(BFTrellises.BAMBOO);
        registerTrellisLootTables(BFTrellises.WALNUT);
        registerTrellisLootTables(BFTrellises.HOARY);
        registerTrellisLootTables(BFTrellises.CRIMSON);
        registerTrellisLootTables(BFTrellises.WARPED);

        add(BFBlocks.WILD_WHEAT, WildCropDrops(Items.WHEAT_SEEDS, BFBlocks.WILD_WHEAT));
        add(BFBlocks.WILD_CARROTS, WildCropDrops(Items.CARROT, BFBlocks.WILD_CARROTS));
        add(BFBlocks.WILD_POTATOES, WildCropDrops(Items.POTATO, BFBlocks.WILD_POTATOES));
        add(BFBlocks.WILD_BEETROOTS, WildCropDrops(Items.BEETROOT_SEEDS, BFBlocks.WILD_BEETROOTS));
        add(BFBlocks.WILD_LEEKS, WildCropDrops(BFItems.LEEK_SEEDS, BFBlocks.WILD_LEEKS));
        add(BFBlocks.WILD_PASSION_FRUIT_VINE, WildCropDrops(BFItems.PASSION_FRUIT, BFBlocks.WILD_PASSION_FRUIT_VINE));
        add(BFBlocks.WILD_ELDERBERRY_VINE, WildCropDrops(BFItems.ELDERBERRIES, BFBlocks.WILD_ELDERBERRY_VINE));
        add(BFBlocks.WILD_MAIZE, LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WILD_MAIZE)
//                                        .properties(StatePredicate.Builder.create().exactMatch(WildMaizeBlock.HALF, DoubleBlockHalf.LOWER)))
                                .when(this.doesNotHaveShearsOrSilkTouch())
                                .add(this.applyExplosionDecay(BFBlocks.WILD_MAIZE, LootItem.lootTableItem(BFItems.MAIZE_SEEDS))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
//                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WILD_MAIZE)
//                                        .properties(StatePredicate.Builder.create().exactMatch(WildMaizeBlock.HALF, DoubleBlockHalf.LOWER)))
                                .when(this.hasShearsOrSilkTouch())
                                .add(this.applyExplosionDecay(BFBlocks.WILD_MAIZE, LootItem.lootTableItem(BFBlocks.WILD_MAIZE)))));
        add(BFBlocks.MAIZE_CROP, LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.MAIZE_CROP)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MaizeCropBlock.AGE, 7)))
                        .add(this.applyExplosionDecay(BFBlocks.MAIZE_CROP, LootItem.lootTableItem(BFItems.MAIZE)))));
        add(BFBlocks.FELDSPAR_BRICK_SLAB, createSlabItemTable(BFBlocks.FELDSPAR_BRICK_SLAB));
        add(BFBlocks.TINGED_GLASS, createSilkTouchOnlyTable(BFBlocks.TINGED_GLASS));
        dropOther(BFBlocks.SPONGEKIN_SPROUT, BFItems.SPONGEKIN_SEEDS);
        add(BFBlocks.PRISMARINE_BLOSSOM, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(this.doesNotHaveSilkTouch())
                        .add(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM, LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS)).setWeight(4))
                        .add(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM, LootItem.lootTableItem(Items.PRISMARINE_SHARD)).setWeight(2))
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
                        .add(LootItem.lootTableItem(BFBlocks.PRISMARINE_BLOSSOM))));
        add(BFBlocks.FALLEN_WALNUTS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.FALLEN_WALNUTS)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FallenWalnutsBlock.COUNT, 0)))
                        .add(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS, LootItem.lootTableItem(BFItems.WALNUT))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.FALLEN_WALNUTS)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FallenWalnutsBlock.COUNT, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS, LootItem.lootTableItem(BFItems.WALNUT))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(5.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.FALLEN_WALNUTS)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FallenWalnutsBlock.COUNT, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS, LootItem.lootTableItem(BFItems.WALNUT))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(6.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.FALLEN_WALNUTS)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FallenWalnutsBlock.COUNT, 3)))
                        .add(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS, LootItem.lootTableItem(BFItems.WALNUT)))));

        add(BFBlocks.LEEKS, createCropDrops(BFBlocks.LEEKS, BFItems.LEEK, BFItems.LEEK_SEEDS, LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.LEEKS).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeetrootBlock.AGE, 7))));

        jackOStrawDrops(BFBlocks.RED_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.ORANGE_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.YELLOW_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.LIME_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.GREEN_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.CYAN_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.LIGHT_BLUE_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.BLUE_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.PURPLE_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.MAGENTA_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.PINK_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.WHITE_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.LIGHT_GRAY_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.GRAY_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.BLACK_JACK_O_STRAW);
        jackOStrawDrops(BFBlocks.BROWN_JACK_O_STRAW);

        picketsDrops(BFBlocks.OAK_PICKETS);
        picketsDrops(BFBlocks.BIRCH_PICKETS);
        picketsDrops(BFBlocks.SPRUCE_PICKETS);
        picketsDrops(BFBlocks.JUNGLE_PICKETS);
        picketsDrops(BFBlocks.ACACIA_PICKETS);
        picketsDrops(BFBlocks.DARK_OAK_PICKETS);
        picketsDrops(BFBlocks.MANGROVE_PICKETS);
        picketsDrops(BFBlocks.CHERRY_PICKETS);
        picketsDrops(BFBlocks.BAMBOO_PICKETS);
        picketsDrops(BFBlocks.WALNUT_PICKETS);
        picketsDrops(BFBlocks.HOARY_PICKETS);
        picketsDrops(BFBlocks.CRIMSON_PICKETS);
        picketsDrops(BFBlocks.WARPED_PICKETS);
        picketsDrops(BFBlocks.IRON_RAILING);


        add(BFBlocks.WALNUT_MULCH, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, LootItem.lootTableItem(BFBlocks.WALNUT_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, LootItem.lootTableItem(BFBlocks.WALNUT_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 3)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, LootItem.lootTableItem(BFBlocks.WALNUT_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 4)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, LootItem.lootTableItem(BFBlocks.WALNUT_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(5.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 5)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, LootItem.lootTableItem(BFBlocks.WALNUT_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(6.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 6)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, LootItem.lootTableItem(BFBlocks.WALNUT_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(7.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 7)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, LootItem.lootTableItem(BFBlocks.WALNUT_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(8.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALNUT_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 8)))
                        .add(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, LootItem.lootTableItem(BFBlocks.WALNUT_MULCH)))));


        fruitBlockDrops(BFBlocks.APPLE_BLOCK, Items.APPLE);
        fruitBlockDrops(BFBlocks.GOLDEN_APPLE_BLOCK, Items.GOLDEN_APPLE);
        fruitBlockDrops(BFBlocks.ORANGE_BLOCK, BFItems.ORANGE);
        fruitBlockDrops(BFBlocks.LEMON_BLOCK, BFItems.LEMON);
        fruitBlockDrops(BFBlocks.PLUM_BLOCK, BFItems.PLUM);
        fruitBlockDrops(BFBlocks.HOARY_APPLE_BLOCK, BFItems.HOARY_APPLE);

        hangingFruitDrops(BFBlocks.HANGING_APPLE, Items.APPLE);
        hangingFruitDrops(BFBlocks.HANGING_ORANGE, BFItems.ORANGE);
        hangingFruitDrops(BFBlocks.HANGING_LEMON, BFItems.LEMON);
        hangingFruitDrops(BFBlocks.HANGING_PLUM, BFItems.PLUM);
        hangingFruitDrops(BFBlocks.HANGING_HOARY_APPLE, BFItems.HOARY_APPLE);
        hangingFruitDrops(BFBlocks.HANGING_GOLDEN_APPLE, Items.GOLDEN_APPLE);
        usedBlocks.add(BFBlocks.HANGING_WITHERED_GOLDEN_APPLE);
        add(BFBlocks.GRASSY_DIRT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveSilkTouch())
                        .add(this.applyExplosionDecay(BFBlocks.GRASSY_DIRT, LootItem.lootTableItem(Blocks.DIRT))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.hasSilkTouch())
                        .add(this.applyExplosionDecay(BFBlocks.GRASSY_DIRT, LootItem.lootTableItem(BFBlocks.GRASSY_DIRT)))));
        add(BFBlocks.TEA_SHRUB, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.TEA_SHRUB)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TeaShrubBlock.BERRIES, true)))
                        .add(this.applyExplosionDecay(BFBlocks.TEA_SHRUB, LootItem.lootTableItem(BFItems.TEA_BERRIES)))
        ));

        add(BFBlocks.PALM_MULCH, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH, LootItem.lootTableItem(BFBlocks.PALM_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH, LootItem.lootTableItem(BFBlocks.PALM_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 3)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH, LootItem.lootTableItem(BFBlocks.PALM_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 4)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH, LootItem.lootTableItem(BFBlocks.PALM_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(5.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 5)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH, LootItem.lootTableItem(BFBlocks.PALM_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(6.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 6)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH, LootItem.lootTableItem(BFBlocks.PALM_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(7.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 7)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH, LootItem.lootTableItem(BFBlocks.PALM_MULCH))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(8.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_MULCH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MulchBlock.LAYERS, 8)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_MULCH, LootItem.lootTableItem(BFBlocks.PALM_MULCH)))));
        add(BFBlocks.COIR_BRICK_SLAB, createSlabItemTable(BFBlocks.COIR_BRICK_SLAB));
        add(BFBlocks.PALM_FROND, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_FROND)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PalmFrondBlock.SIZE, 0)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_FROND, LootItem.lootTableItem(BFItems.PALM_FROND))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_FROND)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PalmFrondBlock.SIZE, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_FROND, LootItem.lootTableItem(BFItems.PALM_FROND))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.PALM_FROND)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PalmFrondBlock.SIZE, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.PALM_FROND, LootItem.lootTableItem(BFItems.PALM_FROND))))
        );
        add(BFBlocks.WALL_PALM_FROND, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALL_PALM_FROND)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WallPalmFrondBlock.SIZE, 0)))
                        .add(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND, LootItem.lootTableItem(BFItems.PALM_FROND))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALL_PALM_FROND)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WallPalmFrondBlock.SIZE, 1)))
                        .add(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND, LootItem.lootTableItem(BFItems.PALM_FROND))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.WALL_PALM_FROND)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WallPalmFrondBlock.SIZE, 2)))
                        .add(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND, LootItem.lootTableItem(BFItems.PALM_FROND))))
        );
        add(BFBlocks.COCONUT_CANDLE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(this.applyExplosionDecay(BFBlocks.COCONUT_CANDLE, LootItem.lootTableItem(BFBlocks.COCONUT_CANDLE)
                                .apply(List.of(2, 3), (candles) -> SetItemCountFunction.setCount(ConstantValue.exactly((float)candles))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BFBlocks.COCONUT_CANDLE)
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CoconutCandleBlock.CANDLES, candles))))))));
        add(BFBlocks.SPONGEKIN, (block) -> {
            return createSilkTouchDispatchTable(
                    block,
                    applyExplosionDecay(
                            block,
                            LootItem.lootTableItem(BFItems.SPONGEKIN_SLICE)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                                    .apply(ApplyBonusCount.addUniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                    .apply(LimitCount.limitCount(IntRange.upperBound(9)))));
        });
        dropPottedContents(BFBlocks.POTTED_HONEYSUCKLE);
        dropPottedContents(BFBlocks.POTTED_APPLE_SAPLING);
        dropPottedContents(BFBlocks.POTTED_ORANGE_SAPLING);
        dropPottedContents(BFBlocks.POTTED_LEMON_SAPLING);
        dropPottedContents(BFBlocks.POTTED_PLUM_SAPLING);
        dropPottedContents(BFBlocks.POTTED_HOARY_APPLE_SAPLING);
        dropPottedContents(BFBlocks.POTTED_WALNUT_SAPLING);
        dropPottedContents(BFBlocks.POTTED_VIOLET_BELLFLOWER);
        dropPottedContents(BFBlocks.POTTED_PALM_FROND);
        dropPottedContents(BFBlocks.POTTED_GOLDEN_APPLE_SAPLING);
        dropOther(BFBlocks.PALM_SAPLING, BFItems.COCONUT);
        dropSelf(BFBlocks.FELDSPAR_BRICK_WALL);


        usedBlocks.add(BFBlocks.APPLE_PIE);
        usedBlocks.add(BFBlocks.ARTISAN_BREAD);
        usedBlocks.add(BFBlocks.ARTISAN_COOKIE);
        usedBlocks.add(BFBlocks.CERAMIC_BUTTON);
        usedBlocks.add(BFBlocks.CERAMIC_DISH);
        usedBlocks.add(BFBlocks.CERAMIC_DOOR);
        usedBlocks.add(BFBlocks.CERAMIC_LEVER);
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC);
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC_SLAB);
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC_STAIRS);
        //usedBlocks.add(BFBlocks.CERAMIC_MOSAIC_WALL);
        usedBlocks.add(BFBlocks.CERAMIC_PRESSURE_PLATE);
        usedBlocks.add(BFBlocks.CERAMIC_TILE_PILLAR);
        usedBlocks.add(BFBlocks.CERAMIC_TILE_SLAB);
        usedBlocks.add(BFBlocks.CERAMIC_TILE_STAIRS);
        //usedBlocks.add(BFBlocks.CERAMIC_TILE_WALL);
        usedBlocks.add(BFBlocks.CERAMIC_TILES);
        usedBlocks.add(BFBlocks.CERAMIC_TRAPDOOR);
        usedBlocks.add(BFBlocks.CHAMOMILE_FLOWERS);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        //usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
        //usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILE_WALL);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILES);
        usedBlocks.add(BFBlocks.COCONUT_CAKE);
        usedBlocks.add(BFBlocks.COCONUT);
        usedBlocks.add(BFBlocks.COCOA_CAKE);
        usedBlocks.add(BFBlocks.CRACKED_CERAMIC_TILES);
        usedBlocks.add(BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES);
        usedBlocks.add(BFBlocks.ELDERBERRY_TART);
        usedBlocks.add(BFBlocks.GLOW_BERRY_TART);
        usedBlocks.add(BFBlocks.HANGING_WALNUTS);
        usedBlocks.add(BFBlocks.HOARY_PIE);
        usedBlocks.add(BFBlocks.LAPISBERRY_TART);
        usedBlocks.add(BFBlocks.LEMON_PIE);
        usedBlocks.add(BFBlocks.ORANGE_PIE);
        usedBlocks.add(BFBlocks.PASSION_FRUIT_TART);
        usedBlocks.add(BFBlocks.PLUM_PIE);
        usedBlocks.add(BFBlocks.PUMPKIN_PIE);
        usedBlocks.add(BFBlocks.MELON_PIE);
        usedBlocks.add(BFBlocks.SWEET_BERRY_TART);
        usedBlocks.add(BFBlocks.TEA_SHRUB);

        usedBlocks.add(BFBlocks.HOARY_SIGN);
        usedBlocks.add(BFBlocks.HOARY_WALL_SIGN);
        usedBlocks.add(BFBlocks.HOARY_HANGING_SIGN);
        usedBlocks.add(BFBlocks.HOARY_WALL_HANGING_SIGN);
        usedBlocks.add(BFBlocks.WALNUT_SIGN);
        usedBlocks.add(BFBlocks.WALNUT_WALL_SIGN);
        usedBlocks.add(BFBlocks.WALNUT_HANGING_SIGN);
        usedBlocks.add(BFBlocks.WALNUT_WALL_HANGING_SIGN);
        usedBlocks.add(BFBlocks.SOLID_CERAMIC);

        for(ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.MOD_ID)) {
            Block block = BuiltInRegistries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.dropSelf(block);
        }
    }

    public void registerTrellisLootTables(TrellisVariant trellis) {
        this.dropSelf(TrellisUtil.getTrellisFromVariant(trellis));
        for (VineCrop crop : TrellisUtil.VineCrops) {
            this.add(TrellisUtil.getCropTrellisFromVariant(trellis, crop), LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                            .add(this.applyExplosionDecay(TrellisUtil.getCropTrellisFromVariant(trellis, crop), LootItem.lootTableItem(TrellisUtil.getTrellisFromVariant(trellis))))));
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            this.add(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                            .add(this.applyExplosionDecay(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), LootItem.lootTableItem(TrellisUtil.getTrellisFromVariant(trellis))))));
        }
    }

    public LootTable.Builder WildCropDrops(Item seed, Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.doesNotHaveShearsOrSilkTouch())
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(seed))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(this.hasShearsOrSilkTouch())
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))));
    }

    public void hangingFruitDrops(Block block, Item drop) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HangingFruitBlock.AGE, 4)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))))
        );
    }


    public void fruitBlockDrops(Block block, Item fruitItem) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FruitBlock.SLICES, 0)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FruitBlock.SLICES, 1)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(fruitItem))))

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FruitBlock.SLICES, 2)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(fruitItem))))

                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FruitBlock.SLICES, 3)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(fruitItem)))));
        usedBlocks.add(block);
    }

    public void picketsDrops(Block block) {
        this.add(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PicketsBlock.NORTH, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PicketsBlock.EAST, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PicketsBlock.SOUTH, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PicketsBlock.WEST, true)))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)))));
    }

    public void jackOStrawDrops(Block block) {
        this.add(block, this.createSinglePropConditionTable(block, JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }
}
