package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import com.mradhit.questnskills.utils.PacketChannel;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class NetworkManager {
    public NetworkManager() {
        ClientPlayNetworking.registerGlobalReceiver(PacketChannel.SYNCHRONIZE, (client, handler, buf, responseSender) -> {
            String bufs = buf.readString();
            JSONObject data = new JSONObject(bufs);

            QuestnSkills.syncedData.put("kills", data.get("kills"));
            QuestnSkills.syncedData.put("mana", data.get("mana"));
        });
    }
}
