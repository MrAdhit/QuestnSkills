package com.mradhit.skillnquest;

import com.mradhit.skillnquest.managers.KeybindManager;
import com.mradhit.skillnquest.managers.NetworkManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class QuestnSkills implements ModInitializer {
    public final static String MOD_ID = "questnskills";
    public final static String MOD_NAME = "Quest & Skills";
    public final static Logger LOGGER = LogManager.getLogger(MOD_NAME);

    public static HashMap<String, Object> syncedData = new HashMap<>();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing " + MOD_NAME);

        new NetworkManager();
        new KeybindManager();
    }
}
