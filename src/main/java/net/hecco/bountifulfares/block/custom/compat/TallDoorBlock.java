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
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
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

public class TallDoorBlock extends Block implements Waterloggable {
    public static final EnumProperty<TripleBlockPart> THIRD;
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
    public TallDoorBlock(Block from, BlockSetType blockset) {
        this(from, blockset, null);
    }

    public TallDoorBlock(Block from, BlockSetType blockset, @Nullable FeatureFlag flag) {
        super(flag != null ? Settings.copy(from).requires(new FeatureFlag[]{flag}) : Settings.copy(from));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, Boolean.FALSE).with(HINGE, DoorHinge.LEFT).with(POWERED, Boolean.FALSE).with(WATERLOGGED, Boolean.FALSE).with(THIRD, TripleBlockPart.LOWER));
        this.type = blockset;
    }

    public TallDoorBlock(AbstractBlock.Settings properties, BlockSetType blockset) {
        super(properties);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, Boolean.FALSE).with(HINGE, DoorHinge.LEFT).with(POWERED, Boolean.FALSE).with(WATERLOGGED, Boolean.FALSE).with(THIRD, TripleBlockPart.LOWER));
        this.type = blockset;
    }

    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction facing, BlockState facingState, WorldAccess level, BlockPos currentPos, BlockPos facingPos) {
        TripleBlockPart tripleblockpart = stateIn.get(THIRD);
        if (facing.getAxis() != Direction.Axis.Y || tripleblockpart == TripleBlockPart.LOWER != (facing == Direction.UP) && tripleblockpart != TripleBlockPart.MIDDLE) {
            return tripleblockpart == TripleBlockPart.LOWER && facing == Direction.DOWN && !stateIn.canPlaceAt(level, currentPos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(stateIn, facing, facingState, level, currentPos, facingPos);
        } else {
            return facingState.getBlock() == this && facingState.get(THIRD) != tripleblockpart ? stateIn.with(FACING, facingState.get(FACING)).with(OPEN, facingState.get(OPEN)).with(HINGE, facingState.get(HINGE)).with(POWERED, facingState.get(POWERED)) : Blocks.AIR.getDefaultState();
        }
    }

    public void onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!level.isClient && player.isCreative()) {
            BlockPos otherPos1 = pos;
            BlockPos otherPos2 = pos;
            TripleBlockPart tripleblockpart = state.get(THIRD);
            switch (tripleblockpart) {
                case LOWER:
                    otherPos1 = pos.up();
                    otherPos2 = pos.up(2);
                    break;
                case MIDDLE:
                    otherPos1 = pos.down();
                    otherPos2 = pos.up();
                    break;
                case UPPER:
                    otherPos1 = pos.down(2);
                    otherPos2 = pos.down();
            }

            BlockState blockstate1 = level.getBlockState(otherPos1);
            BlockState blockstate2 = level.getBlockState(otherPos2);
            if (blockstate1.getBlock() == state.getBlock() && blockstate1.get(THIRD) == TripleBlockPart.LOWER) {
                level.setBlockState(otherPos1, blockstate1.get(WATERLOGGED) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState(), 35);
                level.syncWorldEvent(player, 2001, otherPos1, Block.getRawIdFromState(blockstate1));
            }

            if (blockstate2.getBlock() == state.getBlock() && blockstate2.get(THIRD) == TripleBlockPart.LOWER) {
                level.setBlockState(otherPos2, blockstate2.get(WATERLOGGED) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState(), 35);
                level.syncWorldEvent(player, 2001, otherPos1, Block.getRawIdFromState(blockstate1));
            }
        }

        super.onBreak(level, pos, state, player);
    }

    public @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos blockpos = context.getBlockPos();
        if (blockpos.getY() < context.getWorld().getTopY() - 2 && context.getWorld().getBlockState(blockpos.up()).canReplace(context) && context.getWorld().getBlockState(blockpos.up(2)).canReplace(context)) {
            World level = context.getWorld();
            boolean flag = level.isReceivingRedstonePower(blockpos) || level.isReceivingRedstonePower(blockpos.up());
            boolean waterfilled = level.getFluidState(blockpos).getFluid() == Fluids.WATER;
            return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing()).with(HINGE, this.getHinge(context)).with(POWERED, flag).with(OPEN, flag).with(THIRD, TripleBlockPart.LOWER).with(WATERLOGGED, waterfilled);
        } else {
            return null;
        }
    }

    public void onPlaced(World level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        boolean waterfilled = level.getFluidState(pos.up(1)).getFluid() == Fluids.WATER;
        boolean waterfilled2 = level.getFluidState(pos.up(2)).getFluid() == Fluids.WATER;
        level.setBlockState(pos.up(), state.with(THIRD, TripleBlockPart.MIDDLE).with(WATERLOGGED, waterfilled), 3);
        level.setBlockState(pos.up().up(), state.with(THIRD, TripleBlockPart.UPPER).with(WATERLOGGED, waterfilled2), 3);
    }

    private DoorHinge getHinge(ItemPlacementContext context) {
        BlockView BlockGetter = context.getWorld();
        BlockPos placePos = context.getBlockPos();
        Direction behindDir = context.getHorizontalPlayerFacing();
        BlockPos placePosAbove = placePos.up();
        Direction leftDir = behindDir.rotateYCounterclockwise();
        BlockPos leftPos = placePos.offset(leftDir);
        BlockState leftBlockstate = BlockGetter.getBlockState(leftPos);
        BlockPos leftPosAbove = placePosAbove.offset(leftDir);
        BlockState leftAboveBlockstate = BlockGetter.getBlockState(leftPosAbove);
        Direction rightDir = behindDir.rotateYClockwise();
        BlockPos rightPos = placePos.offset(rightDir);
        BlockState rightBlockstate = BlockGetter.getBlockState(rightPos);
        BlockPos rightPosAbove = placePosAbove.offset(rightDir);
        BlockState rightAboveBlockstate = BlockGetter.getBlockState(rightPosAbove);
        int i = (leftBlockstate.isFullCube(BlockGetter, leftPos) ? -1 : 0) + (leftAboveBlockstate.isFullCube(BlockGetter, leftPosAbove) ? -1 : 0) + (rightBlockstate.isFullCube(BlockGetter, rightPos) ? 1 : 0) + (rightAboveBlockstate.isFullCube(BlockGetter, rightPosAbove) ? 1 : 0);
        boolean leftIsLowerOfSameType = leftBlockstate.getBlock() == this && leftBlockstate.get(THIRD) == TripleBlockPart.LOWER;
        boolean rightIsLowerOfSameType = rightBlockstate.getBlock() == this && rightBlockstate.get(THIRD) == TripleBlockPart.LOWER;
        if ((!leftIsLowerOfSameType || rightIsLowerOfSameType) && i <= 0) {
            if ((!rightIsLowerOfSameType || leftIsLowerOfSameType) && i >= 0) {
                int j = behindDir.getOffsetX();
                int k = behindDir.getOffsetZ();
                Vec3d vec3d = context.getHitPos();
                double d0 = vec3d.x - (double)placePos.getX();
                double d1 = vec3d.z - (double)placePos.getZ();
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
        } else {
//            tryOpenDoubleDoor(level, state, pos);
            state = state.cycle(OPEN);
            level.setBlockState(pos, state, 10);
            this.playSound(player, level, pos, state.get(OPEN));
            level.emitGameEvent(player, state.get(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);


            return ActionResult.success(level.isClient);
        }
    }

    public void toggleDoor(World level, BlockPos pos, boolean open) {
        BlockState blockstate = level.getBlockState(pos);
        if (blockstate.getBlock() == this && blockstate.get(OPEN) != open) {
            level.setBlockState(pos, blockstate.with(OPEN, open), 10);
            if (blockstate.get(THIRD) == TripleBlockPart.UPPER) {
                BlockState middle = level.getBlockState(pos.down());
                BlockState bottom = level.getBlockState(pos.down(2));
                if (middle.getBlock() == this) {
                    level.setBlockState(pos.down(), middle.with(OPEN, open), 10);
                }

                if (bottom.getBlock() == this) {
                    level.setBlockState(pos.down(2), middle.with(OPEN, open), 10);
                }
            }

            this.playSound(null, level, pos, open);
        }

    }

    public boolean isOpen(BlockState state) {
        return state.get(OPEN);
    }

    public void setOpen(@Nullable Entity entity, World level, BlockState state, BlockPos pos, boolean open) {
        if (state.isOf(this) && state.get(OPEN) != open) {
            level.setBlockState(pos, state.with(OPEN, open), 10);
            this.playSound(entity, level, pos, open);
            level.emitGameEvent(entity, open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
//            tryOpenDoubleDoor(level, state, pos);
        }

    }

    public void neighborUpdate(BlockState state, World level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = level.isReceivingRedstonePower(pos);
        if (!flag) {
            switch (state.get(THIRD)) {
                case LOWER:
                    flag = level.isReceivingRedstonePower(pos.offset(Direction.UP)) || level.isReceivingRedstonePower(pos.offset(Direction.UP, 2));
                    break;
                case MIDDLE:
                    flag = level.isReceivingRedstonePower(pos.offset(Direction.DOWN)) || level.isReceivingRedstonePower(pos.offset(Direction.UP));
                    break;
                case UPPER:
                    flag = level.isReceivingRedstonePower(pos.offset(Direction.DOWN)) || level.isReceivingRedstonePower(pos.offset(Direction.DOWN, 2));
            }
        }

        if (blockIn != this && flag != state.get(POWERED)) {
            level.setBlockState(pos, state.with(POWERED, flag), 2);
        }
    }

    public boolean canPlaceAt(BlockState state, WorldView level, BlockPos pos) {
        BlockPos below = pos.down();
        BlockPos below2 = below.down();
        BlockState belowState = level.getBlockState(below);
        BlockState below2State = level.getBlockState(below2);
        boolean result;
        if (state.get(THIRD) == TripleBlockPart.LOWER) {
            result = belowState.isSideSolidFullSquare(level, below, Direction.UP);
            return result;
        } else if (state.get(THIRD) == TripleBlockPart.MIDDLE) {
            result = belowState.getBlock() == this;
            return result;
        } else {
            result = belowState.getBlock() == this && below2State.getBlock() == this;
            return result;
        }
    }

    protected void playSound(@Nullable Entity entity, World level, BlockPos pos, boolean isOpen) {
        level.playSound(entity, pos, isOpen ? this.type.doorOpen() : this.type.doorClose(), SoundCategory.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    public long getRenderingSeed(BlockState state, BlockPos pos) {
        return MathHelper.hashCode(pos.getX(), pos.down(state.get(THIRD) == TripleBlockPart.LOWER ? 0 : (state.get(THIRD) == TripleBlockPart.MIDDLE ? 1 : 2)).getY(), pos.getZ());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(THIRD, FACING, OPEN, HINGE, POWERED, WATERLOGGED);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        boolean flag = !(Boolean)state.get(OPEN);
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
        return switch (type) {
            case WALKABLE, OPEN -> state.get(OPEN);
            default -> false;
        };
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
        return state.getBlock() instanceof TallDoorBlock;
    }

//    public static void tryOpenDoubleDoor(World world, BlockState state, BlockPos pos) {
//        if (Compats.DOUBLE_DOORS_INSTALLED || Compats.COUPLINGS_INSTALLED || Compats.modChecker.isQuarkModuleEnabled()) {
//            Direction direction = state.get(FACING);
//            boolean isOpen = state.get(OPEN);
//            DoorHinge isMirrored = state.get(HINGE);
//            BlockPos mirrorPos = pos.offset(isMirrored == DoorHinge.RIGHT ? direction.rotateYCounterclockwise() : direction.rotateYClockwise());
//            BlockPos doorPos = state.get(THIRD) == TripleBlockPart.LOWER ? mirrorPos : mirrorPos.down();
//            BlockState other = world.getBlockState(doorPos);
//            if (other.getBlock() == state.getBlock() && other.get(FACING) == direction && !(Boolean)other.get(POWERED) && other.get(OPEN) == isOpen && other.get(HINGE) != isMirrored) {
//                BlockState newState = other.cycle(OPEN);
//                world.setBlockState(doorPos, newState, 10);
//            }
//        }
//
//    }

    public BlockSetType type() {
        return this.type;
    }

    static {
        THIRD = EnumProperty.of("third", TripleBlockPart.class);
        FACING = HorizontalFacingBlock.FACING;
        OPEN = Properties.OPEN;
        HINGE = Properties.DOOR_HINGE;
        POWERED = Properties.POWERED;
        WATERLOGGED = Properties.WATERLOGGED;
        SOUTH_AABB = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        NORTH_AABB = Block.createCuboidShape(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        WEST_AABB = Block.createCuboidShape(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        EAST_AABB = Block.createCuboidShape(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
    }
}