//package net.hecco.bountifulcuisine.compat;
//
//import me.shedaniel.math.Point;
//import me.shedaniel.math.Rectangle;
//import me.shedaniel.rei.api.client.gui.Renderer;
//import me.shedaniel.rei.api.client.gui.widgets.Widget;
//import me.shedaniel.rei.api.client.gui.widgets.Widgets;
//import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
//import me.shedaniel.rei.api.common.category.CategoryIdentifier;
//import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
//import me.shedaniel.rei.api.common.util.EntryStacks;
//import net.hecco.bountifulcuisine.BountifulCuisine;
//import net.hecco.bountifulcuisine.block.ModBlocks;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class MillingCategory implements DisplayCategory<BasicDisplay> {
//    public static final Identifier TEXTURE = new Identifier(BountifulCuisine.MOD_ID, "textures/gui/gristmill.png");
//    public static final CategoryIdentifier<MillingDisplay> MILLING = CategoryIdentifier.of(BountifulCuisine.MOD_ID, "milling");
//    @Override
//    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
//        return MILLING;
//    }
//
//    @Override
//    public Text getTitle() {
//        return Text.translatable("block.bountifulcuisine.gristmill");
//    }
//
//    @Override
//    public Renderer getIcon() {
//        return EntryStacks.of(ModBlocks.GRISTMILL.asItem().getDefaultStack());
//    }
//
//    @Override
//    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
//        Point startpoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
//        List<Widget> widgets = new LinkedList<>();
//        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startpoint.x, startpoint.y, 175, 182)));
//        widgets.add(Widgets.createSlot(new Point(startpoint.x + 44, startpoint.y + 36)).entries(display.getInputEntries().get(0)));
//        widgets.add(Widgets.createSlot(new Point(startpoint.x + 116, startpoint.y + 36)).markOutput().entries(display.getOutputEntries().get(0)));
//
//        return widgets;
//    }
//
//    @Override
//    public int getDisplayHeight() {
//        return 90;
//    }
//}
