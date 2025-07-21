package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.block.custom.NewTrellisBlock;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class TrellisBlockItem extends BlockItem {
    public TrellisBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult place(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace().getOpposite());
        BlockState block = context.getLevel().getBlockState(pos);
        if (block.getBlock() instanceof NewTrellisBlock) {
            Direction facing = block.getValue(BlockStateProperties.HORIZONTAL_FACING);
            if (context.getClickedFace() == facing) {
                Vec3 clickPos = context.getClickLocation().subtract(Vec3.atCenterOf(pos)).add(0.5, 0.5, 0.5);
                Direction placeRelative = facing;
                if (facing.getAxis() == Direction.Axis.X) {
                    if (Math.abs(clickPos.y - 0.5) > Math.abs(clickPos.z - 0.5)) {
                        if (Math.abs(clickPos.y - 0.5) > 0.35) {
                            placeRelative = clickPos.y > 0.5 ? Direction.UP : Direction.DOWN;
                        }
                    } else {
                        if (Math.abs(clickPos.z - 0.5) > 0.35) {
                            placeRelative = clickPos.z > 0.5 ? Direction.SOUTH : Direction.NORTH;
                        }
                    }
                } else {
                    if (Math.abs(clickPos.y - 0.5) > Math.abs(clickPos.x - 0.5)) {
                        if (Math.abs(clickPos.y - 0.5) > 0.35) {
                            placeRelative = clickPos.y > 0.5 ? Direction.UP : Direction.DOWN;
                        }
                    } else {
                        if (Math.abs(clickPos.x - 0.5) > 0.35) {
                            placeRelative = clickPos.x > 0.5 ? Direction.EAST : Direction.WEST;
                        }
                    }
                }
                if (!context.getLevel().getBlockState(context.getClickedPos().relative(context.getClickedFace().getOpposite()).relative(placeRelative)).canBeReplaced() && context.getPlayer().getDirection() == facing) {
                    placeRelative = null;
                }
                return super.place(new BlockPlaceContext(
                        context.getPlayer(), context.getHand(), context.getItemInHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), context.getClickedPos().relative(context.getClickedFace().getOpposite()).relative(placeRelative != null ? placeRelative : Direction.NORTH, placeRelative != null ? 1 : 0), false)
                ));
            }
        }
        return super.place(context);
    }
}
