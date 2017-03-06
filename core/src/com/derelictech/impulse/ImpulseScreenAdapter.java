package com.derelictech.impulse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.kotcrab.vis.runtime.scene.Scene;
import com.kotcrab.vis.ui.widget.VisTable;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    ImpulseScreenAdapter.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: Abstract Screen
 */
abstract class ImpulseScreenAdapter extends ScreenAdapter {
    static Game game;

    ImpulseAssetManager manager;
    Scene scene;

    Stage stage;
    VisTable root;

    ImpulseScreenAdapter(Game g, String scene_str) {
        game = g;

        /* Setup asset manager */
        manager = new ImpulseAssetManager();
        manager.enableFreeType();

        /* Setup setup scene */
        scene = manager.loadSceneNow(scene_str);

        /* Setup stage */
        stage = new Stage(new FitViewport(CONST.INIT_SCREEN_W, CONST.INIT_SCREEN_H));

        /* Setup root table */
        root = new VisTable();
        stage.addActor(root);
        root.setFillParent(true);
    }

    @Override
    public void show() {
        /* Reset the input processor each time this screen is shown */
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        /* Render and tick the VisUI ECS first, then the Scene2D stage next */
        scene.render();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        manager.update();
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose () {
        manager.dispose();
        stage.dispose();
    }
}
