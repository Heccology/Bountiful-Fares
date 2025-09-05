package net.hecco.bountifulfares.definition.compat.farmersdelight;

import net.hecco.bountifulfares.definition.block.integration.FDCabinetBlock;
import net.hecco.bountifulfares.definition.compat.block.CompatBlockItem;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.FARMERS_DELIGHT_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class FarmersDelightBlocks {
//    public static final Supplier<Block> WALNUT_CABINET = registerBlock("walnut_cabinet", () -> new FDCabinetBlock(FARMERS_DELIGHT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).mapColor(MapColor.COLOR_BROWN)));
//    public static final Supplier<Block> HOARY_CABINET = registerBlock("hoary_cabinet", () -> new FDCabinetBlock(FARMERS_DELIGHT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).mapColor(MapColor.TERRACOTTA_GRAY)));

    public static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return HLServices.REGISTRY.registerBlockNoItem(FARMERS_DELIGHT_MOD_ID, name, block);
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        HLServices.REGISTRY.registerItem(FARMERS_DELIGHT_MOD_ID, name, () -> new CompatBlockItem(FARMERS_DELIGHT_MOD_ID, block.get(), new Item.Properties()));
    }
    public static void registerFarmersDelightBlocks()
    {

    }
}
