package com.mradhit.skillnquest.managers;

import com.mradhit.skillnquest.QuestnSkills;
import com.mradhit.skillnquest.utils.PacketChannel;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class NetworkManager {
    public NetworkManager() {
        QuestnSkills.LOGGER.info("Initializing Network Manager");
        ClientPlayNetworking.registerGlobalReceiver(PacketChannel.SYNCHRONIZE, (client, handler, buf, responseSender) -> {

        });
    }
}
