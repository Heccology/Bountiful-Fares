package net.hecco.bountifulfares.definition.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.CeramicFlowerPotBlockEntity;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_DISH_BLOCK_ENTITY;
import static net.hecco.bountifulfares.registry.content.BFBlockEntities.CERAMIC_FLOWER_POT_BLOCK_ENTITY;

public class CeramicFlowerPotBlock extends BaseEntityBlock {

    public static Map<Block, Block> POTTED_PLANTS = new HashMap<>();

    public CeramicFlowerPotBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.join(Block.box(5, 0, 5, 11, 6, 11), Block.box(4, 6, 4, 12, 8, 12), BooleanOp.OR);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof CeramicFlowerPotBlockEntity pot && pot.getPlant().getItem() instanceof BlockItem bli) {
            Block bl1 = POTTED_PLANTS.get(bli.getBlock());
            if (bl1 != null) bl1.animateTick(state, level, pos, random);
        }
    }

    public static void getAllPottedPlants() {
        Map<Block, Block> map = new HashMap<>();
        for (Block block : BuiltInRegistries.BLOCK) {
            if (block instanceof FlowerPotBlock pot && pot.getPotted() != Blocks.AIR) {
                map.put(pot.getPotted(), pot);
            }
        }
        POTTED_PLANTS = map;
    }

    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CeramicFlowerPotBlockEntity entity) {

            ItemInteractionResult BRUSH_PASS = DyeableCeramicBlock.onUseForFlowerPot(stack, state, level, pos, player, hand, state.getBlock(), entity);

            if (BRUSH_PASS.consumesAction())
            {
                return BRUSH_PASS;
            }

            if (POTTED_PLANTS.isEmpty()) {
                getAllPottedPlants();
            }
            Item item = stack.getItem();
            if (item instanceof BlockItem blockItem) {
                if (POTTED_PLANTS.containsKey(blockItem.getBlock())) {
                    if (entity.getPlant().isEmpty()) {
                        entity.setPlant(item.getDefaultInstance());
                        stack.consumeAndReturn(1, player);
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CeramicFlowerPotBlockEntity entity && !entity.getPlant().isEmpty()) {
            if (!player.addItem(entity.getPlant())) {
                player.drop(entity.getPlant(), false);
            }
            entity.setPlant(ItemStack.EMPTY);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        if (level.getBlockEntity(pos) instanceof CeramicFlowerPotBlockEntity entity && !entity.getPlant().isEmpty()) {
            return entity.getPlant();
        }
        if (CeramicFlowerPotBlockEntity.getColor(level, pos) != CeramicFlowerPotBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getCloneItemStack(level, pos, state);
            CeramicFlowerPotBlockEntity blockEntity = CERAMIC_FLOWER_POT_BLOCK_ENTITY.get().getBlockEntity(level, pos);
            int color;
            if(blockEntity != null){
                color = blockEntity.color;
            } else {
                color = CeramicFlowerPotBlockEntity.DEFAULT_COLOR;
            }
            stack.set(DataComponents.DYED_COLOR, new DyedItemColor(color, true));
            return stack;
        } else {
            return new ItemStack(BFBlocks.CERAMIC_FLOWER_POT.get());
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        if (blockEntity instanceof CeramicFlowerPotBlockEntity entity && !entity.getPlant().isEmpty()) {
            popResource(level, pos, entity.getPlant());
        }
    }

    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !state.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CeramicFlowerPotBlockEntity(blockPos, blockState);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(CeramicFlowerPotBlock::new);
    }
}
