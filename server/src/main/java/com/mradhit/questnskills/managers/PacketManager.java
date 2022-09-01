package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import com.mradhit.questnskills.utils.PacketChannel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class PacketManager {
    public PacketManager() {
        RegisterOutgoingPacket();
        IncomingPacket();
    }

    private void IncomingPacket() {
        Bukkit.getMessenger().registerIncomingPluginChannel(QuestnSkills.plugin, PacketChannel.EQUIPMENT_1, (channel, player, message) -> {
            
        });
        Bukkit.getMessenger().registerIncomingPluginChannel(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE, (channel, player, message) -> {
            sync(player);
        });
    }

    private void RegisterOutgoingPacket() {
        QuestnSkills.plugin.getServer().getMessenger().registerOutgoingPluginChannel(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE);
    }

    public static void sync(Player player) {
        QuestnSkills.plugin.getLogger().info(player.getName() + " is requesting synchronization");

        JSONObject data = new JSONObject();
        PlayerSaveManager playerData = new PlayerSaveManager(player);

        data.put("kills", playerData.KILL.get());

        player.getPlayer().sendPluginMessage(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE, PacketManager.buildMessage(data.toString()));
    }

    public static byte[] buildMessage(String input) {
        ByteBuffer buf = ByteBuffer.allocate(input.length() + 1);
        buf.put((byte) input.length());
        buf.put(input.getBytes(StandardCharsets.UTF_8));
        return buf.array();
    }
}
