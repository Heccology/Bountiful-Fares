package net.hecco.bountifulfares.registry.integration;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.hecco.bountifulfares.BountifulFares.AMENDMENTS_MOD_ID;

public class AmendmentsIntegration implements BFIntegration {

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
