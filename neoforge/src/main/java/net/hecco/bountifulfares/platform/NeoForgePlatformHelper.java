package net.hecco.bountifulfares.platform;

import net.hecco.bountifulfares.config.NeoForgeBFConfig;
import net.hecco.bountifulfares.definition.platform.services.IPlatformHelper;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.Map;
import java.util.Objects;

public class NeoForgePlatformHelper implements IPlatformHelper {


    @Override
    public boolean getBoolConfigValue(String id) {
        return (boolean) NeoForgeBFConfig.VALUES.entrySet().stream().filter((entry) -> Objects.equals(entry.getKey(), id)).map(Map.Entry::getValue).map(ModConfigSpec.ConfigValue::get).toList().getFirst();
    }

    @Override
    public int getIntConfigValue(String id) {
        return (int) NeoForgeBFConfig.VALUES.entrySet().stream().filter((entry) -> Objects.equals(entry.getKey(), id)).map(Map.Entry::getValue).map(ModConfigSpec.ConfigValue::get).toList().getFirst();
    }
}