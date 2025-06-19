package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class BFEntities {
    public static final EntityType<FlourProjectileEntity> THROWN_FLOUR_PROJECTILE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "flour"),
            FabricEntityTypeBuilder.<FlourProjectileEntity>create(MobCategory.CREATURE, FlourProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).trackRangeBlocks(4).trackedUpdateRate(10).build());

    public static void registerModEntities() {
//        BountifulFares.LOGGER.info("Registering Mod Entities for " + BountifulFares.MOD_ID);
    }
}
