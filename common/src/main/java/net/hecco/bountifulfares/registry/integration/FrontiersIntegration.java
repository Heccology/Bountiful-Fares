package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.lib.compat.CompatManager;
import net.hecco.heccolib.lib.compat.ModIntegration;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.hecco.bountifulfares.BountifulFares.FRONTIERS_MOD_ID;

public class FrontiersIntegration implements ModIntegration {
    @Override
    public CompatManager getCompatManager() {
        return BountifulFares.COMPAT_MANAGER;
    }

    @Override
    public List<String> modIds() {
        return List.of(FRONTIERS_MOD_ID);
    }

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public @Nullable String getDatapackName() {
        return "Frontiers x Bountiful Fares";
    }

    @Override
    public void registerContent() {
        //content goes here, make sure to wrap anything you register with registerContent(...)
        //if you do a trellis type add it to the TRELLISES map in BFBlocks, it does all the data stuff besides recipes for you
    }
}
