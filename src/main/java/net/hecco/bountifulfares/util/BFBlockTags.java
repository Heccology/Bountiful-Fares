package net.hecco.bountifulfares.util;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.block.Block;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BFBlockTags {
    public static final TagKey<Block> INFUSED_CANDLES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "infused_candles"));
    public static final TagKey<Block> APPLE_LEAVES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "apple_leaves"));
    public static final TagKey<Block> ORANGE_LEAVES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "orange_leaves"));
    public static final TagKey<Block> LEMON_LEAVES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "lemon_leaves"));
    public static final TagKey<Block> PLUM_LEAVES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "plum_leaves"));
    public static final TagKey<Block> APPLE_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "apple_logs"));
    public static final TagKey<Block> ORANGE_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "orange_logs"));
    public static final TagKey<Block> LEMON_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "lemon_logs"));
    public static final TagKey<Block> PLUM_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "plum_logs"));
    public static final TagKey<Block> WALNUT_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "walnut_logs"));
    public static final TagKey<Block> HOARY_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "hoary_logs"));
    public static final TagKey<Block> JACK_O_STRAWS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "jack_o_straws"));

    public static final TagKey<Block> CERAMIC_TILES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "ceramic_tiles"));
    public static final TagKey<Block> DYEABLE_CERAMIC_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "dyeable_ceramic_blocks"));
    public static final TagKey<Block> TRELLISES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "trellises"));
    public static final TagKey<Block> FELSIC_STONES = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "felsic_stones"));
    public static final TagKey<Block> PICKETS = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "pickets"));
    public static final TagKey<Block> GRASS_SEEDS_PLANTABLE_ON = TagKey.of(RegistryKeys.BLOCK, new Identifier(BountifulFares.MOD_ID, "grass_seeds_plantable_on"));
    public static final TagKey<PaintingVariant> PAINTINGS = TagKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(BountifulFares.MOD_ID, "bf_paintings"));
}
