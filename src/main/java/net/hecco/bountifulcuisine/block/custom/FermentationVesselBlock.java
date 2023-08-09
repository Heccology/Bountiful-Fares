package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.enums.ItemFermenting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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

import static net.hecco.bountifulcuisine.block.custom.FullFermentationVesselBlock.ITEM_FERMENTING;

public class FermentationVesselBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static BooleanProperty isFullWithWater = BooleanProperty.of("is_full_with_water");
    protected static final VoxelShape VOXEL_SHAPE = VoxelShapes.combineAndSimplify(Block.createCuboidShape(2, 0, 2, 14, 13, 14), Block.createCuboidShape(5, 13, 5, 11, 15, 11), BooleanBiFunction.OR);
    public FermentationVesselBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(isFullWithWater, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VOXEL_SHAPE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, isFullWithWater);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        var itemStack = player.getStackInHand(hand);
        if(itemStack.isOf(Items.POTION) && PotionUtil.getPotion(itemStack) == Potions.WATER && !state.get(isFullWithWater)) {
            world.setBlockState(pos, state.with(isFullWithWater, true), 2);
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 0.8F);
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            if (itemStack.isEmpty() && !player.isCreative()) {
                player.setStackInHand(hand, new ItemStack(Items.GLASS_BOTTLE));
            } else if (!player.getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE))) {
                player.dropItem(new ItemStack(Items.GLASS_BOTTLE), false);
            }
            return ActionResult.SUCCESS;
        } else if(itemStack.isOf(Items.POTION) && PotionUtil.getPotion(itemStack) == Potions.WATER && state.get(isFullWithWater)) {
            return ActionResult.PASS;
        } else if(state.get(isFullWithWater) && itemStack.isOf(Items.SPIDER_EYE)) {
            world.setBlockState(pos, ModBlocks.FULL_FERMENTATION_VESSEL.getDefaultState().with(ITEM_FERMENTING, ItemFermenting.SPIDER_EYE), 2);
            world.playSound(null, pos, SoundEvents.ENTITY_AXOLOTL_SPLASH, SoundCategory.BLOCKS, 1.0F, 0.8F);
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
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
