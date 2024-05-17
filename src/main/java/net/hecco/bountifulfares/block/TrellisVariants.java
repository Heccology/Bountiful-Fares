package net.hecco.bountifulfares.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresClient;
import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.block.custom.DecorativeTrellisBlock;
import net.hecco.bountifulfares.block.custom.TrellisBlock;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.item.ModItems;
import net.hecco.bountifulfares.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.*;

public class TrellisVariants {

    public static  List<TrellisVariant> TrellisVariants = new ArrayList<>();
    public static List<VineCrop> VineCrops = new ArrayList<>(List.of(
            ModTrellises.PASSION_FRUIT,
            ModTrellises.ELDERBERRY,
            ModTrellises.LAPISBERRY,
            ModTrellises.GLOW_BERRY

    ));
    public static List<DecorativeVine> DecorativeVines = new ArrayList<>(List.of(
            ModTrellises.ROSE,
            ModTrellises.LILAC,
            ModTrellises.PEONY,
            ModTrellises.SUNFLOWER,
            ModTrellises.VINE,
            ModTrellises.WEEPING,
            ModTrellises.TWISTING
    ));

    public static void registerTrellises() {
//        TrellisVariants.sort(Comparator.comparing(TrellisVariant::getId));
//        for (TrellisVariant trellis : TrellisVariants) {
//            if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//            }
//        }
//        for (TrellisVariant trellis : TrellisVariants) {
//            if (!Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                TRELLISES.put(trellis.getTrellisName(), registerBlock(trellis.getId(), trellis.getTrellisName(), new TrellisBlock(trellis, FabricBlockSettings.create().nonOpaque().strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).nonOpaque())));
//                for (VineCrop crop : VineCrops) {
//                    if (crop.getSeedsItem() != crop.getCropItem()) {
//                        CROP_TRELLISES.put(crop.getName() + trellis.getTrellisName(), registerBlockNoItem(trellis.getId(), crop.getName() + "_" + trellis.getTrellisName(), new CropTrellisBlock(crop.getSeedsItem(), crop.getCropItem(), trellis, crop, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS))));
//                    } else {
//                        CROP_TRELLISES.put(crop.getName() + trellis.getTrellisName(), registerBlockNoItem(trellis.getId(), crop.getName() + "_" + trellis.getTrellisName(), new CropTrellisBlock(crop.getCropItem(), trellis, crop, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS))));
//                    }
//                }
//                for (DecorativeVine vine : DecorativeVines) {
//                    DECORATIVE_TRELLISES.put(vine.getName() + trellis.getTrellisName(), registerBlockNoItem(trellis.getId(), vine.getName() + "_" + trellis.getTrellisName(), new DecorativeTrellisBlock(vine.canDuplicate(), vine.getPlantItem(), trellis, vine, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
//                }
//            }
//        }
    }

    public static Block registerBlockNoItem(String id, String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(id, name), block);
    }

    public static Block registerBlock(String id, String name, Block block) {
        registerBlockItem(id, name, block);
        return Registry.register(Registries.BLOCK, new Identifier(id, name), block);
    }

    private static Item registerBlockItem(String id, String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), new BlockItem(block, new FabricItemSettings()));
    }
}
