package com.derelictech.impulse;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.kotcrab.vis.runtime.scene.Scene;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;

public class Impulse extends ApplicationAdapter {

    ImpulseAssetManager manager;
    Scene scene;

    Stage stage;
    VisTable root;
	
	@Override
	public void create () {
        manager = new ImpulseAssetManager();
        manager.enableFreeType();

        scene = manager.loadSceneNow("scene/main_game.scene");
        VisUI.load(VisUI.SkinScale.X2);

        stage = new Stage(new FitViewport(CONST.INIT_SCREEN_W, CONST.INIT_SCREEN_H));
        root = new VisTable();
        stage.addActor(root);
        root.setFillParent(true);
        root.left();

        VisTextButton play_btn = new VisTextButton("PLAY!");
        root.add(play_btn).expandX();
        root.addSeparator(true);
        VisTextButton hello = new VisTextButton("HELLO WORLD");
        root.add(hello).expandX();

        root.setDebug(true);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        scene.render();
        stage.draw();
	}

    @Override
    public void resize(int width, int height) {
        manager.update();
        stage.getViewport().update(width, height);
    }
	
	@Override
	public void dispose () {
        VisUI.dispose();
		manager.dispose();
        stage.dispose();
	}
}
