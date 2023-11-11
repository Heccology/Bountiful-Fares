package net.hecco.bountifulcuisine;

import net.fabricmc.api.ModInitializer;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.custom.entity.ModBlockEntities;
import net.hecco.bountifulcuisine.effect.ModEffects;
import net.hecco.bountifulcuisine.entity.ModBoats;
import net.hecco.bountifulcuisine.item.ModItemGroups;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.particle.ModParticles;
import net.hecco.bountifulcuisine.potion.ModPotions;
import net.hecco.bountifulcuisine.recipe.ModRecipes;
import net.hecco.bountifulcuisine.screen.ModScreenHandlers;
import net.hecco.bountifulcuisine.util.ItemGroupAdditions;
import net.hecco.bountifulcuisine.util.ModLootTableModifiers;
import net.hecco.bountifulcuisine.util.ModRegistries;
import net.hecco.bountifulcuisine.world.gen.ModWorldGeneration;
import net.hecco.bountifulcuisine.world.tree.ModFoliagePlacerTypes;
import net.hecco.bountifulcuisine.world.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BountifulCuisine implements ModInitializer {
	public static final String MOD_ID = "bountifulcuisine";
	public static final String ELS_AND_LS_DYES_MOD_ID = "bountifulcuisine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlocks.registerElsAndLsDyesCompatibilityBlocks();
		ModBlockEntities.registerBlockEntities();
		ModItemGroups.registerItemGroups();
		ItemGroupAdditions.registerItemGroupAdditions();
		ModRegistries.RegisterModStuffs();
		ModWorldGeneration.generateModWorldGeneration();
		ModFoliagePlacerTypes.register();
		ModEffects.registerEffects();
		ModBoats.registerBoats();
		ModLootTableModifiers.modifyLootTables();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
		ModParticles.registerParticles();
		ModPotions.registerPotions();
		ModTrunkPlacerTypes.register();
	}
}