package net.hecco.bountifulfares.compat.twigs;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.sounds.BFSounds;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.BountifulFares.TWIGS_MOD_ID;
import static net.hecco.bountifulfares.block.BFBlocks.createLightLevelFromLitBlockState;
import static net.hecco.bountifulfares.compat.BFCompat.compatBlocks;

public class TwigsBlocks {

    public static final Block WALNUT_TABLE = registerBlock("walnut_table", new TwigsTableBlock(FabricBlockSettings.copyOf(BFBlocks.WALNUT_PLANKS)));
    public static final Block HOARY_TABLE = registerBlock("hoary_table", new TwigsTableBlock(FabricBlockSettings.copyOf(BFBlocks.HOARY_PLANKS)));
    public static final Block FELDSPAR_LAMP = registerBlock("feldspar_lamp", new TwigsLampBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(4.5F).sounds(TwigsSounds.LAMP).luminance(createLightLevelFromLitBlockState(8))));


    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, new Identifier(TWIGS_MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(TWIGS_MOD_ID, name), new CompatBlockItem(TWIGS_MOD_ID, block, new FabricItemSettings()));
    }
    public static void registerTwigsBlocks() {

    }
}
