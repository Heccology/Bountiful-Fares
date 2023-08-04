package net.hecco.bountifulcuisine.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.hecco.bountifulcuisine.block.ModBlocks;

public class ModRegistries {
    public static void RegisterModStuffs() {
        registerStrippables();
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.APPLE_LOG, ModBlocks.STRIPPED_APPLE_LOG);
        StrippableBlockRegistry.register(ModBlocks.APPLE_WOOD, ModBlocks.STRIPPED_APPLE_WOOD);
        StrippableBlockRegistry.register(ModBlocks.ORANGE_LOG, ModBlocks.STRIPPED_ORANGE_LOG);
        StrippableBlockRegistry.register(ModBlocks.ORANGE_WOOD, ModBlocks.STRIPPED_ORANGE_WOOD);
        StrippableBlockRegistry.register(ModBlocks.LEMON_LOG, ModBlocks.STRIPPED_LEMON_LOG);
        StrippableBlockRegistry.register(ModBlocks.LEMON_WOOD, ModBlocks.STRIPPED_LEMON_WOOD);
        StrippableBlockRegistry.register(ModBlocks.PLUM_LOG, ModBlocks.STRIPPED_PLUM_LOG);
        StrippableBlockRegistry.register(ModBlocks.PLUM_WOOD, ModBlocks.STRIPPED_PLUM_WOOD);
    }
}
