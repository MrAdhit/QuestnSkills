package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import me.dpohvar.powernbt.api.NBTCompound;
import org.bukkit.entity.Player;

public class PlayerDataManager {
    public NBTCompound playerData;

    private Player player;

    public PlayerDataManager(Player player) {
        this.player = player;

        playerData = QuestnSkills.nbtManager.read(this.player);
    }

    public int getKills() {
        int kills = playerData.getInt("kills");

        return kills;
    }

    public void setKills(Integer count) {
        this.playerData.put("kills", count);

        QuestnSkills.nbtManager.write(this.player, this.playerData);
    }
}
