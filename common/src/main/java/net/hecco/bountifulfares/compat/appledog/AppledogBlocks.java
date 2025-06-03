package net.hecco.bountifulfares.compat.appledog;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class AppledogBlocks {
    public static final Block APPLEDOG_BLOCK = registerBlock("appledog_block", new AppledogBlock(APPLEDOG_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_BLOCK).strength(1f, 1000f)));
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(APPLEDOG_MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(APPLEDOG_MOD_ID, name), new CompatBlockItem(APPLEDOG_MOD_ID, block, new Item.Properties().rarity(Rarity.EPIC)));
    }
    public static void registerAppledogBlocks() {
    }
}
