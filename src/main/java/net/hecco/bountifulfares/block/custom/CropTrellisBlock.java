package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.ModBlocks;
import net.hecco.bountifulfares.block.TrellisVariants;
import net.hecco.bountifulfares.block.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.block.trellis_parts.VineCrop;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
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
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import static net.hecco.bountifulfares.block.ModBlocks.CROPS_TO_CROP_TRELLISES;

public class CropTrellisBlock extends Block implements Waterloggable, Fertilizable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING;
    public static final IntProperty AGE = Properties.AGE_3;
    private final Item berryItem;
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0, 0, 15, 16, 16, 16);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 1);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(15, 0, 0, 16, 16, 16);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0, 0, 0, 1, 16, 16);
    public static BooleanProperty SNIPPED = BooleanProperty.of("snipped");

    public TrellisVariant variant;
    public VineCrop crop;

    public CropTrellisBlock(Item berryItem, TrellisVariant variant, VineCrop crop, Settings settings) {
        super(settings);
        this.berryItem = berryItem;
        CROPS_TO_CROP_TRELLISES.put(berryItem, this);
        this.variant = variant;
        this.crop = crop;
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH).with(AGE, 0).with(SNIPPED, false));
    }
    public CropTrellisBlock(Item seedsItem, Item berryItem, TrellisVariant variant, Settings settings) {
        super(settings);
        this.berryItem = berryItem;
        CROPS_TO_CROP_TRELLISES.put(seedsItem, this);
        this.variant = variant;
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH).with(AGE, 0).with(SNIPPED, false));
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
    public String getTranslationKey() {
        return "block." + variant.getId() + "." + crop.getNameWithId() + "_" + variant.getTrellisName();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, AGE, SNIPPED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = state.get(AGE);
        if (player.getStackInHand(hand).isOf(Items.SHEARS) && !state.get(SNIPPED)) {
            player.getStackInHand(hand).damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
            world.setBlockState(pos, state.with(SNIPPED, true));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
            player.getStackInHand(hand).damage(1, player, (playerx) -> {
                playerx.sendToolBreakStatus(hand);
            });
            return ActionResult.SUCCESS;
        } else if(i != 3) {
            return ActionResult.PASS;
        } else if(state.get(AGE) == 3 & !state.get(SNIPPED)) {
            int j = 1 + world.random.nextInt(2);
            if (this.berryItem != null) {
                dropStack(world, pos, new ItemStack(this.berryItem, world.random.nextBetween(1, 2)));
                world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            }
            BlockState blockState = state.with(AGE, 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(state.get(SNIPPED)) {

        } else if (!isFullyGrown(state)) {
            if (world.random.nextFloat() < 0.2f) {
                world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
            }
        }
    }
    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if(state.get(SNIPPED)) {

        } else if (!isFullyGrown(state)) {
            world.setBlockState(pos, state.cycle(AGE), Block.NOTIFY_LISTENERS);
        }
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
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(TrellisVariants.TRELLISES.get(variant.getTrellisName()));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        if(isFullyGrown(state)) {
            return false;
        }
        return !state.get(SNIPPED);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        if(isFullyGrown(state)) {
            return false;
        }
        return !state.get(SNIPPED);
    }

    protected static boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 3;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }
    public static BlockState getCropTrellisFromCrop(Item seedsItem) {
        if (seedsItem != null && CROPS_TO_CROP_TRELLISES.containsKey(seedsItem)) {
            return (CROPS_TO_CROP_TRELLISES.get(seedsItem)).getDefaultState();
        } else {
            return ModBlocks.TRELLIS.getDefaultState();
        }
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }
}
