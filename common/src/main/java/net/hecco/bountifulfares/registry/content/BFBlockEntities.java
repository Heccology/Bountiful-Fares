package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.entity.*;
import net.hecco.bountifulfares.definition.block.entity.compat.CabinetBlockEntity;
import net.hecco.bountifulfares.definition.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.registry.content.BFBlocks.*;

public class BFBlockEntities {
    public static final Supplier<BlockEntityType<DyeableCeramicBlockEntity>> CERAMIC_TILES_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "ceramic_tiles_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(DyeableCeramicBlockEntity::new, CERAMIC_TILES, CERAMIC_TILE_STAIRS, CERAMIC_TILE_SLAB, /*CERAMIC_TILE_WALL,*/ CERAMIC_PRESSURE_PLATE, CERAMIC_BUTTON, CERAMIC_LEVER, CHECKERED_CERAMIC_TILES, CHECKERED_CERAMIC_TILE_STAIRS, CHECKERED_CERAMIC_TILE_SLAB, /*CHECKERED_CERAMIC_TILE_WALL,*/ CRACKED_CERAMIC_TILES, CRACKED_CHECKERED_CERAMIC_TILES, CERAMIC_TILE_PILLAR, CERAMIC_MOSAIC, CERAMIC_MOSAIC_STAIRS, CERAMIC_MOSAIC_SLAB, /*CERAMIC_MOSAIC_WALL,*/ CHECKERED_CERAMIC_MOSAIC, CHECKERED_CERAMIC_MOSAIC_STAIRS, CHECKERED_CERAMIC_MOSAIC_SLAB, /*CHECKERED_CERAMIC_MOSAIC_WALL,*/ CERAMIC_DOOR, CERAMIC_TRAPDOOR, SOLID_CERAMIC)
    );

    public static final Supplier<BlockEntityType<CeramicDishBlockEntity>> CERAMIC_DISH_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "ceramic_dish_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(CeramicDishBlockEntity::new, CERAMIC_DISH)
    );

    public static final Supplier<BlockEntityType<FermentationVesselBlockEntity>> FERMENTATION_VESSEL_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "fermentation_vessel_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(FermentationVesselBlockEntity::new, FERMENTATION_VESSEL)
    );

    public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "mod_sign_entity",
            () -> HLServices.REGISTRY.createBlockEntity(ModSignBlockEntity::new, HOARY_SIGN, HOARY_WALL_SIGN, WALNUT_SIGN, WALNUT_WALL_SIGN)
    );

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "mod_hanging_sign_entity",
            () -> HLServices.REGISTRY.createBlockEntity(ModHangingSignBlockEntity::new, HOARY_HANGING_SIGN, HOARY_WALL_HANGING_SIGN, WALNUT_HANGING_SIGN, WALNUT_WALL_HANGING_SIGN)
    );

    public static final Supplier<BlockEntityType<GristmillBlockEntity>> GRISTMILL_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "gristmill_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(GristmillBlockEntity::new, GRISTMILL)
    );

    public static final Supplier<BlockEntityType<GreenTeaCandleBlockEntity>> GREEN_TEA_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "green_tea_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(GreenTeaCandleBlockEntity::new, GREEN_TEA_CANDLE)
    );

    public static final Supplier<BlockEntityType<BlackTeaCandleBlockEntity>> BLACK_TEA_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "black_tea_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(BlackTeaCandleBlockEntity::new, BLACK_TEA_CANDLE)
    );

    public static final Supplier<BlockEntityType<ChamomileCandleBlockEntity>> CHAMOMILE_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "chamomile_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(ChamomileCandleBlockEntity::new, CHAMOMILE_CANDLE)
    );

    public static final Supplier<BlockEntityType<HoneysuckleCandleBlockEntity>> HONEYSUCKLE_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "honeysuckle_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(HoneysuckleCandleBlockEntity::new, HONEYSUCKLE_CANDLE)
    );

    public static final Supplier<BlockEntityType<BellflowerCandleBlockEntity>> BELLFLOWER_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "bellflower_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(BellflowerCandleBlockEntity::new, BELLFLOWER_CANDLE)
    );

    public static final Supplier<BlockEntityType<TorchflowerCandleBlockEntity>> TORCHFLOWER_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "torchflower_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(TorchflowerCandleBlockEntity::new, TORCHFLOWER_CANDLE)
    );

    public static final Supplier<BlockEntityType<WalnutCandleBlockEntity>> WALNUT_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "walnut_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(WalnutCandleBlockEntity::new, WALNUT_CANDLE)
    );

    public static final Supplier<BlockEntityType<TrellisBlockEntity>> TRELLIS_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "trellis_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(TrellisBlockEntity::new, TRELLISES.get("oak"), TRELLISES.get("spruce"), TRELLISES.get("birch"), TRELLISES.get("jungle"), TRELLISES.get("acacia"), TRELLISES.get("dark_oak"), TRELLISES.get("mangrove"), TRELLISES.get("cherry"), TRELLISES.get("bamboo"), TRELLISES.get("walnut"), TRELLISES.get("hoary"), TRELLISES.get("crimson"), TRELLISES.get("warped"))
    );

    public static final Supplier<BlockEntityType<CoirBedBlockEntity>> COIR_BED_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "coir_bed_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(CoirBedBlockEntity::new, COIR_BED)
    );

    public static Supplier<BlockEntityType<CabinetBlockEntity>> CABINET_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        if (HLServices.PLATFORM.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID) || HLServices.PLATFORM.isDatagen()) {
            CABINET_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "cabinet_block_entity",
                    () -> HLServices.REGISTRY.createBlockEntity(CabinetBlockEntity::new, FarmersDelightBlocks.WALNUT_CABINET)
            );
        }
    }
}
