package net.hecco.bountifulfares.definition.block.entity;

import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.definition.networking.payload.TrellisEmptyPayload;
import net.hecco.bountifulfares.definition.networking.payload.TrellisPlantPayload;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class TrellisBlockEntity extends BlockEntity {
    private ItemStack plant = ItemStack.EMPTY;
    private int stage = 1;
    public TrellisBlockEntity(BlockPos pos, BlockState blockState) {
        super(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), pos, blockState);
    }

    public Item getPlant() {
        if (this.plant != null) {
            return this.plant.getItem();
        } else {
            return null;
        }
    }

    public boolean canPlantOn() {
        return plant == ItemStack.EMPTY;
    }

    public void setPlant(Item seed) {
        this.plant = seed.getDefaultInstance();
        this.stage = 1;
        setChanged();
    }

    public void removePlant() {
        this.plant = ItemStack.EMPTY;
        this.stage = 1;
        setChanged();
    }

    public void setStage(int stage) {
        this.stage = stage;
        setChanged();
    }

    public int getStage() {
        return this.stage;
    }

    @Override
    public void setChanged() {
        if (this.getLevel() != null && !this.getLevel().isClientSide) {
            ServerLevel level = (ServerLevel) this.getLevel();
            if (plant != ItemStack.EMPTY) {
                NLServices.NETWORK.sendToPlayersTrackingChunk(level, this.getBlockPos(), new TrellisPlantPayload(this.getBlockPos(), this.plant, this.stage));
            } else {
                NLServices.NETWORK.sendToPlayersTrackingChunk(level, this.getBlockPos(), new TrellisEmptyPayload(this.getBlockPos()));
            }
        }
        super.setChanged();

    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        if (plant != ItemStack.EMPTY) {
            nbt.put("Plant", plant.save(registryLookup, nbt));
        }
        if (TrellisBlock.CROPS.containsKey(plant.getItem())) {
            nbt.putInt("Stage", stage);
        }
        super.saveAdditional(nbt, registryLookup);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registryLookup) {
        return saveWithoutMetadata(registryLookup);
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        if (nbt.get("Plant") != null) {
            plant = ItemStack.parse(registryLookup, Objects.requireNonNull(nbt.get("Plant"))).orElse(ItemStack.EMPTY);
            if (nbt.contains("Stage")) {
                stage = nbt.getInt("Stage");
            }
        }
        super.loadAdditional(nbt, registryLookup);
    }
}
