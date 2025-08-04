package net.hecco.bountifulfares.definition.data.grass_seeds;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.item.custom.GrassSeedsItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GrassSeedsInteractionResourceLoader extends SimpleJsonResourceReloadListener {

    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    private final Map<ResourceLocation, GrassSeedsInteractionDefinition> definitions = new HashMap<>();
    public GrassSeedsInteractionResourceLoader() {
        super(GSON, "bountifulfares/grass_seeds_interaction");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> resourceLocationJsonElementMap, ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        definitions.clear();
        for (var entry : resourceLocationJsonElementMap.entrySet()) {
            ResourceLocation id = entry.getKey();
            try {
                GrassSeedsInteractionDefinition def = GrassSeedsInteractionDefinition.CODEC.parse(JsonOps.INSTANCE, entry.getValue()).getOrThrow();
                if (def.soil() == null) {
                    throw new NullPointerException("Soil was not found");
                }
                if (def.result() == null) {
                    throw new NullPointerException("Result was not found");
                } else {
                    definitions.put(id, def);
                }
            } catch (Exception e) {
                BountifulFares.LOGGER.error("Failed to load grass seeds interaction '{}'", id, e);
            }
        }
        for (GrassSeedsInteractionDefinition definition : definitions.values().stream().toList()) {
            GrassSeedsItem.INTERACTIONS.add(Triple.of(definition.soil(), definition.result(), definition.onTop()));
        }
    }

    public Collection<GrassSeedsInteractionDefinition> getAllDefinitions() {
        return this.definitions.values();
    }
}
