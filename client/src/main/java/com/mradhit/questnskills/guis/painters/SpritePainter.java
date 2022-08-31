package com.mradhit.questnskills.guis.painters;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SpritePainter implements BackgroundPainter {
    private final Identifier texture;
    private final int width;
    private final int height;
    private final float cropLeft;
    private final float cropTop;
    private final float cropRight;
    private final float cropBottom;

    public SpritePainter(Identifier texture, int width, int height){
        this(texture, width, height, 0, 0, 1, 1);
    }

    public SpritePainter(Identifier texture, int width, int height, float cropLeft, float cropTop, float cropRight, float cropBottom){
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.cropLeft = cropLeft;
        this.cropTop = cropTop;
        this.cropRight = cropRight;
        this.cropBottom = cropBottom;
    }

    public void paintBackground(MatrixStack matrices, int left, int top, WWidget panel){
        ScreenDrawing.texturedRect(matrices, left, top, width, height, texture, cropLeft, cropTop, cropRight, cropBottom, 0xFF_FFFFFF);
    }
}
