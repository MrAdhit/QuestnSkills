package com.mradhit.skillnquest.managers;

import com.mradhit.skillnquest.QuestnSkills;
import com.mradhit.skillnquest.guis.MainMenuGui;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindManager {
    private final KeyBinding openMainMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding("Open Main Menu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_APOSTROPHE, QuestnSkills.MOD_NAME));

    public KeybindManager() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while(openMainMenu.isPressed()){
                MinecraftClient.getInstance().setScreen(new ScreenManager(new MainMenuGui()));
            }
        });
    }
}
