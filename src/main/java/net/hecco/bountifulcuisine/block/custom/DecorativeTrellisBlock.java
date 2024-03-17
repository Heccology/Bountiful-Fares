package net.hecco.bountifulcuisine.block.custom;

import com.google.common.collect.Maps;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Map;

public class DecorativeTrellisBlock extends TrellisBlock implements Fertilizable {
    private final boolean canDuplicate;
    private static final Map<Item, DecorativeTrellisBlock> PLANTS_TO_DECORATIVE_TRELLISES = Maps.newHashMap();
    private static final Map<DecorativeTrellisBlock, Item> DECORATIVE_TRELLISES_TO_PLANTS = Maps.newHashMap();
    public DecorativeTrellisBlock(Item item, boolean canDuplicate, Settings settings) {
        super(settings);
        PLANTS_TO_DECORATIVE_TRELLISES.put(item, this);
        DECORATIVE_TRELLISES_TO_PLANTS.put(this, item);
        this.canDuplicate = canDuplicate;
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Direction facing = state.get(FACING);
        if (player.getStackInHand(hand).isOf(Items.SHEARS)) {
            player.getStackInHand(hand).damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
            world.setBlockState(pos, ModBlocks.TRELLIS.getDefaultState().with(FACING, facing), 2);
            dropStack(world, pos, new ItemStack(DECORATIVE_TRELLISES_TO_PLANTS.get(this)));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModBlocks.TRELLIS);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return canDuplicate;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return canDuplicate;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (canDuplicate) {
            dropStack(world, pos, new ItemStack(DECORATIVE_TRELLISES_TO_PLANTS.get(this)));
        }
    }

    public static BlockState getDecorativeTrellisFromPlant(Item item) {
        return (PLANTS_TO_DECORATIVE_TRELLISES.get(item)).getDefaultState();
    }
}
