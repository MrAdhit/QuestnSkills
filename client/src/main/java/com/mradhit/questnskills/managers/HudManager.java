package com.mradhit.questnskills.managers;

import com.google.common.util.concurrent.AtomicDouble;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mradhit.questnskills.QuestnSkills;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class HudManager {
    private final MinecraftClient client = MinecraftClient.getInstance();
    private float ticks;
    private int height;
    private int width;

    private double previousMana = 0d;

    public HudManager() {
        draw();
    }

    private void draw() {
        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
            width = client.getWindow().getScaledWidth();
            height = client.getWindow().getScaledHeight();
            ticks = (client.player.getWorld().getTickOrder() % 20);

            TextRenderer renderer = client.textRenderer;

            renderer.draw(matrices, "Kills : " + QuestnSkills.syncedData.getOrDefault("kills", 0), 5, 5, 0xFF_FFFFFF);

            drawManaBar(matrices);

            renderer.draw(matrices, "Tick : " + ticks, 5, 15, 0xFF_FFFFFF);
            renderer.draw(matrices, "World Time : " + (client.player.getWorld().getTime()), 5, 25, 0xFF_FFFFFF);
        });
    }

    private void drawManaBar(MatrixStack matrices) {
        double mana = (double) QuestnSkills.syncedData.getOrDefault("mana", 100d);
        double maxMana = (double) QuestnSkills.syncedData.getOrDefault("mana-max", 100d);
        double manaPercentage = (mana / maxMana);

        int barWidth = (width / 2) + 10;
        int barHeight = height - 50 - (client.player.isCreative() ? 33 : (client.player.getAir() == 300 ? 0 : 9));

        if(!(client.player.isCreative() || client.player.isSpectator())) {
            drawHud(matrices, ImageManager.getSprite("textures/gui/mana_bar_empty.png"), barWidth, barHeight, 0, 80, 9, 8, 9);
            drawHud(matrices, ImageManager.getSprite("textures/gui/mana_bar.png"), barWidth, barHeight, 2, (int) (80d * manaPercentage), 9, 8, 9);

            if(previousMana != mana) {
                if(ticks >= 0 && ticks <= 10) {
                    drawHud(matrices, ImageManager.getSprite("textures/gui/mana_bar_using.png"), barWidth, barHeight, 1, 80, 9, 8, 9);
                }
            }

            if(ticks == 11) {
                previousMana = mana;
            }

        }
    }

    public static void drawHud(MatrixStack matrices, Identifier texture, int x, int y, int z, int width, int height, int spriteWidth, int spriteHeight) {
        drawHud(matrices, texture, x, y, z, 0, 0, width, height, spriteWidth, spriteHeight);
    }

    public static void drawHud(MatrixStack matrices, Identifier texture, int x, int y, int z, int u, int v, int width, int height, int spriteWidth, int spriteHeight) {
        ImageManager.CalculateUV crop = new ImageManager.CalculateUV(spriteWidth, spriteHeight, u, v, spriteWidth, spriteHeight);

        RenderSystem.setShaderTexture(0, texture);
        DrawableHelper.drawTexture(matrices, x, y, z, crop.u1, crop.v1, width, height, spriteWidth, spriteHeight);
    }
}
