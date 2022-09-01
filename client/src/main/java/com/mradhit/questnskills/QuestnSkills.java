package com.mradhit.questnskills;

import com.mradhit.questnskills.managers.EventManager;
import com.mradhit.questnskills.managers.HudManager;
import com.mradhit.questnskills.managers.KeybindManager;
import com.mradhit.questnskills.managers.NetworkManager;
import net.fabricmc.api.ModInitializer;
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
        new EventManager();
        new KeybindManager();
        new HudManager();
    }
}
