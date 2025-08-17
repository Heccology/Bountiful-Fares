package net.hecco.bountifulfares.util;

//Mostly taken from MIT-licensed project Adorn by Juuz
//Source: https://github.com/Juuxel/Adorn/blob/bd70a2955640897bc68ff1f4f201fe5e6c10bc32/fabric/src/main/java/juuxel/adorn/AdornMixinPlugin.java

import com.google.common.collect.ImmutableMap;
import net.neoforged.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class BFNeoforgeMixinPlugin implements IMixinConfigPlugin {
    private static final Supplier<Boolean> TRUE = () -> true;

    //populate this with conditionally loading mixins EXCLUSIVE TO NEOFORGE -diemant
    private static final Map<String, Supplier<Boolean>> CONDITIONS = ImmutableMap.ofEntries(
            Map.entry("net.hecco.bountifulfares.mixin.compat.appleskin.TooltipOverlayHandlerMixin", () ->
                    LoadingModList.get().getModFileById("appleskin") != null)
            //Map.entry("mixin path", () ->
            //                    LoadingModList.get().getModFileById("mod id") != null)
    );

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return CONDITIONS.getOrDefault(mixinClassName, TRUE).get();
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}