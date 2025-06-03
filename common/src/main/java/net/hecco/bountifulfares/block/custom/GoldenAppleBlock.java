package net.hecco.bountifulfares.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GoldenAppleBlock extends FruitBlock {

    private static final VoxelShape[] NORTH_SHAPES = new VoxelShape[] {
            Shapes.join(Block.box(8, 0, 0, 16, 16, 16), Block.box(0, 0, 8, 8, 16, 16), BooleanOp.OR),
            Block.box(0, 0, 8, 16, 16, 16),
            Block.box(0, 0, 8, 8, 16, 16)
    };
    private static final VoxelShape[] EAST_SHAPES = new VoxelShape[] {
            Shapes.join(Block.box(0, 0, 8, 16, 16, 16), Block.box(0, 0, 0, 8, 16, 8), BooleanOp.OR),
            Block.box(0, 0, 0, 8, 16, 16),
            Block.box(0, 0, 0, 8, 16, 8)
    };
    private static final VoxelShape[] SOUTH_SHAPES = new VoxelShape[] {
            Shapes.join(Block.box(0, 0, 0, 8, 16, 16), Block.box(8, 0, 0, 16, 16, 8), BooleanOp.OR),
            Block.box(0, 0, 0, 16, 16, 8),
            Block.box(8, 0, 0, 16, 16, 8)
    };
    private static final VoxelShape[] WEST_SHAPES = new VoxelShape[] {
            Shapes.join(Block.box(0, 0, 0, 16, 16, 8), Block.box(8, 0, 8, 16, 16, 16), BooleanOp.OR),
            Block.box(8, 0, 0, 16, 16, 16),
            Block.box(8, 0, 8, 16, 16, 16)
    };

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(SLICES) != 0) {
            if (state.getValue(FACING) == Direction.NORTH) {
                return NORTH_SHAPES[state.getValue(SLICES) - 1];
            } else if (state.getValue(FACING) == Direction.EAST) {
                return EAST_SHAPES[state.getValue(SLICES) - 1];
            } else if (state.getValue(FACING) == Direction.SOUTH) {
                return SOUTH_SHAPES[state.getValue(SLICES) - 1];
            } else if (state.getValue(FACING) == Direction.WEST) {
                return WEST_SHAPES[state.getValue(SLICES) - 1];
            }
        }
        return super.getShape(state, world, pos, context);
    }
    public GoldenAppleBlock(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (state.getValue(SLICES) != 3 && player.canEat(true)) {
            world.setBlock(pos, state.cycle(SLICES), Block.UPDATE_CLIENTS);
            if (player.canEat(false)) {
                player.getFoodData().eat(4, 0.1f);
            }
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0));
            world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.SUCCESS;
        } else if (state.getValue(SLICES) == 3 && player.canEat(true)) {
            world.removeBlock(pos, false);
            if (player.canEat(false)) {
                player.getFoodData().eat(4, 0.1f);
            }
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0));
            world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.BLOCKS, 1.0f, 1.0f);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public Item getFruitItem() {
        return Items.GOLDEN_APPLE;
    }
}
