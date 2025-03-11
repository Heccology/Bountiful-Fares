package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

public class TrellisBlock extends HorizontalFacingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0, 0, 15, 16, 16, 16);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 1);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(15, 0, 0, 16, 16, 16);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0, 0, 0, 1, 16, 16);

    public TrellisVariant variant;
    public TrellisBlock(TrellisVariant variant, Settings settings) {
        super(settings);
        this.variant = variant;
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH));
    }

    public TrellisBlock(Settings settings) {
        super(settings);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
            default:
                return EAST_SHAPE;
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        Direction facing = state.get(FACING);
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        boolean isSurvival = !player.isCreative();
        if (BFBlocks.CROPS_TO_CROP_TRELLISES.containsKey(itemStack.getItem())) {
            if (!world.isClient()) {
                world.setBlockState(pos, BFTrellises.CROP_TRELLISES.get(BFBlocks.CROPS_TO_VINE_CROPS.get(itemStack.getItem()).getName() + variant.getBlockName()).getDefaultState().with(FACING, facing), 2);
            }
            world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            if (isSurvival) {
                itemStack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        if (BFBlocks.PLANTS_TO_DECORATIVE_TRELLISES.containsKey(itemStack.getItem())) {
            if (!world.isClient()) {
                world.setBlockState(pos, BFTrellises.DECORATIVE_TRELLISES.get(BFBlocks.PLANTS_TO_DECORATIVE_VINES.get(itemStack.getItem()).getName() + variant.getBlockName()).getDefaultState().with(FACING, facing), 2);
            }
            world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            if (isSurvival) {
                itemStack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
            if (itemStack.isOf(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "lavender")))) {
                if (!world.isClient()) {
                    world.setBlockState(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_LAVENDER).getDefaultState().with(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    itemStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
            if (itemStack.isOf(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "bleeding_heart")))) {
                if (!world.isClient()) {
                    world.setBlockState(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLEEDING_HEART).getDefaultState().with(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    itemStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
            if (itemStack.isOf(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "blue_bulbs")))) {
                if (!world.isClient()) {
                    world.setBlockState(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLUE_BULB).getDefaultState().with(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    itemStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
            if (itemStack.isOf(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "carnation")))) {
                if (!world.isClient()) {
                    world.setBlockState(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_CARNATION).getDefaultState().with(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    itemStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
            if (itemStack.isOf(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "gardenia")))) {
                if (!world.isClient()) {
                    world.setBlockState(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_GARDENIA).getDefaultState().with(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    itemStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
            if (itemStack.isOf(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "marigold")))) {
                if (!world.isClient()) {
                    world.setBlockState(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_MARIGOLD).getDefaultState().with(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    itemStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
            if (itemStack.isOf(Registries.ITEM.get(Identifier.of(BountifulFares.NATURES_SPIRIT_MOD_ID, "foxglove")))) {
                if (!world.isClient()) {
                    world.setBlockState(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_FOXGLOVE).getDefaultState().with(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    itemStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
        }
        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
            if (itemStack.isOf(Registries.ITEM.get(Identifier.of(BountifulFares.SPAWN_MOD_ID, "sunflower_seeds")))) {
                if (!world.isClient()) {
                    world.setBlockState(pos, TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.SPAWN_SUNFLOWER).getDefaultState().with(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    itemStack.decrement(1);
                }
                return ActionResult.SUCCESS;
            }
        }
        return super.onUse(state, world, pos, player, hit);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
        .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
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

    @Override
    public boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    public static final MapCodec<TrellisBlock> CODEC = TrellisBlock.createCodec(TrellisBlock::new);

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }
}
