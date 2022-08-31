package com.mradhit.skillnquest.guis;

import com.mradhit.skillnquest.guis.painters.SpritePainter;
import com.mradhit.skillnquest.guis.widgets.WSpriteButton;
import com.mradhit.skillnquest.utils.PacketChannel;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.util.Identifier;

public class EquipmentGui extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final int wPanel = 1920 / 5;
    private final int hPanel = 1080 / 5;

    public EquipmentGui() {
        setRootPanel(root);
        root.setSize(wPanel, hPanel);

        WSpriteButton button1 = new WSpriteButton(new Identifier("minecraft:textures/models/armor/flamos_helmet.png"));
        button1.setTooltips(new String[]{
                "Equipment 1",
                "Give a diamond helmet",
                " ",
                "§aDirt x64",
                "§aStone x64",
                "§aDiamond x64"
        });
        button1.setOnClick(() -> {
            ClientPlayNetworking.send(PacketChannel.EQUIPMENT_1, PacketByteBufs.empty());
        });
        root.add(button1, 364 / 5, 390 / 5, 194 / 5, 189 / 5);

        WSpriteButton button2 = new WSpriteButton(new Identifier("minecraft:textures/item/bow.png"));
        button2.setTooltips(new String[]{
                "Equipment 2",
                "Give a bow",
                " ",
                "§aDirt x64",
                "§aStone x64",
                "§aDiamond x64"
        });
        button2.setOnClick(() -> {

        });
        root.add(button2, 614 / 5, 390 / 5, 194 / 5, 189 / 5);
    }

    @Override
    public void addPainters(){
        this.rootPanel.setBackgroundPainter(new SpritePainter(new Identifier("questnskills:textures/gui/equipment_menu.png"), wPanel, hPanel));
    }
}
