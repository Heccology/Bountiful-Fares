package net.hecco.bountifulcuisine.block.custom.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulcuisine.block.ModBlocks.*;

public class ModBlockEntities {
    public static final BlockEntityType<CeramicTilesBlockEntity> CERAMIC_TILES_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "ceramic_tiles_block_entity"),
            FabricBlockEntityTypeBuilder.create(CeramicTilesBlockEntity::new, CERAMIC_TILES, CERAMIC_TILE_STAIRS, CERAMIC_TILE_SLAB, CERAMIC_PRESSURE_PLATE, CERAMIC_BUTTON).build()
    );

    public static final BlockEntityType<CheckeredCeramicTilesBlockEntity> CHECKERED_CERAMIC_TILES_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "checkered_ceramic_tiles_block_entity"),
            FabricBlockEntityTypeBuilder.create(CheckeredCeramicTilesBlockEntity::new, CHECKERED_CERAMIC_TILES, CHECKERED_CERAMIC_TILE_STAIRS, CHECKERED_CERAMIC_TILE_SLAB).build()
    );

    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new, HOARY_SIGN, HOARY_WALL_SIGN).build()
    );

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "mod_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new, HOARY_HANGING_SIGN, HOARY_WALL_HANGING_SIGN).build()
    );

    public static final BlockEntityType<GristmillBlockEntity> GRISTMILL_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "gristmill_block_entity"),
            FabricBlockEntityTypeBuilder.create(GristmillBlockEntity::new, GRISTMILL).build(null)
    );

    public static final BlockEntityType<GreenTeaCandleBlockEntity> GREEN_TEA_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "green_tea_candle_entity"),
            FabricBlockEntityTypeBuilder.create(GreenTeaCandleBlockEntity::new, GREEN_TEA_CANDLE).build()
    );
    public static final BlockEntityType<BlackTeaCandleBlockEntity> BLACK_TEA_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "black_tea_candle_entity"),
            FabricBlockEntityTypeBuilder.create(BlackTeaCandleBlockEntity::new, BLACK_TEA_CANDLE).build()
    );
    public static final BlockEntityType<ChamomileCandleBlockEntity> CHAMOMILE_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "chamomile_candle_entity"),
            FabricBlockEntityTypeBuilder.create(ChamomileCandleBlockEntity::new, CHAMOMILE_CANDLE).build()
    );
    public static final BlockEntityType<HoneysuckleCandleBlockEntity> HONEYSUCKLE_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "honeysuckle_candle_entity"),
            FabricBlockEntityTypeBuilder.create(HoneysuckleCandleBlockEntity::new, HONEYSUCKLE_CANDLE).build()
    );
    public static final BlockEntityType<BellflowerCandleBlockEntity> BELLFLOWER_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "bellflower_candle_entity"),
            FabricBlockEntityTypeBuilder.create(BellflowerCandleBlockEntity::new, BELLFLOWER_CANDLE).build()
    );
    public static final BlockEntityType<TorchflowerCandleBlockEntity> TORCHFLOWER_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "torchflower_candle_entity"),
            FabricBlockEntityTypeBuilder.create(TorchflowerCandleBlockEntity::new, TORCHFLOWER_CANDLE).build()
    );

    public static void registerBlockEntities() {
        BountifulCuisine.LOGGER.debug("Registering Block Entities for " + BountifulCuisine.MOD_ID);
    }
}
