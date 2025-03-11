package net.hecco.bountifulfares.registry.content;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BFEntities {
    public static final EntityType<FlourProjectileEntity> THROWN_FLOUR_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BountifulFares.MOD_ID, "flour"),
            FabricEntityTypeBuilder.<FlourProjectileEntity>create(SpawnGroup.CREATURE, FlourProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).trackRangeBlocks(4).trackedUpdateRate(10).build());

    public static void registerModEntities() {
//        BountifulFares.LOGGER.info("Registering Mod Entities for " + BountifulFares.MOD_ID);
    }
}
