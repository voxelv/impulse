package com.derelictech.impulse;

import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.derelictech.impulse.util.StringUtils;
import com.kotcrab.vis.ui.FocusManager;
import com.kotcrab.vis.ui.util.Validators;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisTextField;
import com.kotcrab.vis.ui.widget.VisValidatableTextField;

/**
 * Project: impulse
 * Package: com.derelictech.impulse
 * File:    MainGameScreen.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: Main Game Screen
 */
public class MainGameScreen extends ImpulseScreenAdapter {

    Integer num = -1;

    private final VisTextButton back_btn;
    private final VisValidatableTextField input_text;
    private final VisLabel output_text;

    public MainGameScreen(Game g) {
        super(g, "scene/main_game.scene");

        back_btn = new VisTextButton("BACK");
        input_text = new VisValidatableTextField(Validators.INTEGERS);
        output_text = new VisLabel("");
    }

    @Override
    public void show() {
        super.show();
        root.add(new VisLabel("HELLO GAME SCENE"));

        root.row();
        root.add(back_btn);
        root.row();
        root.add(input_text).width(400);
        root.row();
        root.add(output_text);

        ////////////////////// Event Handling //////////////////////
        back_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MainMenuScreen(game));
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
                            num = Integer.parseInt(text);
                            output_text.setText("I can haz " + num + CONST.XI + "?");
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
    }
}
