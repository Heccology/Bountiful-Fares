package net.hecco.bountifulfares.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.networking.payload.CeramicBlockColorPayload;
import net.hecco.bountifulfares.networking.payload.CeramicDishEmptyPayload;
import net.hecco.bountifulfares.networking.payload.CeramicDishItemPayload;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BFMessages {

    public static final Identifier CERAMIC_DISH_ITEM = Identifier.of(BountifulFares.MOD_ID, "ceramic_dish_item");
    public static final Identifier CERAMIC_DISH_EMPTY = Identifier.of(BountifulFares.MOD_ID, "ceramic_dish_empty");
    public static final Identifier CERAMIC_BLOCK_COLOR = Identifier.of(BountifulFares.MOD_ID, "ceramic_block_color");

    public static void registerS2CPackets() {
        // Ceramic Dish Emptying Sync
        ClientPlayNetworking.registerGlobalReceiver(CeramicDishEmptyPayload.ID, (payload, context) ->
        {
            context.client().execute(() -> {
                World world = context.player().getWorld();
                BlockPos pos = payload.pos();

                if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
                    entity.setStack(0, Items.AIR.getDefaultStack());
                    world.updateListeners(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
                }
            });
        });
        // Ceramic Dish Item Sync
        ClientPlayNetworking.registerGlobalReceiver(CeramicDishItemPayload.ID, (payload, context) ->
        {
            context.client().execute(() -> {
                World world = context.player().getWorld();
                BlockPos pos = payload.pos();
                ItemStack stack = payload.stack();

                if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
                    entity.setStack(0, stack);
                    world.updateListeners(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
                }
            });
        });
        // Ceramic Block Color Sync
        ClientPlayNetworking.registerGlobalReceiver(CeramicBlockColorPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                World world = context.player().getWorld();
                BlockPos pos = payload.pos();
                int color = payload.color();

                if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity entity) {
                    entity.color = color;
                    world.updateListeners(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
                }
                else if (world.getBlockEntity(pos) instanceof CeramicDishBlockEntity entity) {
                    entity.color = color;
                    world.updateListeners(pos, world.getBlockState(pos), world.getBlockState(pos), 2);
                }
            });
        });
    }

    public static void registerPayloads()
    {
        PayloadTypeRegistry.playS2C().register(CeramicDishItemPayload.ID, CeramicDishItemPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(CeramicBlockColorPayload.ID, CeramicBlockColorPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(CeramicDishEmptyPayload.ID, CeramicDishEmptyPayload.CODEC);
    }
}
