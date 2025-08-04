//package net.hecco.bountifulfares.compat.twigs;
//
//import net.hecco.bountifulfares.BountifulFares;
//import net.hecco.bountifulfares.compat.block.CompatBlockItem;
//import net.hecco.bountifulfares.registry.content.BFBlocks;
//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraft.world.level.material.MapColor;
//
//import static net.hecco.bountifulfares.BountifulFares.TWIGS_MOD_ID;
//import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;
//import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;
//
//public class TwigsBlocks {
//
//    public static final Block WALNUT_TABLE = registerBlock("walnut_table", new TwigsTableBlock(BountifulFares.TWIGS_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.WALNUT_PLANKS)));
//    public static final Block HOARY_TABLE = registerBlock("hoary_table", new TwigsTableBlock(BountifulFares.TWIGS_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.HOARY_PLANKS)));
//    public static final Block FELDSPAR_LAMP = registerBlock("feldspar_lamp", new TwigsLampBlock(BountifulFares.TWIGS_MOD_ID, BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(4.5F).sound(TwigsSounds.LAMP).lightLevel(createLightLevelFromLitBlockState(8))));
//
//
//    public static Block registerBlock(String name, Block block) {
//        registerBlockItem(name, block);
//        compatBlocks.add(block);
//        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(TWIGS_MOD_ID, name), block);
//    }
//    private static void registerBlockItem(String name, Block block) {
//        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(TWIGS_MOD_ID, name), new CompatBlockItem(TWIGS_MOD_ID, block, new Item.Properties()));
//    }
//    public static void registerTwigsBlocks() {
//
//    }
//}
