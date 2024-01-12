package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.interfaces.DyeableCeramicBlockInterface;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.entity.CeramicTilesBlockEntity;
import net.hecco.bountifulcuisine.sounds.ModSounds;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CeramicPressurePlateBlock extends AbstractPressurePlateBlock implements DyeableCeramicBlockInterface {
    public static final BooleanProperty POWERED = Properties.POWERED;

    public CeramicPressurePlateBlock(Settings settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.setDefaultState((this.stateManager.getDefaultState()).with(POWERED, false));
    }

    @Override
    protected int getTickRate() {
        return 2;
    }

    protected int getRedstoneOutput(BlockState state) {
        return state.get(POWERED) ? 15 : 0;
    }

    protected BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return state.with(POWERED, rsOut > 0);
    }

    protected int getRedstoneOutput(World world, BlockPos pos) {
        Class<Entity> var10000 = Entity.class;
        return getEntityCount(world, BOX.offset(pos), var10000) > 0 ? 15 : 0;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient) {
            int i = this.getRedstoneOutput(state);
            if (i == 0) {
                this.updateCeramicPlateState(entity, world, pos, state, i);
            }

        }
    }

    private void updateCeramicPlateState(@Nullable Entity entity, World world, BlockPos pos, BlockState state, int output) {
        int i = this.getRedstoneOutput(world, pos);
        boolean bl = output > 0;
        boolean bl2 = i > 0;
        if (output != i) {
            BlockState blockState = this.setRedstoneOutput(state, i);
            world.setBlockState(pos, blockState, 2);
            this.updateNeighbors(world, pos);
            world.scheduleBlockRerenderIfNeeded(pos, state, blockState);
        }

        if (!bl2 && bl) {
            world.playSound(null, pos, ModSounds.CERAMIC_TILES_BREAK, SoundCategory.BLOCKS);
            world.emitGameEvent(entity, GameEvent.BLOCK_DEACTIVATE, pos);
            state.get(POWERED);
        } else if (bl2 && !bl) {
            world.playSound(null, pos, ModSounds.CERAMIC_TILES_PLACE, SoundCategory.BLOCKS);
            world.emitGameEvent(entity, GameEvent.BLOCK_ACTIVATE, pos);
        }

        if (bl2) {
            world.scheduleBlockTick(new BlockPos(pos), this, this.getTickRate());
        }

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }


    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        if (CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getPickStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(ModBlocks.CERAMIC_PRESSURE_PLATE);
        }
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }
}
