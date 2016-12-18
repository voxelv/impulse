package com.derelictech.impulse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.badlogic.gdx.Gdx.input;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    TableScreen.java
 * Author:  voxelv
 * Creation Date: 2016-12-18
 * Description: A screen with a table called root that's set up to be rendered already
 */
public class TableScreen extends ScreenAdapter {
    private Game game;
    private Skin skin;
    private Stage stage;
    private Table root;
    private Camera camera;

    public TableScreen(Game g) {
        game = g;

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        stage = new Stage(new FitViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT, camera));
        input.setInputProcessor(stage);

        System.out.println("SETUP");


        root = new Table(skin);
        root.setFillParent(true);
        root.debugAll();
        stage.addActor(root);
    }

    @Override
    public void render(float delta) {
//        Gdx.gl.glClearColor(0.16f, 0.16f, 0.16f, 1);
        Gdx.gl.glClearColor(0.75f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
