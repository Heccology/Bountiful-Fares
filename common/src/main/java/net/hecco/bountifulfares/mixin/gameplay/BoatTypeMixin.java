//package net.hecco.bountifulfares.mixin.gameplay;
//
//import net.minecraft.util.ByIdMap;
//import net.minecraft.util.StringRepresentable;
//import net.minecraft.world.entity.vehicle.Boat;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Mutable;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.gen.Invoker;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.IntFunction;
//
//@Mixin(Boat.Type.class)
//public class BoatTypeMixin {
//
//    @Shadow @Final @Mutable
//    private static Boat.Type[] $VALUES;
//
//    @Shadow @Final @Mutable
//    public static StringRepresentable.EnumCodec<Boat.Type> CODEC;
//
//    @Shadow @Final @Mutable
//    private static IntFunction<Boat.Type> BY_ID;
//
//    @Invoker("<init>")
//    public static Boat.Type invokeInit(String name, int id, Block wood, String key) {
//        throw new AssertionError();
//    }
//
//    static {
//        List<Boat.Type> variants = new ArrayList<>(Arrays.asList($VALUES));
//
//        //Game crashes if I put any modded item however planks dropping from boats as long since been discarded and is only used as a fallback anyway - yirmiri
//        variants.add(invokeInit("BOUNTIFULFARES_HOARY", variants.size(), Blocks.OAK_PLANKS, "bountifulfares_hoary"));
//        variants.add(invokeInit("BOUNTIFULFARES_WALNUT", variants.size(), Blocks.OAK_PLANKS, "bountifulfares_walnut"));
//
//        $VALUES = variants.toArray(new Boat.Type[0]);
////        CODEC = StringRepresentable.fromEnum(Boat.Type::values);
//        BY_ID = ByIdMap.continuous(Enum::ordinal, $VALUES, ByIdMap.OutOfBoundsStrategy.ZERO);
//    }
//}