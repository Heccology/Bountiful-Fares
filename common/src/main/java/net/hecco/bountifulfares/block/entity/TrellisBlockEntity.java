package net.hecco.bountifulfares.block.entity;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

public class TrellisBlockEntity extends BlockEntity {
    private ItemStack plant = ItemStack.EMPTY;
    private ResourceLocation texture = null;
    public TrellisBlockEntity(BlockPos pos, BlockState blockState) {
        super(BFBlockEntities.TRELLIS_BLOCK_ENTITY.get(), pos, blockState);
    }

    public Item getPlant() {
        return this.plant.getItem();
    }

    public boolean canPlantOn() {
        return plant == ItemStack.EMPTY;
    }

    public void setPlant(Item seed, ResourceLocation texture) {
        this.plant = seed.getDefaultInstance();
        this.texture = texture;
        BountifulFares.LOGGER.info(Minecraft.getInstance().getModelManager().getModel(
                new ModelResourceLocation(ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "vine_trellis"), "")
        ) + "");
        setChanged();
    }

    public void removePlant() {
        this.plant = ItemStack.EMPTY;
        setChanged();
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        if (plant != ItemStack.EMPTY) {
            nbt.put("Plant", plant.save(registryLookup, nbt));
        }
        if (texture != null) {
            nbt.putString("Texture", texture.toString());
        }
        super.saveAdditional(nbt, registryLookup);
    }

    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider registryLookup) {
        if (nbt.get("Plant") != null) {
            plant = ItemStack.parse(registryLookup, Objects.requireNonNull(nbt.get("Plant"))).orElse(ItemStack.EMPTY);
        } else {
            plant = ItemStack.EMPTY;
        }
        if (nbt.get("Texture") != null) {
            ResourceLocation.read(nbt.getString("Texture"));
        } else {
            texture = null;
        }
        super.loadAdditional(nbt, registryLookup);
    }
}
