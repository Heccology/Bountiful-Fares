package net.hecco.bountifulfares.datagen.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Tilt;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

import static net.minecraft.data.client.BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates;

public class ModTemplateModels {
    //Pickets model generation by DigitalPear
    public static final Model TEMPLATE_PICKETS = new Model(Optional.of(new Identifier(BountifulFares.MOD_ID, "template_pickets").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE);
    public static final Model TEMPLATE_TRELLIS = new Model(Optional.of(new Identifier(BountifulFares.MOD_ID, "template_trellis").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE);
    public static final Model TEMPLATE_TRELLIS_0 = new Model(Optional.of(new Identifier(BountifulFares.MOD_ID, "template_planted_trellis_0").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE, TextureKey.CROP);
    public static final Model TEMPLATE_TRELLIS_1 = new Model(Optional.of(new Identifier(BountifulFares.MOD_ID, "template_planted_trellis").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE, TextureKey.CROP, TextureKey.FRONT);
    public static final Model TEMPLATE_TRELLIS_UPSIDE_DOWN = new Model(Optional.of(new Identifier(BountifulFares.MOD_ID, "template_planted_trellis_upside_down").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE, TextureKey.CROP, TextureKey.FRONT);
    public static void registerPicketsModels(BlockStateModelGenerator blockStateModelGenerator, Block picket){
        Identifier modelID = TEMPLATE_PICKETS.upload(picket, TextureMap.texture(picket), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(picket)
                .with(When.create().set(PicketsBlock.NORTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelID))
                .with(When.create()
                                .set(PicketsBlock.NORTH, false)
                                .set(PicketsBlock.SOUTH, false)
                                .set(PicketsBlock.EAST, false)
                                .set(PicketsBlock.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelID))


                .with(When.create().set(PicketsBlock.EAST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .with(When.create()
                                .set(PicketsBlock.NORTH, false)
                                .set(PicketsBlock.SOUTH, false)
                                .set(PicketsBlock.EAST, false)
                                .set(PicketsBlock.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R90))


                .with(When.create().set(PicketsBlock.SOUTH, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .with(When.create()
                                .set(PicketsBlock.NORTH, false)
                                .set(PicketsBlock.SOUTH, false)
                                .set(PicketsBlock.EAST, false)
                                .set(PicketsBlock.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R180))


                .with(When.create().set(PicketsBlock.WEST, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .with(When.create()
                                .set(PicketsBlock.NORTH, false)
                                .set(PicketsBlock.SOUTH, false)
                                .set(PicketsBlock.EAST, false)
                                .set(PicketsBlock.WEST, false),
                        BlockStateVariant.create().put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R270))

        );
        Models.GENERATED.upload(ModelIds.getItemModelId(picket.asItem()), TextureMap.layer0(getItemId(picket)), blockStateModelGenerator.modelCollector);
    }

    public static void registerTrellis(BlockStateModelGenerator blockStateModelGenerator, Block trellis){
        Identifier modelID = TEMPLATE_TRELLIS.upload(trellis, TextureMap.texture(trellis), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(trellis)
                .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                        .register(Direction.NORTH, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .register(Direction.EAST, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.SOUTH, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .register(Direction.WEST, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID).put(VariantSettings.Y, VariantSettings.Rotation.R270)))
        );
    }
    public static void registerCropTrellis(BlockStateModelGenerator blockStateModelGenerator, Block trellis, String trellisId, String vinesId, String foliageId, String modId){
        Identifier modelID1 = TEMPLATE_TRELLIS_0.upload(trellis, TextureMap.texture(trellis).put(TextureKey.TEXTURE, new Identifier(modId, "block/" + trellisId)).put(TextureKey.CROP, new Identifier(BountifulFares.MOD_ID, "block/" + vinesId + "_0")), blockStateModelGenerator.modelCollector);
        Identifier modelID2 = TEMPLATE_TRELLIS_1.upload(trellis, "_1", TextureMap.texture(trellis).put(TextureKey.TEXTURE, new Identifier(modId, "block/" + trellisId)).put(TextureKey.CROP, new Identifier(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureKey.FRONT, new Identifier(BountifulFares.MOD_ID, "block/" + foliageId + "_1")), blockStateModelGenerator.modelCollector);
        Identifier modelID3 = TEMPLATE_TRELLIS_1.upload(trellis, "_2", TextureMap.texture(trellis).put(TextureKey.TEXTURE, new Identifier(modId, "block/" + trellisId)).put(TextureKey.CROP, new Identifier(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureKey.FRONT, new Identifier(BountifulFares.MOD_ID, "block/" + foliageId + "_2")), blockStateModelGenerator.modelCollector);
        Identifier modelID4 = TEMPLATE_TRELLIS_1.upload(trellis, "_3", TextureMap.texture(trellis).put(TextureKey.TEXTURE, new Identifier(modId, "block/" + trellisId)).put(TextureKey.CROP, new Identifier(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureKey.FRONT, new Identifier(BountifulFares.MOD_ID, "block/" + foliageId + "_3")), blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(trellis)
                .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                        .register(Direction.NORTH, BlockStateVariant.create()
                                .put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .register(Direction.EAST, BlockStateVariant.create()
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.SOUTH, BlockStateVariant.create()
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .register(Direction.WEST, BlockStateVariant.create()
                                .put(VariantSettings.Y, VariantSettings.Rotation.R270)))
                .coordinate(BlockStateVariantMap.create(Properties.AGE_3)
                        .register(0, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID1))
                        .register(1, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID2))
                        .register(2, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID3))
                        .register(3, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4)))
        );
    }

    public static void registerDecorTrellis(BlockStateModelGenerator blockStateModelGenerator, Block trellis, String trellisId, String vinesId, String foliageId, String modId){
        Identifier modelID4 = TEMPLATE_TRELLIS_1.upload(trellis, TextureMap.texture(trellis).put(TextureKey.TEXTURE, new Identifier(modId, "block/" + trellisId)).put(TextureKey.CROP, new Identifier(modId, "block/" + vinesId)).put(TextureKey.FRONT, new Identifier(modId, "block/" + foliageId)), blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(trellis)
                .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                        .register(Direction.NORTH, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4).put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .register(Direction.EAST, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.SOUTH, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .register(Direction.WEST, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4).put(VariantSettings.Y, VariantSettings.Rotation.R270)))
        );
    }

    public static void registerUpsideDownDecorTrellis(BlockStateModelGenerator blockStateModelGenerator, Block trellis, String trellisId, String vinesId, String foliageId, String modId){
        Identifier modelID4 = TEMPLATE_TRELLIS_UPSIDE_DOWN.upload(trellis, TextureMap.texture(trellis).put(TextureKey.TEXTURE, new Identifier(modId, "block/" + trellisId)).put(TextureKey.CROP, new Identifier(modId, "block/" + vinesId)).put(TextureKey.FRONT, new Identifier(modId, "block/" + foliageId)), blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(trellis)
                .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                        .register(Direction.NORTH, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4).put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .register(Direction.EAST, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.SOUTH, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .register(Direction.WEST, BlockStateVariant.create()
                                .put(VariantSettings.MODEL, modelID4).put(VariantSettings.Y, VariantSettings.Rotation.R270)))
        );
    }

    public static Identifier getItemId(Block block) {
        Identifier identifier = Registries.BLOCK.getId(block);
        return identifier.withPrefixedPath("item/");
    }
}
