package net.hecco.bountifulfares.config;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.hecco.bountifulfares.BountifulFares;

@Environment(value= EnvType.CLIENT)
public enum Category {
    GAMEPLAY("config.bountifulfares.category.gameplay", false,
            Entry.integerEntry("config.bountifulfares.milling_time", () -> BountifulFares.CONFIG.getMillingTime(),
                    newValue -> BountifulFares.CONFIG.setMillingTime(newValue), 4, 1, 10),

            Entry.integerEntry("config.bountifulfares.fermentation_time", () -> BountifulFares.CONFIG.getFermentationTime(),
                    newValue -> BountifulFares.CONFIG.setFermentationTime(newValue), 300, 1, 600),

            Entry.integerEntry("config.bountifulfares.infused_candle_radius", () -> BountifulFares.CONFIG.getInfusedCandleRadius(),
                    newValue -> BountifulFares.CONFIG.setInfusedCandleRadius(newValue), 3, 0, 16),

            Entry.booleanEntry("config.bountifulfares.fruit_replace_when_picked", () -> BountifulFares.CONFIG.isFruitReplaceWhenPicked(),
                    newValue -> BountifulFares.CONFIG.setFruitReplaceWhenPicked(newValue), true),

            Entry.booleanEntry("config.bountifulfares.flour_throwing", () -> BountifulFares.CONFIG.isEnableFlourThrowing(),
                    newValue -> BountifulFares.CONFIG.setEnableFlourThrowing(newValue), true),

            Entry.integerEntry("config.bountifulfares.flour_throwing_cooldown", () -> BountifulFares.CONFIG.getFlourThrowingCooldown(),
                    newValue -> BountifulFares.CONFIG.setFlourThrowingCooldown(newValue), 0, 0, 20),

            Entry.booleanEntry("config.bountifulfares.container_foods_eatable_on_dish", () -> BountifulFares.CONFIG.isContainerFoodsEatableOnDish(),
                    newValue -> BountifulFares.CONFIG.setContainerFoodsEatableOnDish(newValue), false),

            Entry.booleanEntry("config.bountifulfares.sweet_berry_pips", () -> BountifulFares.CONFIG.enableSweetBerryPips,
                    newValue -> BountifulFares.CONFIG.enableSweetBerryPips = newValue, true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.hoary_seeds", () -> BountifulFares.CONFIG.isEnableHoarySeeds(),
                    newValue -> BountifulFares.CONFIG.setEnableHoarySeeds(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.lapisberry_seeds", () -> BountifulFares.CONFIG.isEnableLapisberrySeeds(),
                    newValue -> BountifulFares.CONFIG.setEnableLapisberrySeeds(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.grass_loot_table_override", () -> BountifulFares.CONFIG.isGrassLootTableOverride(),
                    newValue -> BountifulFares.CONFIG.setGrassLootTableOverride(newValue), true, "config.bountifulfares.restart_warning"),

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

            Entry.booleanEntry("config.bountifulfares.wild_leeks", () -> BountifulFares.CONFIG.generateWildLeeks,
                    newValue -> BountifulFares.CONFIG.generateWildLeeks = newValue, true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.wild_maize", () -> BountifulFares.CONFIG.generateWildMaize,
                    newValue -> BountifulFares.CONFIG.generateWildMaize = newValue, true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.wild_passion_fruit", () -> BountifulFares.CONFIG.generateWildPassionFruit,
                    newValue -> BountifulFares.CONFIG.generateWildPassionFruit = newValue, true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.wild_elderberries", () -> BountifulFares.CONFIG.generateWildElderberries,
                    newValue -> BountifulFares.CONFIG.generateWildElderberries = newValue, true, "config.bountifulfares.restart_warning"),

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

            Entry.booleanEntry("config.bountifulfares.golden_apple_tree_rooms", () -> BountifulFares.CONFIG.isGenerateGoldenAppleTreeRooms(),
                    newValue -> BountifulFares.CONFIG.setGenerateGoldenAppleTreeRooms(newValue), true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.grassy_dirt_patches", () -> BountifulFares.CONFIG.generateGrassyDirtPatches,
                    newValue -> BountifulFares.CONFIG.generateGrassyDirtPatches = newValue, true, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.flower_forest_fruit_trees", () -> BountifulFares.CONFIG.isGenerateAllFruitTreesInFlowerForest(),
                    newValue -> BountifulFares.CONFIG.setGenerateAllFruitTreesInFlowerForest(newValue), false, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.forest_tea_shrubs", () -> BountifulFares.CONFIG.isGenerateForestTeaShrubs(),
                    newValue -> BountifulFares.CONFIG.setGenerateForestTeaShrubs(newValue), false, "config.bountifulfares.restart_warning"),

            Entry.booleanEntry("config.bountifulfares.forest_walnut_trees", () -> BountifulFares.CONFIG.isGenerateForestWalnutTrees(),
                    newValue -> BountifulFares.CONFIG.setGenerateForestWalnutTrees(newValue), false, "config.bountifulfares.restart_warning")
    ),

    CLIENT("config.bountifulfares.category.client", false,
            Entry.booleanEntry("config.bountifulfares.fermentation_bubble_particles", () -> BountifulFares.CONFIG.isFermentationBubbleParticles(),
                    newValue -> BountifulFares.CONFIG.setFermentationBubbleParticles(newValue), true),
            Entry.booleanEntry("config.bountifulfares.restoration_overlay", () -> BountifulFares.CONFIG.isRestorationHeartOverlay(),
                    newValue -> BountifulFares.CONFIG.setRestorationHeartOverlay(newValue), true),
            Entry.booleanEntry("config.bountifulfares.acidified_effect_icon_effects", () -> BountifulFares.CONFIG.isAcidifiedEffectIconEffects(),
                    newValue -> BountifulFares.CONFIG.setAcidifiedEffectIconEffects(newValue), true),
            Entry.booleanEntry("config.bountifulfares.effect_tooltips", () -> BountifulFares.CONFIG.effectTooltips,
                    newValue -> BountifulFares.CONFIG.effectTooltips = newValue, true)
    )
    ;
//    MINT("config.bountifulfares.category.mint", true,
//            Entry.booleanEntry("config.bountifulfares.honeysuckle_to_banana_dye", () -> BountifulFares.CONFIG.isHoneysuckleToBananaDye(),
//                    newValue -> BountifulFares.CONFIG.setHoneysuckleToBananaDye(newValue), true, "config.bountifulfares.restart_warning")),
//    DYE_DEPOT("config.bountifulfares.category.dye_depot", true,
//            Entry.booleanEntry("config.bountifulfares.rename_items_to_match_dyes", () -> BountifulFares.CONFIG.isRenameItemsToMatchDyes(),
//                    newValue -> BountifulFares.CONFIG.setRenameItemsToMatchDyes(newValue), true, "config.bountifulfares.restart_warning"),
//            Entry.booleanEntry("config.bountifulfares.honeysuckle_to_amber_dye", () -> BountifulFares.CONFIG.isHoneysuckleToAmberDye(),
//                    newValue -> BountifulFares.CONFIG.setHoneysuckleToAmberDye(newValue), true, "config.bountifulfares.restart_warning"),
//            Entry.booleanEntry("config.bountifulfares.chamomile_to_beige_dye", () -> BountifulFares.CONFIG.isChamomileToBeigeDye(),
//                    newValue -> BountifulFares.CONFIG.setChamomileToBeigeDye(newValue), true, "config.bountifulfares.restart_warning")),
//
//    COMPAT("config.bountifulfares.category.compat", false, new Category[]{MINT, DYE_DEPOT});


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