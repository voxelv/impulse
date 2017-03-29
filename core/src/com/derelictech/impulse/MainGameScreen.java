package com.derelictech.impulse;

import com.artemis.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.derelictech.impulse.ecs.ConsolePrintSystem;
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

    public static World world;

    private Integer num = -1;

    private VisTextButton back_btn;
    private VisValidatableTextField input_text;
    private VisLabel output_text;

    public MainGameScreen(Impulse g) {
        super(g);
    }

    @Override
    public void show() {
        super.show();

        WorldConfiguration config = new WorldConfigurationBuilder()
            .with(new ConsolePrintSystem())
            .build();
        world = new World(config);
        ConsolePrintSystem.create("TEST");
        ConsolePrintSystem.create("OHAI");
        ConsolePrintSystem.create("WRLD");

        back_btn = new VisTextButton("BACK");
        input_text = new VisValidatableTextField(Validators.INTEGERS);
        output_text = new VisLabel("");

        root.add(new VisLabel("HELLO GAME SCENE"));

        root.row();
        root.add(back_btn);
        root.row();
        root.add(input_text).width(400);
        root.row();
        root.add(output_text);
        root.row();
        VisTextButton module_btn= new VisTextButton("NEW MODULE");
        root.add(module_btn);

        ////////////////////// Event Handling //////////////////////
        back_btn.addListener(new ClickListener(Input.Buttons.LEFT) {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setImpulseScreen("menu");
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
        world.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        world.setDelta(delta);
        world.process();
    }
}
