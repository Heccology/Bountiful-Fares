package net.hecco.bountifulfares;

import com.mojang.serialization.DynamicOps;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.networking.BFMessages;
import net.hecco.bountifulfares.recipe.BFSpecialRecipes;
import net.hecco.bountifulfares.registry.content.*;
import net.hecco.bountifulfares.registry.misc.*;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.registry.util.BFDamageTypes;
import net.hecco.bountifulfares.registry.util.BFLootTableModifiers;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


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
	public static final String DUNGEONS_DELIGHT_MOD_ID = "dungeonsdelight";

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
		BFSpecialRecipes.registerSpecialRecipes();
		BFCompat.registerCompatContent();
		BFMessages.registerPayloads();
		DynamicRegistrySetupCallback.EVENT.register(registryManager -> {
			//LOGGER.info("DynamicRegistrySetupCallback triggered!");

			// Access the item registry
			registryManager.getOptional(RegistryKeys.ITEM).ifPresent(itemRegistry -> {
				LOGGER.info("Item registry is available!");
				RegistryEntry<Item> diamondEntry = itemRegistry.getEntry(Items.DIAMOND);
				LOGGER.info("Diamond Entry: " + diamondEntry);
				if (diamondEntry != null) {
					Map<TagKey<Item>, List<RegistryEntry<Item>>> map = new HashMap<>();
					map.put(BFItemTags.C_HIDDEN_FROM_RECIPE_VIEWERS, List.of(diamondEntry));
					itemRegistry.populateTags(map);
				} else {
					LOGGER.warn("Diamond entry is null!");
				}
			});
		});
	} //appledog - Yirmiri
	//appledog - Hecco
	//appledog - Diemond_Player (holy self-insert)
	//appledog - Artyrian (ew)
}