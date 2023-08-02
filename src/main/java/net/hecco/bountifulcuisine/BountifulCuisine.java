package net.hecco.bountifulcuisine;

import net.fabricmc.api.ModInitializer;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItemGroups;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BountifulCuisine implements ModInitializer {
	public static final String MOD_ID = "bountifulcuisine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModRegistries.RegisterModStuffs();
	}
}