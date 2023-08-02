package net.hecco.bountifulcuisine.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.hecco.bountifulcuisine.block.ModBlocks;

public class ModRegistries {
    public static void RegisterModStuffs() {
        registerStrippables();
    }

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.APPLE_LOG, ModBlocks.STRIPPED_APPLE_LOG);
    }
}
