package net.hecco.bountifulfares.item.component;

import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import org.joml.Matrix4f;

public class ClientTiffinTooltip implements ClientTooltipComponent {
    private final TiffinContents contents;

    public ClientTiffinTooltip(TiffinContents contents) {
        this.contents = contents;
    }

    @Override
    public int getHeight() {
        return this.contents.count == 0 ? 12 : this.contents.count >= TiffinContents.CAPACITY ? 28 : 18;
    }

    @Override
    public int getWidth(Font font) {
        return 128;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        Item item = this.contents.getItem();
        guiGraphics.renderItem(item.getDefaultInstance(), x, y);
//        RenderSystem.disableScissor();
    }

    @Override
    public void renderText(Font font, int mouseX, int mouseY, Matrix4f matrix, MultiBufferSource.BufferSource bufferSource) {
        if (this.contents.count != 0) {
            font.drawInBatch("x" + this.contents.getCount(), (float) mouseX + 18, (float) mouseY + 3, ChatFormatting.GRAY.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            if (this.contents.count >= TiffinContents.CAPACITY) {
                font.drawInBatch("Full!", (float) mouseX + 2, (float) mouseY + 3 + 14, ChatFormatting.RED.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            }
        } else {
            font.drawInBatch("Empty", (float) mouseX + 2, (float) mouseY, ChatFormatting.DARK_GRAY.getColor(), true, matrix, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
        } //TODO: turn to translatable text
        ClientTooltipComponent.super.renderText(font, mouseX, mouseY, matrix, bufferSource);
    }
}
