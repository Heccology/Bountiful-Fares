package net.hecco.bountifulfares.compat.twigs;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TwigsBlockTags {
    public static final TagKey<Block> TABLES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BountifulFares.TWIGS_MOD_ID, "tables"));

}
