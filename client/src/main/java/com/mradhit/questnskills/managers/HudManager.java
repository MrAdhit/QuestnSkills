package com.mradhit.questnskills.managers;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mradhit.questnskills.QuestnSkills;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.util.Identifier;

public class HudManager {
    public HudManager() {
        draw();
    }

    private void draw() {
        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
            int width = MinecraftClient.getInstance().getWindow().getScaledWidth();
            int height = MinecraftClient.getInstance().getWindow().getScaledHeight();
            int scale = 18;

            TextRenderer renderer = MinecraftClient.getInstance().textRenderer;

            RenderSystem.setShaderTexture(0, new Identifier(QuestnSkills.MOD_ID, "textures/gui/bar-empty.png"));
            DrawableHelper.drawTexture(matrices, (width / 2) + 10, height - 50, 0f, 0f, 80, 9, 80, 9);

            renderer.draw(matrices, "Kills : " + QuestnSkills.syncedData.getOrDefault("kills", 0), 5, 5, 0xFF_FFFFFF);
            RenderSystem.setShaderTexture(0, new Identifier(QuestnSkills.MOD_ID, "textures/gui/bar-fill.png"));
            DrawableHelper.drawTexture(matrices, (width / 2) + 10, height - 50, 0f, 0f, (8 * (int) QuestnSkills.syncedData.getOrDefault("mana", 10)), 9, 80, 9);
        });
    }
}
