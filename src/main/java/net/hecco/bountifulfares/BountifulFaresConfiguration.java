package net.hecco.bountifulfares;

import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;

public class BountifulFaresConfiguration {

    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "bountifulfares.json");

//    private boolean enableItemGuideTooltips = true;
    private boolean fruitReplaceWhenPicked = true;
    private boolean enableFlourThrowing = true;
    private int flourThrowingCooldown = 0;
    private boolean containerFoodsEatableOnDish = false;
    private boolean restorationHeartOverlay = true;
    private boolean acidifiedEffectIconEffects = true;
    private boolean fermentationBubbleParticles = true;
    public boolean effectTooltips = true;
    public boolean enableSweetBerryPips = true;
    private boolean enableLapisberrySeeds = true;
    private boolean enableHoarySeeds = true;
    public boolean grassLootTableOverride = true;
    private boolean enableElderGuardianSpongekinSeeds = true;
    private boolean enableGuardianSpongekinSeeds = true;
    private boolean generateWildWheat = true;
    private boolean generateWildCarrots = true;
    private boolean generateWildPotatoes = true;
    private boolean generateWildBeetroot = true;
    public boolean generateWildLeeks = true;
    public boolean generateWildMaize = true;
    private boolean generateAppleTrees = true;
    private boolean generateOrangeTrees = true;
    private boolean generateLemonTrees = true;
    private boolean generatePlumTrees = true;
    private boolean generatePalmTrees = true;
    public boolean generateWildPassionFruit = true;
    public boolean generateWildElderberries = true;
    public boolean generateGrassyDirtPatches = true;
    private boolean generateAllFruitTreesInFlowerForest = false;
    private boolean generateForestTeaShrubs = false;
    private boolean generateForestWalnutTrees = false;
    private boolean generateGoldenAppleTreeRooms = true;
    private int fermentationTime = 300;
    private int millingTime = 4;
    private int infusedCandleRadius = 3;
////  mint
//    private boolean honeysuckleToBananaDye = true;
////  dye_depot
//    private boolean renameItemsToMatchDyes = true;
//    private boolean honeysuckleToAmberDye = true;
//    private boolean chamomileToBeigeDye = true;



    public BountifulFaresConfiguration() {
    }

    public static BountifulFaresConfiguration load() {
        BountifulFaresConfiguration configuration = new BountifulFaresConfiguration();
        if (!CONFIG_FILE.exists()) {
            save(configuration);
        }

        Reader reader;
        try {
            reader = Files.newBufferedReader(CONFIG_FILE.toPath());
            configuration = (new GsonBuilder().setPrettyPrinting().create()).fromJson(reader, BountifulFaresConfiguration.class);
            reader.close();
        } catch (IOException e) {
            BountifulFares.LOGGER.error("Error while trying to load configuration file. Default configuration used.", e);
        }

        return configuration;
    }

    public static void save(BountifulFaresConfiguration config) {
        try {
            Writer writer = Files.newBufferedWriter(CONFIG_FILE.toPath());
            (new GsonBuilder().setPrettyPrinting().create()).toJson(config, writer);

            writer.close();
        } catch (IOException e) {
            BountifulFares.LOGGER.error("Error while trying to save configuration file.", e);
        }
    }

//    public boolean isEnableItemGuideTooltips() {
//        return enableItemGuideTooltips;
//    }
//
//    public void setEnableItemGuideTooltips(boolean bool) {
//        enableItemGuideTooltips = bool;
//    }

    public boolean isFruitReplaceWhenPicked() {
        return fruitReplaceWhenPicked;
    }

    public void setFruitReplaceWhenPicked(boolean bool) {
        fruitReplaceWhenPicked = bool;
    }

    public boolean isContainerFoodsEatableOnDish() {
        return containerFoodsEatableOnDish;
    }

    public void setContainerFoodsEatableOnDish(boolean bool) {
        containerFoodsEatableOnDish = bool;
    }

    public boolean isRestorationHeartOverlay() {
        return restorationHeartOverlay;
    }

    public void setRestorationHeartOverlay(boolean bool) {
        restorationHeartOverlay = bool;
    }

    public boolean isAcidifiedEffectIconEffects() {
        return acidifiedEffectIconEffects;
    }

    public void setAcidifiedEffectIconEffects(boolean bool) {
        acidifiedEffectIconEffects = bool;
    }

    public boolean isFermentationBubbleParticles() {
        return fermentationBubbleParticles;
    }

    public void setFermentationBubbleParticles(boolean bool) {
        fermentationBubbleParticles = bool;
    }

    public boolean isEnableFlourThrowing() {
        return enableFlourThrowing;
    }

    public void setEnableFlourThrowing(boolean bool) {
        enableFlourThrowing = bool;
    }

    public int getFlourThrowingCooldown() {
        return flourThrowingCooldown;
    }

    public void setFlourThrowingCooldown(int value) {
        flourThrowingCooldown = limit(0, 20, value);
    }

    public boolean isEnableLapisberrySeeds() {
        return enableLapisberrySeeds;
    }

    public void setEnableLapisberrySeeds(boolean bool) {
        enableLapisberrySeeds = bool;
    }

    public boolean isEnableHoarySeeds() {
        return enableHoarySeeds;
    }

    public void setEnableHoarySeeds(boolean bool) {
        enableHoarySeeds = bool;
    }

    public boolean isGrassLootTableOverride() {
        return grassLootTableOverride;
    }

    public void setGrassLootTableOverride(boolean bool) {
        grassLootTableOverride = bool;
    }

    public boolean isEnableElderGuardianSpongekinSeeds() {
        return enableElderGuardianSpongekinSeeds;
    }

    public void setEnableElderGuardianSpongekinSeeds(boolean bool) {
        enableElderGuardianSpongekinSeeds = bool;
    }

    public boolean isEnableGuardianSpongekinSeeds() {
        return enableGuardianSpongekinSeeds;
    }

    public void setEnableGuardianSpongekinSeeds(boolean bool) {
        enableGuardianSpongekinSeeds = bool;
    }

    public boolean isGenerateWildWheat() {
        return generateWildWheat;
    }

    public void setGenerateWildWheat(boolean bool) {
        generateWildWheat = bool;
    }

    public boolean isGenerateWildCarrots() {
        return generateWildCarrots;
    }

    public void setGenerateWildCarrots(boolean bool) {
        generateWildCarrots = bool;
    }

    public boolean isGenerateWildPotatoes() {
        return generateWildPotatoes;
    }

    public void setGenerateWildPotatoes(boolean bool) {
        generateWildPotatoes = bool;
    }

    public boolean isGenerateWildBeetroot() {
        return generateWildBeetroot;
    }

    public void setGenerateWildBeetroot(boolean bool) {
        generateWildBeetroot = bool;
    }

    public boolean isGenerateAppleTrees() {
        return generateAppleTrees;
    }

    public void setGenerateAppleTrees(boolean bool) {
        generateAppleTrees = bool;
    }

    public boolean isGenerateOrangeTrees() {
        return generateOrangeTrees;
    }

    public void setGenerateOrangeTrees(boolean bool) {
        generateOrangeTrees = bool;
    }

    public boolean isGenerateLemonTrees() {
        return generateLemonTrees;
    }

    public void setGenerateLemonTrees(boolean bool) {
        generateLemonTrees = bool;
    }

    public boolean isGeneratePlumTrees() {
        return generatePlumTrees;
    }

    public void setGeneratePlumTrees(boolean bool) {
        generatePlumTrees = bool;
    }

    public boolean isGeneratePalmTrees() {
        return generatePalmTrees;
    }

    public void setGeneratePalmTrees(boolean bool) {
        generatePalmTrees = bool;
    }

    public boolean isGenerateAllFruitTreesInFlowerForest() {
        return generateAllFruitTreesInFlowerForest;
    }

    public void setGenerateAllFruitTreesInFlowerForest(boolean bool) {
        generateAllFruitTreesInFlowerForest = bool;
    }

    public boolean isGenerateForestTeaShrubs() {
        return generateForestTeaShrubs;
    }

    public void setGenerateForestTeaShrubs(boolean bool) {
        generateForestTeaShrubs = bool;
    }

    public boolean isGenerateForestWalnutTrees() {
        return generateForestWalnutTrees;
    }

    public void setGenerateForestWalnutTrees(boolean bool) {
        generateForestWalnutTrees = bool;
    }

    public boolean isGenerateGoldenAppleTreeRooms() {
        return generateGoldenAppleTreeRooms;
    }

    public void setGenerateGoldenAppleTreeRooms(boolean bool) {
        generateGoldenAppleTreeRooms = bool;
    }

    public int getFermentationTime() {
        return fermentationTime;
    }

    public void setFermentationTime(int value) {
        fermentationTime = limit(1, 600, value);
    }

    public int getMillingTime() {
        return millingTime;
    }

    public void setMillingTime(int value) {
        millingTime = limit(1, 10, value);
    }

    public int getInfusedCandleRadius() {
        return infusedCandleRadius;
    }

    public void setInfusedCandleRadius(int value) {
        infusedCandleRadius = limit(0, 16, value);
    }


//    public boolean isHoneysuckleToBananaDye() {
//        return honeysuckleToBananaDye;
//    }
//
//    public void setHoneysuckleToBananaDye(boolean bool) {
//        honeysuckleToBananaDye = bool;
//    }
//
//    public boolean isRenameItemsToMatchDyes() {
//        return renameItemsToMatchDyes;
//    }
//
//    public void setRenameItemsToMatchDyes(boolean bool) {
//        renameItemsToMatchDyes = bool;
//    }
//
//    public boolean isHoneysuckleToAmberDye() {
//        return honeysuckleToAmberDye;
//    }
//
//    public void setHoneysuckleToAmberDye(boolean bool) {
//        honeysuckleToAmberDye = bool;
//    }
//
//    public boolean isChamomileToBeigeDye() {
//        return chamomileToBeigeDye;
//    }
//
//    public void setChamomileToBeigeDye(boolean bool) {
//        chamomileToBeigeDye = bool;
//    }


    private static double limit(double min, double max, double value) {
        if (value > max) {
            return max;
        }

        return Math.max(value, min);
    }

    private static int limit(int min, int max, int value) {
        if (value > max) {
            return max;
        }

        return Math.max(value, min);
    }
}
