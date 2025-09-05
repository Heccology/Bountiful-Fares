package net.hecco.bountifulfares.registry.integration;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.block.integration.CabinetBlockEntity;
import net.hecco.bountifulfares.definition.block.integration.FDCabinetBlock;
import net.hecco.bountifulfares.definition.compat.farmersdelight.FarmersDelightBlocks;
import net.hecco.heccolib.lib.compat.CompatManager;
import net.hecco.heccolib.lib.compat.ModIntegration;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

import static net.hecco.bountifulfares.BountifulFares.FARMERS_DELIGHT_MOD_ID;

public class FarmersDelightIntegration implements ModIntegration {
    @Override
    public CompatManager getCompatManager() {
        return BountifulFares.COMPAT_MANAGER;
    }

    @Override
    public List<String> modIds() {
        return List.of(FARMERS_DELIGHT_MOD_ID);
    }

    public static Supplier<BlockEntityType<CabinetBlockEntity>> CABINET_BLOCK_ENTITY;

    @Override
    public void registerContent() {
        var walnut_cabinet = registerBlock("walnut_cabinet", () -> new FDCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).mapColor(MapColor.COLOR_BROWN)));
        var hoary_cabinet = registerBlock("hoary_cabinet", () -> new FDCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BARREL).mapColor(MapColor.TERRACOTTA_GRAY)));

        if (HLServices.PLATFORM.isModLoaded(BountifulFares.FARMERS_DELIGHT_MOD_ID)) {
            CABINET_BLOCK_ENTITY = HLServices.REGISTRY.registerBlockEntityType(BountifulFares.MOD_ID, "cabinet_block_entity",
                    () -> HLServices.REGISTRY.createBlockEntity(CabinetBlockEntity::new, walnut_cabinet, hoary_cabinet)
            );
        }
    }

    @SuppressWarnings("unchecked")
    private Supplier<Block> registerBlock(String id, Supplier<Block> supplier) {
        Supplier<Block> block = (Supplier<Block>) registerContent(HLServices.REGISTRY.registerBlockNoItem(FARMERS_DELIGHT_MOD_ID, id, supplier));
        registerContent(HLServices.REGISTRY.registerItem(FARMERS_DELIGHT_MOD_ID, id, () -> new BlockItem(block.get(), new Item.Properties())));
        return block;
    }

    @Override
    public boolean shouldCreateDatapack() {
        return true;
    }

    @Override
    public @Nullable String getDatapackName() {
        return "Farmer's Delight x Bountiful Fares";
    }
}
