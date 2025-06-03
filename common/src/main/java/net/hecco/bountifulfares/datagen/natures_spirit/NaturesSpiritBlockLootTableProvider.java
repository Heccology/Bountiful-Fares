package net.hecco.bountifulfares.datagen.natures_spirit;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class NaturesSpiritBlockLootTableProvider extends FabricBlockLootTableProvider {
    public NaturesSpiritBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public static final ArrayList<Block> usedBlocks = new ArrayList<>();

    @Override
    public void add(Block block, LootTable.Builder lootTable) {
        if(usedBlocks.contains(block)) {
            return;
        }
        super.add(block, lootTable);
        usedBlocks.add(block);
    }

    @Override
    public void generate() {
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

        for(ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
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
}
