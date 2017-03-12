package com.derelictech.impulse;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.derelictech.impulse.game.ModuleRecipes;
import com.kotcrab.vis.ui.VisUI;

import java.util.HashMap;

import static com.badlogic.gdx.Application.LOG_DEBUG;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    Impulse.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: Impulse Game
 */

public class Impulse extends Game {
    /**
     * Impulse has two types.
     */
    public enum Type {
        XI_Ξ,   /* Integer Impulse (XI, Ξ) */
        PHI_Φ   /* Fractional Impulse (FI or PHI, Φ) */
    }
    private HashMap<String, ImpulseScreenAdapter> screen_dict;

    private void setScreen(String screen_name) {
        if(screen_dict.containsKey(screen_name)) {
            Gdx.app.debug("IMPULSE GAME", "screen is in dictionary");
            super.setScreen(screen_dict.get(screen_name));
        }
    }

	@Override
	public void create () {
        Gdx.app.setLogLevel(LOG_DEBUG);

        ModuleRecipes.load();

        VisUI.load(VisUI.SkinScale.X2);

        screen_dict = new HashMap<String, ImpulseScreenAdapter>();

        screen_dict.put("menu", new MainMenuScreen(this));
        screen_dict.put("game", new MainGameScreen(this));

        setScreen("menu");
	}

    @Override
    public void dispose() {
        super.dispose();
        VisUI.dispose();
    }
}
