package net.hecco.bountifulfares.block.entity.compat;

//public class CabinetBlockEntity extends LootableContainerBlockEntity {
//    private static final int MAX_INVENTORY_SIZE = 27;
//
//    private final ViewerCountManager viewerManager;
//    private DefaultedList<ItemStack> content;
//
//    public CabinetBlockEntity(BlockPos blockPos, BlockState blockState) {
//        this(BFBlockEntities.CABINET_BLOCK_ENTITY, blockPos, blockState);
//    }
//
//    private CabinetBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
//        super(type, blockPos, blockState);
//        this.content = DefaultedList.ofSize(MAX_INVENTORY_SIZE, ItemStack.EMPTY);
//        this.viewerManager = new ViewerCountManager() {
//            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
//                world.playSound(null, pos, BFSounds.CABINET_OPEN, SoundCategory.BLOCKS, 1f, 1f);
//                CabinetBlockEntity.this.setOpen(state, true);
//            }
//
//            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
//                CabinetBlockEntity.this.playSound(state, BFSounds.CABINET_OPEN);
//                CabinetBlockEntity.this.setOpen(state, false);
//            }
//
//            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
//                // Nothing to do when viewer count is updated
//            }
//
//            @Override
//            protected boolean isPlayerViewing(PlayerEntity player) {
//                if (player.currentScreenHandler instanceof GenericContainerScreenHandler genericContainerScreenHandler) {
//                    Inventory inventory = genericContainerScreenHandler.getInventory();
//                    return inventory == CabinetBlockEntity.this;
//                } else {
//                    return false;
//                }
//            }
//
//        };
//    }
//
//    @Override
//    protected Text getContainerName() {
//        return net.minecraft.text.Text.translatable("farmersdelight.container.cabinet");
//    }
//
//    @Override
//    protected DefaultedList<ItemStack> getHeldStacks() {
//        return null;
//    }
//
//    @Override
//    protected void setHeldStacks(DefaultedList<ItemStack> inventory) {
//
//    }
//
//    @Override
//    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
//        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
//    }
//
//    @Override
//    protected DefaultedList<ItemStack> getInvStackList() {
//        return content;
//    }
//
//    @Override
//    protected void setInvStackList(DefaultedList<ItemStack> list) {
//        content = list;
//    }
//
//    @Override
//    public int size() {
//        return MAX_INVENTORY_SIZE;
//    }
//
//    @Override
//    public void onOpen(PlayerEntity player) {
//        if (!this.removed && !player.isSpectator()) {
//            this.viewerManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
//        }
//    }
//
//    @Override
//    public void onClose(PlayerEntity player) {
//        if (!this.removed && !player.isSpectator()) {
//            this.viewerManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
//        }
//    }
//
//    @Override
//    public void writeNbt(NbtCompound tag) {
//        super.writeNbt(tag);
//        if (!serializeLootTable(tag)) {
//            Inventories.writeNbt(tag, content);
//        }
//    }
//
//    @Override
//    public void readNbt(NbtCompound tag) {
//        super.readNbt(tag);
//        content = DefaultedList.ofSize(size(), ItemStack.EMPTY);
//        if (!deserializeLootTable(tag)) {
//            Inventories.readNbt(tag, content);
//        }
//    }
//
//    @Nullable
//    @Override
//    public Packet<ClientPlayPacketListener> toUpdatePacket() {
//        return BlockEntityUpdateS2CPacket.create(this);
//    }
//
//    @Override
//    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
//        NbtCompound nbtCompound = new NbtCompound();
//        Inventories.writeNbt(nbtCompound, content, registryLookup);
//
//        return nbtCompound;
//    }
//
//    public void tick() {
//        if (!this.removed) {
//            this.viewerManager.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
//        }
//
//        if (this.viewerManager.getViewerCount() > 0) {
//            scheduleTick();
//        } else {
//            BlockState blockstate = getCachedState();
//            if (!(blockstate.getBlock() instanceof CabinetBlock)) {
//                markRemoved();
//                return;
//            }
//
//            boolean flag = blockstate.get(CabinetBlock.OPEN);
//            if (flag) {
//                playSound(blockstate, SoundEvents.BLOCK_BARREL_CLOSE);
//                setOpen(blockstate, false);
//            }
//        }
//    }
//
//    private void scheduleTick() {
//        Objects.requireNonNull(getWorld()).getBlockTickScheduler().scheduleTick(OrderedTick.create(getCachedState().getBlock(), getPos()));
//    }
//
//    private void setOpen(BlockState state, boolean open) {
//        Objects.requireNonNull(getWorld()).setBlockState(getPos(), state.with(CabinetBlock.OPEN, open));
//    }
//
//    private void playSound(BlockState state, SoundEvent sound) {
//        Vec3i vec3i = state.get(CabinetBlock.FACING).getVector();
//        BlockPos pos = getPos();
//        double dX = pos.getX() + .5d + vec3i.getX() / 2.d;
//        double dT = pos.getY() + .5d + vec3i.getY() / 2.d;
//        double dZ = pos.getZ() + .5d + vec3i.getZ() / 2.d;
//        World world = Objects.requireNonNull(getWorld());
//        world.playSound(null, dX, dT, dZ, sound, SoundCategory.BLOCKS, .5f, world.getRandom().nextFloat() * .1f + .9f);
//    }
//}
