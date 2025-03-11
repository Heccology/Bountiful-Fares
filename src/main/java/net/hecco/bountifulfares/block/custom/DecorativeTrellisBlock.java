package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.registry.content.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import static net.hecco.bountifulfares.registry.content.BFBlocks.DECORATIVE_TRELLISES_TO_PLANTS;
import static net.hecco.bountifulfares.registry.content.BFBlocks.PLANTS_TO_DECORATIVE_TRELLISES;

public class DecorativeTrellisBlock extends TrellisBlock implements Fertilizable {
    private final boolean canDuplicate;

    public TrellisVariant variant;
    public DecorativeVine vine;
    public DecorativeTrellisBlock(boolean canDuplicate, Item item, TrellisVariant variant, DecorativeVine vine, Settings settings) {
        super(variant, settings);
        this.canDuplicate = canDuplicate;
        PLANTS_TO_DECORATIVE_TRELLISES.put(item, this);
        DECORATIVE_TRELLISES_TO_PLANTS.put(this, item);
        this.variant = variant;
        this.vine = vine;
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        Direction facing = state.get(FACING);
        if (player.getStackInHand(player.getActiveHand()).isOf(Items.SHEARS)) {
            player.getStackInHand(player.getActiveHand()).damage(1, player, LivingEntity.getSlotForHand(player.getActiveHand()));
            world.setBlockState(pos, TrellisUtil.getTrellisFromVariant(variant).getDefaultState().with(FACING, facing), 2);
            dropStack(world, pos, new ItemStack(DECORATIVE_TRELLISES_TO_PLANTS.get(this)));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        dropStack((World) world, pos, new ItemStack(vine.getPlantItem()));
        super.onBroken(world, pos, state);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(TrellisUtil.getTrellisFromVariant(variant));
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
        if (item != null && PLANTS_TO_DECORATIVE_TRELLISES.containsKey(item)) {
            return (PLANTS_TO_DECORATIVE_TRELLISES.get(item)).getDefaultState();
        } else {
            return BFTrellises.TRELLISES.get("trellis").getDefaultState();
        }
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
