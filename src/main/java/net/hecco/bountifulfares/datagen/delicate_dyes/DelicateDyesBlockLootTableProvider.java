package net.hecco.bountifulfares.datagen.delicate_dyes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.bountifulfares.block.custom.JackOStrawBlock;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DelicateDyesBlockLootTableProvider extends FabricBlockLootTableProvider {
    public DelicateDyesBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        jackOStrawDrops(DelicateDyesBlocks.CORAL_JACK_O_STRAW);
        jackOStrawDrops(DelicateDyesBlocks.CANARY_JACK_O_STRAW);
        jackOStrawDrops(DelicateDyesBlocks.WASABI_JACK_O_STRAW);
        jackOStrawDrops(DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW);
        jackOStrawDrops(DelicateDyesBlocks.SKY_JACK_O_STRAW);
        jackOStrawDrops(DelicateDyesBlocks.BLURPLE_JACK_O_STRAW);
        jackOStrawDrops(DelicateDyesBlocks.SANGRIA_JACK_O_STRAW);
        jackOStrawDrops(DelicateDyesBlocks.ROSE_JACK_O_STRAW);
    }

    public void jackOStrawDrops(Block block) {
        this.addDrop(block, this.dropsWithProperty(block, JackOStrawBlock.HALF, DoubleBlockHalf.LOWER));
    }
}
