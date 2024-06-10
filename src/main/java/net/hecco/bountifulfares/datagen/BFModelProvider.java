package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.trellis.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.item.BFItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;

import static net.hecco.bountifulfares.datagen.custom.BFTemplateModels.*;
public class BFModelProvider extends FabricModelProvider {
    public BFModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(BFBlocks.WALNUT_LOG).log(BFBlocks.WALNUT_LOG).wood(BFBlocks.WALNUT_WOOD);
        blockStateModelGenerator.registerLog(BFBlocks.STRIPPED_WALNUT_LOG).log(BFBlocks.STRIPPED_WALNUT_LOG).wood(BFBlocks.STRIPPED_WALNUT_WOOD);
        blockStateModelGenerator.registerSingleton(BFBlocks.WALNUT_LEAVES, TexturedModel.LEAVES);
        BlockStateModelGenerator.BlockTexturePool walnutTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BFBlocks.WALNUT_PLANKS);
        walnutTexturePool.stairs(BFBlocks.WALNUT_STAIRS);
        walnutTexturePool.slab(BFBlocks.WALNUT_SLAB);
        walnutTexturePool.fence(BFBlocks.WALNUT_FENCE);
        walnutTexturePool.fenceGate(BFBlocks.WALNUT_FENCE_GATE);
        walnutTexturePool.pressurePlate(BFBlocks.WALNUT_PRESSURE_PLATE);
        walnutTexturePool.button(BFBlocks.WALNUT_BUTTON);
        blockStateModelGenerator.registerHangingSign(BFBlocks.STRIPPED_WALNUT_LOG, BFBlocks.WALNUT_HANGING_SIGN, BFBlocks.WALNUT_WALL_HANGING_SIGN);
        blockStateModelGenerator.registerDoor(BFBlocks.WALNUT_DOOR);
        blockStateModelGenerator.registerSimpleCubeAll(BFBlocks.CUT_FELDSPAR_BLOCK);
        BlockStateModelGenerator.BlockTexturePool feldsparTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BFBlocks.FELDSPAR_BRICKS);
        feldsparTexturePool.stairs(BFBlocks.FELDSPAR_BRICK_STAIRS);
        feldsparTexturePool.slab(BFBlocks.FELDSPAR_BRICK_SLAB);

        BlockStateModelGenerator.BlockTexturePool coirBrickTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BFBlocks.COIR_BRICKS);
        coirBrickTexturePool.stairs(BFBlocks.COIR_BRICK_STAIRS);
        coirBrickTexturePool.slab(BFBlocks.COIR_BRICK_SLAB);
        coirBrickTexturePool.wall(BFBlocks.COIR_BRICK_WALL);
        blockStateModelGenerator.registerWoolAndCarpet(BFBlocks.PACKED_COCONUT_COIR, BFBlocks.COIR_CARPET);

        registerPicketsModels(blockStateModelGenerator, BFBlocks.OAK_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.SPRUCE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.BIRCH_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.JUNGLE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.ACACIA_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.DARK_OAK_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.MANGROVE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.CHERRY_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.BAMBOO_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.HOARY_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.WALNUT_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.CRIMSON_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.WARPED_PICKETS);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.OAK);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.SPRUCE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.BIRCH);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.JUNGLE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.ACACIA);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.DARK_OAK);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.MANGROVE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.CHERRY);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.BAMBOO);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WALNUT);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.HOARY);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.CRIMSON);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WARPED);
        blockStateModelGenerator.registerSimpleCubeAll(BFBlocks.PALM_CROWN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(BFItems.LEEK, Models.HANDHELD);
        itemModelGenerator.register(BFItems.LEEK_SEEDS, Models.GENERATED);
        itemModelGenerator.register(BFItems.LEEK_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.CRUSTED_BEEF, Models.GENERATED);
        itemModelGenerator.register(BFItems.WALNUT, Models.GENERATED);
        itemModelGenerator.register(BFItems.WALNUT_BOAT, Models.GENERATED);
        itemModelGenerator.register(BFItems.WALNUT_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(BFBlocks.WILD_PASSION_FRUIT_VINE.asItem(), Models.GENERATED);
        itemModelGenerator.register(BFBlocks.WILD_ELDERBERRY_VINE.asItem(), Models.GENERATED);
        itemModelGenerator.register(BFItems.FISH_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.APPLE_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.STONE_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.FOREST_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.ARID_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.MEADOW_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.COASTAL_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.BERRY_STUFFED_POTATO, Models.GENERATED);
        itemModelGenerator.register(BFItems.MAIZE_STUFFED_POTATO, Models.GENERATED);
        itemModelGenerator.register(BFItems.MAIZE_BREAD, Models.GENERATED);
        itemModelGenerator.register(BFItems.WALNUT_COOKIE, Models.GENERATED);
        itemModelGenerator.register(BFItems.CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.PIQUANT_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.PASSION_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.COCOA_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.ANCIENT_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.CANDIED_APPLE, Models.GENERATED);
        itemModelGenerator.register(BFItems.CANDIED_PLUM, Models.GENERATED);
        itemModelGenerator.register(BFItems.GRASS_SEEDS, Models.GENERATED);
        itemModelGenerator.register(BFItems.SCORCHKIN_SEEDS, Models.GENERATED);
        itemModelGenerator.register(BFItems.PALM_FROND, Models.GENERATED);
        itemModelGenerator.register(BFItems.COCONUT, Models.GENERATED);
        itemModelGenerator.register(BFItems.COCONUT_COIR, Models.GENERATED);
        itemModelGenerator.register(BFItems.COCONUT_HALF, Models.GENERATED);
        itemModelGenerator.register(BFItems.COCONUT_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.COCONUT_CRUSTED_COD, Models.GENERATED);
        itemModelGenerator.register(BFBlocks.COCONUT_CANDLE.asItem(), Models.GENERATED);
    }
}
