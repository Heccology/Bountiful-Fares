package net.hecco.bountifulfares.registry.misc;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.trigger.FillTiffinTrigger;
import net.hecco.bountifulfares.definition.trigger.PickFruitInteractionTrigger;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class BFCriteriaTriggers {
    public static final Supplier<CriterionTrigger<?>> PICK_FRUIT = HLServices.REGISTRY.register(BountifulFares.MOD_ID, "pick_fruit", BuiltInRegistries.TRIGGER_TYPES, PickFruitInteractionTrigger::new);
    public static final Supplier<CriterionTrigger<?>> FILL_TIFFIN = HLServices.REGISTRY.register(BountifulFares.MOD_ID, "fill_tiffin", BuiltInRegistries.TRIGGER_TYPES, FillTiffinTrigger::new);

    public static void register() {}
}
