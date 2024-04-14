package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.custom.PicketsBlock;
import net.hecco.bountifulfares.datagen.custom.ModTemplateModels;
import net.hecco.bountifulfares.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static net.hecco.bountifulfares.datagen.custom.ModTemplateModels.registerPicketsModels;
import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

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
        registerPicketsModels(blockStateModelGenerator, ModBlocks.OAK_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.SPRUCE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.BIRCH_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.JUNGLE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.ACACIA_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.DARK_OAK_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.MANGROVE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.CHERRY_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.BAMBOO_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.HOARY_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.WALNUT_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.CRIMSON_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ModBlocks.WARPED_PICKETS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LEEK, Models.HANDHELD);
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
        itemModelGenerator.register(ModItems.GRASS_SEEDS, Models.GENERATED);
    }
}
