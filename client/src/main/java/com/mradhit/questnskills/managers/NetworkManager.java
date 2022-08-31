package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import com.mradhit.questnskills.utils.PacketChannel;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class NetworkManager {
    public NetworkManager() {
        QuestnSkills.LOGGER.info("Initializing Network Manager");
        ClientPlayNetworking.registerGlobalReceiver(PacketChannel.SYNCHRONIZE, (client, handler, buf, responseSender) -> {

        });
    }
}
