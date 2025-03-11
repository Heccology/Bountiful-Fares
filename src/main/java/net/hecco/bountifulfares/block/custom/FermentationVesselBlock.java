package net.hecco.bountifulfares.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.FermentationVesselBlockEntity;
import net.hecco.bountifulfares.block.enums.FermentationStage;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class FermentationVesselBlock extends BlockWithEntity implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final EnumProperty<FermentationStage> FERMENTATION_STAGE = EnumProperty.of("fermentation_stage", FermentationStage.class);

    public FermentationVesselBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FERMENTATION_STAGE, FermentationStage.EMPTY).with(WATERLOGGED, false));
    }
    public static final MapCodec<FermentationVesselBlock> CODEC = FermentationVesselBlock.createCodec(FermentationVesselBlock::new);
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
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

    public Optional<RecipeEntry<FermentationRecipe>> getCurrentRecipe(World world, ItemStack input) {
        return Objects.requireNonNull(world).getRecipeManager().getFirstMatch(BFRecipes.FERMENTING, new SingleStackRecipeInput(input), world);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        if (itemStack.isOf(PotionContentsComponent.createStack(Items.POTION, Potions.WATER).getItem()) && state.get(FERMENTATION_STAGE) == FermentationStage.EMPTY) {
            world.setBlockState(pos, state.with(FERMENTATION_STAGE, FermentationStage.WATER), 2);
            world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_FILL, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat()/3);
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            if (itemStack.isEmpty() && !player.isCreative()) {
                player.setStackInHand(player.getActiveHand(), new ItemStack(Items.GLASS_BOTTLE));
            } else if (!player.getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE))) {
                player.dropItem(new ItemStack(Items.GLASS_BOTTLE), false);
            }
            return ActionResult.SUCCESS;

        } else if (itemStack.isOf(Items.WATER_BUCKET) && state.get(FERMENTATION_STAGE) == FermentationStage.EMPTY) {
            world.setBlockState(pos, state.with(FERMENTATION_STAGE, FermentationStage.WATER), 2);
            world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat()/3);
            world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_FILL, SoundCategory.BLOCKS, 0.7F, 0.8F + world.random.nextFloat()/3);
            if (!player.isCreative()) {
                itemStack.decrement(1);
            }
            if (itemStack.isEmpty() && !player.isCreative()) {
                player.setStackInHand(player.getActiveHand(), new ItemStack(Items.BUCKET));
            } else if (!player.getInventory().insertStack(new ItemStack(Items.BUCKET))) {
                player.dropItem(new ItemStack(Items.BUCKET), false);
            }
            return ActionResult.SUCCESS;

        } else if (world.getBlockEntity(pos) instanceof FermentationVesselBlockEntity entity) {
            if (getCurrentRecipe(world, itemStack).isPresent() && state.get(FERMENTATION_STAGE) == FermentationStage.WATER) {
                if (entity.canInsertItem()) {
                    entity.insertItem(itemStack.getItem().getDefaultStack());
                    world.setBlockState(pos, state.with(FERMENTATION_STAGE, FermentationStage.FERMENTING));
                    pushEntitiesUpBeforeBlockChange(state.with(FERMENTATION_STAGE, FermentationStage.WATER), state.with(FERMENTATION_STAGE, FermentationStage.FERMENTING), world, pos);
                    Item remainder = getCurrentRecipe(world, itemStack).get().value().getIngredient().getMatchingStacks()[0].getItem().getRecipeRemainder();
                    if (!player.isCreative()) {
                        itemStack.decrement(1);
                    }
                    if (remainder != null) {
                        if (itemStack.isEmpty() && !player.isCreative()) {
                            player.setStackInHand(player.getActiveHand(), new ItemStack(remainder));
                        } else if (!player.getInventory().insertStack(new ItemStack(remainder))) {
                            player.dropItem(new ItemStack(remainder), false);
                        }
                    }
                    world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_SPLASH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat()/3);
                    entity.setParticleColor(getCurrentRecipe(world, itemStack).get().value().getParticleColor());
                    return ActionResult.SUCCESS;
                }
            } else if (!entity.canInsertItem()) {
                return entity.tryExtractItem(world, pos, state, player, player.getActiveHand());
            }
            return ActionResult.PASS;
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (world.getBlockEntity(pos) instanceof FermentationVesselBlockEntity entity) {
            if (BountifulFares.CONFIG.isFermentationBubbleParticles() && state.get(FermentationVesselBlock.FERMENTATION_STAGE) == FermentationStage.FERMENTING && entity.getParticleColor().isPresent()) {
                Vector3f color = Vec3d.unpackRgb(entity.getParticleColor().orElse(16777215)).toVector3f();
                for (int i = 0; i < random.nextBetween(1, 3); i++) {
                    world.addParticle(BFParticles.FERMENTED_BUBBLE, pos.getX() + 0.20 + (world.random.nextFloat() * 0.6), pos.getY() + 0.85, pos.getZ() + 0.20 + (world.random.nextFloat() * 0.6), color.x, color.y, color.z);
                }
            }
        }
        super.randomDisplayTick(state, world, pos, random);
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
        return validateTicker(type, BFBlockEntities.FERMENTATION_VESSEL_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
