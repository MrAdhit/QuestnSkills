package com.mradhit.questnskills.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class ModInGameHud {

    @Inject(method = "renderStatusBars", at = @At(value = "HEAD"))
    public void renderMana(MatrixStack matrices, CallbackInfo ci) {

    }
}
