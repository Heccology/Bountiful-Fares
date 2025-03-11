package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.FermentationVesselBlock;
import net.hecco.bountifulfares.block.enums.FermentationStage;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.bountifulfares.registry.content.BFSounds;
import net.hecco.bountifulfares.registry.misc.BFRecipes;
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
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class FermentationVesselBlockEntity extends BlockEntity implements ImplementedInventory {
    public final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress;
    public boolean fermented;
    public int particleColor;
    public FermentationVesselBlockEntity(BlockPos pos, BlockState state) {
        super(BFBlockEntities.FERMENTATION_VESSEL_BLOCK_ENTITY, pos, state);
        this.fermented = false;
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
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, this.inventory, registryLookup);
        nbt.putInt("fermenting.progress", this.progress);
        nbt.putInt("particleColor", this.particleColor);
    }


    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, this.inventory, registryLookup);
        this.progress = nbt.getInt("fermenting.progress");
        this.particleColor = nbt.getInt("particleColor");
        super.readNbt(nbt, registryLookup);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public void setParticleColor(int color) {
        this.particleColor = color;
        markDirty();
    }

    public Optional<Integer> getParticleColor() {
        return this.particleColor == 0 ? Optional.empty() : Optional.of(this.particleColor);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    public boolean canInsertItem() {
        return this.getStack(0).isEmpty();
    }

    public void insertItem(ItemStack item) {
        assert this.world != null;
        if (!this.world.isClient()) {
            this.setStack(0, item.copyWithCount(1));
            markDirty();
        }
    }

    public void removeItem() {
        assert this.world != null;
        this.setStack(0, Items.AIR.getDefaultStack());
        markDirty();
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (!world.isClient) {
            if (this.maxProgress != (BountifulFares.CONFIG.getFermentationTime() * 20)) {
                this.maxProgress = BountifulFares.CONFIG.getFermentationTime() * 20;
            }
            if (this.progress < this.maxProgress && !this.inventory.get(0).isEmpty()) {
                this.progress++;
                markDirty(world, pos, state);
            }
            if (this.progress >= this.maxProgress && this.inventory.get(0).isEmpty()) {
                this.fermented = false;
                this.progress = 0;
                markDirty(world, pos, state);
            }
            if (!this.fermented && this.progress >= this.maxProgress && !this.inventory.get(0).isEmpty()) {
                this.fermented = true;
                if (state.get(FermentationVesselBlock.FERMENTATION_STAGE) != FermentationStage.FERMENTED) {
                    world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_FERMENT, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() / 3);
                    markDirty(world, pos, state);
                }
            }
            if (this.fermented && state.get(FermentationVesselBlock.FERMENTATION_STAGE) != FermentationStage.FERMENTED) {
                world.setBlockState(pos, state.with(FermentationVesselBlock.FERMENTATION_STAGE, FermentationStage.FERMENTED));
            }
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

    public Optional<RecipeEntry<FermentationRecipe>> getCurrentRecipe() {
        Optional<RecipeEntry<FermentationRecipe>> recipe = Objects.requireNonNull(this.getWorld()).getRecipeManager().getFirstMatch(BFRecipes.FERMENTING, new SingleStackRecipeInput(inventory.get(0)), this.world);
        return recipe.isEmpty() ? Optional.empty() : Objects.requireNonNull(this.getWorld()).getRecipeManager().getFirstMatch(BFRecipes.FERMENTING, new SingleStackRecipeInput(inventory.get(0)), this.world);
    }
    public ActionResult tryExtractItem(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        if (this.fermented) {
            ItemStack output = getCurrentRecipe().isEmpty() ? null : getCurrentRecipe().get().value().getOutput();
            if (output != null) {
                Item collector = output.getItem().getRecipeRemainder();
                if (collector == null) {
                    FermentationVesselBlock.dropStack(world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), output);
                    world.setBlockState(pos, state.with(FermentationVesselBlock.FERMENTATION_STAGE, FermentationStage.EMPTY));
                    removeItem();
                    world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() / 3);
                    this.progress = 0;
                    this.fermented = false;
                    markDirty(world, pos, state);
                    return ActionResult.SUCCESS;
                } else {
                    if (player.getStackInHand(hand).isOf(collector)) {
                        world.playSound(null, pos, BFSounds.FERMENTATION_VESSEL_EMPTY, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() / 3);
                        if (!player.isCreative()) {
                            player.getStackInHand(hand).decrement(1);
                        }
                        if (player.getStackInHand(hand).isEmpty() && !player.isCreative()) {
                            player.setStackInHand(hand, new ItemStack(output.getItem()));
                        } else if (!player.getInventory().insertStack(new ItemStack(output.getItem()))) {
                            player.dropItem(new ItemStack(output.getItem()), false);
                        }
                        world.setBlockState(pos, state.with(FermentationVesselBlock.FERMENTATION_STAGE, FermentationStage.EMPTY));
                        this.progress = 0;
                        this.fermented = false;
                        removeItem();
                        markDirty(world, pos, state);
                        return ActionResult.SUCCESS;
                    } else {
                        player.sendMessage(Text.translatable("warning." + BountifulFares.MOD_ID + ".fermentation_vessel." + collector), true);
                        return ActionResult.SUCCESS;
                    }
                }
            }
        }
        return ActionResult.PASS;
    }
}



