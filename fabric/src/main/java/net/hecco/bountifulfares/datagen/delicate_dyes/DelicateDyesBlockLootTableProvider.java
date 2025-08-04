package net.hecco.bountifulfares.datagen.delicate_dyes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.definition.block.custom.JackOStrawBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.concurrent.CompletableFuture;

public class DelicateDyesBlockLootTableProvider extends FabricBlockLootTableProvider {
    public DelicateDyesBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
//        jackOStrawDrops(DelicateDyesBlocks.CORAL_JACK_O_STRAW);
//        jackOStrawDrops(DelicateDyesBlocks.CANARY_JACK_O_STRAW);
//        jackOStrawDrops(DelicateDyesBlocks.WASABI_JACK_O_STRAW);
//        jackOStrawDrops(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW);
//        jackOStrawDrops(DelicateDyesBlocks.SKY_JACK_O_STRAW);
//        jackOStrawDrops(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW);
//        jackOStrawDrops(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW);
//        jackOStrawDrops(DelicateDyesBlocks.ROSE_JACK_O_STRAW);
    }

    public void jackOStrawDrops(Block block) {
        this.add(block, this.createSinglePropConditionTable(block, JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }
}
