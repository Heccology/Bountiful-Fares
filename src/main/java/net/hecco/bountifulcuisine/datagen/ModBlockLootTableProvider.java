package net.hecco.bountifulcuisine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.custom.FallenWalnutsBlock;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public static final LootCondition.Builder WITH_FORTUNE = MatchToolLootCondition.builder(net.minecraft.predicate.item.ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(1))));
    public static final float[] PRISMARINE_DROP_CHANCE = new float[]{0.0F, 0.12F, 0.15F, 0.2F};
    public static final float[] FRUIT_SAPLING_DROP_CHANCE = new float[]{0.1F, 0.12F, 0.15F, 0.2F};
    public static final float[] FLOWERING_FRUIT_SAPLING_DROP_CHANCE = new float[]{0.2F, 0.24F, 0.3F, 0.4F};
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.APPLE_LOG);
        addDrop(ModBlocks.APPLE_WOOD);
        addDrop(ModBlocks.STRIPPED_APPLE_LOG);
        addDrop(ModBlocks.STRIPPED_APPLE_WOOD);
        addDrop(ModBlocks.APPLE_LEAVES, leavesDrops(ModBlocks.APPLE_LEAVES, ModBlocks.APPLE_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.FLOWERING_APPLE_LEAVES, leavesDrops(ModBlocks.FLOWERING_APPLE_LEAVES, ModBlocks.APPLE_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.APPLE_BLOCK);
        addDrop(ModBlocks.APPLE_SAPLING);
        addDrop(ModBlocks.ORANGE_LOG);
        addDrop(ModBlocks.ORANGE_WOOD);
        addDrop(ModBlocks.STRIPPED_ORANGE_LOG);
        addDrop(ModBlocks.STRIPPED_ORANGE_WOOD);
        addDrop(ModBlocks.ORANGE_LEAVES, leavesDrops(ModBlocks.ORANGE_LEAVES, ModBlocks.ORANGE_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.FLOWERING_ORANGE_LEAVES, leavesDrops(ModBlocks.FLOWERING_ORANGE_LEAVES, ModBlocks.ORANGE_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.ORANGE_BLOCK);
        addDrop(ModBlocks.ORANGE_SAPLING);
        addDrop(ModBlocks.LEMON_LOG);
        addDrop(ModBlocks.LEMON_WOOD);
        addDrop(ModBlocks.STRIPPED_LEMON_LOG);
        addDrop(ModBlocks.STRIPPED_LEMON_WOOD);
        addDrop(ModBlocks.LEMON_LEAVES, leavesDrops(ModBlocks.LEMON_LEAVES, ModBlocks.LEMON_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.FLOWERING_LEMON_LEAVES, leavesDrops(ModBlocks.FLOWERING_LEMON_LEAVES, ModBlocks.LEMON_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.LEMON_BLOCK);
        addDrop(ModBlocks.LEMON_SAPLING);
        addDrop(ModBlocks.PLUM_LOG);
        addDrop(ModBlocks.PLUM_WOOD);
        addDrop(ModBlocks.STRIPPED_PLUM_LOG);
        addDrop(ModBlocks.STRIPPED_PLUM_WOOD);
        addDrop(ModBlocks.PLUM_LEAVES, leavesDrops(ModBlocks.PLUM_LEAVES, ModBlocks.PLUM_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.FLOWERING_PLUM_LEAVES, leavesDrops(ModBlocks.FLOWERING_PLUM_LEAVES, ModBlocks.PLUM_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.PLUM_BLOCK);
        addDrop(ModBlocks.PLUM_SAPLING);
        addDrop(ModBlocks.HOARY_APPLE_SAPLING_CROP, ModItems.HOARY_SEEDS);
        addDrop(ModBlocks.HOARY_APPLE_SAPLING);
        addDrop(ModBlocks.HOARY_LOG);
        addDrop(ModBlocks.HOARY_WOOD);
        addDrop(ModBlocks.STRIPPED_HOARY_LOG);
        addDrop(ModBlocks.STRIPPED_HOARY_WOOD);
        addDrop(ModBlocks.HOARY_PLANKS);
        addDrop(ModBlocks.HOARY_STAIRS);
        addDrop(ModBlocks.HOARY_SLAB);
        addDrop(ModBlocks.HOARY_FENCE);
        addDrop(ModBlocks.HOARY_FENCE_GATE);
        addDrop(ModBlocks.HOARY_DOOR, doorDrops(ModBlocks.HOARY_DOOR));
        addDrop(ModBlocks.HOARY_TRAPDOOR);
        addDrop(ModBlocks.HOARY_PRESSURE_PLATE);
        addDrop(ModBlocks.HOARY_BUTTON);
        addDrop(ModBlocks.HOARY_SIGN);
        addDrop(ModBlocks.HOARY_WALL_SIGN);
        addDrop(ModBlocks.HOARY_HANGING_SIGN);
        addDrop(ModBlocks.HOARY_WALL_HANGING_SIGN);
        addDrop(ModBlocks.HOARY_LEAVES, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with((this.applyExplosionDecay(ModBlocks.HOARY_LEAVES, ItemEntry.builder(Items.STICK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))))
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, LEAVES_STICK_DROP_CHANCE))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITH_SILK_TOUCH_OR_SHEARS)
                        .with(ItemEntry.builder(ModBlocks.HOARY_LEAVES))));
        addDrop(ModBlocks.HOARY_APPLE_BLOCK);
        addDrop(ModBlocks.GOLDEN_APPLE_BLOCK);
        addDrop(ModBlocks.WALNUT_LOG);
        addDrop(ModBlocks.WALNUT_WOOD);
        addDrop(ModBlocks.STRIPPED_WALNUT_LOG);
        addDrop(ModBlocks.STRIPPED_WALNUT_WOOD);
        addDrop(ModBlocks.WALNUT_PLANKS);
        addDrop(ModBlocks.WALNUT_STAIRS);
        addDrop(ModBlocks.WALNUT_SLAB);
        addDrop(ModBlocks.WALNUT_FENCE);
        addDrop(ModBlocks.WALNUT_FENCE_GATE);
        addDrop(ModBlocks.WALNUT_DOOR, doorDrops(ModBlocks.WALNUT_DOOR));
        addDrop(ModBlocks.WALNUT_TRAPDOOR);
        addDrop(ModBlocks.WALNUT_PRESSURE_PLATE);
        addDrop(ModBlocks.WALNUT_BUTTON);
        addDrop(ModBlocks.WALNUT_SIGN);
        addDrop(ModBlocks.WALNUT_WALL_SIGN);
        addDrop(ModBlocks.WALNUT_HANGING_SIGN);
        addDrop(ModBlocks.WALNUT_WALL_HANGING_SIGN);
        addDrop(ModBlocks.WALNUT_LEAVES, leavesDrops(ModBlocks.WALNUT_LEAVES, ModBlocks.PLUM_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(ModBlocks.OAK_PICKETS);
        addDrop(ModBlocks.SPRUCE_PICKETS);
        addDrop(ModBlocks.BIRCH_PICKETS);
        addDrop(ModBlocks.JUNGLE_PICKETS);
        addDrop(ModBlocks.ACACIA_PICKETS);
        addDrop(ModBlocks.DARK_OAK_PICKETS);
        addDrop(ModBlocks.MANGROVE_PICKETS);
        addDrop(ModBlocks.CHERRY_PICKETS);
        addDrop(ModBlocks.BAMBOO_PICKETS);
        addDrop(ModBlocks.HOARY_PICKETS);
        addDrop(ModBlocks.CRIMSON_PICKETS);
        addDrop(ModBlocks.WARPED_PICKETS);
        addDrop(ModBlocks.TRELLIS);
        addDrop(ModBlocks.PASSION_FRUIT_TRELLIS, plantedTrellisDrops(ModBlocks.PASSION_FRUIT_TRELLIS, ModBlocks.PASSION_FRUIT));
        addDrop(ModBlocks.ELDERBERRY_TRELLIS, plantedTrellisDrops(ModBlocks.ELDERBERRY_TRELLIS, ModBlocks.ELDERBERRIES));
        addDrop(ModBlocks.GLOW_BERRY_TRELLIS, plantedTrellisDrops(ModBlocks.GLOW_BERRY_TRELLIS, Items.GLOW_BERRIES));
        addDrop(ModBlocks.LAPISBERRY_TRELLIS, plantedTrellisDrops(ModBlocks.LAPISBERRY_TRELLIS, ModBlocks.LAPISBERRIES));
        addDrop(ModBlocks.ROSE_TRELLIS, plantedTrellisDrops(ModBlocks.ROSE_TRELLIS, Items.ROSE_BUSH));
        addDrop(ModBlocks.LILAC_TRELLIS, plantedTrellisDrops(ModBlocks.LILAC_TRELLIS, Items.LILAC));
        addDrop(ModBlocks.PEONY_TRELLIS, plantedTrellisDrops(ModBlocks.PEONY_TRELLIS, Items.PEONY));
        addDrop(ModBlocks.SUNFLOWER_TRELLIS, plantedTrellisDrops(ModBlocks.SUNFLOWER_TRELLIS, Items.SUNFLOWER));
        addDrop(ModBlocks.WILD_WHEAT, Items.WHEAT_SEEDS);
        addDrop(ModBlocks.WILD_CARROTS, Items.CARROT);
        addDrop(ModBlocks.WILD_POTATOES, Items.POTATO);
        addDrop(ModBlocks.WILD_BEETROOTS, Items.BEETROOT_SEEDS);
        addDrop(ModBlocks.WILD_GOOSEBERRIES, ModItems.LEEK_SEEDS);
        addDrop(ModBlocks.MAIZE_CROP, ModItems.MAIZE);
        addDrop(ModBlocks.FELDSPAR_BLOCK);
        addDrop(ModBlocks.CUT_FELDSPAR_BLOCK);
        addDrop(ModBlocks.FELDSPAR_BRICKS);
        addDrop(ModBlocks.FELDSPAR_BRICK_STAIRS);
        addDrop(ModBlocks.FELDSPAR_BRICK_SLAB);
        addDrop(ModBlocks.FELDSPAR_LANTERN);
        addDrop(ModBlocks.TINGED_GLASS, dropsWithSilkTouch(ModBlocks.TINGED_GLASS));
        addDrop(ModBlocks.CERAMIC_CLAY_BLOCK);
        addDrop(ModBlocks.CERAMIC_PRESSURE_PLATE);
        addDrop(ModBlocks.CERAMIC_BUTTON);
        addDrop(ModBlocks.GRISTMILL);
        addDrop(ModBlocks.SPONGEKIN_SPROUT, ModItems.SPONGEKIN_SEEDS);
        addDrop(ModBlocks.PRISMARINE_BLOSSOM, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .conditionally(WITHOUT_SILK_TOUCH)
                        .with(this.applyExplosionDecay(ModBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_CRYSTALS)).weight(4))
                        .with(this.applyExplosionDecay(ModBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_SHARD)).weight(2))
                        .with(EmptyEntry.builder().weight(2)))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(WITH_FORTUNE)
                        .with(this.applyExplosionDecay(ModBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_CRYSTALS)).weight(4))
                            .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, PRISMARINE_DROP_CHANCE))
                        .with(this.applyExplosionDecay(ModBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_SHARD)).weight(2))
                            .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, PRISMARINE_DROP_CHANCE)))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITH_SILK_TOUCH)
                        .with(ItemEntry.builder(ModBlocks.PRISMARINE_BLOSSOM))));
        addDrop(ModBlocks.WHITE_JACK_O_STRAW, doorDrops(ModBlocks.WHITE_JACK_O_STRAW));
        addDrop(ModBlocks.FALLEN_WALNUTS, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.FALLEN_WALNUTS)
                                .properties(StatePredicate.Builder.create().exactMatch(FallenWalnutsBlock.COUNT, 0)))
                        .with(this.applyExplosionDecay(ModBlocks.FALLEN_WALNUTS, ItemEntry.builder(ModItems.WALNUT))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.FALLEN_WALNUTS)
                                .properties(StatePredicate.Builder.create().exactMatch(FallenWalnutsBlock.COUNT, 1)))
                        .with(this.applyExplosionDecay(ModBlocks.FALLEN_WALNUTS, ItemEntry.builder(ModItems.WALNUT))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.FALLEN_WALNUTS)
                                .properties(StatePredicate.Builder.create().exactMatch(FallenWalnutsBlock.COUNT, 2)))
                        .with(this.applyExplosionDecay(ModBlocks.FALLEN_WALNUTS, ItemEntry.builder(ModItems.WALNUT))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(6.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.FALLEN_WALNUTS)
                                .properties(StatePredicate.Builder.create().exactMatch(FallenWalnutsBlock.COUNT, 3)))
                        .with(this.applyExplosionDecay(ModBlocks.FALLEN_WALNUTS, ItemEntry.builder(ModItems.WALNUT)))));
    }
    public LootTable.Builder plantedTrellisDrops(Block block, Item plant) {
        return LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(plant))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(ModBlocks.TRELLIS))));
    }
}
