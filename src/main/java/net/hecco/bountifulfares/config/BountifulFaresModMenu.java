package net.hecco.bountifulfares.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.SubCategoryListEntry;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.BountifulFaresConfiguration;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.Arrays;

@Environment(value= EnvType.CLIENT)
public class BountifulFaresModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return this::buildConfigScreen;
    }

    private Screen buildConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setSavingRunnable(() -> BountifulFaresConfiguration.save(BountifulFares.CONFIG))
                .setTitle(Text.translatable("config.bountifulfares.title"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        Arrays.stream(Category.values()).filter(category -> !category.isChild()).forEach(category -> buildCategory(builder, entryBuilder, category));
        return builder.build();
    }

    private void buildCategory(ConfigBuilder builder, ConfigEntryBuilder entryBuilder, Category category) {
        ConfigCategory configCategory = builder.getOrCreateCategory(Text.translatable(category.text()));
        Arrays.stream(category.entries()).forEach(entry -> configCategory.addEntry(entry.build(entryBuilder)));
        Arrays.stream(category.children()).forEach(entry -> configCategory.addEntry(buildSubCategory(entryBuilder.startSubCategory(Text.translatable(entry.text())), entryBuilder, entry)));

    }

    private SubCategoryListEntry buildSubCategory(SubCategoryBuilder subCategoryBuilder, ConfigEntryBuilder entryBuilder, Category category) {
        Arrays.stream(category.entries()).forEach(entry -> subCategoryBuilder.add(entry.build(entryBuilder)));
        Arrays.stream(category.children()).forEach(entry -> subCategoryBuilder.add(buildSubCategory(entryBuilder.startSubCategory(Text.translatable(entry.text())), entryBuilder, entry)));
        return subCategoryBuilder.build();
    }
}
