package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.route.Route;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.K;

import java.io.File;
import java.io.IOException;

public class PlayerSaveManager {
    public YamlDocument SAVE;
    public Kill KILL = new Kill();
    public Mana MANA = new Mana();

    private Player player;

    public PlayerSaveManager(Player player) {
        this.player = player;

        try {
            SAVE = YamlDocument.create(new File(QuestnSkills.plugin.getDataFolder().getCanonicalPath() + "/playerdata", player.getName() + ".yml"), QuestnSkills.plugin.getResource(player.getName() + ".yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Kill {
        public void set(int count) {
            SAVE.set(Route.fromString("kills"), count);

            save();
        }

        public int get() {
            return (int) (SAVE.get(Route.fromString("kills")) == null ? 0 : SAVE.get(Route.fromString("kills")));
        }
    }

    public class Mana {
        public void set(int count) {
            SAVE.set(Route.fromString("mana"), count);

            save();
        }

        public int get() {
            return (int) (SAVE.get(Route.fromString("mana")) == null ? 10 : SAVE.get(Route.fromString("mana")));
        }
    }

    public void reload() {
        try {
            this.SAVE.reload();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            this.SAVE.save();
            PacketManager.sync(this.player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
