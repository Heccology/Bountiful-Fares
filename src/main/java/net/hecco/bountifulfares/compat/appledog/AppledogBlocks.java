package net.hecco.bountifulfares.compat.appledog;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class AppledogBlocks {
    public static final Block APPLEDOG_BLOCK = registerBlock("appledog_block", new AppledogBlock(APPLEDOG_MOD_ID, AbstractBlock.Settings.copy(BFBlocks.APPLE_BLOCK).strength(1f, 1000f)));
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(APPLEDOG_MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(APPLEDOG_MOD_ID, name), new CompatBlockItem(APPLEDOG_MOD_ID, block, new Item.Settings().rarity(Rarity.EPIC)));
    }
    public static void registerAppledogBlocks() {
    }
}
