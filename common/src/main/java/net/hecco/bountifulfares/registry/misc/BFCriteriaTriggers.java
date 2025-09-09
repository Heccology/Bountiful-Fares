package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.trigger.*;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class BFCriteriaTriggers {
    public static final Supplier<CriterionTrigger<?>> PICK_FRUIT = NLServices.REGISTRY.register(BountifulFares.MOD_ID, "pick_fruit", BuiltInRegistries.TRIGGER_TYPES, PickFruitInteractionTrigger::new);
    public static final Supplier<CriterionTrigger<?>> FILL_TIFFIN = NLServices.REGISTRY.register(BountifulFares.MOD_ID, "fill_tiffin", BuiltInRegistries.TRIGGER_TYPES, FillTiffinTrigger::new);
    public static final Supplier<CriterionTrigger<?>> PLANT_ON_TRELLIS = NLServices.REGISTRY.register(BountifulFares.MOD_ID, "plant_on_trellis", BuiltInRegistries.TRIGGER_TYPES, PlantOnTrellisTrigger::new);
    public static final Supplier<CriterionTrigger<?>> USE_ARTISAN_BRUSH_IN_INVENTORY = NLServices.REGISTRY.register(BountifulFares.MOD_ID, "use_artisan_brush_in_inventory", BuiltInRegistries.TRIGGER_TYPES, UseArtisanBrushInInventoryTrigger::new);
    public static final Supplier<CriterionTrigger<?>> ACIDIFY_EFFECT = NLServices.REGISTRY.register(BountifulFares.MOD_ID, "acidify_effect", BuiltInRegistries.TRIGGER_TYPES, AcidifyEffectTrigger::new);

    public static void register() {}
}
