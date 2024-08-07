package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
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
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

import static net.hecco.bountifulfares.compat.BFCompat.compatBlocks;


public class BFBlockLootTableProvider extends FabricBlockLootTableProvider {
    public static final ArrayList<Block> usedBlocks = new ArrayList<>();

    public static final LootCondition.Builder WITH_FORTUNE = MatchToolLootCondition.builder(net.minecraft.predicate.item.ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.FORTUNE, NumberRange.IntRange.atLeast(1))));
    public static final float[] PRISMARINE_DROP_CHANCE = new float[]{0.0F, 0.12F, 0.15F, 0.2F};
    public static final float[] FRUIT_SAPLING_DROP_CHANCE = new float[]{0.01F, 0.05F, 0.08F, 0.1F};
    public static final float[] FLOWERING_FRUIT_SAPLING_DROP_CHANCE = new float[]{0.1F, 0.12F, 0.15F, 0.2F};
    public BFBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void addDrop(Block block, LootTable.Builder lootTable) {
        if(usedBlocks.contains(block)) {
            return;
        }
        super.addDrop(block, lootTable);
        usedBlocks.add(block);
    }

    @Override
    public void generate() {
        addDrop(BFBlocks.APPLE_LEAVES, leavesDrops(BFBlocks.APPLE_LEAVES, BFBlocks.APPLE_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.FLOWERING_APPLE_LEAVES, leavesDrops(BFBlocks.FLOWERING_APPLE_LEAVES, BFBlocks.APPLE_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.ORANGE_LEAVES, leavesDrops(BFBlocks.ORANGE_LEAVES, BFBlocks.ORANGE_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.FLOWERING_ORANGE_LEAVES, leavesDrops(BFBlocks.FLOWERING_ORANGE_LEAVES, BFBlocks.ORANGE_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.LEMON_LEAVES, leavesDrops(BFBlocks.LEMON_LEAVES, BFBlocks.LEMON_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.FLOWERING_LEMON_LEAVES, leavesDrops(BFBlocks.FLOWERING_LEMON_LEAVES, BFBlocks.LEMON_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.PLUM_LEAVES, leavesDrops(BFBlocks.PLUM_LEAVES, BFBlocks.PLUM_SAPLING, FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.FLOWERING_PLUM_LEAVES, leavesDrops(BFBlocks.FLOWERING_PLUM_LEAVES, BFBlocks.PLUM_SAPLING, FLOWERING_FRUIT_SAPLING_DROP_CHANCE));
        addDrop(BFBlocks.HOARY_APPLE_SAPLING_CROP, BFItems.HOARY_SEEDS);
        addDrop(BFBlocks.HOARY_SLAB, slabDrops(BFBlocks.HOARY_SLAB));
        addDrop(BFBlocks.HOARY_DOOR, doorDrops(BFBlocks.HOARY_DOOR));
        addDrop(BFBlocks.HOARY_LEAVES, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                        .with((this.applyExplosionDecay(BFBlocks.HOARY_LEAVES, ItemEntry.builder(Items.STICK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))))
                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, LEAVES_STICK_DROP_CHANCE))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WITH_SILK_TOUCH_OR_SHEARS)
                        .with(ItemEntry.builder(BFBlocks.HOARY_LEAVES))));
        addDrop(BFBlocks.WALNUT_SLAB, slabDrops(BFBlocks.WALNUT_SLAB));
        addDrop(BFBlocks.WALNUT_DOOR, doorDrops(BFBlocks.WALNUT_DOOR));
        addDrop(BFBlocks.WALNUT_LEAVES, leavesDrops(BFBlocks.WALNUT_LEAVES, BFBlocks.WALNUT_SAPLING, SAPLING_DROP_CHANCE));

        picketsDrops(NaturesSpiritBlocks.ASPEN_PICKETS);
        picketsDrops(NaturesSpiritBlocks.CEDAR_PICKETS);
        picketsDrops(NaturesSpiritBlocks.COCONUT_PICKETS);
        picketsDrops(NaturesSpiritBlocks.CYPRESS_PICKETS);
        picketsDrops(NaturesSpiritBlocks.FIR_PICKETS);
        picketsDrops(NaturesSpiritBlocks.GHAF_PICKETS);
        picketsDrops(NaturesSpiritBlocks.JOSHUA_PICKETS);
        picketsDrops(NaturesSpiritBlocks.LARCH_PICKETS);
        picketsDrops(NaturesSpiritBlocks.MAHOGANY_PICKETS);
        picketsDrops(NaturesSpiritBlocks.MAPLE_PICKETS);
        picketsDrops(NaturesSpiritBlocks.OLIVE_PICKETS);
        picketsDrops(NaturesSpiritBlocks.PALO_VERDE_PICKETS);
        picketsDrops(NaturesSpiritBlocks.REDWOOD_PICKETS);
        picketsDrops(NaturesSpiritBlocks.MAHOGANY_PICKETS);
        picketsDrops(NaturesSpiritBlocks.SAXAUL_PICKETS);
        picketsDrops(NaturesSpiritBlocks.SUGI_PICKETS);
        picketsDrops(NaturesSpiritBlocks.WILLOW_PICKETS);
        picketsDrops(NaturesSpiritBlocks.WISTERIA_PICKETS);

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
//        registerTrellisLootTables(BFTrellises.CORK);
//        registerTrellisLootTables(BFTrellises.BAOBAB);
//        registerTrellisLootTables(BFTrellises.WW_CYPRESS);
//        registerTrellisLootTables(BFTrellises.PALM);
        registerTrellisLootTables(ExcessiveBuildingBlocks.ANCIENT);
        registerTrellisLootTables(MintBlocks.WINTERGREEN);
        registerTrellisLootTables(SpawnBlocks.ROTTEN);
        registerTrellisLootTables(ArtsAndCraftsBlocks.CORK);

        registerTrellisLootTables(NaturesSpiritBlocks.ASPEN);
        registerTrellisLootTables(NaturesSpiritBlocks.CEDAR);
        registerTrellisLootTables(NaturesSpiritBlocks.COCONUT);
        registerTrellisLootTables(NaturesSpiritBlocks.CYPRESS);
        registerTrellisLootTables(NaturesSpiritBlocks.FIR);
        registerTrellisLootTables(NaturesSpiritBlocks.GHAF);
        registerTrellisLootTables(NaturesSpiritBlocks.JOSHUA);
        registerTrellisLootTables(NaturesSpiritBlocks.LARCH);
        registerTrellisLootTables(NaturesSpiritBlocks.MAHOGANY);
        registerTrellisLootTables(NaturesSpiritBlocks.MAPLE);
        registerTrellisLootTables(NaturesSpiritBlocks.OLIVE);
        registerTrellisLootTables(NaturesSpiritBlocks.PALO_VERDE);
        registerTrellisLootTables(NaturesSpiritBlocks.REDWOOD);
        registerTrellisLootTables(NaturesSpiritBlocks.SAXAUL);
        registerTrellisLootTables(NaturesSpiritBlocks.SUGI);
        registerTrellisLootTables(NaturesSpiritBlocks.WILLOW);
        registerTrellisLootTables(NaturesSpiritBlocks.WISTERIA);

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
        addDrop(BFBlocks.FELDSPAR_BRICK_SLAB, slabDrops(BFBlocks.FELDSPAR_BRICK_SLAB));
        addDrop(BFBlocks.TINGED_GLASS, dropsWithSilkTouch(BFBlocks.TINGED_GLASS));
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

        jackOStrawDrops(DyeDepotBlocks.MAROON_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.ROSE_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.CORAL_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.GINGER_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.TAN_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.BEIGE_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.AMBER_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.OLIVE_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.FOREST_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.VERDANT_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.TEAL_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.MINT_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.AQUA_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.SLATE_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.NAVY_JACK_O_STRAW);
        jackOStrawDrops(DyeDepotBlocks.INDIGO_JACK_O_STRAW);

        jackOStrawDrops(MintBlocks.ACORN_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.ARTICHOKE_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.AMBER_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.BANANA_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.CERULEAN_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.FUCHSIA_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.GRAPE_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.INDIGO_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.MAROON_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.MAUVE_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.MOLD_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.MINT_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.NAVY_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.PEACH_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.PERIWINKLE_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.SAGE_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.SAP_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.SHAMROCK_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.VELVET_JACK_O_STRAW);
        jackOStrawDrops(MintBlocks.VERMILION_JACK_O_STRAW);
        picketsDrops(MintBlocks.WINTERGREEN_PICKETS);

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
        picketsDrops(ExcessiveBuildingBlocks.ANCIENT_PICKETS);
        picketsDrops(SpawnBlocks.ROTTEN_PICKETS);
        picketsDrops(ArtsAndCraftsBlocks.CORK_PICKETS);


        addDrop(BFBlocks.WALNUT_MULCH, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 1)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 2)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 3)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 4)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 5)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(6.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 6)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(7.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 7)))
                        .with(this.applyExplosionDecay(BFBlocks.WALNUT_MULCH, ItemEntry.builder(BFBlocks.WALNUT_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(8.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALNUT_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 8)))
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


        addDrop(BFBlocks.PALM_MULCH, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 1)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_MULCH, ItemEntry.builder(BFBlocks.PALM_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 2)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_MULCH, ItemEntry.builder(BFBlocks.PALM_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 3)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_MULCH, ItemEntry.builder(BFBlocks.PALM_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(4.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 4)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_MULCH, ItemEntry.builder(BFBlocks.PALM_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 5)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_MULCH, ItemEntry.builder(BFBlocks.PALM_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(6.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 6)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_MULCH, ItemEntry.builder(BFBlocks.PALM_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(7.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 7)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_MULCH, ItemEntry.builder(BFBlocks.PALM_MULCH))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(8.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_MULCH)
                                .properties(StatePredicate.Builder.create().exactMatch(MulchBlock.LAYERS, 8)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_MULCH, ItemEntry.builder(BFBlocks.PALM_MULCH)))));
        addDrop(BFBlocks.COIR_BRICK_SLAB, slabDrops(BFBlocks.COIR_BRICK_SLAB));
        addDrop(BFBlocks.PALM_FROND, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_FROND)
                                .properties(StatePredicate.Builder.create().exactMatch(PalmFrondBlock.SIZE, 0)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_FROND, ItemEntry.builder(BFItems.PALM_FROND))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_FROND)
                                .properties(StatePredicate.Builder.create().exactMatch(PalmFrondBlock.SIZE, 1)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_FROND, ItemEntry.builder(BFItems.PALM_FROND))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.PALM_FROND)
                                .properties(StatePredicate.Builder.create().exactMatch(PalmFrondBlock.SIZE, 2)))
                        .with(this.applyExplosionDecay(BFBlocks.PALM_FROND, ItemEntry.builder(BFItems.PALM_FROND))))
        );
        addDrop(BFBlocks.WALL_PALM_FROND, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALL_PALM_FROND)
                                .properties(StatePredicate.Builder.create().exactMatch(WallPalmFrondBlock.SIZE, 0)))
                        .with(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND, ItemEntry.builder(BFItems.PALM_FROND))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALL_PALM_FROND)
                                .properties(StatePredicate.Builder.create().exactMatch(WallPalmFrondBlock.SIZE, 1)))
                        .with(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND, ItemEntry.builder(BFItems.PALM_FROND))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F))
                        .conditionally(BlockStatePropertyLootCondition.builder(BFBlocks.WALL_PALM_FROND)
                                .properties(StatePredicate.Builder.create().exactMatch(WallPalmFrondBlock.SIZE, 2)))
                        .with(this.applyExplosionDecay(BFBlocks.WALL_PALM_FROND, ItemEntry.builder(BFItems.PALM_FROND))))
        );
        addPottedPlantDrops(BFBlocks.POTTED_HONEYSUCKLE);
        addPottedPlantDrops(BFBlocks.POTTED_APPLE_SAPLING);
        addPottedPlantDrops(BFBlocks.POTTED_ORANGE_SAPLING);
        addPottedPlantDrops(BFBlocks.POTTED_LEMON_SAPLING);
        addPottedPlantDrops(BFBlocks.POTTED_PLUM_SAPLING);
        addPottedPlantDrops(BFBlocks.POTTED_HOARY_APPLE_SAPLING);
        addPottedPlantDrops(BFBlocks.POTTED_WALNUT_SAPLING);
        addPottedPlantDrops(BFBlocks.POTTED_VIOLET_BELLFLOWER);
        addPottedPlantDrops(BFBlocks.POTTED_PALM_FROND);
        addDrop(BFBlocks.PALM_SAPLING, BFItems.COCONUT);


        usedBlocks.add(BFBlocks.APPLE_PIE);
        usedBlocks.add(BFBlocks.ARTISAN_BREAD);
        usedBlocks.add(BFBlocks.ARTISAN_COOKIES);
        usedBlocks.add(BFBlocks.CERAMIC_BUTTON);
        usedBlocks.add(BFBlocks.CERAMIC_DISH);
        usedBlocks.add(BFBlocks.CERAMIC_DOOR);
        usedBlocks.add(BFBlocks.CERAMIC_LEVER);
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC);
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC_SLAB);
        usedBlocks.add(BFBlocks.CERAMIC_MOSAIC_STAIRS);
        usedBlocks.add(BFBlocks.CERAMIC_PRESSURE_PLATE);
        usedBlocks.add(BFBlocks.CERAMIC_TILE_PILLAR);
        usedBlocks.add(BFBlocks.CERAMIC_TILE_SLAB);
        usedBlocks.add(BFBlocks.CERAMIC_TILE_STAIRS);
        usedBlocks.add(BFBlocks.CERAMIC_TILES);
        usedBlocks.add(BFBlocks.CERAMIC_TRAPDOOR);
        usedBlocks.add(BFBlocks.CHAMOMILE_FLOWERS);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILE_SLAB);
        usedBlocks.add(BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS);
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
        usedBlocks.add(BFBlocks.SWEET_BERRY_TART);
        usedBlocks.add(BFBlocks.TEA_SHRUB);
        usedBlocks.add(BFBlocks.SPONGEKIN);






        addDrop(FarmersDelightBlocks.WALNUT_CABINET);
        addDrop(FarmersDelightBlocks.HOARY_CABINET);

        addDrop(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB, slabDrops(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB));
        addDrop(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB, slabDrops(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB));
        picketsDrops(ExcessiveBuildingBlocks.ANCIENT_PICKETS);


        for(Identifier id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.MOD_ID)) {
            Block block = Registries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.addDrop(block);
        }

        for(Identifier id : BountifulFaresUtil.allCompatBlockIds()) {
            Block block = Registries.BLOCK.get(id);
            if(usedBlocks.contains(block) || !compatBlocks.contains(block)) { continue; }
            this.addDrop(block);
        }
    }

    public void registerTrellisLootTables(TrellisVariant trellis) {
        this.addDrop(TrellisUtil.getTrellisFromVariant(trellis));
        for (VineCrop crop : TrellisUtil.VineCrops) {
            this.addDrop(TrellisUtil.getCropTrellisFromVariant(trellis, crop), LootTable.builder()
                    .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                            .with(this.applyExplosionDecay(TrellisUtil.getCropTrellisFromVariant(trellis, crop), ItemEntry.builder(TrellisUtil.getTrellisFromVariant(trellis))))));
        }
        for (DecorativeVine vine : TrellisUtil.DecorativeVines) {
            this.addDrop(TrellisUtil.getDecorTrellisFromVariant(trellis, vine), LootTable.builder()
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
        this.addDrop(block, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                .properties(StatePredicate.Builder.create().exactMatch(HangingFruitBlock.AGE, 4)))
                        .with(this.applyExplosionDecay(block, ItemEntry.builder(drop))))
        );
    }


    public void fruitBlockDrops(Block block, Item fruitItem) {
        this.addDrop(block, LootTable.builder()
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
        usedBlocks.add(block);
    }

    public void picketsDrops(Block block) {
        this.addDrop(block, LootTable.builder()
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
        this.addDrop(block, this.dropsWithProperty(block, JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }
}
