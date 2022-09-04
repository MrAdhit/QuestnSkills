package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import com.mradhit.questnskills.utils.PacketChannel;
import io.github.cottonmc.cotton.gui.client.CottonHud;
import io.github.cottonmc.cotton.gui.widget.WBar;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.util.Identifier;

public class EventManager {
    private int once = 0;
    public EventManager() {
        ClientTickEvents.END_WORLD_TICK.register(world -> {
            once++;

            if(once == 1) {
                QuestnSkills.LOGGER.info("Requesting synchronization");
                ClientPlayNetworking.send(PacketChannel.SYNCHRONIZE, PacketByteBufs.empty());
            }
        });
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            once = 0;
        });
    }
}
