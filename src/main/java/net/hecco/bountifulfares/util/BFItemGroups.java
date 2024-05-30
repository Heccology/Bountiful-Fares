package net.hecco.bountifulfares.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.trellis.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.potion.BFPotions;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.PotionUtil;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;

public class BFItemGroups {

    private static final Comparator<RegistryEntry<PaintingVariant>> PAINTING_VARIANT_COMPARATOR = Comparator.comparing(RegistryEntry::value, Comparator.comparingInt((paintingVariant) -> 16 * 16));

    public static ItemGroup BOUNTIFUL_FARES = Registry.register(Registries.ITEM_GROUP, new Identifier(BountifulFares.MOD_ID, "bountiful_fares"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bountiful_fares"))
                    .icon(() -> new ItemStack(BFItems.PASSION_FRUIT)).entries((displayContext, entries) -> {
                        boolean mint = BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID);
                        boolean dye_depot = BountifulFares.isModLoaded(BountifulFares.DYE_DEPOT_MOD_ID);
                        entries.add(BFBlocks.APPLE_LOG);
                        entries.add(BFBlocks.APPLE_WOOD);
                        entries.add(BFBlocks.STRIPPED_APPLE_LOG);
                        entries.add(BFBlocks.STRIPPED_APPLE_WOOD);
                        entries.add(BFBlocks.APPLE_LEAVES);
                        entries.add(BFBlocks.FLOWERING_APPLE_LEAVES);
                        entries.add(Items.APPLE);
                        entries.add(BFBlocks.APPLE_BLOCK);
                        entries.add(BFBlocks.APPLE_SAPLING);
                        entries.add(BFBlocks.ORANGE_LOG);
                        entries.add(BFBlocks.ORANGE_WOOD);
                        entries.add(BFBlocks.STRIPPED_ORANGE_LOG);
                        entries.add(BFBlocks.STRIPPED_ORANGE_WOOD);
                        entries.add(BFBlocks.ORANGE_LEAVES);
                        entries.add(BFBlocks.FLOWERING_ORANGE_LEAVES);
                        entries.add(BFItems.ORANGE);
                        entries.add(BFBlocks.ORANGE_BLOCK);
                        entries.add(BFBlocks.ORANGE_SAPLING);
                        entries.add(BFBlocks.LEMON_LOG);
                        entries.add(BFBlocks.LEMON_WOOD);
                        entries.add(BFBlocks.STRIPPED_LEMON_LOG);
                        entries.add(BFBlocks.STRIPPED_LEMON_WOOD);
                        entries.add(BFBlocks.LEMON_LEAVES);
                        entries.add(BFBlocks.FLOWERING_LEMON_LEAVES);
                        entries.add(BFItems.LEMON);
                        entries.add(BFBlocks.LEMON_BLOCK);
                        entries.add(BFBlocks.LEMON_SAPLING);
                        entries.add(BFBlocks.PLUM_LOG);
                        entries.add(BFBlocks.PLUM_WOOD);
                        entries.add(BFBlocks.STRIPPED_PLUM_LOG);
                        entries.add(BFBlocks.STRIPPED_PLUM_WOOD);
                        entries.add(BFBlocks.PLUM_LEAVES);
                        entries.add(BFBlocks.FLOWERING_PLUM_LEAVES);
                        entries.add(BFItems.PLUM);
                        entries.add(BFBlocks.PLUM_BLOCK);
                        entries.add(BFBlocks.PLUM_SAPLING);
                        entries.add(BFBlocks.GOLDEN_APPLE_BLOCK);
                        entries.add(BFBlocks.HOARY_APPLE_SAPLING);
                        entries.add(BFBlocks.HOARY_LOG);
                        entries.add(BFBlocks.HOARY_WOOD);
                        entries.add(BFBlocks.STRIPPED_HOARY_LOG);
                        entries.add(BFBlocks.STRIPPED_HOARY_WOOD);
                        entries.add(BFBlocks.HOARY_PLANKS);
                        entries.add(BFBlocks.HOARY_STAIRS);
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(BFBlocks.HOARY_VERTICAL_STAIRS);
                        }
                        entries.add(BFBlocks.HOARY_SLAB);
                        if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
                            entries.add(BFBlocks.HOARY_TABLE);
                        }
                        entries.add(BFBlocks.HOARY_FENCE);
                        entries.add(BFBlocks.HOARY_FENCE_GATE);
                        entries.add(BFBlocks.HOARY_DOOR);
                        entries.add(BFBlocks.HOARY_TRAPDOOR);
                        entries.add(BFBlocks.HOARY_PRESSURE_PLATE);
                        entries.add(BFBlocks.HOARY_BUTTON);
                        entries.add(BFItems.HOARY_SIGN);
                        entries.add(BFItems.HOARY_HANGING_SIGN);
                        entries.add(BFItems.HOARY_BOAT);
                        entries.add(BFItems.HOARY_CHEST_BOAT);
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(BFBlocks.CHISELED_HOARY_PLANKS);
                            entries.add(BFBlocks.HOARY_MOSAIC);
                            entries.add(BFBlocks.HOARY_MOSAIC_STAIRS);
                            entries.add(BFBlocks.HOARY_MOSAIC_VERTICAL_STAIRS);
                            entries.add(BFBlocks.HOARY_MOSAIC_SLAB);
                            entries.add(BFBlocks.HOARY_LADDER);
                        }
                        entries.add(BFBlocks.HOARY_LEAVES);
                        entries.add(BFItems.HOARY_APPLE);
                        entries.add(BFBlocks.HOARY_APPLE_BLOCK);
                        entries.add(BFBlocks.WALNUT_SAPLING);
                        entries.add(BFBlocks.WALNUT_LOG);
                        entries.add(BFBlocks.WALNUT_WOOD);
                        entries.add(BFBlocks.STRIPPED_WALNUT_LOG);
                        entries.add(BFBlocks.STRIPPED_WALNUT_WOOD);
                        entries.add(BFBlocks.WALNUT_PLANKS);
                        entries.add(BFBlocks.WALNUT_STAIRS);
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(BFBlocks.WALNUT_VERTICAL_STAIRS);
                        }
                        entries.add(BFBlocks.WALNUT_SLAB);
                        if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
                            entries.add(BFBlocks.WALNUT_TABLE);
                        }
                        entries.add(BFBlocks.WALNUT_FENCE);
                        entries.add(BFBlocks.WALNUT_FENCE_GATE);
                        entries.add(BFBlocks.WALNUT_DOOR);
                        entries.add(BFBlocks.WALNUT_TRAPDOOR);
                        entries.add(BFBlocks.WALNUT_PRESSURE_PLATE);
                        entries.add(BFBlocks.WALNUT_BUTTON);
                        entries.add(BFItems.WALNUT_SIGN);
                        entries.add(BFItems.WALNUT_HANGING_SIGN);
                        entries.add(BFItems.WALNUT_BOAT);
                        entries.add(BFItems.WALNUT_CHEST_BOAT);
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(BFBlocks.CHISELED_WALNUT_PLANKS);
                            entries.add(BFBlocks.WALNUT_MOSAIC);
                            entries.add(BFBlocks.WALNUT_MOSAIC_STAIRS);
                            entries.add(BFBlocks.WALNUT_MOSAIC_VERTICAL_STAIRS);
                            entries.add(BFBlocks.WALNUT_MOSAIC_SLAB);
                            entries.add(BFBlocks.WALNUT_LADDER);
                        }
                        entries.add(BFBlocks.WALNUT_LEAVES);
                        entries.add(BFItems.WALNUT);
                        entries.add(BFBlocks.WALNUT_MULCH);
                        entries.add(BFBlocks.WALNUT_MULCH_BLOCK);
                        entries.add(BFBlocks.OAK_PICKETS);
                        entries.add(BFBlocks.SPRUCE_PICKETS);
                        entries.add(BFBlocks.BIRCH_PICKETS);
                        entries.add(BFBlocks.JUNGLE_PICKETS);
                        entries.add(BFBlocks.ACACIA_PICKETS);
                        entries.add(BFBlocks.DARK_OAK_PICKETS);
                        entries.add(BFBlocks.MANGROVE_PICKETS);
                        entries.add(BFBlocks.CHERRY_PICKETS);
                        entries.add(BFBlocks.BAMBOO_PICKETS);
                        entries.add(BFBlocks.WALNUT_PICKETS);
                        if (mint) {
                            entries.add(BFBlocks.WINTERGREEN_PICKETS);
                        }
                        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
                            entries.add(BFBlocks.REDWOOD_PICKETS);
                            entries.add(BFBlocks.SUGI_PICKETS);
                            entries.add(BFBlocks.WISTERIA_PICKETS);
                            entries.add(BFBlocks.FIR_PICKETS);
                            entries.add(BFBlocks.WILLOW_PICKETS);
                            entries.add(BFBlocks.ASPEN_PICKETS);
                            entries.add(BFBlocks.MAPLE_PICKETS);
                            entries.add(BFBlocks.CYPRESS_PICKETS);
                            entries.add(BFBlocks.OLIVE_PICKETS);
                            entries.add(BFBlocks.JOSHUA_PICKETS);
                            entries.add(BFBlocks.GHAF_PICKETS);
                            entries.add(BFBlocks.PALO_VERDE_PICKETS);
                            entries.add(BFBlocks.COCONUT_PICKETS);
                            entries.add(BFBlocks.CEDAR_PICKETS);
                            entries.add(BFBlocks.LARCH_PICKETS);
                            entries.add(BFBlocks.MAHOGANY_PICKETS);
                            entries.add(BFBlocks.SAXAUL_PICKETS);
                        }
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(BFBlocks.ANCIENT_PICKETS);
                        }
                        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
                            entries.add(BFBlocks.ROTTEN_PICKETS);
                        }
                        entries.add(BFBlocks.HOARY_PICKETS);
                        entries.add(BFBlocks.CRIMSON_PICKETS);
                        entries.add(BFBlocks.WARPED_PICKETS);
                        entries.add(BFItems.FELDSPAR);
                        entries.add(BFBlocks.FELDSPAR_BLOCK);
                        entries.add(BFBlocks.CUT_FELDSPAR_BLOCK);
                        entries.add(BFBlocks.FELDSPAR_BRICKS);
                        entries.add(BFBlocks.FELDSPAR_BRICK_STAIRS);
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(BFBlocks.FELDSPAR_BRICK_VERTICAL_STAIRS);
                        }
                        entries.add(BFBlocks.FELDSPAR_BRICK_SLAB);
                        entries.add(BFBlocks.FELDSPAR_LANTERN);
                        if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID)) {
                            entries.add(BFBlocks.FELDSPAR_LAMP);
                        }
                        entries.add(BFBlocks.TINGED_GLASS);
                        entries.add(BFItems.CERAMIC_CLAY);
                        entries.add(BFBlocks.CERAMIC_CLAY_BLOCK);
                        entries.add(BFItems.CERAMIC_TILE);
                        entries.add(BFBlocks.CERAMIC_TILES);
                        entries.add(BFBlocks.CERAMIC_TILE_STAIRS);
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(BFBlocks.CERAMIC_TILE_VERTICAL_STAIRS);
                        }
                        entries.add(BFBlocks.CERAMIC_TILE_SLAB);
                        entries.add(BFBlocks.CRACKED_CERAMIC_TILES);
                        entries.add(BFBlocks.CERAMIC_TILE_PILLAR);
                        entries.add(BFBlocks.CERAMIC_MOSAIC);
                        entries.add(BFBlocks.CERAMIC_MOSAIC_STAIRS);
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(BFBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS);
                        }
                        entries.add(BFBlocks.CERAMIC_MOSAIC_SLAB);
                        entries.add(BFBlocks.CERAMIC_DOOR);
                        entries.add(BFBlocks.CERAMIC_TRAPDOOR);
                        entries.add(BFBlocks.CERAMIC_PRESSURE_PLATE);
                        entries.add(BFBlocks.CERAMIC_BUTTON);
                        entries.add(BFBlocks.CERAMIC_LEVER);
                        entries.add(BFBlocks.CERAMIC_DISH);
                        entries.add(BFItems.ARTISAN_BRUSH);
                        entries.add(BFItems.SUN_HAT);
                        if (mint && !dye_depot) {
                            entries.add(BFBlocks.WHITE_JACK_O_STRAW);
                            entries.add(BFBlocks.LIGHT_GRAY_JACK_O_STRAW);
                            entries.add(BFBlocks.GRAY_JACK_O_STRAW);
                            entries.add(BFBlocks.BLACK_JACK_O_STRAW);
                            entries.add(BFBlocks.ACORN_JACK_O_STRAW);
                            entries.add(BFBlocks.BROWN_JACK_O_STRAW);
                            entries.add(BFBlocks.MAROON_JACK_O_STRAW);
                            entries.add(BFBlocks.RED_JACK_O_STRAW);
                            entries.add(BFBlocks.PEACH_JACK_O_STRAW);
                            entries.add(BFBlocks.VERMILION_JACK_O_STRAW);
                            entries.add(BFBlocks.ORANGE_JACK_O_STRAW);
                            entries.add(BFBlocks.AMBER_JACK_O_STRAW);
                            entries.add(BFBlocks.YELLOW_JACK_O_STRAW);
                            entries.add(BFBlocks.BANANA_JACK_O_STRAW);
                            entries.add(BFBlocks.ARTICHOKE_JACK_O_STRAW);
                            entries.add(BFBlocks.MOLD_JACK_O_STRAW);
                            entries.add(BFBlocks.LIME_JACK_O_STRAW);
                            entries.add(BFBlocks.SAGE_JACK_O_STRAW);
                            entries.add(BFBlocks.SAP_JACK_O_STRAW);
                            entries.add(BFBlocks.GREEN_JACK_O_STRAW);
                            entries.add(BFBlocks.SHAMROCK_JACK_O_STRAW);
                            entries.add(BFBlocks.MINT_JACK_O_STRAW);
                            entries.add(BFBlocks.CYAN_JACK_O_STRAW);
                            entries.add(BFBlocks.CERULEAN_JACK_O_STRAW);
                            entries.add(BFBlocks.LIGHT_BLUE_JACK_O_STRAW);
                            entries.add(BFBlocks.NAVY_JACK_O_STRAW);
                            entries.add(BFBlocks.BLUE_JACK_O_STRAW);
                            entries.add(BFBlocks.PERIWINKLE_JACK_O_STRAW);
                            entries.add(BFBlocks.GRAPE_JACK_O_STRAW);
                            entries.add(BFBlocks.PURPLE_JACK_O_STRAW);
                            entries.add(BFBlocks.INDIGO_JACK_O_STRAW);
                            entries.add(BFBlocks.MAGENTA_JACK_O_STRAW);
                            entries.add(BFBlocks.MAUVE_JACK_O_STRAW);
                            entries.add(BFBlocks.VELVET_JACK_O_STRAW);
                            entries.add(BFBlocks.FUCHSIA_JACK_O_STRAW);
                            entries.add(BFBlocks.PINK_JACK_O_STRAW);
                        }
                        if (dye_depot && !mint) {
                            entries.add(BFBlocks.WHITE_JACK_O_STRAW);
                            entries.add(BFBlocks.LIGHT_GRAY_JACK_O_STRAW);
                            entries.add(BFBlocks.GRAY_JACK_O_STRAW);
                            entries.add(BFBlocks.BLACK_JACK_O_STRAW);
                            entries.add(BFBlocks.MAROON_JACK_O_STRAW);
                            entries.add(BFBlocks.ROSE_JACK_O_STRAW);
                            entries.add(BFBlocks.RED_JACK_O_STRAW);
                            entries.add(BFBlocks.CORAL_JACK_O_STRAW);
                            entries.add(BFBlocks.GINGER_JACK_O_STRAW);
                            entries.add(BFBlocks.ORANGE_JACK_O_STRAW);
                            entries.add(BFBlocks.TAN_JACK_O_STRAW);
                            entries.add(BFBlocks.BEIGE_JACK_O_STRAW);
                            entries.add(BFBlocks.YELLOW_JACK_O_STRAW);
                            entries.add(BFBlocks.AMBER_JACK_O_STRAW);
                            entries.add(BFBlocks.OLIVE_JACK_O_STRAW);
                            entries.add(BFBlocks.LIME_JACK_O_STRAW);
                            entries.add(BFBlocks.FOREST_JACK_O_STRAW);
                            entries.add(BFBlocks.GREEN_JACK_O_STRAW);
                            entries.add(BFBlocks.VERDANT_JACK_O_STRAW);
                            entries.add(BFBlocks.TEAL_JACK_O_STRAW);
                            entries.add(BFBlocks.CYAN_JACK_O_STRAW);
                            entries.add(BFBlocks.MINT_JACK_O_STRAW);
                            entries.add(BFBlocks.AQUA_JACK_O_STRAW);
                            entries.add(BFBlocks.LIGHT_BLUE_JACK_O_STRAW);
                            entries.add(BFBlocks.BLUE_JACK_O_STRAW);
                            entries.add(BFBlocks.SLATE_JACK_O_STRAW);
                            entries.add(BFBlocks.NAVY_JACK_O_STRAW);
                            entries.add(BFBlocks.INDIGO_JACK_O_STRAW);
                            entries.add(BFBlocks.PURPLE_JACK_O_STRAW);
                            entries.add(BFBlocks.MAGENTA_JACK_O_STRAW);
                            entries.add(BFBlocks.PINK_JACK_O_STRAW);
                        }
                        if (!mint && !dye_depot){
                            entries.add(BFBlocks.WHITE_JACK_O_STRAW);
                            entries.add(BFBlocks.LIGHT_GRAY_JACK_O_STRAW);
                            entries.add(BFBlocks.GRAY_JACK_O_STRAW);
                            entries.add(BFBlocks.BLACK_JACK_O_STRAW);
                            entries.add(BFBlocks.BROWN_JACK_O_STRAW);
                            entries.add(BFBlocks.RED_JACK_O_STRAW);
                            entries.add(BFBlocks.ORANGE_JACK_O_STRAW);
                            entries.add(BFBlocks.YELLOW_JACK_O_STRAW);
                            entries.add(BFBlocks.LIME_JACK_O_STRAW);
                            entries.add(BFBlocks.GREEN_JACK_O_STRAW);
                            entries.add(BFBlocks.CYAN_JACK_O_STRAW);
                            entries.add(BFBlocks.LIGHT_BLUE_JACK_O_STRAW);
                            entries.add(BFBlocks.BLUE_JACK_O_STRAW);
                            entries.add(BFBlocks.PURPLE_JACK_O_STRAW);
                            entries.add(BFBlocks.MAGENTA_JACK_O_STRAW);
                            entries.add(BFBlocks.PINK_JACK_O_STRAW);
                        }
                        entries.add(BFBlocks.GRASSY_DIRT);
                        entries.add(BFBlocks.WILD_WHEAT);
                        entries.add(BFBlocks.WILD_CARROTS);
                        entries.add(BFBlocks.WILD_POTATOES);
                        entries.add(BFBlocks.WILD_BEETROOTS);
                        entries.add(BFBlocks.WILD_MAIZE);
                        entries.add(BFBlocks.WILD_LEEKS);
                        entries.add(BFBlocks.WILD_PASSION_FRUIT_VINE);
                        entries.add(BFBlocks.WILD_ELDERBERRY_VINE);
                        entries.add(BFItems.GRASS_SEEDS);
                        entries.add(BFItems.MAIZE_SEEDS);
                        entries.add(BFItems.LEEK_SEEDS);
                        entries.add(BFItems.SPONGEKIN_SEEDS);
                        entries.add(BFItems.LAPISBERRY_SEEDS);
                        entries.add(BFItems.HOARY_SEEDS);
                        entries.add(BFItems.MAIZE);
                        entries.add(BFItems.LEEK);
                        for (TrellisVariant trellis : TrellisUtil.TrellisVariants) {
                            if (Objects.equals(trellis.getModId(), BountifulFares.MOD_ID)) {
                                if (TrellisUtil.getTrellisFromVariant(trellis) != null) {
                                    entries.add(TrellisUtil.getTrellisFromVariant(trellis));
                                }
                            }
                        }
                        if (BountifulFares.isModLoaded(BountifulFares.ELS_AND_LS_DYES_MOD_ID)) {
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.WINTERGREEN));
                        }
                        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.REDWOOD));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.SUGI));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.WISTERIA));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.FIR));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.NS_WILLOW));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.ASPEN));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.MAPLE));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.CYPRESS));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.OLIVE));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.JOSHUA));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.GHAF));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.PALO_VERDE));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.COCONUT));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.CEDAR));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.LARCH));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.MAHOGANY));
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.SAXAUL));
                        }
                        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.ANCIENT));
                        }
                        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
                            entries.add(TrellisUtil.getTrellisFromVariant(BFTrellises.ROTTEN));
                        }
                        entries.add(BFItems.PASSION_FRUIT);
                        entries.add(BFItems.ELDERBERRIES);
                        entries.add(BFItems.LAPISBERRIES);
                        entries.add(BFItems.TEA_BERRIES);
                        entries.add(BFItems.TEA_LEAVES);
                        entries.add(BFItems.DRIED_TEA_LEAVES);
                        entries.add(BFBlocks.CHAMOMILE_FLOWERS);
                        entries.add(BFBlocks.HONEYSUCKLE);
                        entries.add(BFBlocks.VIOLET_BELLFLOWER);
                        entries.add(BFBlocks.SPONGEKIN);
                        entries.add(BFItems.SPONGEKIN_SLICE);
                        entries.add(BFBlocks.PRISMARINE_BLOSSOM);
                        entries.add(BFBlocks.GRISTMILL);
                        entries.add(BFItems.FLOUR);
                        entries.add(BFItems.GREEN_TEA_BLEND);
                        entries.add(BFItems.BLACK_TEA_BLEND);
                        entries.add(BFItems.CHAMOMILE_TEA_BLEND);
                        entries.add(BFItems.HONEYSUCKLE_TEA_BLEND);
                        entries.add(BFItems.BELLFLOWER_TEA_BLEND);
                        entries.add(BFItems.TORCHFLOWER_TEA_BLEND);
                        entries.add(BFItems.GREEN_TEA_BOTTLE);
                        entries.add(BFItems.BLACK_TEA_BOTTLE);
                        entries.add(BFItems.CHAMOMILE_TEA_BOTTLE);
                        entries.add(BFItems.HONEYSUCKLE_TEA_BOTTLE);
                        entries.add(BFItems.BELLFLOWER_TEA_BOTTLE);
                        entries.add(BFItems.TORCHFLOWER_TEA_BOTTLE);
                        entries.add(BFBlocks.GREEN_TEA_CANDLE);
                        entries.add(BFBlocks.BLACK_TEA_CANDLE);
                        entries.add(BFBlocks.CHAMOMILE_CANDLE);
                        entries.add(BFBlocks.HONEYSUCKLE_CANDLE);
                        entries.add(BFBlocks.BELLFLOWER_CANDLE);
                        entries.add(BFBlocks.TORCHFLOWER_CANDLE);
                        entries.add(BFBlocks.WALNUT_CANDLE);
                        entries.add(BFBlocks.FERMENTATION_VESSEL);
                        entries.add(BFItems.ELDERBERRY_WINE_BOTTLE);
                        entries.add(BFItems.LAPISBERRY_WINE_BOTTLE);
                        entries.add(BFItems.MEAD_BOTTLE);
                        entries.add(BFItems.JAR);
                        entries.add(BFItems.APPLE_CIDER_JAR);
                        entries.add(BFItems.PLUM_CIDER_JAR);
                        entries.add(BFItems.HOARY_CIDER_JAR);
                        entries.add(BFItems.APPLE_COMPOTE_JAR);
                        entries.add(BFItems.ORANGE_COMPOTE_JAR);
                        entries.add(BFItems.LEMON_COMPOTE_JAR);
                        entries.add(BFItems.PLUM_COMPOTE_JAR);
                        entries.add(BFItems.HOARY_COMPOTE_JAR);
                        entries.add(BFItems.CITRUS_ESSENCE);
                        entries.add(PotionUtil.setPotion(Items.POTION.getDefaultStack(), BFPotions.ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.POTION.getDefaultStack(), BFPotions.LONG_ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.POTION.getDefaultStack(), BFPotions.STRONG_ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), BFPotions.ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), BFPotions.LONG_ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), BFPotions.STRONG_ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), BFPotions.ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), BFPotions.LONG_ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), BFPotions.STRONG_ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.TIPPED_ARROW.getDefaultStack(), BFPotions.ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.TIPPED_ARROW.getDefaultStack(), BFPotions.LONG_ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.TIPPED_ARROW.getDefaultStack(), BFPotions.STRONG_ACIDIC));
                        entries.add(PotionUtil.setPotion(Items.POTION.getDefaultStack(), BFPotions.STUPOR));
                        entries.add(PotionUtil.setPotion(Items.POTION.getDefaultStack(), BFPotions.LONG_STUPOR));
                        entries.add(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), BFPotions.STUPOR));
                        entries.add(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), BFPotions.LONG_STUPOR));
                        entries.add(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), BFPotions.STUPOR));
                        entries.add(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), BFPotions.LONG_STUPOR));
                        entries.add(PotionUtil.setPotion(Items.TIPPED_ARROW.getDefaultStack(), BFPotions.STUPOR));
                        entries.add(PotionUtil.setPotion(Items.TIPPED_ARROW.getDefaultStack(), BFPotions.LONG_STUPOR));
                        entries.add(BFBlocks.ARTISAN_BREAD);
                        entries.add(BFItems.ARTISAN_COOKIE);
                        entries.add(BFBlocks.APPLE_PIE);
                        entries.add(BFBlocks.ORANGE_PIE);
                        entries.add(BFBlocks.LEMON_PIE);
                        entries.add(BFBlocks.PLUM_PIE);
                        entries.add(BFBlocks.HOARY_PIE);
                        entries.add(BFBlocks.PASSION_FRUIT_TART);
                        entries.add(BFBlocks.ELDERBERRY_TART);
                        entries.add(BFBlocks.GLOW_BERRY_TART);
                        entries.add(BFBlocks.SWEET_BERRY_TART);
                        entries.add(BFBlocks.LAPISBERRY_TART);
                        entries.add(BFBlocks.COCOA_CAKE);
                        entries.add(BFItems.WALNUT_COOKIE);
                        entries.add(BFItems.MAIZE_BREAD);
                        entries.add(BFItems.FOREST_MEDLEY);
                        entries.add(BFItems.ARID_MEDLEY);
                        entries.add(BFItems.MEADOW_MEDLEY);
                        entries.add(BFItems.COASTAL_MEDLEY);
                        entries.add(BFItems.MUSHROOM_STUFFED_POTATO);
                        entries.add(BFItems.BERRY_STUFFED_POTATO);
                        entries.add(BFItems.MAIZE_STUFFED_POTATO);
                        entries.add(BFItems.LEEK_STEW);
                        entries.add(BFItems.FISH_STEW);
                        entries.add(BFItems.APPLE_STEW);
                        entries.add(BFItems.STONE_STEW);
                        entries.add(BFItems.BOUNTIFUL_STEW);
                        entries.add(BFItems.PASSION_GLAZED_SALMON);
                        entries.add(BFItems.CRUSTED_BEEF);
                        entries.add(BFItems.CRIMSON_CHOW);
                        entries.add(BFItems.WARPED_CHOW);
                        entries.add(BFItems.CUSTARD);
                        entries.add(BFItems.PIQUANT_CUSTARD);
                        entries.add(BFItems.PASSION_CUSTARD);
                        entries.add(BFItems.COCOA_CUSTARD);
                        entries.add(BFItems.ANCIENT_CUSTARD);
                        entries.add(BFItems.CANDY);
                        entries.add(BFItems.PIQUANT_CANDY);
                        entries.add(BFItems.SOUR_CANDY);
                        entries.add(BFItems.BITTER_CANDY);
                        entries.add(BFItems.CANDIED_APPLE);
                        entries.add(BFItems.CANDIED_PLUM);
                        entries.add(BFItems.CANDIED_ORANGE);
                        entries.add(BFItems.CANDIED_LEMON);
                        displayContext.lookup().getOptionalWrapper(RegistryKeys.PAINTING_VARIANT).ifPresent((wrapper) -> {
                            addPaintings(entries, wrapper, (registryEntry) -> registryEntry.isIn(BFBlockTags.PAINTINGS), ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
                        });
                    }).build());

    private static void addPaintings(ItemGroup.Entries entries, RegistryWrapper.Impl<PaintingVariant> registryWrapper, Predicate<RegistryEntry<PaintingVariant>> predicate, ItemGroup.StackVisibility visibility) {
        registryWrapper.streamEntries().filter(predicate).sorted(PAINTING_VARIANT_COMPARATOR).forEach((variant) -> {
            ItemStack itemStack = new ItemStack(Items.PAINTING);
            NbtCompound nbtCompound = itemStack.getOrCreateSubNbt("EntityTag");
            PaintingEntity.writeVariantToNbt(nbtCompound, variant);
            entries.add(itemStack, visibility);
        });
    }
    public static void registerItemGroups() {
//        BountifulFares.LOGGER.info("Registering Item Group Entries for " + BountifulFares.MOD_ID);
    }
}
