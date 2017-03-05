package com.derelictech.impulse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.kotcrab.vis.ui.VisUI;

import java.util.HashMap;

public class Impulse extends Game {

    HashMap<String, ImpulseScreenAdapter> screen_dict;

    public void setScreen(String screen_name) {
        if(screen_dict.containsKey(screen_name)) {
            Gdx.app.log("IMPULSE GAME", "screen is in dictionary");
            super.setScreen(screen_dict.get(screen_name));
        }
    }
	
	@Override
	public void create () {
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
