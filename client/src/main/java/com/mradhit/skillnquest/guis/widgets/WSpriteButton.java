package com.mradhit.skillnquest.guis.widgets;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.TooltipBuilder;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class WSpriteButton extends WWidget {
    private int color = WLabel.DEFAULT_TEXT_COLOR;
    private Identifier texture;
    private boolean enabled;
    private String[] tooltips = {""};

    @Nullable
    private Runnable onClick;

    public WSpriteButton(Identifier texture){
        this(texture, true);
    }

    public WSpriteButton(Identifier texture, boolean enabled){
        this.texture = texture;
        this.enabled = enabled;
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY){
        boolean hovered = (mouseX>=0 && mouseY>=0 && mouseX<getWidth() && mouseY<getHeight());
        this.color = (this.enabled ? (hovered ? 0xFFFFFF : 0xCCCCCC) : 0x686868);

        ScreenDrawing.texturedRect(matrices, x, y, width, height, texture, color);
    }

    @Override
    public void addTooltip(TooltipBuilder tooltip){
        for(String text : this.tooltips){
            tooltip.add(Text.of(text));
        }
    }

    public InputResult onClick(int x, int y, int button){
        super.onClick(x, y, button);
        if(this.enabled && isWithinBounds(x, y)){
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
            if (this.onClick != null) {
                this.onClick.run();
            }
            return InputResult.PROCESSED;
        }
        return InputResult.IGNORED;
    }

    public WSpriteButton setOnClick(@Nullable Runnable onClick) {
        this.onClick = onClick;
        return this;
    }

    public void setTooltips(String[] tooltips){
        this.tooltips = tooltips;
    }

    public void setEnabled(Boolean enabled){
        this.enabled = enabled;
    }

    @Override
    public boolean canResize(){
        return true;
    }

    @Override
    public boolean canFocus() {
        return true;
    }
}
