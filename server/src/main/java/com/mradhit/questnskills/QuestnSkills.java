package com.mradhit.questnskills;

import com.mradhit.questnskills.manager.EventManager;
import com.mradhit.questnskills.manager.PacketManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuestnSkills extends JavaPlugin {
    public final static String PLUGIN_ID = "questnskills";
    public static QuestnSkills plugin;

    @Override
    public void onEnable() {
        plugin = this;

        new EventManager();
        new PacketManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
