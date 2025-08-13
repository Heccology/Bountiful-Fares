package net.hecco.bountifulfares.registry.util;

//import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.definition.entity.FlourProjectileEntity;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.tags.BFBlockTags;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.hecco.heccolib.platform.HLServices;
import net.hecco.heccolib.platform.services.HLRegistryHelper;
import net.minecraft.core.Position;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;

import java.util.Objects;

import static net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES;

public class BFRegistries {
    public static void registerModStuffs() {
//        registerStrippables();
        registerCeramicCheckeredConversions();
//        registerFuels();
        registerModCompostables();

        DispenserBlock.registerBehavior(BFItems.FLOUR.get(), new FlourDispenserBehavior() {});

//        DispenserBlock.registerBehavior(BFItems.GRASS_SEEDS.get(), new GrassSeedsDispenserBehavior() {
//            @Override
//            public ItemStack execute(BlockSource pointer, ItemStack stack) {
//                return super.execute(pointer, stack);
//            } TODO
//        });
    }

    public static void registerCeramicCheckeredConversions() {
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILES.get(), BFBlocks.CHECKERED_CERAMIC_TILES.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_STAIRS.get(), BFBlocks.CHECKERED_CERAMIC_TILE_STAIRS.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_SLAB.get(), BFBlocks.CHECKERED_CERAMIC_TILE_SLAB.get());
//        registerCheckeredCeramic(BFBlocks.CERAMIC_TILE_WALL, BFBlocks.CHECKERED_CERAMIC_TILE_WALL);
        registerCheckeredCeramic(BFBlocks.CRACKED_CERAMIC_TILES.get(), BFBlocks.CRACKED_CHECKERED_CERAMIC_TILES.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_STAIRS.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC_STAIRS.get());
        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_SLAB.get(), BFBlocks.CHECKERED_CERAMIC_MOSAIC_SLAB.get());
//        registerCheckeredCeramic(BFBlocks.CERAMIC_MOSAIC_WALL, BFBlocks.CHECKERED_CERAMIC_MOSAIC_WALL);
//        if (BountifulFares.isModLoaded(BountifulFares.EXCESSIVE_BUILDING_MOD_ID)) {
//            registerCheckeredCeramic(ExcessiveBuildingBlocks.CERAMIC_TILE_VERTICAL_STAIRS, ExcessiveBuildingBlocks.CHECKERED_CERAMIC_TILE_VERTICAL_STAIRS);
//            registerCheckeredCeramic(ExcessiveBuildingBlocks.CERAMIC_MOSAIC_VERTICAL_STAIRS, ExcessiveBuildingBlocks.CHECKERED_CERAMIC_MOSAIC_VERTICAL_STAIRS);
//        }
    }

    public static void registerCheckeredCeramic(Block normal, Block checkered) {
        BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(normal, checkered);
        BFBlocks.CERAMIC_TO_CHECKERED_CERAMIC.put(checkered, normal);
        BFBlocks.REVERT_CHECKERED_CERAMIC.put(checkered, normal);
    }

    public static void registerStrippables() {
//        register(BFBlocks.APPLE_LOG, BFBlocks.STRIPPED_APPLE_LOG);
//        register(BFBlocks.APPLE_WOOD, BFBlocks.STRIPPED_APPLE_WOOD);
//        register(BFBlocks.GOLDEN_APPLE_LOG, BFBlocks.STRIPPED_APPLE_LOG);
//        register(BFBlocks.GOLDEN_APPLE_WOOD, BFBlocks.STRIPPED_APPLE_WOOD);
//        register(BFBlocks.ORANGE_LOG, BFBlocks.STRIPPED_ORANGE_LOG);
//        register(BFBlocks.ORANGE_WOOD, BFBlocks.STRIPPED_ORANGE_WOOD);
//        register(BFBlocks.LEMON_LOG, BFBlocks.STRIPPED_LEMON_LOG);
//        register(BFBlocks.LEMON_WOOD, BFBlocks.STRIPPED_LEMON_WOOD);
//        register(BFBlocks.PLUM_LOG, BFBlocks.STRIPPED_PLUM_LOG);
//        register(BFBlocks.PLUM_WOOD, BFBlocks.STRIPPED_PLUM_WOOD);
//        register(BFBlocks.HOARY_LOG, BFBlocks.STRIPPED_HOARY_LOG);
//        register(BFBlocks.HOARY_WOOD, BFBlocks.STRIPPED_HOARY_WOOD);
//        register(BFBlocks.WALNUT_LOG, BFBlocks.STRIPPED_WALNUT_LOG);
//        register(BFBlocks.WALNUT_WOOD, BFBlocks.STRIPPED_WALNUT_WOOD);
//        register(BFBlocks.PALM_LOG, BFBlocks.STRIPPED_PALM_LOG);
//        register(BFBlocks.PALM_WOOD, BFBlocks.STRIPPED_PALM_WOOD);
    }

    private static void registerModCompostables() {
        COMPOSTABLES.put(BFBlocks.APPLE_LEAVES.get().asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_APPLE_LEAVES.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.APPLE_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.APPLE_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFBlocks.ORANGE_LEAVES.get().asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_ORANGE_LEAVES.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.ORANGE_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.ORANGE_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.ORANGE.get(), 0.65f);
        COMPOSTABLES.put(BFBlocks.LEMON_LEAVES.get().asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_LEMON_LEAVES.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.LEMON_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.LEMON_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.LEMON.get(), 0.65f);
        COMPOSTABLES.put(BFBlocks.PLUM_LEAVES.get().asItem(), 0.3f);
        COMPOSTABLES.put(BFBlocks.FLOWERING_PLUM_LEAVES.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.PLUM_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.PLUM_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.PLUM.get(), 0.65f);
        COMPOSTABLES.put(BFItems.HOARY_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.HOARY_LEAVES.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.HOARY_APPLE_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFBlocks.HOARY_APPLE_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.HOARY_APPLE.get(), 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_LEAVES.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_SAPLING.get().asItem(), 0.85f);
        COMPOSTABLES.put(BFItems.WALNUT.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WALNUT_MULCH.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.WALNUT_MULCH_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.COCONUT.get(), 0.5f);
        COMPOSTABLES.put(BFItems.COCONUT_HALF.get(), 0.3f);
        COMPOSTABLES.put(BFItems.PALM_FROND.get(), 0.5f);
        COMPOSTABLES.put(BFItems.COCONUT_COIR.get(), 0.5f);
        COMPOSTABLES.put(BFBlocks.PACKED_COCONUT_COIR.get(), 0.85f);
        COMPOSTABLES.put(BFBlocks.COIR_CARPET.get(), 0.5f);
        COMPOSTABLES.put(BFBlocks.PALM_MULCH.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.PALM_MULCH_BLOCK.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.PASSION_FRUIT.get(), 0.3f);
        COMPOSTABLES.put(BFItems.ELDERBERRIES.get(), 0.3f);
        COMPOSTABLES.put(BFItems.LAPISBERRY_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.LAPISBERRIES.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_WHEAT.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_POTATOES.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_CARROTS.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_BEETROOTS.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.WILD_MAIZE.get(), 0.5f);
        COMPOSTABLES.put(BFBlocks.WILD_LEEKS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.GRASS_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.MAIZE_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.MAIZE.get(), 0.65f);
        COMPOSTABLES.put(BFItems.LEEK_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFItems.LEEK.get(), 0.65f);
        COMPOSTABLES.put(BFItems.FLOUR.get(), 0.3f);
        COMPOSTABLES.put(BFItems.SPONGEKIN_SEEDS.get(), 0.3f);
        COMPOSTABLES.put(BFBlocks.SPONGEKIN.get().asItem(), 1f);
        COMPOSTABLES.put(BFItems.SPONGEKIN_SLICE.get(), 0.65f);
        COMPOSTABLES.put(BFItems.TEA_BERRIES.get(), 0.5f);
        COMPOSTABLES.put(BFItems.TEA_LEAVES.get(), 0.5f);
        COMPOSTABLES.put(BFItems.DRIED_TEA_LEAVES.get(), 0.5f);
        COMPOSTABLES.put(BFBlocks.CHAMOMILE_FLOWERS.get().asItem(), 0.5f);
        COMPOSTABLES.put(BFBlocks.HONEYSUCKLE.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFBlocks.VIOLET_BELLFLOWER.get().asItem(), 0.65f);
        COMPOSTABLES.put(BFItems.MAIZE_BREAD.get(), 0.85f);
        COMPOSTABLES.put(BFItems.WALNUT_COOKIE.get(), 0.85f);
        COMPOSTABLES.put(BFBlocks.WILD_ELDERBERRY_VINE.get().asItem(), 0.5F);
        COMPOSTABLES.put(BFBlocks.WILD_PASSION_FRUIT_VINE.get().asItem(), 0.5F);
        COMPOSTABLES.put(BFBlocks.WILD_CARROTS.get().asItem(), 0.3F);
        COMPOSTABLES.put(BFBlocks.WILD_WHEAT.get().asItem(), 0.3F);
        COMPOSTABLES.put(BFBlocks.WILD_POTATOES.get().asItem(), 0.3F);
        COMPOSTABLES.put(BFBlocks.WILD_LEEKS.get().asItem(), 0.3F);
        COMPOSTABLES.put(BFBlocks.WILD_BEETROOTS.get().asItem(), 0.3F);
        COMPOSTABLES.put(BFBlocks.WILD_MAIZE.get().asItem(), 0.3F);
        COMPOSTABLES.put(BFItems.SWEET_BERRY_PIPS.get(), 0.3F);
        COMPOSTABLES.put(BFBlocks.ARTISAN_BREAD.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.ARTISAN_COOKIE.get().asItem(), 0.5F);
        COMPOSTABLES.put(BFBlocks.APPLE_PIE.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.ORANGE_PIE.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.LEMON_PIE.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.PLUM_PIE.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.HOARY_PIE.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.MELON_PIE.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.PASSION_FRUIT_TART.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.ELDERBERRY_TART.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.GLOW_BERRY_TART.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.SWEET_BERRY_TART.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.LAPISBERRY_TART.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.COCOA_CAKE.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.COCONUT_CAKE.get().asItem(), 1F);
        COMPOSTABLES.put(BFBlocks.SPONGE_CAKE.get().asItem(), 1F);
        COMPOSTABLES.put(BFItems.POPPED_MAIZE.get(), 0.3F);
    }

    public static void registerFlammables() {
        HLServices.REGISTRY.setFlammable(BFBlockTags.APPLE_LEAVES, 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlockTags.ORANGE_LEAVES, 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlockTags.LEMON_LEAVES, 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlockTags.PLUM_LEAVES, 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlocks.HOARY_LEAVES.get(), 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlocks.PALM_FROND.get(), 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALL_PALM_FROND.get(), 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlockTags.APPLE_LOGS, 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlockTags.ORANGE_LOGS, 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlockTags.LEMON_LOGS, 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlockTags.PLUM_LOGS, 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.PALM_CROWN.get(), 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlockTags.PALM_LOGS, 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlockTags.HOARY_LOGS, 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlockTags.WALNUT_LOGS, 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.HOARY_PLANKS.get(), 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.HOARY_STAIRS.get(), 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.HOARY_SLAB.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.HOARY_FENCE.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.HOARY_FENCE_GATE.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.HOARY_DOOR.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.HOARY_TRAPDOOR.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_PLANKS.get(), 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_STAIRS.get(), 10, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_SLAB.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_FENCE.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_FENCE_GATE.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_DOOR.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_TRAPDOOR.get(), 20, 5);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_MULCH.get(), 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_MULCH_BLOCK.get(), 20, 30);
        HLServices.REGISTRY.setFlammable(BFBlocks.PALM_MULCH.get(), 60, 30);
        HLServices.REGISTRY.setFlammable(BFBlocks.PALM_MULCH_BLOCK.get(), 20, 30);
        HLServices.REGISTRY.setFlammable(BFBlockTags.PICKETS, 20, 5);
    }
}
