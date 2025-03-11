package net.hecco.bountifulfares.block.custom;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CeramicButtonBlock extends ButtonBlock implements BlockEntityProvider {
    public CeramicButtonBlock(Settings settings, BlockSetType blockSetType, int pressTicks, boolean wooden) {
        super(blockSetType, pressTicks, settings);
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
            if (state.get(POWERED)) {
                return ActionResult.CONSUME;
            } else {
                this.powerOn(state, world, pos, player);
                return ActionResult.success(world.isClient);
            }
        }
        return ActionResult.PASS;
    }
}
