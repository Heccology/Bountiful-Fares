package net.hecco.bountifulfares.datagen.dungeons_delight;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.definition.block.custom.PicketsBlock;
import net.hecco.bountifulfares.definition.compat.dungeons_delight.DungeonsDelightBlocks;
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

public class DungeonsDelightBlockLootTableProvider extends FabricBlockLootTableProvider {
    public DungeonsDelightBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
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
//        registerTrellisLootTables(DungeonsDelightBlocks.WORMWOOD);
        picketsDrops(DungeonsDelightBlocks.WORMWOOD_PICKETS.get());

        for(ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.DUNGEONS_DELIGHT_MOD_ID)) {
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
