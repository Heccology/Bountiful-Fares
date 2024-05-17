package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.ModTrellises;
import net.hecco.bountifulfares.block.TrellisVariants;
import net.hecco.bountifulfares.block.entity.ModBlockEntities;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.compat.ModResourcePacks;
import net.hecco.bountifulfares.effect.ModEffects;
import net.hecco.bountifulfares.entity.ModBoats;
import net.hecco.bountifulfares.item.ModItems;
import net.hecco.bountifulfares.painting.ModPaintings;
import net.hecco.bountifulfares.particle.ModParticles;
import net.hecco.bountifulfares.potion.ModPotions;
import net.hecco.bountifulfares.recipe.ModRecipes;
import net.hecco.bountifulfares.screen.ModScreenHandlers;
import net.hecco.bountifulfares.sounds.ModSounds;
import net.hecco.bountifulfares.util.ItemGroupAdditions;
import net.hecco.bountifulfares.util.ModItemGroups;
import net.hecco.bountifulfares.util.ModLootTableModifiers;
import net.hecco.bountifulfares.util.ModRegistries;
import net.hecco.bountifulfares.world.gen.ModWorldGeneration;
import net.hecco.bountifulfares.world.tree.ModFoliagePlacerTypes;
import net.hecco.bountifulfares.world.tree.ModTreeDecoratorTypes;
import net.hecco.bountifulfares.world.tree.ModTrunkPlacerTypes;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class BountifulFares implements ModInitializer {
	public static final String MOD_ID = "bountifulfares";

	// modid used for features that should only register if El's and L's Dye Mod is installed, like itemgroups.
	public static final String ELS_AND_LS_DYES_MOD_ID = "mint";
	public static final String DYE_DEPOT_MOD_ID = "dye_depot";
	public static final String AMENDMENTS_MOD_ID = "amendments";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static BountifulFaresConfiguration CONFIG = new BountifulFaresConfiguration();
	@Override
	public void onInitialize() {
		BountifulFares.CONFIG = BountifulFaresConfiguration.load();
		ModResourcePacks.registerBuiltinResourcePacks();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlocks.registerElsAndLsDyesBlocks();
		ModBlocks.registerDyeDepotBlocks();
		ModTrellises.registerTrellisParts();
		TrellisVariants.registerTrellises();
//		FabricLoader.getInstance().getEntrypoints("net.fabricmc.api.ModInitializer", BountifulFares.class).forEach(entrypoint -> {
//				TrellisVariants.registerTrellises();
//		});
		ModItemGroups.registerItemGroups();
		ItemGroupAdditions.registerItemGroupAdditions();
		ModRecipes.registerRecipes();
		ModWorldGeneration.generateModWorldGeneration();
		ModFoliagePlacerTypes.register();
		ModEffects.registerEffects();
		ModBoats.registerBoats();
		ModLootTableModifiers.modifyLootTables();
		ModScreenHandlers.registerScreenHandlers();
		ModParticles.registerParticles();
		ModPotions.registerPotions();
		ModTrunkPlacerTypes.register();
		ModTreeDecoratorTypes.register();
		ModPaintings.registerPaintings();
		ModRegistries.RegisterModStuffs();
		ModBlockEntities.registerBlockEntities();
		ModSounds.registerSounds();
	}
}