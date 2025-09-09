package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.nexuslib.lib.compat.CompatManager;
import net.hecco.nexuslib.lib.compat.ModIntegration;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.hecco.bountifulfares.BountifulFares.AMENDMENTS_MOD_ID;

public class AmendmentsIntegration implements ModIntegration {
    @Override
    public CompatManager getCompatManager() {
        return BountifulFares.COMPAT_MANAGER;
    }

    @Override
    public List<String> modIds() {
        return List.of(AMENDMENTS_MOD_ID);
    }

    @Override
    public void registerContent() {}

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public @Nullable String getDatapackName() {
        return "Amendments x Bountiful Fares";
    }
}
