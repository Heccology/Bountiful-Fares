package net.hecco.bountifulfares.definition.item.component;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import org.joml.Matrix4f;

public class ClientTiffinTooltip implements ClientTooltipComponent {
    private final TiffinContents contents;

    public ClientTiffinTooltip(TiffinContents contents) {
        this.contents = contents;
    }

    @Override
    public int getHeight() {
        return this.contents.item.isEmpty() ? 12 : this.contents.item.getCount() >= contents.CAPACITY ? 28 : 18;
    }

    @Override
    public int getWidth(Font font) {
        return 128;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        guiGraphics.renderItem(this.contents.getItemStack(), x, y);
//        RenderSystem.disableScissor();
    }

    @Override
    public void renderText(Font font, int mouseX, int mouseY, Matrix4f matrix, MultiBufferSource.BufferSource bufferSource) {
        if (this.contents.item.getCount() != 0) {
            font.drawInBatch("x" + this.contents.getCount(), (float) mouseX + 18, (float) mouseY + 3, ChatFormatting.GRAY.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            if (this.contents.item.getCount() >= contents.CAPACITY) {
                font.drawInBatch("Full!", (float) mouseX + 2, (float) mouseY + 3 + 14, ChatFormatting.RED.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            }
        } else {
            font.drawInBatch("Empty", (float) mouseX + 2, (float) mouseY, ChatFormatting.DARK_GRAY.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
        } //TODO: turn to translatable text
        ClientTooltipComponent.super.renderText(font, mouseX, mouseY, matrix, bufferSource);
    }
}
