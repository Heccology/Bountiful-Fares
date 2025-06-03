package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TrellisBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape NORTH_SHAPE = Block.box(0, 0, 15, 16, 16, 16);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(0, 0, 0, 16, 16, 1);
    protected static final VoxelShape WEST_SHAPE = Block.box(15, 0, 0, 16, 16, 16);
    protected static final VoxelShape EAST_SHAPE = Block.box(0, 0, 0, 1, 16, 16);

    public TrellisVariant variant;
    public TrellisBlock(TrellisVariant variant, Properties settings) {
        super(settings);
        this.variant = variant;
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
    }

    public TrellisBlock(Properties settings) {
        super(settings);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
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
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        Direction facing = state.getValue(FACING);
        boolean isSurvival = !player.isCreative();
        if (BFBlocks.CROPS_TO_CROP_TRELLISES.containsKey(stack.getItem())) {
            if (!world.isClientSide()) {
                world.setBlock(pos, BFTrellises.CROP_TRELLISES.get(BFBlocks.CROPS_TO_VINE_CROPS.get(stack.getItem()).getName() + variant.getBlockName()).defaultBlockState().setValue(FACING, facing), 2);
            }
            world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
            world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            if (isSurvival) {
                stack.shrink(1);
            }
            return ItemInteractionResult.SUCCESS;
        }
        if (BFBlocks.PLANTS_TO_DECORATIVE_TRELLISES.containsKey(stack.getItem())) {
            if (!world.isClientSide()) {
                world.setBlock(pos, BFTrellises.DECORATIVE_TRELLISES.get(BFBlocks.PLANTS_TO_DECORATIVE_VINES.get(stack.getItem()).getName() + variant.getBlockName()).defaultBlockState().setValue(FACING, facing), 2);
            }
            world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
            world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            if (isSurvival) {
                stack.shrink(1);
            }
            return ItemInteractionResult.SUCCESS;
        }
        if (BountifulFares.isModLoaded(BountifulFares.NATURES_SPIRIT_MOD_ID)) {
            if (stack.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "lavender")))) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_LAVENDER).defaultBlockState().setValue(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    stack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
            if (stack.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "bleeding_heart")))) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLEEDING_HEART).defaultBlockState().setValue(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    stack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
            if (stack.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "blue_bulbs")))) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_BLUE_BULB).defaultBlockState().setValue(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    stack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
            if (stack.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "carnation")))) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_CARNATION).defaultBlockState().setValue(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    stack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
            if (stack.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "gardenia")))) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_GARDENIA).defaultBlockState().setValue(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    stack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
            if (stack.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "marigold")))) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_MARIGOLD).defaultBlockState().setValue(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    stack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
            if (stack.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.NATURES_SPIRIT_MOD_ID, "foxglove")))) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, TrellisUtil.getDecorTrellisFromVariant(variant, BFTrellises.NS_FOXGLOVE).defaultBlockState().setValue(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    stack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
        }
        if (BountifulFares.isModLoaded(BountifulFares.SPAWN_MOD_ID)) {
            if (stack.is(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(BountifulFares.SPAWN_MOD_ID, "sunflower_seeds")))) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, TrellisUtil.getCropTrellisFromVariant(variant, BFTrellises.SPAWN_SUNFLOWER).defaultBlockState().setValue(FACING, facing), 2);
                }
                world.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                if (isSurvival) {
                    stack.shrink(1);
                }
                return ItemInteractionResult.SUCCESS;
            }
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite())
        .setValue(WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }

    public static final MapCodec<TrellisBlock> CODEC = TrellisBlock.simpleCodec(TrellisBlock::new);

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
