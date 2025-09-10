package net.hecco.bountifulfares.definition.item.component;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
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
        return 48;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        guiGraphics.renderItem(this.contents.getItemStack(), x, y);
    }

    @Override
    public void renderText(Font font, int mouseX, int mouseY, Matrix4f matrix, MultiBufferSource.BufferSource bufferSource) {
        if (this.contents.item.getCount() != 0) {
            font.drawInBatch(this.contents.getCount() + "/" + this.contents.CAPACITY, (float) mouseX + 18, (float) mouseY + 3, ChatFormatting.GRAY.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            if (this.contents.item.getCount() >= contents.CAPACITY) {
                font.drawInBatch(Component.translatable("tooltip.bountifulfares.shulker_tiffin.full"), (float) mouseX + 2, (float) mouseY + 3 + 14, ChatFormatting.RED.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            }
        } else {
            font.drawInBatch(Component.translatable("tooltip.bountifulfares.shulker_tiffin.empty"), (float) mouseX, (float) mouseY, ChatFormatting.DARK_GRAY.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
        }
        ClientTooltipComponent.super.renderText(font, mouseX, mouseY, matrix, bufferSource);
    }
}
