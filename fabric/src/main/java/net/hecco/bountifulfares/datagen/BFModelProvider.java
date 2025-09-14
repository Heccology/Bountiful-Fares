package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.integration.NoMansLandIntegration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.datagen.BFTemplateModels.*;

public class BFModelProvider extends FabricModelProvider {
    public BFModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.APPLE_LOG.get(), BFBlocks.APPLE_WOOD.get(), BFBlocks.APPLE_LEAVES.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_APPLE_LOG.get(), BFBlocks.STRIPPED_APPLE_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.ORANGE_LOG.get(), BFBlocks.ORANGE_WOOD.get(), BFBlocks.ORANGE_LEAVES.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_ORANGE_LOG.get(), BFBlocks.STRIPPED_ORANGE_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.LEMON_LOG.get(), BFBlocks.LEMON_WOOD.get(), BFBlocks.LEMON_LEAVES.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_LEMON_LOG.get(), BFBlocks.STRIPPED_LEMON_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.PLUM_LOG.get(), BFBlocks.PLUM_WOOD.get(), BFBlocks.PLUM_LEAVES.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_PLUM_LOG.get(), BFBlocks.STRIPPED_PLUM_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.PALM_LOG.get(), BFBlocks.PALM_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.STRIPPED_PALM_LOG.get(), BFBlocks.STRIPPED_PALM_WOOD.get());
        registerFruitLogModels(blockStateModelGenerator, BFBlocks.GOLDEN_APPLE_LOG.get(), BFBlocks.GOLDEN_APPLE_WOOD.get(), BFBlocks.GOLDEN_APPLE_LEAVES.get());

        blockStateModelGenerator.woodProvider(BFBlocks.WALNUT_LOG.get()).logWithHorizontal(BFBlocks.WALNUT_LOG.get()).wood(BFBlocks.WALNUT_WOOD.get());
        blockStateModelGenerator.woodProvider(BFBlocks.STRIPPED_WALNUT_LOG.get()).logWithHorizontal(BFBlocks.STRIPPED_WALNUT_LOG.get()).wood(BFBlocks.STRIPPED_WALNUT_WOOD.get());
        blockStateModelGenerator.createTrivialBlock(BFBlocks.WALNUT_LEAVES.get(), TexturedModel.LEAVES);
        blockStateModelGenerator.createTrivialBlock(BFBlocks.GOLDEN_APPLE_LEAVES.get(), TexturedModel.LEAVES);
        blockStateModelGenerator.createTrivialBlock(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get(), TexturedModel.LEAVES);
        BlockModelGenerators.BlockFamilyProvider walnutTexturePool = blockStateModelGenerator.family(BFBlocks.WALNUT_PLANKS.get());
        walnutTexturePool.stairs(BFBlocks.WALNUT_STAIRS.get());
        walnutTexturePool.slab(BFBlocks.WALNUT_SLAB.get());
        walnutTexturePool.fence(BFBlocks.WALNUT_FENCE.get());
        walnutTexturePool.fenceGate(BFBlocks.WALNUT_FENCE_GATE.get());
        walnutTexturePool.pressurePlate(BFBlocks.WALNUT_PRESSURE_PLATE.get());
        walnutTexturePool.button(BFBlocks.WALNUT_BUTTON.get());
        blockStateModelGenerator.createHangingSign(BFBlocks.STRIPPED_WALNUT_LOG.get(), BFBlocks.WALNUT_HANGING_SIGN.get(), BFBlocks.WALNUT_WALL_HANGING_SIGN.get());
        blockStateModelGenerator.createDoor(BFBlocks.WALNUT_DOOR.get());
        blockStateModelGenerator.createTrivialCube(BFBlocks.CUT_FELDSPAR_BLOCK.get());
        BlockModelGenerators.BlockFamilyProvider feldsparTexturePool = blockStateModelGenerator.family(BFBlocks.FELDSPAR_BRICKS.get());
        feldsparTexturePool.stairs(BFBlocks.FELDSPAR_BRICK_STAIRS.get());
        feldsparTexturePool.slab(BFBlocks.FELDSPAR_BRICK_SLAB.get());
        feldsparTexturePool.wall(BFBlocks.FELDSPAR_BRICK_WALL.get());

        BlockModelGenerators.BlockFamilyProvider coirBrickTexturePool = blockStateModelGenerator.family(BFBlocks.COIR_BRICKS.get());
        coirBrickTexturePool.stairs(BFBlocks.COIR_BRICK_STAIRS.get());
        coirBrickTexturePool.slab(BFBlocks.COIR_BRICK_SLAB.get());
        coirBrickTexturePool.wall(BFBlocks.COIR_BRICK_WALL.get());
        blockStateModelGenerator.createFullAndCarpetBlocks(BFBlocks.PACKED_COCONUT_COIR.get(), BFBlocks.COIR_CARPET.get());

        blockStateModelGenerator.createPlant(BFBlocks.GOLDEN_APPLE_SAPLING.get(), BFBlocks.POTTED_GOLDEN_APPLE_SAPLING.get(), BlockModelGenerators.TintState.NOT_TINTED);

        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.RED_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.ORANGE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.YELLOW_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIME_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.GREEN_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.CYAN_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIGHT_BLUE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.BLUE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.PURPLE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.MAGENTA_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.PINK_JACK_O_STRAW.get());
        registerUnlitableJackOStrawModels(blockStateModelGenerator, BFBlocks.BROWN_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.WHITE_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.LIGHT_GRAY_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.GRAY_JACK_O_STRAW.get());
        registerJackOStrawModels(blockStateModelGenerator, BFBlocks.BLACK_JACK_O_STRAW.get());

//        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.CORAL_JACK_O_STRAW);
//        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.CANARY_JACK_O_STRAW);
//        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.WASABI_JACK_O_STRAW);
//        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SACRAMENTO_JACK_O_STRAW);
//        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SKY_JACK_O_STRAW);
//        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.BLURPLE_JACK_O_STRAW);
//        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.SANGRIA_JACK_O_STRAW);
//        registerJackOStrawModels(blockStateModelGenerator, DelicateDyesBlocks.ROSE_JACK_O_STRAW);

        for (Supplier<Block> block : BFBlocks.PICKETS.values()) {
            registerPicketsModels(blockStateModelGenerator, block.get());
        }
        registerPicketsModels(blockStateModelGenerator, BFBlocks.IRON_RAILING.get());
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.ASPEN_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.CEDAR_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.COCONUT_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.CYPRESS_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.FIR_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.GHAF_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.JOSHUA_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.LARCH_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.MAHOGANY_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.MAPLE_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.OLIVE_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.PALO_VERDE_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.REDWOOD_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.SAXAUL_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.SUGI_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.WILLOW_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, NaturesSpiritBlocks.WISTERIA_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, SpawnBlocks.ROTTEN_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ArtsAndCraftsBlocks.CORK_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, DungeonsDelightBlocks.WORMWOOD_PICKETS);

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
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.OAK);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.SPRUCE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.BIRCH);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.JUNGLE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.ACACIA);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.DARK_OAK);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.MANGROVE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.CHERRY);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.BAMBOO);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WALNUT);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.HOARY);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.CRIMSON);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WARPED);

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.BAOBAB);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WW_CYPRESS);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.PALM);

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ExcessiveBuildingBlocks.ANCIENT);
//        BlockModelGenerators.BlockFamilyProvider walnutMulchBrickPool = blockStateModelGenerator.family(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS);
//        walnutMulchBrickPool.stairs(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_STAIRS);
//        walnutMulchBrickPool.slab(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_SLAB);
//        walnutMulchBrickPool.wall(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICK_WALL);
//        blockStateModelGenerator.delegateItemModel(ExcessiveBuildingBlocks.WALNUT_MULCH_BRICKS, ResourceLocation.fromNamespaceAndPath(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "block/walnut_mulch_bricks"));
//        BlockModelGenerators.BlockFamilyProvider palmMulchBrickPool = blockStateModelGenerator.family(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS);
//        palmMulchBrickPool.stairs(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_STAIRS);
//        palmMulchBrickPool.slab(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_SLAB);
//        palmMulchBrickPool.wall(ExcessiveBuildingBlocks.PALM_MULCH_BRICK_WALL);
//        blockStateModelGenerator.delegateItemModel(ExcessiveBuildingBlocks.PALM_MULCH_BRICKS, ResourceLocation.fromNamespaceAndPath(BountifulFares.EXCESSIVE_BUILDING_MOD_ID, "block/palm_mulch_bricks"));

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, MintBlocks.WINTERGREEN);
//
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, SpawnBlocks.ROTTEN);

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.ASPEN);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.CEDAR);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.COCONUT);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.CYPRESS);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.FIR);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.GHAF);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.JOSHUA);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.LARCH);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.MAHOGANY);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.MAPLE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.OLIVE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.PALO_VERDE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.REDWOOD);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.SAXAUL);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.SUGI);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.WILLOW);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, NaturesSpiritBlocks.WISTERIA);
//
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ArtsAndCraftsBlocks.CORK);
//
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, DungeonsDelightBlocks.WORMWOOD);

        for (Map.Entry<String, Supplier<Block>> entry : BFBlocks.TRELLISES.entrySet()) {
            BFTemplateModels.registerTrellis(blockStateModelGenerator, entry.getValue().get());
        }

        blockStateModelGenerator.createTrivialCube(BFBlocks.FLOUR_BLOCK.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(BFItems.LEEK.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.LEEK_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.LEEK_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CRUSTED_BEEF.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WALNUT.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.HOARY_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.HOARY_BOAT.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.WALNUT_BOAT.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.WALNUT_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.WILD_PASSION_FRUIT_VINE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.WILD_ELDERBERRY_VINE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.FISH_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.APPLE_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STONE_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.FOREST_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.ARID_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MEADOW_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COASTAL_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.BERRY_STUFFED_POTATO.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MAIZE_STUFFED_POTATO.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MAIZE_BREAD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WALNUT_COOKIE.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.CUSTARD.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.PIQUANT_CUSTARD.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.PASSION_CUSTARD.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.COCOA_CUSTARD.get(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.generateFlatItem(BFItems.ANCIENT_CUSTARD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CANDIED_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.CANDIED_PLUM.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.GRASS_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SCORCHKIN_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PALM_FROND.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_COIR.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_HALF.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_CRUSTED_COD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.COCONUT_CANDLE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.DIRT_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PICKLED_SPONGEKIN.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.TROPICAL_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SWEET_BERRY_PIPS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.SEA_SALAD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STUFFED_HOARY_APPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.MIRE_MEDLEY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.STRANGE_CANDY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COCONUT_MILK_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.MELON_PIE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFBlocks.SPONGE_CAKE.get().asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.POPPED_MAIZE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.COOKED_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.PICKLED_BEETROOT.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.FOUL_FLESH.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(BFItems.WATER_CUP.get(), ModelTemplates.FLAT_ITEM);
        for (Supplier<Item> item : BFItems.TIFFINS.values()) {
            itemModelGenerator.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
        }
        for (DyeColor color : DyeColor.values()) {
            itemModelGenerator.generateFlatItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, color.getName() + "_shulker_tiffin_back")), ModelTemplates.FLAT_ITEM);
            itemModelGenerator.generateFlatItem(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, color.getName() + "_shulker_tiffin_front")), ModelTemplates.FLAT_ITEM);
        }



        //COMPAT
        itemModelGenerator.generateFlatItem(NoMansLandIntegration.CANDIED_PEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(NoMansLandIntegration.MAPLE_MEAD_BOTTLE.get(), ModelTemplates.FLAT_ITEM);

    }
}
