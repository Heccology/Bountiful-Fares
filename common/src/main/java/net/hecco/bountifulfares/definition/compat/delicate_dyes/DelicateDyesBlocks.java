package net.hecco.bountifulfares.definition.compat.delicate_dyes;

import net.hecco.bountifulfares.definition.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.definition.compat.block.CompatJackOStrawBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.*;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DelicateDyesBlocks {
    public static final Supplier<Block> CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final Supplier<Block> CANARY_JACK_O_STRAW = registerBlock("canary_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final Supplier<Block> WASABI_JACK_O_STRAW = registerBlock("wasabi_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final Supplier<Block> SACRAMENTO_JACK_O_STRAW = registerBlock("sacramento_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final Supplier<Block> SKY_JACK_O_STRAW = registerBlock("sky_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final Supplier<Block> BLURPLE_JACK_O_STRAW = registerBlock("blurple_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final Supplier<Block> SANGRIA_JACK_O_STRAW = registerBlock("sangria_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
    public static final Supplier<Block> ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw", () -> new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));

    public static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return HLServices.REGISTRY.registerBlockNoItem(DUNGEONS_DELIGHT_MOD_ID, name, block);
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        HLServices.REGISTRY.registerItem(DUNGEONS_DELIGHT_MOD_ID, name, () -> new CompatBlockItem(DUNGEONS_DELIGHT_MOD_ID, block.get(), new Item.Properties()));
    }
    public static void registerPigmentPaloozaBlocks() {

    }
}
