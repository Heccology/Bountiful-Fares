package net.hecco.bountifulfares.definition.block.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.definition.block.interfaces.CeramicDishBlockInterface;
import net.hecco.bountifulfares.definition.item.custom.StackableBowlFoodItem;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CeramicDishBlock extends Block implements EntityBlock, SimpleWaterloggedBlock, CeramicDishBlockInterface {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public CeramicDishBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        if (CeramicDishBlockEntity.getColor(world, pos) != CeramicDishBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getCloneItemStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(BFBlocks.CERAMIC_DISH.get());
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(3, 0, 3, 13, 1, 13);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity blockEntity) {
            ItemStack stackEntity = blockEntity.getItem(0);
            ItemInteractionResult BRUSH_PASS = DyeableCeramicBlock.onUseForDish(stack, state, world, pos, player, hand, state.getBlock(), blockEntity);

            if (BRUSH_PASS.consumesAction())
            {
                return BRUSH_PASS;
            }
            else if (!stack.isEmpty() && blockEntity.canInsertItem()) {
                blockEntity.insertItem(stack);
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                world.playLocalSound(pos, BFSounds.CERAMIC_DISH_INTERACT.get(), SoundSource.PLAYERS, 1.0f, 0.8f + world.random.nextFloat() / 4, true);
                blockEntity.setChanged();
                return ItemInteractionResult.SUCCESS;
            }
            else if (!stackEntity.isEmpty()) {
                if (player.isShiftKeyDown() && stack.isEmpty()) {
                    player.setItemInHand(hand, stackEntity);
                    blockEntity.removeItem();
                    world.playLocalSound(pos, BFSounds.CERAMIC_DISH_INTERACT.get(), SoundSource.PLAYERS, 1.0f, 0.8f + world.random.nextFloat() / 4, true);
                    blockEntity.setChanged();
                    return ItemInteractionResult.SUCCESS;
                }
                else if (canEatOnDish(stackEntity)) {
                    FoodProperties check = stackEntity.getComponents().get(DataComponents.FOOD);
                    boolean shouldIgnore = check != null && check.canAlwaysEat();
                    if (player.canEat(shouldIgnore)) {
                        world.playSound(null, pos, SoundEvents.PLAYER_BURP, SoundSource.BLOCKS, 0.3f, 1.0f);

                        for (int i = 0; i < 4 + world.random.nextIntBetweenInclusive(0, 4); i++) {
                            world.addParticle(new ItemParticleOption(
                                    ParticleTypes.ITEM, stackEntity),
                                    pos.getX() + world.random.nextGaussian() / 12 + 0.5,
                                    pos.getY() + 0.2,
                                    pos.getZ() + world.random.nextGaussian() / 12 + 0.5,
                                    (world.random.nextFloat() - 0.5) / 8,
                                    (world.random.nextFloat() - 0.5) / 8,
                                    (world.random.nextFloat() - 0.5) / 8);
                        }

                        if (check != null && check.usingConvertsTo().isPresent()) {
                            Item item = check.usingConvertsTo().get().getItem();
                            ItemEntity itementity = new ItemEntity(world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, new ItemStack(item));
                            itementity.setDeltaMovement(0.0, 0.2, 0.0);
                            world.addFreshEntity(itementity);
                        }
                        /*
                            NOTE ABOUT `!(stackEntity.getItem() instanceof StackableBowlFoodItem)`:
                                You should probably make the food data component actually just return a bowl.
                                If you do that, remove the check for StackableBowlFoodItemm
                                - Artyrian
                        */
                        else if (stackEntity.getItem().hasCraftingRemainingItem() && !(stackEntity.getItem() instanceof StackableBowlFoodItem)) {
                            ItemEntity itementity = new ItemEntity(world, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, new ItemStack(stackEntity.getItem().getCraftingRemainingItem()));
                            itementity.setDeltaMovement(0.0, 0.2, 0.0);
                            world.addFreshEntity(itementity);
                        }

                        stackEntity.getItem().finishUsingItem(stackEntity, world, player);

                        blockEntity.removeItem();
                        blockEntity.setChanged();
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    public static boolean canEatOnDish(ItemStack stack) {
        if (stack.getComponents().get(DataComponents.FOOD) != null) {
            Item item = stack.getItem();
            boolean eatOnDishEnabled = BountifulFares.CONFIG.isContainerFoodsEatableOnDish();
            boolean hasRemainder = stack.getItem().hasCraftingRemainingItem();
            boolean hasFoodTransform = (stack.getComponents().get(DataComponents.FOOD).usingConvertsTo().isPresent());

            if (!eatOnDishEnabled && (hasRemainder || hasFoodTransform)) { return false; }
            else if (stack.is(Items.PUMPKIN_PIE) && BountifulFares.CONFIG.enablePlaceablePumpkinPie) { return false; }
            else if (!stack.is(BFItemTags.CERAMIC_DISH_BLACKLIST)) { return true; }
        }
        return false;

        // old code prior to this - artyrian
        //if (stack.getComponents().get(DataComponents.FOOD) != null) {
        //    if (BountifulFares.CONFIG.isContainerFoodsEatableOnDish()) {
        //        return true;
        //    } else if (!stack.getItem().hasCraftingRemainingItem()) {
        //        return true;
        //    }
        //}
        //return false;
    }


    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CeramicDishBlockEntity entity) {
                popResource(world, pos, entity.getItem(0));
                world.updateNeighbourForOutputSignal(pos,this);
            }
            super.onRemove(state, world, pos, newState, moved);
        }
    }

    public boolean isPossibleToRespawnInThis(BlockState state) {
        return true;
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        return canSupportRigidBlock(world, blockPos) || canSupportCenter(world, blockPos, Direction.UP);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CeramicDishBlockEntity(pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        boolean bl = fluidState.getType() == Fluids.WATER;
        return super.getStateForPlacement(ctx).setValue(WATERLOGGED, bl).setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return direction == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }

    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        if (level.getBlockEntity(pos) instanceof CeramicDishBlockEntity blockEntity) {
            ItemStack dishItem = blockEntity.getItem(0);

            if (!dishItem.isEmpty()) {
                if (dishItem.has(DataComponents.FOOD) && canEatOnDish(dishItem)) {
                    int MAX_COMP = 15;
                    float amnt = ((float)dishItem.get(DataComponents.FOOD).nutrition() / 20.0F);
                    return Math.clamp(Math.round(MAX_COMP * amnt), 1, MAX_COMP);
                }
                else return 1;
            }
            else return 0;
        }
        else return 0;
    }

    public void chorusTeleport(Level world, LivingEntity user) {
        if (!world.isClientSide) {
            double d = user.getX();
            double e = user.getY();
            double f = user.getZ();

            for(int i = 0; i < 16; ++i) {
                double g = user.getX() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                double h = Mth.clamp(user.getY() + (double)(user.getRandom().nextInt(16) - 8), (double)world.getMinBuildHeight(), (double)(world.getMinBuildHeight() + ((ServerLevel)world).getLogicalHeight() - 1));
                double j = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                if (user.isPassenger()) {
                    user.stopRiding();
                }

                Vec3 vec3d = user.position();
                if (user.randomTeleport(g, h, j, true)) {
                    world.gameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Context.of(user));
                    SoundEvent soundEvent = user instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                    world.playSound((Player)null, d, e, f, soundEvent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    user.playSound(soundEvent, 1.0F, 1.0F);
                    break;
                }
            }
        }
    }
}
