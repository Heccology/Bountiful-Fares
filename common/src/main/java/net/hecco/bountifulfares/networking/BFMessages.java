package net.hecco.bountifulfares.networking;

//import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
//import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.NewTrellisBlock;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.block.entity.TrellisBlockEntity;
import net.hecco.bountifulfares.networking.payload.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class BFMessages {

    public static final ResourceLocation CERAMIC_DISH_ITEM = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "ceramic_dish_item");
    public static final ResourceLocation CERAMIC_DISH_EMPTY = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "ceramic_dish_empty");
    public static final ResourceLocation CERAMIC_BLOCK_COLOR = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "ceramic_block_color");
    public static final ResourceLocation TRELLIS_PLANT = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "trellis_plant");
    public static final ResourceLocation TRELLIS_EMPTY = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "trellis_empty");

    public static void ceramicDishEmpty(CeramicDishEmptyPayload payload) {
        Level world = Minecraft.getInstance().level;
        if (world == null) return;
        BlockPos pos = payload.pos();

        if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
            entity.setItem(0, Items.AIR.getDefaultInstance());
            world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
        }
    }

    public static void ceramicDishItem(CeramicDishItemPayload payload) {
        Level world = Minecraft.getInstance().level;
        if (world == null) return;
        BlockPos pos = payload.pos();
        ItemStack stack = payload.stack();

        if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
            entity.setItem(0, stack);
            world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
        }
    }

    public static void ceramicBlockColor(CeramicBlockColorPayload payload) {
        Level world = Minecraft.getInstance().level;
        if (world == null) return;
        BlockPos pos = payload.pos();
        int color = payload.color();

        if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity entity) {
            entity.color = color;
            world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
        }
        else if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
            entity.color = color;
            world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
        }
    }

    public static void trellisPlant(TrellisPlantPayload payload) {
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

    public static void trellisEmpty(TrellisEmptyPayload payload) {
        Level world = Minecraft.getInstance().level;
        if (world == null) return;
        BlockPos pos = payload.pos();

        if (world.getBlockEntity(pos) instanceof TrellisBlockEntity entity) {
            entity.removePlant();
            world.sendBlockUpdated(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
        }
    }
}
