package net.hecco.bountifulfares;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.*;
import java.util.function.Supplier;

public class BountifulFaresUtil {
    public static final List<String> WOOD_TYPES = new ArrayList<>(List.of("oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "bamboo", "walnut", "hoary", "crimson", "warped"));
    public static Set<ResourceLocation> allBlockIdsInNamespace(String namespace) {
        Set<ResourceLocation> set = BuiltInRegistries.BLOCK.keySet();
        Set<ResourceLocation> a = new HashSet<>();
        for(ResourceLocation id : set) {
            if(Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }

    public static Set<ResourceLocation> allCompatBlockIds() {
        Set<ResourceLocation> set = BuiltInRegistries.ITEM.keySet();
        Set<ResourceLocation> a = new HashSet<>();
        for(ResourceLocation id : set) {
            Supplier<?> i = () -> BuiltInRegistries.BLOCK.get(id);
            if (BountifulFares.COMPAT_MANAGER.CONTENT_TO_INTEGRATION.containsKey(i.get())) {
                a.add(id);
            }
        }
        return a;
    }

    public static Set<ResourceLocation> allCompatItemIds() {
        Set<ResourceLocation> set = BuiltInRegistries.ITEM.keySet();
        Set<ResourceLocation> a = new HashSet<>();
        for(ResourceLocation id : set) {
            Supplier<?> i = () -> BuiltInRegistries.ITEM.get(id);
            if (BountifulFares.COMPAT_MANAGER.CONTENT_TO_INTEGRATION.containsKey(i.get())) {
                a.add(id);
            }
        }
        return a;
    }

    public static Set<ResourceLocation> allItemIdsInNamespace(String namespace) {
        Set<ResourceLocation> set = BuiltInRegistries.ITEM.keySet();
        Set<ResourceLocation> a = new HashSet<>();
        for(ResourceLocation id : set) {
            if(Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }

    public static String toSentenceCase(String s) {
        String words[] = s.split("[\\s|_]");
        StringBuilder capitalizeWord = new StringBuilder();
        for(String w : words){
            String first = w.substring(0,1);
            String afterfirst = w.substring(1);
            capitalizeWord
                    .append(first.toUpperCase())
                    .append(afterfirst)
                    .append(" ");
        }
        return capitalizeWord.toString().trim();
    }
}
