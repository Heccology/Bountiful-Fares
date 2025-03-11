package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CeramicTrapdoorBlock extends TrapdoorBlock implements BlockEntityProvider {
    private final BlockSetType blockSetType;
    public CeramicTrapdoorBlock(Settings settings, BlockSetType blockSetType) {
        super(blockSetType, settings);
        this.blockSetType = blockSetType;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (DyeableCeramicBlock.onUse(state, world, pos, player, state.getBlock()) == ActionResult.PASS) {
            if (!state.get(POWERED)) {
                if (!this.blockSetType.canOpenByHand()) {
                    return ActionResult.PASS;
                } else {
                    state = state.cycle(OPEN);
                    world.setBlockState(pos, state, 2);
                    if (state.get(WATERLOGGED)) {
                        world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
                    }

                    this.playToggleSound(player, world, pos, state.get(OPEN));
                    return ActionResult.success(world.isClient);
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            boolean bl = world.isReceivingRedstonePower(pos);
            if (bl != state.get(POWERED)) {
                if (!state.get(POWERED)) {
                    state = state.cycle(OPEN);
                    this.playToggleSound(null, world, pos, bl);
                }
                world.setBlockState(pos, state.with(POWERED, bl), 2);
                if (state.get(WATERLOGGED)) {
                    world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
                }
            }

        }
    }
}

