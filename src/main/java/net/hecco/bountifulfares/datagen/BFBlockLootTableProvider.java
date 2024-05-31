package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.trellis.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.block.custom.*;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.block.BeetrootsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
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


public class BFBlockLootTableProvider extends FabricBlockLootTableProvider {

    public static final LootCondition.Builder WITH_FORTUNE = MatchToolLootCondition.builder(net.minecraft.predicate.item.ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(1))));
    public static final float[] PRISMARINE_DROP_CHANCE = new float[]{0.0F, 0.12F, 0.15F, 0.2F};
    public static final float[] FRUIT_SAPLING_DROP_CHANCE = new float[]{0.01F, 0.05F, 0.08F, 0.1F};
    public static final float[] FLOWERING_FRUIT_SAPLING_DROP_CHANCE = new float[]{0.1F, 0.12F, 0.15F, 0.2F};
    public BFBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(BFBlocks.APPLE_LOG);
        addDrop(BFBlocks.APPLE_WOOD);
        addDrop(BFBlocks.STRIPPED_APPLE_LOG);
        addDrop(BFBlocks.STRIPPED_APPLE_WOOD);
        addDrop(BFBlocks.APPLE_LEAVES, leavesDrops(BFBlocks.APPLE_LEAVES, BFBlocks.APPLE_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.FLOWERING_APPLE_LEAVES, leavesDrops(BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.APPLE_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.APPLE_BLOCK);
        addDrop(BFBlocks.APPLE_SAPLING);
        addDrop(BFBlocks.ORANGE_LOG);
        addDrop(BFBlocks.ORANGE_WOOD);
        addDrop(BFBlocks.STRIPPED_ORANGE_LOG);
        addDrop(BFBlocks.STRIPPED_ORANGE_WOOD);
        addDrop(BFBlocks.ORANGE_LEAVES, leavesDrops(BFBlocks.ORANGE_LEAVES, BFBlocks.ORANGE_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.FLOWERING_ORANGE_LEAVES, leavesDrops(BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.ORANGE_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.ORANGE_BLOCK);
        addDrop(BFBlocks.ORANGE_SAPLING);
        addDrop(BFBlocks.LEMON_LOG);
        addDrop(BFBlocks.LEMON_WOOD);
        addDrop(BFBlocks.STRIPPED_LEMON_LOG);
        addDrop(BFBlocks.STRIPPED_LEMON_WOOD);
        addDrop(BFBlocks.LEMON_LEAVES, leavesDrops(BFBlocks.LEMON_LEAVES, BFBlocks.LEMON_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.FLOWERING_LEMON_LEAVES, leavesDrops(BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.LEMON_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.LEMON_BLOCK);
        addDrop(BFBlocks.LEMON_SAPLING);
        addDrop(BFBlocks.PLUM_LOG);
        addDrop(BFBlocks.PLUM_WOOD);
        addDrop(BFBlocks.STRIPPED_PLUM_LOG);
        addDrop(BFBlocks.STRIPPED_PLUM_WOOD);
        addDrop(BFBlocks.PLUM_LEAVES, leavesDrops(BFBlocks.PLUM_LEAVES, BFBlocks.PLUM_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.FLOWERING_PLUM_LEAVES, leavesDrops(BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.PLUM_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.PLUM_BLOCK);
        addDrop(BFBlocks.PLUM_SAPLING);
        addDrop(BFBlocks.HOARY_APPLE_SAPLING_CROP, BFItems.HOARY_SEEDS);
        addDrop(BFBlocks.HOARY_APPLE_SAPLING);
        addDrop(BFBlocks.HOARY_LOG);
        addDrop(BFBlocks.HOARY_WOOD);
        addDrop(BFBlocks.STRIPPED_HOARY_LOG);
        addDrop(BFBlocks.STRIPPED_HOARY_WOOD);
        addDrop(BFBlocks.HOARY_PLANKS);
        addDrop(BFBlocks.HOARY_STAIRS);
        addDrop(BFBlocks.HOARY_SLAB, slabDrops(BFBlocks.HOARY_SLAB));
        addDrop(BFBlocks.HOARY_FENCE);
        addDrop(BFBlocks.HOARY_FENCE_GATE);
        addDrop(BFBlocks.HOARY_DOOR, doorDrops(BFBlocks.HOARY_DOOR));
        addDrop(BFBlocks.HOARY_TRAPDOOR);
        addDrop(BFBlocks.HOARY_PRESSURE_PLATE);
        addDrop(BFBlocks.HOARY_BUTTON);
        addDrop(BFBlocks.HOARY_SIGN);
        addDrop(BFBlocks.HOARY_WALL_SIGN);
        addDrop(BFBlocks.HOARY_HANGING_SIGN);
        addDrop(BFBlocks.HOARY_WALL_HANGING_SIGN);
        addDrop(BFBlocks.HOARY_LEAVES, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with((this.applyExplosionDecay(BFBlocks.HOARY_LEAVES, ItemEntry.builder(Items.STICK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))))
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, LEAVES_STICK_DROP_CHANCE))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITH_SILK_TOUCH_OR_SHEARS)
                        .with(ItemEntry.builder(BFBlocks.HOARY_LEAVES))));
        addDrop(BFBlocks.HOARY_APPLE_BLOCK);
        addDrop(BFBlocks.GOLDEN_APPLE_BLOCK);
        addDrop(BFBlocks.WALNUT_SAPLING);
        addDrop(BFBlocks.WALNUT_LOG);
        addDrop(BFBlocks.WALNUT_WOOD);
        addDrop(BFBlocks.STRIPPED_WALNUT_LOG);
        addDrop(BFBlocks.STRIPPED_WALNUT_WOOD);
        addDrop(BFBlocks.WALNUT_PLANKS);
        addDrop(BFBlocks.WALNUT_STAIRS);
        addDrop(BFBlocks.WALNUT_SLAB, slabDrops(BFBlocks.WALNUT_SLAB));
        addDrop(BFBlocks.WALNUT_FENCE);
        addDrop(BFBlocks.WALNUT_FENCE_GATE);
        addDrop(BFBlocks.WALNUT_DOOR, doorDrops(BFBlocks.WALNUT_DOOR));
        addDrop(BFBlocks.WALNUT_TRAPDOOR);
        addDrop(BFBlocks.WALNUT_PRESSURE_PLATE);
        addDrop(BFBlocks.WALNUT_BUTTON);
        addDrop(BFBlocks.WALNUT_SIGN);
        addDrop(BFBlocks.WALNUT_WALL_SIGN);
        addDrop(BFBlocks.WALNUT_HANGING_SIGN);
        addDrop(BFBlocks.WALNUT_WALL_HANGING_SIGN);
        addDrop(BFBlocks.WALNUT_LEAVES, leavesDrops(BFBlocks.WALNUT_LEAVES, BFBlocks.WALNUT_SAPLING, SAPLING_DROP_CHANCE));
//        picketsDrops(ModBlocks.ASPEN_PICKETS);
//        picketsDrops(ModBlocks.CEDAR_PICKETS);
//        picketsDrops(ModBlocks.COCONUT_PICKETS);
//        picketsDrops(ModBlocks.CYPRESS_PICKETS);
//        picketsDrops(ModBlocks.FIR_PICKETS);
//        picketsDrops(ModBlocks.GHAF_PICKETS);
//        picketsDrops(ModBlocks.JOSHUA_PICKETS);
//        picketsDrops(ModBlocks.LARCH_PICKETS);
//        picketsDrops(ModBlocks.MAHOGANY_PICKETS);
//        picketsDrops(ModBlocks.MAPLE_PICKETS);
//        picketsDrops(ModBlocks.PALO_VERDE_PICKETS);
//        picketsDrops(ModBlocks.MAHOGANY_PICKETS);
//        picketsDrops(ModBlocks.SAXAUL_PICKETS);
//        picketsDrops(ModBlocks.SUGI_PICKETS);
//        picketsDrops(ModBlocks.WILLOW_PICKETS);
//        picketsDrops(ModBlocks.WISTERIA_PICKETS);

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
//        registerTrellisLootTables(BFTrellises.BAOBAB);
//        registerTrellisLootTables(BFTrellises.WW_CYPRESS);
//        registerTrellisLootTables(BFTrellises.PALM);
//        registerTrellisLootTables(BFTrellises.ANCIENT);
//        registerTrellisLootTables(BFTrellises.WINTERGREEN);
//        registerTrellisLootTables(BFTrellises.ROTTEN);

//        registerTrellisLootTables(BFTrellises.ASPEN);
//        registerTrellisLootTables(BFTrellises.CEDAR);
//        registerTrellisLootTables(BFTrellises.COCONUT);
//        registerTrellisLootTables(BFTrellises.CYPRESS);
//        registerTrellisLootTables(BFTrellises.FIR);
//        registerTrellisLootTables(BFTrellises.GHAF);
//        registerTrellisLootTables(BFTrellises.JOSHUA);
//        registerTrellisLootTables(BFTrellises.LARCH);
//        registerTrellisLootTables(BFTrellises.MAHOGANY);
//        registerTrellisLootTables(BFTrellises.MAPLE);
//        registerTrellisLootTables(BFTrellises.OLIVE);
//        registerTrellisLootTables(BFTrellises.PALO_VERDE);
//        registerTrellisLootTables(BFTrellises.REDWOOD);
//        registerTrellisLootTables(BFTrellises.SAXAUL);
//        registerTrellisLootTables(BFTrellises.SUGI);
//        registerTrellisLootTables(BFTrellises.NS_WILLOW);
//        registerTrellisLootTables(BFTrellises.WISTERIA);


//        addDrop(ModBlocks.TRELLIS);
//        addDrop(ModBlocks.PASSION_FRUIT_TRELLIS, plantedTrellisDrops(ModBlocks.PASSION_FRUIT_TRELLIS, ModItems.PASSION_FRUIT));
//        addDrop(ModBlocks.ELDERBERRY_TRELLIS, plantedTrellisDrops(ModBlocks.ELDERBERRY_TRELLIS, ModItems.ELDERBERRIES));
//        addDrop(ModBlocks.GLOW_BERRY_TRELLIS, plantedTrellisDrops(ModBlocks.GLOW_BERRY_TRELLIS, Items.GLOW_BERRIES));
//        addDrop(ModBlocks.LAPISBERRY_TRELLIS, plantedTrellisDrops(ModBlocks.LAPISBERRY_TRELLIS, ModItems.LAPISBERRIES));
//        addDrop(ModBlocks.ROSE_TRELLIS, plantedTrellisDrops(ModBlocks.ROSE_TRELLIS, Items.ROSE_BUSH));
//        addDrop(ModBlocks.LILAC_TRELLIS, plantedTrellisDrops(ModBlocks.LILAC_TRELLIS, Items.LILAC));
//        addDrop(ModBlocks.PEONY_TRELLIS, plantedTrellisDrops(ModBlocks.PEONY_TRELLIS, Items.PEONY));
//        addDrop(ModBlocks.SUNFLOWER_TRELLIS, plantedTrellisDrops(ModBlocks.SUNFLOWER_TRELLIS, Items.SUNFLOWER));
//        addDrop(ModBlocks.VINE_TRELLIS, plantedTrellisDrops(ModBlocks.VINE_TRELLIS, Items.VINE));
//        addDrop(ModBlocks.WEEPING_TRELLIS, plantedTrellisDrops(ModBlocks.WEEPING_TRELLIS, Items.WEEPING_VINES));
//        addDrop(ModBlocks.TWISTING_TRELLIS, plantedTrellisDrops(ModBlocks.TWISTING_TRELLIS, Items.TWISTING_VINES));
        addDrop(BFBlocks.WILD_WHEAT, WildCropDrops(Items.WHEAT_SEEDS, BFBlocks.WILD_WHEAT));
        addDrop(BFBlocks.WILD_CARROTS, WildCropDrops(Items.CARROT, BFBlocks.WILD_CARROTS));
        addDrop(BFBlocks.WILD_POTATOES, WildCropDrops(Items.POTATO, BFBlocks.WILD_POTATOES));
        addDrop(BFBlocks.WILD_BEETROOTS, WildCropDrops(Items.BEETROOT_SEEDS, BFBlocks.WILD_BEETROOTS));
        addDrop(BFBlocks.WILD_LEEKS, WildCropDrops(BFItems.LEEK_SEEDS, BFBlocks.WILD_LEEKS));
        addDrop(BFBlocks.WILD_PASSION_FRUIT_VINE, WildCropDrops(BFItems.PASSION_FRUIT, BFBlocks.WILD_PASSION_FRUIT_VINE));
        addDrop(BFBlocks.WILD_ELDERBERRY_VINE, WildCropDrops(BFItems.ELDERBERRIES, BFBlocks.WILD_ELDERBERRY_VINE));
        addDrop(BFBlocks.WILD_MAIZE, LootTable.builder()
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
//                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WILD_MAIZE)
//                                        .properties(StatePredicate.Builder.create().exactMatch(WildMaizeBlock.HALF, DoubleBlockHalf.LOWER)))
                                .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                                .with(this.applyExplosionDecay(BFBlocks.WILD_MAIZE, ItemEntry.builder(BFItems.MAIZE_SEEDS))))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
//                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WILD_MAIZE)
//                                        .properties(StatePredicate.Builder.create().exactMatch(WildMaizeBlock.HALF, DoubleBlockHalf.LOWER)))
                                .conditionally(WITH_SILK_TOUCH_OR_SHEARS)
                                .with(this.applyExplosionDecay(BFBlocks.WILD_MAIZE, ItemEntry.builder(BFBlocks.WILD_MAIZE)))));
        addDrop(BFBlocks.MAIZE_CROP, LootTable.builder()
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.MAIZE_CROP)
                                .properties(StatePredicate.Builder.create().exactMatch(MaizeCropBlock.AGE, 7)))
                        .with(this.applyExplosionDecay(BFBlocks.MAIZE_CROP, ItemEntry.builder(BFItems.MAIZE)))));
        addDrop(BFBlocks.FELDSPAR_BLOCK);
        addDrop(BFBlocks.CUT_FELDSPAR_BLOCK);
        addDrop(BFBlocks.FELDSPAR_BRICKS);
        addDrop(BFBlocks.FELDSPAR_BRICK_STAIRS);
        addDrop(BFBlocks.FELDSPAR_BRICK_SLAB, slabDrops(BFBlocks.FELDSPAR_BRICK_SLAB));
        addDrop(BFBlocks.FELDSPAR_LANTERN);
        addDrop(BFBlocks.TINGED_GLASS, dropsWithSilkTouch(BFBlocks.TINGED_GLASS));
        addDrop(BFBlocks.CERAMIC_CLAY_BLOCK);
        addDrop(BFBlocks.FERMENTATION_VESSEL);
        addDrop(BFBlocks.GRISTMILL);
        addDrop(BFBlocks.HONEYSUCKLE);
        addDrop(BFBlocks.VIOLET_BELLFLOWER);
        addDrop(BFBlocks.SPONGEKIN_SPROUT, BFItems.SPONGEKIN_SEEDS);
        addDrop(BFBlocks.PRISMARINE_BLOSSOM, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .conditionally(WITHOUT_SILK_TOUCH)
                        .with(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_CRYSTALS)).weight(4))
                        .with(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_SHARD)).weight(2))
                        .with(EmptyEntry.builder().weight(2)))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(WITH_FORTUNE)
                        .with(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_CRYSTALS)).weight(4))
                            .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, PRISMARINE_DROP_CHANCE))
                        .with(this.applyExplosionDecay(BFBlocks.PRISMARINE_BLOSSOM, ItemEntry.builder(Items.PRISMARINE_SHARD)).weight(2))
                            .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, PRISMARINE_DROP_CHANCE)))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITH_SILK_TOUCH)
                        .with(ItemEntry.builder(BFBlocks.PRISMARINE_BLOSSOM))));
        addDrop(BFBlocks.FALLEN_WALNUTS, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.FALLEN_WALNUTS)
                                .properties(StatePredicate.Builder.create().exactMatch(FallenWalnutsBlock.COUNT, 0)))
                        .with(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS, ItemEntry.builder(BFItems.WALNUT))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.FALLEN_WALNUTS)
                                .properties(StatePredicate.Builder.create().exactMatch(FallenWalnutsBlock.COUNT, 1)))
                        .with(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS, ItemEntry.builder(BFItems.WALNUT))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.FALLEN_WALNUTS)
                                .properties(StatePredicate.Builder.create().exactMatch(FallenWalnutsBlock.COUNT, 2)))
                        .with(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS, ItemEntry.builder(BFItems.WALNUT))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(6.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.FALLEN_WALNUTS)
                                .properties(StatePredicate.Builder.create().exactMatch(FallenWalnutsBlock.COUNT, 3)))
                        .with(this.applyExplosionDecay(BFBlocks.FALLEN_WALNUTS, ItemEntry.builder(BFItems.WALNUT)))));

        addDrop(BFBlocks.LEEKS, cropDrops(BFBlocks.LEEKS, BFItems.LEEK, BFItems.LEEK_SEEDS, BlockStatePropertyLootCondition.builder(BFBlocks.LEEKS).properties(StatePredicate.Builder.create().exactMatch(BeetrootsBlock.AGE, 7))));

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

//        jackOStrawDrops(ModBlocks.MAROON_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.ROSE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.CORAL_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.GINGER_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.TAN_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.BEIGE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.AMBER_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.OLIVE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.FOREST_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.VERDANT_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.TEAL_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.MINT_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.AQUA_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.SLATE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.NAVY_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.INDIGO_JACK_O_STRAW);
//
//        jackOStrawDrops(ModBlocks.ACORN_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.ARTICHOKE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.AMBER_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.BANANA_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.CERULEAN_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.FUCHSIA_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.GRAPE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.INDIGO_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.MAROON_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.MAUVE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.MOLD_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.MINT_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.NAVY_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.PEACH_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.PERIWINKLE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.SAGE_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.SAP_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.SHAMROCK_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.VELVET_JACK_O_STRAW);
//        jackOStrawDrops(ModBlocks.VERMILION_JACK_O_STRAW);
//
//        picketsDrops(ModBlocks.WINTERGREEN_PICKETS);

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

        addDrop(BFBlocks.WALNUT_MULCH_BLOCK);
        addDrop(BFBlocks.WALNUT_MULCH, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 1)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 2)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 3)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 4)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 5)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(6.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 6)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(7.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 7)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(8.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 8)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH)))));


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
        addDrop(BFBlocks.GRASSY_DIRT, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITHOUT_SILK_TOUCH)
                        .with(this.applyExplosionDecay(BFBlocks.GRASSY_DIRT, ItemEntry.builder(Blocks.DIRT))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITH_SILK_TOUCH)
                        .with(this.applyExplosionDecay(BFBlocks.GRASSY_DIRT, ItemEntry.builder(BFBlocks.GRASSY_DIRT)))));
    }

    public void registerTrellisLootTables(TrellisVariant trellis) {
        addDrop(TrellisUtil.getTrellisFromVariant(trellis));
        for (VineCrop crop : TrellisUtil.VineCrops) {
            addDrop(TrellisUtil.getCropTrellisFromVariant(trellis, crop), LootTable.builder()
                    .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                            .with(this.applyExplosionDecay(TrellisUtil.getCropTrellisFromVariant(trellis, crop), ItemEntry.builder(TrellisUtil.getTrellisFromVariant(trellis))))));
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            addDrop(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), LootTable.builder()
                    .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                            .with(this.applyExplosionDecay(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), ItemEntry.builder(TrellisUtil.getTrellisFromVariant(trellis))))));
        }
    }

    public LootTable.Builder WildCropDrops(Item seed, Block block) {
        return LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(seed))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITH_SILK_TOUCH_OR_SHEARS)
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(block))));
    }

    public void hangingFruitDrops(Block block, Item drop) {
        addDrop(block, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(HangingFruitBlock.AGE, 4)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(drop))))
        );
    }


    public void fruitBlockDrops(Block block, Item fruitItem) {
        addDrop(block, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(FruitBlock.SLICES, 0)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(block))))

                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(FruitBlock.SLICES, 1)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(fruitItem))))

                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(FruitBlock.SLICES, 2)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(fruitItem))))

                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(FruitBlock.SLICES, 3)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(fruitItem)))));
    }

    public void picketsDrops(Block block) {
        addDrop(block, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(PicketsBlock.NORTH, true)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(block))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(PicketsBlock.EAST, true)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(block))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(PicketsBlock.SOUTH, true)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(block))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(PicketsBlock.WEST, true)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(block)))));
    }

    public void jackOStrawDrops(Block block) {
        addDrop(block, this.dropsWithProperty(block, JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }
}
