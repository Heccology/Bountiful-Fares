package net.hecco.bountifulfares.registry.tags;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.level.block.Block;

public class BFBlockTags {
    //Leaves Tags
    public static final TagKey<Block> APPLE_LEAVES = createBlockTag( "apple_leaves");
    public static final TagKey<Block> ORANGE_LEAVES = createBlockTag( "orange_leaves");
    public static final TagKey<Block> LEMON_LEAVES = createBlockTag( "lemon_leaves");
    public static final TagKey<Block> PLUM_LEAVES = createBlockTag( "plum_leaves");
    public static final TagKey<Block> GOLDEN_APPLE_LEAVES = createBlockTag( "golden_apple_leaves");

    //Log Tags
    public static final TagKey<Block> APPLE_LOGS = createBlockTag( "apple_logs");
    public static final TagKey<Block> ORANGE_LOGS = createBlockTag( "orange_logs");
    public static final TagKey<Block> LEMON_LOGS = createBlockTag( "lemon_logs");
    public static final TagKey<Block> PLUM_LOGS = createBlockTag( "plum_logs");
    public static final TagKey<Block> WALNUT_LOGS = createBlockTag( "walnut_logs");
    public static final TagKey<Block> HOARY_LOGS = createBlockTag( "hoary_logs");
    public static final TagKey<Block> PALM_LOGS = createBlockTag( "palm_logs");
    public static final TagKey<Block> GOLDEN_APPLE_LOGS = createBlockTag( "golden_apple_logs");

    //Block Group Tags
    public static final TagKey<Block> HANGING_FRUIT = createBlockTag( "hanging_fruit");
    public static final TagKey<Block> JACK_O_STRAWS = createBlockTag( "jack_o_straws");
    public static final TagKey<Block> INFUSED_CANDLES = createBlockTag( "infused_candles");
    public static final TagKey<Block> PICKETS = createBlockTag( "pickets");
    public static final TagKey<Block> CERAMIC_TILES = createBlockTag( "ceramic_tiles");
    public static final TagKey<Block> DYEABLE_CERAMIC_BLOCKS = createBlockTag( "dyeable_ceramic_blocks");

    //Plantable Tags
    public static final TagKey<Block> GRASS_SEEDS_PLANTABLE_ON = createBlockTag( "grass_seeds_plantable_on");
    public static final TagKey<Block> PALM_SAPLINGS_PLANTABLE_ON = createBlockTag( "palm_saplings_plantable_on");
    public static final TagKey<Block> WILD_ELDERBERRY_PLACEABLE_ON = createBlockTag( "wild_elderberry_placeable_on");
    //public static final TagKey<Block> SCORCHKIN_SEEDS_PLANTABLE_ON = createBlockTag( "splits_coconuts");

    //Technical Tags
    public static final TagKey<Block> FELSIC_STONES = createBlockTag( "felsic_stones");
    public static final TagKey<Block> SPLITS_COCONUTS = createBlockTag( "splits_coconuts");
    public static final TagKey<Block> IGNORE_PARTICLE_TINT = createBlockTag( "ignore_particle_tint");
    public static final TagKey<Block> PRISMARINE_PROPAGATION_SUBSTRATE = createBlockTag( "prismarine_propagation_substrate");

    //Paintings are here too, I guess
    public static final TagKey<PaintingVariant> PAINTINGS = TagKey.create(Registries.PAINTING_VARIANT,
                                                            ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID,
                                                                                             "bf_paintings"));

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(Registries.BLOCK,
                             ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, name));
    }
}
