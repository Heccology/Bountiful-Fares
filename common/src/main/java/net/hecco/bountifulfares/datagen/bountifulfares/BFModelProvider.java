package net.hecco.bountifulfares.datagen.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;

import static net.hecco.bountifulfares.datagen.bountifulfares.BFTemplateModels.*;

public class BFModelProvider extends FabricModelProvider {
    public BFModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.APPLE_LOG, BFBlocks.APPLE_WOOD, BFBlocks.APPLE_LEAVES);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_APPLE_LOG, BFBlocks.STRIPPED_APPLE_WOOD);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.ORANGE_LOG, BFBlocks.ORANGE_WOOD, BFBlocks.ORANGE_LEAVES);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_ORANGE_LOG, BFBlocks.STRIPPED_ORANGE_WOOD);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.LEMON_LOG, BFBlocks.LEMON_WOOD, BFBlocks.LEMON_LEAVES);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_LEMON_LOG, BFBlocks.STRIPPED_LEMON_WOOD);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.PLUM_LOG, BFBlocks.PLUM_WOOD, BFBlocks.PLUM_LEAVES);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_PLUM_LOG, BFBlocks.STRIPPED_PLUM_WOOD);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.PALM_LOG, BFBlocks.PALM_WOOD);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_PALM_LOG, BFBlocks.STRIPPED_PALM_WOOD);
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.GOLDEN_APPLE_LOG, BFBlocks.GOLDEN_APPLE_WOOD, BFBlocks.GOLDEN_APPLE_LEAVES);

        blockStateModelGenerator.woodProvider(BFBlocks.WALNUT_LOG).logWithHorizontal(BFBlocks.WALNUT_LOG).wood(BFBlocks.WALNUT_WOOD);
        blockStateModelGenerator.woodProvider(BFBlocks.STRIPPED_WALNUT_LOG).logWithHorizontal(BFBlocks.STRIPPED_WALNUT_LOG).wood(BFBlocks.STRIPPED_WALNUT_WOOD);
        blockStateModelGenerator.createTrivialBlock(BFBlocks.WALNUT_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.createTrivialBlock(BFBlocks.GOLDEN_APPLE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.createTrivialBlock(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES, TexturedModel.LEAVES);
        BlockModelGenerators.BlockFamilyProvider walnutTexturePool = blockStateModelGenerator.family(BFBlocks.WALNUT_PLANKS);
        walnutTexturePool.stairs(BFBlocks.WALNUT_STAIRS);
        walnutTexturePool.slab(BFBlocks.WALNUT_SLAB);
        walnutTexturePool.fence(BFBlocks.WALNUT_FENCE);
        walnutTexturePool.fenceGate(BFBlocks.WALNUT_FENCE_GATE);
        walnutTexturePool.pressurePlate(BFBlocks.WALNUT_PRESSURE_PLATE);
        walnutTexturePool.button(BFBlocks.WALNUT_BUTTON);
        blockStateModelGenerator.createHangingSign(BFBlocks.STRIPPED_WALNUT_LOG, BFBlocks.WALNUT_HANGING_SIGN, BFBlocks.WALNUT_WALL_HANGING_SIGN);
        blockStateModelGenerator.createDoor(BFBlocks.WALNUT_DOOR);
        blockStateModelGenerator.createTrivialCube(BFBlocks.CUT_FELDSPAR_BLOCK);
        BlockModelGenerators.BlockFamilyProvider feldsparTexturePool = blockStateModelGenerator.family(BFBlocks.FELDSPAR_BRICKS);
        feldsparTexturePool.stairs(BFBlocks.FELDSPAR_BRICK_STAIRS);
        feldsparTexturePool.slab(BFBlocks.FELDSPAR_BRICK_SLAB);
        feldsparTexturePool.wall(BFBlocks.FELDSPAR_BRICK_WALL);

        BlockModelGenerators.BlockFamilyProvider coirBrickTexturePool = blockStateModelGenerator.family(BFBlocks.COIR_BRICKS);
        coirBrickTexturePool.stairs(BFBlocks.COIR_BRICK_STAIRS);
        coirBrickTexturePool.slab(BFBlocks.COIR_BRICK_SLAB);
        coirBrickTexturePool.wall(BFBlocks.COIR_BRICK_WALL);
        blockStateModelGenerator.createFullAndCarpetBlocks(BFBlocks.PACKED_COCONUT_COIR, BFBlocks.COIR_CARPET);

        blockStateModelGenerator.createPlant(BFBlocks.GOLDEN_APPLE_SAPLING, BFBlocks.POTTED_GOLDEN_APPLE_SAPLING, BlockModelGenerators.TintState.NOT_TINTED);

        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.RED_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.ORANGE_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.YELLOW_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIME_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.GREEN_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.CYAN_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIGHT_BLUE_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.BLUE_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.PURPLE_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.MAGENTA_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.PINK_JACK_O_STRAW);
        registerUnlitableJackOStrawModels(blockStateModelGenerator, BFBlocks.BROWN_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.WHITE_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIGHT_GRAY_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.GRAY_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.BLACK_JACK_O_STRAW);

        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.CORAL_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.CANARY_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.WASABI_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SKY_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.BLURPLE_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SANGRIA_JACK_O_STRAW);
        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.ROSE_JACK_O_STRAW);

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
        registerPicketsModels(blockStateModelGenerator, BFBlocks.IRON_RAILING);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.ASPEN_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.CEDAR_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.COCONUT_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.CYPRESS_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.FIR_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.GHAF_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.JOSHUA_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.LARCH_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.MAHOGANY_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.MAPLE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.OLIVE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.PALO_VERDE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.REDWOOD_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.SAXAUL_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.SUGI_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.WILLOW_PICKETS);
        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.WISTERIA_PICKETS);
        registerPicketsModels(blockStateModelGenerator, SpawnBlocks.ROTTEN_PICKETS);
        registerPicketsModels(blockStateModelGenerator, ArtsAndCraftsBlocks.CORK_PICKETS);
        registerPicketsModels(blockStateModelGenerator, DungeonsDelightBlocks.WORMWOOD_PICKETS);

//        for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//            if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                ModTemplateModels.registerTrellis(blockStateModelGenerator, TrellisUtil.getTrellisFromVariant(trellis));
//                for (VineCrop crop : TrellisVariants.VineCrops) {
//                    ModTemplateModels.registerCropTrellis(blockStateModelGenerator,
//                            TrellisUtil.getCropTrellisFromVariant(trellis, crop),
//                            trellis.getTrellisName(),
//                            crop.getName() + "_trellis_vines",
//                            crop.getName() + "_trellis_foliage",
//                            trellis.getId());
//                }
//                for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
//                    if (vine != ModTrellises.TWISTING) {
//                        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                                TrellisUtil.getDecorTrellisFromVariant(trellis, vine),
//                                trellis.getTrellisName(),
//                                vine.getName() + "_trellis_vines",
//                                vine.getName() + "_trellis_foliage",
//                                trellis.getId());
//                    } else {
//                        ModTemplateModels.registerUpsideDownDecorTrellis(blockStateModelGenerator,
//                                TrellisUtil.getDecorTrellisFromVariant(trellis, vine),
//                                trellis.getTrellisName(),
//                                vine.getName() + "_trellis_vines",
//                                vine.getName() + "_trellis_foliage",
//                                trellis.getId());
//                    }
//                }
//            }
//        }
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

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.BAOBAB);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WW_CYPRESS);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.PALM);

        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ExcessiveBuildingBlocks.ANCIENT);
        BlockModelGenerators.BlockFamilyProvider walnutMulchBrickPool = blockStateModelGenerator.family(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS);
        walnutMulchBrickPool.stairs(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_STAIRS);
        walnutMulchBrickPool.slab(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_SLAB);
        walnutMulchBrickPool.wall(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_WALL);
        blockStateModelGenerator.delegateItemModel(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS, ResourceLocation.fromNamespaceAndPath(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "block/walnut_mulch_bricks"));
        BlockModelGenerators.BlockFamilyProvider palmMulchBrickPool = blockStateModelGenerator.family(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS);
        palmMulchBrickPool.stairs(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_STAIRS);
        palmMulchBrickPool.slab(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_SLAB);
        palmMulchBrickPool.wall(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_WALL);
        blockStateModelGenerator.delegateItemModel(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS, ResourceLocation.fromNamespaceAndPath(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "block/palm_mulch_bricks"));

        TrellisUtil.registerTrellisModels(blockStateModelGenerator, MintBlocks.WINTERGREEN);

        TrellisUtil.registerTrellisModels(blockStateModelGenerator, SpawnBlocks.ROTTEN);

        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.ASPEN);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.CEDAR);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.COCONUT);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.CYPRESS);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.FIR);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.GHAF);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.JOSHUA);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.LARCH);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.MAHOGANY);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.MAPLE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.OLIVE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.PALO_VERDE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.REDWOOD);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.SAXAUL);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.SUGI);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.WILLOW);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.WISTERIA);

        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ArtsAndCraftsBlocks.CORK);

        TrellisUtil.registerTrellisModels(blockStateModelGenerator, DungeonsDelightBlocks.WORMWOOD);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(BFItems.LEEK, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.LEEK_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.LEEK_STEW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CRUSTED_BEEF, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WALNUT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WALNUT_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WALNUT_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.WILD_PASSION_FRUIT_VINE.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.WILD_ELDERBERRY_VINE.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.FISH_STEW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.APPLE_STEW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STONE_STEW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.FOREST_MEDLEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.ARID_MEDLEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MEADOW_MEDLEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COASTAL_MEDLEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.BERRY_STUFFED_POTATO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MAIZE_STUFFED_POTATO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MAIZE_BREAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WALNUT_COOKIE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CUSTARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PIQUANT_CUSTARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PASSION_CUSTARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCOA_CUSTARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.ANCIENT_CUSTARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CANDIED_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CANDIED_PLUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.GRASS_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SCORCHKIN_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PALM_FROND, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_COIR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_HALF, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_STEW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_CRUSTED_COD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.COCONUT_CANDLE.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.DIRT_STEW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PICKLED_SPONGEKIN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.TROPICAL_MEDLEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SWEET_BERRY_PIPS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SEA_SALAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STUFFED_HOARY_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MIRE_MEDLEY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STRANGE_CANDY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_MILK_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.MELON_PIE.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.SPONGE_CAKE.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.POPPED_MAIZE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COOKED_EGG, ModelTemplates.FLAT_ITEM);
    }
}
