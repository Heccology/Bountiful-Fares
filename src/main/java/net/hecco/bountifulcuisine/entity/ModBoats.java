package net.hecco.bountifulcuisine.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.hecco.bountifulcuisine.block.ModBlocks;
import net.hecco.bountifulcuisine.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier HOARY_BOAT_ID = new Identifier(BountifulCuisine.MOD_ID, "hoary_boat");
    public static final Identifier HOARY_CHEST_BOAT_ID = new Identifier(BountifulCuisine.MOD_ID, "hoary_chest_boat");

    public static final RegistryKey<TerraformBoatType> HOARY_BOAT_KEY = TerraformBoatTypeRegistry.createKey(HOARY_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType hoaryBoat = new TerraformBoatType.Builder()
                .item(ModItems.HOARY_BOAT)
                .chestItem(ModItems.HOARY_CHEST_BOAT)
                .planks(ModBlocks.HOARY_PLANKS.asItem())
                .build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, HOARY_BOAT_KEY, hoaryBoat);
    }
}
