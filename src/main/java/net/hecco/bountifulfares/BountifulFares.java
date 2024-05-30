package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.trellis.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.block.entity.BFBlockEntities;
import net.hecco.bountifulfares.compat.BFResourcePacks;
import net.hecco.bountifulfares.effect.BFEffects;
import net.hecco.bountifulfares.entity.BFBoats;
import net.hecco.bountifulfares.painting.BFPaintings;
import net.hecco.bountifulfares.particle.BFParticles;
import net.hecco.bountifulfares.potion.BFPotions;
import net.hecco.bountifulfares.recipe.BFRecipes;
import net.hecco.bountifulfares.screen.BFScreenHandlers;
import net.hecco.bountifulfares.sounds.BFSounds;
import net.hecco.bountifulfares.util.BFItemGroupAdditions;
import net.hecco.bountifulfares.util.BFItemGroups;
import net.hecco.bountifulfares.util.BFLootTableModifiers;
import net.hecco.bountifulfares.util.BFRegistries;
import net.hecco.bountifulfares.world.gen.BFWorldGeneration;
import net.hecco.bountifulfares.world.tree.BFTreeDecoratorTypes;
import net.hecco.bountifulfares.world.tree.BFTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BountifulFares implements ModInitializer {
	public static final String MOD_ID = "bountifulfares";

	// modid used for features that should only register if El's and L's Dye Mod is installed, like itemgroups.
	public static final String ELS_AND_LS_DYES_MOD_ID = "mint";
	public static final String DYE_DEPOT_MOD_ID = "dye_depot";
	public static final String AMENDMENTS_MOD_ID = "amendments";
	public static final String EXCESSIVE_BUILDING_MOD_ID = "excessive_building";
	public static final String NATURES_SPIRIT_MOD_ID = "natures_spirit";
	public static final String SPAWN_MOD_ID = "spawn";
	public static final String FARMERS_DELIGHT_MOD_ID = "farmersdelight";
	public static final String DRAMATIC_DOORS_MOD_ID = "dramaticdoors";
	public static final String TWIGS_MOD_ID = "twigs";
	public static final String ETCETERA_MOD_ID = "etcetera";
	public static final String WILDER_WILD_MOD_ID = "wilderwild";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static BountifulFaresConfiguration CONFIG = new BountifulFaresConfiguration();

	public static boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}
	public static boolean isDatagen() {
		return System.getProperty("fabric-api.datagen") != null;
	}
	@Override
	public void onInitialize() {
		BountifulFares.CONFIG = BountifulFaresConfiguration.load();
		BFResourcePacks.registerBuiltinResourcePacks();
		BFItems.registerModItems();
		BFBlocks.registerModBlocks();
		BFTrellises.registerTrellisParts();
		TrellisUtil.registerTrellisParts();
		BFItemGroups.registerItemGroups();
		BFItemGroupAdditions.registerItemGroupAdditions();
		BFRecipes.registerRecipes();
		BFWorldGeneration.generateModWorldGeneration();
		BFEffects.registerEffects();
		BFBoats.registerBoats();
		BFLootTableModifiers.modifyLootTables();
		BFScreenHandlers.registerScreenHandlers();
		BFParticles.registerParticles();
		BFPotions.registerPotions();
		BFTrunkPlacerTypes.register();
		BFTreeDecoratorTypes.register();
		BFPaintings.registerPaintings();
		BFRegistries.RegisterModStuffs();
		BFBlockEntities.registerBlockEntities();
		BFSounds.registerSounds();
	}
}