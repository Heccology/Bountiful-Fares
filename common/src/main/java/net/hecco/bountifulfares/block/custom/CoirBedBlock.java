package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.CoirBedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class CoirBedBlock extends BedBlock {
    public CoirBedBlock(Properties settings) {
        super(DyeColor.BROWN, settings);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CoirBedBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        BlockState state1 = state;
        BlockPos pos1 = pos;
        if (world.isClientSide) {
            return InteractionResult.CONSUME;
        } else {
            if (state.getValue(PART) != BedPart.HEAD) {
                pos = pos.relative(state.getValue(FACING));
                state = world.getBlockState(pos);
                if (!state.is(this)) {
                    return InteractionResult.CONSUME;
                }
            }

            if (!canSetSpawn(world)) {
                world.removeBlock(pos, false);
                BlockPos blockPos = pos.relative(state.getValue(FACING).getOpposite());
                if (world.getBlockState(blockPos).is(this)) {
                    world.removeBlock(blockPos, false);
                }

                Vec3 vec3d = pos.getCenter();
                world.explode(null, world.damageSources().badRespawnPointExplosion(vec3d), null, vec3d, 5.0F, true, Level.ExplosionInteraction.BLOCK);
                return InteractionResult.SUCCESS;
            } else if (state.getValue(OCCUPIED)) {
                return super.useWithoutItem(state1, world, pos1, player, hit);
            } else {
                player.startSleepInBed(pos).ifLeft((reason) -> {
                    if (reason.getMessage() != null) {
                        player.displayClientMessage(reason.getMessage(), true);
                    }

                });
                return InteractionResult.SUCCESS;
            }
        }
    }
}
