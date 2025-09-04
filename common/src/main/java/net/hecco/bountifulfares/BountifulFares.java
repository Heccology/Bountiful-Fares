package net.hecco.bountifulfares;

import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.misc.*;
import net.hecco.bountifulfares.registry.util.BFDamageTypes;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.heccolib.platform.HLServices;
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

	public static void init() {
//		BFResourcePacks.registerBuiltinResourcePacks(); //TODO: FIX..... idk what to do here.. me neither
		BFSounds.registerSounds();
		BFBlocks.registerBlocks();
		if (!HLServices.PLATFORM.isDatagen()) {
			BFBlockEntities.registerBlockEntities();
		}
		BFComponents.registerComponents();
		BFItems.registerItems();
		BFRecipes.registerRecipes();
		BFEffects.registerEffects();
//		//BFBoats.registerBoats();
		BFParticles.registerParticles();
		BFPotions.registerPotions();
		BFTrunkPlacerTypes.registerTrunkPlacers();
		BFFeatures.register();
		BFMenus.registerScreenHandlers();
		BFEntities.registerEntities();
		BFDamageTypes.registerDamageTypes();
//		BFCompat.registerCompatContent(); //TODO: LAST BECAUSE THERE IS SO MUCH WORK AND THIS IS NOT PRIORITY AT ALL
		BFItemGroups.registerItemGroups();
		BFRegistries.registerMiscRegistries();
		BFCriteriaTriggers.register();
	}

	//appledog - Yirmiri
	//appledog - Hecco
	//appledog - Diemond_Player (holy self-insert)
	//appledog - Artyrian (ew)
	//blueberrycat - Yirmiri
	//hey mr bountifare
	//hello stranger - mr bountifare
	//snommer - Dඞ 𝕲𝖗𝕬𝖓𝕯𝕸𝖆 lOpEro𝓼𝓷𝓞𝓶
	//okay.. - mr bountifare (again)
	//im neoing my forge rn...haheh....who else??
	//imagine recreating a port to make the port the same codebase as the original but then you remove the thing that makes it the same as the original - a salty biRCH TREE ENJOYER
	/* ill reset it all to zero - artyrian
											also what the sigma */
	//🍎
	//if you spell appledog with a b... you can call that bappledog
	//RIP diemant yunidieer :(
}