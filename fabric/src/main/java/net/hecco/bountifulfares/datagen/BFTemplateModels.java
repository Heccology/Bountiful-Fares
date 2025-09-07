package net.hecco.bountifulfares.datagen;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.FruitLogBlock;
import net.hecco.bountifulfares.definition.block.custom.PicketsBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.Optional;

public class BFTemplateModels {
    //Pickets model generation by DigitalPear
    public static final ModelTemplate TEMPLATE_PICKETS = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_pickets").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE);
    public static final ModelTemplate TEMPLATE_TRELLIS = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_trellis").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE);
    public static final ModelTemplate TEMPLATE_TRELLIS_0 = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_planted_trellis_0").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.CROP);
    public static final ModelTemplate TEMPLATE_TRELLIS_1 = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_planted_trellis").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.CROP, TextureSlot.FRONT);
    public static final ModelTemplate TEMPLATE_TRELLIS_UPSIDE_DOWN = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_planted_trellis_upside_down").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.CROP, TextureSlot.FRONT);
    public static void registerPicketsModels(BlockModelGenerators blockStateModelGenerator, Block picket){
        ResourceLocation modelID = TEMPLATE_PICKETS.create(picket, TextureMapping.defaultTexture(picket), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(picket)
                .with(Condition.condition().term(PicketsBlock.NORTH, true),
                        Variant.variant().with(VariantProperties.MODEL, modelID))
                .with(Condition.condition()
                                .term(PicketsBlock.NORTH, false)
                                .term(PicketsBlock.SOUTH, false)
                                .term(PicketsBlock.EAST, false)
                                .term(PicketsBlock.WEST, false),
                        Variant.variant().with(VariantProperties.MODEL, modelID))


                .with(Condition.condition().term(PicketsBlock.EAST, true),
                        Variant.variant().with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .with(Condition.condition()
                                .term(PicketsBlock.NORTH, false)
                                .term(PicketsBlock.SOUTH, false)
                                .term(PicketsBlock.EAST, false)
                                .term(PicketsBlock.WEST, false),
                        Variant.variant().with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))


                .with(Condition.condition().term(PicketsBlock.SOUTH, true),
                        Variant.variant().with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .with(Condition.condition()
                                .term(PicketsBlock.NORTH, false)
                                .term(PicketsBlock.SOUTH, false)
                                .term(PicketsBlock.EAST, false)
                                .term(PicketsBlock.WEST, false),
                        Variant.variant().with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))


                .with(Condition.condition().term(PicketsBlock.WEST, true),
                        Variant.variant().with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .with(Condition.condition()
                                .term(PicketsBlock.NORTH, false)
                                .term(PicketsBlock.SOUTH, false)
                                .term(PicketsBlock.EAST, false)
                                .term(PicketsBlock.WEST, false),
                        Variant.variant().with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))

        );
        ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(picket.asItem()), TextureMapping.layer0(getItemId(picket)), blockStateModelGenerator.modelOutput);
    }

    public static void registerFruitLogModels(BlockModelGenerators blockStateModelGenerator, Block log, Block wood, Block leaves) {
        ResourceLocation logID = BuiltInRegistries.BLOCK.getKey(log);
        ResourceLocation woodID = BuiltInRegistries.BLOCK.getKey(wood);
        ResourceLocation template_fruit_log = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(logID.withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_log_noside = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log_noside").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), logID.getPath() + "_noside").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_log_otherside = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log_otherside").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), logID.getPath() + "_otherside").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_log_side = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log_side").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), logID.getPath() + "_side").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_wood_otherside = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_wood_otherside").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), woodID.getPath() + "_otherside").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_wood_side = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_wood_side").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), woodID.getPath() + "_side").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log").withPrefix("item/")), Optional.empty(), TextureSlot.TEXTURE).create(logID.withPrefix("item/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_wood").withPrefix("item/")), Optional.empty(), TextureSlot.TEXTURE).create(woodID.withPrefix("item/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(log)
                .with(Condition.condition().term(FruitLogBlock.NORTH, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.EAST, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.SOUTH, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.WEST, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.UP, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                )
                .with(Condition.condition().term(FruitLogBlock.DOWN, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.DOWN, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.UP, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.UP, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.WEST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.WEST, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.WEST, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.LEAFY,true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, BuiltInRegistries.BLOCK.getKey(leaves).withPrefix("block/"))
                                .with(VariantProperties.UV_LOCK, true)
                ));

        blockStateModelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(wood)
                .with(Condition.condition().term(FruitLogBlock.NORTH, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.EAST, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.SOUTH, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.WEST, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.UP, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                )
                .with(Condition.condition().term(FruitLogBlock.DOWN, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.DOWN, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.UP, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.UP, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.WEST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.WEST, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.WEST, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.LEAFY,true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, BuiltInRegistries.BLOCK.getKey(leaves).withPrefix("block/"))
                                .with(VariantProperties.UV_LOCK, true)
                ));


    }

    public static void registerFruitLogModels(BlockModelGenerators blockStateModelGenerator, Block log, Block wood) {
        ResourceLocation logID = BuiltInRegistries.BLOCK.getKey(log);
        ResourceLocation woodID = BuiltInRegistries.BLOCK.getKey(wood);
        ResourceLocation template_fruit_log = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(logID.withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_log_noside = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log_noside").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), logID.getPath() + "_noside").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_log_otherside = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log_otherside").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), logID.getPath() + "_otherside").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_log_side = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log_side").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), logID.getPath() + "_side").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_wood_otherside = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_wood_otherside").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), woodID.getPath() + "_otherside").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        ResourceLocation template_fruit_wood_side = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_wood_side").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(ResourceLocation.fromNamespaceAndPath(logID.getNamespace(), woodID.getPath() + "_side").withPrefix("block/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_log").withPrefix("item/")), Optional.empty(), TextureSlot.TEXTURE).create(logID.withPrefix("item/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);
        new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "template_fruit_wood").withPrefix("item/")), Optional.empty(), TextureSlot.TEXTURE).create(woodID.withPrefix("item/"), TextureMapping.defaultTexture(log), blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(log)
                .with(Condition.condition().term(FruitLogBlock.NORTH, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.EAST, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.SOUTH, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.WEST, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.UP, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                )
                .with(Condition.condition().term(FruitLogBlock.DOWN, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.DOWN, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.UP, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.UP, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.WEST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.WEST, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.WEST, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
        );

        blockStateModelGenerator.blockStateOutput.accept(MultiPartGenerator.multiPart(wood)
                .with(Condition.condition().term(FruitLogBlock.NORTH, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.EAST, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.SOUTH, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.WEST, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.UP, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                )
                .with(Condition.condition().term(FruitLogBlock.DOWN, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.DOWN, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.UP, true),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.UP, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.UP, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Y).term(FruitLogBlock.DOWN, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R180)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.EAST, false).term(FruitLogBlock.WEST, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.X).term(FruitLogBlock.WEST, false).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
                )

                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_log_noside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.WEST, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_otherside)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.NORTH, false).term(FruitLogBlock.SOUTH, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
                .with(Condition.condition().term(FruitLogBlock.AXIS, Direction.Axis.Z).term(FruitLogBlock.SOUTH, false).term(FruitLogBlock.EAST, false).term(FruitLogBlock.UP, false).term(FruitLogBlock.WEST, false).term(FruitLogBlock.DOWN, false),
                        Variant.variant()
                                .with(VariantProperties.MODEL, template_fruit_wood_side)
                                .with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
                )
        );


    }

    public static void registerJackOStrawModels(BlockModelGenerators blockStateModelGenerator, Block block) {
        ResourceLocation lowerModel = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "jack_o_straw_lower").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).createWithSuffix(block, "_lower", TextureMapping.defaultTexture(block), blockStateModelGenerator.modelOutput);
        ResourceLocation upperModel = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "jack_o_straw_upper").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).createWithSuffix(block, "_upper", TextureMapping.defaultTexture(block), blockStateModelGenerator.modelOutput);
        ResourceLocation upperLitModel = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "jack_o_straw_upper").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).createWithSuffix(block, "_upper_lit", TextureMapping.defaultTexture(BuiltInRegistries.BLOCK.getKey(block).withPath((path) -> "block/" + path + "_lit")), blockStateModelGenerator.modelOutput);
        new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "jack_o_straw_inventory").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(BuiltInRegistries.BLOCK.getKey(block).withPrefix("item/"), TextureMapping.defaultTexture(block), blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)))
                .with(PropertyDispatch.properties(BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.LIT)
                        .select(DoubleBlockHalf.LOWER, false, Variant.variant().with(VariantProperties.MODEL, lowerModel))
                        .select(DoubleBlockHalf.LOWER, true, Variant.variant().with(VariantProperties.MODEL, lowerModel))
                        .select(DoubleBlockHalf.UPPER, false, Variant.variant().with(VariantProperties.MODEL, upperModel))
                        .select(DoubleBlockHalf.UPPER, true, Variant.variant().with(VariantProperties.MODEL, upperLitModel))
                )
        );
    }

    public static void registerUnlitableJackOStrawModels(BlockModelGenerators blockStateModelGenerator, Block block) {
        ResourceLocation lowerModel = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "jack_o_straw_lower").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).createWithSuffix(block, "_lower", TextureMapping.defaultTexture(block), blockStateModelGenerator.modelOutput);
        ResourceLocation upperModel = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "jack_o_straw_upper").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).createWithSuffix(block, "_upper", TextureMapping.defaultTexture(block), blockStateModelGenerator.modelOutput);
        new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "jack_o_straw_inventory").withPrefix("block/")), Optional.empty(), TextureSlot.TEXTURE).create(BuiltInRegistries.BLOCK.getKey(block).withPrefix("item/"), TextureMapping.defaultTexture(block), blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)))
                .with(PropertyDispatch.property(BlockStateProperties.DOUBLE_BLOCK_HALF)
                        .select(DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, lowerModel))
                        .select(DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, upperModel))
                )
        );
    }


    public static void registerTrellis(BlockModelGenerators blockStateModelGenerator, Block block){
        ResourceLocation modelID = TEMPLATE_TRELLIS.create(block, TextureMapping.defaultTexture(block), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.delegateItemModel(block, modelID);
        blockStateModelGenerator.skipAutoItemBlock(block);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, Variant.variant()
                                .with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, Variant.variant()
                                .with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.SOUTH, Variant.variant()
                                .with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.WEST, Variant.variant()
                                .with(VariantProperties.MODEL, modelID).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)))
        );
    }
    public static void registerCropTrellis(BlockModelGenerators blockStateModelGenerator, Block trellis, String trellisId, String vinesId, String foliageId, String modId){
        ResourceLocation modelID1 = TEMPLATE_TRELLIS_0.create(trellis, TextureMapping.defaultTexture(trellis).put(TextureSlot.TEXTURE, ResourceLocation.fromNamespaceAndPath(modId, "block/" + trellisId)).put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + vinesId + "_0")), blockStateModelGenerator.modelOutput);
        ResourceLocation modelID2 = TEMPLATE_TRELLIS_1.createWithSuffix(trellis, "_1", TextureMapping.defaultTexture(trellis).put(TextureSlot.TEXTURE, ResourceLocation.fromNamespaceAndPath(modId, "block/" + trellisId)).put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureSlot.FRONT, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + foliageId + "_1")), blockStateModelGenerator.modelOutput);
        ResourceLocation modelID3 = TEMPLATE_TRELLIS_1.createWithSuffix(trellis, "_2", TextureMapping.defaultTexture(trellis).put(TextureSlot.TEXTURE, ResourceLocation.fromNamespaceAndPath(modId, "block/" + trellisId)).put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureSlot.FRONT, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + foliageId + "_2")), blockStateModelGenerator.modelOutput);
        ResourceLocation modelID4 = TEMPLATE_TRELLIS_1.createWithSuffix(trellis, "_3", TextureMapping.defaultTexture(trellis).put(TextureSlot.TEXTURE, ResourceLocation.fromNamespaceAndPath(modId, "block/" + trellisId)).put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + vinesId + "_1")).put(TextureSlot.FRONT, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + foliageId + "_3")), blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(trellis)
                .with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, Variant.variant()
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, Variant.variant()
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.SOUTH, Variant.variant()
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.WEST, Variant.variant()
                                .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)))
                .with(PropertyDispatch.property(BlockStateProperties.AGE_3)
                        .select(0, Variant.variant()
                                .with(VariantProperties.MODEL, modelID1))
                        .select(1, Variant.variant()
                                .with(VariantProperties.MODEL, modelID2))
                        .select(2, Variant.variant()
                                .with(VariantProperties.MODEL, modelID3))
                        .select(3, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4)))
        );
    }

    public static void registerDecorTrellis(BlockModelGenerators blockStateModelGenerator, Block trellis, String trellisId, String vinesId, String foliageId, String modId){
        ResourceLocation modelID4 = TEMPLATE_TRELLIS_1.create(trellis, TextureMapping.defaultTexture(trellis).put(TextureSlot.TEXTURE, ResourceLocation.fromNamespaceAndPath(modId, "block/" + trellisId)).put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + vinesId)).put(TextureSlot.FRONT, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + foliageId)), blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(trellis)
                .with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.SOUTH, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.WEST, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)))
        );
    }

    public static void registerUpsideDownDecorTrellis(BlockModelGenerators blockStateModelGenerator, Block trellis, String trellisId, String vinesId, String foliageId, String modId){
        ResourceLocation modelID4 = TEMPLATE_TRELLIS_UPSIDE_DOWN.create(trellis, TextureMapping.defaultTexture(trellis).put(TextureSlot.TEXTURE, ResourceLocation.fromNamespaceAndPath(modId, "block/" + trellisId)).put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + vinesId)).put(TextureSlot.FRONT, ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "block/" + foliageId)), blockStateModelGenerator.modelOutput);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(trellis)
                .with(PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.SOUTH, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.WEST, Variant.variant()
                                .with(VariantProperties.MODEL, modelID4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)))
        );
    }

    public static ResourceLocation getItemId(Block block) {
        ResourceLocation identifier = BuiltInRegistries.BLOCK.getKey(block);
        return identifier.withPrefix("item/");
    }
}
