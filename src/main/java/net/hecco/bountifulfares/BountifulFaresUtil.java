package net.hecco.bountifulfares;

import net.hecco.bountifulfares.registry.misc.BFCompat;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BountifulFaresUtil {
    public static Set<Identifier> allBlockIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.BLOCK.getIds();
        Set<Identifier> a = new HashSet<>();
        for(Identifier id : set) {
            if(Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }

    public static Set<Identifier> allCompatBlockIds() {
        Set<Identifier> set = Registries.BLOCK.getIds();
        Set<Identifier> a = new HashSet<>();
        for(Identifier id : set) {
            for (String namespace : BFCompat.COMPAT_IDS) {
                if (Objects.equals(id.getNamespace(), namespace)) {
                    a.add(id);
                }
            }
        }
        return a;
    }
    public static Set<Identifier> allItemIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.ITEM.getIds();
        Set<Identifier> a = new HashSet<>();
        for(Identifier id : set) {
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
