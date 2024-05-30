package net.hecco.bountifulfares.block.custom.compat;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class ShortDoorBlock extends Block implements Waterloggable {
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;
    public static final EnumProperty<DoorHinge> HINGE;
    public static final BooleanProperty POWERED;
    public static final BooleanProperty WATERLOGGED;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape EAST_AABB;
    private final BlockSetType type;
    public static final Identifier TOOTH_DOOR_RES;

    public ShortDoorBlock(Block from, BlockSetType blockset) {
        this(from, blockset, (FeatureFlag) null);
    }

    public ShortDoorBlock(Block from, BlockSetType blockset, @Nullable FeatureFlag flag) {
        super(flag != null ? AbstractBlock.Settings.copy(from).requires(new FeatureFlag[]{flag}) : AbstractBlock.Settings.copy(from));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, Boolean.FALSE).with(HINGE, DoorHinge.LEFT).with(POWERED, Boolean.FALSE).with(WATERLOGGED, Boolean.FALSE));
        this.type = blockset;
    }

    public ShortDoorBlock(AbstractBlock.Settings properties, BlockSetType blockset) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, Boolean.FALSE).with(HINGE, DoorHinge.LEFT).with(POWERED, Boolean.FALSE).with(WATERLOGGED, Boolean.FALSE));
        this.type = blockset;
    }

    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess level, BlockPos currentPos, BlockPos facingPos) {
        return !this.canPlaceAt(stateIn, level, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    public void onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(level, pos, state, player);
    }

    public @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        if (blockpos.getY() < context.getWorld().getTopY() && context.getWorld().getBlockState(blockpos).canReplace(context)) {
            World level = context.getWorld();
            Direction face = context.getHorizontalPlayerFacing();
            DoorHinge hinge = this.getHinge(context);
            boolean flag = level.isReceivingRedstonePower(blockpos) || level.isReceivingRedstonePower(blockpos.up());
            boolean waterfilled = level.getFluidState(blockpos).getFluid() == Fluids.WATER;
            if (context.getSide() == context.getHorizontalPlayerFacing().getOpposite() && context.getSide().getAxis().isHorizontal()) {
                face = face.getOpposite();
                hinge = hinge == DoorHinge.LEFT ? DoorHinge.RIGHT : DoorHinge.LEFT;
            }

            return this.getDefaultState().with(FACING, face).with(HINGE, hinge).with(POWERED, flag).with(OPEN, flag).with(WATERLOGGED, waterfilled);
        } else {
            return null;
        }
    }

    public void onPlaced(World level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
    }

    protected DoorHinge getHinge(ItemPlacementContext context) {
        BlockView BlockGetter = context.getWorld();
        BlockPos placePos = context.getBlockPos();
        Direction behindDir = context.getHorizontalPlayerFacing();
        Direction leftDir = behindDir.rotateYCounterclockwise();
        BlockPos leftPos = placePos.offset(leftDir);
        BlockState leftBlockstate = BlockGetter.getBlockState(leftPos);
        Direction rightDir = behindDir.rotateYClockwise();
        BlockPos rightPos = placePos.offset(rightDir);
        BlockState rightBlockstate = BlockGetter.getBlockState(rightPos);
        int i = (leftBlockstate.isFullCube(BlockGetter, leftPos) ? -1 : 0) + (rightBlockstate.isFullCube(BlockGetter, rightPos) ? 1 : 0);
        boolean leftIsLowerOfSameType = leftBlockstate.getBlock() == this;
        boolean rightIsLowerOfSameType = rightBlockstate.getBlock() == this;
        if ((!leftIsLowerOfSameType || rightIsLowerOfSameType) && i <= 0) {
            if ((!rightIsLowerOfSameType || leftIsLowerOfSameType) && i >= 0) {
                int j = behindDir.getOffsetX();
                int k = behindDir.getOffsetZ();
                Vec3d vec3d = context.getHitPos();
                double d0 = vec3d.x - (double) placePos.getX();
                double d1 = vec3d.z - (double) placePos.getZ();
                return j < 0 && d1 < 0.5 || j > 0 && d1 > 0.5 || k < 0 && d0 > 0.5 || k > 0 && d0 < 0.5 ? DoorHinge.RIGHT : DoorHinge.LEFT;
            } else {
                return DoorHinge.LEFT;
            }
        } else {
            return DoorHinge.RIGHT;
        }
    }

    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        if (!this.type.canOpenByHand()) {
            return ActionResult.PASS;
        } else if (state.get(POWERED)) {
            state = state.cycle(OPEN);
            level.setBlockState(pos, state, 10);
            this.playSound(player, level, pos, state.get(OPEN));
            level.emitGameEvent(player, state.get(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            if (state.get(WATERLOGGED)) {
                level.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(level));
            }

            return ActionResult.success(level.isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    public void toggleDoor(World level, BlockPos pos, boolean open) {
        BlockState blockstate = level.getBlockState(pos);
        if (blockstate.getBlock() == this && blockstate.get(OPEN) != open) {
            level.setBlockState(pos, blockstate.with(OPEN, open), 10);
            this.playSound(null, level, pos, open);
        }

    }

    public boolean isOpen(BlockState state) {
        return state.get(OPEN);
    }



    public void neighborUpdate(BlockState state, World level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = level.isReceivingRedstonePower(pos);
        if (blockIn != this && flag != state.get(POWERED)) {
                level.setBlockState(pos, state.with(POWERED, flag), 2);
        }
    }

    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        return true;
    }

    protected void playSound(@Nullable Entity entity, World level, BlockPos pos, boolean isOpen) {
        level.playSound(entity, pos, isOpen ? this.type.doorOpen() : this.type.doorClose(), SoundCategory.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    public long getRenderingSeed(BlockState state, BlockPos pos) {
        return MathHelper.hashCode(pos.getX(), pos.getY(), pos.getZ());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, OPEN, HINGE, POWERED, WATERLOGGED});
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        boolean flag = !(Boolean) state.get(OPEN);
        boolean flag1 = state.get(HINGE) == DoorHinge.RIGHT;
        switch (direction) {
            case EAST:
            default:
                return flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
            case SOUTH:
                return flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
            case WEST:
                return flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
            case NORTH:
                return flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
        }
    }

    public boolean allowsMovement(BlockState state, BlockView level, BlockPos pos, PathNodeType type) {
        switch (type) {
            case WALKABLE, OPEN:
                return state.get(OPEN);
            case WATER:
                return false;
            default:
                return false;
        }
    }

    public PistonBehavior getPushReaction(BlockState state) {
        return PistonBehavior.DESTROY;
    }

    public BlockState rotate(BlockState state, BlockRotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirrorIn) {
        return mirrorIn == BlockMirror.NONE ? state : state.rotate(mirrorIn.getRotation(state.get(FACING))).cycle(HINGE);
    }

    public static boolean isWoodenDoor(World level, BlockPos pos) {
        return isWoodenDoor(level.getBlockState(pos));
    }

    public static boolean isWoodenDoor(BlockState state) {
        return state.getBlock() instanceof ShortDoorBlock;
    }

    public BlockSetType type() {
        return this.type;
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        OPEN = Properties.OPEN;
        HINGE = Properties.DOOR_HINGE;
        POWERED = Properties.POWERED;
        WATERLOGGED = Properties.WATERLOGGED;
        SOUTH_AABB = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        NORTH_AABB = Block.createCuboidShape(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        WEST_AABB = Block.createCuboidShape(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        EAST_AABB = Block.createCuboidShape(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        TOOTH_DOOR_RES = new Identifier("dramaticdoors", "short_tooth_door");
    }
}
