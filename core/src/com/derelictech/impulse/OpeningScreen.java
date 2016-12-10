package com.derelictech.impulse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.*;

import static com.badlogic.gdx.Gdx.input;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    OpeningScreen.java
 * Author:  voxelv
 * Creation Date: 2016-12-01
 * Description:
 */
public class OpeningScreen implements Screen {
    private Game game;
    private Skin skin;
    private Stage stage;
    private Table root;
    private TextButton button1, button2, button3, button4, button5;
    private Table gameArea;
    private Table uiArea;
    private Camera camera;

    public OpeningScreen(Game g) {
        game = g;

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		stage = new Stage(new FitViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT, camera));
        input.setInputProcessor(stage);


        root = new Table(skin);
        root.setFillParent(true);
        root.setDebug(true);
        root.setColor(0.16f, 0.16f, 0.16f, 1);
        stage.addActor(root);

        gameArea = new Table();
        gameArea.setWidth(300);
        gameArea.setHeight(300);
        root.add(gameArea).expand();

        uiArea = new Table();
        root.add(uiArea).expandY().top();

        button1 = new TextButton("Button 1", skin);
        uiArea.add(button1).size(115, 30);
        uiArea.row();
        button2 = new TextButton("Button 2", skin);
        uiArea.add(button2).size(115, 30);
        uiArea.row();
        button3 = new TextButton("Button 3", skin);
        uiArea.add(button3).size(115, 30);
        uiArea.row();
        button4 = new TextButton("Button 4", skin);
        uiArea.add(button4).size(115, 30);
        uiArea.row();
        button5 = new TextButton("Button 5", skin);
        uiArea.add(button5).size(115, 30);



        root.debugAll();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        Gdx.gl.glClearColor(0.16f, 0.16f, 0.16f, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
