package net.hecco.bountifulfares.config;

import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.TooltipListEntry;
import net.minecraft.network.chat.Component;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Entry<T> {

    private final String text;
    private final String[] tooltip;
    private final Supplier<T> current;
    private final Consumer<T> saver;
    private final T defaultValue;

    private final T min;
    private final T max;

    public static Entry<Boolean> booleanEntry(String name, Supplier<Boolean> current, Consumer<Boolean> saver, Boolean defaultValue) {
        return new Entry<>(name, current, saver, defaultValue) {
            @Override
            public TooltipListEntry<Boolean> build(ConfigEntryBuilder builder) {
                return builder.startBooleanToggle(Component.translatable(getText()), getCurrent().get())
                        .setSaveConsumer(getSaver())
                        .setDefaultValue(getDefaultValue())
                        .build();
            }
        };
    }

    public static Entry<Boolean> booleanEntry(String name, Supplier<Boolean> current, Consumer<Boolean> saver, Boolean defaultValue, String... tooltip) {
        return new Entry<>(name, current, saver, defaultValue, tooltip) {
            @Override
            public TooltipListEntry<Boolean> build(ConfigEntryBuilder builder) {
                return builder.startBooleanToggle(Component.translatable(getText()), getCurrent().get())
                        .setSaveConsumer(getSaver())
                        .setTooltip(Arrays.stream(getTooltip()).map(Component::translatable).toArray(Component[]::new))
                        .setDefaultValue(getDefaultValue())
                        .build();
            }
        };
    }

    public static Entry<Double> doubleEntry(String name, Supplier<Double> current, Consumer<Double> saver, Double defaultValue, Double min, Double max, String... tooltip) {
        return new Entry<>(name, current, saver, defaultValue, min, max, tooltip) {
            @Override
            public TooltipListEntry<Double> build(ConfigEntryBuilder builder) {
                return builder.startDoubleField(Component.translatable(getText()), getCurrent().get())
                        .setSaveConsumer(getSaver())
                        .setTooltip(Arrays.stream(getTooltip()).map(Component::literal).toArray(Component[]::new))
                        .setDefaultValue(getDefaultValue()).setMin(getMin()).setMax(getMax())
                        .build();
            }
        };
    }

    public static Entry<Integer> integerEntry(String name, Supplier<Integer> current, Consumer<Integer> saver, Integer defaultValue, Integer min, Integer max, String... tooltip) {
        return new Entry<>(name, current, saver, defaultValue, min, max, tooltip) {
            @Override
            public TooltipListEntry<Integer> build(ConfigEntryBuilder builder) {
                return builder.startIntField(Component.translatable(getText()), getCurrent().get())
                        .setSaveConsumer(getSaver())
                        .setTooltip(Arrays.stream(getTooltip()).map(Component::literal).toArray(Component[]::new))
                        .setDefaultValue(getDefaultValue()).setMin(getMin()).setMax(getMax())
                        .build();
            }
        };
    }

    public static Entry<String> stringEntry(String name, Supplier<String> current, Consumer<String> saver, String defaultValue, String... tooltip) {
        return new Entry<>(name, current, saver, defaultValue, tooltip) {
            @Override
            public TooltipListEntry<String> build(ConfigEntryBuilder builder) {
                return builder.startStrField(Component.literal(getText()), getCurrent().get())
                        .setSaveConsumer(getSaver())
                        .setTooltip(Arrays.stream(getTooltip()).map(Component::literal).toArray(Component[]::new))
                        .setDefaultValue(getDefaultValue())
                        .build();
            }
        };
    }

    private Entry (String name, Supplier<T> current, Consumer<T> saver, T defaultValue, String... tooltip) {
        this(name, current, saver, defaultValue, null, null, tooltip);
    }

    private Entry (String name, Supplier<T> current, Consumer<T> saver, T defaultValue, T min, T max, String... tooltip) {
        this.text = name;
        this.current = current;
        this.saver = saver;
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
        this.tooltip = tooltip;
    }

    public abstract TooltipListEntry<T> build(ConfigEntryBuilder builder);

    public String getText() {
        return text;
    }

    public String[] getTooltip() {
        return tooltip;
    }

    public Supplier<T> getCurrent() {
        return current;
    }

    public Consumer<T> getSaver() {
        return saver;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

}