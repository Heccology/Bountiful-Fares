//package net.hecco.bountifulfares.screen;
//
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.hecco.bountifulfares.BountifulFares;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
//import net.minecraft.client.renderer.GameRenderer;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.player.Inventory;
//
//public class GristmillScreen extends AbstractContainerScreen<GristmillScreenHandler> {
//    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/gristmill.png");
//    private static final ResourceLocation PROGRESS_ARROW = ResourceLocation.fromNamespaceAndPath(BountifulFares.MOD_ID, "textures/gui/gristmill_progress_arrow.png");
//    public GristmillScreen(GristmillScreenHandler handler, Inventory inventory, Component title) {
//        super(handler, inventory, title);
//    }//TODO: FIX
//
//    @Override
//    protected void init() {
//        super.init();
//    }
//
//    @Override
//    protected void renderBg(GuiGraphics context, float delta, int mouseX, int mouseY) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, TEXTURE);
//        int x = (width - imageWidth) / 2;
//        int y = (height - imageHeight) / 2;
//
//        context.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
//        renderProgressArrow(context, this.leftPos, this.topPos);
//    }
//
//    private void renderProgressArrow(GuiGraphics context, int x, int y) {
//        if(menu.isCrafting()) {
//            context.blit(PROGRESS_ARROW, x + 69, y + 36, 0, 0, menu.getScaledProgress(), 14);
//        }
//    }
//
//    @Override
//    public void render(GuiGraphics context, int mouseX, int mouseY, float delta) {
//        renderBg(context, delta, mouseX, mouseY);
//        super.render(context, mouseX, mouseY, delta);
//        renderTooltip(context, mouseX, mouseY);
//    }
//}
