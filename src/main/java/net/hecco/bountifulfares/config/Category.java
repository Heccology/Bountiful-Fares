package net.hecco.bountifulfares.config;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.hecco.bountifulfares.BountifulFares;

@Environment(value= EnvType.CLIENT)
public enum Category {

    SETTINGS("Settings", false,
            Entry.booleanEntry("config.bountifulfares.wild_vanilla_crops", () -> BountifulFares.CONFIG.isGenerateVanillaWildCrops(),
                newValue -> BountifulFares.CONFIG.setGenerateVanillaWildCrops(newValue), true, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.apple_trees", () -> BountifulFares.CONFIG.isGenerateAppleTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateAppleTrees(newValue), true, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.orange_trees", () -> BountifulFares.CONFIG.isGenerateOrangeTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateOrangeTrees(newValue), true, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.lemon_trees", () -> BountifulFares.CONFIG.isGenerateLemonTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateLemonTrees(newValue), true, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.plum_trees", () -> BountifulFares.CONFIG.isGeneratePlumTrees(),
                    newValue -> BountifulFares.CONFIG.setGeneratePlumTrees(newValue), true, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.flower_forest_fruit_trees", () -> BountifulFares.CONFIG.isGenerateAllFruitTreesInFlowerForest(),
                    newValue -> BountifulFares.CONFIG.setGenerateAllFruitTreesInFlowerForest(newValue), false, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.forest_tea_shrubs", () -> BountifulFares.CONFIG.isGenerateForestTeaShrubs(),
                    newValue -> BountifulFares.CONFIG.setGenerateForestTeaShrubs(newValue), false, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.forest_walnut_trees", () -> BountifulFares.CONFIG.isGenerateForestWalnutTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateForestWalnutTrees(newValue), false, "config.bountifulfares.restart_warning"),
            Entry.booleanEntry("config.bountifulfares.item_guide_tooltips", () -> BountifulFares.CONFIG.isEnableItemGuideTooltips(),
                    newValue -> BountifulFares.CONFIG.setEnableItemGuideTooltips(newValue), true),
            Entry.booleanEntry("config.bountifulfares.bountiful_painting", () -> BountifulFares.CONFIG.isEnableBountifulPainting(),
                    newValue -> BountifulFares.CONFIG.setEnableBountifulPainting(newValue), true, "config.bountifulfares.restart_warning"));



//            Entry.doubl("richSoilBoostChance", () -> BountifulFares.CONFIG.getRichSoilBoostChance(),
//                    newValue -> BountifulFares.CONFIG.setRichSoilBoostChance(newValue), 0.2, 0.0, 1.0,
//                    "How often (in percentage) should Rich Soil succeed in boosting a plant's",
//                    "growth at each random tick? Set it to 0.0 to disable this."),
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