package net.hecco.bountifulfares;

import net.hecco.bountifulfares.registry.content.BFEntities;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import oshi.util.tuples.Pair;

@EventBusSubscriber(modid = BountifulFares.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NeoForgeClientEvents {
    @SubscribeEvent
    public static void blockColorSetup(RegisterColorHandlersEvent.Block event) {
        for (Pair<BlockColor, Block> pair : BountifulFaresClient.blockColors) {
            event.register(pair.getA(), pair.getB());
        }
    }

    @SubscribeEvent
    public static void itemColorSetup(RegisterColorHandlersEvent.Item event) {
        for (Pair<ItemColor, ItemLike> pair : BountifulFaresClient.itemColors) {
            event.register(pair.getA(), pair.getB());
        }
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BFEntities.THROWN_FLOUR_PROJECTILE.get(), ThrownItemRenderer::new);
    }
}
