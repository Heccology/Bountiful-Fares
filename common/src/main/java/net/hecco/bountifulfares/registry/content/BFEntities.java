package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.definition.entity.FlourProjectileEntity;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class BFEntities {
//    public static final Supplier<EntityType<FlourProjectileEntity>> THROWN_FLOUR_PROJECTILE = register("flour", () ->
//            EntityType.Builder.<FlourProjectileEntity>of(FlourProjectileEntity::new, MobCategory.MISC)
//                    .clientTrackingRange(8).updateInterval(10).sized(0.25F, 0.25F)
//                    .build("bountifulfares:flour"));
public static final Supplier<EntityType<FlourProjectileEntity>> THROWN_FLOUR_PROJECTILE = register("flour", () ->
        EntityType.Builder.<FlourProjectileEntity>of(FlourProjectileEntity::new, MobCategory.MISC)
                .clientTrackingRange(8).updateInterval(10).sized(0.25F, 0.25F)
                .build("bountifulfares:flour"));

    private static <E extends Entity> Supplier<EntityType<E>> register(String id, Supplier<EntityType<E>> registry) {
        return HLServices.REGISTRY.registerEntityType(BountifulFares.MOD_ID, id, registry);
    }

    public static void registerEntities() {
    }
}
