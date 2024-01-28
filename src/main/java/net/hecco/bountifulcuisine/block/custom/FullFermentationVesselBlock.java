package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.enums.ItemFermenting;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.stream.Stream;

public class FullFermentationVesselBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape VOXEL_SHAPE = Stream.of(
            Block.createCuboidShape(2, 0, 2, 14, 13, 14),
            Block.createCuboidShape(5, 13, 5, 11, 14, 11),
            Block.createCuboidShape(4, 14, 4, 12, 16, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    protected static int fermentTime;
    private int maxFermentTime = 3;
    protected static final EnumProperty<ItemFermenting> ITEM_FERMENTING = EnumProperty.of("item_fermenting", ItemFermenting.class);
    private static BooleanProperty COMPLETE = BooleanProperty.of("complete");
    public FullFermentationVesselBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(ITEM_FERMENTING, ItemFermenting.SPIDER_EYE).with(COMPLETE, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        fermentTime++;
        if (fermentTime >= maxFermentTime && !state.get(COMPLETE)) {
            world.setBlockState(pos, state.with(COMPLETE, true), 2);
            world.playSound(null, pos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, ITEM_FERMENTING, COMPLETE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        var itemStack = player.getStackInHand(hand);
        if (state.get(ITEM_FERMENTING) == ItemFermenting.SPIDER_EYE && state.get(COMPLETE)) {
            FullFermentationVesselBlock.dropStack(world, pos, new ItemStack(Items.FERMENTED_SPIDER_EYE, 1));
            if(state.get(WATERLOGGED)) {
                world.setBlockState(pos, ModBlocks.OLD_FERMENTATION_VESSEL.getDefaultState().with(WATERLOGGED, true), 2);
            } else if(!state.get(WATERLOGGED)) {
                world.setBlockState(pos, ModBlocks.OLD_FERMENTATION_VESSEL.getDefaultState(), 2);
            }
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F);
            return ActionResult.SUCCESS;
        }


        if (state.get(ITEM_FERMENTING) == ItemFermenting.ELDERBERRIES && state.get(COMPLETE)) {
            if(itemStack.isOf(Items.GLASS_BOTTLE)) {
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 0.8F);
                if (!player.isCreative()) {
                    itemStack.decrement(1);
                }
                if (itemStack.isEmpty() && !player.isCreative()) {
                    player.setStackInHand(hand, new ItemStack(ModItems.ELDERBERRY_WINE_BOTTLE));
                } else if (!player.getInventory().insertStack(new ItemStack(ModItems.ELDERBERRY_WINE_BOTTLE))) {
                    player.dropItem(new ItemStack(ModItems.ELDERBERRY_WINE_BOTTLE), false);
                }
                if(state.get(WATERLOGGED)) {
                    world.setBlockState(pos, ModBlocks.OLD_FERMENTATION_VESSEL.getDefaultState().with(WATERLOGGED, true), 2);
                } else if(!state.get(WATERLOGGED)) {
                    world.setBlockState(pos, ModBlocks.OLD_FERMENTATION_VESSEL.getDefaultState(), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F);
                return ActionResult.SUCCESS;
            } else {
                player.sendMessage(Text.translatable("warning." + BountifulCuisine.MOD_ID + ".fermentation_vessel.use_bottle"), true);
            }

        }
        if (state.get(ITEM_FERMENTING) == ItemFermenting.CITRUS && state.get(COMPLETE)) {
            FullFermentationVesselBlock.dropStack(world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), new ItemStack(ModItems.CITRIC_ACID, 1));
            if(state.get(WATERLOGGED)) {
                world.setBlockState(pos, ModBlocks.OLD_FERMENTATION_VESSEL.getDefaultState().with(WATERLOGGED, true), 2);
            } else if(!state.get(WATERLOGGED)) {
                world.setBlockState(pos, ModBlocks.OLD_FERMENTATION_VESSEL.getDefaultState(), 2);
            }
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(Item.fromBlock(ModBlocks.OLD_FERMENTATION_VESSEL));
    }

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
}
