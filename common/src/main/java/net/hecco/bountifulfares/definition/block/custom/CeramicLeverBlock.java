package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CeramicLeverBlock extends LeverBlock implements EntityBlock {

    public CeramicLeverBlock(Properties settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        return DyeableCeramicBlock.onUse(stack, state, world, pos, player, hand, state.getBlock());
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        BlockState blockState;
        if (world.isClientSide) {
            blockState = state.cycle(POWERED);
            if (blockState.getValue(POWERED)) {
                makeParticle(blockState, world, pos, 1.0F);
            }

            return InteractionResult.SUCCESS;
        }
        else {
            this.pull(state, world, pos, player);
            SoundEvent f = state.getValue(POWERED) ? BFSounds.CERAMIC_LEVER_OFF.get() : BFSounds.CERAMIC_LEVER_ON.get();
            world.playSound(null, pos, f, SoundSource.BLOCKS, 0.8F, 1);
            world.gameEvent(player, state.getValue(POWERED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACE)) {
            case FLOOR:
                return Block.box(4, 0, 4, 12, 2, 12);
            case WALL:
                switch (state.getValue(FACING)) {
                    case EAST:
                        return Block.box(0, 4, 4, 2, 12, 12);
                    case WEST:
                        return Block.box(14, 4, 4, 16, 12, 12);
                    case SOUTH:
                        return Block.box(4, 4, 0, 12, 12, 2);
                    case NORTH:
                    default:
                        return Block.box(4, 4, 14, 12, 12, 16);
                }
            case CEILING:
            default:
                return Block.box(4, 14, 4, 12, 16, 12);
        }
    }

    public static void makeParticle(BlockState state, LevelAccessor world, BlockPos pos, float alpha) {
        Direction direction = state.getValue(FACING).getOpposite();
        Direction direction2 = getConnectedDirection(state).getOpposite();
        double d = (double)pos.getX() + (double)0.5F + 0.1 * (double)direction.getStepX() + 0.2 * (double)direction2.getStepX();
        double e = (double)pos.getY() + (double)0.5F + 0.1 * (double)direction.getStepY() + 0.2 * (double)direction2.getStepY();
        double f = (double)pos.getZ() + (double)0.5F + 0.1 * (double)direction.getStepZ() + 0.2 * (double)direction2.getStepZ();
        world.addParticle(new DustParticleOptions(DustParticleOptions.REDSTONE_PARTICLE_COLOR, alpha), d, e, f, 0.0F, 0.0F, 0.0F);
    }
}
