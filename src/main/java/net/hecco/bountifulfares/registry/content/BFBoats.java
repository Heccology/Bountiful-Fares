package net.hecco.bountifulfares.registry.content;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class BFBoats {
    public static final Identifier HOARY_BOAT_ID = Identifier.of(BountifulFares.MOD_ID, "hoary_boat");
    public static final Identifier HOARY_CHEST_BOAT_ID = Identifier.of(BountifulFares.MOD_ID, "hoary_chest_boat");

    public static final Identifier WALNUT_BOAT_ID = Identifier.of(BountifulFares.MOD_ID, "walnut_boat");
    public static final Identifier WALNUT_CHEST_BOAT_ID = Identifier.of(BountifulFares.MOD_ID, "walnut_chest_boat");

    public static final RegistryKey<TerraformBoatType> HOARY_BOAT_KEY = TerraformBoatTypeRegistry.createKey(HOARY_BOAT_ID);
    public static final RegistryKey<TerraformBoatType> WALNUT_BOAT_KEY = TerraformBoatTypeRegistry.createKey(WALNUT_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType hoaryBoat = new TerraformBoatType.Builder()
                .item(BFItems.HOARY_BOAT)
                .chestItem(BFItems.HOARY_CHEST_BOAT)
                .planks(BFBlocks.HOARY_PLANKS.asItem())
                .build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, HOARY_BOAT_KEY, hoaryBoat);
        TerraformBoatType walnutBoat = new TerraformBoatType.Builder()
                .item(BFItems.WALNUT_BOAT)
                .chestItem(BFItems.WALNUT_CHEST_BOAT)
                .planks(BFBlocks.WALNUT_PLANKS.asItem())
                .build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, WALNUT_BOAT_KEY, walnutBoat);
    }
}
