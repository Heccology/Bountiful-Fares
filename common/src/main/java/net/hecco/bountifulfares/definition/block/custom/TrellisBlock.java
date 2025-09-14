package net.hecco.bountifulfares.definition.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.entity.TrellisBlockEntity;
import net.hecco.bountifulfares.definition.data.trellis.TrellisCropDefinition;
import net.hecco.bountifulfares.definition.data.trellis.TrellisPlantDefinition;
import net.hecco.bountifulfares.definition.trigger.PlantOnTrellisTrigger;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.misc.BFCriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
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
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class TrellisBlock extends HorizontalDirectionalBlock implements EntityBlock, SimpleWaterloggedBlock, BonemealableBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape NORTH_SHAPE = Block.box(0, 0, 15, 16, 16, 16);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(0, 0, 0, 16, 16, 1);
    protected static final VoxelShape WEST_SHAPE = Block.box(15, 0, 0, 16, 16, 16);
    protected static final VoxelShape EAST_SHAPE = Block.box(0, 0, 0, 1, 16, 16);

    public static Map<Item, TrellisPlantDefinition> PLANTS = new HashMap<>();
    public static Map<Item, TrellisCropDefinition> CROPS = new HashMap<>();

    public TrellisBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
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
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof TrellisBlockEntity entity) {
            if (CROPS.containsKey(entity.getPlant())) {
                TrellisCropDefinition crop = CROPS.get(entity.getPlant());
                if (entity.getStage() >= crop.stages()) {
                    entity.setStage(Math.max(entity.getStage() - 2, 0));
                    popResource(level, pos, new ItemStack(crop.produce(), crop.minDrops() != crop.maxDrops() ? level.random.nextInt(Math.min(crop.minDrops(), crop.maxDrops()), Math.max(crop.minDrops(), crop.maxDrops())) : crop.minDrops()));
                    //let definition pass a loot table and use that instead, allows for things such as multiple drops and chances
                    level.playSound(null, pos, BFSounds.HANGING_FRUIT_PICK.get(), SoundSource.BLOCKS, 1.0f, 1.0f + (level.random.nextFloat() / 5));
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
     }

    @Override
    protected void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (level.getBlockEntity(pos) instanceof TrellisBlockEntity entity) {
            if (CROPS.containsKey(entity.getPlant())) {
                TrellisCropDefinition crop = CROPS.get(entity.getPlant());
                popResource(level, pos, crop.seeds().getDefaultInstance());
                entity.removePlant();
                level.playSound(null, pos, SoundEvents.CROP_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f + (level.random.nextFloat() / 5));
            }
            if (PLANTS.containsKey(entity.getPlant())) {
                TrellisPlantDefinition crop = PLANTS.get(entity.getPlant());
                popResource(level, pos, crop.plant().getDefaultInstance());
                entity.removePlant();
                level.playSound(null, pos, SoundEvents.CROP_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f + (level.random.nextFloat() / 5));
            }
        }
        super.attack(state, level, pos, player);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof TrellisBlockEntity entity) {
            if (entity.canPlantOn()) {
                if (PLANTS.containsKey(stack.getItem()) || CROPS.containsKey(stack.getItem())) {
                    entity.setPlant(stack.getItem());
                    if (!level.isClientSide()) {
                        ((PlantOnTrellisTrigger) BFCriteriaTriggers.PLANT_ON_TRELLIS.get()).trigger((ServerPlayer) player, stack);
                    }
                    level.playSound(null, pos, SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0f, 1.0f + (level.random.nextFloat() / 5));
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getBlockEntity(pos) instanceof TrellisBlockEntity entity) {
            if (CROPS.containsKey(entity.getPlant())) {
                TrellisCropDefinition crop = CROPS.get(entity.getPlant());
                if (random.nextFloat() < crop.growChance() && entity.getStage() < crop.stages()) {
                    entity.setStage(entity.getStage() + 1);
                }
            }
        }
        super.randomTick(state, level, pos, random);
    }

    @Override
    public void destroy(LevelAccessor world, BlockPos pos, BlockState state) {
        if (world.getBlockEntity(pos) instanceof TrellisBlockEntity entity && !entity.canPlantOn()) {
            popResource((Level) world, pos, entity.getPlant().getDefaultInstance());
        }
        super.destroy(world, pos, state);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TrellisBlockEntity(blockPos, blockState);
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

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return TrellisBlock.simpleCodec(TrellisBlock::new);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        if (levelReader.getBlockEntity(blockPos) instanceof TrellisBlockEntity entity) {
            if (PLANTS.containsKey(entity.getPlant()) && PLANTS.get(entity.getPlant()).canDuplicate()) {
                return true;
            } else if (CROPS.containsKey(entity.getPlant()) && entity.getStage() < CROPS.get(entity.getPlant()).stages()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        if (serverLevel.getBlockEntity(blockPos) instanceof TrellisBlockEntity entity) {
            if (PLANTS.containsKey(entity.getPlant()) && PLANTS.get(entity.getPlant()).canDuplicate()) {
                popResource(serverLevel, blockPos, entity.getPlant().getDefaultInstance());
            } else if (CROPS.containsKey(entity.getPlant()) && entity.getStage() < CROPS.get(entity.getPlant()).stages()) {
                entity.setStage(entity.getStage() + 1);
            }
        }
    }

    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        if (level.getBlockEntity(pos) instanceof TrellisBlockEntity blockEntity && !blockEntity.canPlantOn()) {
            if (CROPS.containsKey(blockEntity.getPlant())) {
                TrellisCropDefinition crop = CROPS.get(blockEntity.getPlant());

                int MAX_COMP = 15;
                float amnt = ((float)blockEntity.getStage() / (float)crop.stages());
                return Math.clamp(Math.round(MAX_COMP * amnt), 1, MAX_COMP);
            }
            else if (PLANTS.containsKey(blockEntity.getPlant())) {
                return 15;
            }
        }

        return 0;
    }
}
