package com.derelictech.impulse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.derelictech.impulse.ecs.system.ScreenManager;
import com.derelictech.impulse.util.CommandLog;
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

    Table blank;
    VisTable menu_area;

    int MENU_PAD = 1;
    int MENU_WIDTH = 300;

    public MainMenuScreen(Game g) {
        super(g);
    }

    @Override
    public void show() {
        super.show();

        root.left();

        blank = new Table();
        root.add(blank).expand();

        menu_area = new VisTable();
        root.add(menu_area);

        menu_area.row();
        VisTextButton play_btn = new VisTextButton("PLAY");
        play_btn.setFocusBorderEnabled(true);
        menu_area.add(play_btn).width(MENU_WIDTH).pad(MENU_PAD);

        menu_area.row();
        VisTextButton debug_btn = new VisTextButton("DEBUG");
        play_btn.setFocusBorderEnabled(true);
        menu_area.add(debug_btn).fillX().pad(MENU_PAD);

        menu_area.row();
        VisTextButton info_btn = new VisTextButton("INFO");
        menu_area.add(info_btn).fillX().pad(MENU_PAD);

        menu_area.row();
        VisTextButton quit_btn = new VisTextButton("QUIT");
        menu_area.add(quit_btn).fillX().pad(MENU_PAD);

        stage.addActor(new TestScrollPaneWindow());


        /////////////////////////// Listeners //////////////////////////////

        play_btn.addListener(new ClickListener(Input.Buttons.LEFT){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ScreenManager.setScreen("game");
            }
        });

        debug_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Impulse.do_debug = !Impulse.do_debug;
                stage.setDebugAll(Impulse.do_debug);
            }
        });

        info_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                CommandLog.push("MAIN_MENU", "Welcome to Impulse!");
            }
        });

        quit_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
    }
}
