package net.hecco.bountifulfares.data.trellis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.TrellisBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Items;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TrellisPlantResourceLoader extends SimpleJsonResourceReloadListener {

    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private final Map<ResourceLocation, TrellisPlantDefinition> registeredPlants = new HashMap<>();
    public TrellisPlantResourceLoader() {
        super(GSON, "bountifulfares/trellis_plant");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> resourceLocationJsonElementMap, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        registeredPlants.clear();
        for (var entry : resourceLocationJsonElementMap.entrySet()) {
            ResourceLocation id = entry.getKey();
            try {
                TrellisPlantDefinition def = TrellisPlantDefinition.CODEC.parse(JsonOps.INSTANCE, entry.getValue()).getOrThrow();
                if (def.plant() == Items.AIR) {
                    throw new NullPointerException("Plant item was not found");
                } else {
                    registeredPlants.put(id, def);
                }
            } catch (Exception e) {
                BountifulFares.LOGGER.error("Failed to load trellis plant '{}'", id, e);
            }
        }
        for (TrellisPlantDefinition plantDefinition : registeredPlants.values().stream().toList()) {
            BountifulFares.LOGGER.info(plantDefinition + "");
            TrellisBlock.PLANTS.put(plantDefinition.plant(), plantDefinition);
        }
    }

    public Collection<TrellisPlantDefinition> getAllTrellisPlants() {
        return this.registeredPlants.values();
    }
}
