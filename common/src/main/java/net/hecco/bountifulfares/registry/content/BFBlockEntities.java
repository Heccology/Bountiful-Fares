package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.*;
import net.hecco.bountifulfares.block.entity.compat.CabinetBlockEntity;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

import static net.hecco.bountifulfares.registry.content.BFBlocks.*;

public class BFBlockEntities {
    public static final Supplier<BlockEntityType<DyeableCeramicBlockEntity>> CERAMIC_TILES_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "ceramic_tiles_block_entity",
            HLServices.REGISTRY.createBlockEntity(DyeableCeramicBlockEntity::new, CERAMIC_TILES.get(), CERAMIC_TILE_STAIRS.get(), CERAMIC_TILE_SLAB.get(), /*CERAMIC_TILE_WALL,*/ CERAMIC_PRESSURE_PLATE.get(), CERAMIC_BUTTON.get(), CERAMIC_LEVER.get(), CHECKERED_CERAMIC_TILES.get(), CHECKERED_CERAMIC_TILE_STAIRS.get(), CHECKERED_CERAMIC_TILE_SLAB.get(), /*CHECKERED_CERAMIC_TILE_WALL,*/ CRACKED_CERAMIC_TILES.get(), CRACKED_CHECKERED_CERAMIC_TILES.get(), CERAMIC_TILE_PILLAR.get(), CERAMIC_MOSAIC.get(), CERAMIC_MOSAIC_STAIRS.get(), CERAMIC_MOSAIC_SLAB.get(), /*CERAMIC_MOSAIC_WALL,*/ CHECKERED_CERAMIC_MOSAIC.get(), CHECKERED_CERAMIC_MOSAIC_STAIRS.get(), CHECKERED_CERAMIC_MOSAIC_SLAB.get(), /*CHECKERED_CERAMIC_MOSAIC_WALL,*/ CERAMIC_DOOR.get(), CERAMIC_TRAPDOOR.get(), SOLID_CERAMIC.get(), ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS.get(), ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS.get())
    );

    public static final Supplier<BlockEntityType<CeramicDishBlockEntity>> CERAMIC_DISH_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "ceramic_dish_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(CeramicDishBlockEntity::new, CERAMIC_DISH.get())
    );

    public static final Supplier<BlockEntityType<FermentationVesselBlockEntity>> FERMENTATION_VESSEL_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "fermentation_vessel_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(FermentationVesselBlockEntity::new, FERMENTATION_VESSEL.get())
    );

    public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "mod_sign_entity",
            () -> HLServices.REGISTRY.createBlockEntity(ModSignBlockEntity::new, HOARY_SIGN.get(), HOARY_WALL_SIGN.get(), WALNUT_SIGN.get(), WALNUT_WALL_SIGN.get())
    );

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "mod_hanging_sign_entity",
            () -> HLServices.REGISTRY.createBlockEntity(ModHangingSignBlockEntity::new, HOARY_HANGING_SIGN.get(), HOARY_WALL_HANGING_SIGN.get(), WALNUT_HANGING_SIGN.get(), WALNUT_WALL_HANGING_SIGN.get())
    );

    public static final Supplier<BlockEntityType<GristmillBlockEntity>> GRISTMILL_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "gristmill_block_entity",
            () -> HLServices.REGISTRY.createBlockEntity(GristmillBlockEntity::new, GRISTMILL.get())
    );

    public static final Supplier<BlockEntityType<GreenTeaCandleBlockEntity>> GREEN_TEA_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "green_tea_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(GreenTeaCandleBlockEntity::new, GREEN_TEA_CANDLE.get())
    );
    public static final Supplier<BlockEntityType<BlackTeaCandleBlockEntity>> BLACK_TEA_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "black_tea_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(BlackTeaCandleBlockEntity::new, BLACK_TEA_CANDLE.get())
    );
    public static final Supplier<BlockEntityType<ChamomileCandleBlockEntity>> CHAMOMILE_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "chamomile_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(ChamomileCandleBlockEntity::new, CHAMOMILE_CANDLE.get())
    );
    public static final Supplier<BlockEntityType<HoneysuckleCandleBlockEntity>> HONEYSUCKLE_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "honeysuckle_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(HoneysuckleCandleBlockEntity::new, HONEYSUCKLE_CANDLE.get())
    );
    public static final Supplier<BlockEntityType<BellflowerCandleBlockEntity>> BELLFLOWER_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "bellflower_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(BellflowerCandleBlockEntity::new, BELLFLOWER_CANDLE.get())
    );
    public static final Supplier<BlockEntityType<TorchflowerCandleBlockEntity>> TORCHFLOWER_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "torchflower_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(TorchflowerCandleBlockEntity::new, TORCHFLOWER_CANDLE.get())
    );

    public static final Supplier<BlockEntityType<WalnutCandleBlockEntity>> WALNUT_CANDLE_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "walnut_candle_entity",
            () -> HLServices.REGISTRY.createBlockEntity(WalnutCandleBlockEntity::new, WALNUT_CANDLE.get())
    );

    public static Supplier<BlockEntityType<CabinetBlockEntity>> CABINET_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        if (HLServices.PLATFORM.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID) || HLServices.PLATFORM.isDatagen()) {
            CABINET_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "cabinet_block_entity",
                    () -> HLServices.REGISTRY.createBlockEntity(CabinetBlockEntity::new, FarmersDelightBlocks.WALNUT_CABINET.get(), FarmersDelightBlocks.HOARY_CABINET.get()).build()
            );
        }
    }
}
