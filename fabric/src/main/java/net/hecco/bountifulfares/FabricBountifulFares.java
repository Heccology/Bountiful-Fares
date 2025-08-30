package net.hecco.bountifulfares;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.data.FabricGrassSeedsInteractionResourceLoader;
import net.hecco.bountifulfares.data.FabricTrellisCropResourceLoader;
import net.hecco.bountifulfares.data.FabricTrellisPlantResourceLoader;
import net.hecco.bountifulfares.datagen.DatagenOnlyItems;
import net.hecco.bountifulfares.registry.BFFabricLootTableModifiers;
import net.hecco.bountifulfares.registry.BFMessages;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.bountifulfares.registry.util.BFRegistries;
import net.hecco.heccolib.lib.fuelRegistry.HLFuelRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static net.hecco.bountifulfares.registry.misc.BFItemGroupAdditions.*;

public class FabricBountifulFares implements ModInitializer {

    @Override
    public void onInitialize() {
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrellisPlantResourceLoader());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricTrellisCropResourceLoader());
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new FabricGrassSeedsInteractionResourceLoader());
        BountifulFares.init();
        BFRegistries.registerFlammables();
        registerFuels();
        BFRegistries.registerCeramicCheckeredConversions();
        BFRegistries.registerTillables();
        BFRegistries.registerPathables();
        BFRegistries.registerStrippables();
        BFFabricLootTableModifiers.modifyLootTables();
        addTiffin(TOOLS_AND_UTILITIES, BFItems.SUN_HAT.get(), null);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(null).get(), DyeColor.WHITE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.WHITE).get(), DyeColor.LIGHT_GRAY);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.LIGHT_GRAY).get(), DyeColor.GRAY);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.GRAY).get(), DyeColor.BLACK);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.BLACK).get(), DyeColor.BROWN);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.BROWN).get(), DyeColor.RED);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.RED).get(), DyeColor.ORANGE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.ORANGE).get(), DyeColor.YELLOW);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.YELLOW).get(), DyeColor.LIME);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.LIME).get(), DyeColor.GREEN);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.GREEN).get(), DyeColor.CYAN);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.CYAN).get(), DyeColor.LIGHT_BLUE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.LIGHT_BLUE).get(), DyeColor.BLUE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.BLUE).get(), DyeColor.PURPLE);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.PURPLE).get(), DyeColor.MAGENTA);
        addTiffin(TOOLS_AND_UTILITIES, BFItems.TIFFINS.get(DyeColor.MAGENTA).get(), DyeColor.PINK);
        addTiffin(FOOD_AND_DRINKS, BFItems.TORCHFLOWER_TEA_CUP.get(), null);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(null).get(), DyeColor.WHITE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.WHITE).get(), DyeColor.LIGHT_GRAY);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.LIGHT_GRAY).get(), DyeColor.GRAY);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.GRAY).get(), DyeColor.BLACK);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.BLACK).get(), DyeColor.BROWN);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.BROWN).get(), DyeColor.RED);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.RED).get(), DyeColor.ORANGE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.ORANGE).get(), DyeColor.YELLOW);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.YELLOW).get(), DyeColor.LIME);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.LIME).get(), DyeColor.GREEN);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.GREEN).get(), DyeColor.CYAN);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.CYAN).get(), DyeColor.LIGHT_BLUE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.LIGHT_BLUE).get(), DyeColor.BLUE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.BLUE).get(), DyeColor.PURPLE);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.PURPLE).get(), DyeColor.MAGENTA);
        addTiffin(FOOD_AND_DRINKS, BFItems.TIFFINS.get(DyeColor.MAGENTA).get(), DyeColor.PINK);
        BFItemGroupAdditions.registerItemGroupAdditions();
        BFMessages.registerPayloads();
        DatagenOnlyItems.registerDatagenItems();
        FabricLoader.getInstance().getConfigDir().toFile();
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (player.canEat(false) && BountifulFares.CONFIG.isCakeEatSounds() && !player.isSpectator()) {
                BlockPos pos = hitResult.getBlockPos();
                BlockState state = world.getBlockState(pos);
                Block target = state.getBlock();
                ResourceLocation identifier = BuiltInRegistries.BLOCK.getKey(target);
                if (
                        target instanceof CakeBlock &&
                        (identifier.getPath().contains("_cake") || identifier.equals(BuiltInRegistries.BLOCK.getKey(Blocks.CAKE))) &&
                        target.defaultBlockState().hasProperty(BlockStateProperties.BITES)
                ) {
                    world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 0.5f, 1.0f);
                    if (state.getValue(BlockStateProperties.BITES) == 6) {
                        world.playSound(null, pos, SoundEvents.PLAYER_BURP, SoundSource.BLOCKS, 0.5f, 1.0f);
                    }
                }
            }
            return InteractionResult.PASS;
        });
    }

    public static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(BFItemTags.FRUIT_LOGS, 200);
        registry.add(BFItemTags.HOARY_LOGS, 300);
        registry.add(BFItemTags.WALNUT_LOGS, 300);
        registry.add(BFItemTags.PICKETS, 200);

        for (Supplier<Block> block : BFBlocks.TRELLISES.values()) {
            if (!(BuiltInRegistries.BLOCK.getKey(block.get()).getPath() == "crimson_trellis" || BuiltInRegistries.BLOCK.getKey(block.get()).getPath() == "warped_trellis")) {
                registry.add(block.get(), 300);
            }
        }

        registry.add(BFBlocks.GRISTMILL.get(), 300);
        registry.add(BFBlocks.WHITE_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.GRAY_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.BLACK_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.BROWN_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.RED_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.ORANGE_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.YELLOW_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.LIME_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.GREEN_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.CYAN_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.BLUE_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.PURPLE_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.MAGENTA_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.PINK_JACK_O_STRAW.get(), 400);
        registry.add(BFBlocks.PALM_FROND.get(), 100);
        registry.add(BFItems.COCONUT_COIR.get(), 100);
        registry.add(BFBlocks.PACKED_COCONUT_COIR.get(), 400);
        registry.add(BFBlocks.COIR_CARPET.get(), 200);
        registry.add(BFBlocks.COIR_BRICKS.get(), 400);
        registry.add(BFBlocks.COIR_BRICK_SLAB.get(), 400);
        registry.add(BFBlocks.COIR_BRICK_STAIRS.get(), 400);
        registry.add(BFBlocks.COIR_BRICK_WALL.get(), 400);
//        registry.add(MintBlocks.ACORN_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.AMBER_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.ARTICHOKE_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.BANANA_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.CERULEAN_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.FUCHSIA_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.GRAPE_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.INDIGO_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.MAROON_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.MAUVE_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.MINT_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.MOLD_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.NAVY_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.PEACH_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.PERIWINKLE_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.SAGE_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.SAP_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.SHAMROCK_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.VELVET_JACK_O_STRAW, 400);
//        registry.add(MintBlocks.VERMILION_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.MAROON_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.ROSE_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.CORAL_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.GINGER_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.TAN_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.BEIGE_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.AMBER_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.OLIVE_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.FOREST_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.VERDANT_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.TEAL_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.MINT_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.AQUA_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.SLATE_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.NAVY_JACK_O_STRAW, 400);
//        registry.add(DyeDepotBlocks.INDIGO_JACK_O_STRAW, 400);
//        registry.add(ExcessiveBuildingBlocks.WALNUT_VERTICAL_STAIRS, 300);
//        registry.add(ExcessiveBuildingBlocks.CHISELED_WALNUT_PLANKS, 300);
//        registry.add(ExcessiveBuildingBlocks.WALNUT_MOSAIC, 300);
//        registry.add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_SLAB, 300);
//        registry.add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_STAIRS, 300);
//        registry.add(ExcessiveBuildingBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS, 300);
//        registry.add(ExcessiveBuildingBlocks.WALNUT_LADDER, 300);
//        registry.add(ExcessiveBuildingBlocks.HOARY_VERTICAL_STAIRS, 300);
//        registry.add(ExcessiveBuildingBlocks.CHISELED_HOARY_PLANKS, 300);
//        registry.add(ExcessiveBuildingBlocks.HOARY_MOSAIC, 300);
//        registry.add(ExcessiveBuildingBlocks.HOARY_MOSAIC_SLAB, 300);
//        registry.add(ExcessiveBuildingBlocks.HOARY_MOSAIC_STAIRS, 300);
//        registry.add(ExcessiveBuildingBlocks.HOARY_MOSAIC_VERTICAL_STAIRS, 300);
//        registry.add(ExcessiveBuildingBlocks.HOARY_LADDER, 300);

    }
}
