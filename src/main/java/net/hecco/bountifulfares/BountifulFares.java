package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.misc.*;
import net.hecco.bountifulfares.registry.util.BFDamageTypes;
import net.hecco.bountifulfares.registry.util.BFLootTableModifiers;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BountifulFares implements ModInitializer {
	public static final String MOD_ID = "bountifulfares";

	public static final String ELS_AND_LS_DYES_MOD_ID = "mint";
	public static final String DYE_DEPOT_MOD_ID = "dye_depot";
	public static final String AMENDMENTS_MOD_ID = "amendments";
	public static final String EXCESSIVE_BUILDING_MOD_ID = "excessive_building";
	public static final String DELICATE_DYES_MOD_ID = "delicate_dyes";
	public static final String NATURES_SPIRIT_MOD_ID = "natures_spirit";
	public static final String SPAWN_MOD_ID = "spawn";
	public static final String FARMERS_DELIGHT_MOD_ID = "farmersdelight";
	public static final String TWIGS_MOD_ID = "twigs";
	public static final String ETCETERA_MOD_ID = "etcetera";
	public static final String ARTS_AND_CRAFTS_MOD_ID = "arts_and_crafts";
	public static final String APPLEDOG_MOD_ID = "appledog";
	public static final String DUNGEONS_DELIGHT_MOD_ID = "dungeons_delight";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static BountifulFaresConfiguration CONFIG = new BountifulFaresConfiguration();

	public static boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}
	public static boolean isDatagen() {
		try {
			Class.forName("net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint");
			return System.getProperty("fabric-api.datagen") != null;
		} catch (ClassNotFoundException e) {
            return false;
        }
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
		BFTreeGeneration.generateTrees();
		BFFoliageGeneration.generateFlowers();
		BFEffects.registerEffects();
		BFBoats.registerBoats();
		BFLootTableModifiers.modifyLootTables();
		BFParticles.registerParticles();
		BFPotions.registerPotions();
		BFTrunkPlacerTypes.register();
		BFFeatures.register();
		BFRegistries.RegisterModStuffs();
		BFBlockEntities.registerBlockEntities();
		BFScreenHandlers.registerScreenHandlers();
		BFEntities.registerModEntities();
		BFSounds.registerSounds();
		BFDamageTypes.registerDamageTypes();
		BFCompat.registerCompatContent();
	} //appledog - Lydia
	//appledog - Hecco
}