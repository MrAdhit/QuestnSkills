package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CommandManager {
    public CommandManager() {
        QuestnSkills.plugin.getCommand("getkill").setExecutor((sender, command, label, args) -> {
            PlayerDataManager playerData = new PlayerDataManager((Player) sender);

            int kill = playerData.KILL.get();

            sender.sendMessage(String.valueOf(kill));

            return false;
        });
        QuestnSkills.plugin.getCommand("setkill").setExecutor((sender, command, label, args) -> {
            PlayerDataManager playerData = new PlayerDataManager((Player) sender);

            playerData.KILL.set(Integer.valueOf(args[0]));
            return false;
        });
        QuestnSkills.plugin.getCommand("setmana").setExecutor((sender, command, label, args) -> {
            PlayerDataManager playerData = new PlayerDataManager((Player) sender);

            if(args[0].equalsIgnoreCase("animate")) {
                final int[] i = {0};
                Bukkit.getScheduler().scheduleSyncRepeatingTask(QuestnSkills.plugin, () -> {
                    i[0]++;
                    if(i[0] >= 200) {
                        Bukkit.getScheduler().cancelTasks(QuestnSkills.plugin);
                    }

                    int val = i[0];

                    if(i[0] >= 100) {
                        val = 100 - Math.abs(100 - i[0]);
                    }

                    System.out.println(val);
                    playerData.MANA.set(val);
                }, 1L, 1L);
                return true;
            }

            playerData.MANA.set(Integer.valueOf(args[0]));
            return false;
        });
    }
}
