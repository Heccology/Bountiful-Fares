package net.hecco.bountifulfares.definition.block.custom;

import com.mojang.serialization.MapCodec;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.entity.FermentationVesselBlockEntity;
import net.hecco.bountifulfares.definition.block.enums.FermentationStage;
import net.hecco.bountifulfares.definition.platform.Services;
import net.hecco.bountifulfares.definition.recipe.FermentationRecipe;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.registry.content.BFParticles;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
import net.hecco.bountifulfares.registry.tags.BFItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class FermentationVesselBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<FermentationStage> FERMENTATION_STAGE = EnumProperty.create("fermentation_stage", FermentationStage.class);

    public FermentationVesselBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FERMENTATION_STAGE, FermentationStage.EMPTY).setValue(WATERLOGGED, false));
    }
    public static final MapCodec<FermentationVesselBlock> CODEC = FermentationVesselBlock.simpleCodec(FermentationVesselBlock::new);
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FERMENTATION_STAGE, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(FERMENTATION_STAGE) == FermentationStage.FERMENTING || state.getValue(FERMENTATION_STAGE) == FermentationStage.FERMENTED) {
            return Stream.of(
                    Block.box(4, 14, 4, 12, 16, 12),
                    Block.box(2, 0, 2, 14, 13, 14),
                    Block.box(5, 13, 5, 11, 14, 11)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        } else {
            return Shapes.join(
                    Block.box(2, 0, 2, 14, 13, 14),
                    Block.box(5, 13, 5, 11, 15, 11),
                    BooleanOp.OR
            );
        }
    }

    public Optional<RecipeHolder<FermentationRecipe>> getCurrentRecipe(Level world, ItemStack input) {
        Optional<RecipeHolder<FermentationRecipe>> recipe = Objects.requireNonNull(world).getRecipeManager().getRecipeFor(BFRecipes.FERMENTING.get(), new SingleRecipeInput(input), world);
        return recipe.isEmpty() ? Optional.empty() : recipe;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (state.getValue(FERMENTATION_STAGE) == FermentationStage.EMPTY && stack.is(BFItemTags.FERMENTATION_WATER_SOURCES)) {
            Item item = (stack.getItem().hasCraftingRemainingItem()) ? stack.getItem().getCraftingRemainingItem() : null;
            boolean validSource = true;
            boolean playSplash = false;

            // who cares if it's hardcoded blehhhhh
            if (stack.is(Items.WATER_BUCKET)) {
                playSplash = true;
                item = Items.BUCKET;
            }
            else if (stack.is(Items.POTION)) {
                PotionContents potioncontents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
                validSource = potioncontents.is(Potions.WATER);
                item = Items.GLASS_BOTTLE;
            }
            else if (stack.is(BFItems.WATER_CUP.get())) {
                item = BFItems.CUP.get();
            }

            if (validSource) {
                world.setBlock(pos, state.setValue(FERMENTATION_STAGE, FermentationStage.WATER), 3);

                if (playSplash) world.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat()/3);
                world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_FILL.get(), SoundSource.BLOCKS, 0.7F, 0.8F + world.random.nextFloat()/3);

                if (!player.isCreative()) { stack.shrink(1); }

                if (item != null) {
                    if (stack.isEmpty() && !player.isCreative()) { player.setItemInHand(hand, new ItemStack(item)); }
                    else if (!player.getInventory().add(new ItemStack(item))) { player.drop(new ItemStack(item), false); }
                }

                return ItemInteractionResult.SUCCESS;
            }
        } else if (world.getBlockEntity(pos) instanceof FermentationVesselBlockEntity entity) {
            if (getCurrentRecipe(world, stack).isPresent() && state.getValue(FERMENTATION_STAGE) == FermentationStage.WATER) {
                if (entity.canInsertItem()) {
                    entity.insertItem(stack.getItem().getDefaultInstance());
                    world.setBlockAndUpdate(pos, state.setValue(FERMENTATION_STAGE, FermentationStage.FERMENTING));
                    pushEntitiesUp(state.setValue(FERMENTATION_STAGE, FermentationStage.WATER), state.setValue(FERMENTATION_STAGE, FermentationStage.FERMENTING), world, pos);
                    Item remainder = getCurrentRecipe(world, stack).get().value().getIngredient().getItems()[0].getItem().getCraftingRemainingItem();
                    world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_SPLASH.get(), SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat()/3);
                    entity.setParticleColor(getCurrentRecipe(world, stack).get().value().getParticleColor());
                    if (!player.isCreative()) {
                        stack.shrink(1);
                    }
                    if (remainder != null) {
                        if (stack.isEmpty() && !player.isCreative()) {
                            player.setItemInHand(hand, new ItemStack(remainder));
                        } else if (!player.getInventory().add(new ItemStack(remainder))) {
                            player.drop(new ItemStack(remainder), false);
                        }
                    }
                    return ItemInteractionResult.SUCCESS;
                }
            } else if (!entity.canInsertItem()) {
                return entity.tryExtractItem(world, pos, state, player, hand);
            }
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (world.getBlockEntity(pos) instanceof FermentationVesselBlockEntity entity) {
            if (Services.PLATFORM.get().getBoolConfigValue("fermentationBubbleParticles") && state.getValue(FermentationVesselBlock.FERMENTATION_STAGE) == FermentationStage.FERMENTING && entity.getParticleColor().isPresent()) {
                Vector3f color = Vec3.fromRGB24(entity.getParticleColor().orElse(16777215)).toVector3f();
                double randX = (world.random.nextDouble() * 0.6);
                double randZ = (world.random.nextDouble() * 0.6);
                //do not spawn particles that will be inside the vessel (values here are mostly experimental)
                if (!((randX > 0.1 && randX < 0.5) &&
                      (randZ > 0.1 && randZ < 0.5))) {
                    for (int i = 0; i < random.nextIntBetweenInclusive(1, 3); i++) {
                        world.addParticle(BFParticles.FERMENTED_BUBBLE.get(),
                                       pos.getX() + 0.20 + randX,
                                       pos.getY() + 0.85,
                                       pos.getZ() + 0.20 + randZ,
                                          color.x, color.y, color.z);
                    }
                }
            }
        }
        super.animateTick(state, world, pos, random);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        boolean bl = fluidState.getType() == Fluids.WATER;
        return super.getStateForPlacement(ctx).setValue(WATERLOGGED, bl);
    }


    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(state);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FermentationVesselBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, BFBlockEntities.FERMENTATION_VESSEL_BLOCK_ENTITY.get(), (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }

    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    protected int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        int MAX_COMP = 15;
        if (level.getBlockEntity(pos) instanceof FermentationVesselBlockEntity entity) {
            if (
                    blockState.getValue(FermentationVesselBlock.FERMENTATION_STAGE) == FermentationStage.FERMENTED ||
                    blockState.getValue(FermentationVesselBlock.FERMENTATION_STAGE) == FermentationStage.FERMENTING
            ) {
                float amnt = ((float) entity.getProgress() / (float) entity.getMaxProgress());
                return Math.clamp(Math.round(MAX_COMP * amnt), 1, MAX_COMP);
            }
        }

        return 0;
    }
}
