package net.hecco.bountifulcuisine.block.entity;

import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.custom.GristmillBlock;
import net.hecco.bountifulcuisine.util.FermentationRecipes;
import net.hecco.bountifulcuisine.block.custom.FermentationVesselBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FermentationVesselBlockEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 6000 + Random.create().nextBetween(0, 400);
    public boolean fermented;
    public boolean indicatedFermentation;
    public FermentationVesselBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FERMENTATION_VESSEL_BLOCK_ENTITY, pos, state);
        this.fermented = false;
        this.indicatedFermentation = false;
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> FermentationVesselBlockEntity.this.progress;
                    case 1 -> FermentationVesselBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: FermentationVesselBlockEntity.this.progress = value;
                    case 1: FermentationVesselBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 1;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("fermenting.progress", progress);
        BountifulCuisine.LOGGER.info(inventory.toString());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        nbt.getInt("fermenting.progress");
        super.readNbt(nbt);
        BountifulCuisine.LOGGER.info(inventory.toString());
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public boolean canInsertItem() {
        return this.getStack(0).isEmpty();
    }

    public void insertItem(ItemStack item) {
        assert world != null;
        if (!world.isClient()) {
            this.setStack(0, item.copyWithCount(1));
            markDirty();
        }
    }

    public void removeItem() {
        assert world != null;
        this.setStack(0, Items.AIR.getDefaultStack());
        markDirty();
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (progress != maxProgress && !inventory.get(0).isEmpty()) {
            progress++;
            markDirty(world, pos, state);
        }
        if (progress >= maxProgress && !inventory.get(0).isEmpty()) {
            this.fermented = true;
            if (!indicatedFermentation) {
                world.playSound(null, pos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat()/3);
                indicatedFermentation = true;
            }
            markDirty(world, pos, state);
        }
        if (progress >= maxProgress && inventory.get(0).isEmpty()) {
            this.progress = 0;
            indicatedFermentation = false;
            markDirty(world, pos, state);
        }
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return false;
    }

    public ActionResult tryExtractItem(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        if (fermented) {
            ItemStack input = inventory.get(0);
            Item output = FermentationRecipes.getOutputFromInput(input.getItem());
            Item collector = null;
            if (output != null) {
                collector = FermentationRecipes.getCollector(output);
            }
            if (collector == null) {
                Integer outputCount = FermentationRecipes.getOutputCount(output);
                FermentationVesselBlock.dropStack(world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), new ItemStack(output, outputCount));
                world.setBlockState(pos, state.with(FermentationVesselBlock.WATER, false).with(FermentationVesselBlock.FERMENTING, false));
                removeItem();
                world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F);
                return ActionResult.SUCCESS;
            } else {
                if (player.getStackInHand(hand).isOf(collector)) {
                    world.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F);
                    if (!player.isCreative()) {
                        player.getStackInHand(hand).decrement(1);
                    }
                    if (player.getStackInHand(hand).isEmpty() && !player.isCreative()) {
                        player.setStackInHand(hand, new ItemStack(output));
                    } else if (!player.getInventory().insertStack(new ItemStack(output))) {
                        player.dropItem(new ItemStack(output), false);
                    }
                    world.setBlockState(pos, state.with(FermentationVesselBlock.WATER, false).with(FermentationVesselBlock.FERMENTING, false));
                    removeItem();
                    return ActionResult.SUCCESS;
                } else {
                    player.sendMessage(Text.translatable("warning." + BountifulCuisine.MOD_ID + ".fermentation_vessel." + collector), true);
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }
}
