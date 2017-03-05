package com.derelictech.impulse;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.*;
import com.kotcrab.vis.ui.VisUI;

public class Impulse extends ApplicationAdapter {
	Stage stage;
	Image img;
    Viewport vp;
	
	@Override
	public void create () {
        vp = new FitViewport(10, 10);
        stage = new Stage(vp);
		img = new Image(new Texture(Gdx.files.internal("impulse_wip_fancy.png")));
        img.setSize(10, 10);
		VisUI.load();
		stage.addActor(img);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
		VisUI.dispose();
	}

    @Override
    public void resize(int width, int height) {
        vp.update(width, height);
    }
}
