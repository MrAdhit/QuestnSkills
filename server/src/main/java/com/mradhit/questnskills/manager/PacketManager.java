package com.mradhit.questnskills.manager;

import com.mradhit.questnskills.QuestnSkills;
import com.mradhit.questnskills.utils.PacketChannel;
import org.bukkit.Bukkit;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class PacketManager {
    public PacketManager() {
        RegisterOutgoingPacket();
        IncomingPacket();
    }

    private void IncomingPacket() {
        Bukkit.getMessenger().registerIncomingPluginChannel(QuestnSkills.plugin, PacketChannel.EQUIPMENT_1, (channel, player, message) -> {
            player.getPlayer().sendPluginMessage(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE, buildMessage("test"));

        });
    }

    private void RegisterOutgoingPacket() {
        QuestnSkills.plugin.getServer().getMessenger().registerOutgoingPluginChannel(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE);
    }

    public static byte[] buildMessage(String input){
        ByteBuffer buf = ByteBuffer.allocate(input.length() + 1);
        buf.put((byte) input.length());
        buf.put(input.getBytes(StandardCharsets.UTF_8));
        return buf.array();
    }
}
