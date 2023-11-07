package net.hecco.bountifulcuisine.util;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> JACK_O_STRAW_LIGHTABLE = TagKey.of(RegistryKeys.ITEM, new Identifier(BountifulCuisine.MOD_ID, "jack_o_straw_lightable"));
    public static final TagKey<Item> DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(BountifulCuisine.MOD_ID, "dyes"));
    public static final TagKey<Item> ELS_AND_LS_DYES = TagKey.of(RegistryKeys.ITEM, new Identifier(BountifulCuisine.MOD_ID, "els_and_ls_dyes"));
}
