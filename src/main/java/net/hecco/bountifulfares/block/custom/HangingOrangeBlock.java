package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.sounds.BFSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class HangingOrangeBlock extends HangingFruitBlock {
    private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.createCuboidShape(7, 13, 7, 9, 16, 9),
            Block.createCuboidShape(6, 13, 6, 10, 16, 10),
            Block.createCuboidShape(6.5, 13, 6.5, 9.5, 16, 9.5),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5.5, 10, 5.5, 10.5, 15, 10.5), Block.createCuboidShape(7, 15, 7, 9, 16, 9), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 8, 5, 11, 14, 11), Block.createCuboidShape(7, 14, 7, 9, 16, 9), BooleanBiFunction.OR)};
    private static final VoxelShape[] COLL_SHAPES = new VoxelShape[]{
            VoxelShapes.empty(),
            VoxelShapes.empty(),
            Block.createCuboidShape(6.5, 13, 6.5, 9.5, 16, 9.5),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5.5, 10, 5.5, 10.5, 15, 10.5), Block.createCuboidShape(7, 15, 7, 9, 16, 9), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 8, 5, 11, 14, 11), Block.createCuboidShape(7, 14, 7, 9, 16, 9), BooleanBiFunction.OR)};

    public HangingOrangeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        VoxelShape voxelShape = SHAPES[state.get(AGE)];
        return voxelShape.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        VoxelShape voxelShape = COLL_SHAPES[state.get(AGE)];
        return voxelShape.offset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.up(), Direction.DOWN) && !world.isWater(pos)
                || world.getBlockState(pos.up()).isOf(BFBlocks.ORANGE_LEAVES) && !world.isWater(pos)
                || world.getBlockState(pos.up()).isOf(BFBlocks.FLOWERING_ORANGE_LEAVES) && !world.isWater(pos);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = state.get(AGE);
        if (i != 4 && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        }
        if (i == 4) {
            HangingFruitBlock.dropStack(world, pos, new ItemStack(BFItems.ORANGE, 1));
            world.playSound(null, pos, BFSounds.HANGING_FRUIT_PICK, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            if (!world.isClient()) {
                if (BountifulFares.CONFIG.isFruitReplaceWhenPicked()) {
                    BlockState blockState = state.with(AGE, 0);
                    world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
                } else {
                    world.removeBlock(pos, false);
                }
            }
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(BFItems.ORANGE);
    }
}
