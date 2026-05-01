package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.trigger.*;
import net.hecco.nexuslib.platform.NLServices;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class BFCriteriaTriggers {
    public static final Supplier<CriterionTrigger<?>> PICK_FRUIT =  register( "pick_fruit", PickFruitInteractionTrigger::new);
    public static final Supplier<CriterionTrigger<?>> FILL_TIFFIN = register("fill_tiffin", FillTiffinTrigger::new);
    public static final Supplier<CriterionTrigger<?>> CRAFT_FOOD_IN_TIFFIN = register("craft_food_in_tiffin", CraftFoodInTiffinTrigger::new);
    public static final Supplier<CriterionTrigger<?>> PLANT_ON_TRELLIS = register("plant_on_trellis", PlantOnTrellisTrigger::new);
    public static final Supplier<CriterionTrigger<?>> USE_ARTISAN_BRUSH_IN_INVENTORY = register("use_artisan_brush_in_inventory", UseArtisanBrushInInventoryTrigger::new);
    public static final Supplier<CriterionTrigger<?>> ACIDIFY_EFFECT = register("acidify_effect", AcidifyEffectTrigger::new);

    private static Supplier<CriterionTrigger<?>> register(String name, Supplier<CriterionTrigger<?>> supplier) {
        return NLServices.REGISTRY.register(BountifulFares.MOD_ID, name,
                                            BuiltInRegistries.TRIGGER_TYPES, supplier);
    }

    public static void registerCriteriaTriggers() {

    }
}
