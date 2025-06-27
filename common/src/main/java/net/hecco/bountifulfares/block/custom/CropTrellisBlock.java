//package net.hecco.bountifulfares.block.custom;
//
//import net.hecco.bountifulfares.registry.content.BFTrellises;
//import net.hecco.bountifulfares.trellis.TrellisUtil;
//import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
//import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.util.RandomSource;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.ItemInteractionResult;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.context.BlockPlaceContext;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.LevelAccessor;
//import net.minecraft.world.level.LevelReader;
//import net.minecraft.world.level.block.*;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.block.state.properties.BooleanProperty;
//import net.minecraft.world.level.block.state.properties.DirectionProperty;
//import net.minecraft.world.level.block.state.properties.IntegerProperty;
//import net.minecraft.world.level.gameevent.GameEvent;
//import net.minecraft.world.level.material.FluidState;
//import net.minecraft.world.level.material.Fluids;
//import net.minecraft.world.level.pathfinder.PathComputationType;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//
//import static net.hecco.bountifulfares.registry.content.BFBlocks.CROPS_TO_CROP_TRELLISES;
//
//public class CropTrellisBlock extends Block implements SimpleWaterloggedBlock, BonemealableBlock {
//    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
//    public static final DirectionProperty FACING;
//    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
//    private final Item berryItem;
//    protected static final VoxelShape NORTH_SHAPE = Block.box(0, 0, 15, 16, 16, 16);
//    protected static final VoxelShape SOUTH_SHAPE = Block.box(0, 0, 0, 16, 16, 1);
//    protected static final VoxelShape WEST_SHAPE = Block.box(15, 0, 0, 16, 16, 16);
//    protected static final VoxelShape EAST_SHAPE = Block.box(0, 0, 0, 1, 16, 16);
//    public static BooleanProperty SNIPPED = BooleanProperty.create("snipped");
//
//    private final TrellisVariant variant;
//    private final VineCrop crop;
//    private String berryItemID;
//    private final int harvestResetAge;
//    public CropTrellisBlock(Item berryItem, TrellisVariant variant, VineCrop crop, Properties settings) {
//        super(settings);
//        this.berryItem = berryItem;
//        CROPS_TO_CROP_TRELLISES.put(berryItem, this);
//        this.variant = variant;
//        this.crop = crop;
//        this.harvestResetAge = 1;
//        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH).setValue(AGE, 0).setValue(SNIPPED, false));
//    }
//
//    public CropTrellisBlock(int harvestResetAge, String berryItemID, TrellisVariant variant, VineCrop crop, Properties settings) {
//        super(settings);
//        this.berryItem = null;
//        this.berryItemID = berryItemID;
//        this.variant = variant;
//        this.crop = crop;
//        this.harvestResetAge = harvestResetAge;
//        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH).setValue(AGE, 0).setValue(SNIPPED, false));
//    }
//    public CropTrellisBlock(Item seedsItem, Item berryItem, TrellisVariant variant, VineCrop crop, Properties settings) {
//        super(settings);
//        this.berryItem = berryItem;
//        CROPS_TO_CROP_TRELLISES.put(seedsItem, this);
//        this.variant = variant;
//        this.crop = crop;
//        this.harvestResetAge = 1;
//        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH).setValue(AGE, 0).setValue(SNIPPED, false));
//    }
//
//    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
//        switch (state.getValue(FACING)) {
//            case NORTH:
//                return NORTH_SHAPE;
//            case SOUTH:
//                return SOUTH_SHAPE;
//            case WEST:
//                return WEST_SHAPE;
//            case EAST:
//            default:
//                return EAST_SHAPE;
//        }
//    }
//
//    @Override
//    public void destroy(LevelAccessor world, BlockPos pos, BlockState state) {
//        popResource((Level) world, pos, new ItemStack(crop.getSeedsItem()));
//        super.destroy(world, pos, state);
//    }
//    //same note as in DecorativeTrellisBlock
//    @Override
//    public String getDescriptionId() {
//        return "block." + variant.getModId() + "." + variant.getBlockName();
//    }
//
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(WATERLOGGED, FACING, AGE, SNIPPED);
//    }
//
//    @Override
//    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
//    {
//        if (stack.is(Items.SHEARS) && !state.getValue(SNIPPED)) {
//            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
//            world.setBlockAndUpdate(pos, state.setValue(SNIPPED, true));
//            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
//            return ItemInteractionResult.SUCCESS;
//        }
//        return super.useItemOn(stack, state, world, pos, player, hand, hit);
//    }
//
//    @Override
//    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
//        int i = state.getValue(AGE);
//        if (i == 3 & !state.getValue(SNIPPED)) {
//            int j = 1 + world.random.nextInt(2);
//            if (this.berryItem != null) {
//                popResource(world, pos, new ItemStack(this.berryItem, world.random.nextIntBetweenInclusive(1, 2)));
//                world.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
//            } else if (this.berryItemID != null) {
//                popResource(world, pos, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(crop.getId(), this.berryItemID)), world.random.nextIntBetweenInclusive(1, 2)));
//                world.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
//            }
//            BlockState blockState = state.setValue(AGE, harvestResetAge);
//            world.setBlock(pos, blockState, Block.UPDATE_CLIENTS);
//            world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
//            return InteractionResult.SUCCESS;
//        }
//        return super.useWithoutItem(state, world, pos, player, hit);
//    }
//
//    @Override
//    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
//        if(state.getValue(SNIPPED)) {
//
//        } else if (!isFullyGrown(state)) {
//            if (world.random.nextFloat() < 0.2f) {
//                world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
//            }
//        }
//    }
//    @Override
//    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
//        if(state.getValue(SNIPPED)) {
//
//        } else if (!isFullyGrown(state)) {
//            world.setBlock(pos, state.cycle(AGE), Block.UPDATE_CLIENTS);
//        }
//    }
//
//    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
//        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite())
//        .setValue(WATERLOGGED, ctx.getLevel().getFluidState(ctx.getClickedPos()).getType() == Fluids.WATER);
//    }
//
//    @Override
//    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
//        if (state.getValue(WATERLOGGED)) {
//            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
//        }
//        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
//    }
//
//    @Override
//    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
//        return new ItemStack(TrellisUtil.getTrellisFromVariant(variant));
//    }
//
//    @Override
//    public FluidState getFluidState(BlockState state) {
//        if (state.getValue(WATERLOGGED)) {
//            return Fluids.WATER.getSource(false);
//        }
//        return super.getFluidState(state);
//    }
//
//    @Override
//    protected boolean isPathfindable(BlockState state, PathComputationType type) {
//        return false;
//    }
//
//    @Override
//    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
//        if(isFullyGrown(state)) {
//            return false;
//        }
//        return !state.getValue(SNIPPED);
//    }
//
//    @Override
//    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
//        if(isFullyGrown(state)) {
//            return false;
//        }
//        return !state.getValue(SNIPPED);
//    }
//
//    protected static boolean isFullyGrown(BlockState state) {
//        return state.getValue(AGE) == 3;
//    }
//
//    public BlockState rotate(BlockState state, Rotation rotation) {
//        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
//    }
//
//    public BlockState mirror(BlockState state, Mirror mirror) {
//        return state.rotate(mirror.getRotation(state.getValue(FACING)));
//    }
//
//    public boolean propagatesSkylightDown(BlockState state, BlockGetter world, BlockPos pos) {
//        return state.getFluidState().isEmpty();
//    }
//    public static BlockState getCropTrellisFromCrop(Item seedsItem) {
//        if (seedsItem != null && CROPS_TO_CROP_TRELLISES.containsKey(seedsItem)) {
//            return (CROPS_TO_CROP_TRELLISES.get(seedsItem)).defaultBlockState();
//        } else {
//            return BFTrellises.TRELLISES.get("trellis").defaultBlockState();
//        }
//    }
//
//    static {
//        FACING = BlockStateProperties.HORIZONTAL_FACING;
//    }
//}
