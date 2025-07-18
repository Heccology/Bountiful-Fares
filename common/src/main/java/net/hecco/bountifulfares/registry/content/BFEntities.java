package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class BFEntities {
//    public static final Supplier<EntityType<FlourProjectileEntity>> THROWN_FLOUR_PROJECTILE = register("flour", () ->
//            EntityType.Builder.<FlourProjectileEntity>of(FlourProjectileEntity::new, MobCategory.MISC)
//                    .clientTrackingRange(4).sized(0.25F, 0.25F)
//                    .build(BountifulFares.MOD_ID + ":" + "flour")); //TODO: LOOK AT THIS AGAIN
//
//    private static <E extends Entity> Supplier<EntityType<E>> register(String id, Supplier<EntityType<E>> registry) {
//        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, id, (net.minecraft.resources.ResourceKey<? extends net.minecraft.core.Registry<EntityType<E>>>) BuiltInRegistries.ENTITY_TYPE.key(), registry);
//    }

    public static void registerEntities() {
    }
}
