package net.hecco.bountifulfares.config;

import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.hecco.bountifulfares.BountifulFares;
import oshi.util.tuples.Pair;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FabricBFConfig {

    public final List<LimitedIntValue> INT_CONFIGS = List.of(
            new LimitedIntValue("millingTime", 4, 1, 10),
            new LimitedIntValue("fermentationTime", 300, 1, 600),
            new LimitedIntValue("infusedCandleRadius", 3, 1, 16),
            new LimitedIntValue("flourThrowingCooldown", 0, 0, 20)
    );

    public final List<Pair<String, Boolean>> BOOL_CONFIGS = new ArrayList<>(List.of(
            new Pair<>("fruitReplaceWhenPicked", true),
            new Pair<>("enableFlourThrowing", true),
            new Pair<>("containerFoodsEatableOnDish", false),
            new Pair<>("enablePlaceablePumpkinPie", true),
            new Pair<>("cakeEatSounds", true),
            new Pair<>("enableSweetBerryPips", true),
            new Pair<>("enableHoarySeeds", true),
            new Pair<>("enableLapisberrySeeds", true),
            new Pair<>("grassLootTableOverride", true),
            new Pair<>("enableGuardianSpongekinSeeds", true),
            new Pair<>("showCompatItemsInRecipeViewers", true),
            new Pair<>("fermentationBubbleParticles", true),
            new Pair<>("restorationHeartOverlay", true),
            new Pair<>("acidifiedEffectIconEffects", true),
            new Pair<>("effectTooltips", true),
            new Pair<>("tiffinCornerFoodIcon", false),
            new Pair<>("showTiffinFoodInHand", false)
    ));

    public static class LimitedIntValue {
        private final String id;
        private int value;
        private final int min;
        private final int max;
        public LimitedIntValue(String id, int value, int min, int max) {
            this.id = id;
            this.value = value;
            this.min = min;
            this.max = max;
        }
        public String id() {
            return this.id;
        }
        public int value() {
            return this.value;
        }
        public void setValue(int i) {
            value = Math.clamp(i, min, max);
        }
    }

    public boolean getBoolValue(String id) {
        return BOOL_CONFIGS.stream().filter(pair -> Objects.equals(pair.getA(), id)).map(Pair::getB).findFirst().orElse(false);
    }

    public int getIntValue(String id) {
        return INT_CONFIGS.stream().filter(value -> Objects.equals(value.id(), id)).map(LimitedIntValue::value).findFirst().orElse(0);
    }

    public void setIntValue(String id, int value) {
        LimitedIntValue i = INT_CONFIGS.stream().filter((j) -> Objects.equals(j.id, id)).toList().getFirst();
        i.setValue(value);
    }

    public void setBoolValue(String id, boolean value) {
        for (int index = 0; index < BOOL_CONFIGS.size(); index++) {
            Pair<String, Boolean> pair = BOOL_CONFIGS.get(index);
            if (Objects.equals(pair.getA(), id)) {
                BOOL_CONFIGS.set(index, new Pair<>(pair.getA(), value));
                return;
            }
        }
    }


    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "bountifulfares.json");

    public static FabricBFConfig load() {
        FabricBFConfig configuration = new FabricBFConfig();
        if (!CONFIG_FILE.exists()) {
            save(configuration);
        }

        Reader reader;
        try {
            reader = Files.newBufferedReader(CONFIG_FILE.toPath());
            configuration = (new GsonBuilder().setPrettyPrinting().create()).fromJson(reader, FabricBFConfig.class);
            reader.close();
        } catch (IOException e) {
            BountifulFares.LOGGER.error("Error while trying to load configuration file. Default configuration used.", e);
        }

        return configuration;
    }

    public static void save(FabricBFConfig config) {
        try {
            Writer writer = Files.newBufferedWriter(CONFIG_FILE.toPath());
            (new GsonBuilder().setPrettyPrinting().create()).toJson(config, writer);

            writer.close();
        } catch (IOException e) {
            BountifulFares.LOGGER.error("Error while trying to save configuration file.", e);
        }
    }
}
