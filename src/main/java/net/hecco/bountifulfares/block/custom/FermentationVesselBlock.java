package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.ModBlockEntities;
import net.hecco.bountifulfares.block.enums.FermentationStage;
import net.hecco.bountifulfares.particle.ModParticles;
import net.hecco.bountifulfares.util.FermentationRecipes;
import net.hecco.bountifulfares.block.entity.FermentationVesselBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class FermentationVesselBlock extends BlockWithEntity implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final EnumProperty<FermentationStage> FERMENTATION_STAGE = EnumProperty.of("fermentation_stage", FermentationStage.class);

    public FermentationVesselBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FERMENTATION_STAGE, FermentationStage.EMPTY).with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FERMENTATION_STAGE, WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(FERMENTATION_STAGE) == FermentationStage.FERMENTING || state.get(FERMENTATION_STAGE) == FermentationStage.FERMENTED) {
            return Stream.of(
                    Block.createCuboidShape(4, 14, 4, 12, 16, 12),
                    Block.createCuboidShape(2, 0, 2, 14, 13, 14),
                    Block.createCuboidShape(5, 13, 5, 11, 14, 11)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
        } else {
            return VoxelShapes.combineAndSimplify(
                    Block.createCuboidShape(2, 0, 2, 14, 13, 14),
                    Block.createCuboidShape(5, 13, 5, 11, 15, 11),
                    BooleanBiFunction.OR
            );
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.POTION) && PotionUtil.getPotion(itemStack) == Potions.WATER && state.get(FERMENTATION_STAGE) == FermentationStage.EMPTY) {
            world.setBlockState(pos, state.with(FERMENTATION_STAGE, FermentationStage.WATER), 2);
            world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 0.8F);
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            if (itemStack.isEmpty() && !player.isCreative()) {
                player.setStackInHand(hand, new ItemStack(Items.GLASS_BOTTLE));
            } else if (!player.getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE))) {
                player.dropItem(new ItemStack(Items.GLASS_BOTTLE), false);
            }
            return ActionResult.SUCCESS;

        } else if (world.getBlockEntity(pos) instanceof FermentationVesselBlockEntity entity) {
            if (FermentationRecipes.isItemInput(player, hand) && state.get(FERMENTATION_STAGE) == FermentationStage.WATER) {
                if (entity.canInsertItem()) {
                    entity.insertItem(itemStack.getItem().getDefaultStack());
                    world.setBlockState(pos, state.with(FERMENTATION_STAGE, FermentationStage.FERMENTING));
                    pushEntitiesUpBeforeBlockChange(state.with(FERMENTATION_STAGE, FermentationStage.WATER), state.with(FERMENTATION_STAGE, FermentationStage.FERMENTING), world, pos);
                    if (!player.isCreative()) {
                        itemStack.decrement(1);
                    }
                    Item remainder = FermentationRecipes.getRemainderFromInput(player.getStackInHand(hand).getItem());
                    if (remainder != null) {
                        if (itemStack.isEmpty() && !player.isCreative()) {
                            player.setStackInHand(hand, new ItemStack(remainder));
                        } else if (!player.getInventory().insertStack(new ItemStack(remainder))) {
                            player.dropItem(new ItemStack(remainder), false);
                        }
                    }
                    world.playSound(null, pos, SoundEvents.ENTITY_AXOLOTL_SPLASH, SoundCategory.BLOCKS, 1.0F, 0.8F);
                    return ActionResult.SUCCESS;
                }
            } else if (!entity.canInsertItem()) {
                return entity.tryExtractItem(world, pos, state, player, hand);
            }
            return ActionResult.PASS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;
        return super.getPlacementState(ctx).with(WATERLOGGED, bl);
    }


    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FermentationVesselBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.FERMENTATION_VESSEL_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }

//    @Override
//    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
//        world.addParticle(ModParticles.FERMENTATION_BUBBLE_PARTICLE, pos.getX()+0.25 + (random.nextFloat()/2), pos.getY()+0.85, pos.getZ()+0.25 + (random.nextFloat()/2), 0.0, 0.0, 0.0);
//        super.randomDisplayTick(state, world, pos, random);
//    }
}
