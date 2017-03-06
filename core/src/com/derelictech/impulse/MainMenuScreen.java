package com.derelictech.impulse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    MainMenuScreen.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: Main Menu Screen
 */
public class MainMenuScreen extends ImpulseScreenAdapter {

    VisTable blank;
    VisTable menu_area;

    public MainMenuScreen(Game g) {
        super(g, "scene/main_menu.scene");
    }

    @Override
    public void show() {
        super.show();
        root.left();

        blank = new VisTable();
        root.add(blank).expand();

        menu_area = new VisTable();
        root.add(menu_area).top();
        root.add(blank).width(100);

        menu_area.add(blank).height(400);
        menu_area.row();
        VisTextButton play_btn = new VisTextButton("PLAY");
        play_btn.setFocusBorderEnabled(true);
        menu_area.add(play_btn).width(300).pad(5);

        menu_area.row();
        VisTextButton info_btn = new VisTextButton("INFO");
        menu_area.add(info_btn).fillX().pad(5);
        menu_area.row();
        final VisTextButton quit_btn = new VisTextButton("QUIT");
        menu_area.add(quit_btn).fillX().pad(5);

        play_btn.addListener(new ClickListener(Input.Buttons.LEFT){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                MainMenuScreen.game.setScreen(new MainGameScreen(MainMenuScreen.game));
            }
        });



        quit_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });


//        stage.setDebugAll(true);
//        root.setDebug(true);
//        menu_area.debug();
    }
}
