package net.hecco.bountifulfares;

import net.hecco.bountifulfares.networking.BFMessages;
import net.hecco.bountifulfares.recipe.BFSpecialRecipes;
import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.misc.*;
import net.hecco.bountifulfares.registry.util.BFDamageTypes;
import net.hecco.bountifulfares.registry.util.BFLootTableModifiers;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BountifulFares {
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
	public static final String DUNGEONS_DELIGHT_MOD_ID = "dungeonsdelight";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static BountifulFaresConfiguration CONFIG = new BountifulFaresConfiguration();

	public static void init() {
		BountifulFares.CONFIG = BountifulFaresConfiguration.load(); //TODO: MOVE TO NEOFORGE CONFIG API(?)
		BFResourcePacks.registerBuiltinResourcePacks(); //TODO: FIX..... idk what to do here
		BFItems.registerModItems();
		BFBlocks.registerModBlocks(); //TODO: UTILIZE BLOCKFAMILYCREATOR
		BFTrellises.registerTrellisParts(); //TODO: FIX
//		TrellisUtil.registerTrellisParts(); //TODO: FIX
		BFItemGroups.registerItemGroups();
		BFItemGroupAdditions.registerItemGroupAdditions(); //TODO: MOVE TO FABRIC (CREATE EQUIVALENT ON NEOFORGE,,,, OR IG MAKE A HELPER FOR THIS IN HECCOLIB)
		BFRecipes.registerRecipes();
		BFEffects.registerEffects();
		//BFBoats.registerBoats(); //TODO: FIX(???.. or just remove boats if all else fails)
		BFLootTableModifiers.modifyLootTables(); //TODO: MOVE TO FABRIC (CREATE EQUIVALENT NEOFORGE LOOT MODIFIER JSONS)
		BFParticles.registerParticles(); //TODO: MOVE TO HECCOLIB REGISTRY
		BFPotions.registerPotions();
		BFTrunkPlacerTypes.register(); //TODO: MOVE TO HECCOLIB REGISTRY
		BFFeatures.register();
		BFRegistries.RegisterModStuffs(); //TODO: FIX
		BFBlockEntities.registerBlockEntities(); //TODO: MOVE TO HECCOLIB REGISTRY
		BFScreenHandlers.registerScreenHandlers(); //TODO: MOVE TO HECCOLIB REGISTRY
		BFEntities.registerEntities(); //TODO: MOVE TO HECCOLIB REGISTRY
		BFSounds.registerSounds();
		BFDamageTypes.registerDamageTypes();
		BFSpecialRecipes.registerSpecialRecipes(); //TODO: FIX(??????????????)
		BFCompat.registerCompatContent();
		BFMessages.registerPayloads(); //TODO: FIX
	} //appledog - Yirmiri
	//appledog - Hecco
	//appledog - Diemond_Player (holy self-insert)
	//appledog - Artyrian (ew)
	//blueberrycat - Yirmiri
	//hey mr bountifare
	//hello stranger - mr bountifare
}