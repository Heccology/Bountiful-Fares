package net.hecco.bountifulfares.registry.integration.everycompat;

import net.hecco.bountifulfares.definition.block.custom.PicketsBlock;
import net.hecco.bountifulfares.definition.block.custom.TrellisBlock;
import net.hecco.bountifulfares.registry.content.BFBlockEntities;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.RenderLayer;
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
import java.util.function.Supplier;

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
        // NOTE: vsauce, diemant here. at one point the properties were copied using
        // Utils.copyPropertySafe(w.planks)
        // but this seems to cause some issues for example trellises should have noOcclussion which
        // planks lack. Now, I do not know why would anyone copy planks if in the same line earlier you
        // had gotten the block instance already. So i replaced them with copying the bf blocks
        Supplier<Block> picketsRoleModel = getModBlock("oak_pickets");
        pickets = SimpleEntrySet.builder(WoodType.class, "pickets",
                        picketsRoleModel, () -> VanillaWoodTypes.OAK,
                        w -> new PicketsBlock(Utils.copyPropertySafe(picketsRoleModel.get())))
                .addTexture(modRes("block/oak_pickets"))
                .addTexture(modRes("item/oak_pickets"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(modRes("pickets"), Registries.BLOCK, Registries.ITEM)
                .defaultRecipe()
                .setTabKey(tab)
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(pickets);

        // using acacia as base block because 'oak_trellis' does not exist
        Supplier<Block> trellisRoleModel = getModBlock("acacia_trellis");
        trellis = SimpleEntrySet.builder(WoodType.class, "trellis",
                        trellisRoleModel, () -> VanillaWoodTypes.ACACIA,
                        w -> new TrellisBlock(Utils.copyPropertySafe(trellisRoleModel.get())))
                .addTexture(modRes("block/acacia_trellis"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .defaultRecipe()
                .setTabKey(tab)
                .addTile(BFBlockEntities.TRELLIS_BLOCK_ENTITY)
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(trellis);

    }

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
