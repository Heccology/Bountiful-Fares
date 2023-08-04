package net.hecco.bountifulcuisine.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static ItemGroup BOUNTIFUL_CUISINE = Registry.register(Registries.ITEM_GROUP, new Identifier(BountifulCuisine.MOD_ID, "bountiful_cuisine"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bountiful_cuisine"))
                    .icon(() -> new ItemStack(Item.fromBlock(ModBlocks.APPLE_SAPLING))).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.APPLE_LOG);
                        entries.add(ModBlocks.APPLE_WOOD);
                        entries.add(ModBlocks.STRIPPED_APPLE_LOG);
                        entries.add(ModBlocks.STRIPPED_APPLE_WOOD);
                        entries.add(ModBlocks.APPLE_LEAVES);
                        entries.add(ModBlocks.BLOSSOMING_APPLE_LEAVES);
                        entries.add(Items.APPLE);
                        entries.add(ModBlocks.APPLE_SAPLING);
                        entries.add(ModBlocks.ORANGE_LOG);
                        entries.add(ModBlocks.ORANGE_WOOD);
                        entries.add(ModBlocks.STRIPPED_ORANGE_LOG);
                        entries.add(ModBlocks.STRIPPED_ORANGE_WOOD);
                        entries.add(ModBlocks.ORANGE_LEAVES);
                        entries.add(ModBlocks.BLOSSOMING_ORANGE_LEAVES);
                        entries.add(ModItems.ORANGE);
                        entries.add(ModBlocks.ORANGE_SAPLING);
                        entries.add(ModBlocks.LEMON_LOG);
                        entries.add(ModBlocks.LEMON_WOOD);
                        entries.add(ModBlocks.STRIPPED_LEMON_LOG);
                        entries.add(ModBlocks.STRIPPED_LEMON_WOOD);
                        entries.add(ModBlocks.LEMON_LEAVES);
                        entries.add(ModBlocks.BLOSSOMING_LEMON_LEAVES);
                        entries.add(ModItems.LEMON);
                        entries.add(ModBlocks.LEMON_SAPLING);
                        entries.add(ModBlocks.PLUM_LOG);
                        entries.add(ModBlocks.PLUM_WOOD);
                        entries.add(ModBlocks.STRIPPED_PLUM_LOG);
                        entries.add(ModBlocks.STRIPPED_PLUM_WOOD);
                        entries.add(ModBlocks.PLUM_LEAVES);
                        entries.add(ModBlocks.BLOSSOMING_PLUM_LEAVES);
                        entries.add(ModItems.PLUM);
                        entries.add(ModBlocks.PLUM_SAPLING);
                        entries.add(ModItems.CITRUS_JUICE_BOTTLE);
                        entries.add(ModItems.CITRIC_ACID);
                        entries.add(ModItems.CANDIED_ORANGE);
                        entries.add(ModItems.CANDIED_LEMON);
                    }).build());
    public static void registerItemGroups() {

    }
}
