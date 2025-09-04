package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.lib.compat.CompatManager;
import net.hecco.heccolib.lib.compat.ModIntegration;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.item.Item;

import java.util.List;

public class NaturesSpiritIntegration implements ModIntegration {
    @Override
    public CompatManager compatManager() {
        return BountifulFares.COMPAT_MANAGER;
    }

    @Override
    public List<String> modIds() {
        return List.of(BountifulFares.NATURES_SPIRIT_MOD_ID);
    }

    @Override
    public void registerContent() {
        registerContent(HLServices.REGISTRY.registerItem(BountifulFares.NATURES_SPIRIT_MOD_ID, "test_item", () -> new Item(new Item.Properties())));
    }
}
