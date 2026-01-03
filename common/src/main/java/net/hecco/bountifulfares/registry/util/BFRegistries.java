package net.hecco.bountifulfares.registry.util;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.nexuslib.lib.loader_agnostic.toolAction.NLToolActions;
import net.hecco.nexuslib.lib.untintedParticleRegistry.NLUntintedParticleRegistry;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES;

public class BFRegistries {
    public static void registerMiscRegistries() {
        registerCeramicCheckeredConversions();
        // registerStrippables();
        // registerTillables();  // Done in NF & Fabric inits respectively
        // registerPathables();
//        registerFuels();
        registerDispenserBehaviors();
    }

    public static void registerUntintedParticleBlocks() {
        NLUntintedParticleRegistry.add(BFBlocks.APPLE_LOG.get());
        NLUntintedParticleRegistry.add(BFBlocks.APPLE_WOOD.get());
        NLUntintedParticleRegistry.add(BFBlocks.ORANGE_LOG.get());
        NLUntintedParticleRegistry.add(BFBlocks.ORANGE_WOOD.get());
        NLUntintedParticleRegistry.add(BFBlocks.LEMON_LOG.get());
        NLUntintedParticleRegistry.add(BFBlocks.LEMON_WOOD.get());
        NLUntintedParticleRegistry.add(BFBlocks.PLUM_LOG.get());
        NLUntintedParticleRegistry.add(BFBlocks.PLUM_WOOD.get());
        NLUntintedParticleRegistry.add(BFBlocks.GRASSY_DIRT.get());
    }

    public static void registerDispenserBehaviors() {
        // Flour
        DispenserBlock.registerBehavior(BFItems.FLOUR.get(), new FlourDispenserBehavior() {});

        // Grass Seeds
        DispenserBlock.registerBehavior(BFItems.GRASS_SEEDS.get(), new GrassSeedsDispenserBehavior() {
            @Override
            public ItemStack execute(BlockSource pointer, ItemStack stack) {
                return super.execute(pointer, stack);
            }
        });

        // Empty Cup (Copies Glass Bottle lololololol)
        DispenserBlock.registerBehavior(BFItems.CUP.get(), new OptionalDispenseItemBehavior() {
            private ItemStack takeLiquid(BlockSource source, ItemStack emptyItem, ItemStack fullItem) {
                source.level().gameEvent(null, GameEvent.FLUID_PICKUP, source.pos());
                return this.consumeWithRemainder(source, emptyItem, fullItem);
            }

            public ItemStack execute(BlockSource blockSource, ItemStack item) {
                this.setSuccess(false);
                ServerLevel serverLevel = blockSource.level();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                BlockState blockState = serverLevel.getBlockState(blockPos);
                if (serverLevel.getFluidState(blockPos).is(FluidTags.WATER)) {
                    this.setSuccess(true);
                    return this.takeLiquid(blockSource, item, new ItemStack(BFItems.WATER_CUP.get()));
                } else {
                    return super.execute(blockSource, item);
                }
            }
        });

        // Water Cup
        DispenserBlock.registerBehavior(BFItems.WATER_CUP.get(), new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            public ItemStack execute(BlockSource blockSource, ItemStack item)
            {
                ServerLevel serverLevel = blockSource.level();
                BlockPos blockPos = blockSource.pos();
                BlockPos blockPos2 = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                if (!serverLevel.getBlockState(blockPos2).is(BlockTags.CONVERTABLE_TO_MUD)) {
                    return this.defaultDispenseItemBehavior.dispense(blockSource, item);
                } else {
                    if (!serverLevel.isClientSide) {
                        for(int i = 0; i < 5; ++i) {
                            serverLevel.sendParticles(ParticleTypes.SPLASH, (double)blockPos.getX() + serverLevel.random.nextDouble(), (blockPos.getY() + 1), (double)blockPos.getZ() + serverLevel.random.nextDouble(),
                                    1, 0.0, 0.0, 0.0, 1.0);
                        }
                    }

                    serverLevel.playSound(null, blockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    serverLevel.gameEvent(null, GameEvent.FLUID_PLACE, blockPos);
                    serverLevel.setBlockAndUpdate(blockPos2, Blocks.MUD.defaultBlockState());
                    return this.consumeWithRemainder(blockSource, item, new ItemStack(BFItems.CUP.get()));
                }
            }
        });
    }

    public static void registerCauldronBehaviors() {
        // Water Cup (Empty Interaction)
        CauldronInteraction.EMPTY.map().put(BFItems.WATER_CUP.get(), (state, level, pos, player, hand, stack) -> {
            if (!level.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(BFItems.CUP.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                level.setBlockAndUpdate(pos, Blocks.WATER_CAULDRON.defaultBlockState());
                level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        });

        // Water Cup (Water Interaction)
        CauldronInteraction.WATER.map().put(BFItems.WATER_CUP.get(), (state, level, pos, player, hand, stack) -> {
            if (state.getValue(LayeredCauldronBlock.LEVEL) == 3) {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            } else {
                if (!level.isClientSide) {
                    Item item = stack.getItem();
                    player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(BFItems.CUP.get())));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(item));
                    level.setBlockAndUpdate(pos, state.cycle(LayeredCauldronBlock.LEVEL));
                    level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }

                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
        });

        // Empty Cup (Water Interaction)
        CauldronInteraction.WATER.map().put(BFItems.CUP.get(), (state, level, pos, player, hand, stack) -> {
            if (!level.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(BFItems.WATER_CUP.get())));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                LayeredCauldronBlock.lowerFillLevel(state, level, pos);
                level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        });
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
        NLToolActions.addStrippable(BFBlocks.APPLE_LOG, BFBlocks.STRIPPED_APPLE_LOG);
        NLToolActions.addStrippable(BFBlocks.APPLE_WOOD, BFBlocks.STRIPPED_APPLE_WOOD);
        NLToolActions.addStrippable(BFBlocks.GOLDEN_APPLE_LOG, BFBlocks.STRIPPED_APPLE_LOG);
        NLToolActions.addStrippable(BFBlocks.GOLDEN_APPLE_WOOD, BFBlocks.STRIPPED_APPLE_WOOD);
        NLToolActions.addStrippable(BFBlocks.ORANGE_LOG, BFBlocks.STRIPPED_ORANGE_LOG);
        NLToolActions.addStrippable(BFBlocks.ORANGE_WOOD, BFBlocks.STRIPPED_ORANGE_WOOD);
        NLToolActions.addStrippable(BFBlocks.LEMON_LOG, BFBlocks.STRIPPED_LEMON_LOG);
        NLToolActions.addStrippable(BFBlocks.LEMON_WOOD, BFBlocks.STRIPPED_LEMON_WOOD);
        NLToolActions.addStrippable(BFBlocks.PLUM_LOG, BFBlocks.STRIPPED_PLUM_LOG);
        NLToolActions.addStrippable(BFBlocks.PLUM_WOOD, BFBlocks.STRIPPED_PLUM_WOOD);
        NLToolActions.addStrippable(BFBlocks.HOARY_LOG, BFBlocks.STRIPPED_HOARY_LOG);
        NLToolActions.addStrippable(BFBlocks.HOARY_WOOD, BFBlocks.STRIPPED_HOARY_WOOD);
        NLToolActions.addStrippable(BFBlocks.WALNUT_LOG, BFBlocks.STRIPPED_WALNUT_LOG);
        NLToolActions.addStrippable(BFBlocks.WALNUT_WOOD, BFBlocks.STRIPPED_WALNUT_WOOD);
        NLToolActions.addStrippable(BFBlocks.PALM_LOG, BFBlocks.STRIPPED_PALM_LOG);
        NLToolActions.addStrippable(BFBlocks.PALM_WOOD, BFBlocks.STRIPPED_PALM_WOOD);
    }

    public static void registerPathables() {
        NLToolActions.addPathable(BFBlocks.GRASSY_DIRT.get(), Blocks.DIRT_PATH);
    }

    public static void registerTillables() {
        NLToolActions.addTillable(BFBlocks.GRASSY_DIRT.get(), Blocks.FARMLAND);
    }

    public static Object2FloatMap<ItemLike> registerModCompostables() {
        Object2FloatMap<ItemLike> compostables = new Object2FloatOpenHashMap();
        compostables.put(BFBlocks.APPLE_LEAVES.get().asItem(), 0.3f);
        compostables.put(BFBlocks.FLOWERING_APPLE_LEAVES.get().asItem(), 0.5f);
        compostables.put(BFBlocks.APPLE_SAPLING.get().asItem(), 0.85f);
        compostables.put(BFBlocks.APPLE_BLOCK.get().asItem(), 1f);
        compostables.put(BFBlocks.ORANGE_LEAVES.get().asItem(), 0.3f);
        compostables.put(BFBlocks.FLOWERING_ORANGE_LEAVES.get().asItem(), 0.5f);
        compostables.put(BFBlocks.ORANGE_SAPLING.get().asItem(), 0.85f);
        compostables.put(BFBlocks.ORANGE_BLOCK.get().asItem(), 1f);
        compostables.put(BFItems.ORANGE.get(), 0.65f);
        compostables.put(BFBlocks.LEMON_LEAVES.get().asItem(), 0.3f);
        compostables.put(BFBlocks.FLOWERING_LEMON_LEAVES.get().asItem(), 0.5f);
        compostables.put(BFBlocks.LEMON_SAPLING.get().asItem(), 0.85f);
        compostables.put(BFBlocks.LEMON_BLOCK.get().asItem(), 1f);
        compostables.put(BFItems.LEMON.get(), 0.65f);
        compostables.put(BFBlocks.PLUM_LEAVES.get().asItem(), 0.3f);
        compostables.put(BFBlocks.FLOWERING_PLUM_LEAVES.get().asItem(), 0.5f);
        compostables.put(BFBlocks.PLUM_SAPLING.get().asItem(), 0.85f);
        compostables.put(BFBlocks.PLUM_BLOCK.get().asItem(), 1f);
        compostables.put(BFItems.PLUM.get(), 0.65f);
        compostables.put(BFItems.HOARY_SEEDS.get(), 0.3f);
        compostables.put(BFBlocks.HOARY_LEAVES.get().asItem(), 0.65f);
        compostables.put(BFBlocks.HOARY_APPLE_SAPLING.get().asItem(), 0.85f);
        compostables.put(BFBlocks.HOARY_APPLE_BLOCK.get().asItem(), 1f);
        compostables.put(BFItems.HOARY_APPLE.get(), 0.65f);
        compostables.put(BFBlocks.WALNUT_LEAVES.get().asItem(), 0.65f);
        compostables.put(BFBlocks.WALNUT_SAPLING.get().asItem(), 0.85f);
        compostables.put(BFItems.WALNUT.get(), 0.3f);
        compostables.put(BFBlocks.WALNUT_MULCH.get().asItem(), 0.65f);
        compostables.put(BFBlocks.WALNUT_MULCH_BLOCK.get().asItem(), 1f);
        compostables.put(BFItems.COCONUT.get(), 0.5f);
        compostables.put(BFItems.COCONUT_HALF.get(), 0.3f);
        compostables.put(BFItems.PALM_FROND.get(), 0.5f);
        compostables.put(BFItems.COCONUT_COIR.get(), 0.5f);
        compostables.put(BFBlocks.PACKED_COCONUT_COIR.get(), 0.85f);
        compostables.put(BFBlocks.COIR_CARPET.get(), 0.5f);
        compostables.put(BFBlocks.PALM_MULCH.get().asItem(), 0.65f);
        compostables.put(BFBlocks.PALM_MULCH_BLOCK.get().asItem(), 1f);
        compostables.put(BFItems.PASSION_FRUIT.get(), 0.3f);
        compostables.put(BFItems.ELDERBERRIES.get(), 0.3f);
        compostables.put(BFItems.LAPISBERRY_SEEDS.get(), 0.3f);
        compostables.put(BFItems.LAPISBERRIES.get(), 0.3f);
        compostables.put(BFBlocks.WILD_WHEAT.get(), 0.3f);
        compostables.put(BFBlocks.WILD_POTATOES.get(), 0.3f);
        compostables.put(BFBlocks.WILD_CARROTS.get(), 0.3f);
        compostables.put(BFBlocks.WILD_BEETROOTS.get(), 0.3f);
        compostables.put(BFBlocks.WILD_MAIZE.get(), 0.5f);
        compostables.put(BFBlocks.WILD_LEEKS.get(), 0.3f);
        compostables.put(BFItems.GRASS_SEEDS.get(), 0.3f);
        compostables.put(BFItems.MAIZE_SEEDS.get(), 0.3f);
        compostables.put(BFItems.MAIZE.get(), 0.65f);
        compostables.put(BFItems.LEEK_SEEDS.get(), 0.3f);
        compostables.put(BFItems.LEEK.get(), 0.65f);
        compostables.put(BFItems.FLOUR.get(), 0.3f);
        compostables.put(BFBlocks.FLOUR_BLOCK.get(), 1.0f);
        compostables.put(BFItems.SPONGEKIN_SEEDS.get(), 0.3f);
        compostables.put(BFBlocks.SPONGEKIN.get().asItem(), 1f);
        compostables.put(BFItems.SPONGEKIN_SLICE.get(), 0.65f);
        compostables.put(BFItems.TEA_BERRIES.get(), 0.5f);
        compostables.put(BFItems.TEA_LEAVES.get(), 0.5f);
        compostables.put(BFItems.DRIED_TEA_LEAVES.get(), 0.5f);
        compostables.put(BFBlocks.CHAMOMILE_FLOWERS.get().asItem(), 0.5f);
        compostables.put(BFBlocks.HONEYSUCKLE.get().asItem(), 0.65f);
        compostables.put(BFBlocks.VIOLET_BELLFLOWER.get().asItem(), 0.65f);
        compostables.put(BFItems.MAIZE_BREAD.get(), 0.85f);
        compostables.put(BFItems.WALNUT_COOKIE.get(), 0.85f);
        compostables.put(BFBlocks.WILD_ELDERBERRY_VINE.get().asItem(), 0.5F);
        compostables.put(BFBlocks.WILD_PASSION_FRUIT_VINE.get().asItem(), 0.5F);
        compostables.put(BFBlocks.WILD_CARROTS.get().asItem(), 0.3F);
        compostables.put(BFBlocks.WILD_WHEAT.get().asItem(), 0.3F);
        compostables.put(BFBlocks.WILD_POTATOES.get().asItem(), 0.3F);
        compostables.put(BFBlocks.WILD_LEEKS.get().asItem(), 0.3F);
        compostables.put(BFBlocks.WILD_BEETROOTS.get().asItem(), 0.3F);
        compostables.put(BFBlocks.WILD_MAIZE.get().asItem(), 0.3F);
        compostables.put(BFItems.SWEET_BERRY_PIPS.get(), 0.3F);
        compostables.put(BFBlocks.ARTISAN_BREAD.get().asItem(), 1F);
        compostables.put(BFBlocks.ARTISAN_COOKIE.get().asItem(), 0.5F);
        compostables.put(BFBlocks.APPLE_PIE.get().asItem(), 1F);
        compostables.put(BFBlocks.ORANGE_PIE.get().asItem(), 1F);
        compostables.put(BFBlocks.LEMON_PIE.get().asItem(), 1F);
        compostables.put(BFBlocks.PLUM_PIE.get().asItem(), 1F);
        compostables.put(BFBlocks.HOARY_PIE.get().asItem(), 1F);
        compostables.put(BFBlocks.MELON_PIE.get().asItem(), 1F);
        compostables.put(BFBlocks.PASSION_FRUIT_TART.get().asItem(), 1F);
        compostables.put(BFBlocks.ELDERBERRY_TART.get().asItem(), 1F);
        compostables.put(BFBlocks.GLOW_BERRY_TART.get().asItem(), 1F);
        compostables.put(BFBlocks.SWEET_BERRY_TART.get().asItem(), 1F);
        compostables.put(BFBlocks.LAPISBERRY_TART.get().asItem(), 1F);
        compostables.put(BFBlocks.COCOA_CAKE.get().asItem(), 1F);
        compostables.put(BFBlocks.COCONUT_CAKE.get().asItem(), 1F);
        compostables.put(BFBlocks.SPONGE_CAKE.get().asItem(), 1F);
        compostables.put(BFItems.POPPED_MAIZE.get(), 0.3F);
        COMPOSTABLES.putAll(compostables);
        return compostables;
    }

    public static void registerFlammables() {
        NLServices.REGISTRY.setFlammable(BFBlocks.APPLE_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.FLOWERING_APPLE_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.ORANGE_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.FLOWERING_ORANGE_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.LEMON_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.FLOWERING_LEMON_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.PLUM_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.FLOWERING_PLUM_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_LEAVES.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.PALM_FROND.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALL_PALM_FROND.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.APPLE_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.APPLE_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_APPLE_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_APPLE_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.ORANGE_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.ORANGE_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_ORANGE_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_ORANGE_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.LEMON_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.LEMON_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_LEMON_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_LEMON_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.PLUM_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.PLUM_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_PLUM_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_PLUM_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.PALM_CROWN.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.PALM_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.PALM_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_PALM_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_PALM_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_WALNUT_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_WALNUT_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_HOARY_LOG.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.STRIPPED_HOARY_WOOD.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_PLANKS.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_STAIRS.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_SLAB.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_FENCE.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_FENCE_GATE.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_DOOR.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.HOARY_TRAPDOOR.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_PLANKS.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_STAIRS.get(), 10, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_SLAB.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_FENCE.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_FENCE_GATE.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_DOOR.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_TRAPDOOR.get(), 20, 5);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_MULCH.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.WALNUT_MULCH_BLOCK.get(), 20, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.PALM_MULCH.get(), 60, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.PALM_MULCH_BLOCK.get(), 20, 30);
        NLServices.REGISTRY.setFlammable(BFBlocks.FLOUR_BLOCK.get(), 10, 5);
        for (Supplier<Block> block : BFBlocks.PICKETS.values()) {
            NLServices.REGISTRY.setFlammable(block.get(), 20, 5);
        }
        for (Supplier<Block> block : BFBlocks.TRELLISES.values()) {
            NLServices.REGISTRY.setFlammable(block.get(), 20, 10);
        }
    }
}
