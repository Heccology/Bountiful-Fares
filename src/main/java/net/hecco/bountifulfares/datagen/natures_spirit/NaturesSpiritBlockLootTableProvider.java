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
import net.minecraft.block.Block;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class NaturesSpiritBlockLootTableProvider extends FabricBlockLootTableProvider {
    public NaturesSpiritBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public static final ArrayList<Block> usedBlocks = new ArrayList<>();

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

        for(Identifier id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
            Block block = Registries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
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
}
