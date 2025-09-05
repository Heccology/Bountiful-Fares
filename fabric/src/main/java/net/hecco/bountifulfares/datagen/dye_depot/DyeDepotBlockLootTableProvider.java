package net.hecco.bountifulfares.datagen.dye_depot;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresUtil;
import net.hecco.bountifulfares.definition.block.custom.JackOStrawBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class DyeDepotBlockLootTableProvider extends FabricBlockLootTableProvider {
    public DyeDepotBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
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
//        jackOStrawDrops(DyeDepotBlocks.MAROON_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.ROSE_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.CORAL_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.GINGER_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.TAN_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.BEIGE_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.AMBER_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.OLIVE_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.FOREST_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.VERDANT_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.TEAL_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.MINT_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.AQUA_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.SLATE_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.NAVY_JACK_O_STRAW);
//        jackOStrawDrops(DyeDepotBlocks.INDIGO_JACK_O_STRAW);

        for(ResourceLocation id : BountifulFaresUtil.allBlockIdsInNamespace(BountifulFares.DYE_DEPOT_MOD_ID)) {
            Block block = BuiltInRegistries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.dropSelf(block);
        }
    }

    public void jackOStrawDrops(Block block) {
        this.add(block, this.createSinglePropConditionTable(block, JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }
}
