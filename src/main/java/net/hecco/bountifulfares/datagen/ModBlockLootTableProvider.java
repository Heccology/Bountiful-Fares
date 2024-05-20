package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.ModTrellises;
import net.hecco.bountifulfares.block.TrellisUtil;
import net.hecco.bountifulfares.block.TrellisVariants;
import net.hecco.bountifulfares.block.custom.*;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.block.BeetrootsBlock;
import net.minecraft.block.Block;
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


public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public static final LootCondition.Builder WITH_FORTUNE = MatchToolLootCondition.builder(net.minecraft.predicate.item.ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(1))));
    public static final float[] PRISMARINE_DROP_CHANCE = new float[]{0.0F, 0.12F, 0.15F, 0.2F};
    public static final float[] FRUIT_SAPLING_DROP_CHANCE = new float[]{0.01F, 0.05F, 0.08F, 0.1F};
    public static final float[] FLOWERING_FRUIT_SAPLING_DROP_CHANCE = new float[]{0.1F, 0.12F, 0.15F, 0.2F};
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
        addDrop(ModBlocks.WALNUT_SAPLING);
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
        addDrop(ModBlocks.WALNUT_LEAVES, leavesDrops(ModBlocks.WALNUT_LEAVES, ModBlocks.WALNUT_SAPLING, SAPLING_DROP_CHANCE));
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

        registerTrellisLootTables(ModTrellises.OAK);
        registerTrellisLootTables(ModTrellises.SPRUCE);
        registerTrellisLootTables(ModTrellises.BIRCH);
        registerTrellisLootTables(ModTrellises.JUNGLE);
        registerTrellisLootTables(ModTrellises.ACACIA);
        registerTrellisLootTables(ModTrellises.DARK_OAK);
        registerTrellisLootTables(ModTrellises.MANGROVE);
        registerTrellisLootTables(ModTrellises.CHERRY);
        registerTrellisLootTables(ModTrellises.BAMBOO);
        registerTrellisLootTables(ModTrellises.WALNUT);
        registerTrellisLootTables(ModTrellises.HOARY);
        registerTrellisLootTables(ModTrellises.CRIMSON);
        registerTrellisLootTables(ModTrellises.WARPED);

//        registerTrellisLootTables(ModTrellises.ASPEN);
//        registerTrellisLootTables(ModTrellises.CEDAR);
//        registerTrellisLootTables(ModTrellises.COCONUT);
//        registerTrellisLootTables(ModTrellises.CYPRESS);
//        registerTrellisLootTables(ModTrellises.FIR);
//        registerTrellisLootTables(ModTrellises.GHAF);
//        registerTrellisLootTables(ModTrellises.JOSHUA);
//        registerTrellisLootTables(ModTrellises.LARCH);
//        registerTrellisLootTables(ModTrellises.MAHOGANY);
//        registerTrellisLootTables(ModTrellises.MAPLE);
//        registerTrellisLootTables(ModTrellises.OLIVE);
//        registerTrellisLootTables(ModTrellises.PALO_VERDE);
//        registerTrellisLootTables(ModTrellises.REDWOOD);
//        registerTrellisLootTables(ModTrellises.SAXAUL);
//        registerTrellisLootTables(ModTrellises.SUGI);
//        registerTrellisLootTables(ModTrellises.WILLOW);
//        registerTrellisLootTables(ModTrellises.WISTERIA);


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
        addDrop(ModBlocks.WILD_WHEAT, WildCropDrops(Items.WHEAT_SEEDS, ModBlocks.WILD_WHEAT));
        addDrop(ModBlocks.WILD_CARROTS, WildCropDrops(Items.CARROT, ModBlocks.WILD_CARROTS));
        addDrop(ModBlocks.WILD_POTATOES, WildCropDrops(Items.POTATO, ModBlocks.WILD_POTATOES));
        addDrop(ModBlocks.WILD_BEETROOTS, WildCropDrops(Items.BEETROOT_SEEDS, ModBlocks.WILD_BEETROOTS));
        addDrop(ModBlocks.WILD_LEEKS, WildCropDrops(ModItems.LEEK_SEEDS, ModBlocks.WILD_LEEKS));
        addDrop(ModBlocks.WILD_PASSION_FRUIT_VINE, WildCropDrops(ModItems.PASSION_FRUIT, ModBlocks.WILD_PASSION_FRUIT_VINE));
        addDrop(ModBlocks.WILD_ELDERBERRY_VINE, WildCropDrops(ModItems.ELDERBERRIES, ModBlocks.WILD_ELDERBERRY_VINE));
        addDrop(ModBlocks.WILD_MAIZE, LootTable.builder()
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
//                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WILD_MAIZE)
//                                        .properties(StatePredicate.Builder.create().exactMatch(WildMaizeBlock.HALF, DoubleBlockHalf.LOWER)))
                                .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                                .with(this.applyExplosionDecay(ModBlocks.WILD_MAIZE, ItemEntry.builder(ModItems.MAIZE_SEEDS))))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
//                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WILD_MAIZE)
//                                        .properties(StatePredicate.Builder.create().exactMatch(WildMaizeBlock.HALF, DoubleBlockHalf.LOWER)))
                                .conditionally(WITH_SILK_TOUCH_OR_SHEARS)
                                .with(this.applyExplosionDecay(ModBlocks.WILD_MAIZE, ItemEntry.builder(ModBlocks.WILD_MAIZE)))));
        addDrop(ModBlocks.MAIZE_CROP, LootTable.builder()
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.MAIZE_CROP)
                                .properties(StatePredicate.Builder.create().exactMatch(MaizeCropBlock.AGE, 7)))
                        .with(this.applyExplosionDecay(ModBlocks.MAIZE_CROP, ItemEntry.builder(ModItems.MAIZE)))));
        addDrop(ModBlocks.FELDSPAR_BLOCK);
        addDrop(ModBlocks.CUT_FELDSPAR_BLOCK);
        addDrop(ModBlocks.FELDSPAR_BRICKS);
        addDrop(ModBlocks.FELDSPAR_BRICK_STAIRS);
        addDrop(ModBlocks.FELDSPAR_BRICK_SLAB);
        addDrop(ModBlocks.FELDSPAR_LANTERN);
        addDrop(ModBlocks.TINGED_GLASS, dropsWithSilkTouch(ModBlocks.TINGED_GLASS));
        addDrop(ModBlocks.CERAMIC_CLAY_BLOCK);
        addDrop(ModBlocks.FERMENTATION_VESSEL);
        addDrop(ModBlocks.GRISTMILL);
        addDrop(ModBlocks.HONEYSUCKLE);
        addDrop(ModBlocks.VIOLET_BELLFLOWER);
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

        addDrop(ModBlocks.LEEKS, cropDrops(ModBlocks.LEEKS, ModItems.LEEK, ModItems.LEEK_SEEDS, BlockStatePropertyLootCondition.builder(ModBlocks.LEEKS).properties(StatePredicate.Builder.create().exactMatch(BeetrootsBlock.AGE, 7))));

        jackOStrawDrops(ModBlocks.RED_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.ORANGE_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.YELLOW_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.LIME_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.GREEN_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.CYAN_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.LIGHT_BLUE_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.BLUE_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.PURPLE_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.MAGENTA_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.PINK_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.WHITE_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.LIGHT_GRAY_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.GRAY_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.BLACK_JACK_O_STRAW);
        jackOStrawDrops(ModBlocks.BROWN_JACK_O_STRAW);

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

        picketsDrops(ModBlocks.OAK_PICKETS);
        picketsDrops(ModBlocks.BIRCH_PICKETS);
        picketsDrops(ModBlocks.SPRUCE_PICKETS);
        picketsDrops(ModBlocks.JUNGLE_PICKETS);
        picketsDrops(ModBlocks.ACACIA_PICKETS);
        picketsDrops(ModBlocks.DARK_OAK_PICKETS);
        picketsDrops(ModBlocks.MANGROVE_PICKETS);
        picketsDrops(ModBlocks.CHERRY_PICKETS);
        picketsDrops(ModBlocks.BAMBOO_PICKETS);
        picketsDrops(ModBlocks.WALNUT_PICKETS);
        picketsDrops(ModBlocks.HOARY_PICKETS);
        picketsDrops(ModBlocks.CRIMSON_PICKETS);
        picketsDrops(ModBlocks.WARPED_PICKETS);

        addDrop(ModBlocks.WALNUT_MULCH_BLOCK);
        addDrop(ModBlocks.WALNUT_MULCH, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 1)))
                        .with(this.applyExplosionDecay(ModBlocks.WALNUT_MULCH, ItemEntry.builder(ModBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 2)))
                        .with(this.applyExplosionDecay(ModBlocks.WALNUT_MULCH, ItemEntry.builder(ModBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 3)))
                        .with(this.applyExplosionDecay(ModBlocks.WALNUT_MULCH, ItemEntry.builder(ModBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 4)))
                        .with(this.applyExplosionDecay(ModBlocks.WALNUT_MULCH, ItemEntry.builder(ModBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 5)))
                        .with(this.applyExplosionDecay(ModBlocks.WALNUT_MULCH, ItemEntry.builder(ModBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(6.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 6)))
                        .with(this.applyExplosionDecay(ModBlocks.WALNUT_MULCH, ItemEntry.builder(ModBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(7.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 7)))
                        .with(this.applyExplosionDecay(ModBlocks.WALNUT_MULCH, ItemEntry.builder(ModBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(8.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(WalnutMulchBlock.LAYERS, 8)))
                        .with(this.applyExplosionDecay(ModBlocks.WALNUT_MULCH, ItemEntry.builder(ModBlocks.WALNUT_MULCH)))));


        fruitBlockDrops(ModBlocks.APPLE_BLOCK, Items.APPLE);
        fruitBlockDrops(ModBlocks.GOLDEN_APPLE_BLOCK, Items.GOLDEN_APPLE);
        fruitBlockDrops(ModBlocks.ORANGE_BLOCK, ModItems.ORANGE);
        fruitBlockDrops(ModBlocks.LEMON_BLOCK, ModItems.LEMON);
        fruitBlockDrops(ModBlocks.PLUM_BLOCK, ModItems.PLUM);
        fruitBlockDrops(ModBlocks.HOARY_APPLE_BLOCK, ModItems.HOARY_APPLE);

        hangingFruitDrops(ModBlocks.HANGING_APPLE, Items.APPLE);
        hangingFruitDrops(ModBlocks.HANGING_ORANGE, ModItems.ORANGE);
        hangingFruitDrops(ModBlocks.HANGING_LEMON, ModItems.LEMON);
        hangingFruitDrops(ModBlocks.HANGING_PLUM, ModItems.PLUM);
        hangingFruitDrops(ModBlocks.HANGING_HOARY_APPLE, ModItems.HOARY_APPLE);

    }

    public void registerTrellisLootTables(TrellisVariant trellis) {
        addDrop(TrellisUtil.getTrellisFromVariant(trellis));
        for (VineCrop crop : TrellisVariants.VineCrops) {
            addDrop(TrellisUtil.getCropTrellisFromVariant(trellis, crop), LootTable.builder()
                    .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                            .with(this.applyExplosionDecay(TrellisUtil.getCropTrellisFromVariant(trellis, crop), ItemEntry.builder(TrellisUtil.getTrellisFromVariant(trellis))))));
        }
        for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
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
