package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
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

public class HangingWitheredGoldenAppleBlock extends PlantBlock {

    public static final IntProperty AGE = Properties.AGE_5;

    private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.createCuboidShape(7, 13, 7, 9, 16, 9),
            Block.createCuboidShape(6, 13, 6, 10, 16, 10),
            Block.createCuboidShape(6.5, 13, 6.5, 9.5, 16, 9.5),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5.5, 10, 5.5, 10.5, 15, 10.5), Block.createCuboidShape(7, 15, 7, 9, 16, 9), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 8, 5, 11, 14, 11), Block.createCuboidShape(7, 14, 7, 9, 16, 9), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 8, 5, 11, 14, 11), Block.createCuboidShape(7, 14, 7, 9, 16, 9), BooleanBiFunction.OR)
    };
    private static final VoxelShape[] COLL_SHAPES = new VoxelShape[]{VoxelShapes.empty(),
            VoxelShapes.empty(),
            Block.createCuboidShape(6.5, 13, 6.5, 9.5, 16, 9.5),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5.5, 10, 5.5, 10.5, 15, 10.5), Block.createCuboidShape(7, 15, 7, 9, 16, 9), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 8, 5, 11, 14, 11), Block.createCuboidShape(7, 14, 7, 9, 16, 9), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5, 8, 5, 11, 14, 11), Block.createCuboidShape(7, 14, 7, 9, 16, 9), BooleanBiFunction.OR)
    };

    public HangingWitheredGoldenAppleBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape voxelShape = SHAPES[state.get(AGE)];
        if (!BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID) && !BountifulFares.isModLoaded(BountifulFares.ETCETERA_MOD_ID)) {
            Vec3d vec3d = state.getModelOffset(world, pos);
            return voxelShape.offset(vec3d.x, vec3d.y, vec3d.z);
        }
        return voxelShape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape voxelShape = COLL_SHAPES[state.get(AGE)];
        if (!BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID) && !BountifulFares.isModLoaded(BountifulFares.ETCETERA_MOD_ID)) {
            Vec3d vec3d = state.getModelOffset(world, pos);
            return voxelShape.offset(vec3d.x, vec3d.y, vec3d.z);
        }
        return voxelShape;
    }

    @Override
    public float getMaxHorizontalModelOffset() {
        if (BountifulFares.isModLoaded(BountifulFares.TWIGS_MOD_ID) || BountifulFares.isModLoaded(BountifulFares.ETCETERA_MOD_ID)) {
            return 0;
        }
        return super.getMaxHorizontalModelOffset();
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.up(), Direction.DOWN) && !world.isWater(pos)
                || world.getBlockState(pos.up()).isOf(BFBlocks.GOLDEN_APPLE_LEAVES) && !world.isWater(pos)
                || world.getBlockState(pos.up()).isOf(BFBlocks.FLOWERING_GOLDEN_APPLE_LEAVES) && !world.isWater(pos);
    }

    private static boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 5;
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (isFullyGrown(state)) {
            world.breakBlock(hit.getBlockPos(), true);
        }
        super.onProjectileHit(world, state, hit, projectile);
    }
}
