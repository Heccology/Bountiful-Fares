package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class HangingFruitBlock extends BushBlock implements BonemealableBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;

    public HangingFruitBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
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
        if (!HangingFruitBlock.isFullyGrown(state) && random.nextFloat() < 0.1) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return false;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        int i = state.getValue(AGE);
        if (i == 4) {
            HangingFruitBlock.popResource(world, pos, new ItemStack(Items.APPLE, 1));
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

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return state.getValue(AGE) < 4;
    }

    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        if (!isFullyGrown(state)) {
            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
        }
    }

    private static boolean isFullyGrown(BlockState state) {
        return state.getValue(AGE) == 4;
    }

    @Override
    public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
        if (isFullyGrown(state)) {
            world.destroyBlock(hit.getBlockPos(), true);
        }
        super.onProjectileHit(world, state, hit, projectile);
    }
}
