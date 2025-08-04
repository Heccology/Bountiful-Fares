package net.hecco.bountifulfares.definition.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingGoldenAppleBlock extends BushBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.box(7, 13, 7, 9, 16, 9),
            Block.box(6, 13, 6, 10, 16, 10),
            Block.box(6.5, 13, 6.5, 9.5, 16, 9.5),
            Shapes.join(Block.box(5.5, 10, 5.5, 10.5, 15, 10.5), Block.box(7, 15, 7, 9, 16, 9), BooleanOp.OR),
            Shapes.join(Block.box(5, 8, 5, 11, 14, 11), Block.box(7, 14, 7, 9, 16, 9), BooleanOp.OR),
            Shapes.join(Block.box(5, 8, 5, 11, 14, 11), Block.box(7, 14, 7, 9, 16, 9), BooleanOp.OR)
    };
    private static final VoxelShape[] COLL_SHAPES = new VoxelShape[]{Shapes.empty(),
            Shapes.empty(),
            Block.box(6.5, 13, 6.5, 9.5, 16, 9.5),
            Shapes.join(Block.box(5.5, 10, 5.5, 10.5, 15, 10.5), Block.box(7, 15, 7, 9, 16, 9), BooleanOp.OR),
            Shapes.join(Block.box(5, 8, 5, 11, 14, 11), Block.box(7, 14, 7, 9, 16, 9), BooleanOp.OR),
            Shapes.join(Block.box(5, 8, 5, 11, 14, 11), Block.box(7, 14, 7, 9, 16, 9), BooleanOp.OR)
    };

    public HangingGoldenAppleBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape voxelShape = SHAPES[state.getValue(AGE)];
        if (!HLServices.PLATFORM.isModLoaded(BountifulFares.TWIGS_MOD_ID) && !HLServices.PLATFORM.isModLoaded(BountifulFares.ETCETERA_MOD_ID)) {
            Vec3 vec3d = state.getOffset(world, pos);
            return voxelShape.move(vec3d.x, vec3d.y, vec3d.z);
        }
        return voxelShape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape voxelShape = COLL_SHAPES[state.getValue(AGE)];
        if (!HLServices.PLATFORM.isModLoaded(BountifulFares.TWIGS_MOD_ID) && !HLServices.PLATFORM.isModLoaded(BountifulFares.ETCETERA_MOD_ID)) {
            Vec3 vec3d = state.getOffset(world, pos);
            return voxelShape.move(vec3d.x, vec3d.y, vec3d.z);
        }
        return voxelShape;
    }

    @Override
    public float getMaxHorizontalOffset() {
        if (HLServices.PLATFORM.isModLoaded(BountifulFares.TWIGS_MOD_ID) || HLServices.PLATFORM.isModLoaded(BountifulFares.ETCETERA_MOD_ID)) {
            return 0;
        }
        return super.getMaxHorizontalOffset();
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }


    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (world.getMaxLocalRawBrightness(pos) < 8) {
            if (!HangingGoldenAppleBlock.isFullyGrown(state) && random.nextFloat() < 0.025) {
                world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
            }
        } else {
            if (random.nextFloat() < 0.1) {
                world.setBlock(pos, BFBlocks.HANGING_WITHERED_GOLDEN_APPLE.get().defaultBlockState().setValue(HangingWitheredGoldenAppleBlock.AGE, state.getValue(AGE)), Block.UPDATE_CLIENTS);
                world.playSound(null, pos, BFSounds.GOLDEN_APPLE_WITHER.get(), SoundSource.BLOCKS, 1.0f, 0.6f + random.nextFloat()/2);
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return Block.canSupportCenter(world, pos.above(), Direction.DOWN) && !world.isWaterAt(pos)
                || world.getBlockState(pos.above()).is(BFBlocks.GOLDEN_APPLE_LEAVES.get()) && !world.isWaterAt(pos)
                || world.getBlockState(pos.above()).is(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES.get()) && !world.isWaterAt(pos);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        int i = state.getValue(AGE);
        if (i == 5) {
            HangingGoldenAppleBlock.popResource(world, pos, new ItemStack(Items.GOLDEN_APPLE, 1));
            world.playSound(null, pos, BFSounds.HANGING_FRUIT_PICK.get(), SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            if (!world.isClientSide()) {
                if (BountifulFares.CONFIG.isFruitReplaceWhenPicked()) {
                    BlockState blockState = state.setValue(AGE, 0);
                    world.setBlock(pos, blockState, Block.UPDATE_CLIENTS);
                    world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
                } else {
                    world.removeBlock(pos, false);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.useWithoutItem(state, world, pos, player, hit);
    }

    private static boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) == 5;
    }

    @Override
    public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
        if (isFullyGrown(state)) {
            world.destroyBlock(hit.getBlockPos(), true);
        }
        super.onProjectileHit(world, state, hit, projectile);
    }
}
