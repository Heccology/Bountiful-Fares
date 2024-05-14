package net.hecco.bountifulfares.block.trellis_parts;

import net.hecco.bountifulfares.block.TrellisVariants;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.Objects;

public class TrellisVariant {
    private final String MOD_ID;
    private final String TYPE_ID;

//    Used for crafting recipes, can be ignored if there is no planks to craft it with
    private Item PLANKS = Items.STICK;


    public TrellisVariant(String modId, String id, Item planks) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        this.PLANKS = planks;
        TrellisVariants.TrellisVariants.add(this);
    }

    public TrellisVariant(String modId, String id) {
        this.MOD_ID = modId;
        this.TYPE_ID = id;
        TrellisVariants.TrellisVariants.add(this);
    }

    public String getName() {
        return this.TYPE_ID;
    }

    public String getTrellisName() {
        if (Objects.equals(TYPE_ID, "oak")) {
            return "trellis";
        }
        return this.TYPE_ID + "_trellis";
    }

    public String getId() {
        return this.MOD_ID;
    }

    public Item getPlanks() {
        return this.PLANKS;
    }

}
