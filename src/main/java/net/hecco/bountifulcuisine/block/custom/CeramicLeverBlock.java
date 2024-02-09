package net.hecco.bountifulcuisine.block.custom;

import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.block.entity.CeramicTilesBlockEntity;
import net.hecco.bountifulcuisine.block.interfaces.DyeableCeramicBlockInterface;
import net.hecco.bountifulcuisine.item.ModItems;
import net.hecco.bountifulcuisine.item.custom.ArtisanBrushItem;
import net.hecco.bountifulcuisine.sounds.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

public class CeramicLeverBlock extends LeverBlock implements DyeableCeramicBlockInterface {

    public CeramicLeverBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(ModItems.ARTISAN_BRUSH) && itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY) != null) {
            int brushColor = itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY);
            world.removeBlock(pos, false);
            world.setBlockState(pos, this.getStateWithProperties(state));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof CeramicTilesBlockEntity ceramicTilesBlockEntity && ceramicTilesBlockEntity.color != brushColor) {
                ceramicTilesBlockEntity.color = brushColor;
                ceramicTilesBlockEntity.markDirty();
                return ActionResult.SUCCESS;

            }
        }
        BlockState blockState;
        if (world.isClient) {
            blockState = state.cycle(POWERED);
            if (blockState.get(POWERED)) {
                spawnParticles(blockState, world, pos, 1.0F);
            }

            return ActionResult.SUCCESS;
        } else {
            blockState = this.togglePower(state, world, pos);
            SoundEvent f = blockState.get(POWERED) ? ModSounds.CERAMIC_LEVER_ON : ModSounds.CERAMIC_LEVER_OFF;
            world.playSound(null, pos, f, SoundCategory.BLOCKS, 0.8F, 1);
            world.emitGameEvent(player, blockState.get(POWERED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
            return ActionResult.CONSUME;
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACE)) {
            case FLOOR:
                return Block.createCuboidShape(4, 0, 4, 12, 2, 12);
            case WALL:
                switch (state.get(FACING)) {
                    case EAST:
                        return Block.createCuboidShape(0, 4, 4, 2, 12, 12);
                    case WEST:
                        return Block.createCuboidShape(14, 4, 4, 16, 12, 12);
                    case SOUTH:
                        return Block.createCuboidShape(4, 4, 0, 12, 12, 2);
                    case NORTH:
                    default:
                        return Block.createCuboidShape(4, 4, 14, 12, 12, 16);
                }
            case CEILING:
            default:
                return Block.createCuboidShape(4, 14, 4, 12, 16, 12);
        }
    }

    private static void spawnParticles(BlockState state, WorldAccess world, BlockPos pos, float alpha) {
        Direction direction = (state.get(FACING)).getOpposite();
        Direction direction2 = getDirection(state).getOpposite();
        double d = (double)pos.getX() + 0.5 + 0.1 * (double)direction.getOffsetX() + 0.2 * (double)direction2.getOffsetX();
        double e = (double)pos.getY() + 0.5 + 0.1 * (double)direction.getOffsetY() + 0.2 * (double)direction2.getOffsetY();
        double f = (double)pos.getZ() + 0.5 + 0.1 * (double)direction.getOffsetZ() + 0.2 * (double)direction2.getOffsetZ();
        world.addParticle(new DustParticleEffect(DustParticleEffect.RED, alpha), d, e, f, 0.0, 0.0, 0.0);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        if (CeramicTilesBlockEntity.getColor(world, pos) != CeramicTilesBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getPickStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(ModBlocks.CERAMIC_LEVER);
        }
    }
}
