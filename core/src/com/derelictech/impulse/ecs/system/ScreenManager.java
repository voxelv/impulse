package com.derelictech.impulse.ecs.system;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.derelictech.impulse.Impulse;
import com.derelictech.impulse.MainGameScreen;
import com.derelictech.impulse.MainMenuScreen;
import com.derelictech.impulse.util.CommandLog;

import java.util.HashMap;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.ecs.system
 * Author:  voxelv
 * Creation Date: 2017-04-01
 * Description: Manages screens
 */
public class ScreenManager extends BaseSystem {
    private static HashMap<String, Screen> screen_dict;
    private static String current_screen;

    private boolean doProcessing = false;
    public void setProcessing(boolean b) {
        this.doProcessing = b;
    }

    @Override
    protected void initialize() {
        super.initialize();
        screen_dict = new HashMap<String, Screen>();

        screen_dict.put("menu", new MainMenuScreen(Impulse.game()));
        screen_dict.put("game", new MainGameScreen(Impulse.game()));
        setScreen("menu");
    }

    @Override
    protected void processSystem() {

    }

    @Override
    protected boolean checkProcessing() {
        return doProcessing;
    }

    public static void setScreen(String screen_id) {
        if(screen_dict.containsKey(screen_id)) {
            CommandLog.push("SCRN_MNGR", "Setting Screen to: " + screen_id);
            Impulse.game().setScreen(screen_dict.get(screen_id));
            current_screen = screen_id;
        }
    }

    public static Screen getCurrentScreen() {
        return screen_dict.get(current_screen);
    }

    @Override
    public void dispose() {
        for(Screen s : screen_dict.values()) {
            s.dispose();
        }
    }
}
