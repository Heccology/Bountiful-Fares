package net.hecco.bountifulcuisine.util;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> INFUSED_CANDLES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulCuisine.MOD_ID, "infused_candles"));
}
