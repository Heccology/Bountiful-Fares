package net.hecco.bountifulfares.definition.networking;

import net.hecco.bountifulfares.definition.networking.payload.TiffinFillPayload;
import net.hecco.bountifulfares.definition.networking.payload.UseArtisanBrushPayload;
import net.hecco.bountifulfares.definition.trigger.FillTiffinTrigger;
import net.hecco.bountifulfares.definition.trigger.UseArtisanBrushInInventoryTrigger;
import net.hecco.bountifulfares.registry.misc.BFCriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;

public class BFC2SPackets {
    public static void useArtisanBrushInInventory(UseArtisanBrushPayload payload, ServerPlayer player) {
        ((UseArtisanBrushInInventoryTrigger) BFCriteriaTriggers.USE_ARTISAN_BRUSH_IN_INVENTORY.get()).trigger(player);
    }

    public static void tiffinFill(TiffinFillPayload payload, ServerPlayer player) {
        ((FillTiffinTrigger) BFCriteriaTriggers.FILL_TIFFIN.get()).trigger(player, payload.fullness());
    }
}
