package net.hecco.bountifulfares.datagen.bountifulfares;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.FruitLogBlock;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class BFTemplateModels {
    //Pickets model generation by DigitalPear
    public static final Model TEMPLATE_PICKETS = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_pickets").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE);
    public static final Model TEMPLATE_TRELLIS = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_trellis").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE);
    public static final Model TEMPLATE_TRELLIS_0 = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_planted_trellis_0").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE, TextureKey.CROP);
    public static final Model TEMPLATE_TRELLIS_1 = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_planted_trellis").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE, TextureKey.CROP, TextureKey.FRONT);
    public static final Model TEMPLATE_TRELLIS_UPSIDE_DOWN = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_planted_trellis_upside_down").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE, TextureKey.CROP, TextureKey.FRONT);
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

    public static void registerFruitLogModels(BlockStateModelGenerator blockStateModelGenerator, Block log, Block wood, Block leaves) {
        Identifier logID = Registries.BLOCK.getId(log);
        Identifier woodID = Registries.BLOCK.getId(wood);
        Identifier template_fruit_log = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(logID.withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_log_noside = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log_noside").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), logID.getPath() + "_noside").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_log_otherside = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log_otherside").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), logID.getPath() + "_otherside").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_log_side = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log_side").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), logID.getPath() + "_side").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_wood_otherside = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_wood_otherside").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), woodID.getPath() + "_otherside").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_wood_side = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_wood_side").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), woodID.getPath() + "_side").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log").withPrefixedPath("item/")), Optional.empty(), TextureKey.TEXTURE).upload(logID.withPrefixedPath("item/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_wood").withPrefixedPath("item/")), Optional.empty(), TextureKey.TEXTURE).upload(woodID.withPrefixedPath("item/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(log)
                .with(When.create().set(FruitLogBlock.NORTH, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.EAST, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.SOUTH, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.WEST, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.UP, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                )
                .with(When.create().set(FruitLogBlock.DOWN, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.DOWN, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.UP, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.UP, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.WEST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.WEST, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.WEST, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.LEAFY,true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, Registries.BLOCK.getId(leaves).withPrefixedPath("block/"))
                                .put(VariantSettings.UVLOCK, true)
                ));

        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(wood)
                .with(When.create().set(FruitLogBlock.NORTH, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.EAST, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.SOUTH, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.WEST, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.UP, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                )
                .with(When.create().set(FruitLogBlock.DOWN, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.DOWN, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.UP, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.UP, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.WEST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.WEST, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.WEST, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.LEAFY,true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, Registries.BLOCK.getId(leaves).withPrefixedPath("block/"))
                                .put(VariantSettings.UVLOCK, true)
                ));


    }

    public static void registerFruitLogModels(BlockStateModelGenerator blockStateModelGenerator, Block log, Block wood) {
        Identifier logID = Registries.BLOCK.getId(log);
        Identifier woodID = Registries.BLOCK.getId(wood);
        Identifier template_fruit_log = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(logID.withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_log_noside = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log_noside").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), logID.getPath() + "_noside").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_log_otherside = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log_otherside").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), logID.getPath() + "_otherside").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_log_side = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log_side").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), logID.getPath() + "_side").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_wood_otherside = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_wood_otherside").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), woodID.getPath() + "_otherside").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        Identifier template_fruit_wood_side = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_wood_side").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Identifier.of(logID.getNamespace(), woodID.getPath() + "_side").withPrefixedPath("block/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_log").withPrefixedPath("item/")), Optional.empty(), TextureKey.TEXTURE).upload(logID.withPrefixedPath("item/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);
        new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "template_fruit_wood").withPrefixedPath("item/")), Optional.empty(), TextureKey.TEXTURE).upload(woodID.withPrefixedPath("item/"), TextureMap.texture(log), blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(log)
                .with(When.create().set(FruitLogBlock.NORTH, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.EAST, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.SOUTH, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.WEST, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.UP, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                )
                .with(When.create().set(FruitLogBlock.DOWN, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.DOWN, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.UP, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.UP, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.WEST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.WEST, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.WEST, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
        );

        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(wood)
                .with(When.create().set(FruitLogBlock.NORTH, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.EAST, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.SOUTH, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.WEST, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.UP, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                )
                .with(When.create().set(FruitLogBlock.DOWN, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.DOWN, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.UP, true),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.UP, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.UP, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Y).set(FruitLogBlock.DOWN, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R180)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.EAST, false).set(FruitLogBlock.WEST, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.X).set(FruitLogBlock.WEST, false).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                )

                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                                .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_log_noside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.WEST, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_otherside)
                                .put(VariantSettings.X, VariantSettings.Rotation.R90)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.NORTH, false).set(FruitLogBlock.SOUTH, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
                .with(When.create().set(FruitLogBlock.AXIS, Direction.Axis.Z).set(FruitLogBlock.SOUTH, false).set(FruitLogBlock.EAST, false).set(FruitLogBlock.UP, false).set(FruitLogBlock.WEST, false).set(FruitLogBlock.DOWN, false),
                        BlockStateVariant.create()
                                .put(VariantSettings.MODEL, template_fruit_wood_side)
                                .put(VariantSettings.X, VariantSettings.Rotation.R270)
                )
        );


    }

    public static void registerJackOStrawModels(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier lowerModel = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "jack_o_straw_lower").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(block, "_lower", TextureMap.texture(block), blockStateModelGenerator.modelCollector);
        Identifier upperModel = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "jack_o_straw_upper").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(block, "_upper", TextureMap.texture(block), blockStateModelGenerator.modelCollector);
        Identifier upperLitModel = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "jack_o_straw_upper").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(block, "_upper_lit", TextureMap.texture(Registries.BLOCK.getId(block).withPath((path) -> "block/" + path + "_lit")), blockStateModelGenerator.modelCollector);
        new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "jack_o_straw_inventory").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Registries.BLOCK.getId(block).withPrefixedPath("item/"), TextureMap.texture(block), blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                        .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270)))
                .coordinate(BlockStateVariantMap.create(Properties.DOUBLE_BLOCK_HALF, Properties.LIT)
                        .register(DoubleBlockHalf.LOWER, false, BlockStateVariant.create().put(VariantSettings.MODEL, lowerModel))
                        .register(DoubleBlockHalf.LOWER, true, BlockStateVariant.create().put(VariantSettings.MODEL, lowerModel))
                        .register(DoubleBlockHalf.UPPER, false, BlockStateVariant.create().put(VariantSettings.MODEL, upperModel))
                        .register(DoubleBlockHalf.UPPER, true, BlockStateVariant.create().put(VariantSettings.MODEL, upperLitModel))
                )
        );
    }

    public static void registerUnlitableJackOStrawModels(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier lowerModel = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "jack_o_straw_lower").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(block, "_lower", TextureMap.texture(block), blockStateModelGenerator.modelCollector);
        Identifier upperModel = new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "jack_o_straw_upper").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(block, "_upper", TextureMap.texture(block), blockStateModelGenerator.modelCollector);
        new Model(Optional.of(Identifier.of(BountifulFares.MOD_ID, "jack_o_straw_inventory").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE).upload(Registries.BLOCK.getId(block).withPrefixedPath("item/"), TextureMap.texture(block), blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block)
                .coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                        .register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R0))
                        .register(Direction.EAST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90))
                        .register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180))
                        .register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270)))
                .coordinate(BlockStateVariantMap.create(Properties.DOUBLE_BLOCK_HALF)
                        .register(DoubleBlockHalf.LOWER, BlockStateVariant.create().put(VariantSettings.MODEL, lowerModel))
                        .register(DoubleBlockHalf.UPPER, BlockStateVariant.create().put(VariantSettings.MODEL, upperModel))
                )
        );
    }


    public static void registerTrellis(BlockStateModelGenerator blockStateModelGenerator, TrellisVariant trellis){
        Identifier modelID = TEMPLATE_TRELLIS.upload(TrellisUtil.getTrellisFromVariant(trellis), TextureMap.texture(TrellisUtil.getTrellisFromVariant(trellis)), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(TrellisUtil.getTrellisFromVariant(trellis), modelID);
        blockStateModelGenerator.excludeFromSimpleItemModelGeneration(TrellisUtil.getTrellisFromVariant(trellis));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(TrellisUtil.getTrellisFromVariant(trellis))
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
        Identifier modelID1 = TEMPLATE_TRELLIS_0.upload(trellis, TextureMap.texture(trellis).put(TextureKey.TEXTURE, Identifier.of(modId, "block/" + trellisId)).put(TextureKey.CROP, Identifier.of(BountifulFares.MOD_ID, "block/" + vinesId + "_0")), blockStateModelGenerator.modelCollector);
        Identifier modelID2 = TEMPLATE_TRELLIS_1.upload(trellis, "_1", TextureMap.texture(trellis).put(TextureKey.TEXTURE, Identifier.of(modId, "block/" + trellisId)).put(TextureKey.CROP, Identifier.of(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureKey.FRONT, Identifier.of(BountifulFares.MOD_ID, "block/" + foliageId + "_1")), blockStateModelGenerator.modelCollector);
        Identifier modelID3 = TEMPLATE_TRELLIS_1.upload(trellis, "_2", TextureMap.texture(trellis).put(TextureKey.TEXTURE, Identifier.of(modId, "block/" + trellisId)).put(TextureKey.CROP, Identifier.of(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureKey.FRONT, Identifier.of(BountifulFares.MOD_ID, "block/" + foliageId + "_2")), blockStateModelGenerator.modelCollector);
        Identifier modelID4 = TEMPLATE_TRELLIS_1.upload(trellis, "_3", TextureMap.texture(trellis).put(TextureKey.TEXTURE, Identifier.of(modId, "block/" + trellisId)).put(TextureKey.CROP, Identifier.of(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureKey.FRONT, Identifier.of(BountifulFares.MOD_ID, "block/" + foliageId + "_3")), blockStateModelGenerator.modelCollector);

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
        Identifier modelID4 = TEMPLATE_TRELLIS_1.upload(trellis, TextureMap.texture(trellis).put(TextureKey.TEXTURE, Identifier.of(modId, "block/" + trellisId)).put(TextureKey.CROP, Identifier.of(BountifulFares.MOD_ID, "block/" + vinesId)).put(TextureKey.FRONT, Identifier.of(BountifulFares.MOD_ID, "block/" + foliageId)), blockStateModelGenerator.modelCollector);

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
        Identifier modelID4 = TEMPLATE_TRELLIS_UPSIDE_DOWN.upload(trellis, TextureMap.texture(trellis).put(TextureKey.TEXTURE, Identifier.of(modId, "block/" + trellisId)).put(TextureKey.CROP, Identifier.of(BountifulFares.MOD_ID, "block/" + vinesId)).put(TextureKey.FRONT, Identifier.of(BountifulFares.MOD_ID, "block/" + foliageId)), blockStateModelGenerator.modelCollector);

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
