package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.compat.DatagenOnlyItems;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.compat.dye_depot.DyeDepotBlocks;
import net.hecco.bountifulfares.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.compat.natures_spirit.NaturesSpiritBlocks;
import net.hecco.bountifulfares.compat.spawn.SpawnBlocks;
import net.hecco.bountifulfares.compat.twigs.TwigsBlocks;
import net.hecco.bountifulfares.compat.twigs.TwigsSounds;
import net.minecraft.block.Block;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.hecco.bountifulfares.BountifulFares.*;

public class BFCompat {
    public static Set<Block> compatBlocks = new HashSet<>();
    public static final List<String> COMPAT_IDS = List.of(ELS_AND_LS_DYES_MOD_ID, DYE_DEPOT_MOD_ID, AMENDMENTS_MOD_ID, EXCESSIVE_BUILDING_MOD_ID, NATURES_SPIRIT_MOD_ID, SPAWN_MOD_ID, FARMERS_DELIGHT_MOD_ID, TWIGS_MOD_ID, ARTS_AND_CRAFTS_MOD_ID, DELICATE_DYES_MOD_ID, APPLEDOG_MOD_ID);
    public static void registerCompatContent() {
        DatagenOnlyItems.registerDatagenItems();

//        mint
        MintBlocks.registerMintBlocks();

//        dye_depot
        DyeDepotBlocks.registerDyeDepotBlocks();

//        farmersdelight
        FarmersDelightBlocks.registerFarmersDelightBlocks();

//        excessive_building
        ExcessiveBuildingBlocks.registerExcessiveBuildingBlocks();

//        natures_spirit
        NaturesSpiritBlocks.registerNaturesSpiritBlocks();

//        twigs
        TwigsBlocks.registerTwigsBlocks();
        if (BountifulFares.isModLoaded(TWIGS_MOD_ID)) {
            TwigsSounds.registerSounds();
        }

//        spawn
        SpawnBlocks.registerSpawnBlocks();

//        arts_and_crafts
        ArtsAndCraftsBlocks.registerArtsAndCraftsBlocks();

//        delicate_dyes
        DelicateDyesBlocks.registerPigmentPaloozaBlocks();

        AppledogBlocks.registerAppledogBlocks();

        DungeonsDelightBlocks.registerDungeonsDelightBlocks();
    }
}
