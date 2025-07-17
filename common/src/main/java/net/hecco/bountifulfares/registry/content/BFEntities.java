package net.hecco.bountifulfares.registry.content;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.entity.FlourProjectileEntity;
import net.hecco.heccolib.platform.HLServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class BFEntities {
    public static final Supplier<EntityType<FlourProjectileEntity>> THROWN_FLOUR_PROJECTILE = register("flour", () ->
            EntityType.Builder.of(FlourProjectileEntity::new, MobCategory.MISC)
                    .clientTrackingRange(4).sized(0.25F, 0.25F)
                    .build(BountifulFares.MOD_ID + ":" + "flour"));

    private static <T extends EntityType<?>> Supplier<T> register(String id, Supplier<T> registry) {
        return HLServices.REGISTRY.register(BountifulFares.MOD_ID, id, BuiltInRegistries.ENTITY_TYPE.key(), registry);
    }

    public static void registerEntities() {
    }
}
