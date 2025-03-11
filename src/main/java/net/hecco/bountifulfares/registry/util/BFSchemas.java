package net.hecco.bountifulfares.registry.util;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import net.minecraft.datafixer.fix.ItemNameFix;
import net.minecraft.datafixer.schema.IdentifierNormalizingSchema;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

//public class BFSchemas {
//    private static final BiFunction<Integer, Schema, Schema> EMPTY_IDENTIFIER_NORMALIZE = IdentifierNormalizingSchema::new;
//
//    public static void build(DataFixerBuilder builder) {
//        Schema schema55 = builder.addSchema(2020202020, EMPTY_IDENTIFIER_NORMALIZE);
//        builder.addFixer(ItemNameFix.create(schema55, "Rename jar items", replacing(ImmutableMap.of("bountifulfares:jar", "bountifulfares:cup"))));
//    }
//
//    private static UnaryOperator<String> replacing(Map<String, String> replacements) {
//        return (string) -> (String)replacements.getOrDefault(IdentifierNormalizingSchema.normalize(string), string);
//    }
//}
