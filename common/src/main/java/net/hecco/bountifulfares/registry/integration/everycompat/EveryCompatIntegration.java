package net.hecco.bountifulfares.registry.integration.everycompat;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.entity.TrellisBlockEntity;
import net.hecco.nexuslib.lib.compat.CompatManager;
import net.hecco.nexuslib.lib.compat.ModIntegration;
import net.hecco.nexuslib.platform.NLServices;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.EVERY_COMPAT_MOD_ID;

public class EveryCompatIntegration implements ModIntegration {

    @Override
    public CompatManager getCompatManager() { return BountifulFares.COMPAT_MANAGER; }

    public static Supplier<BlockEntityType<TrellisBlockEntity>> EC_TRELLIS_BLOCK_ENTITY;

    @Override
    public List<String> modIds() { return List.of(EVERY_COMPAT_MOD_ID); }

    @Override
    public void registerContent() {
        EveryCompatAPI.registerModule(new BFEveryCompatModule(BountifulFares.MOD_ID));

        // look at FarmersDelightIntegration to see how they filled in the EC_TRELLIS_BLOCK_ENTITY equivalent
        //EC_TRELLIS_BLOCK_ENTITY = NLServices.REGISTRY.registerBlockEntityType(EveryCompat.MOD_ID, "trellis_block_entity",
        //        () -> NLServices.REGISTRY.createBlockEntity(TrellisBlockEntity::new, WALNUT_CABINET, HOARY_CABINET)

                // i asked chatgpt if its possible to make the WALNUT_CABINET and friends stuff possible with a list of
                // Supplier<Block> and yes its possible. Look at the latest convo there
        //);
    }
}
