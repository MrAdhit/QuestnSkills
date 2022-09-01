package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import org.bukkit.entity.Player;

public class CommandManager {
    public CommandManager() {
        QuestnSkills.plugin.getCommand("getkill").setExecutor((sender, command, label, args) -> {
            PlayerSaveManager playerData = new PlayerSaveManager((Player) sender);

            int kill = playerData.KILL.get();

            sender.sendMessage(String.valueOf(kill));

            return false;
        });
        QuestnSkills.plugin.getCommand("setkill").setExecutor((sender, command, label, args) -> {
            PlayerSaveManager playerData = new PlayerSaveManager((Player) sender);

            playerData.KILL.set(Integer.valueOf(args[0]));
            return false;
        });
        QuestnSkills.plugin.getCommand("setmana").setExecutor((sender, command, label, args) -> {
            PlayerSaveManager playerData = new PlayerSaveManager((Player) sender);

            playerData.MANA.set(Integer.valueOf(args[0]));
            return false;
        });
    }
}
