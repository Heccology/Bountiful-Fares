package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GoldenAppleBlock extends FruitBlock {

    private static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(8, 0, 0, 16, 16, 16), Block.createCuboidShape(0, 0, 8, 8, 16, 16), BooleanBiFunction.OR),
            Block.createCuboidShape(0, 0, 8, 16, 16, 16),
            Block.createCuboidShape(0, 0, 8, 8, 16, 16)
    };
    private static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 8, 16, 16, 16), Block.createCuboidShape(0, 0, 0, 8, 16, 8), BooleanBiFunction.OR),
            Block.createCuboidShape(0, 0, 0, 8, 16, 16),
            Block.createCuboidShape(0, 0, 0, 8, 16, 8)
    };
    private static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 8, 16, 16), Block.createCuboidShape(8, 0, 0, 16, 16, 8), BooleanBiFunction.OR),
            Block.createCuboidShape(0, 0, 0, 16, 16, 8),
            Block.createCuboidShape(8, 0, 0, 16, 16, 8)
    };
    private static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 16, 16, 8), Block.createCuboidShape(8, 0, 8, 16, 16, 16), BooleanBiFunction.OR),
            Block.createCuboidShape(8, 0, 0, 16, 16, 16),
            Block.createCuboidShape(8, 0, 8, 16, 16, 16)
    };

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(SLICES) != 0) {
            if (state.get(FACING) == Direction.NORTH) {
                return NORTH_SHAPES[state.get(SLICES) - 1];
            } else if (state.get(FACING) == Direction.EAST) {
                return EAST_SHAPES[state.get(SLICES) - 1];
            } else if (state.get(FACING) == Direction.SOUTH) {
                return SOUTH_SHAPES[state.get(SLICES) - 1];
            } else if (state.get(FACING) == Direction.WEST) {
                return WEST_SHAPES[state.get(SLICES) - 1];
            }
        }
        return super.getOutlineShape(state, world, pos, context);
    }
    public GoldenAppleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (state.get(SLICES) != 3 && player.canConsume(true)) {
            world.setBlockState(pos, state.cycle(SLICES), Block.NOTIFY_LISTENERS);
            if (player.canConsume(false)) {
                player.getHungerManager().add(4, 0.1f);
            }
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0));
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        } else if (state.get(SLICES) == 3 && player.canConsume(true)) {
            world.removeBlock(pos, false);
            if (player.canConsume(false)) {
                player.getHungerManager().add(4, 0.1f);
            }
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0));
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public Item getFruitItem() {
        return Items.GOLDEN_APPLE;
    }
}
