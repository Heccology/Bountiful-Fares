package net.hecco.bountifulfares.compat.appledog;

import net.hecco.bountifulfares.compat.block.CompatBlockItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;
import static net.hecco.bountifulfares.registry.misc.BFCompat.compatBlocks;

public class AppledogBlocks {
    public static final Supplier<Block> APPLEDOG_BLOCK = registerBlock("appledog_block", () -> new AppledogBlock(APPLEDOG_MOD_ID, BlockBehaviour.Properties.ofFullCopy(BFBlocks.APPLE_BLOCK.get()).strength(1f, 1000f)));

    public static Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        registerBlockItem(name, block);
        compatBlocks.add(block);
        return HLServices.REGISTRY.registerBlockNoItem(APPLEDOG_MOD_ID, name, block);
    }

    private static void registerBlockItem(String name, Supplier<Block> block) {
        HLServices.REGISTRY.registerItem(APPLEDOG_MOD_ID, name, () -> new CompatBlockItem(APPLEDOG_MOD_ID, block.get(), new Item.Properties().rarity(Rarity.EPIC)));
    }

    public static void registerAppledogBlocks() {
    }
}
