package com.mradhit.questnskills.guis;

import com.mradhit.questnskills.guis.painters.SpritePainter;
import com.mradhit.questnskills.guis.widgets.WSpriteButton;
import com.mradhit.questnskills.QuestnSkills;
import com.mradhit.questnskills.managers.ScreenManager;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class MainMenuGui extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final int wPanel = 1920 / 5;
    private final int hPanel = 1080 / 5;

    public MainMenuGui() {
        setRootPanel(root);
        root.setSize(wPanel, hPanel);

        WSpriteButton button1 = new WSpriteButton(new Identifier("questnskills:textures/gui/buttons/button-p.png"));
        button1.setTooltips(new String[]{"Ke Equipments"});
        button1.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new ScreenManager(new EquipmentGui()));
        });
        root.add(button1, 364 / 5, 390 / 5, 194 / 5, 189 / 5);

        WSpriteButton button2 = new WSpriteButton(new Identifier("questnskills:textures/gui/buttons/button-p.png"));
        button2.setTooltips(new String[]{"Ke Abilities"});
        button2.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new ScreenManager(new AbilitiesGui()));
        });
        root.add(button2, 863 / 5, 390 / 5, 194 / 5, 189 / 5);

        WSpriteButton button3 = new WSpriteButton(new Identifier("questnskills:textures/gui/buttons/button-p.png"));
        button3.setTooltips(new String[]{"Ke Upgrades"});
        button3.setOnClick(() -> {

        });
        root.add(button3, 1331 / 5, 390 / 5, 194 / 5, 189 / 5);
    }

    @Override
    public void addPainters(){
        this.rootPanel.setBackgroundPainter(new SpritePainter(new Identifier(QuestnSkills.MOD_ID, "textures/gui/main_menu.png"), wPanel, hPanel));
    }
}
