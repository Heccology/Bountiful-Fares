package net.hecco.bountifulfares.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hecco.bountifulfares.block.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

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
            ModTrellises.TWISTING,
            ModTrellises.NS_LAVENDER,
            ModTrellises.NS_BLEEDING_HEART,
            ModTrellises.NS_BLUE_BULB,
            ModTrellises.NS_CARNATION,
            ModTrellises.NS_GARDENIA,
            ModTrellises.NS_MARIGOLD,
            ModTrellises.NS_FOXGLOVE
    ));

    public static void registerTrellises() {

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
