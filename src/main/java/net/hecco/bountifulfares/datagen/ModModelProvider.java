package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.WALNUT_LOG).log(ModBlocks.WALNUT_LOG).wood(ModBlocks.WALNUT_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_WALNUT_LOG).log(ModBlocks.STRIPPED_WALNUT_LOG).wood(ModBlocks.STRIPPED_WALNUT_WOOD);
        blockStateModelGenerator.registerSingleton(ModBlocks.WALNUT_LEAVES, TexturedModel.LEAVES);
        BlockStateModelGenerator.BlockTexturePool walnutTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WALNUT_PLANKS);
        walnutTexturePool.stairs(ModBlocks.WALNUT_STAIRS);
        walnutTexturePool.slab(ModBlocks.WALNUT_SLAB);
        walnutTexturePool.fence(ModBlocks.WALNUT_FENCE);
        walnutTexturePool.fenceGate(ModBlocks.WALNUT_FENCE_GATE);
        walnutTexturePool.pressurePlate(ModBlocks.WALNUT_PRESSURE_PLATE);
        walnutTexturePool.button(ModBlocks.WALNUT_BUTTON);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_WALNUT_LOG, ModBlocks.WALNUT_HANGING_SIGN, ModBlocks.WALNUT_WALL_HANGING_SIGN);
        blockStateModelGenerator.registerDoor(ModBlocks.WALNUT_DOOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CUT_FELDSPAR_BLOCK);
        BlockStateModelGenerator.BlockTexturePool feldsparTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FELDSPAR_BRICKS);
        feldsparTexturePool.stairs(ModBlocks.FELDSPAR_BRICK_STAIRS);
        feldsparTexturePool.slab(ModBlocks.FELDSPAR_BRICK_SLAB);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LEEK, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEEK_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUSTED_BEEF, Models.GENERATED);
        itemModelGenerator.register(ModItems.WALNUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WALNUT_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.WALNUT_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.WILD_PASSION_FRUIT_VINE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.WILD_ELDERBERRY_VINE.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.FISH_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOREST_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARID_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEADOW_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.COASTAL_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(ModItems.BERRY_STUFFED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAIZE_STUFFED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAIZE_BREAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.WALNUT_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUSTARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIQUANT_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PASSION_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCOA_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOWING_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANDIED_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANDIED_PLUM, Models.GENERATED);
    }
}
