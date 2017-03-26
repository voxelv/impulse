package com.derelictech.impulse;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    Impulse.java
 * Author:  voxelv
 * Creation Date: 2016-12-01
 * Description:
 */

public class Impulse extends Game {
	private Stage stage;
	private Skin skin;
    private TextureAtlas atlas;
    private final String xi = "\u039e";
    private final String phi = "\u03a6";

	@Override
	public void create () {
        this.setScreen(new OpeningScreen(this));
	}
	
	@Override
	public void dispose () {

	}
}
