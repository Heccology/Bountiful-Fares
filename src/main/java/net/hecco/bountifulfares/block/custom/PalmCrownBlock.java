package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class PalmCrownBlock extends PillarBlock {
    public PalmCrownBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (player.getStackInHand(player.getActiveHand()).getItem() instanceof BoneMealItem) {
            if (hit.getSide() != Direction.DOWN && hit.getSide() != Direction.UP) {
                if (world.getBlockState(pos.offset(hit.getSide(), 1)).isAir()) {
                    world.setBlockState(pos.offset(hit.getSide(), 1), BFBlocks.COCONUT.getDefaultState().with(Properties.HORIZONTAL_FACING, hit.getSide()));
                    if (!world.isClient) {
                        world.syncWorldEvent(1505, pos, 0);
                    }
                    BoneMealItem.createParticles(world, pos.down(), 2);
                    if (!player.isCreative()) {
                        player.getStackInHand(player.getActiveHand()).decrement(1);
                    }
                    return ActionResult.SUCCESS;
                }
            } else {
                Direction[] DIRECTIONS = new Direction[]{Direction.WEST, Direction.EAST, Direction.NORTH, Direction.SOUTH};
                for (Direction direction : DIRECTIONS) {
                    if (world.getBlockState(pos.offset(direction)).isAir()) {
                        world.setBlockState(pos.offset(direction), BFBlocks.COCONUT.getDefaultState().with(Properties.HORIZONTAL_FACING, direction));
                        if (!world.isClient) {
                            world.syncWorldEvent(1505, pos.down(), 0);
                        }
                        BoneMealItem.createParticles(world, pos.down(), 2);
                        if (!player.isCreative()) {
                            player.getStackInHand(player.getActiveHand()).decrement(1);
                        }
                        return ActionResult.SUCCESS;
                    }
                }
            }
        }
        return super.onUse(state, world, pos, player, hit);
    }
}
