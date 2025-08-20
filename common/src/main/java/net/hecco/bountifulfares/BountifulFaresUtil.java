package net.hecco.bountifulfares;

import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.registry.misc.BFCompat;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BountifulFaresUtil {
    public static final List<String> WOOD_TYPES = List.of("oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "mangrove", "cherry", "bamboo", "walnut", "hoary", "crimson", "warped");
    public static final List<Block> WOOD_PLANKS = List.of(Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.CHERRY_PLANKS, Blocks.BAMBOO_PLANKS, BFBlocks.WALNUT_PLANKS.get(), BFBlocks.HOARY_PLANKS.get(), Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS);
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
        Set<ResourceLocation> set = BuiltInRegistries.BLOCK.keySet();
        Set<ResourceLocation> a = new HashSet<>();
        for(ResourceLocation id : set) {
            for (String namespace : BFCompat.COMPAT_IDS) {
                if (Objects.equals(id.getNamespace(), namespace)) {
                    a.add(id);
                }
            }
        }
        return a;
    }

    public static Set<ResourceLocation> allCompatItemIds() {
        Set<ResourceLocation> set = BuiltInRegistries.ITEM.keySet();
        Set<ResourceLocation> a = new HashSet<>();
        for(ResourceLocation id : set) {
            for (String namespace : BFCompat.COMPAT_IDS) {
                if (Objects.equals(id.getNamespace(), namespace)) {
                    a.add(id);
                }
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
