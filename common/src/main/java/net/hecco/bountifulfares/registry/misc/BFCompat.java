package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.definition.compat.appledog.AppledogBlocks;
import net.hecco.bountifulfares.definition.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.definition.compat.delicate_dyes.DelicateDyesBlocks;
import net.hecco.bountifulfares.definition.compat.dungeons_delight.DungeonsDelightBlocks;
import net.hecco.bountifulfares.definition.compat.excessive_building.ExcessiveBuildingBlocks;
import net.hecco.bountifulfares.definition.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.bountifulfares.definition.compat.natures_spirit.NaturesSpiritBlocks;
import net.minecraft.world.level.block.Block;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.*;

public class BFCompat {
    public static Set<Supplier<Block>> compatBlocks = new HashSet<>();
    public static final List<String> COMPAT_IDS = List.of(ELS_AND_LS_DYES_MOD_ID, DYE_DEPOT_MOD_ID, AMENDMENTS_MOD_ID, EXCESSIVE_BUILDING_MOD_ID, NATURES_SPIRIT_MOD_ID, SPAWN_MOD_ID, FARMERS_DELIGHT_MOD_ID, TWIGS_MOD_ID, ARTS_AND_CRAFTS_MOD_ID, DELICATE_DYES_MOD_ID, APPLEDOG_MOD_ID, DUNGEONS_DELIGHT_MOD_ID);
    public static void registerCompatContent() {

//        mint
//        MintBlocks.registerMintBlocks();

//        dye_depot
//        DyeDepotBlocks.registerDyeDepotBlocks();

//        farmersdelight
        FarmersDelightBlocks.registerFarmersDelightBlocks();

//        excessive_building
        ExcessiveBuildingBlocks.registerExcessiveBuildingBlocks();

//        natures_spirit
        NaturesSpiritBlocks.registerNaturesSpiritBlocks();

//        twigs
//        TwigsBlocks.registerTwigsBlocks();
//        if (Services.PLATFORM.isModLoaded(TWIGS_MOD_ID)) {
//            TwigsSounds.registerSounds();
//        }

//        spawn
//        SpawnBlocks.registerSpawnBlocks();

//        arts_and_crafts
        ArtsAndCraftsBlocks.registerArtsAndCraftsBlocks();

//        delicate_dyes
        DelicateDyesBlocks.registerPigmentPaloozaBlocks();

        AppledogBlocks.registerAppledogBlocks();

        DungeonsDelightBlocks.registerDungeonsDelightBlocks();
    }
}
