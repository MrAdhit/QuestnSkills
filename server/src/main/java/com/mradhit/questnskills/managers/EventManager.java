package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitTask;

public class EventManager implements Listener {
    public EventManager() {
        QuestnSkills.plugin.getServer().getPluginManager().registerEvents(this, QuestnSkills.plugin);
    }

    @EventHandler
    private void OnPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setGameMode(GameMode.CREATIVE);
        e.getPlayer().setOp(true);
        PlayerDataManager playerData = new PlayerDataManager(e.getPlayer());

        BukkitTask schedule = Bukkit.getScheduler().runTaskTimerAsynchronously(QuestnSkills.plugin, () -> {
            PacketManager.sync(e.getPlayer());
        }, 1L, 1L);

        QuestnSkills.playerScheduler.put(e.getPlayer(), schedule);
    }

    @EventHandler
    private void OnPlayerQuit(PlayerQuitEvent e) {
        QuestnSkills.playerScheduler.get(e.getPlayer()).cancel();
    }

    @EventHandler
    private void OnEntityDeath(EntityDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        if(killer != null) {
            PlayerDataManager playerData = new PlayerDataManager(killer);

            playerData.KILL.set(playerData.KILL.get() + 1);
        }
    }
}
