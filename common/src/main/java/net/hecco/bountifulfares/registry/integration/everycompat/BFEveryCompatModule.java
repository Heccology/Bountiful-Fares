package net.hecco.bountifulfares.registry.integration.everycompat;

import net.hecco.bountifulfares.definition.block.custom.PicketsBlock;
import net.hecco.bountifulfares.definition.block.integration.ECTrellisBlock;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.List;

import static net.hecco.bountifulfares.BountifulFares.ARTS_AND_CRAFTS_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.FARMERS_DELIGHT_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.FRONTIERS_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.NATURES_SPIRIT_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.JADENS_NETHER_EXPANSION_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.NO_MANS_LAND_MOD_ID;

public class BFEveryCompatModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> pickets, trellis;

    public BFEveryCompatModule(String modId) {
        super(modId, "bf", EveryCompat.MOD_ID);

        ResourceLocation tab = modRes(modId);

        pickets = SimpleEntrySet.builder(WoodType.class, "pickets",
                        getModBlock("oak_pickets"), () -> VanillaWoodTypes.OAK,
                        w -> new PicketsBlock(Utils.copyPropertySafe(w.planks)))
                .addTexture(modRes("block/oak_pickets"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(modRes("pickets"), Registries.BLOCK, Registries.ITEM)
                .defaultRecipe()
                .setTabKey(tab)
                .build();
        this.addEntry(pickets);

        // using acacia as base block because 'oak_trellis' does not exist
        trellis = SimpleEntrySet.builder(WoodType.class, "trellis",
                        getModBlock("acacia_trellis"), () -> VanillaWoodTypes.ACACIA,
                        w -> new ECTrellisBlock(Utils.copyPropertySafe(w.planks)))
                .addTexture(modRes("block/acacia_trellis"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .defaultRecipe()
                .setTabKey(tab)
                .build();
        this.addEntry(trellis);

    }

    /*
    TODO:
    Put Supplier<Block> of each trellis (and pickets?) into their respective Maps **NEEDS TO HAPPEN**
    Figure out how to make BF Block entity list dynamic, or at least add my own dynamic resource



    @Override
    public void onModSetup() {
        trellis.blocks.forEach((w, block) -> {
            String key = EveryCompat.MOD_ID + "_" + w.getTypeName();

            // Somehow need to get a Supplier<Block> instead of Block of each one to stick in here
            //BFBlocks.TRELLISES.put(key, );
        });
    }
    */

    public List<String> getAlreadySupportedMods() {
        return List.of(ARTS_AND_CRAFTS_MOD_ID,
                FARMERS_DELIGHT_MOD_ID,
                FRONTIERS_MOD_ID,
                NATURES_SPIRIT_MOD_ID,
                JADENS_NETHER_EXPANSION_MOD_ID,
                NO_MANS_LAND_MOD_ID
        );
    }

}
