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
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulfares.datagen.bountifulfares.BFTemplateModels.*;

public class BFModelProvider extends FabricModelProvider {
    public BFModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
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

        blockStateModelGenerator.registerLog(BFBlocks.WALNUT_LOG).log(BFBlocks.WALNUT_LOG).wood(BFBlocks.WALNUT_WOOD);
        blockStateModelGenerator.registerLog(BFBlocks.STRIPPED_WALNUT_LOG).log(BFBlocks.STRIPPED_WALNUT_LOG).wood(BFBlocks.STRIPPED_WALNUT_WOOD);
        blockStateModelGenerator.registerSingleton(BFBlocks.WALNUT_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(BFBlocks.GOLDEN_APPLE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES, TexturedModel.LEAVES);
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

        blockStateModelGenerator.registerFlowerPotPlant(BFBlocks.GOLDEN_APPLE_SAPLING, BFBlocks.POTTED_GOLDEN_APPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

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
        BlockStateModelGenerator.BlockTexturePool walnutMulchBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS);
        walnutMulchBrickPool.stairs(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_STAIRS);
        walnutMulchBrickPool.slab(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_SLAB);
        walnutMulchBrickPool.wall(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_WALL);
        blockStateModelGenerator.registerParentedItemModel(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS, Identifier.of(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "block/walnut_mulch_bricks"));
        BlockStateModelGenerator.BlockTexturePool palmMulchBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS);
        palmMulchBrickPool.stairs(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_STAIRS);
        palmMulchBrickPool.slab(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_SLAB);
        palmMulchBrickPool.wall(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_WALL);
        blockStateModelGenerator.registerParentedItemModel(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS, Identifier.of(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "block/palm_mulch_bricks"));

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
        itemModelGenerator.register(BFItems.DIRT_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.PICKLED_SPONGEKIN, Models.GENERATED);
        itemModelGenerator.register(BFItems.TROPICAL_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.SWEET_BERRY_PIPS, Models.GENERATED);
        itemModelGenerator.register(BFItems.SEA_SALAD, Models.GENERATED);
        itemModelGenerator.register(BFItems.STUFFED_HOARY_APPLE, Models.GENERATED);
        itemModelGenerator.register(BFItems.MIRE_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.STRANGE_CANDY, Models.GENERATED);
        itemModelGenerator.register(BFItems.COCONUT_MILK_BOTTLE, Models.GENERATED);
    }
}
