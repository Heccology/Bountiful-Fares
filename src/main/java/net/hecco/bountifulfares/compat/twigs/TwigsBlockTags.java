package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TwigsBlockTags {
    public static final TagKey<Block> TABLES = TagKey.of(RegistryKeys.BLOCK, Identifier.of(BountifulFares.TWIGS_MOD_ID, "tables"));

}
