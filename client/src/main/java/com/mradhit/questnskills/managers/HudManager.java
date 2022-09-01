package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

public class HudManager {
    public HudManager() {
        draw();
    }

    private void draw() {
        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
            TextRenderer renderer = MinecraftClient.getInstance().textRenderer;

            renderer.draw(matrices, "Kills : " + QuestnSkills.syncedData.getOrDefault("kills", 0), 5, 5, 0xFF_FFFFFF);
        });
    }
}
