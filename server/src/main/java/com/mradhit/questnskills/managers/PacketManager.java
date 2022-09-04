package com.mradhit.questnskills.managers;

import com.mradhit.questnskills.QuestnSkills;
import com.mradhit.questnskills.utils.PacketChannel;
import io.lumine.mythic.lib.MythicLib;
import io.lumine.mythic.lib.api.player.EquipmentSlot;
import io.lumine.mythic.lib.skill.trigger.TriggerMetadata;
import net.Indyuce.mmocore.api.MMOCoreAPI;
import net.Indyuce.mmocore.skill.cast.SkillCastingHandler;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.manager.TierManager;
import net.Indyuce.mmoitems.manager.TypeManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.json.JSONObject;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PacketManager {
    public PacketManager() {
        RegisterOutgoingPacket();
        IncomingPacket();
    }

    private void IncomingPacket() {
        Bukkit.getMessenger().registerIncomingPluginChannel(QuestnSkills.plugin, PacketChannel.EQUIPMENT_1, (channel, player, message) -> {
            ItemStack item = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "FLAMOS_SCYTHE_SHINY");
            ItemStack item1 = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("ARMOR"), "ZEPHYR_HEAD");
            ItemStack item2 = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("ARMOR"), "FLAMOS_CHESTPLATE");
            ItemStack item3 = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("ARMOR"), "FLAMOS_LEGGINGS");
            ItemStack item4 = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("ARMOR"), "FLAMOS_BOOTS");

            player.getInventory().addItem(item, item1, item2, item3, item4);


        });
        Bukkit.getMessenger().registerIncomingPluginChannel(QuestnSkills.plugin, PacketChannel.ABILITIES, (channel, player, message) -> {
            PlayerDataManager pData = new PlayerDataManager(player);

            switch(message[3]) {
                case 0:
                    pData.MMOCoreData.setLevel(2);
                    pData.MMOCoreData.setBoundSkill(1, pData.MMOCoreData.getProfess().getSkill("FLAME_SLASH"));
                    break;
                case 1:
                    pData.MMOCoreData.setLevel(3);
                    pData.MMOCoreData.setBoundSkill(2, pData.MMOCoreData.getProfess().getSkill("INFERNO_WHEEL"));
                    break;
                case 2:
                    pData.MMOCoreData.setLevel(5);
                    pData.MMOCoreData.setBoundSkill(3, pData.MMOCoreData.getProfess().getSkill("INFERNO_ORBS"));
                    break;
                case 3:
                    pData.MMOCoreData.setLevel(6);
                    pData.MMOCoreData.setBoundSkill(4, pData.MMOCoreData.getProfess().getSkill("BLAZING_LEAP"));
                    break;
                case 4:
                    pData.MMOCoreData.setLevel(7);
                    pData.MMOCoreData.setBoundSkill(4, pData.MMOCoreData.getProfess().getSkill("HELLFIRE_SCYTHE"));
                    break;
            }
        });
        Bukkit.getMessenger().registerIncomingPluginChannel(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE, (channel, player, message) -> {
            sync(player);
        });
    }

    private void RegisterOutgoingPacket() {
        QuestnSkills.plugin.getServer().getMessenger().registerOutgoingPluginChannel(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE);
    }

    public static void sync(Player player) {
        JSONObject data = new JSONObject();
        PlayerDataManager playerData = new PlayerDataManager(player);

        data.put("kills", playerData.KILL.get());
        data.put("mana", playerData.MANA.get());
        data.put("mana-max", playerData.MANA.max());

        player.getPlayer().sendPluginMessage(QuestnSkills.plugin, PacketChannel.SYNCHRONIZE, PacketManager.buildMessage(data.toString()));
    }

    public static byte[] buildMessage(String input) {
        ByteBuffer buf = ByteBuffer.allocate(input.length() + 1);
        buf.put((byte) input.length());
        buf.put(input.getBytes(StandardCharsets.UTF_8));
        return buf.array();
    }
}
