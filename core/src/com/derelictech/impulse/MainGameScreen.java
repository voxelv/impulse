package com.derelictech.impulse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTextButton;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    MainGameScreen.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description:
 */
public class MainGameScreen extends ImpulseScreenAdapter {

    public MainGameScreen(Game g) {
        super(g, "scene/main_game.scene");
    }

    @Override
    public void show() {
        super.show();
        root.add(new VisLabel("HELLO GAME SCENE"));

        root.row();

        VisTextButton back_btn = new VisTextButton("BACK");
        root.add(back_btn);

        back_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MainMenuScreen(game));
            }
        });
    }
}
