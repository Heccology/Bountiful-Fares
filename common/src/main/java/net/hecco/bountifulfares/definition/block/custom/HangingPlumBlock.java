package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingPlumBlock extends HangingFruitBlock {
    private static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(7, 14, 7, 9, 16, 9),
            Block.box(6, 13, 6, 10, 16, 10),
            Block.box(6.5, 13, 6.5, 9.5, 16, 9.5),
            Shapes.join(Block.box(6, 11, 6, 10, 15, 10), Block.box(7, 15, 7, 9, 16, 9), BooleanOp.OR),
            Shapes.join(Block.box(5.5, 10, 5.5, 10.5, 15, 10.5), Block.box(7, 15, 7, 9, 16, 9), BooleanOp.OR)};
    private static final VoxelShape[] COLL_SHAPES = new VoxelShape[]{
            Shapes.empty(),
            Shapes.empty(),
            Block.box(6.5, 13, 6.5, 9.5, 16, 9.5),
            Shapes.join(Block.box(6, 11, 6, 10, 15, 10), Block.box(7, 15, 7, 9, 16, 9), BooleanOp.OR),
            Shapes.join(Block.box(5.5, 10, 5.5, 10.5, 15, 10.5), Block.box(7, 15, 7, 9, 16, 9), BooleanOp.OR)};

    public HangingPlumBlock(Properties settings) {
        super(settings);
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
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return Block.canSupportCenter(world, pos.above(), Direction.DOWN) && !world.isWaterAt(pos)
                || world.getBlockState(pos.above()).is(BFBlocks.PLUM_LEAVES.get()) && !world.isWaterAt(pos)
                || world.getBlockState(pos.above()).is(BFBlocks.FLOWERING_PLUM_LEAVES.get()) && !world.isWaterAt(pos);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        int i = state.getValue(AGE);
        if (i == 4) {
            HangingFruitBlock.popResource(world, pos, new ItemStack(BFItems.PLUM.get(), 1));
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
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(BFItems.PLUM.get());
    }
}
