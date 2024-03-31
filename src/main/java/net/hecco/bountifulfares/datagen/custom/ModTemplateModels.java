package net.hecco.bountifulfares.datagen.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModTemplateModels {
    //Pickets model generation by DigitalPear
    public static final Model TEMPLATE_PICKETS = new Model(Optional.of(new Identifier(BountifulFares.MOD_ID, "template_pickets").withPrefixedPath("block/")), Optional.empty(), TextureKey.TEXTURE);
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

    public static Identifier getItemId(Block block) {
        Identifier identifier = Registries.BLOCK.getId(block);
        return identifier.withPrefixedPath("item/");
    }
}
