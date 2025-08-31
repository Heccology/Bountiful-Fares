package net.hecco.bountifulfares.definition.networking;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.definition.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.definition.block.entity.TrellisBlockEntity;
import net.hecco.bountifulfares.definition.networking.payload.*;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class BFPackets {
    public static void ceramicDishEmpty(CeramicDishEmptyPayload payload) {
        if (HLServices.PLATFORM.isClientSide()) {
            Level world = Minecraft.getInstance().level;
            if (world == null) return;
            BlockPos pos = payload.pos();

            if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
                entity.setItem(0, Items.AIR.getDefaultInstance());
                world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
            }
        }
    }

    public static void ceramicDishItem(CeramicDishItemPayload payload) {
        if (HLServices.PLATFORM.isClientSide()) {
            Level world = Minecraft.getInstance().level;
            if (world == null) return;
            BlockPos pos = payload.pos();
            ItemStack stack = payload.stack();

            if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
                entity.setItem(0, stack);
                world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
            }
        }
    }

    public static void ceramicBlockColor(CeramicBlockColorPayload payload) {
        if (HLServices.PLATFORM.isClientSide()) {
            Level world = Minecraft.getInstance().level;
            if (world == null) return;
            BlockPos pos = payload.pos();
            int color = payload.color();

            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity entity) {
                entity.color = color;
                world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
            } else if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
                entity.color = color;
                world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
            }
        }
    }

    public static void trellisPlant(TrellisPlantPayload payload) {
        if (HLServices.PLATFORM.isClientSide()) {
            Level world = Minecraft.getInstance().level;
            if (world == null) return;
            BlockPos pos = payload.pos();
            ItemStack stack = payload.stack();

            if (world.getBlockEntity(pos) instanceof TrellisBlockEntity entity) {
                entity.setPlant(stack.getItem());
                entity.setStage(payload.stage());
                world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
            }
        }
    }

    public static void trellisEmpty(TrellisEmptyPayload payload) {
        if (HLServices.PLATFORM.isClientSide()) {
            Level world = Minecraft.getInstance().level;
            if (world == null) return;
            BlockPos pos = payload.pos();

            if (world.getBlockEntity(pos) instanceof TrellisBlockEntity entity) {
                entity.removePlant();
                world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
            }
        }
    }

    public static void trellisSync(TrellisSyncPayload payload) {
        if (HLServices.PLATFORM.isClientSide()) {
            TrellisBlock.CROPS.clear();
            payload.crops().forEach((id, def) ->
                    TrellisBlock.CROPS.put(def.seeds(), def)
            );

            TrellisBlock.PLANTS.clear();
            payload.plants().forEach((id, def) ->
                    TrellisBlock.PLANTS.put(def.plant(), def)
            );
        }
    }
}
