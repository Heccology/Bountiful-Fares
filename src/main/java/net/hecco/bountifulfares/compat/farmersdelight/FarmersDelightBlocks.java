package net.hecco.bountifulfares.compat.farmersdelight;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import static net.hecco.bountifulfares.BountifulFares.FARMERS_DELIGHT_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class FarmersDelightBlocks {
    public static final Block WALNUT_CABINET = registerBlock("walnut_cabinet", new CabinetBlock(FARMERS_DELIGHT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).mapColor(MapColor.COLOR_BROWN)));
    public static final Block HOARY_CABINET = registerBlock("hoary_cabinet", new CabinetBlock(FARMERS_DELIGHT_MOD_ID, BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).mapColor(MapColor.TERRACOTTA_GRAY)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(FARMERS_DELIGHT_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(FARMERS_DELIGHT_MOD_ID, name), new CompatBlockItem(FARMERS_DELIGHT_MOD_ID, block, new Item.Properties()));
    }
    public static void registerFarmersDelightBlocks()
    {

    }
}
