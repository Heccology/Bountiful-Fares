package net.hecco.bountifulfares.compat.farmersdelight;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.BountifulFares.FARMERS_DELIGHT_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class FarmersDelightBlocks {
//    public static final Block WALNUT_CABINET = registerBlock("walnut_cabinet", new CabinetBlock(FARMERS_DELIGHT_MOD_ID, FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.BROWN)));
//    public static final Block HOARY_CABINET = registerBlock("hoary_cabinet", new CabinetBlock(FARMERS_DELIGHT_MOD_ID, FabricBlockSettings.copyOf(Blocks.BARREL).mapColor(MapColor.TERRACOTTA_GRAY)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(FARMERS_DELIGHT_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FARMERS_DELIGHT_MOD_ID, name), new CompatBlockItem(FARMERS_DELIGHT_MOD_ID, block, new Item.Settings()));
    }
    public static void registerFarmersDelightBlocks() {

    }
}
