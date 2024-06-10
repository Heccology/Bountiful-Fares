package net.hecco.bountifulfares.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.compat.CabinetBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.block.BFBlocks.*;

public class BFBlockEntities {
    public static final BlockEntityType<DyeableCeramicBlockEntity> CERAMIC_TILES_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "ceramic_tiles_block_entity"),
            FabricBlockEntityTypeBuilder.create(DyeableCeramicBlockEntity::new, CERAMIC_TILES, CERAMIC_TILE_STAIRS, CERAMIC_TILE_SLAB, CERAMIC_PRESSURE_PLATE, CERAMIC_BUTTON, CERAMIC_LEVER, CHECKERED_CERAMIC_TILES, CHECKERED_CERAMIC_TILE_STAIRS, CHECKERED_CERAMIC_TILE_SLAB).build()
    );

    public static final BlockEntityType<CeramicDishBlockEntity> CERAMIC_DISH_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "ceramic_dish_block_entity"),
            FabricBlockEntityTypeBuilder.create(CeramicDishBlockEntity::new, CERAMIC_DISH).build()
    );

    public static final BlockEntityType<FermentationVesselBlockEntity> FERMENTATION_VESSEL_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "fermentation_vessel_block_entity"),
            FabricBlockEntityTypeBuilder.create(FermentationVesselBlockEntity::new, FERMENTATION_VESSEL).build()
    );

    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new, HOARY_SIGN, HOARY_WALL_SIGN, WALNUT_SIGN, WALNUT_WALL_SIGN).build()
    );

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "mod_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new, HOARY_HANGING_SIGN, HOARY_WALL_HANGING_SIGN, WALNUT_HANGING_SIGN, WALNUT_WALL_HANGING_SIGN).build()
    );

    public static final BlockEntityType<GristmillBlockEntity> GRISTMILL_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "gristmill_block_entity"),
            FabricBlockEntityTypeBuilder.create(GristmillBlockEntity::new, GRISTMILL).build(null)
    );

    public static final BlockEntityType<GreenTeaCandleBlockEntity> GREEN_TEA_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "green_tea_candle_entity"),
            FabricBlockEntityTypeBuilder.create(GreenTeaCandleBlockEntity::new, GREEN_TEA_CANDLE).build()
    );
    public static final BlockEntityType<BlackTeaCandleBlockEntity> BLACK_TEA_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "black_tea_candle_entity"),
            FabricBlockEntityTypeBuilder.create(BlackTeaCandleBlockEntity::new, BLACK_TEA_CANDLE).build()
    );
    public static final BlockEntityType<ChamomileCandleBlockEntity> CHAMOMILE_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "chamomile_candle_entity"),
            FabricBlockEntityTypeBuilder.create(ChamomileCandleBlockEntity::new, CHAMOMILE_CANDLE).build()
    );
    public static final BlockEntityType<HoneysuckleCandleBlockEntity> HONEYSUCKLE_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "honeysuckle_candle_entity"),
            FabricBlockEntityTypeBuilder.create(HoneysuckleCandleBlockEntity::new, HONEYSUCKLE_CANDLE).build()
    );
    public static final BlockEntityType<BellflowerCandleBlockEntity> BELLFLOWER_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "bellflower_candle_entity"),
            FabricBlockEntityTypeBuilder.create(BellflowerCandleBlockEntity::new, BELLFLOWER_CANDLE).build()
    );
    public static final BlockEntityType<TorchflowerCandleBlockEntity> TORCHFLOWER_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "torchflower_candle_entity"),
            FabricBlockEntityTypeBuilder.create(TorchflowerCandleBlockEntity::new, TORCHFLOWER_CANDLE).build()
    );

    public static final BlockEntityType<WalnutCandleBlockEntity> WALNUT_CANDLE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulFares.MOD_ID, "walnut_candle_entity"),
            FabricBlockEntityTypeBuilder.create(WalnutCandleBlockEntity::new, WALNUT_CANDLE).build()
    );

    public static BlockEntityType<CabinetBlockEntity> CABINET_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        if (BountifulFares.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID)) {
            CABINET_BLOCK_ENTITY = Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(BountifulFares.MOD_ID, "cabinet_block_entity"),
                    FabricBlockEntityTypeBuilder.create(CabinetBlockEntity::new, WALNUT_CABINET).build()
            );
        }
    }
}
