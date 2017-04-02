package com.derelictech.impulse;

import com.artemis.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.derelictech.impulse.ecs.system.ClearAllEntitiesSystem;
import com.derelictech.impulse.ecs.system.ConsolePrintSystem;
import com.derelictech.impulse.ecs.system.ScreenManager;
import com.derelictech.impulse.game.Module;
import com.kotcrab.vis.ui.FocusManager;
import com.kotcrab.vis.ui.util.Validators;
import com.kotcrab.vis.ui.widget.*;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    MainGameScreen.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: Main Game Screen
 */
public class MainGameScreen extends ImpulseScreenAdapter {

    private Table blank;
    private VisTextButton back_btn;
    private VisValidatableTextField input_text;
    private VisLabel output_text;

    public MainGameScreen(Game g) {
        super(g);
    }

    @Override
    public void show() {
        super.show();
        ConsolePrintSystem cps = Impulse.world().getSystem(ConsolePrintSystem.class);
        ClearAllEntitiesSystem.reset();

        cps.create("TEST");
        cps.create("OHAI");
        cps.create("WRLD");

        back_btn = new VisTextButton("BACK");
        input_text = new VisValidatableTextField(Validators.INTEGERS);
        output_text = new VisLabel("");

        root.add(new VisLabel("HELLO GAME SCENE"));

        root.row();
        root.add(output_text).left();
        root.row();
        root.add(input_text).width(400).pad(1);
        root.row();
        VisTextButton module_btn= new VisTextButton("NEW MODULE");
        root.add(module_btn).fillX().pad(1);
        root.row();
        root.add(back_btn).fillX().pad(1);

        ////////////////////// Event Handling //////////////////////
        back_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ScreenManager.setScreen("menu");
            }
        });

        input_text.addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                switch (keycode) {
                    case Input.Keys.ENTER:
                        String text = ((VisValidatableTextField) (event.getTarget())).getText();
                        boolean textbox_valid = ((VisValidatableTextField) event.getTarget()).isInputValid();

                        if(textbox_valid) {
                            output_text.setText("I can haz " + Integer.parseInt(text) + CONST.XI + "?");
                            input_text.setText("");
                        }
                    case Input.Keys.ESCAPE:
                        FocusManager.resetFocus(stage);
                        break;
                    default:
                        break;
                }
                return true;
            }
        }); /* END input_text.addListener() */

        module_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Module module = new Module();
            }
        });
    }

    @Override
    public void hide() {
        super.hide();
        ClearAllEntitiesSystem.deleteAll();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
