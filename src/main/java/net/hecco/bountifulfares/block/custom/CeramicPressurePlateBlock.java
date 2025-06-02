package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BasePressurePlateBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class CeramicPressurePlateBlock extends BasePressurePlateBlock implements EntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public CeramicPressurePlateBlock(Properties settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.registerDefaultState((this.stateDefinition.any()).setValue(POWERED, false));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends BasePressurePlateBlock> codec() {
        return null;
    }

    @Override
    protected int getPressedTime() {
        return 4;
    }

    protected int getSignalForState(BlockState state) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    protected BlockState setSignalForState(BlockState state, int rsOut) {
        return state.setValue(POWERED, rsOut > 0);
    }

    protected int getSignalStrength(Level world, BlockPos pos) {
        Class<Entity> var10000 = Entity.class;
        return getEntityCount(world, TOUCH_AABB.move(pos), var10000) > 0 ? 15 : 0;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        return DyeableCeramicBlock.onUse(stack, state, world, pos, player, hand, state.getBlock());
    }

    private void updateCeramicPlateState(@Nullable Entity entity, Level world, BlockPos pos, BlockState state, int output) {
        int i = this.getSignalStrength(world, pos);
        boolean bl = output > 0;
        boolean bl2 = i > 0;
        if (output != i) {
            BlockState blockState = this.setSignalForState(state, i);
            world.setBlock(pos, blockState, 2);
            this.updateNeighbours(world, pos);
            world.setBlocksDirty(pos, state, blockState);
        }

        if (!bl2 && bl) {
            world.playSound(null, pos, BFSounds.CERAMIC_LEVER_OFF, SoundSource.BLOCKS);
            world.gameEvent(entity, GameEvent.BLOCK_DEACTIVATE, pos);
            state.getValue(POWERED);
        } else if (bl2 && !bl) {
            world.playSound(null, pos, BFSounds.CERAMIC_LEVER_ON, SoundSource.BLOCKS);
            world.gameEvent(entity, GameEvent.BLOCK_ACTIVATE, pos);
        }

        if (bl2) {
            world.scheduleTick(new BlockPos(pos), this, this.getPressedTime());
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }


    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }
}
