package com.mradhit.questnskills;

import com.mradhit.questnskills.managers.CommandManager;
import com.mradhit.questnskills.managers.EventManager;
import com.mradhit.questnskills.managers.PacketManager;
import me.dpohvar.powernbt.PowerNBT;
import me.dpohvar.powernbt.api.NBTManager;
import net.Indyuce.mmocore.MMOCore;
import net.Indyuce.mmocore.api.MMOCoreAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public final class QuestnSkills extends JavaPlugin {
    public final static String PLUGIN_ID = "questnskills";
    public final static NBTManager nbtManager = PowerNBT.getApi();

    public static QuestnSkills plugin;
    public static HashMap<Player, BukkitTask> playerScheduler = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;

        new EventManager();
        new PacketManager();
        new CommandManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
