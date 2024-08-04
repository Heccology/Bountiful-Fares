package net.hecco.bountifulfares.config;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.hecco.bountifulfares.BountifulFares;

@Environment(value= EnvType.CLIENT)
public enum Category {

//    CLIENT("config.bountifulfares.category.client", false,
//            Entry.booleanEntry("config.bountifulfares.item_guide_tooltips", () -> BountifulFares.CONFIG.isEnableItemGuideTooltips(),
//                    newValue -> BountifulFares.CONFIG.setEnableItemGuideTooltips(newValue), true)),


    PAINTINGS("config.bountifulfares.category.paintings", true,
            Entry.booleanEntry("config.bountifulfares.bountiful_painting", () -> BountifulFares.CONFIG.isEnableBountifulPainting(),
                    newValue -> BountifulFares.CONFIG.setEnableBountifulPainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.citrus_dish_painting", () -> BountifulFares.CONFIG.isEnableCitrusDishPainting(),
                    newValue -> BountifulFares.CONFIG.setEnableCitrusDishPainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.hazel_floret_painting", () -> BountifulFares.CONFIG.isEnableHazelFloretPainting(),
                    newValue -> BountifulFares.CONFIG.setEnableHazelFloretPainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.violet_floret_painting", () -> BountifulFares.CONFIG.isEnableVioletFloretPainting(),
                    newValue -> BountifulFares.CONFIG.setEnableVioletFloretPainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.why_blue_painting", () -> BountifulFares.CONFIG.isEnableWhyBluePainting(),
                    newValue -> BountifulFares.CONFIG.setEnableWhyBluePainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.ruminer_painting", () -> BountifulFares.CONFIG.isEnableRuminerPainting(),
                    newValue -> BountifulFares.CONFIG.setEnableRuminerPainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.phylogenesis_painting", () -> BountifulFares.CONFIG.isEnablePhylogenesisPainting(),
                    newValue -> BountifulFares.CONFIG.setEnablePhylogenesisPainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.escalade_painting", () -> BountifulFares.CONFIG.isEnableEscaladePainting(),
                    newValue -> BountifulFares.CONFIG.setEnableEscaladePainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.aquaculture_painting", () -> BountifulFares.CONFIG.isEnableAquaculturePainting(),
                    newValue -> BountifulFares.CONFIG.setEnableAquaculturePainting(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.unpleasant_tiles_painting", () -> BountifulFares.CONFIG.isEnableUnpleasantTilesPainting(),
                    newValue -> BountifulFares.CONFIG.setEnableUnpleasantTilesPainting(newValue), true, "config.bountifulfares.restart_warning")),
    GAMEPLAY("config.bountifulfares.category.gameplay", false, new Category[]{PAINTINGS},
            Entry.integerEntry("config.bountifulfares.milling_time", () -> BountifulFares.CONFIG.getMillingTime(),
                    newValue -> BountifulFares.CONFIG.setMillingTime(newValue), 4, 1, 10),

            Entry.integerEntry("config.bountifulfares.fermentation_time", () -> BountifulFares.CONFIG.getFermentationTime(),
                    newValue -> BountifulFares.CONFIG.setFermentationTime(newValue), 300, 1, 600),

            Entry.booleanEntry("config.bountifulfares.fruit_replace_when_picked", () -> BountifulFares.CONFIG.isFruitReplaceWhenPicked(),
                    newValue -> BountifulFares.CONFIG.setFruitReplaceWhenPicked(newValue), true),

            Entry.booleanEntry("config.bountifulfares.flour_throwing", () -> BountifulFares.CONFIG.isEnableFlourThrowing(),
                    newValue -> BountifulFares.CONFIG.setEnableFlourThrowing(newValue), true),

            Entry.booleanEntry("config.bountifulfares.lapisberry_seeds", () -> BountifulFares.CONFIG.isEnableLapisberrySeeds(),
                    newValue -> BountifulFares.CONFIG.setEnableLapisberrySeeds(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.hoary_seeds", () -> BountifulFares.CONFIG.isEnableHoarySeeds(),
                    newValue -> BountifulFares.CONFIG.setEnableHoarySeeds(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.spongekin_seeds_elder_guardian", () -> BountifulFares.CONFIG.isEnableElderGuardianSpongekinSeeds(),
                    newValue -> BountifulFares.CONFIG.setEnableElderGuardianSpongekinSeeds(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.spongekin_seeds_guardian", () -> BountifulFares.CONFIG.isEnableGuardianSpongekinSeeds(),
                    newValue -> BountifulFares.CONFIG.setEnableGuardianSpongekinSeeds(newValue), true, "config.bountifulfares.restart_warning")),

    WORLD("config.bountifulfares.category.world", false,
            Entry.booleanEntry("config.bountifulfares.wild_wheat", () -> BountifulFares.CONFIG.isGenerateWildWheat(),
                    newValue -> BountifulFares.CONFIG.setGenerateWildWheat(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.wild_carrots", () -> BountifulFares.CONFIG.isGenerateWildCarrots(),
                    newValue -> BountifulFares.CONFIG.setGenerateWildCarrots(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.wild_potatoes", () -> BountifulFares.CONFIG.isGenerateWildPotatoes(),
                    newValue -> BountifulFares.CONFIG.setGenerateWildPotatoes(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.wild_beetroot", () -> BountifulFares.CONFIG.isGenerateWildBeetroot(),
                    newValue -> BountifulFares.CONFIG.setGenerateWildBeetroot(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.apple_trees", () -> BountifulFares.CONFIG.isGenerateAppleTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateAppleTrees(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.orange_trees", () -> BountifulFares.CONFIG.isGenerateOrangeTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateOrangeTrees(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.lemon_trees", () -> BountifulFares.CONFIG.isGenerateLemonTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateLemonTrees(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.plum_trees", () -> BountifulFares.CONFIG.isGeneratePlumTrees(),
                    newValue -> BountifulFares.CONFIG.setGeneratePlumTrees(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.palm_trees", () -> BountifulFares.CONFIG.isGeneratePalmTrees(),
                    newValue -> BountifulFares.CONFIG.setGeneratePalmTrees(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.flower_forest_fruit_trees", () -> BountifulFares.CONFIG.isGenerateAllFruitTreesInFlowerForest(),
                    newValue -> BountifulFares.CONFIG.setGenerateAllFruitTreesInFlowerForest(newValue), false, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.forest_tea_shrubs", () -> BountifulFares.CONFIG.isGenerateForestTeaShrubs(),
                    newValue -> BountifulFares.CONFIG.setGenerateForestTeaShrubs(newValue), false, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.forest_walnut_trees", () -> BountifulFares.CONFIG.isGenerateForestWalnutTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateForestWalnutTrees(newValue), false, "config.bountifulfares.restart_warning")),

    CLIENT("config.bountifulfares.category.client", false,
            Entry.booleanEntry("config.bountifulfares.restoration_overlay", () -> BountifulFares.CONFIG.isRestorationHeartOverlay(),
                    newValue -> BountifulFares.CONFIG.setRestorationHeartOverlay(newValue), true)),
    MINT("config.bountifulfares.category.mint", true,
            Entry.booleanEntry("config.bountifulfares.honeysuckle_to_banana_dye", () -> BountifulFares.CONFIG.isHoneysuckleToBananaDye(),
                    newValue -> BountifulFares.CONFIG.setHoneysuckleToBananaDye(newValue), true, "config.bountifulfares.restart_warning")),
    DYE_DEPOT("config.bountifulfares.category.dye_depot", true,
            Entry.booleanEntry("config.bountifulfares.rename_items_to_match_dyes", () -> BountifulFares.CONFIG.isRenameItemsToMatchDyes(),
                    newValue -> BountifulFares.CONFIG.setRenameItemsToMatchDyes(newValue), true, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.honeysuckle_to_amber_dye", () -> BountifulFares.CONFIG.isHoneysuckleToAmberDye(),
                    newValue -> BountifulFares.CONFIG.setHoneysuckleToAmberDye(newValue), true, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.chamomile_to_beige_dye", () -> BountifulFares.CONFIG.isChamomileToBeigeDye(),
                    newValue -> BountifulFares.CONFIG.setChamomileToBeigeDye(newValue), true, "config.bountifulfares.restart_warning")),

    COMPAT("config.bountifulfares.category.compat", false, new Category[]{MINT, DYE_DEPOT});


//            Entry.doubl("cuttingBoardFortuneBonus", () -> BountifulFares.CONFIG.getCuttingBoardFortuneBonus(),
//                    newValue -> BountifulFares.CONFIG.setCuttingBoardFortuneBonus(newValue), 0.1, 0.0, 1.0,
//                    "How much of a bonus (in percentage) should each level of Fortune grant to",
//                    "Cutting Board chances? Set it to 0.0 to disable this."),


    private final String text;
    private final Entry<?>[] entries;
    private final Category[] children;
    private final boolean isChild;

    Category(String text, boolean isChild, Entry<?>... entries) {
        this.text = text;
        this.entries = entries;
        this.children = new Category[0];
        this.isChild = isChild;
    }

    Category(String text, boolean isChild, Category[] children, Entry<?>... entries) {
        this.text = text;
        this.entries = entries;
        this.children = children;
        this.isChild = isChild;
    }

    public String text() {
        return text;
    }

    public Entry<?>[] entries() {
        return entries;
    }

    public Category[] children() {
        return children;
    }

    public boolean isChild() {
        return isChild;
    }

}