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
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.*;
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
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        Direction facing = state.get(FACING);
        if (stack.isOf(Items.SHEARS)) {
            stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            world.setBlockState(pos, TrellisUtil.getTrellisFromVariant(variant).getDefaultState().with(FACING, facing), 2);
            dropStack(world, pos, new ItemStack(DECORATIVE_TRELLISES_TO_PLANTS.get(this)));
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return ItemActionResult.SUCCESS;
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
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

    //Hey Hecco i have noticed that you have like 20-22 lang files for the same translation of trellises
    //You can use this method to make these hundreds of lang lines redundant
    //P.S. i tested this with WTHIT and it works
    //if you accept this, this will allow to remove like 500 lines from every lang file
    //they are so annoying to translate through "find and replace"
    @Override
    public String getTranslationKey() {
        return "block." + variant.getModId() + "." + variant.getBlockName();
    }
}
