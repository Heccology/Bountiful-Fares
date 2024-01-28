package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.entity.OldFermentationVesselBlockEntity;
import net.hecco.bountifulcuisine.block.entity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class OldFermentationVesselBlock extends BlockWithEntity implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final BooleanProperty WATER = BooleanProperty.of("water");
    private static final BooleanProperty FERMENTING = BooleanProperty.of("fermenting");
    protected static final VoxelShape VOXEL_SHAPE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 0, 2, 14, 13, 14), Block.createCuboidShape(5, 13, 5, 11, 15, 11), BooleanBiFunction.OR);
    public OldFermentationVesselBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(WATER, false).with(FERMENTING, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VOXEL_SHAPE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, WATER, FERMENTING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof OldFermentationVesselBlockEntity entity) {
            if (entity.canCollect()) {
                if (entity.getCollector() == null) {
                    dropStack(world, pos, entity.getOutput());
                    return ActionResult.SUCCESS;
                } else {
                    Item collector = entity.getCollector();
                    if (player.getStackInHand(hand).isOf(collector)) {
                        player.getStackInHand(hand).decrement(1);
                        dropStack(world, pos, entity.getOutput());
                        return ActionResult.SUCCESS;
                    }
                }
            } else if (entity.canInputItem(player, hand)) {
                entity.setStack(0, new ItemStack(player.getStackInHand(hand).getItem(), 1));
                BountifulCuisine.LOGGER.info("inputted!");
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    public BooleanProperty getFermentingState() {
        return FERMENTING;
    }

//        @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        var itemStack = player.getStackInHand(hand);
//        if(itemStack.isOf(Items.POTION) && PotionUtil.getPotion(itemStack) == Potions.WATER && !state.get(WATER)) {
//            world.setBlockState(pos, state.with(WATER, true), 2);
//            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 0.8F);
//            if (!player.isCreative()) {
//                itemStack.decrement(1);
//            }
//            if (itemStack.isEmpty() && !player.isCreative()) {
//                player.setStackInHand(hand, new ItemStack(Items.GLASS_BOTTLE));
//            } else if (!player.getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE))) {
//                player.dropItem(new ItemStack(Items.GLASS_BOTTLE), false);
//            }
//            return ActionResult.SUCCESS;
//        } else if (itemStack.isOf(Items.WATER_BUCKET) && !state.get(WATER)) {
//            world.setBlockState(pos, state.with(WATER, true), 2);
//            world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F);
//            if (!player.isCreative()) {
//                itemStack.decrement(1);
//            }
//            if (itemStack.isEmpty() && !player.isCreative()) {
//                player.setStackInHand(hand, new ItemStack(Items.BUCKET));
//            } else if (!player.getInventory().insertStack(new ItemStack(Items.BUCKET))) {
//                player.dropItem(new ItemStack(Items.BUCKET), false);
//            }
//            return ActionResult.SUCCESS;
//         }else if(itemStack.isOf(Items.POTION) && PotionUtil.getPotion(itemStack) == Potions.WATER && state.get(WATER)) {
//            return ActionResult.PASS;
//        } else if(state.get(WATER) && itemStack.isOf(Items.SPIDER_EYE)) {
//            if(state.get(WATERLOGGED)) {
//                world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.SPIDER_EYE).with(WATERLOGGED, true), 2);
//            } else if(!state.get(WATERLOGGED)) {
//                world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.SPIDER_EYE), 2);
//            }
//            world.playSound(null, pos, SoundEvents.ENTITY_AXOLOTL_SPLASH, SoundCategory.BLOCKS, 1.0F, 0.8F);
//            if (!player.isCreative()) {
//                itemStack.decrement(1);
//            }
//            return ActionResult.SUCCESS;
//        } else if(state.get(WATER) && itemStack.isOf(ModItems.ELDERBERRIES)) {
//            if (state.get(WATERLOGGED)) {
//                world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.ELDERBERRIES).with(WATERLOGGED, true), 2);
//            } else if (!state.get(WATERLOGGED)) {
//                world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.ELDERBERRIES), 2);
//            }
//            world.playSound(null, pos, SoundEvents.ENTITY_AXOLOTL_SPLASH, SoundCategory.BLOCKS, 1.0F, 0.8F);
//            if (!player.isCreative()) {
//                itemStack.decrement(1);
//            }
//            return ActionResult.SUCCESS;
//        }  else if(state.get(WATER) && itemStack.isOf(ModItems.ORANGE)) {
//            if (state.get(WATERLOGGED)) {
//                world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.CITRUS).with(WATERLOGGED, true), 2);
//            } else if (!state.get(WATERLOGGED)) {
//                world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.CITRUS), 2);
//            }
//            world.playSound(null, pos, SoundEvents.ENTITY_AXOLOTL_SPLASH, SoundCategory.BLOCKS, 1.0F, 0.8F);
//            if (!player.isCreative()) {
//                itemStack.decrement(1);
//            }
//            return ActionResult.SUCCESS;
//        }  else if(state.get(WATER) && itemStack.isOf(ModItems.LEMON)) {
//            if (state.get(WATERLOGGED)) {
//                world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.CITRUS).with(WATERLOGGED, true), 2);
//            } else if (!state.get(WATERLOGGED)) {
//                world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.CITRUS), 2);
//            }
//            world.playSound(null, pos, SoundEvents.ENTITY_AXOLOTL_SPLASH, SoundCategory.BLOCKS, 1.0F, 0.8F);
//            if (!player.isCreative()) {
//                itemStack.decrement(1);
//            }
//            return ActionResult.SUCCESS;
//        }
//        return ActionResult.PASS;
//    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OldFermentationVesselBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.OLD_FERMENTATION_VESSEL_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
