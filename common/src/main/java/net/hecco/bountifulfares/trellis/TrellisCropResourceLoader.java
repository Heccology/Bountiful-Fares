package net.hecco.bountifulfares.trellis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.NewTrellisBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Items;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TrellisCropResourceLoader extends SimpleJsonResourceReloadListener {

    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private final Map<ResourceLocation, TrellisCropDefinition> registeredPlants = new HashMap<>();
    public TrellisCropResourceLoader() {
        super(GSON, "bountifulfares/trellis_crop");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> resourceLocationJsonElementMap, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        registeredPlants.clear();
        for (var entry : resourceLocationJsonElementMap.entrySet()) {
            ResourceLocation id = entry.getKey();
            try {
                TrellisCropDefinition def = TrellisCropDefinition.CODEC.parse(JsonOps.INSTANCE, entry.getValue()).getOrThrow();
                if (def.seeds() == Items.AIR) {
                    throw new NullPointerException("Seeds item was not found");
                } else if (def.produce() == Items.AIR) {
                    throw new NullPointerException("Produce item was not found");
                } else {
                    registeredPlants.put(id, def);
                }
            } catch (Exception e) {
                BountifulFares.LOGGER.error("Failed to load trellis crop '{}'", id, e);
            }
        }
        for (TrellisCropDefinition cropDefinition : registeredPlants.values().stream().toList()) {
            NewTrellisBlock.CROPS.put(cropDefinition.seeds(), cropDefinition);
        }
    }

    public Collection<TrellisCropDefinition> getAllTrellisCrops() {
        return this.registeredPlants.values();
    }
}
