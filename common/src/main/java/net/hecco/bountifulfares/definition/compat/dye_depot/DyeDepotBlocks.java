//package net.hecco.bountifulfares.compat.dye_depot;
//
//import net.hecco.bountifulfares.compat.block.CompatBlockItem;
//import net.hecco.bountifulfares.compat.block.CompatJackOStrawBlock;
//import net.hecco.bountifulfares.registry.content.BFBlocks;
//import net.hecco.heccolib.platform.HLServices;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//
//import java.util.function.Supplier;
//
//import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;
//import static net.hecco.bountifulfares.BountifulFares.DYE_DEPOT_MOD_ID;
//import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;
//
//public class DyeDepotBlocks {
//
//    public static final Supplier<Block> MAROON_JACK_O_STRAW = registerBlock("maroon_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> ROSE_JACK_O_STRAW = registerBlock("rose_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> CORAL_JACK_O_STRAW = registerBlock("coral_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> GINGER_JACK_O_STRAW = registerBlock("ginger_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> TAN_JACK_O_STRAW = registerBlock("tan_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> BEIGE_JACK_O_STRAW = registerBlock("beige_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> AMBER_JACK_O_STRAW = registerBlock("amber_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> OLIVE_JACK_O_STRAW = registerBlock("olive_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> FOREST_JACK_O_STRAW = registerBlock("forest_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> VERDANT_JACK_O_STRAW = registerBlock("verdant_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> TEAL_JACK_O_STRAW = registerBlock("teal_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> MINT_JACK_O_STRAW = registerBlock("mint_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> AQUA_JACK_O_STRAW = registerBlock("aqua_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> SLATE_JACK_O_STRAW = registerBlock("slate_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> NAVY_JACK_O_STRAW = registerBlock("navy_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//    public static final Supplier<Block> INDIGO_JACK_O_STRAW = registerBlock("indigo_jack_o_straw", () -> new CompatJackOStrawBlock(DYE_DEPOT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.RED_JACK_O_STRAW.get())));
//
//    public static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
//        registerBlockItem(name, block);
//        compatBlocks.add(block);
//        return HLServices.REGISTRY.registerBlockNoItem(DYE_DEPOT_MOD_ID, name, block);
//    }
//
//    private static void registerBlockItem(String name, Supplier<Block> block) {
//        HLServices.REGISTRY.registerItem(DYE_DEPOT_MOD_ID, name, () -> new CompatBlockItem(DYE_DEPOT_MOD_ID, block.get(), new Item.Properties()));
//    }
//    public static void registerDyeDepotBlocks() {
//
//    }
//}
