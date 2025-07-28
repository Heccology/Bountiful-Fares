package net.hecco.bountifulfares.item.component;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.Item;

public class ClientTiffinTooltip implements ClientTooltipComponent {
    private final TiffinContents contents;

    public ClientTiffinTooltip(TiffinContents contents) {
        this.contents = contents;
    }

    @Override
    public int getHeight() {
        return 16;
    }

    @Override
    public int getWidth(Font font) {
        return 16;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        Item item = this.contents.getItem();
        guiGraphics.renderItem(item.getDefaultInstance(), 0, 0);
        ClientTooltipComponent.super.renderImage(font, x, y, guiGraphics);
    }
}
