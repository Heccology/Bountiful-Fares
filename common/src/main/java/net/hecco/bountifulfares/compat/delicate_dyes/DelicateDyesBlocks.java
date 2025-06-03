package net.hecco.bountifulfares.compat.delicate_dyes;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.compat.block.CompatJackOStrawBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static net.hecco.bountifulfares.BountifulFares.DELICATE_DYES_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class DelicateDyesBlocks {
    public static final Block CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW)));
    public static final Block CANARY_JACK_O_STRAW = registerBlock("canary_jack_o_straw", new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW)));
    public static final Block WASABI_JACK_O_STRAW = registerBlock("wasabi_jack_o_straw", new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW)));
    public static final Block SACRAMENTO_JACK_O_STRAW = registerBlock("sacramento_jack_o_straw", new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW)));
    public static final Block SKY_JACK_O_STRAW = registerBlock("sky_jack_o_straw", new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW)));
    public static final Block BLURPLE_JACK_O_STRAW = registerBlock("blurple_jack_o_straw", new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW)));
    public static final Block SANGRIA_JACK_O_STRAW = registerBlock("sangria_jack_o_straw", new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW)));
    public static final Block ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw", new CompatJackOStrawBlock(DELICATE_DYES_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(DELICATE_DYES_MOD_ID, name), new CompatBlockItem(DELICATE_DYES_MOD_ID, block, new Item.Properties()));
    }
    public static void registerPigmentPaloozaBlocks() {

    }
}
