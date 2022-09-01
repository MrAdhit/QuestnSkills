package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventManager implements Listener {
    public EventManager() {
        QuestnSkills.plugin.getServer().getPluginManager().registerEvents(this, QuestnSkills.plugin);
    }

    @EventHandler
    private void OnPlayerJoin(PlayerJoinEvent e){
        e.getPlayer().setGameMode(GameMode.CREATIVE);
        e.getPlayer().setOp(true);
        PlayerSaveManager playerData = new PlayerSaveManager(e.getPlayer());
    }
}
