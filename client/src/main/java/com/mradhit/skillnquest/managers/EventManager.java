package com.mradhit.skillnquest.managers;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class EventManager {
    public EventManager() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {

        });
    }
}
