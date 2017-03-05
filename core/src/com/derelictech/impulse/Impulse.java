package com.derelictech.impulse;

import com.artemis.Archetype;
import com.artemis.World;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.*;
import com.kotcrab.vis.runtime.font.FreeTypeFontProvider;
import com.kotcrab.vis.runtime.scene.Scene;
import com.kotcrab.vis.runtime.scene.VisAssetManager;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisImage;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisWindow;

public class Impulse extends ApplicationAdapter {

    ImpulseAssetManager manager;
    Scene scene;

    Stage stage;
    Table root;
	
	@Override
	public void create () {
        manager = new ImpulseAssetManager();
        manager.enableFreeType();

        scene = manager.loadSceneNow("scene/main_game.scene");
        VisUI.load();

        stage = new Stage();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        scene.render();
	}
	
	@Override
	public void dispose () {
        VisUI.dispose();
		manager.dispose();
	}

    @Override
    public void resize(int width, int height) {
        manager.update();
    }
}
