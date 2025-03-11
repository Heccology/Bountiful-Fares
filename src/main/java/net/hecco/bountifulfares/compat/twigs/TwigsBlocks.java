package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.BountifulFares.TWIGS_MOD_ID;
import static net.hecco.bountifulfares.registry.content.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class TwigsBlocks {

    public static final Block WALNUT_TABLE = registerBlock("walnut_table", new TwigsTableBlock(BountifulFares.TWIGS_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.WALNUT_PLANKS)));
    public static final Block HOARY_TABLE = registerBlock("hoary_table", new TwigsTableBlock(BountifulFares.TWIGS_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.HOARY_PLANKS)));
    public static final Block FELDSPAR_LAMP = registerBlock("feldspar_lamp", new TwigsLampBlock(BountifulFares.TWIGS_MOD_ID, AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(4.5F).sounds(TwigsSounds.LAMP).luminance(createLightLevelFromLitBlockState(8))));


    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(TWIGS_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TWIGS_MOD_ID, name), new CompatBlockItem(TWIGS_MOD_ID, block, new Item.Settings()));
    }
    public static void registerTwigsBlocks() {

    }
}
