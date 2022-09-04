package com.mradhit.questnskills.guis;

import com.mradhit.questnskills.guis.painters.SpritePainter;
import com.mradhit.questnskills.guis.widgets.WSpriteButton;
import com.mradhit.questnskills.utils.PacketChannel;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class AbilitiesGui extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final int wPanel = 252;
    private final int hPanel = 140;

    public AbilitiesGui() {
        setRootPanel(root);
        root.setSize(wPanel, hPanel);

        WSpriteButton button1 = new WSpriteButton(new Identifier("minecraft:textures/flamos_texture/icon_flame_slash.png"));
        button1.setTooltips(new String[]{
                "Flame Slash",
                "§4Flamos performs a slash attack",
                "",
                "§9Costs 1 Mana"
        });
        button1.setOnClick(() -> {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(0);

            ClientPlayNetworking.send(PacketChannel.ABILITIES, buf);
        });
        root.add(button1, 41, 61, 30, 30);

        WSpriteButton button2 = new WSpriteButton(new Identifier("minecraft:textures/flamos_texture/icon_inferno_wheel.png"));
        button2.setTooltips(new String[]{
                "Inferno Wheel",
                "§4Flamos spins his scythe and burns entities around him",
                "",
                "§9Costs 2 Mana"
        });
        button2.setOnClick(() -> {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(1);

            ClientPlayNetworking.send(PacketChannel.ABILITIES, buf);
        });
        root.add(button2, 76, 61, 30, 30);

        WSpriteButton button3 = new WSpriteButton(new Identifier("minecraft:textures/flamos_texture/icon_inferno_orbs.png"));
        button3.setTooltips(new String[]{
                "Inferno Orbs & Fire Immune",
                "§4Flamos creates rotating fire orbs that",
                "§4burn entities when hit and",
                "§4Flamos is immune to fire and lava damage",
                "",
                "§9Costs 13 Mana"
        });
        button3.setOnClick(() -> {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(2);

            ClientPlayNetworking.send(PacketChannel.ABILITIES, buf);
        });
        root.add(button3, 111, 61, 30, 30);

        WSpriteButton button4 = new WSpriteButton(new Identifier("minecraft:textures/flamos_texture/icon_blazing_leap.png"));
        button4.setTooltips(new String[]{
                "Blazing Leap",
                "§4Flamos leaps upwards",
                "",
                "§9Costs 3 Mana"
        });
        button4.setOnClick(() -> {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(3);

            ClientPlayNetworking.send(PacketChannel.ABILITIES, buf);
        });
        root.add(button4, 146, 61, 30, 30);

        WSpriteButton button5 = new WSpriteButton(new Identifier("minecraft:textures/flamos_texture/icon_hellfire_slash.png"));
        button5.setTooltips(new String[]{
                "Hellfire Scythe",
                "§4For 10 seconds Flamos’ speed and attack speed increase",
                "§4His basic attacks become bigger and stronger,",
                "§4burning entites on attack",
                "",
                "§9Costs 20 Mana"
        });
        button5.setOnClick(() -> {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(4);

            ClientPlayNetworking.send(PacketChannel.ABILITIES, buf);
        });
        root.add(button5, 181, 61, 30, 30);
    }

    @Override
    public void addPainters() {
        this.rootPanel.setBackgroundPainter(new SpritePainter(new Identifier("questnskills:textures/gui/abilities.png"), wPanel, hPanel, 0f, 0f, 0.984375f, 0.546875f));
    }
}
