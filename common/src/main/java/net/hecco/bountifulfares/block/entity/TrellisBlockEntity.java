package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.networking.payload.TrellisEmptyPayload;
import net.hecco.bountifulfares.networking.payload.TrellisPlantPayload;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class TrellisBlockEntity extends BlockEntity {
    private ItemStack plant = ItemStack.EMPTY;
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

    public void setPlant(Item seed, ResourceLocation texture) {
        this.plant = seed.getDefaultInstance();
        BountifulFares.LOGGER.info(Minecraft.getInstance().getModelManager().getModel(
                new ModelResourceLocation(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "vine_trellis"), "")
        ) + "");
        setChanged();
    }

    public void removePlant() {
        this.plant = ItemStack.EMPTY;
        setChanged();
    }

    @Override
    public void setChanged() {
        if (this.getLevel() != null && !this.getLevel().isClientSide) {
            ServerLevel level = (ServerLevel) this.getLevel();
            if (plant != ItemStack.EMPTY) {
                HLServices.NETWORK.sendToPlayersTrackingChunk(level, this.getBlockPos(), new TrellisPlantPayload(this.getBlockPos(), this.plant));
            } else {
                HLServices.NETWORK.sendToPlayersTrackingChunk(level, this.getBlockPos(), new TrellisEmptyPayload(this.getBlockPos()));
            }
        }
        super.setChanged();

    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        if (plant != ItemStack.EMPTY) {
            nbt.put("Plant", plant.save(registryLookup, nbt));
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
        } else {
            plant = ItemStack.EMPTY;
        }
        super.loadAdditional(nbt, registryLookup);
    }
}
