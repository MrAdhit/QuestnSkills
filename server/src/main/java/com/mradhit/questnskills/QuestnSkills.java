package com.mradhit.questnskills;

import com.mradhit.questnskills.managers.CommandManager;
import com.mradhit.questnskills.managers.EventManager;
import com.mradhit.questnskills.managers.PacketManager;
import me.dpohvar.powernbt.PowerNBT;
import me.dpohvar.powernbt.api.NBTManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuestnSkills extends JavaPlugin {
    public final static String PLUGIN_ID = "questnskills";
    public final static NBTManager nbtManager = PowerNBT.getApi();

    public static QuestnSkills plugin;

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
