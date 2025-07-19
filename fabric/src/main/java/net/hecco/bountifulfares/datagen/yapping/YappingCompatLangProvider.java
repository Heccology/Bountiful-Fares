package net.hecco.bountifulfares.datagen.yapping;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class YappingCompatLangProvider {

    public static void generate(FabricLanguageProvider.TranslationBuilder builder, Block block, String tooltip) {
        builder.add("yapping_tooltips." + block.getDescriptionId() + ".desc", tooltip);
    }

    public static void generate(FabricLanguageProvider.TranslationBuilder builder, Item item, String tooltip) {
        builder.add("yapping_tooltips." + item.getDescriptionId() + ".desc", tooltip);
    }

    public static void generateTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        generate(translationBuilder, BFItems.ORANGE.get(), "A citrus fruit found in tropical areas");
        generate(translationBuilder, BFItems.LEMON.get(), "A citrus fruit found near rivers");
        generate(translationBuilder, BFItems.PLUM.get(), "");
//        generate(translationBuilder, BFItems.HOARY_APPLE, "An ancient fruit, has a ");


//        desc.add(YT_ID + "block." + ID + "oak_log.desc", "A sturdy log from an oak tree");
//        desc.add(YT_ID + "block." + ID + "oak_wood.desc", "A sturdy piece of wood from an oak log");
//        desc.add(YT_ID + "block." + ID + "stripped_oak_log.desc", "An oak log that has been stripped- by accident?");
//        desc.add(YT_ID + "block." + ID + "stripped_oak_wood.desc", "An oak wood that has been stripped- by accident?");
//        desc.add(YT_ID + "block." + ID + "oak_planks.desc", "Fine planks constructed from oak");
//        desc.add(YT_ID + "block." + ID + "oak_stairs.desc", "Fine wooden stairs constructed from oak");
//        desc.add(YT_ID + "block." + ID + "oak_slab.desc", "Fine wooden slabs constructed from oak");
//        desc.add(YT_ID + "block." + ID + "oak_fence.desc", "Too high to jump over");
//        desc.add(YT_ID + "block." + ID + "oak_fence_gate.desc", "Can be opened, connects with fences and walls");
//        desc.add(YT_ID + "block." + ID + "oak_door.desc", "Make yourself feel at home");
//        desc.add(YT_ID + "block." + ID + "oak_trapdoor.desc", "Commonly used for everything BUT traps");
//        desc.add(YT_ID + "block." + ID + "oak_pressure_plate.desc", "Produces a redstone signal when ANY entity makes contact with it");
//        desc.add(YT_ID + "block." + ID + "oak_button.desc", "Can be pushed by players, arrows, and tridents, stays pushed for 1.5 seconds");
//
//        desc.add(YT_ID + "block." + ID + "spruce_log.desc", "A sturdy log from a spruce tree");
//        desc.add(YT_ID + "block." + ID + "spruce_wood.desc", "A sturdy piece of wood from a spruce log");
//        desc.add(YT_ID + "block." + ID + "stripped_spruce_log.desc", "A spruce log that has been stripped- by accident?");
//        desc.add(YT_ID + "block." + ID + "stripped_spruce_wood.desc", "A spruce wood that has been stripped- by accident?");
//        desc.add(YT_ID + "block." + ID + "spruce_planks.desc", "Fine planks constructed from spruce");
//        desc.add(YT_ID + "block." + ID + "spruce_stairs.desc", "Fine wooden stairs constructed from spruce");
//        desc.add(YT_ID + "block." + ID + "spruce_slab.desc", "Fine wooden slabs constructed from spruce");
//        desc.add(YT_ID + "block." + ID + "spruce_fence.desc", "Too high to jump over");
//        desc.add(YT_ID + "block." + ID + "spruce_fence_gate.desc", "Can be opened, connects with fences and walls");
//        desc.add(YT_ID + "block." + ID + "spruce_door.desc", "Make yourself feel at home");
//        desc.add(YT_ID + "block." + ID + "spruce_trapdoor.desc", "Commonly used for everything BUT traps");
//        desc.add(YT_ID + "block." + ID + "spruce_pressure_plate.desc", "Produces a redstone signal when ANY entity makes contact with it");
//        desc.add(YT_ID + "block." + ID + "spruce_button.desc", "Can be pushed by players, arrows, and tridents, stays pushed for 1.5 seconds");
    }
}