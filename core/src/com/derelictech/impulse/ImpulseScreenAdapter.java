package com.derelictech.impulse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.kotcrab.vis.ui.widget.VisTable;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    ImpulseScreenAdapter.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: Abstract Screen
 */
class ImpulseScreenAdapter extends ScreenAdapter {
    static Game game;

    Stage stage;
    VisTable root;

    ImpulseScreenAdapter(Game g) {
        game = g;
    }

    @Override
    public void show() {
        /* Setup stage */
        stage = new Stage(new FillViewport(CONST.INIT_SCREEN_W, CONST.INIT_SCREEN_H));

        /* Setup root table */
        root = new VisTable();
        stage.addActor(root);
        root.setFillParent(true);

        /* Reset the input processor each time this screen is shown */
        Gdx.input.setInputProcessor(stage);

        stage.setDebugAll(Impulse.do_debug);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void hide() {
        stage.dispose();
    }
}
