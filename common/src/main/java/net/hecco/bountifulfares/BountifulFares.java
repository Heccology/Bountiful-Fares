package net.hecco.bountifulfares;

import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.integration.BFCompat;
import net.hecco.bountifulfares.registry.misc.*;
import net.hecco.bountifulfares.registry.util.BFDamageTypes;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.nexuslib.lib.compat.CompatManager;
import net.hecco.nexuslib.lib.compat.NLCompatAPI;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BountifulFares {
	public static final String MOD_ID = "bountifulfares";

	public static final String AMENDMENTS_MOD_ID = "amendments";
	public static final String NATURES_SPIRIT_MOD_ID = "natures_spirit";
	public static final String FARMERS_DELIGHT_MOD_ID = "farmersdelight";
	public static final String ETCETERA_MOD_ID = "etcetera";
	public static final String ARTS_AND_CRAFTS_MOD_ID = "arts_and_crafts";
    public static final String APPLEDOG_MOD_ID = "appledog";
	public static final String AEU_MOD_ID = "aeu";
	public static final String FRONTIERS_MOD_ID = "frontiers";
	public static final String NO_MANS_LAND_MOD_ID = "nomansland";
	public static final String TWIGS_MOD_ID = "twigs";
	public static final String JADENS_NETHER_EXPANSION_MOD_ID = "netherexp";
	public static final String DELICATE_DYES_MOD_ID = "delicate_dyes";
    public static final String EVERY_COMPAT_MOD_ID = "everycomp";
	public static final String DUNGEONSDELIGHT_MOD_ID = "dungeonsdelight";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final CompatManager COMPAT_MANAGER = NLCompatAPI.createCompatManager(MOD_ID);

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	public static ResourceLocation id(String modid, String path) {
		return ResourceLocation.fromNamespaceAndPath(modid, path);
	}

	public static void init() {
		BFSounds.registerSounds();
		BFBlocks.registerBlocks();
        BFCompat.register();
		BFBlockEntities.registerBlockEntities();
		BFComponents.registerComponents();
		BFItems.registerItems();
		BFRecipes.registerRecipes();
		BFEffects.registerEffects();
		BFParticles.registerParticles();
		BFPotions.registerPotions();
		BFTrunkPlacerTypes.registerTrunkPlacers();
		BFFeatures.register();
		BFMenus.registerScreenHandlers();
		BFEntities.registerEntities();
		BFDamageTypes.registerDamageTypes();
		BFItemGroups.registerItemGroups();
		BFRegistries.registerMiscRegistries();
		BFCriteriaTriggers.registerCriteriaTriggers();
		//TODO: Fix c2s networking on fabric
		//TODO: Add custom HarvestTrellis goal for farmer villagers
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
	//bountifulfares:cup is better than stupid ah bountifulfares:jar
	//i am here too guys -- Zeus
}