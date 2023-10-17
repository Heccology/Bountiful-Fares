package net.hecco.bountifulcuisine.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<FlourProjectileEntity> THROWN_FLOUR_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "flour"),
            FabricEntityTypeBuilder.<FlourProjectileEntity>create(SpawnGroup.CREATURE, FlourProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static void registerModEntities() {
        BountifulCuisine.LOGGER.info("Registering Mod Entities for " + BountifulCuisine.MOD_ID);
    }
}
