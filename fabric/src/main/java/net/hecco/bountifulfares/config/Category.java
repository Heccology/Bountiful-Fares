package net.hecco.bountifulfares.config;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.FabricBountifulFares;
import net.hecco.bountifulfares.definition.platform.Services;

public enum Category {
    GAMEPLAY("bountifulfares.configuration.category.gameplay", false,
            Entry.integerEntry("bountifulfares.configuration.milling_time", () -> FabricBountifulFares.CONFIG.getIntValue("millingTime"),
                    newValue -> FabricBountifulFares.CONFIG.setIntValue("millingTime", newValue), 4, 1, 10),

            Entry.integerEntry("bountifulfares.configuration.fermentation_time", () -> FabricBountifulFares.CONFIG.getIntValue("fermentationTime"),
                    newValue -> FabricBountifulFares.CONFIG.setIntValue("fermentationTime", newValue), 300, 1, 600),

            Entry.integerEntry("bountifulfares.configuration.infused_candle_radius", () -> FabricBountifulFares.CONFIG.getIntValue("infusedCandleRadius"),
                    newValue -> FabricBountifulFares.CONFIG.setIntValue("infusedCandleRadius", newValue), 3, 0, 16),

            Entry.booleanEntry("bountifulfares.configuration.fruit_replace_when_picked", () -> FabricBountifulFares.CONFIG.getBoolValue("fruitReplaceWhenPicked"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("infusedCandleRadius", newValue), true),

            Entry.booleanEntry("bountifulfares.configuration.flour_throwing", () -> FabricBountifulFares.CONFIG.getBoolValue("flourThrowing"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("flourThrowing", newValue), true),

            Entry.integerEntry("bountifulfares.configuration.flour_throwing_cooldown", () -> FabricBountifulFares.CONFIG.getIntValue("flourThrowingCooldown"),
                    newValue -> FabricBountifulFares.CONFIG.setIntValue("flourThrowingCooldown", newValue), 0, 0, 20),

            Entry.booleanEntry("bountifulfares.configuration.container_foods_eatable_on_dish", () -> FabricBountifulFares.CONFIG.getBoolValue("containerFoodsEatableOnDish"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("containerFoodsEatableOnDish", newValue), false),

            Entry.booleanEntry("bountifulfares.configuration.placeable_pumpkin_pie", () -> FabricBountifulFares.CONFIG.getBoolValue("enablePlaceablePumpkinPie"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("enablePlaceablePumpkinPie", newValue), true, "bountifulfares.configuration.restart_warning"),

            Entry.booleanEntry("bountifulfares.configuration.cake_eating_sounds", () -> FabricBountifulFares.CONFIG.getBoolValue("cakeEatSounds"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("cakeEatSounds", newValue), true),

            Entry.booleanEntry("bountifulfares.configuration.sweet_berry_pips", () -> FabricBountifulFares.CONFIG.getBoolValue("enableSweetBerryPips"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("enableSweetBerryPips", newValue), true, "bountifulfares.configuration.restart_warning"),

            Entry.booleanEntry("bountifulfares.configuration.hoary_seeds", () -> FabricBountifulFares.CONFIG.getBoolValue("enableHoarySeeds"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("enableHoarySeeds", newValue), true, "bountifulfares.configuration.restart_warning"),

            Entry.booleanEntry("bountifulfares.configuration.lapisberry_seeds", () -> FabricBountifulFares.CONFIG.getBoolValue("enableLapisberrySeeds"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("enableLapisberrySeeds", newValue), true, "bountifulfares.configuration.restart_warning"),

            Entry.booleanEntry("bountifulfares.configuration.grass_loot_table_override", () -> FabricBountifulFares.CONFIG.getBoolValue("grassLootTableOverride"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("grassLootTableOverride", newValue), true, "bountifulfares.configuration.restart_warning"),

            Entry.booleanEntry("bountifulfares.configuration.spongekin_seeds_guardian", () -> FabricBountifulFares.CONFIG.getBoolValue("enableGuardianSpongekinSeeds"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("enableGuardianSpongekinSeeds", newValue), true, "bountifulfares.configuration.restart_warning"),

            Entry.booleanEntry("bountifulfares.configuration.show_compat_items_in_recipe_viewers", () -> FabricBountifulFares.CONFIG.getBoolValue("showCompatItemsInRecipeViewers"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("showCompatItemsInRecipeViewers", newValue), true, "bountifulfares.configuration.restart_warning")
    ),

    CLIENT("bountifulfares.configuration.category.client", false,
            Entry.booleanEntry("bountifulfares.configuration.fermentation_bubble_particles", () -> FabricBountifulFares.CONFIG.getBoolValue("fermentationBubbleParticles"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("fermentationBubbleParticles", newValue), true),
            Entry.booleanEntry("bountifulfares.configuration.restoration_overlay", () -> FabricBountifulFares.CONFIG.getBoolValue("restorationHeartOverlay"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("restorationHeartOverlay", newValue), true),
            Entry.booleanEntry("bountifulfares.configuration.acidified_effect_icon_effects", () -> FabricBountifulFares.CONFIG.getBoolValue("acidifiedEffectIconEffects"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("acidifiedEffectIconEffects", newValue), true),
            Entry.booleanEntry("bountifulfares.configuration.effect_tooltips", () -> FabricBountifulFares.CONFIG.getBoolValue("effectTooltips"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("effectTooltips", newValue), true),
            Entry.booleanEntry("bountifulfares.configuration.tiffin_corner_food_icon", () -> FabricBountifulFares.CONFIG.getBoolValue("tiffinCornerFoodIcon"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("tiffinCornerFoodIcon", newValue), false),
            Entry.booleanEntry("bountifulfares.configuration.show_tiffin_food_in_hand", () -> FabricBountifulFares.CONFIG.getBoolValue("showTiffinFoodInHand"),
                    newValue -> FabricBountifulFares.CONFIG.setBoolValue("showTiffinFoodInHand", newValue), false)
    )
    ;
//    MINT("bountifulfares.configuration.category.mint", true,
//            Entry.booleanEntry("bountifulfares.configuration.honeysuckle_to_banana_dye", () -> FabricBountifulFares.CONFIG.isHoneysuckleToBananaDye(),
//                    newValue -> FabricBountifulFares.CONFIG.setHoneysuckleToBananaDye(newValue), true, "bountifulfares.configuration.restart_warning")),
//    DYE_DEPOT("bountifulfares.configuration.category.dye_depot", true,
//            Entry.booleanEntry("bountifulfares.configuration.rename_items_to_match_dyes", () -> FabricBountifulFares.CONFIG.isRenameItemsToMatchDyes(),
//                    newValue -> FabricBountifulFares.CONFIG.setRenameItemsToMatchDyes(newValue), true, "bountifulfares.configuration.restart_warning"),
//            Entry.booleanEntry("bountifulfares.configuration.honeysuckle_to_amber_dye", () -> FabricBountifulFares.CONFIG.isHoneysuckleToAmberDye(),
//                    newValue -> FabricBountifulFares.CONFIG.setHoneysuckleToAmberDye(newValue), true, "bountifulfares.configuration.restart_warning"),
//            Entry.booleanEntry("bountifulfares.configuration.chamomile_to_beige_dye", () -> FabricBountifulFares.CONFIG.isChamomileToBeigeDye(),
//                    newValue -> FabricBountifulFares.CONFIG.setChamomileToBeigeDye(newValue), true, "bountifulfares.configuration.restart_warning")),
//
//    COMPAT("bountifulfares.configuration.category.compat", false, new Category[]{MINT, DYE_DEPOT});


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