package net.hecco.bountifulfares.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GristmillScreen extends HandledScreen<GristmillScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(BountifulFares.MOD_ID, "textures/gui/gristmill.png");
    private static final Identifier PROGRESS_ARROW = Identifier.of(BountifulFares.MOD_ID, "textures/gui/gristmill_progress_arrow.png");
    public GristmillScreen(GristmillScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        renderProgressArrow(context, this.x, this.y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(PROGRESS_ARROW, x + 69, y + 36, 0, 0, handler.getScaledProgress(), 14);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        drawBackground(context, delta, mouseX, mouseY);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
