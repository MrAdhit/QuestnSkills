package com.mradhit.questnskills.manager;

import com.mradhit.questnskills.QuestnSkills;
import com.mradhit.questnskills.utils.PacketChannel;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.nio.charset.StandardCharsets;

public class EventManager implements Listener {
    public EventManager() {
        QuestnSkills.plugin.getServer().getPluginManager().registerEvents(this, QuestnSkills.plugin);
    }

    @EventHandler
    private void OnPlayerJoin(PlayerJoinEvent e){
        e.getPlayer().setGameMode(GameMode.CREATIVE);
        Bukkit.getScheduler().runTaskLater(QuestnSkills.plugin, () -> {
            System.out.println("Sending packet");
            e.getPlayer().sendPluginMessage(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE, PacketManager.buildMessage(e.getPlayer().getAddress().getHostName()));
        }, 20L);
    }
}
