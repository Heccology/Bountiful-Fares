package net.hecco.bountifulfares.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.CropTrellisBlock;
import net.hecco.bountifulfares.block.custom.DecorativeTrellisBlock;
import net.hecco.bountifulfares.block.custom.TrellisBlock;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.hecco.bountifulfares.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrellisVariants {

    public static List<TrellisVariant> TrellisIndex = new ArrayList<>();
    public static List<VineCrop> VineCropIndex = new ArrayList<>();
    public static List<DecorativeVine> DecorativeVineIndex = new ArrayList<>();

    public static Map<String, Block> TRELLISES = new HashMap<>();
    public static Map<String, Block> CROP_TRELLISES = new HashMap<>();
    public static Map<String, Block> DECORATIVE_TRELLISES = new HashMap<>();
    public static void registerTrellises() {
        for (TrellisVariant trellis : TrellisIndex) {
            TRELLISES.put(trellis.getTrellisName(), registerBlock(trellis.getId(), trellis.getTrellisName(), new TrellisBlock(trellis, FabricBlockSettings.create().nonOpaque().strength(0.5F).sounds(ModSounds.LIGHT_WOOD).instrument(Instrument.BASS).nonOpaque())));
            for (VineCrop crop : VineCropIndex) {
                if (crop.getSeedsItem() != crop.getCropItem()) {
                    CROP_TRELLISES.put(crop.getName() + trellis.getTrellisName(), registerBlockNoItem(trellis.getId(), crop.getName() + "_" + trellis.getTrellisName(), new CropTrellisBlock(crop.getSeedsItem(), crop.getCropItem(), trellis, crop, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS))));
                } else {
                    CROP_TRELLISES.put(crop.getName() + trellis.getTrellisName(), registerBlockNoItem(trellis.getId(), crop.getName() + "_" + trellis.getTrellisName(), new CropTrellisBlock(crop.getCropItem(), trellis, crop, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().ticksRandomly().sounds(ModSounds.PLANTED_TRELLIS))));
                }
            }
            for (DecorativeVine vine : DecorativeVineIndex) {
                DECORATIVE_TRELLISES.put(vine.getName() + trellis.getTrellisName(), registerBlockNoItem(trellis.getId(), vine.getName() + "_" + trellis.getTrellisName(), new DecorativeTrellisBlock(vine.canDuplicate(), vine.getPlantItem(), trellis, vine, FabricBlockSettings.create().nonOpaque().strength(0.5F).instrument(Instrument.BASS).nonOpaque().sounds(ModSounds.PLANTED_TRELLIS))));
            }
        }
    }

    public static Block getTrellisFromVariant(TrellisVariant variant) {
        return TRELLISES.get(variant.getTrellisName());
    }

    public static Block getCropTrellisFromVariant(TrellisVariant variant, VineCrop crop) {
        return CROP_TRELLISES.get(crop.getName() + variant.getTrellisName());
    }

    public static Block getDecorTrellisFromVariant(TrellisVariant variant, DecorativeVine vine) {
        return DECORATIVE_TRELLISES.get(vine.getName() + variant.getTrellisName());
    }

    private static Block registerBlockNoItem(String id, String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(id, name), block);
    }

    private static Block registerBlock(String id, String name, Block block) {
        registerBlockItem(id, name, block);
        return Registry.register(Registries.BLOCK, new Identifier(id, name), block);
    }

    private static Item registerBlockItem(String id, String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(id, name), new BlockItem(block, new FabricItemSettings()));
    }
}
